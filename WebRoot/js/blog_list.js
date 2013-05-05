var httpRequest = null;

function getContentAsJSON(curPage) {
	var content = document.getElementById("content");
	content.innerHTML = "Loading, please wait ...";
	var url = "BlogList?page=" + curPage;

	if (window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}

	httpRequest.open("GET", url, true);
	httpRequest.onreadystatechange = handler;
	httpRequest.send(null);
}

function handler() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			processJSON(httpRequest.responseText);
		}
	}
}

function processJSON(jsonArrayString) {
	
	var content = document.getElementById("content");

	// Since JSON is a subset of JavaScript, I am using
	// JavaScript is own compiler to parse JSON in one line!
	var jsonArray = eval("(" + jsonArrayString + ")");

	var curPage = jsonArray[jsonArray.length - 1].curPage;
	var prePage = curPage - 1;
	var nextPage = curPage + 1;
	var totalPage = jsonArray[jsonArray.length - 1].maxPage;

	var text = '<ol id="posts-list" class="hfeed">';

	for ( var index = 0; index < jsonArray.length - 1; index++) {
		var createdDate = new Date(jsonArray[index].blogCreatedDate.time);
		var updateDate = new Date(jsonArray[index].blogUpdateDate.time);
		text += '<li>'
				+ '<article class="hentry">'
				+ '<header>'
				+ '<h2 class="entry-title">'
				+ '<a href="BlogShow?blogId='
				+ jsonArray[index].blogId
				+ '" rel="bookmark" title="Permalink to this POST TITLE">'
				+ jsonArray[index].blogTitle
				+ '</h2>'
				+ '</header>'
				+

				'<footer class="post-info">'
				+ '<abbr class="published"> <!-- YYYYMMDDThh:mm:ss+ZZZZ --> <time datetime="2010-06-08">'
				+ createdDate.getFullYear() + '-' + createdDate.getMonth()
				+ '-' + createdDate.getDate() + ' ' + createdDate.getHours()
				+ ':' + createdDate.getMinutes() + ':'
				+ createdDate.getSeconds() + '</time> </abbr>' +

				'<address class="vcard author">' +

				'By <a class="url fn" href="BlogTitleList?userId='
				+ jsonArray[index].blogUser.userId + '">'
				+ jsonArray[index].blogUser.userName + '</a>' + '</address>'
				+ '</footer>' + '<div class="entry-content">' + '<p>'
				+ jsonArray[index].blogContent + '</p>' + '</div>'
				+ '</article>' + '</li>';
	}
	text += '</ol>';
	text += '<div style="float:right; height:21px; line-height: 21px; display: block; background: #fff; margin: 0px auto 2em auto; overflow: hidden;">' + '<ul style="float: right; height: 100%; width:100%; list-style: none; margin: 0px;">';
	if (curPage != 1) {
		  text += '<li class="page_count">'
				+ '<a href="javascript:getContentAsJSON('+prePage+');">&lt;' + '上一页</a>'
				+ '</li>' 
				+ '<li title="跳转至第一页" class="page_count">'
				+ '<a href="javascript:getContentAsJSON(1);">1</a>' + '</li>'
				+ '<li title="" class="page_count">' + '...' + '</li>';
	}
	text += '<li title="当前所在页" class="page_count">' + curPage + '</li>';

	if (curPage != totalPage) {
		text += '<li title="" class="page_count">...</li>'
				+ '<li title="跳转至最后一页" class="page_count">'
				+ '<a href="javascript:getContentAsJSON('+totalPage+');">'
				+ totalPage + '</a>' + '</li>'
				+ '<li title="跳转至第 '+nextPage+' 页" class="page_count">'
				+ '<a href="javascript:getContentAsJSON('+nextPage+');">下一页&gt;' + '</a>'
				+ '</li>';
	}
	text += '</ul>' + '</div>';
	content.innerHTML = text;
}