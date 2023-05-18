package org.tukorea.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.board.domain.User;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.board.mapper.UserMapper";
	
	public User findByUsername(String username) {
        return sqlSession.selectOne(namespace+ ".findByUsername",username);
    }

    public void save(User user) {
        sqlSession.insert(namespace+".save", user);
    }
    
   public List<User> findUsers(String username){
	return null;
	   
   }

}
