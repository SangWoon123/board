package org.tukorea.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.User;
import org.tukorea.board.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	// 인증
	@Transactional 
	public boolean authenticateUser(String username,String password) throws Exception {
		
		User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true; // 사용자 인증 성공
        }
		return false;
	}
	
	//가입
	@Transactional
	public void createUser(User user) {
		userValidator(user);
		userRepository.save(user);
	}
	
	// 검증
	public void userValidator(User user) {
		User findUser=userRepository.findByUsername(user.getUsername());
		if (findUser != null && !findUser.getUsername().isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
	    }
	}
	
	
	

}
