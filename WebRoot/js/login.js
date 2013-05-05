function nameCheck(){
	var name = document.getElementById("name").value;
	if (name == "" || name == " ") {
		alert("用户名不能为空");
		document.getElementById("name").focus();
		return false;	
	}
	return true;
}

function passwordCheck(){
	var password = document.getElementById("password").value;
	if (password == "" || password == " ") {
		alert("密码不能为空");
		document.getElementById("password").focus();
		return false;
	}
	return true;
}

function checkAll(){
	if(!passwordCheck() || !nameCheck())
		return false;
	return true;
}