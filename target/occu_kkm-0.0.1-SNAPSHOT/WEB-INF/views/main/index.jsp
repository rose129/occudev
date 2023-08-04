<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- viewport 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/occu.css" type="text/css">

<title>O'CCU</title>
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
							<a href="${pageContext.request.contextPath }/home">
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
	<div class="main"> </div>
	<div class="side_right"> </div>
		

	</div>

</body>
</html>