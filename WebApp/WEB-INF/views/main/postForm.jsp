<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<h2 class="main_tit">Home</h2>    
<div class="t_post">
		 <!-- 글 입력 폼 -->
		<form class="post_form" action="${pageContext.request.contextPath}/post" method="post"  enctype="multipart/form-data">
		
			  <div class="profile_img ml-3">
			   	 <a class="" href="${pageContext.request.contextPath}/profile">
			   		 <!-- 임시이미지 -->
					 <img src="${pageContext.request.contextPath }/assets/images/main_menu/profile_icon.png" alt="프로필">
			 	 </a>
			  </div>
			  <div class="p_box_wrap">
			  
				  <div class="post_box">
					  <textarea name="content" id="content" placeholder="what is happening?"></textarea>
					  <label for="imageInput">
					  <div class="file_img">
					  	<i class="fi fi-rr-picture"></i>
					  </div>
					  </label>
					  <input type="file" name="fileImg" id="imageInput">
				  </div>
				  <div class="area_btn">
					  <button class=" btn_1" type="submit">CCU</button>
				  </div>
			  </div>
		  </form>
	
		
		
	
	</div>