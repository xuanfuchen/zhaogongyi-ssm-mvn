<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<div class="wrapper minheightout">
<s:form name="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="5" >
	<tr class="personal-ifram-1">
      <td colspan="3" align="left">
      	<span class="personl-ifram-char-1">管理招聘信息</span>
      </td>
	</tr>
	<tr>
		<td colspan="8" class="hr0">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="100%">
			<%@ include file="/WEB-INF/jsp/admincenter/adminQryJobHeader.jsp" %>
		</td>
	</tr>
	<tr class="tableHead" valign="top">
		<td width="6%" align="center">
        	<input type="checkbox" onclick="cbCheck(this, 'cbGroup')" />
        </td>
		<td width="25%" align="left" id="workKindNameSort" >
			标题
		</td>
		<td width="30%" align="left" id="dutySort" >
			公司
		</td>
		<td width="10%" align="left" id="dutySort" >
			工种
		</td>
		<td width="10%" align="left" id="dutySort" >
			公开设置
		</td>
		<td width="" align="left" id="pubDateSort">
			更新时间
		</td>
	</tr>

	<tbody>
		<s:iterator value="listPage.list" status="s">
			<tr
				<s:if test="(#s.index + 1) % 2 == 0">class="tableRow2" onmousemove="this.className='tableRow3'" onmouseout="this.className='tableRow2'"</s:if>
				<s:else>class="tableRow1" onmousemove="this.className='tableRow3'" onmouseout="this.className='tableRow1'"</s:else>
			         >
			<td align="center">
	             <input type="checkbox" name="cbGroup" value="${WORK_ID }" />
            </td>
			<td align="left">
				[${WORK_ID }]<a href="<%=path %>/zhaopin/toJobDetail.do?wid=${WORK_ID }" target="_blank">${TITLE }</a>
			</td>
			
			<td align="left">
				${COMPANY_NAME }&nbsp;
			</td>
			<td align="left">
				${WORK_TYPE_NAME }&nbsp;
			</td>
			
			<td>
				<s:if test='DIS_FLAG == 1'>公开</s:if><s:else>保密</s:else>
			</td>
			
			<td align="left">
				<s:date name="PUBLISH_DATE" format="yyyy-MM-dd HH:mm" />&nbsp;
			</td>
		</tr>
	</s:iterator>
</tbody>
</table>
<div class="line">
	<jsp:include page="/commons/jsp/pager/simplePager.jsp">
		<jsp:param name="formName" value="frm" />
		<jsp:param name="id" value="1" />
	</jsp:include>
</div>
</s:form>
<script type="text/javascript">
	function modifyJob(wid) {
		var reqStr = _contextPath + "/my/toEditJob.do?wid=" + wid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function delJob(wid) {
		if (!confirm("是否删除？删除后不能恢复！")) {
			return;
		}
		var reqStr = _contextPath + "/my/delJob.do?wid=" + wid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function refreshJob(wid) {
		if (!confirm("是否刷新工作的最新时间？")) {
			return;
		}
		var reqStr = _contextPath + "/my/refreshJob.do?wid=" + wid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function openJob(wid) {
		if (!confirm("是否公开招聘工作，公开后求职者能查看到你的发布？")) {
			return;
		}
		var reqStr = _contextPath + "/my/openJob.do?wid=" + wid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function hideJob(wid) {
		if (!confirm("是否关闭公开，关闭后任何人都查不到这条发布信息？")) {
			return;
		}
		var reqStr = _contextPath + "/my/hideJob.do?wid=" + wid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function viewJob(wid) {
		var reqStr = _contextPath + "/my/viewJob.do?wid=" + wid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
</script>
</body>
</html>
