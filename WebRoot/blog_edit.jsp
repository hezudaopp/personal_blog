<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="blog" scope="request" class="bean.Blog"></jsp:useBean>
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
		<script type="text/javascript" src="<%=request.getContextPath()%>/fckeditor/editor/fckeditor.js"></script>
		<script type="text/javascript">
		function checkBlog() {
			var blogTitle = document.getElementById("blogTitle").value;
			var blogContent = FCKeditorAPI.GetInstance("blogContent").GetXHTML();
			if (blogContent == "" || blogContent == " ") {
				alert("博客内容不能为空！");
				return false;
			}else if (blogTitle == "" || blogTitle == " "){
				alert("博客标题不能为空！");
				return false;
			}
			return true;
		}
		</script>
	</head>

	<body>
	<form name="blogEditForm" onsubmit="return checkBlog();"
	<c:choose>
	<c:when test="${blog.blogId > 0 }">
	action="BlogUpdate"
	</c:when>
	<c:otherwise>
	action="BlogInsert"
	</c:otherwise>
	</c:choose>
	 method="post">
		<input type="hidden" name="blogId" value="${blog.blogId }"/>
		<input type="hidden" name="userId" value="${blog.blogUser.userId }"/>
		<input type="hidden" name="blogCreatedDate" value="${blog.blogCreatedDate }"/>
		<input type="hidden" name="blogUpdateDate" value="${blog.blogUpdateDate }"/>
		<section id="content" class="body">
			<div style="margin-bottom: 10px;">标题：</div>
			<div style="margin-bottom: 10px;">
			<input type="text" id="blogTitle" name="blogTitle" value="${blog.blogTitle }" style="border-color: #C74350;" size="60"/>
			</div>
			<div style="margin-bottom: 10px;">
			内容：
			</div>
			<FCK:editor instanceName="blogContent" height="600" toolbarSet="BlogContent">
				<jsp:attribute name="value">${blog.blogContent}
				</jsp:attribute>
			</FCK:editor>
			<div style="margin-top: -30px;">
			<input type="submit" value="提交博客内容">
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
