//***************************************************
//鼠标放在某个控件上面就会有提示,要求这个控件设置有title
//
//
//
//***************************************************

var pltsPop = null;
var pltsoffsetX = 10; // 弹出窗口位于鼠标左侧或者右侧的距离；3-12 合适 
var pltsoffsetY = 15; // 弹出窗口位于鼠标下方的距离；3-12 合适 
var pltsPopbg = "#FFFFEE"; //背景色 
var pltsPopfg = "#111111"; //前景色 
var pltsTitle = "";
document.write("<div id=pltsTipLayer style=\"display: none;position: absolute; z-index:10001\"></div>");
function pltsinits() { 
document.onmouseover = plts;
document.onmousemove = moveToMouseLoc; 
}
function plts() {
	var o = event.srcElement;
	if (o.alt != null && o.alt != "") {
		o.dypop = o.alt;
		o.alt = "";
	}
	if (o.title != null && o.title != "") {
		o.dypop = o.title;
		o.title = "";
	}
	pltsPop = o.dypop;
	if (pltsPop != null && pltsPop != "" & typeof (pltsPop) != "undefined") {
		pltsTipLayer.style.left = -1000;
		pltsTipLayer.style.display = "";
		var Msg = pltsPop.replace(/\n/g, "<br>");
		Msg = Msg.replace(/\0x13/g, "<br>");
		var re = /\{(.[^\{]*)\}/ig;
		if (!re.test(Msg)) {
			pltsTitle = "<font color=#ff0000>\u6570\u636e\u9a8c\u8bc1</font>";
		} else {
			re = /\{(.[^\{]*)\}(.*)/ig;
			pltsTitle = Msg.replace(re, "$1") + " ";
			re = /\{(.[^\{]*)\}/ig;
			Msg = Msg.replace(re, "");
			Msg = Msg.replace("<br>", "");
		}
		var attr = (document.location.toString().toLowerCase().indexOf("list.asp") > 0 ? "nowrap" : "");
		var content = "<table style=\"FILTER:alpha(opacity=90) shadow(color=#bbbbbb,direction=135);\" id=toolTipTalbe border=0><tr><td width=\"100%\"><table class=tableBorder7 cellspacing=\"1\" cellpadding=\"0\" style=\"width:100%\">" + "<tr id=pltsPoptop ><th height=18 valign=bottom class=th1 ><b><p id=topleft align=left><font color=#ffffff>\u2196</font>" + pltsTitle + "</p><p id=topright align=right style=\"display:none\">" + pltsTitle + "<font color=#ffffff>\u2197</font></b></th></tr>" + "<tr><td \"+attr+\" class=tablebody7 style=\"padding-left:14px;padding-right:14px;padding-top: 6px;padding-bottom:6px;line-height:135%\">" + Msg + "</td></tr>" + "<tr id=pltsPopbot style=\"display:none\"><th height=18 valign=bottom class=th1><b><p id=botleft align=left><font color=#ffffff>\u2199</font>" + pltsTitle + "</p><p id=botright align=right style=\"display:none\">" + pltsTitle + "<font color=#ffffff>\u2198</font></b></th></tr>" + "</table></td></tr></table>";
		pltsTipLayer.innerHTML = content;
		toolTipTalbe.style.width = Math.min(pltsTipLayer.clientWidth, document.body.clientWidth / 2.2); 
		moveToMouseLoc(); 
		return true;
	} else {
		pltsTipLayer.innerHTML = "";
		pltsTipLayer.style.display = "none";
		return true;
	}
}

function moveToMouseLoc() {
	if (pltsTipLayer.innerHTML == "") {
		return true;
	}
	var MouseX = event.x;
	var MouseY = event.y; 
	var popHeight = pltsTipLayer.clientHeight;
	var popWidth = pltsTipLayer.clientWidth;
	
	if (MouseY + pltsoffsetY + popHeight > document.body.clientHeight) {
		popTopAdjust = -popHeight - pltsoffsetY * 1.5;
		pltsPoptop.style.display = "none";
		pltsPopbot.style.display = "";
	} else {
		popTopAdjust = 0;
		pltsPoptop.style.display = "";
		pltsPopbot.style.display = "none";
	}
	if (MouseX + pltsoffsetX + popWidth > document.body.clientWidth) {
		popLeftAdjust = -popWidth - pltsoffsetX * 2;
		topleft.style.display = "none";
		botleft.style.display = "none";
		topright.style.display = "";
		botright.style.display = "";
	} else {
		popLeftAdjust = 0;
		topleft.style.display = "";
		botleft.style.display = "";
		topright.style.display = "none";
		botright.style.display = "none";
	}
	pltsTipLayer.style.left = MouseX + pltsoffsetX + document.body.scrollLeft + popLeftAdjust;
	pltsTipLayer.style.top = MouseY + pltsoffsetY + document.body.scrollTop + popTopAdjust;
	return true;
}
//pltsinits();//鼠标移动提示

//----------------------招聘信息DIV START -------------------
//document.write("<div id=promptDiv style=\"display: none;position: absolute; z-index:10002\"></div>");

document.write("<div id=promptDiv style=\"width:495px;height:auto !important; height:45px;margin:0px;padding:0px 0px 0px 0px;background-image: url(../work/images/wordbluemiddle.gif);" +
		"background-repeat: repeat-y;display: none;position: absolute; z-index:10003\"></div>");
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

//显示招聘信息(传过来的areaSection没有用到！！)
function showEnterpriseWorkPrompt(workTime,enducation,personNum ,areaSection,remark) {
	if(workTime == null || workTime == '') workTime = '不限';
	if(enducation == null || enducation == '') enducation = '不限';
	if(areaSection == null || areaSection == '') areaSection = '不限定区域';
	if(personNum == null || personNum == '') 
		personNum = '若干';
	else
		personNum = personNum +'人';
	
	if(remark == null || remark == '') remark = "";
	 var regR = /[\r]/g;
	  var regN = /[\n]/g;
	  remark = remark.replace(/[；]/g,"；<br />");
	  //remark = remark.replace(regN,"");
	if(remark.length > 101){
		remark = remark.substring(0,100)+"...";
	}
	
	var o = event.srcElement;
	if (o != null && o != "" && typeof (o) != "undefined") {
		promptDiv.style.left = -1000;
		//var content = "<span class=\"hc\"><table cellpadding=\"0\" cellspacing=\"0\" ><tr ><td width=\"50%\">工作年限："+workTime +
		//		"</td><td width=\"50%\">学历要求："+enducation+"</td></tr><tr><td colspan=\"2\">工作区域：广州-"+areaSection+"</td></tr>"+
		//		"</table>"+remark+"</span>";
		/*
		var content = "<div style=\"margin:0px;padding:0px 0px 0px 0px;background-image: url("+realPath+"/work/images/wordbluemiddle.gif);" +
		"background-repeat: repeat-y\"><div style=\"width:495px;height:100%;margin:0px;padding:0px 0px 0px 0px;" +
		"background-image: url("+realPath+"/work/images/wordbluebottom.gif);background-repeat: no-repeat;background-position: left bottom;\"  >" +
		"<div style=\"width:495px;height:100%;margin:0px;padding:15px 15px 15px 25px;background-image: url("+realPath+"/work/images/wordblue.gif);background-repeat: no-repeat;background-position: left top;\">" 
		+"<table width=\"100%\"  cellpadding=\"3\" cellspacing=\"3\" style=\"font-size:14px;color:#666666;line-height: 150%;\" ><tr><td width=\"50%\">工作年限："+workTime +
		"</td><td width=\"50%\">学历要求："+enducation+"</td></tr><tr><td colspan=\"2\">招聘人数："+personNum+"</td></tr><tr><td colspan=\"2\">岗位要求：</td></tr>"
		+"<tr><td colspan=\"2\" style=\"background-color:#F4F8FF;\">"+remark+"</td></tr></table></div></div></div>"
		*/
		var xy = getXY(o);
		var content = "<div style=\"margin:0px;padding:0px 0px 0px 0px;background-image: url("+realPath+"/work/images/wordbluemiddle.gif);background-repeat: repeat-y;\">"+
		"<div id=\"jiantou\" style=\"width:13px; height:17px; margin:0px; padding:0px; position: absolute; top:40px; left:2px;\"><img src=\""+realPath+"/work/images/jiantou.gif\"/></div>"+
		"<div style=\"width:495px;height:100%;margin:0px;padding:0px 0px 0px 0px;background-image: url("+realPath+"/work/images/wordbluebottom.gif);background-repeat: no-repeat;background-position: left bottom;\">"+
		"<div style=\"width:495px;height:100%;margin:0px;padding:15px 15px 15px 20px;background-image:url("+realPath+"/work/images/wordblue.gif);background-repeat: no-repeat;background-position: left top;\">"
		+"<table width=\"95%\"  cellpadding=\"3\" cellspacing=\"3\" style=\"font-size:14px;color:#666666;line-height: 150%;\" ><tr><td width=\"50%\">工作年限："+workTime +
		"</td><td width=\"50%\">学历要求："+enducation+"</td></tr><tr><td colspan=\"2\">招聘人数："+personNum+"</td></tr><tr><td colspan=\"2\">岗位要求：</td></tr>"
		+"<tr><td colspan=\"2\" style=\"background-color:#F4F8FF;\">"+remark+"</td></tr></table></div></div></div>"
		promptDiv.innerHTML = content;
		promptDiv.style.display = "";
		//alert(xy.y+','+document.body.scrollTop+','+document.body.clientHeight+','+document.body.scrollHeight+','+promptDiv.offsetHeight);	
		var jantouTop = (xy.y-document.body.scrollTop)/document.body.clientHeight*promptDiv.offsetHeight;
		if (jantouTop+document.getElementById("jiantou").offsetHeight>promptDiv.offsetHeight)
			jantouTop = promptDiv.offsetHeight-document.getElementById("jiantou").offsetHeight-3;
		document.getElementById("jiantou").style.top = jantouTop;//箭头的位置
		promptDiv.style.left = xy.x+o.offsetWidth;
		promptDiv.style.top = xy.y-jantouTop;
	} else {
		promptDiv.innerHTML = "";
		promptDiv.style.display = "none";
	}
}

//关闭招聘信息
function hideEnterpriseWorkPrompt(){
		promptDiv.innerHTML = "";
		promptDiv.style.display = "none";
}


//显示发票申请信息
function showInvoiceApplyPromt(srcElem,amount,companyName,postAddress,zipCode,phten,telphome,addressee,note){
	if(amount == null || amount == '') amount = '';
	if(companyName == null || companyName == '') companyName = '';
	if(postAddress == null || postAddress == '') postAddress = '';
	if(zipCode == null || zipCode == '') zipCode = '';
	if(phten == null || phten == '') phten = '';
	if(telphome == null || telphome == '') telphome = '';
	if(addressee == null || addressee == '') addressee = '';
	if(note == null || note == '') note = '';
	//alert(amount+"|"+companyName+"|"+postAddress+"|"+zipCode+"|"+phten+"|"+telphome+"|"+addressee+"|"+note);
	
	//var o = event.srcElement;//不能兼容火狐
	var o = srcElem;//firefox用不了event，兼容火狐
	
	if (o != null && o != "" && typeof (o) != "undefined") {
		promptDiv.style.left = -1000;
		var xy = getXY(o);
		
		//内容
		var content = '<div style="border:0px solid red;margin: 0px; padding: 0px; background-image: url('+realPath+'/work/images/wordbluemiddle.gif); background-repeat: repeat-y;">'
		+'<div id="jiantou" style="border:0px solid green;width: 13px; height: 17px;position: absolute; top: 40px; left: 2px;"><img src="'+realPath+'/work/images/jiantou.gif" /></div>'
		+'<div style="border:0px solid blue;width: 495px; height: 100%;background-image: url('+realPath+'/work/images/wordbluebottom.gif); background-repeat: no-repeat; background-position: left bottom;">'
		+'<div style="border:0px solid pink;width: 495px; height: 100%;padding: 15px 15px 15px 20px; background-image: url('+realPath+'/work/images/wordblue.gif); background-repeat: no-repeat; background-position: left top;">'
		+'<table width="95%" cellpadding="3" cellspacing="3" style="font-size: 14px; color: #666666; line-height: 150%;">'
		+'<tr><td width="50%">发票金额：'+amount+'</td><td width="50%">发票抬头：'+companyName+'</td></tr>'
		+'<tr><td>邮编：'+zipCode+'</td><td>电话：'+phten+'</td></tr>'
		+'<tr><td>手机：'+telphome+'</td><td>收件人：'+addressee+'</td></tr>'
		+'<tr><td colspan="100%">发票地址：'+postAddress+'</td></tr>'
		+'<tr><td colspan="100%">备注：'+note+'</td></tr>'
		+'</table></div></div></div>';
		
		//alert(content);
		
		
		
		
		promptDiv.innerHTML = content;
		promptDiv.style.display = "";
		var jantouTop = (xy.y-document.body.scrollTop)/document.body.clientHeight*promptDiv.offsetHeight;
		if (jantouTop+document.getElementById("jiantou").offsetHeight>promptDiv.offsetHeight){
			jantouTop = promptDiv.offsetHeight-document.getElementById("jiantou").offsetHeight-3;
		}
		document.getElementById("jiantou").style.top = jantouTop;//箭头的位置
		promptDiv.style.left = xy.x+o.offsetWidth;
		promptDiv.style.top = xy.y-jantouTop;
	}else {
		promptDiv.innerHTML = "";
		promptDiv.style.display = "none";
	}
	
	
	
}

//关闭发票申请信息
function hideInvoiceApplyPromt(){
		promptDiv.innerHTML = "";
		promptDiv.style.display = "none";
}



//显示求职信息
function showUserInfoPrompt(workYear,slyBegin,slyEnd,age) {
	
	if(workYear == null || workYear==''){
		workYear='未登记  ';
	}else{
		workYear = workYear+" ";
	}
	if(age == null || age=='') age='未登记  ';
	var salary = '';
	if((slyBegin == null || slyBegin == '') && (slyEnd == null || slyEnd == '')){
		salary = '面议';
	}else if((slyBegin == null || slyBegin == '') && (slyEnd != null || slyEnd.Trim() != '')){
		salary = slyEnd+'以下';
	}else if((slyBegin != null || slyBegin != '') && (slyEnd == null || slyEnd.Trim() == '')){
		salary = slyBegin+'以上';
	}else{
		salary = slyBegin+ '-'+slyEnd;
	}
	    
	var o = event.srcElement;
	if (o != null && o != "" & typeof (o) != "undefined") {
		promptDiv.style.left = -1000;
		/*
		var content ="<div style=\"margin:0px;padding:0px 0px 0px 0px;background-image: url("+realPath+"/work/images/wordbluemiddle.gif);" +
		"background-repeat: repeat-y\"><div style=\"width:495px;height:100%;margin:0px;padding:0px 0px 0px 0px;" +
		"background-image: url("+realPath+"/work/images/wordbluebottom.gif);background-repeat: no-repeat;background-position: left bottom;\"  >" +
		"<div style=\"width:495px;height:100%;margin:0px;padding:15px 15px 15px 20px;background-image: url("+realPath+"/work/images/wordblue.gif);background-repeat: no-repeat;background-position: left top;\">" 
		+" <table width=\"100%\" cellpadding=\"3\" cellspacing=\"3\" style=\"font-size:14px;color:#666666;line-height: 150%;\" ><tr ><td width=\"50%\">工作年限："+workYear +
				"</td><td width=\"50%\">年龄："+age+"</td></tr><tr><td colspan=\"2\">薪资要求："+salary+
				"</td></tr></table></div></div></div>"
		*/
		
		var xy = getXY(o)
		var content = "<div style=\"margin:0px;padding:0px 0px 0px 0px;background-image: url("+realPath+"/work/images/wordbluemiddle.gif);background-repeat: repeat-y;\">"+
		"<div id=\"jiantou\" style=\"width:13px; height:17px; margin:0px; padding:0px; position: absolute; top:40px; left:2px;\"><img src=\""+realPath+"/work/images/jiantou.gif\"/></div>"+
		"<div style=\"width:495px;height:100%;margin:0px;padding:0px 0px 0px 0px;background-image: url("+realPath+"/work/images/wordbluebottom.gif);background-repeat: no-repeat;background-position: left bottom;\">"+
		"<div style=\"width:495px;height:100%;margin:0px;padding:15px 15px 15px 20px;background-image:url("+realPath+"/work/images/wordblue.gif);background-repeat: no-repeat;background-position: left top;\">"
		+" <table width=\"100%\" cellpadding=\"3\" cellspacing=\"3\" style=\"font-size:14px;color:#666666;line-height: 150%;\" ><tr ><td width=\"50%\">工作年限："+workYear +
				"</td><td width=\"50%\">年龄："+age+"</td></tr><tr><td colspan=\"2\">薪资要求："+salary+
				"</td></tr></table></div></div></div>"
		promptDiv.innerHTML = content;
		promptDiv.style.display = "";	
		var jantouTop = (xy.y/document.body.scrollWidth*promptDiv.offsetHeight);
		document.getElementById("jiantou").style.top = jantouTop;//箭头的位置
		promptDiv.style.left = xy.x+o.offsetWidth;
		promptDiv.style.top = xy.y-jantouTop;
	} else {
		promptDiv.innerHTML = "";
		promptDiv.style.display = "none";
	}
}
//关闭招聘信息
function hideUserInfoPrompt(){
		promptDiv.innerHTML = "";
		promptDiv.style.display = "none";
}
//----------------------招聘信息DIV END -------------------

//--------显示工种信息 start ----------------------------------------------------
function showWorkType(objId){//objId为div要显示在哪一个控件下方
	if ($("#workType").css("display") == "none") {
		var obj = document.getElementById(objId);
		var xy = getXY(obj);
		var x = xy.x ;
		var y = xy.y + obj.offsetHeight;
		var $workType = $('#workType');//这个为定义的工种div
		$workType.css('top',y);
		$workType.css('left',x);
		$workType.show();
	} else {
		$("#workType").hide();
	}
}
//--------显示工种信息 end-------------------------------------------------------
/*用户中心显示和展开菜单*/
function displayOrNot(which, id) {
 	var menu = document.getElementById(which + id);
 	if('none' == menu.style.display) {
 		menu.style.display = '';
 	}
 	else {
 		menu.style.display = 'none';
 	}
}
function joke() {
	alert("期待中...");
	alert("准备在答辩100分后添加...");
	alert("亲，给个满分吧亲...");
	alert("求满分...");
	alert("唉...放过你吧...");
	alert("你把我灌醉，你让我流泪...");
	alert("嗯~~");
}


