package org.tukorea.board.domain;



import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Post {
		
	private int id;
    private String title;
    private String content;
    private String author;
    private LocalDate createdAt;
    
    public Post() {
    	
    }
    
	public Post(String title, String content, String author, LocalDate createdAt) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.content=content;
		this.author=author;
		this.createdAt=createdAt;
	}
	

	


}
