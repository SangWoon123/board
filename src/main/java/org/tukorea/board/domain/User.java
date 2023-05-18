package org.tukorea.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String username;
	private String password;
	private String nickname;
	private String email; // 추후 삭제
	
	public String getPassword() {
		return password;
	}
	
	public User(String username,String password,String nickname,String email) {
		this.username=username;
		this.password=password;
		this.nickname=nickname;
		this.email=email;
	}
	
	public User() {
		
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	
}
