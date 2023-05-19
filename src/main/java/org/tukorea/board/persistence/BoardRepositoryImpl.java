package org.tukorea.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.board.domain.Post;

@Repository
@Transactional
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.board.mapper.BoardMapper";

	@Override
	public List<Post> getAllPosts() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getAllPosts");
	}

	@Override
	public Post getPostById(int postId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getPostById", postId);
	}

	@Override
	public void createPost(Post post) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".createPost", post);
		
	}

	@Override
	public void updatePost(int postId, String title, String content) throws Exception {
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("id", postId);
	    parameters.put("title", title);
	    parameters.put("content", content);
	    sqlSession.update(namespace + ".updatePost", parameters);
	}


	@Override
	public void deletePost(int postId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".deletePost",postId);
		
	}

	@Override
	public List<Post> searchPost(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".searchPosts",keyword);
	}
	
	@Override
	public int getTotalPostsCount() {
		return sqlSession.selectOne(namespace + ".getTotalPostsCount");
    }

	@Override
    public List<Post> getPostsByPage(int startIndex, int pageSize) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("startIndex", startIndex);
        parameters.put("pageSize", pageSize);
        return sqlSession.selectList(namespace + ".getPostsByPage", parameters);
    }
	


}
