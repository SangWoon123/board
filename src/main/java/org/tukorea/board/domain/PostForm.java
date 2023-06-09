package org.tukorea.board.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
	
    private String title;
    private String content;
    private String author;
    private LocalDate createdAt;
    
    public PostForm() {
    	
    }
    
	public PostForm(String title, String content, String author, LocalDate createdAt) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.content=content;
		this.author=author;
		this.createdAt=createdAt;
	}
	

}
