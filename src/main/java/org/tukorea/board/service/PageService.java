package org.tukorea.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.board.domain.Page;
import org.tukorea.board.domain.Post;
import org.tukorea.board.persistence.BoardRepository;
import org.tukorea.board.persistence.PageRepository;

@Service
public class PageService {
	
	@Autowired
	private PageRepository postRepository;
	
	public Page<Post> getPostsByPage(int pageNumber,int pageSize){
		 int totalElements = postRepository.getTotalPostsCount();
	     int totalPages = (int) Math.ceil((double) totalElements / pageSize);
		
	     if(pageNumber<1) {
	    	 pageNumber=1;
	     }else if(pageNumber>totalPages) {
	    	 pageNumber=totalPages;
	     }
	     
	     int startIndex = (pageNumber - 1) * pageSize;
	        List<Post> posts = postRepository.getPostsByPage(startIndex, pageSize);

	        Page<Post> page = new Page<Post>();
	        page.setContent(posts);
	        page.setPageNumber(pageNumber);
	        page.setPageSize(pageSize);
	        page.setTotalElements(totalElements);
	        page.setTotalPages(totalPages);

	        return page;
	}

}
