<%@ page pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户登录-<%=websiteName %></title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<style type="text/css">
	body {
		font-size: 12px;
		margin: 0px auto;
	}
	*{	
		margin: 0px auto;
		padding: 0px;
	}
	#cityname span {
		font: 24px/1.8 '微软雅黑','黑体',sans-serif;
		color: #666;
	}
	#cityname {
		position: absolute;
		border-left: #eaeaea 1px solid;
		padding-left: 15px;
		height: 39px;
		top: 50px;
		left: 268px;
	}
	#logintext {
		position: absolute;
		top: 70px;
	}
	#logintext a:link {
		margin: 0 14px;
		color: #666;
	}
	#logintext a:visited {
		margin: 0 14px;
		color: #666;
	}
	#logintext a:hover {
		margin: 0 14px;
		color: #e37a7a;
		text-decoration: underline;
	}
	a {
		text-decoration: none;
	}
	#login-header {
		position: relative;
		border-bottom-style: none;
		border-right-style: none;
		margin: 0px auto;
		border-top-style: none;
		border-left-style: none;
		overflow: hidden;
		text-align: left;
		z-index: -100;
		
	}
	.win900 {
		width: 998px;
	}
	
	#conleft {
		position: relative;
		padding-bottom: 0px;
		padding-left: 0px;
		width: 600px;
		padding-right: 0px;
		float: left;
		height: 380px;
		overflow: hidden;
		margin-bottom: 30px;
	} 
	#conright {
		position: relative;
		padding-bottom: 0px;
		line-height: 30px;
		padding-left: 0px;
		width: 317px;
		padding-right: 0px;
		float: right;
		padding-top: 0px;
		margin-bottom: 15px;
	}
	.scrool-bg {
		position: relative;
		/*
		padding-bottom: 10px;
		padding-left: 20px;
		padding-right: 20px;
		padding-top: 30px;
		*/
		border: 1px solid #D4D0C8;
		height: 380px;
	}
	.inp {
		border:#c8c8c8 1px solid;
		padding: 0px 3px; 
		line-height: 2;
		height: 30px;
		vertical-align: middle;
		margin-right: 3px;
	}
	.inw {
		width: 190px;
		font-size: 14px;
	}
	.loginbox {
		font: 12px/3 Tahoma,Helvetica,Arial,'宋体',sans-serif;
	}
	.loginbox table {
		border-style: none;
		width: 100%;
		border-collapse: collapse;
	}
	.loginbox table th {
		text-align: right;
		width: 53px;
		color: #666;
		font-size: 14px;
		font-weight: normal;
		padding-right: 10px;
		vertical-align: middle;
	}
	
	.btns {
		cursor: pointer;
		font-size: 14px;
		font-weight: bold;
		padding: 8px 20px;
		
	}
	span.reg-a a:link {
		margin: 0 4px;
		color: #666;
	}
	span.reg-a a:visited {
		margin: 0 4px;
		color: #666;
	}
	span.reg-a a:hover {
		margin: 0 4px;
		color: #666;
		text-decoration: underline;
	}
	img {
		vertical-align: middle;
		border-style: none;
	}
	.loginbox table td {
		padding: 8px 0px;
		margin-top: 10px;
		margin-bottom: 20px;
	}
	.sc {
		display: block;
	}
	.cb {
		width: 998px;
	}
	.login-welcome-bg {
		background-image: url("<%=path%>/commons/images/common/login-welcome-bg.jpg");
		z-index: -100;
	}
	.other-acct {
		margin-top: 20px;
		margin-left: 12px;
		text-align: center;
		color: #666;
	}
</style>

