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
	
	// ȸ������
	@RequestMapping("/joinform")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	// id �ߺ�üũ
	@RequestMapping(value="/checkId", method= {RequestMethod.POST})
	@ResponseBody
	public String checkId(@RequestParam("userId") String id) {
		System.out.println("UserCTR idcheck: " + id);
		 
		return userService.checkId(id);
	}
	 // �α��� ó�� �޼ҵ�
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
        // �α��� ���� ���� (���⼭�� �����ϰ� ����)
        // ���÷� ����� "admin5"�� �α����ߴٰ� ����
        String loggedInUsername = "admin5";

        // �α��� ���� �� ���ǿ� ����� ���� ����
        if (id.equals(loggedInUsername) && password.equals("1234")) {
            session.setAttribute("loggedInUser", loggedInUsername);
        }

        return "redirect:/home";
    }
	
	
	
	
	
	
	
}


