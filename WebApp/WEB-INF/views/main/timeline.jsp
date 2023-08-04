<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date" %>


<!-- 타임라인 시작 -->
<div id="timeline">

	<div id="postList">
		<!-- 여기에 서버에서 조회한 최신 게시물들을 반복문으로 표시하는 코드를 추가 -->

		<c:forEach items="${postList}" var="post">
			<div class="post_list"
				onclick="location.href='${pageContext.request.contextPath}/home'">

				<div class="profile_img p-0">
					<a class="" href="${pageContext.request.contextPath}/profile">
						<!-- 임시이미지 --> <img
						src="${pageContext.request.contextPath }/assets/images/main_menu/profile_icon.png"
						alt="프로필">
					</a>
				</div>
				<div class="post_con m-0">

					<div>
						<a class="m-0" href="${pageContext.request.contextPath}/profile">
							${post.id} </a>
						<p>${post.dateWrite}</p>
					
					</div>
					<!-- 이미지를 표시하는 부분 -->
					<c:if test="${not empty post.img1 and post.img1.trim() ne ''}">
					<c:choose>
					    <c:when test="${not empty post.img1 and post.img1.endsWith('.mp4')}">
					        <!-- 비디오 태그로 출력 -->
					        <div class="post_content">
						        <video width="500" controls>
						            <source src="assets/images/upload/${post.img1}" type="video/mp4">
						        </video>
					        
					        </div>
					    </c:when>
					    <c:otherwise>
					        <!-- 이미지 태그로 출력 -->
					        <div class="view">
					            <img class="imgItem" src="assets/images/upload/${post.img1}" alt="Post Image">
					        </div>
					    </c:otherwise>
					</c:choose>
					</c:if>
					<!-- // 이미지반복영역 -->
					
					<div class= "post_content" style="white-space: pre-line;">${post.content}</div>
					<!-- // 글내용 -->
				</div>
			</div>
		</c:forEach>
		<!-- // content 내용 -->
		
		<!-- 좋아요, 리포스트, 댓글 버튼 추가 -->

	</div>
</div>
<!-- 타임라인 끝 -->


