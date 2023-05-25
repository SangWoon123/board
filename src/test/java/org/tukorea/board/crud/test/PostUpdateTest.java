package org.tukorea.board.crud.test;

import java.time.LocalDate;
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
public class PostUpdateTest {
	
	@Autowired
	private BoardService bs;
	
	private Logger logger = LoggerFactory.getLogger(PostUpdateTest.class);

	
	@Before
	public void savePost() throws Exception {
		LocalDate current=LocalDate.now();
		Post post=new Post("제목","내용","유저",current);
		bs.createPost(post);
	}
	
	@Test
	@Transactional
	public void updatePost() throws Exception{
		List<Post> findPosts=bs.getAllPosts();
		logger.info("변경 전:"+findPosts.get(0).getTitle());
		
		bs.updatePost(findPosts.get(0).getId(), "변경된 제목", "변경된 내용");
		List<Post> findPosts2=bs.getAllPosts();
		logger.info("변경 후:"+findPosts2.get(0).getTitle());
		
	}

}
