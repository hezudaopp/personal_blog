var xmlHttp;
	var pageMaxRows; //当前页行数
	var curPage; //当前页数
	var maxPage; //最大页数
	var maxRowCount; //最大行数
	var pagDiv;//div
	var pagTable;//table
	var pagTbody;//tbody
	var pagTbody1;//显示页数的tbody
	var pageTbody2;
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			xmlHttp = new XMLHttpRequest();
		}

	}
	//初始化
	function init() {
		pagDiv = document.getElementById("pagDiv1");
		pagTable = document.getElementById("pagTable");
		pagTbody = document.getElementById("pagTbody");
		pagTbody1 = document.getElementById("pageTbody1");
		pageTbody2 = document.getElementById("pageTbody2");
	}
	function getValue(page) {
		createXMLHttpRequest();
		//调用初始化
		init();
		var url = "Page?page=" + page;
		xmlHttp.open("post", url, true);
		xmlHttp.setRequestHeader("Context-type",
				"application/3-www-form-urlencoded");
		xmlHttp.onreadystatechange = call;
		xmlHttp.send(null);
	}
	function call() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				setValue(xmlHttp.responseXML);
			} else {
				alert(xmlHttp.status);
			}
		}

	}
	function setValue(xml) {
		var result = xml.getElementsByTagName("result");
		//当前页行数
		pageMaxRows = xml.getElementsByTagName("pageMaxRows")[0].firstChild.nodeValue;
		//得到当前页
		curPage = xml.getElementsByTagName("curPage")[0].firstChild.nodeValue;
		//得到最大页
		maxPage = xml.getElementsByTagName("maxPage")[0].firstChild.nodeValue;
		//得到最大行数
		maxRowCount = xml.getElementsByTagName("maxRowCount")[0].firstChild.nodeValue;
		if (result.length > 0) {
			//先清除所有的数据
			clearRow();
			clearRow1();
			clearRow2();

			//插入所有的数据
			for ( var i = 0; i < result.length; i++) {
				var rows = document.createElement("tr");
				rows.appendChild(createRow(result[i].childNodes[1].firstChild.nodeValue));
//				rows.appendChild(createRow(result[i].childNodes[2].firstChild.nodeValue));
//				rows.appendChild(createRow(result[i].childNodes[3].firstChild.nodeValue));
//				rows.appendChild(createRow(result[i].childNodes[4].firstChild.nodeValue));
				pagTbody.appendChild(rows);
				
				
			}

			var row = document.createElement("tr");
			//当前页行数
			var td = document.createElement("td");
			td.appendChild(document.createTextNode('每页' + pageMaxRows + '行'));
			row.appendChild(td);
			//得到当前页
			var td1 = document.createElement("td");
			td1.appendChild(document.createTextNode('第' + curPage + '页'));
			row.appendChild(td1);
			//得到最大页
			var td2 = document.createElement("td");
			td2.appendChild(document.createTextNode('共' + maxPage + '页'));
			row.appendChild(td2);
			//得到最大行数
			var td3 = document.createElement("td");
			td3.appendChild(document.createTextNode('共' + maxRowCount + '行'));
			row.appendChild(td3);
			//加进去
			pagTbody1.appendChild(row);

			var pagerow = document.createElement("tr");

			if (parseInt(curPage) == 1) {
				var td = document.createElement("td");
				td.appendChild(document.createTextNode("首页"));
				var td1 = document.createElement("td");
				td1.appendChild(document.createTextNode("上一页"));
				pagerow.appendChild(td);
				pagerow.appendChild(td1);

			} else {
				//首页
				var td = document.createElement("td");
				var a = document.createElement("a");
				a.onclick = function() {
					getValue(1);
				}
				a.appendChild(document.createTextNode("首页"))
				td.appendChild(a);
				//上一页
				var td1 = document.createElement("td");
				var a1 = document.createElement("a");
				a1.onclick = function() {
					getValue(parseInt(curPage) - 1);
				}
				a1.appendChild(document.createTextNode("上一页"))
				td1.appendChild(a1);
				pagerow.appendChild(td);
				pagerow.appendChild(td1);
			}
			if (curPage == maxPage) {
				var td = document.createElement("td");
				td.appendChild(document.createTextNode("上一页"));
				var td1 = document.createElement("td");
				td1.appendChild(document.createTextNode("尾页"));
				pagerow.appendChild(td);
				pagerow.appendChild(td1);
			} else {
				//下一页
				var td = document.createElement("td");
				var a = document.createElement("a");
				a.onclick = function() {
					getValue(parseInt(curPage)+1);
				}
				a.appendChild(document.createTextNode("下一页"))
				td.appendChild(a);
				//尾页
				var td1 = document.createElement("td");
				var a1 = document.createElement("a");
				a1.onclick = function() {
					getValue(parseInt(maxPage));
				}
				a1.appendChild(document.createTextNode("尾页"))
				td1.appendChild(a1);
				pagerow.appendChild(td);
				pagerow.appendChild(td1);
			}
			pageTbody2.appendChild(pagerow);
		} else {
			alert('没有数据');
		}
	}
	//得到所有的列
	function createRow(cell) {

		var Cell = document.createElement("td");
		var text = document.createTextNode(cell);
		Cell.appendChild(text);
		return Cell;
	}
	//删除所有列数据显示区
	function clearRow() {
		if (pagTbody.hasChildNodes()) {
			for ( var i = pagTbody.childNodes.length - 1; i >= 0; i--) {
				pagTbody.removeChild(pagTbody.childNodes[i]);

			}
		}
	}
	//删除最大页数区
	function clearRow1() {
		if (pagTbody1.hasChildNodes()) {
			for ( var i = pagTbody1.childNodes.length - 1; i >= 0; i--) {
				pagTbody1.removeChild(pagTbody1.childNodes[i]);

			}
		}
	}
	//删除最大页数区上一页下一页区
	function clearRow2() {
		if (pageTbody2.hasChildNodes()) {
			for ( var i = pageTbody2.childNodes.length - 1; i >= 0; i--) {
				pageTbody2.removeChild(pageTbody2.childNodes[i]);

			}
		}
	}