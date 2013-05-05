<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'pagination.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/pagination.js"></script>
		<style type="text/css">
		a{
			color: red;
		}
		</style>

	</head>

	<body bgcolor="#ffffff" onload="getValue(1);">
		<form action="" method="POST">
			<div id="pagDiv1">
				<table id="pagTable" border="1" align="center">
					<tbody id="pagTbody">
					</tbody>
				</table>
			</div>
			<div>
				<table id="pagTable1" border="1" align="center">
					<tbody id="pageTbody1">

					</tbody>
				</table>
			</div>
			<div id="pagDiv2">
				<table align="center">
					<tbody id="pageTbody2">

					</tbody>
				</table>
			</div>
		</form>
	</body>

</html>
