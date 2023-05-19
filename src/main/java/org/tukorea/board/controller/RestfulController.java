package org.tukorea.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.board.domain.Post;
import org.tukorea.board.domain.PostForm;
import org.tukorea.board.service.BoardService;

@RestController //게시판 게시글 전체 restf로 반환
public class RestfulController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value="/api/v1/board",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PostForm> allPost() throws Exception {
		List<Post> posts=boardService.getAllPosts();
		
		List<PostForm> postForms=new ArrayList<PostForm>();
		
		for(Post post:posts) {
			PostForm postForm=new PostForm(post.getTitle(),post.getContent(),post.getAuthor(),post.getCreatedAt());
			postForms.add(postForm);
		}
		
		return postForms;
	
	}

}