</head>
<body onload="document.getElementById('acctName').focus()">
	<%@ include file="/commons/jsp/header/header.jsp" %>
	<div style="text-align: center;">
	<div class="win900" style="margin: 0px auto;">
	<div id="login-header">
		
	</div>
	
	<div class="cb">
		<div id="conleft" class="login-welcome-bg">
			<div id="login-welcome-bg"></div>
		</div>
	
	<form id="frm" name="frm" method="post" action="<%=request.getContextPath() %>/" onsubmit="return false;">
		<div id="conright">
			<div class="scrool-bg">
				<div class="loginbox">
					<div class="sc" id="tipDiv"></div>
					<table>
						<tr>
							<td>&nbsp;</td>
							<td><label id="message"></label></td>
						</tr>
						<tr id="usernametr">
							<th>帐户名</th>
							<td><input class="inp inw c_ccc .notNull" type="text" id="acctName" size="20" 
							onfocus="cleanPrompt()"
							/></td>
						</tr>
						<tr id="passwordtr">
							<th>密　码</th>
							<td style=" padding-bottom:5px;">
								<input class="inp inw" id="password" type="password" style="margin-bottom:7px;" size="20" onpaste="return false" value=""
								onfocus="cleanPrompt()"
								/>
							</td>
						</tr>
						<%-- 
						<tr>
							<th>&nbsp;</th>
							<td>
								<input type="checkbox" style="vertical-align: middle;" id="autologin" value="on" name="remember" />
								<label class="logintip" for="coks">下次自动登录 (公共场所慎用)</label>
							</td>
						</tr> --%>
						<tr>
							<th>&nbsp;</th>
							<td style="padding:0;">
								<span class="butt" style="line-height:34px;">
								<input type="submit" name="btnSubmit" value="登录" class="btns" accesskey="l" id="btnSubmit" onclick="sumitForm()"/>
								</span><span class="reg-a"><a href="javascript:window.location.href='<%=path%>/reg/register'">免费注册</a>|<a href='javascript:alert("期待中...我们会尽快实现，<%=company %>")'>找回密码</a> </span>
							</td>
						</tr>
					</table>
				</div>
				<div class="other-acct">
					<span>使用QQ号码快速登录：</span>
					<a href="javascript:alert('此功能还在传说中...')"><img alt="使用QQ帐号登录" src="<%=path %>/commons/images/common/Connect_logo_3.png"/></a>
				</div>
			</div><!--scrool bg-->
			<div class="clear"></div>
		</div>
		<div class="c"></div>
	</div>
	
	<div style="clear: both	;padding-top:6px;width: 998px;border-top: 1px solid #B6D2E9;font-size:12px;font-family:'宋体';">
		<%@ include file="/commons/jsp/include/aboutus.jsp" %>
	</div>
	</div>
	</div>
</form>
<script type="text/javascript">
	function sumitForm() {
		var acctName = document.getElementById("acctName");
		var password = document.getElementById("password");
		var autologin = document.getElementById("autologin");
		if (acctName.value.Trim() == "") {
			alert("请填写帐户名！");
			acctName.value = "";
			acctName.focus();
			return false;
		}
		if (password.value.Trim() == "") {
			alert("请填写密码！");
			password.value = "";
			password.focus();
			return false;
		}
		var reqStr = _contextPath + '/reg/trylogin';
		var dataMap = {"acctName":$('#acctName').val(),"password":$('#password').val()};
		$.ajax({
			url:reqStr,
			method:"POST",
			cache:false,
			async:false,
			dataType:"text",
			data:dataMap,
			success:function(data){
				if(data == "NO_ACCT"){
					document.getElementById("message").innerHTML = '<img alt="错误" src="<%=path%>/commons/images/common/noSmall.gif"><span style="font-size:12px;color:red;">无此账号，请确认帐号正确性！</span>';
				} else if (data == "WRONG_PWD") {
					document.getElementById("message").innerHTML = '<img alt="错误" src="<%=path%>/commons/images/common/noSmall.gif"><span style="font-size:12px;color:red;">密码错误，请检查密码！</span>';
				} else if (data == "SUCCESS") {
					window.location.href = _contextPath + "/my/index";
				} else {
					window.location.href = _contextPath + "/my/index";
				}
			}
		});
	}
	function cleanPrompt() {
		document.getElementById("message").innerHTML = "";
	}
</script>
</body>
</html>