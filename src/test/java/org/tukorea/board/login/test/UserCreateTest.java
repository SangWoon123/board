package org.tukorea.board.login.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.User;
import org.tukorea.board.persistence.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserCreateTest {
	
	@Autowired
	private UserRepository userRepository;
	
	
	// 가입 (create) 테스
	// 유저 아이디, 비밀번호, 이메일, 닉네임 설정
	// 저장
	// 검증
	@Test
	@Transactional
	public void createUserTest() {
	    User user = new User("아이디", "비밀번호", "닉네임", "이메일");
	    userRepository.save(user);

	    User findUser = userRepository.findByUsername("아이디");

	    assertEquals(user.getUsername(), findUser.getUsername());
	}

	

}
