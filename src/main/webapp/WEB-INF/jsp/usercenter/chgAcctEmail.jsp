<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
table tr {
	height: 32px;
}
</style>
<script type="text/javascript">
function save(){
	if(!validateCheck(document.frm)) {
		return;
	}
	if(!confirm("是否修改邮箱？")) {
		return;
	}
	var reqStr = _contextPath + "/reg/validpwd";
	$.ajax({
		async:false,
		url:reqStr,
		cache:false,
		method:"post",
		dataType:"text",
		data:{"acctName":"${acctInfo.acctName }", "password":$.trim($('#password').val())},
		success:function(data){
			if(data == "SUCCESS"){
				document.frm.action = _contextPath + "/my/chgemail";
				document.frm.submit();
			} else {
				alert("密码错误！");
			}
		}
	});
}
function check() {
	
}
</script>
</head>
<body>
<form id="frm" name="frm" method="post" action="">
<table width="100%" border="0" align="center" id="passwordTable">
	<tr class="personal-ifram-1">
		<td>
			<span class="personl-ifram-char-1">修改邮箱</span>
		</td>
	</tr>

	<tr>
		<td height="1px;" colspan="2" class="hr0">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td height="32" align="right" valign="middle" width="30%">
			<span class="redChar">*</span>帐号名：
		</td>
		<td width="413" valign="middle">${acctInfo.acctName }</td>
	</tr>
	<tr>
	  <td height="32"  align="right" valign="middle"><span class="redChar">*</span>旧邮箱：</td>
	  <td valign="middle">${acctInfo.email }</td>
	</tr>
	<tr>
  <td align="right" height="32"  valign="middle"><span class="redChar">*</span>新邮箱：</td>
  <td valign="middle">
  	<input name="newEmail" size="23" 
  	class=".notNull .isEmail newinp" 
  	onblur='chngBorderColorHideMsgDiv(this);checkId(this, "", "mess1", "请填写新邮箱，邮箱格式正确。");' 
  	onfocus="chngBorderColorShowMsgDiv('','请填写新邮箱，邮箱格式正确。',this)">
  	<label id="mess1"></label>
  </td>
</tr>
<tr>
  <td align="right" height="32"  valign="middle"><span class="redChar">*</span>密　码：</td>
  <td valign="middle">
  		<input type="password" maxlength="12" id="password" 
  		class=".notNull newinp" size="23" 
  		onblur='chngBorderColorHideMsgDiv(this);checkId(this, "", "mess2", "密码不能为空");' 
  		onfocus="chngBorderColorShowMsgDiv('','密码不能为空',this)">
    	<label id="mess2"></label>
    </td>
  </tr>
	<tr>
		<td>
			&nbsp;
		</td>
		<td height="60" colspan="1" align="left" valign="middle">
			<input name="" type="button" value="确定修改" onclick="save()" class="confirm-verify" />
		</td>
	</tr>
</table>
</form>
</body>
</html>
