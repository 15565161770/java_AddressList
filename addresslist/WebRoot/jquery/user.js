//当鼠标放在客户名文本框时，给出一个提示文本
function nameFocus() {
	var nameId = document.getElementById("nameId");
	nameId.innerHTML = "请输入注册名";
}
//当鼠标离开客户名文本框时，给出一个文本提示
function nameBlur() {
	var name = document.getElementById("name");
	var nameId = document.getElementById("nameId");
	var reg= /^[\u4e00-\u9fa5]+$/;
	if(name.value == ""){
		nameId.innerHTML = "<font color='red'>注册名不能为空</font>";
		return false;
	}
	if(reg.test(name.value) == false){
		nameId.innerHTML = "<font color='red'>注册名只能输入中文简体汉字</font>";
		return false;
	}
	nameId.innerHTML = "<font color='green'>注册名输入正确</font>";
	return true;
	
}
//当鼠标放在客户名文本框时，给出一个提示文本
function pwdFocus() {
	var pwdId = document.getElementById("pwdId");
	pwdId.innerHTML = "请输入密码";
}
//当鼠标离开客户名文本框时，给出一个文本提示
function pwdBlur() {
	var pwd = document.getElementById("pwd");
	var pwdId = document.getElementById("pwdId");
	if(pwd.value == ""){
		pwdId.innerHTML = "<font color='red'>密码不能为空</font>";
		return false;
	}
	nameId.innerHTML = "<font color='green'>密码输入正确</font>";
	return true;
	
}
//表单提交时验证输入内容的有效性
function checkForm() {
	var flagname = nameBlur();
	var flagpwd = pwdBlur();
	if(flagname == true &&  flagpwd == true ){
		return true;
	}else{
		alert("失败，请按提示输入信息 ！")
		return false;
	}
}