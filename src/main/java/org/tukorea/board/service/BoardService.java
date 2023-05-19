package org.tukorea.board.service;

import java.util.List;

import org.tukorea.board.domain.Post;

public interface BoardService {
	
	public List<Post> getAllPosts() throws Exception; // 게시판 리스트
	public Post getByPostId(int postId) throws Exception; // 게시판 하나
	public void createPost(Post post) throws Exception; // 게시판 생성
	public void updatePost(int postId,String title,String content) throws Exception; // 게시판 수정
	public void deletePost(int postId) throws Exception; // 게시판 삭제
	public List<Post> searchPost(String keyword) throws Exception; //검색
	public int getTotalPostsCount();  // 전체 카운
    public List<Post> getPostsByPage(int startIndex, int pageSize);
}
