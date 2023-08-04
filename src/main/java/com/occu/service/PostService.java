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
	    	
	    	postVo.setCreateDate(new Timestamp(System.currentTimeMillis())); // ���� �ð����� �ʱ�ȭ
	        postDao.insertPost(postVo);
	       
	    }
	    
	    public String saveFile(MultipartFile file) {
	    	//if (!file.isEmpty()) { // �̹��� ������ ���ε��� ��쿡�� ó��
	    		System.out.println("postservice: " + file.getOriginalFilename());
	    	
	            // ���� ���� ��� ���� 
	            String uploadPath = "C:\\javastudy\\occu_workspace\\occukkm\\WebApp\\assets\\images\\upload";
	            System.out.println("uploadPath: "+ uploadPath);
	            // ���� ���ϸ� ��������
	            String orglFileName = file.getOriginalFilename();
	            System.out.println("orglFileName: "+ orglFileName);
	            // ���� Ȯ���� ����
	            String fileExtension = orglFileName.substring(orglFileName.lastIndexOf("."));
	            System.out.println("fileExtension: "+fileExtension);
	            // ������ ���ϸ� ���� (UUID�� �̿��Ͽ� ���ϸ� �ߺ� ����)
	            String saveName = System.currentTimeMillis()+UUID.randomUUID().toString() + fileExtension;
	            System.out.println("saveName: " + saveName);
	            // ���� ���� ��ο� ���ϸ��� �����Ͽ� ���� ���� ��� ����
	            String filePath = uploadPath + "\\" + saveName;
	            System.out.println("filePath "+filePath);
	            // ���� ������
	    		long fileSize = file.getSize();
	    		System.out.println("fileSize: " + fileSize);
	            
	    		// ���� �ϵ� ��ũ ����
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

	  
	    // ����Ʈ ����Ʈ
	    public List<PostVo> getAllPosts() {
	    	System.out.println("postService imageList");
	    	
	        return postDao.selectAllPosts();
	    }
	
	   
}
