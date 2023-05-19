package org.tukorea.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
	
	private int page;
	private int size;
	private int totalPost;
	private int totalPage;
	
	public Page() {
		
	}
	
	public Page(int page, int size, int totalPost) {
        this.page = page;
        this.size = size;
        this.totalPost = totalPost;
        this.totalPage = (int) Math.ceil((double) totalPost / size);
    }
	
	public int getOffset() {
        return (page - 1) * size;
    }
    
    public boolean hasNextPage() {
        return page < totalPage;
    }
    
    public boolean hasPreviousPage() {
        return page > 1;
    }
    
    public int getNextPage() {
        return hasNextPage() ? page + 1 : page;
    }
    
    public int getPreviousPage() {
        return hasPreviousPage() ? page - 1 : page;
    }
	
	
	

}
