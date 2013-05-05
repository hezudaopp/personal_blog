function nameCheck(){
	var name = document.getElementById("name").value;
	if (name == "" || name == " ") {
		document.getElementById("nameMsg").innerHTML="<font color='red'>用户名不能为空</font>";
		return false;	
	}else{
		document.getElementById("nameMsg").innerHTML = "";
	}
	validate();
	return true;
}

function passwordCheck(){
	var password = document.getElementById("password").value;
	var confirm = document.getElementById("confirm").value;
	if (password == "" || password == " ") {
		document.getElementById("passwordMsg").innerHTML="<font color='red'>密码不能为空</font>";
		return false;
	}else{
		document.getElementById("passwordMsg").innerHTML="";
	}
	if (password != confirm) {
		document.getElementById("confirmMsg").innerHTML="<font color='red'>两次输入密码不同</font>";
		return false;
	}else{
		document.getElementById("confirmMsg").innerHTML="";
	}
	return true;
}

function nicknameCheck(){
	var nickname = document.getElementById("nickname").value;
	if (nickname == "" || nickname == " ") {
		document.getElementById("nicknameMsg").innerHTML="<font color='red'>昵称不能为空</font>";
		return false;
	}else{
		document.getElementById("nicknameMsg").innerHTML="";
	}
	return true;
}

function checkAll(){
	if(!nameCheck() || !passwordCheck() || !nicknameCheck())
		return false;
	return true;
}

function checkAllExceptName(){
	if(!passwordCheck() || !nicknameCheck())
		return false;
	return true;
}

var xmlhttp = false;
function createXMLHttpRequest(){
   if(window.ActiveXObject){
     xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
   }
   else if(window.XMLHttpRequest){
     xmlhttp=new XMLHttpRequest();
   }
} 

function validate(){
     createXMLHttpRequest();
     if(!xmlhttp){
    	 window.alert("不能创建XMLHttpRequest对象实例.");
    	 return false;
     }
     var name = document.getElementById("name").value;
     var url = "CheckName?name="+name;
     xmlhttp.open("POST", url, true);
     xmlhttp.onreadystatechange = processResponse;
     xmlhttp.send(null);
} 

function processResponse(){
     if(xmlhttp.readyState == 4){
         if (xmlhttp.status == 200){
        	 var response = xmlhttp.responseText.replace(/(^\s*)|(\s*$)/g, "");
             if (response == 1){
                 document.getElementById("nameMsg").innerHTML="<font color='red'>用户名已存在</font>";
             }else{
                 document.getElementById("nameMsg").innerHTML="<font color='green'>用户名没有被使用,你可以使用注册</font>";
             }
         }
     }
}
