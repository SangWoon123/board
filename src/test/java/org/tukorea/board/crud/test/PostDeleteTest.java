package org.tukorea.board.crud.test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.Post;
import org.tukorea.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class PostDeleteTest {
	
	@Autowired
	private BoardService bs;
	
	private Logger logger=LoggerFactory.getLogger(PostDeleteTest.class);
	
	@Before
	public void savePost() throws Exception {
		LocalDateTime current=LocalDateTime.now();
		Post post=new Post("안녕","내용","유저",current);
		bs.createPost(post);			
	}
	
	@Test
	@Transactional
	public void deletePost() throws Exception{
		List<Post> findPosts=bs.getAllPosts();
		bs.deletePost(findPosts.get(0).getId());		
	}

}
