package org.tukorea.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		User existingUser=userRepository.findByUsername(user.getUsername());
		if (existingUser != null ) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
	    }
		
		User existingNickname=userRepository.findByNickname(user.getNickname());
		if (existingNickname != null ) {
			throw new DataIntegrityViolationException("이미 존재하는 닉네입니다.");
		}
	}
	
	// 유저 반환
	public User findByUsername(String user) {
		return userRepository.findByUsername(user);
	}
	
	
	
	

}
