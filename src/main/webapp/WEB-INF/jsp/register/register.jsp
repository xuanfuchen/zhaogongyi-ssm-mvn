<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>帐户注册_<%=websiteName%>_找工作，招工人
</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="keywords"
	content="<%=websiteName%>,<%=website%>,招工，招聘，求职，注册">
<meta name="description"
	content="<%=websiteName%>是免费的务工者找工作平台和企业招工信息发布平台，包含建筑业，制造业和服务业所有工种。<%=websiteName%>，要做最好的蓝领招聘网络平台，愿所有的务工者朋友们顺利找到好工作。这里是用户注册页面。">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
.select-sty {
	height: 30px;
	border-bottom: #d4d4d4 1px solid;
	border-left: #d4d4d4 1px solid;
	padding-bottom: 2px;
	margin-top: 2px;
	padding-left: 2px;
	padding-right: 2px;
	vertical-align: middle;
	border-top: #d4d4d4 1px solid;
	border-right: #d4d4d4 1px solid;
	padding-top: 2px;
}

.Rtb-class {
	text-align: center;
}

.zhanghaoxinxi {
	padding-bottom: 30px;
	border-bottom: #dce5f1 1px solid;
}

.jibenziliao {
	padding-bottom: 30px;
	border-bottom: #dce5f1 1px solid;
}

.zhaogongyixiang {
	border-bottom: #dce5f1 0px solid;
}

table td {
	height: 40px;
}
</style>
</head>
<body>
	<form id="userRegiestForm" name="frm" method="POST"
		onsubmit="return false">
		<%@ include file="/commons/jsp/header/header.jsp"%>
		<table class="tb-class" width="100%" border="0" bordercolor="red"
			cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td align="center">
					<div
						style="line-height: 40px; height: 40px; border-width: 1px; border-color: #AACDE9; border-style: solid; width: 900px; background-color: #E8F2FA; height: 40px; text-align: left;">
						<div style="float: left;">
							<span
								style="font-weight: bold; font-size: 16px; color: #0861A2; text-align: left; padding-left: 20px; margin-top: 20px; vertical-align: middle;">用户注册</span>
						</div>
						<div style="float: right;">
							<span class="return-to-home"><a href="<%=home%>"
								style="text-decoration: underline;">返回首页</a></span>
						</div>
					</div>

					<div
						style="border-width: 0px 1px 1px 1px; border-color: #AACDE9; border-style: solid; width: 900px;">
						<div style="height: 20px;"></div>
						<%-- 帐号信息 --%>
						<div class="databox">
							<div class="zhanghaoxinxi">
								<table width="100%" border="0" bordercolor="green"
									cellspacing="0" cellpadding="0">
									<tr>
										<td align="right" width="20%"><span class="redChar">*</span>帐
											号：</td>
										<td style="border-right-width: 0" colspan="2"><input
											id="acctName" name="acctName" maxlength="16"
											class="newinp .notNull.isAbc123"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"<%=path%>/reg/isUnique?type=acct&value=#","mess1","帐号由英文字母和数字0-9组成，长度为4-16位。","帐号已经被注册")'
											onFocus="chngBorderColorShowMsgDiv('','帐号由英文字母和数字0-9组成，长度为4-16位。',this)"
											type="text" /> <label id="mess1"></label></td>
									</tr>
									<tr>
										<td align="right"><span class="redChar">*</span>密 码：</td>
										<td style="border-right-width: 0" colspan="2"><input
											id="firstPassword" name="password" type="password"
											maxlength="12" class=".notNull .isPassword newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess2","新密码不能为空，长度在6到12位之间。");'
											onFocus="chngBorderColorShowMsgDiv('','密码不能为空，长度在6到12位之间。12位之间。',this)" />
											<label id="mess2"></label></td>
									</tr>
									<tr>
										<td align="right"><span class="redChar">*</span>密码确认：</td>
										<td style="border-right-width: 0" colspan="2"><input
											id="passwordConfirm" type="password" maxlength="12"
											class=".notNull.isPassword .sameAs(firstPassword) newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess3","确认密码不能为空，且要与上一个密码相同。"); '
											onfocus="chngBorderColorShowMsgDiv('','确认密码不能为空，且要与上一个密码相同。',this)" />
											<label id="mess3"></label></td>
									</tr>
									<tr>
										<td align="right"><span class="redChar">*</span>邮 箱：</td>
										<td colspan="2"><input id="email" name="email"
											maxlength="40" class=".isEmail .notNull newinp"
											onfocus="chngBorderColorShowMsgDiv('','请输入邮箱，该邮箱只用于企业和您联系',this);"
											onblur="chngBorderColorHideMsgDiv(this);checkId(this,'<%=path%>/reg/isUnique?type=email&value=#','messa4','请输入正确的邮箱格式。','邮箱已被注册')">
											<label id="messa4"></label></td>
									</tr>

									<tr>
										<td>&nbsp;</td>
										<td colspan="2"><input id="chkBtn" type="checkbox"
											onChange=""> 我已阅读并同意该协议 <a target="_blank"
											href="<%=path%>/commons/jsp/regProtocol.jsp">查看协议</a></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="2"><input type="button" value="我要注册"
											id="reg_btn" onclick="submitForm()"
											style="cursor: pointer; line-height: 25px; height: 30px; font-weight: bold;">
										</td>
									</tr>
								</table>
							</div>
						</div>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	function submitForm(){
		if(!validateCheck(document.frm)) {
			return;
		}
		if(!document.getElementById("chkBtn").checked){
			alert("同意协议才能注册！");
			return;
		}
		var reValidAcctName = reValidateUnique(document.getElementById("acctName"), "<%=path%>/reg/isUnique?type=acct&value=#","mess1", "帐号已经抢先注册，请重新填写");
		if (!reValidAcctName) {
			return;
		}
		var reValidEmail = reValidateUnique(document.getElementById("email"), '<%=path%>/reg/isUnique?type=email&value=#', 'messa4', '邮箱已被抢先注册，请重新填写');
		if (!reValidEmail) {
			return;
		}
		document.frm.action = '<%=path%>
		/reg/registerUser';
			document.frm.submit();
			document.getElementById("reg_btn").disabled = "disabled";
		}
	</script>
</body>
</html>