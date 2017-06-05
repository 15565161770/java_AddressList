//当鼠标放在客户名文本框时，给出一个提示文本
function nameFocus() {
	var nameId = document.getElementById("nameId");
	nameId.innerHTML = "请输入客户真实姓名";
}
//当鼠标离开客户名文本框时，给出一个文本提示
function nameBlur() {
	var name = document.getElementById("name");
	var nameId = document.getElementById("nameId");
	var reg= /^[\u4e00-\u9fa5]+$/;
	if(name.value == ""){
		nameId.innerHTML = "<font color='red'>联系人名不能为空</font>";
		return false;
	}
	if(reg.test(name.value) == false){
		nameId.innerHTML = "<font color='red'>联系人名只能输入中文简体汉字</font>";
		return false;
	}
	nameId.innerHTML = "<font color='green'>联系人名输入正确</font>";
	return true;
	
}
//当鼠标放在客户名文本框时，给出一个提示文本
function telFocus() {
	var telId = document.getElementById("telId");
	telId.innerHTML = "请输入手机号码";
}

//当鼠标离开客户名文本框时，给出一个文本提示
function telBlur() {
	var tel = document.getElementById("tel");
	var telId = document.getElementById("telId");
	var reg= /^(13|15|17|18)\d{9}$/;
	if(tel.value == ""){
		telId.innerHTML = "<font color='red'>手机号码不能为空</font>";
		return false;
	}
	if(reg.test(tel.value) == false){
		telId.innerHTML = "<font color='red'>手机号码输入不正确</font>";
		return false;
	}
	telId.innerHTML = "<font color='green'>手机号码输入正确</font>";
	return true;
	
}

//表单提交时验证输入内容的有效性
function checkForm() {
	var flagname = nameBlur();
	var flagtel = telBlur();
	if(flagname == true &&  flagtel == true ){
		return true;
	}else{
		alert("失败，请按提示输入信息 ！")
		return false;
	}
	
	
}
