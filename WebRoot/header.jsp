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

		<title>Jawinton's Blog</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/header.css" type="text/css" />
		<script type="text/javascript">
		function isValidDate(str) {
			if (!/^\d{4}\-\d\d\-\d\d/.test(str)) {
				return false;
			}
			var array = str.replace(/\-0/g, "-").split("-");
			var year = parseInt(array[0]);
			var month = parseInt(array[1]) - 1;
			var day = parseInt(array[2]);
			var date = new Date(year, month, day);
			return (date.getFullYear() == year && date.getMonth() == month && date
					.getDate() == day);
		}
	
		function checkDate(){
			var startDate = document.getElementById("dateStart").value;
			var endDate = document.getElementById("dateEnd").value;
			if(startDate!="" && !isValidDate(startDate)){
				alert("起始日期错误");
				return false;
			}
			if(endDate!="" && !isValidDate(endDate)){
				alert("起始日期错误");
				return false;
			}
			return true;
		}
		
</script>

	</head>

	<body>
		<header id="banner" class="body">
		<div>
			<div style="float: left; width: 300px;">
				<h1>
					<a href="#">Jawinton</a>
				</h1>
			</div>
			<div style="float: right; margin-top: 30px; width: 400">
				<form name="searchForm" method="post" action="BlogSearch"
					onsubmit="return checkDate();">
					<div
						style="padding-bottom: 20px; height: 12px; line-height: 12px; font-size: 12px;">
						按内容搜索：
						<input type="text" name="keywords" size="24" />
					</div>
					<div
						style="padding-bottom: 20px; height: 12px; line-height: 12px; font-size: 12px;">
						按日期搜索：
						<input type="text" id="dateStart" name="dateStart" size="10" />
						至
						<input type="text" id="dateEnd" name="dateEnd" size="10" />
					</div>
					<div>
						<input type="submit" name="searchSubmit" value="搜索博文" />
					</div>
				</form>
			</div>
		</div>

		<nav style="clear:both;">
		<ul>
			<li id="tab1">
				<a href="index.jsp">个人主页</a>
			</li>
			<li id="tab2">
				<a href="profile.jsp">个人简介</a>
			</li>
			<li id="tab3">
				<a href="BlogTitleList">博客列表</a>
			</li>
			<li id="tab4">
				<a href="UserRegister">注册用户</a>
			</li>
		</ul>
		</nav>

		</header>
	</body>
</html>
