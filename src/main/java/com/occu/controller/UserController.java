package com.occu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.occu.service.UserService;
import com.occu.vo.UserVo;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 회원가입
	@RequestMapping("/joinform")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	// id 중복체크
	@RequestMapping(value="/checkId", method= {RequestMethod.POST})
	@ResponseBody
	public String checkId(@RequestParam("userId") String id) {
		System.out.println("UserCTR idcheck: " + id);
		 
		return userService.checkId(id);
	}
	 // 로그인 처리 메소드
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
        // 로그인 로직 구현 (여기서는 간략하게 설명)
        // 예시로 사용자 "admin5"가 로그인했다고 가정
        String loggedInUsername = "admin5";

        // 로그인 성공 시 세션에 사용자 정보 저장
        if (id.equals(loggedInUsername) && password.equals("1234")) {
            session.setAttribute("loggedInUser", loggedInUsername);
        }

        return "redirect:/home";
    }
	
	
	
	
	
	
	
}


