package com.occu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.occu.vo.PostVo;

import oracle.jdbc.proxy.annotation.Post;

@Repository
public class PostDao {
	  @Autowired
	  private SqlSession sqlSession;

	    public int insertPost(PostVo postVo) {
	    	System.out.println(postVo);
	    	int result = sqlSession.insert("post.insertPost", postVo);
	    
	        // 성공적으로 삽입된 레코드의 개수를 return값으로 확인하지 않을땐 void로 작성한다
	    	return result;
	    	
	    }

	    public List<PostVo> selectAllPosts() {
	    	

	    	List<PostVo> postList = sqlSession.selectList("post.selectAllPosts");
	    	System.out.println("postList: "+postList);
	    	
	        return postList;
	    }

	  
	
}
