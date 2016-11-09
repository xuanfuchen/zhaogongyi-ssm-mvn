<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="wrapper minheightout">
<s:form name="frm" id="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tr class="personal-ifram-1">
     <td colspan="100%" align="left">
     	<span class="personl-ifram-char-1">修改招聘信息</span>
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
	<td>
		<a href="javascript:window.history.go(-1)" style="font-weight: bold;">返回</a>
	</td>
</tr>
<tr>
	<td align="right">
		招聘标题：</td>
	<td>
		${workInfo.title }
	</td>
</tr>

<tr>
	<td align="right">
		工　　种：
	</td>
	<td>
		[${workInfo.workType.workTypeId }]${workInfo.workTypeName }
	</td>
</tr>

<tr>
	<td align="right">
		<span style="color: red;" ></span>招聘人数：
	</td>
	<td>
		${workInfo.num }
	</td>
</tr>
<tr>
	<td align="right">
		经验要求：
	</td>
	<td>
		${workInfo.exprTime }
	</td>
</tr>
<tr>
	<td align="right">																		
		学历要求：
	</td>
	<td>
		${workInfo.education }
	</td>
</tr>
<tr>
	<td align="right">
		<span style="color: red;" ></span>提供薪水：
	</td>
	<td>
		<s:if test="workInfo.slyBegin != null && workInfo.slyEnd != null">
			${workInfo.slyBegin }&nbsp;&nbsp;至&nbsp;&nbsp;${workInfo.slyEnd }&nbsp;&nbsp;元
		</s:if>
		<s:elseif test="workInfo.slyBegin != null && workInfo.slyEnd == null">
			${workInfo.slyBegin }&nbsp;&nbsp;以上
		</s:elseif>
		<s:elseif test="">
			${workInfo.slyEnd }&nbsp;&nbsp;以下
		</s:elseif>
		<s:else>面议</s:else>
	</td>
</tr>
<tr>
	<td align="right">
		工作地点：
	</td>
	<td style="border-right-width: 0" colspan="1">
		${displayWorkPlace }
	</td>
</tr>
<tr>
	<td align="right">
		职位要求：
	</td>
	<td>
		<s:property value="workInfo.dutyReq"/>
	</td>
</tr>			
<tr>
	<td align="right">
		联 系 人：
	</td>
	<td>
		${workInfo.contactPerson }
	</td>
</tr>
<tr>
	<td align="right">
		联系电话：
	</td>
	<td>
		${workInfo.contactPhone }
	</td>
</tr>
<tr>
	<td align="right">
		电子邮箱：
	</td>
	<td align="left">
		${workInfo.workEmail }
	</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
		<input type="button" value="返回" onclick="window.history.go(-1)" style="padding-top: 4px;" class="confirm-verify">&nbsp;&nbsp;
	</td>
</tr>
</table>
</s:form>
</body>
</html>
