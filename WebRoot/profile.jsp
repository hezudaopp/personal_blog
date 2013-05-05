<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>个人简介</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/featured.css" type="text/css" />
		<link rel="stylesheet" href="css/content.css" type="text/css" />
		<script type="text/javascript" src="js/view.js"></script>
		<style type="text/css">
#content {
	padding-left: 5px;
}

#content ol {
	margin-left: 0px;
	list-style: none;
}

#content ol li ul li {
	margin-left: -45px;
}

.head {
	margin-left: -30px;
	font-size: 1.2em;
	color: #C64350;
}
</style>

	</head>

	<body id="index" class="home" onload="showTab(2);">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- /#banner -->
		<aside id="featured" class="body">
		<article>
		<figure>
		<img src="images/tangwenjie0@gmail.com.gif" alt="Smashing Magazine" />
		</figure>
		<hgroup>
		<h2>
			个人简介
		</h2>
		<h3>
			<a href="#">汤文杰</a>
		</h3>
		</hgroup>
		<p>
			年二十有一，无不良嗜好，亦无突出功绩，然性善。丁亥年识IT，此后乐此不疲。何足道矣。
		</p>
		</article>
		</aside>
		<!-- /#featured -->
		<section id="content" class="body">
		<ol>
			<li>
				<header class="head">
				教育背景
				</header>
				2007年9月～至今 东北大学 软件工程专业
				<li>
					<header class="head">
					主要课程
					</header>
					数据结构、数据库系统概论、面向对象程序设计、C/C ++程序设计、离散数学、 操作系统、计算机网络 专业技能
				</li>
			</li>
			<li>
				<header class="head">
				计算机技能
				</header>
				<ul>
					<li>
						熟悉Java、PHP、C/C++编程，熟悉面向对象编程方法；
					</li>
					<li>
						具有WEB开发经验，熟练掌握HTML、CSS、JavaScript等客户端WEB语言以及AJAX技术；
					</li>
					<li>
						精通MySQL，熟悉SQL语句；
					</li>
					<li>
						熟练使用Eclipse JDT、CDT、PDT和ZEND Studio for eclipse集成开发环境；
					</li>
					<li>
						熟练使用Linux系统，掌握一定的Linux命令，熟悉shell编程
					</li>
				</ul>
			</li>
			<li>
				<header class="head">
				英语水平
				</header>
				通过CET-6
			</li>
		</ol>
		</section>
		<!-- /#content -->
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
