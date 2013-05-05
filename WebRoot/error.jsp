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

		<title>出错界面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/header.css" type="text/css" />
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<!-- /#banner -->

		<div align="center">
			<div id="exception" style="color: blue">
		<%
 			String message = (String) request.getAttribute("message");
 			out.println(message + "<hr>");
 			Throwable exception = (Throwable) request.getAttribute("exception");
 			if (exception != null) {
 				exception.printStackTrace(new java.io.PrintWriter(out));
 				exception.printStackTrace();
 			}
 		%> 
			</div>
		</div>
	</body>
</html>
