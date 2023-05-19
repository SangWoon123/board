package org.tukorea.board.transactional.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.User;
import org.tukorea.board.persistence.UserRepository;
import org.tukorea.board.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Transactional
public class transactionalTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	private Logger logger=LoggerFactory.getLogger(transactionalTest.class);
	
	// 유저 생성
	@Test
	@Rollback
	public void createUser() {
		// 테스트 유저 설정
		User user=new User("testuser","testpassword","testnickname","test@email.com");
		// 유저 생성
		userService.createUser(user);
		
		User findUser=userService.findByUsername("testuser");
		
		assertNotNull(findUser);
		assertEquals("testnickname",findUser.getNickname());	
	}
	
	// 유저 중복아이디 발생 체크
	@Test
	@Rollback
	public void createUser_Duplicate() {
		// 테스트 유저 설정
		User user=new User("testuser","testpassword","testnickname","test@email.com");
		// 유저 생성
		userService.createUser(user);
		
		User checkUser=new User("testuser","testpassword","testnickname2","test@email.com");
		
//		// 중복된 아이디로 저장했을때 예외를 발생시키는지 체크
//		assertThrows(IllegalStateException.class, () -> userService.createUser(checkUser));
		
		User findUser=userRepository.findByUsername("testuser");
		logger.info("저장되어있는 아이디: "+findUser.getUsername());
	}

}
