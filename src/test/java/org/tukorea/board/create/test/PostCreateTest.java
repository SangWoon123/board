package org.tukorea.board.create.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.Post;
import org.tukorea.board.persistence.BoardRepository;
import org.tukorea.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class PostCreateTest {
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private BoardRepository br;
	
	// Post 생성
	@Test
	@Transactional
	public void savePost() throws Exception {
		
		LocalDateTime current=LocalDateTime.now();
		Post post=new Post("안녕","내용","유저",current);
		bs.createPost(post);		
		
	}

}
