package org.tukorea.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
	
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    
    public PostForm() {
    	
    }
    
	public PostForm(String title, String content, String author, LocalDateTime createdAt) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.content=content;
		this.author=author;
		this.createdAt=createdAt;
	}
}
