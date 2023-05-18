package org.tukorea.board.login.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.User;
import org.tukorea.board.persistence.UserRepository;
import org.tukorea.board.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserAuthTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(UserAuthTest.class);
	
	// 유저 검증 (auth)
	// 유저 아이디, 비밀번호 입력
	// 검증
	@Before
	public void createUser() {
	    User user = new User("아이디", "비밀번호", "닉네임", "이메일");
	    userRepository.save(user);
	}
	
	@Test
	@Transactional
	public void authUser() throws Exception {
		if(userService.authenticateUser("아이", "비밀번호")) {
			logger.info("아이디가 검증이 완료되었습니다.");
		}else {
			assert false : "아이디가 잘못되었습니다.";
		}
		
	}

}
