package org.tukorea.board.domain;



import java.time.LocalDate;



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
	

	
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	
	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
	    this.title = title;
	}
	
	public String getContent() {
	    return content;
	}
	
	public void setContent(String content) {
	    this.content = content;
	}
	
	public String getAuthor() {
	    return author;
	}
	
	public void setAuthor(String author) {
	    this.author = author;
	}
	
	public LocalDate getCreatedAt() {
	    return createdAt;
	}
	
	public void setCreatedAt(LocalDate createdAt) {
	    this.createdAt = createdAt;
	}

}
