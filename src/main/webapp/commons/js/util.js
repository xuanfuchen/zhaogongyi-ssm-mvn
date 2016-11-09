/*-----------------------自定义js的String对象的新方法 START------------------------------------------*/
String.prototype.Trim = function () {// 去掉空格
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
String.prototype.LTrim = function () {
	return this.replace(/(^\s*)/g, "");
};
String.prototype.RTrim = function () {
	return this.replace(/(\s*$)/g, "");
};

//改写alert方法【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】

/*-----------------------自定义js的String对象的新方法 END----------------------------------------------*/

/*---------------------------------检查字段 START---------------------------------------------------*/
function validateCheck(srcEle) {//在提交的时候检查有没有验证没有通过的
	//验证input标签
	var inputArr = srcEle.getElementsByTagName("input");
	for (var i = 0; i < inputArr.length; i++) {
		if (inputArr[i].checkResult == false) {//如果单个验证没有通过就不通过
			inputArr[i].focus();//focus再blur，为了不focus时弹出的div挡住红叉叉提示	
			inputArr[i].blur();
			return false;
		}
		if (!validSingleValue(inputArr[i])) {
			inputArr[i].focus();	
			inputArr[i].blur();	
			return false;
		}
  }
	 
	//验证textarea标签
	var textareaArr = srcEle.getElementsByTagName("textarea");
	for (var i = 0; i < textareaArr.length; i++) {
	  	if (textareaArr[i].checkResult == false) {//如果单个验证没有通过就不通过
			textareaArr[i].focus();	
			textareaArr[i].blur();	
			return false;
		}
		if (!validSingleValue(textareaArr[i])) {
			textareaArr[i].focus();
			textareaArr[i].blur();
			return false;
		}
	}	
	return true;
}

// 验证单个值(单个input或单个textarea)
function validSingleValue(srcEle) {
	var result = true;
	var className = $(srcEle)[0].className;
	if (className.indexOf("notNull") != -1) {
		result = notNull(srcEle.value);
		if (!result) {
			return result;
		}
	}
	if (className.indexOf("isInt") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是整数,如果要求不能为空请用.notNull
			result = checkInt(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isAge") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是年龄,如果要求不能为空请用.notNull
			result = ageCheck(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isEmail") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是邮箱地址,如果要求不能为空请用.notNull
			result = emailCheckWithValue(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isMobile") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是手机号码,如果要求不能为空请用.notNull
			result = mobileCheck(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isTelephone") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是座机号码,如果要求不能为空请用.notNull
			result = telephoneCheck(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isPhone") != -1) {
		if (notNull(srcEle.value)){//如果不为空才会判断是不是电话号码(包括手机和座机),如果要求不能为空请用.notNull
			if (!telephoneCheck(srcEle.value) && !mobileCheck(srcEle.value)){
				result = false;
				return result;
			}
		}
	}
	if (className.indexOf("isPassword") != -1) {//写了这个就是必填的
		result = passwordCheck(srcEle);
		if (!result) return result;
	}
	
	//【使用方法，在密码确认第二次输入的class中放入，例如class="sameAs(be_compared_elem_id_without_quot_or_double_quot)"】
	if (className.indexOf("sameAs(") != -1) {// 用于判断当前元素value和指定id的value相同
		result = sameAs(srcEle, className);
		if (!result) return result;
	}
	
	if (className.indexOf("isSalary") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是工资,如果要求不能为空请用.notNull
			result = checkSalary(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isAbc123") != -1) {
		if (notNull(srcEle.value)) {//如果不为空才会判断是不是字母数字类型,如果要求不能为空请用.notNull
			result = checkLettersNumbers(srcEle.value);
			if (!result) return result;
		}
	}
	if (className.indexOf("isHireNum") != -1) {
		if (notNull(srcEle.value) && srcEle.value != "若干") {//如果不为空才会判断是不是字母数字类型,如果要求不能为空请用.notNull
			result = checkInt(srcEle.value);
			if (result == true && parseInt(srcEle.value.Trim()) >= 1) {
				return true;
			} else  {
				return false;
			}
		}
	}
	return result;
}

//不能为空验证
function notNull(value) {
	if ("" == value.Trim())
		return false;
	else
		return true;
}
//判断是否为整数
function checkInt(value) {
	if (/^(\+|-)?\d+$/.test(value)) {
		return true;
	} else {
		return false;
	}
}
//年龄的验证
function ageCheck(_v) {
  if (/^\d+$/.test(_v)) {
   var _age = parseInt(_v);
   if (15< _age && _age < 81)
    return true;
   else
   	return false;
  } else
   return false;
}
//验证email
function emailCheckWithValue(value) {
	var p = /^([a-zA-Z0-9._-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	if (!p.exec(value) && "" != value.Trim()) {
		return false;
	}else{
		return true;		
	}
}
//手机号码验证
function mobileCheck(_v) {
	return /^1[358][0-9]\d{8}$/.test(_v);
}
//电话号码验证
function telephoneCheck(value) {
	return /(^\d{3,4}\-\d{7,8}$)|(^\d{3,4}\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}\-\d{7,8}\-\d{1,5}$)|(^\d{3,4}\d{7,8}\-\d{1,5}$)|(^\d{3,4}\d{7,8}\-\d{1,5}$)/.test(value);
}
//密码格式判断
function passwordCheck(srcEle) {
	if (!notNull(srcEle.value)) {//不允许不填
		return false;
	}
	if (srcEle.value.Trim().length < 6) {//密码长度
		return false;
	}
	return true;
}
function sameAs(srcEle, curElemClassName) {
	if (!notNull(srcEle.value)) {//不允许不填
		return false;
	}
	var index = curElemClassName.indexOf("sameAs(");
	curElemClassName = curElemClassName.substring(index, curElemClassName.length);
	var start = curElemClassName.indexOf("(");
	var end = curElemClassName.indexOf(")");
	var compareElemId = curElemClassName.substring(start + 1, end);
	var compareElemVal = document.getElementById(compareElemId).value.Trim();
	if (srcEle.value.Trim() == compareElemVal) {
		return true;
	} else {
		return false;
	}
}

//检查工资的范围
function checkSalary(value) {
	if (checkInt(value)){//
		if(1 < parseInt(value) && parseInt(value) < 25000)//工资要求在1-25000之间
			return true;
		else
			return false;
	}else{//如果不为数字
		return false;
	}
}
//验证ID是否合法
function checkLettersNumbers(value) {
	return /^[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9_]*$/.test(value.Trim());
}
//判断是否为浮点数
function checkFloat(obj) {
	if (/^(\+|-)?\d+($|\.\d+$)/.test(obj.val())) {
		return true;
	} else {
		return false;
	}
}
//检查是否为日期格式
function checkDate(value) {
  var ret;
  var reg = new RegExp("^([1-9]{1}[0-9]{1,3})\-[0-9]{1,2}\-[0-9]{1,2}$","g");
  if (reg.test(value)) {
    ret = true;
  } else {
    ret = false;
  }
  return ret;
}
//检查是否为浮点数
function checkDouble(value) {
  if (value == null || value.length == 0)
    return false;

  var ret;
  var reg = new RegExp("^[0-9]+(\.[0-9]+)?$","g");//"^[0-9]*\.?{0,1}[0-9]*$","g");
  if (reg.test(value)) {
    ret = true;
  } else {
    ret = false;
  }
  return ret;
}
/*---------------------------------检查字段 END------------------------------------------------------*/


/*---------------------------------对比时间 START-------------------------------------------------------*/
//转换字符串成Date类型
function stringToDate(strDate){
	return new Date(Date.parse(strDate.replace(/-/g,"/")));
}
//比较时间(时间是由页面的js时间控件传入的字符串)
function compareDate(beginDateElem,endDateElem){
	if(beginDateElem && endDateElem){
		if(stringToDate(beginDateElem.value)>stringToDate(endDateElem.value)){
			alert("末尾时间比开始时间小！！");
			return false;
		}
	}
	return true;
}
/*---------------------------------对比时间 END-------------------------------------------------------*/


/*----------------check box相关 START-------------------------------------------------------*/
//obj为this
//name为checkbox的name
function cbCheck(obj, name) {
	var cbGroup = $("input[name=" + name + "]");
	var headCb = $(obj);
	var length = cbGroup.length;
	for (var i = 0; i < length; i++) {
		var cbx = $(cbGroup.get(i));
		cbx.attr("checked", headCb.attr("checked"));
	}
}
//用元素的id属性去实现不更好?把元素的name属性解放出来给request.getParameterValues("xxxxx")提供"固定的值"，较便利(适合嵌套checkbox)
function cbCheckById(obj, chkbx_id) {
	var cbGroup = $("input[id=" + chkbx_id + "]");
	var headCb = $(obj);
	var length = cbGroup.length;
	for (var i = 0; i < length; i++) {
		var cbx = $(cbGroup.get(i));
		cbx.attr("checked", headCb.attr("checked"));
	}
}
//判断是否有选中checkbox(兼容webkit)
function hasCheck(name) {
	var flag = false;
	var len = 0;
	var chkboxes = document.getElementsByName(name);
	if(chkboxes){
		for(var i=0;i<chkboxes.length;i++){
			if(chkboxes[i].checked){
				len++;
			}
		}
	}
	if(len==0){
		showMsg("请先选择记录！");
	}else{
		flag = true;
	}
	return flag;
}
//check box 封装已被选的
function capsuCheckedChkBox(chkbox_name){
	var chkboxes = document.getElementsByName(chkbox_name);
	var temp = "";
	for(var i=0;i<chkboxes.length;i++){
		if(chkboxes[i].checked){
			temp += chkboxes[i].value + ";";
		}
	}
	return temp;
}
/*----------------check box相关 END-------------------------------------------------------*/


/*-----------------打开窗口 START---------------------------------------------------*/
/**
 * <description> 打开模式对话框

 * url 超链地址
 * w 宽度
 * h 高度
 * r 是否可设置大小 'yes' or 'no'
 */
function showMd(url, w, h, s, r) {
	var scroll = s == undefined ? "no" : s;
	var resize = r == undefined ? "yes" : r;
	var property = "dialogHeight:" + h + "px;dialogWidth:" + w + "px;resizable:" + resize + ";help:no;status:no;scroll:" + scroll;
	return window.showModalDialog(url, window, property);
}
/**
 * <description> 打开非模式窗口

 * url 超链地址
 * w 宽度
 * h 高度
 * s 是否显示滚动条

 * r 是否可设置大小 'yes' or 'no'
 */
function openWin(url, w, h, s, r) {
	var scroll = s == undefined ? "no" : s;
	var resize = r == undefined ? "yes" : r;
	var browserheight = $(window).height();//浏览器高度
	var browserwidth = $(window).width();//浏览器宽度
	var property = "width=" + w + ",height=" + h + ",left=" + (browserwidth - w) / 2 + ",top=" + (browserheight - h) / 2 + ",resizable=" + resize + ",scrollbars=" + scroll;
	window.open(url, "", property);
}
/*-----------------打开窗口 END---------------------------------------------------*/


/*--------------------------------popup提示 START------------------------------------------*/
document.write("<div id=messageDiv style=\"width: 287px;margin: 0px; padding: 0px 0px 0px 0px; background-image: url(" + _contextPath + "/commons/images/common/tishi/tishi-middle.jpg); background-repeat: repeat-y; display: none; position: absolute; z-index: 10003\"></div>");
function getXY(Obj) {//取元素的位置
	var sumTop = 0, 
	sumLeft = 0;
	while(Obj != document.body){
		sumLeft += Obj.offsetLeft;
		sumTop += Obj.offsetTop;
		Obj = Obj.offsetParent;
		} 
		return {x:sumLeft, y:sumTop};
}
function chngBorderColorShowMsgDiv(title,message,srcElem){//change border color and show message div
	if(title.Trim()!="" || message.Trim()!=""){
		showMessageByDiv(title,message);
	}
	
	srcElem.style.borderColor='#D9E218';
	srcElem.style.borderWidth='1px';
	srcElem.style.borderStyle='solid';
}
function showMessageByDiv(title,message){
	if (title.Trim()=="" && message.Trim()=="")//都为空就退出
		return;
	var titleTr = "";
	var messageTr = "";
	if (title.Trim()!=""){//如果没有标题就不显示标题
		titleTr = "<tr><td valign='top'>"+title+"</td></tr>";
	}
	if (message.Trim()!=""){
		messageTr = "<tr><td style='font-size:13px;' valign='top' height:10px;	>"+message+"</td></tr></table>";
	}
	
	var tableStr = '<div style="width: 287px;margin: 0px; padding: 0px 0px 0px 0px; background-image: url(' + _contextPath + '/commons/images/common/tishi/tishi-bottom.jpg); background-repeat: no-repeat; background-position: left bottom;">' +
			'<div style="width: 287px;margin: 0px; padding: 5px 0px 5px 27px; background-image: url(' + _contextPath + '/commons/images/common/tishi/tishi-top.jpg); background-repeat: no-repeat; background-position: left top;">' +
			'<table width="100%" border="0" bordercolor="red" height="20">'+title + messageTr +'</table></div></div>';
	//tableStr = tableStr + title + messageTr;
	messageDiv.innerHTML = tableStr;
	var xy = getXY(event.srcElement);
	messageDiv.style.left = xy.x+event.srcElement.offsetWidth+5;
	messageDiv.style.top = xy.y-(-1);
	messageDiv.style.display = "block";
}
function chngBorderColorHideMsgDiv(srcElem){//srcElem事件源
	hideMessageByDiv();
	srcElem.style.borderWidth='1px';
	srcElem.style.borderColor='#d4d4d4';
	srcElem.style.borderStyle='solid';
}
function hideMessageByDiv(){
	messageDiv.innerHTML = "";
	messageDiv.style.display = "none";
}
/*--------------------------------popup提示 END------------------------------------------*/


/*---------------------AJAX验证 START--------------------------------------------------------------------------------------------------*/
//检查某个ID是否可用(使用jQuery的ajax)
/*
srcEle，传入this即可
req_url，不需要验证唯一性传入""，需要验证时传入语句
falseStr，验证失败提示语
falseStr2，可选参数，ajax验证失败后的提示语(有区分的必要)
asyn，可选参数，是否同步还是异步，默认true(异步)
*/
function checkId(srcEle, reg_url, targetId, falseStr, falseStr2, asyn) {
	var elm = document.getElementById(targetId);
	if (!validSingleValue(srcEle)) {//数据前台验证
		if (elm != null && typeof(elm) == 'object') {
			elm.innerHTML ='<img src="' + _contextPath + '/commons/images/common/noSmall.gif"><span style="font-size: 13px;color: red;">' + falseStr + '</span>';
		}
		srcEle.checkResult = false;//提交时要所有的验证
		return false;
	} else {
		srcEle.style.borderColor = "";
		srcEle.checkResult = true;//提交时要所有的验证
		if (elm != null && typeof(elm)=='object') {
			var className = $(srcEle)[0].className;
			if (className.indexOf("notNull") == -1 && srcEle.value.Trim() == ""){//没有为空的验证,而值又为空就说明是通过的,但是不能提示
				elm.innerHTML ='';
			}else{
				elm.innerHTML ='<img src="' + _contextPath + '/commons/images/common/yesBig.gif">';
			}
		}
		//return true;
	}
	
	if (reg_url.Trim() != "") {//有reg_url的时候才去服务器验证
		reg_url = reg_url.replace('#', srcEle.value.Trim());
		if(asyn == null || typeof(asyn) == "undefined") {
			asyn = true
		} else {
			asyn = false;
		}
		var url = reg_url;
		
		$.ajax({
			async:asyn,
			url:url,
			cache:false,
			dataType:"text",
			success:function(data) {
				if(data == "true") {
					if (elm != null && typeof(elm) == 'object') {
						elm.innerHTML ='<img src="' + _contextPath + '/commons/images/common/yesBig.gif">'
					}
					srcEle.checkResult = true;//提交时要所有的验证
					return true;
				} else {
					if (elm != null && typeof(elm) == 'object') {
						var hintStr = falseStr2 ? falseStr2 : falseStr;
						elm.innerHTML ='<img src="' + _contextPath + '/commons/images/common/noSmall.gif"><span style="font-size: 13px;color: red;">' + hintStr + '</span>';
					}
					srcEle.checkResult = false;	//提交时要所有的验证
					return false;
				}
			}//匿名内部类
		});
	}
	return true;
}
//在再次提交表单的时候验证帐号的唯一性
function reValidateUnique(srcEle, reg_url, targetId, falseStr) {
	var elm = document.getElementById(targetId);
	var reg_url = reg_url.replace('#',"'"+srcEle.value.Trim()+"'").Trim();
	var f = false;
	$.ajax({
		async:false,
		url:reg_url,
		cache:false,
		dataType:"text",
		success:function(data) {
			if(data != "true") {
				if (elm != null && typeof(elm) == 'object') {
					elm.innerHTML ='<img src="' + _contextPath + '/commons/images/common/noSmall.gif"><span style="font-size: 13px;color: red;">' + falseStr + '</span>';
				}
				srcEle.checkResult = false;	//提交时要所有的验证
				f = false;
			} else {
				f = true;
			}
		}//匿名内部类
	});
	return f;
}
/*---------------------AJAX验证 START--------------------------------------------------------------------------------------------------*/


function getElementsByClassName(className){
	var elements = $("input[class]");
	var result=[];
	for (var i=0;i<elements.length;i++){
		if(elements[i].className==className)
			result.push(elements[i]);
	}
	return result;
}