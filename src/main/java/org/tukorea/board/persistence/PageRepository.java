package org.tukorea.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.board.domain.Post;


@Repository
public class PageRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.board.mapper.PagedMapper";
	
	public int getTotalPostsCount() {
		return sqlSession.selectOne(namespace+".getTotalPostsCount");
	}
	
	
	public List<Post> getPostsByPage(int startIndex, int pageSize) {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("startIndex", startIndex);
        params.put("pageSize", pageSize);
        return sqlSession.selectList(namespace + ".getPostsByPage", params);
    }
}
