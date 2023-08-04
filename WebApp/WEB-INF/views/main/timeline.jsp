<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date" %>


<!-- Ÿ�Ӷ��� ���� -->
<div id="timeline">

	<div id="postList">
		<!-- ���⿡ �������� ��ȸ�� �ֽ� �Խù����� �ݺ������� ǥ���ϴ� �ڵ带 �߰� -->

		<c:forEach items="${postList}" var="post">
			<div class="post_list"
				onclick="location.href='${pageContext.request.contextPath}/home'">

				<div class="profile_img p-0">
					<a class="" href="${pageContext.request.contextPath}/profile">
						<!-- �ӽ��̹��� --> <img
						src="${pageContext.request.contextPath }/assets/images/main_menu/profile_icon.png"
						alt="������">
					</a>
				</div>
				<div class="post_con m-0">

					<div>
						<a class="m-0" href="${pageContext.request.contextPath}/profile">
							${post.id} </a>
						<p>${post.dateWrite}</p>
					
					</div>
					<!-- �̹����� ǥ���ϴ� �κ� -->
					<c:if test="${not empty post.img1 and post.img1.trim() ne ''}">
					<c:choose>
					    <c:when test="${not empty post.img1 and post.img1.endsWith('.mp4')}">
					        <!-- ���� �±׷� ��� -->
					        <div class="post_content">
						        <video width="500" controls>
						            <source src="assets/images/upload/${post.img1}" type="video/mp4">
						        </video>
					        
					        </div>
					    </c:when>
					    <c:otherwise>
					        <!-- �̹��� �±׷� ��� -->
					        <div class="view">
					            <img class="imgItem" src="assets/images/upload/${post.img1}" alt="Post Image">
					        </div>
					    </c:otherwise>
					</c:choose>
					</c:if>
					<!-- // �̹����ݺ����� -->
					
					<div class= "post_content" style="white-space: pre-line;">${post.content}</div>
					<!-- // �۳��� -->
				</div>
			</div>
		</c:forEach>
		<!-- // content ���� -->
		
		<!-- ���ƿ�, ������Ʈ, ��� ��ư �߰� -->

	</div>
</div>
<!-- Ÿ�Ӷ��� �� -->


