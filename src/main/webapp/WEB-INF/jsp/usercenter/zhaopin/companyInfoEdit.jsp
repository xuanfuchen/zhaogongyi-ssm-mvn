<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function editCompanyInfo(cid) {
		if(!validateCheck(document.frm)) {
			return;
		}
		if (!confirm("确定修改公司资料？")) {
			return;
		}
		document.frm.action = _contextPath + '/my/editCompanyInfo.do?cid=' + cid;
		document.frm.submit();
	}
</script>
</head>
<body>
<div class="wrapper minheightout">
<s:form name="frm" id="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tr class="personal-ifram-1">
     <td colspan="100%" align="left">
     	<span class="personl-ifram-char-1">公司资料</span>
     </td>
</tr>
<tr>
	<td colspan="100%" class="hr0">&nbsp;</td>
</tr>
<tr>
	<td align="right" width="15%">
		<span class="redChar">*</span>公司名称：
	</td>
	<td>
		<s:textfield name="company.name" maxlength="100" cssStyle="width:350px;"
		cssClass=".notNull newinp" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess1","企业名称不能为空，100字以内");' 
		onfocus="chngBorderColorShowMsgDiv('','企业名称不能为空，100字以内',this)"/><label id="mess1"></label> 
	</td>
</tr>

<tr>
	<td align="right">
		<span class="redChar">*</span>行　　业：
	</td>
	<td>
		<s:select name="company.trade" cssStyle="width: 180px;"
			list="#{'服务业':'服务业','制造业':'制造业','建筑业':'建筑业'}"
			label="所属行业" 
			onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess0","公司行业不能为空")' 
			onfocus="chngBorderColorShowMsgDiv('','公司行业不能为空',this)"></s:select><label id="mess0"></label>
		
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>公司性质：
	</td>
	<td>
		<s:select name="company.type" cssStyle="width: 180px"
			list="#{'国有':'国有','私营':'私营','股份制':'股份制','个体户':'个体户','其它':'其它'}"
			label="企业性质" 
			cssClass="notNull" 
			onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess2","企业性质不能为空")' 
			onfocus="chngBorderColorShowMsgDiv('','企业性质不能为空',this)"></s:select><label id="mess2"></label>
		</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>规　　模：
	</td>
	<td>
		<s:select name="company.grand" cssStyle="width: 180px"
			list="#{'1-49人':'1-49人','50-99人':'50-99人','100-499人':'100-499人','500-999人':'500-999人','1000人以上':'1000人以上'}"
			cssClass="notNull" onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess3","企业规模不能选择为空。")' 
			onfocus="chngBorderColorShowMsgDiv('','企业规模不能选择为空。',this)"></s:select><label id="mess3"></label> 
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>联系电话：
	</td>
	<td>
		<s:textfield name="company.comPhone" maxlength="150"
		cssClass=".notNull .isPhone newinp"
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess7","联系电话不能为空")'
		onfocus="chngBorderColorShowMsgDiv('','联系电话不能为空',this)"
		/><label id="mess7"></label>
	</td>
</tr>
<tr>
	<td align="right">
		联系邮箱：
	</td>
	<td>
		<s:textfield name="company.comEmail" maxlength="150"
		cssClass=".isEmail newinp"
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess8","邮箱格式请填写正确")'
		onfocus="chngBorderColorShowMsgDiv('','邮箱默认是注册帐号的邮箱，可以修改为别的邮箱',this)"
		/><label id="mess8"></label>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>公司地址：
	</td>
	<td>
		<s:textfield name="company.addr" id="company.addr" maxlength="150" cssStyle="width:350px;" 
		cssClass=".notNull newinp"
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess4","公司地址不能为空")'
		onfocus="chngBorderColorShowMsgDiv('','公司地址不能为空',this)"
		/><label id="mess4"></label>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>企业简介：
	</td>
	<td>
		<s:textarea name="company.remark" cssStyle="width:400px; height:150px;"
		cssClass=".notNull text"></s:textarea>
		<br><label id="mess5"></label>
	</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
		<input type="button" id="fabu" class="confirm-verify" onclick="editCompanyInfo(${company.companyId })" value="保存修改"/>&nbsp;&nbsp;
		<input type="button" value="返回" onclick="window.history.go(-1)" style="padding-top: 4px;" class="confirm-verify">&nbsp;&nbsp;
	</td>
</tr>
</table>
</s:form>
</body>
</html>
