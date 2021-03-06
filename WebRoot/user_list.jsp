<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'user_list.jsp' starting page</title>

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

	</head>

		<body>
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
			<ul>
				<li style="width:30px">
					ID
				</li>
				<li style="width: 80px;">
					用户名
				</li>
				<li style="width: 200px;">
					密码
				</li>
				<li style="width: 80px;">
					用户昵称
				</li>
				<li style="width: 160px;">
					用户座右铭
				</li>
				<c:if test="${user != null }">
					<li>
						修改
					</li>
					<li>
						删除
					</li>
				</c:if>
			</ul>
		</div>
		<ol id="posts-list" class="hfeed">
			<c:forEach items="${userList }" var="u">
					<li>
						<ul>
							<li style="width: 30px">
								<c:out value="${u.userId }"></c:out>
							</li>
							<li style="width: 80px;">
								<a href="BlogTitleList?userId=${u.userId }"><c:out value="${fn:substring(u.userName,0,10) }"></c:out></a>
							</li>
							<li style="width: 200px;">
								<c:out value="${fn:substring(u.userPassword,0,20) }..."></c:out>
								
							</li>
							<li style="width: 80px;">
							<c:out value="${fn:substring(u.userNickname,0,5) }"></c:out>
							</li>
							<li style="width: 160px;">
								<c:out value="${fn:substring(u.userMotto,0,10) }"></c:out>
							</li>
							<c:if test="${user != null }">
								<li>
									<a href="UserEdit?userId=${u.userId }">修改</a>
								</li>
								<li>
									<a href="UserDelete?userId=${u.userId }" onclick="return confirm('确定要删除该用户？');">删除</a>
								</li>
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
