package com.occu.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.occu.dao.PostDao;
import com.occu.dao.UserDao;
import com.occu.vo.UserVo;

import oracle.jdbc.proxy.annotation.Post;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
    @Autowired
    private PostDao postDao;
	
	//checkid
	public String checkId(String id) {
		System.out.println("UserService checkId");
		String response = "";
		UserVo userVo = userDao.selectOne(id);
		
		if (userVo == null) {
			response = "can";
		} else {
			response = "cant";
		}
		
		return response;
	}
	
	 
}
