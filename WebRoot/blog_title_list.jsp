<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<title></title>

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
		<link rel="stylesheet" href="css/list.css" type="text/css" />
		<script type="text/javascript" src="js/view.js"></script>
	</head>

	<body onload="showTab(3);">
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

		<section id="content" class="body">
		<div>
			<ul class="list">
				<li>
					创建日期
				</li>
				<li>
					博客作者
				</li>
				<li style="width: 200px;">
					博客标题
				</li>
				<li style="width: 140px;">
					最后修改日期
				</li>
				<c:if test="${user != null }">
					<li style="width: 40px;">
						修改
					</li>
					<li style="width: 40px;">
						删除
					</li>
				</c:if>
			</ul>
		</div>
		<ol id="posts-list" class="hfeed">
			<c:forEach items="${blogList }" var="blog">
					<li>
						<ul class="list">
							<li>
								<c:out value="${blog.blogCreatedDate }"></c:out>
							</li>
							<li>
								<a href="BlogTitleList?userId=${blog.blogUser.userId }"><c:out
										value="${blog.blogUser.userName }"></c:out>
								</a>
							</li>
							<li style="width: 200px;">
								<a href="BlogShow?blogId=${blog.blogId }"><c:out
										value="${fn:substring(blog.blogTitle,0,16) }..."></c:out>
								</a>
							</li>
							<li style="width: 140px;">
								<c:out value="${blog.blogUpdateDate }"></c:out>
							</li>
							<c:if test="${user != null }">
								<c:if test="${user.userLevel > 0 || user.userId == blog.blogUser.userId }">
								<li style="width: 40px;">
									<a href="BlogEdit?blogId=${blog.blogId }">修改</a>
								</li>
								<li style="width: 40px;">
									<a href="BlogDelete?blogId=${blog.blogId }"  onclick="return confirm('确定要删除该博客？');">删除</a>
								</li>
								</c:if>
							</c:if>
						</ul>
					</li>
			</c:forEach>
		</ol>
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
