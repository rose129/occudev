<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- viewport 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/occu.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/post.css" type="text/css">
<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
<title>O'CCU</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
        //$(document).ready(function() {
            // 초기에는 타임라인을 보여줌 (기본적으로 timeline.jsp 포함)
          //  $("#feedArea").load("home.jsp");
            
            // 타임라인 메뉴 클릭 시
           // $("#timeline").click(function() {
           //     $("#feedArea").load("timeline.jsp");
          //  });
            
            // 다른 메뉴 클릭 시 (예: 다른메뉴1, 다른메뉴2)
           // $("#otherMenu1").click(function() {
            //    $("#feedArea").load("/WEB-INF/views/other_menu1.jsp");
          //  });
            
          //  $("#otherMenu2").click(function() {
            //    $("#feedArea").load("/WEB-INF/views/other_menu2.jsp");
          //  });
       // });
        


</script>
</head>
<body>
	<div id="wrap">
		
		<!-- header -->
    	<header>
    		<div class="container">
				<nav class="main_nav">
	    			<div class="logo">
	    				<a href="${pageContext.request.contextPath }/home">
	    					<img alt="" src="${pageContext.request.contextPath }/assets/images/main_menu/logo_icon.png">
	    				</a>
	    			</div>
    			

					<ul>
						<li>
							<a id="timeline" href="${pageContext.request.contextPath }/home">
								<div class="home">
									<img alt="home" src="${pageContext.request.contextPath }/assets/images/main_menu/home_icon.png">
									<span>
										HOME
									</span>
								</div>
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/search">
								<div class="search">
									<img alt="" src="${pageContext.request.contextPath }/assets/images/main_menu/search_icon.png">
									<span>
										SEARCH
									</span>
								
								</div>
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/dm">
								<div class="dm">
									<img alt="" src="${pageContext.request.contextPath }/assets/images/main_menu/dm_icon.png">
									<span>
										CCUCHAT
									</span>
								</div>
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/event">
								<div class="event">
									<img alt="" src="${pageContext.request.contextPath }/assets/images/main_menu/event_icon.png">
									<span>
										EVENT
									</span>
								</div>
							</a>
						</li>

						<li>
							<a href="${pageContext.request.contextPath }/profile">
								<div class="profile">
									<img alt="" src="${pageContext.request.contextPath }/assets/images/main_menu/profile_icon.png">
									<span>
										PROFILE
									</span>
								</div>
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/settings">
								<div class="settings">
									<img alt="" src="${pageContext.request.contextPath }/assets/images/main_menu/settings_icon.png">
									<span>
										SETTINGS
									</span>
								</div>
							</a>
						</li>
						
					</ul>

				</nav>
			</div>
    	</header>
	<!-- main -->
	<div class="main"> 
	  <div id="feedArea">
	        
	       <jsp:include page="/WEB-INF/views/main/postForm.jsp"/>
	       <jsp:include page="/WEB-INF/views/main/timeline.jsp"/>
	       
	        
	  </div>
	
	</div>
	<div class="side_right"> </div>
		

	</div>





</body>
</html>