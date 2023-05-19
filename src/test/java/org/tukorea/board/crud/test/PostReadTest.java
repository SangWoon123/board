package org.tukorea.board.crud.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.Post;
import org.tukorea.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Transactional
public class PostReadTest {
	
	@Autowired
	BoardService bs;
	
	// create
	public Post savePost() throws Exception {
		LocalDateTime current=LocalDateTime.now();
		Post post=new Post("안녕","내용","유저",current);
		bs.createPost(post);
		
		return post;
	}
	
	// findBy
	@Transactional
	@Test
	public void findByPost() throws Exception{
		Post post=savePost();
		List<Post> findPost=bs.getAllPosts();
		assertEquals(post.getAuthor(),findPost.get(0).getAuthor());
	}
	
	
	

}
