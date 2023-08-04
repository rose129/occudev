package com.occu.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.occu.dao.PostDao;
import com.occu.vo.PostVo;

@Service
public class PostService {
	
	 @Autowired
	 private PostDao postDao;
	 
	 	

	    public void savePost(PostVo postVo) {
	    	
	    	postVo.setCreateDate(new Timestamp(System.currentTimeMillis())); // 현재 시간으로 초기화
	        postDao.insertPost(postVo);
	       
	    }
	    
	    public String saveFile(MultipartFile file) {
	    	//if (!file.isEmpty()) { // 이미지 파일을 업로드한 경우에만 처리
	    		System.out.println("postservice: " + file.getOriginalFilename());
	    	
	            // 파일 저장 경로 설정 
	            String uploadPath = "C:\\javastudy\\occu_workspace\\occukkm\\WebApp\\assets\\images\\upload";
	            System.out.println("uploadPath: "+ uploadPath);
	            // 원본 파일명 가져오기
	            String orglFileName = file.getOriginalFilename();
	            System.out.println("orglFileName: "+ orglFileName);
	            // 파일 확장자 추출
	            String fileExtension = orglFileName.substring(orglFileName.lastIndexOf("."));
	            System.out.println("fileExtension: "+fileExtension);
	            // 고유한 파일명 생성 (UUID를 이용하여 파일명 중복 방지)
	            String saveName = System.currentTimeMillis()+UUID.randomUUID().toString() + fileExtension;
	            System.out.println("saveName: " + saveName);
	            // 파일 저장 경로와 파일명을 결합하여 실제 파일 경로 생성
	            String filePath = uploadPath + "\\" + saveName;
	            System.out.println("filePath "+filePath);
	            // 파일 사이즈
	    		long fileSize = file.getSize();
	    		System.out.println("fileSize: " + fileSize);
	            
	    		// 서버 하드 디스크 저장
	    		try {
	    			byte[] fileData = file.getBytes();
	    			OutputStream out = new FileOutputStream(filePath);
	    			BufferedOutputStream bos = new BufferedOutputStream(out);
	    						
	    			bos.write(fileData);
	    			bos.close();
	    			
	    		} catch (IOException e) {
	    
	    			e.printStackTrace();
	    		}
	    		
	    		
	    	return saveName;
	    }

	  
	    // 포스트 리스트
	    public List<PostVo> getAllPosts() {
	    	System.out.println("postService imageList");
	    	
	        return postDao.selectAllPosts();
	    }
	
	   
}
