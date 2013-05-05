var httpRequest = null;
var blogId = "";
function getCommentAsJSON(id, curPage) {

	blogId = id;
	var comment = document.getElementById("comment_list");
	comment.innerHTML = "Loading, please wait ...";
	var url = "CommentListByBlog?blogId=" + id + "&commentPage=" + curPage;

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

	var comment = document.getElementById("comment_list");

	// Since JSON is a subset of JavaScript, I am using
	// JavaScript is own compiler to parse JSON in one line!
	var jsonArray = eval("(" + jsonArrayString + ")");

	var curPage = jsonArray[jsonArray.length - 1].curPage;
	var prePage = curPage - 1;
	var nextPage = curPage + 1;
	var totalPage = jsonArray[jsonArray.length - 1].maxPage;

	var text = '<h2>Comment</h2><ul>';
	if(totalPage!=0){
		for ( var index = 0; index < jsonArray.length - 1; index++) {
			var commentDate = new Date(jsonArray[index].commentDate.time);
			var commentDateTime = commentDate.getFullYear() + "-"
					+ commentDate.getMonth() + "-" + commentDate.getDate() + " "
					+ commentDate.getHours() + ":" + commentDate.getMinutes() + ":"
					+ commentDate.getSeconds();
			text += '<li> <div id="commentlist"> <p> <span style="float:left;font-weight: bold;">';
			if (jsonArray[index].commentUser == null) {
				text += '匿名';
			} else {
				text += '<a href="BlogTitleList?userId=' + jsonArray[index].commentUser.userId + '">'+jsonArray[index].commentUser.userName+'</a>';
			}
			text += '</span><span style="float:right;"> '
					+ commentDateTime
					+ ' </span> </p>'
					+ '<div style="clear: both;font-size: 14px;line-height: 22px;margin-top: 9px;width: 100%;">'
					+ jsonArray[index].commentContent + '</div> </div> </li>';
		}
		text += '</ul>';
		// 分页界面代码
		text += '<div style="float: right; height: 21px; line-height: 21px; display: block; background: #fff; margin: 0px 2em 1em auto; overflow: hidden;">' + '<ul style="float: right; height: 100%; width:100%; list-style: none; margin: 0px;">';
		if (curPage != 1) {
			text += '<li class="page_count">'
					+ '<a href="javascript:getCommentAsJSON(' + blogId + ','
					+ prePage + ');">&lt;' + '上一页</a>' + '</li>'
					+ '<li title="跳转至第一页" class="page_count">'
					+ '<a href="javascript:getCommentAsJSON(' + blogId
					+ ',1);">1</a>' + '</li>' + '<li title="" class="page_count">'
					+ '...' + '</li>';
		}
		text += '<li title="当前所在页" class="page_count">' + curPage + '</li>';
	
		if (curPage != totalPage) {
			text += '<li title="" class="page_count">...</li>'
					+ '<li title="跳转至最后一页" class="page_count">'
					+ '<a href="javascript:getCommentAsJSON(' + blogId + ','
					+ totalPage + ');">' + totalPage + '</a>' + '</li>'
					+ '<li title="跳转至第 ' + nextPage + ' 页" class="page_count">'
					+ '<a href="javascript:getCommentAsJSON(' + blogId + ','
					+ nextPage + ');">下一页&gt;' + '</a>' + '</li>';
		}
		text += '</ul>' + '</div>';
	}else{
		text += '<div>暂时没有评论</div>';
	}
	comment.innerHTML = text;
}


