package org.tukorea.board.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.board.domain.Post;
import org.tukorea.board.persistence.BoardRepository;
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardRepository boardRepository;

	@Override
	public List<Post> getAllPosts() throws Exception {
		// TODO Auto-generated method stub
		return boardRepository.getAllPosts();
	}

	@Override
	public Post getByPostId(int postId) throws Exception {
		// TODO Auto-generated method stub
		return boardRepository.getPostById(postId);
	}

	@Override
	public void createPost(Post post) throws Exception {
        boardRepository.createPost(post);
	}

	@Override
	public void updatePost(int postId, String title, String content) throws Exception {
        Post post = getByPostId(postId);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
            boardRepository.updatePost(post.getId(),post.getTitle(),post.getContent());
        }
    }

	@Override
	public void deletePost(int postId) throws Exception {
		// TODO Auto-generated method stub
		boardRepository.deletePost(postId);
		
	}

	@Override
	public List<Post> searchPost(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return boardRepository.searchPost(keyword);
	}
	
	public int getTotalPostsCount() {
        return boardRepository.getTotalPostsCount();
    }

    public List<Post> getPostsByPage(int startIndex, int pageSize) {
        return boardRepository.getPostsByPage(startIndex, pageSize);
    }

}
