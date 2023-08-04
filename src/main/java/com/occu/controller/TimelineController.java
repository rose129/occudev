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

		// 게시글 작성 처리 메소드
		@RequestMapping(value = "/post", method={RequestMethod.POST , RequestMethod.GET})
		public String writePost(@RequestParam("fileImg") MultipartFile file, @ModelAttribute PostVo postVo) {
			
			System.out.println("post");
			System.out.println("File Name: " + file.getOriginalFilename());
			System.out.println(file);
			
			// 파일 저장 및 파일 경로 
	       // String filePath = postService.saveFile(file);
	      //  if (filePath != null) {
	        	// postVo에 파일 경로 설정
		 //       postVo.setImgfile(filePath);
	     //   }
			// 파일 이름
			if (file != null && !file.isEmpty()) {
				String fileName = postService.saveFile(file);
				postVo.setImg1(fileName);
			} else {
				// 이미지 파일을 업로드하지 않은 경우 imgfile을 null로 설정합니다.
				postVo.setImg1(" ");
			}
			System.out.println(postVo.toString());
			
			// 현재 로그인한 사용자의 정보를 세션에서 가져옴
			//String loggedInUser = (String) session.getAttribute("loggedInUser");
			
			// 로그인한 사용자의 정보를 이용하여 게시글 작성
			//PostVo postVo = new PostVo();
			// postVo.setUserNo(1); // 가상의 사용자 번호 설정 (이 부분은 로그인을 구현한 후 로그인한 사용자의 번호로 설정)
			
			postVo.setId("user1"); // 로그인한 사용자의 이름 설정
//			postVo.setContent(content);
			
			// 현재 시간을 가져와서 Timestamp 객체로 변환하여 createDate 필드에 설정합니다.
			Timestamp createDate = new Timestamp(System.currentTimeMillis());
			postVo.setCreateDate(createDate);
			
			
	    	System.out.println(postVo.getContent());
			
//		    System.out.println("postVo" +postVo);
			// 작성한 글을 DB에 저장합니다.
			postService.savePost(postVo);

			// 글 작성이 완료되면 홈 화면으로 리다이렉트합니다.
			return "redirect:/home";
	}
		
		// 게시글 로드
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
