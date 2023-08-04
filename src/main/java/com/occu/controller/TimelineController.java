package com.occu.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.occu.service.PostService;
import com.occu.vo.PostVo;
import com.occu.vo.UserVo;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class TimelineController {

	@Autowired
	private PostService postService;

		// �Խñ� �ۼ� ó�� �޼ҵ�
		@RequestMapping(value = "/post", method={RequestMethod.POST , RequestMethod.GET})
		public String writePost(@RequestParam("fileImg") MultipartFile file, @ModelAttribute PostVo postVo) {
			
			System.out.println("post");
			System.out.println("File Name: " + file.getOriginalFilename());
			System.out.println(file);
			
			// ���� ���� �� ���� ��� 
	       // String filePath = postService.saveFile(file);
	      //  if (filePath != null) {
	        	// postVo�� ���� ��� ����
		 //       postVo.setImgfile(filePath);
	     //   }
			// ���� �̸�
			if (file != null && !file.isEmpty()) {
				String fileName = postService.saveFile(file);
				postVo.setImg1(fileName);
			} else {
				// �̹��� ������ ���ε����� ���� ��� imgfile�� null�� �����մϴ�.
				postVo.setImg1(" ");
			}
			System.out.println(postVo.toString());
			
			// ���� �α����� ������� ������ ���ǿ��� ������
			//String loggedInUser = (String) session.getAttribute("loggedInUser");
			
			// �α����� ������� ������ �̿��Ͽ� �Խñ� �ۼ�
			//PostVo postVo = new PostVo();
			// postVo.setUserNo(1); // ������ ����� ��ȣ ���� (�� �κ��� �α����� ������ �� �α����� ������� ��ȣ�� ����)
			
			postVo.setId("user1"); // �α����� ������� �̸� ����
//			postVo.setContent(content);
			
			// ���� �ð��� �����ͼ� Timestamp ��ü�� ��ȯ�Ͽ� createDate �ʵ忡 �����մϴ�.
			Timestamp createDate = new Timestamp(System.currentTimeMillis());
			postVo.setCreateDate(createDate);
			
			
	    	System.out.println(postVo.getContent());
			
//		    System.out.println("postVo" +postVo);
			// �ۼ��� ���� DB�� �����մϴ�.
			postService.savePost(postVo);

			// �� �ۼ��� �Ϸ�Ǹ� Ȩ ȭ������ �����̷�Ʈ�մϴ�.
			return "redirect:/home";
	}
		
		// �Խñ� �ε�
		@RequestMapping(value = "/home", method={RequestMethod.POST, RequestMethod.GET})
		public String postList(Model model) {
			List<PostVo> postList = postService.getAllPosts();
			//List<PostVo> postList = SqlSession.selectList("post.selectAllPosts");
			
			//for(PostVo pv : postList) {
			//	System.out.println(pv);
		//	}
			//System.out.println("List<PostVo> : "+postList);
			
			model.addAttribute("postList", postList);
			
			System.out.println("postList : "+postList);
			
			return "main/index";
		}
		
		
		
		
		
}
