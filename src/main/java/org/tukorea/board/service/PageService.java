package org.tukorea.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.board.domain.Post;
import org.tukorea.board.persistence.BoardRepository;

@Service
public class PageService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public int getTotalPostsCount() {
        return boardRepository.getTotalPostsCount();
    }

    public List<Post> getPostsByPage(int startIndex, int pageSize) {
        return boardRepository.getPostsByPage(startIndex, pageSize);
    }

}
