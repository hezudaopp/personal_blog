<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<link rel="stylesheet" href="css/comment.css" type="text/css" />
		<link rel="stylesheet" href="css/" type="text/css" />
		<script type="text/javascript" src="js/comment_list.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/fckeditor/editor/fckeditor.js"></script>
		<script type="text/javascript">
		function checkCommentContent() {
			var commentContent = FCKeditorAPI.GetInstance("commentContent").GetXHTML();
			if (commentContent == "" || commentContent == " ") {
				alert("评论不能为空！");
				return false;
			}
			return true;
		}
		</script>

	</head>

	<body onload="getCommentAsJSON(${blog.blogId },1);">
		<section id="content" class="body">
		<ol id="posts-list" class="hfeed">
			<li>
				<article class="hentry">
				<header>
				<h2 class="entry-title">
					<a href="BlogShow?blogId=${blog.blogId }" rel="bookmark"
						title="Permalink to this POST TITLE"> <c:out
							value="${blog.blogTitle } "></c:out> </a>
				</h2>

				</header>

				<footer class="post-info">
				<abbr class="published"> <!-- YYYYMMDDThh:mm:ss+ZZZZ --> <time
						datetime="2010-06-08"> <c:out
						value="${blog.blogCreatedDate }"></c:out> </time> </abbr>

				<address class="vcard author">

					By
					<a class="url fn"
						href="BlogTitleList?userId=${blog.blogUser.userId }"><c:out
							value="${blog.blogUser.userName }"></c:out> </a>
				</address>
				</footer>
				<!-- /.post-info -->

				<div class="entry-content">
					${blog.blogContent }"
				</div>
				<!-- /.entry-content -->
				</article>
			</li>
		</ol>
		<!-- /#posts-list -->
		</section>
		<!-- /#content -->

		<!-- /#comment -->
		<section id="comment" class="body">
		<div id="comment_list">
		</div>
		<form
			action="CommentInsert?blogId=${blog.blogId }&userId=${user.userId }"
			method="post" onsubmit="return checkCommentContent();">
			<div style="padding: 15px 0;">
				<div style="padding-left: 60px;">
					<FCK:editor instanceName="commentContent" toolbarSet="Basic" width="600">
					</FCK:editor>
				</div>
				<div style="text-align: center; margin: 20px 0;">
					<input type="submit" name="commentSubmit" value="写评论">
				</div>
			</div>
		</form>
		</section>
		<!-- /#comment -->

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