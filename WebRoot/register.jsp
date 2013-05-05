<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>Register Page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/featured.css" type="text/css" />
		<link rel="stylesheet" href="css/content.css" type="text/css" />
		<script type="text/javascript" src="js/register.js"></script>
		<script type="text/javascript" src="js/view.js"></script>
	</head>

	<body id="index" class="home" onload="showTab(4);">
		<!-- /#featured -->
		<section id="content" class="body">
		<form id="registerForm" action="UserAdd"
			method="post" onsubmit="return checkAll();">
			<div style="padding-left: 240px;">
				<table>
					<tr>
						<td align="left">
							用户名:
						</td>
						<td>
							<input type="text" name="name" id="name" onblur="nameCheck();" />
						</td>
						<td id="nameMsg"></td>
					</tr>
					<tr>
						<td align="left">
							密码:
						</td>
						<td>
							<input type="password" name="password" id="password"
								onblur="passwordCheck();" />
						</td>
						<td id="passwordMsg"></td>
					</tr>
					<tr>
						<td align="left">
							确认密码:
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
								onblur="nicknameCheck();" />
						</td>
						<td id="nicknameMsg"></td>
					</tr>
					<tr>
						<td align="left">
							座右铭:
						</td>
						<td>
							<input type="text" name="motto" id="motto" onblur="mottoCheck();" />
						</td>
						<td id="mottoMsg"></td>
					</tr>
				</table>
				<input type="submit" value="注册用户">
			</div>
		</form>
		</section>
		<!-- /#content -->
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
