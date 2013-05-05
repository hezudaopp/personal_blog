<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:useBean id="editedUser" scope="request" class="bean.User"></jsp:useBean>
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
		<script type="text/javascript" src="js/register.js"></script>
	</head>

	<body>
		<form name="userEditForm" action="UserUpdate" method="post"
			onsubmit="return checkAllExceptName();">
			<input type="hidden" name="userId" value="${editedUser.userId }" />
			<input type="hidden" name="username" value="${editedUser.userName }" />
			<section id="content" class="body">
			<div style="padding-left: 240px;">
				<table>
					<tr>
						<td align="left">
							用户名:
						</td>
						<td>
							<input type="text" name="name" value="${editedUser.userName }"
								id="name" disabled="disabled" />
						</td>
						<td id="nameMsg"></td>
					</tr>
					<tr>
						<td align="left">
							新密码:
						</td>
						<td>
							<input type="password" name="password" id="password"
								onblur="passwordCheck();" />
						</td>
						<td id="passwordMsg"></td>
					</tr>
					<tr>
						<td align="left">
							确认新密码:
						</td>
						<td>
							<input type="password" name="confirm" id="confirm"
								onblur="passwordCheck();" />
						</td>
						<td id="confirmMsg"></td>
					</tr>
					<tr>
						<td align="left">
							昵称:
						</td>
						<td>
							<input type="text" name="nickname" id="nickname"
								value="${editedUser.userNickname }" onblur="nicknameCheck();" />
						</td>
						<td id="nicknameMsg"></td>
					</tr>
					<tr>
						<td align="left">
							座右铭:
						</td>
						<td>
							<textarea rows="5" cols="30" name="motto" id="motto"
								onblur="mottoCheck();">
								<c:out value="${editedUser.userMotto }"></c:out>
							</textarea>
						</td>
						<td id="mottoMsg"></td>
					</tr>
					<tr>
						<td align="left">
							用户等级:
						</td>
						<td>
							<c:if test="${editedUser.userLevel == 0}">
								<input type="radio" name="level" value="0" checked="checked">一般会员
							<input type="radio" name="level" value="1">管理员
							</c:if>
							<c:if test="${editedUser.userLevel == 1}">
								<input type="radio" name="level" value="0">一般会员
							<input type="radio" name="level" value="1" checked="checked">管理员
							</c:if>
						</td>
						<td id="levelMsg"></td>
					</tr>
				</table>
				<input type="submit" value="修改信息">
			</div>
			</section>
			<!-- /#content -->
		</form>

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
