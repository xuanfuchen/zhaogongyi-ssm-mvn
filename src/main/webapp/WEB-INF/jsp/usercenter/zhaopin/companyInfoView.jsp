<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function editCompanyInfo(cid) {
		document.frm.action = _contextPath + '/my/toEditCompanyInfo.do?cid=' + cid;
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
		公司名称：
	</td>
	<td>
		${company.name }
	</td>
</tr>

<tr>
	<td align="right">
		行　　业：
	</td>
	<td>
		${company.trade }
	</td>
</tr>
<tr>
	<td align="right">
		公司性质：
	</td>
	<td>
		${company.type }
	</td>
</tr>
<tr>
	<td align="right">
		规　　模：
	</td>
	<td>
		${company.grand }
	</td>
</tr>
<tr>
	<td align="right">
		联系电话：
	</td>
	<td>
		${company.comPhone }
	</td>
</tr>
<tr>
	<td align="right">
		联系邮箱：
	</td>
	<td>
		${company.comEmail }&nbsp;
	</td>
</tr>
<tr>
	<td align="right">
		公司地址：
	</td>
	<td>
		${company.addr }
	</td>
</tr>
<tr>
	<td align="right">
		企业简介：
	</td>
	<td style="background-color: #F5F5F5;">
		${company.remark }
	</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td><input type="button" id="fabu" class="confirm-verify" onclick="editCompanyInfo(${company.companyId })" value="修改"/></td>
</tr>
</table>
</s:form>
</body>
</html>
