<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Jawinton's Blog</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/featured.css" type="text/css" />
		<link rel="stylesheet" href="css/content.css" type="text/css" />
		<link rel="stylesheet" href="css/extras.css" type="text/css" />
		<link rel="stylesheet" href="css/blog.css" type="text/css" />
		<script type="text/javascript" src="js/login.js"></script>
		<script type="text/javascript" src="js/blog_list.js"></script>
		<script type="text/javascript" src="js/view.js"></script>
	</head>

	<body id="index" class="home" onload="getContentAsJSON(1);showTab(1);">
		<!-- /#banner -->
		<c:choose>
			<c:when test="${user == null}">
				<aside id="login" class="body">
				<div style="height: 25px;">
					<form name="loginForm" method="post" action="UserLogin"
						onsubmit="return checkAll();">
						用户名:
						<input type="text" name="name" id="name" />
						密码:
						<input type="password" name="password" id="password" />
						<input type="submit" value="登录" />
					</form>
				</div>
				</aside>
			</c:when>
			<c:otherwise>
				<aside id="login" class="body">
				<div class="funlist">
					<a href="UserLogout">退出</a>
				</div>
				<div class="funlist">
					<a href="BlogAdd">撰写博客</a>
				</div>
				<div class="funlist">
					<a href="BlogTitleList?userId=${user.userId }">博客管理</a>
				</div>
				<c:if test="${user.userLevel == 1}">
					<div class="funlist">
						<a href="UserList">用户管理</a>
					</div>
					<div class="funlist">
						<a href="CommentList">评论管理</a>
					</div>
				</c:if>
				<div style="float: right; margin-right: 2px;">
					欢迎归来！
					<c:out value="${user.userName}"></c:out>
				</div>
				</aside>
			</c:otherwise>
		</c:choose>
		<aside id="featured" class="body">
		<article>
		<figure>
		<img src="images/tangwenjie0@gmail.com.gif" alt="Smashing Magazine" />
		</figure>
		<hgroup>

		<h2>
			个人简介
		</h2>
		<h3>
			<a href="#">汤文杰</a>
		</h3>
		</hgroup>
		<p>
			年二十有一，无不良嗜好，亦无突出功绩，然性善。丁亥年识IT，此后乐此不疲。何足道矣。
		</p>

		</article>
		</aside>

		<!-- /#featured -->

		<section id="content" class="body">
		
		<!-- /#posts-list -->
		</section>
		<!-- /#content -->
		<section id="extras" class="body">
		<div class="social">

			<h2>
				social
			</h2>
			<ul>
				<li>
					<a href="http://delicious.com/enrique_ramirez" rel="me">delicious</a>
				</li>
				<li>
					<a href="http://digg.com/users/enriqueramirez" rel="me">digg</a>
				</li>

				<li>
					<a href="http://facebook.com/enrique.ramirez.velez" rel="me">facebook</a>
				</li>
				<li>
					<a href="http://www.lastfm.es/user/enrique-ramirez" rel="me">last.fm</a>
				</li>
				<li>
					<a href="http://website.com/feed/" rel="alternate">rss</a>
				</li>

				<li>
					<a href="http://twitter.com/enrique_ramirez" rel="me">twitter</a>
				</li>
			</ul>
		</div>
		<!-- /.social -->
		</section>
		<!-- /#extras -->
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
