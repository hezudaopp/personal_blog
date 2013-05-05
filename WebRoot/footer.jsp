<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'footer.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/footer.css" type="text/css" />

	</head>

	<body>
		<footer id="contentinfo" class="body">
		<address id="about" class="vcard body">
			<span class="primary"> <strong><a href="#"
					class="fn url">Jawinton</a> </strong> </span>
			<!-- /.primary -->

			<img src="images/tangwenjie0@gmail.com.gif"
				alt="Smashing Magazine Logo" class="photo" />
		</address>
		<!-- /#about -->
		</footer>
		<!-- /#contentinfo -->
	</body>
</html>
