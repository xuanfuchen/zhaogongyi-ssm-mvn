<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<div class="wrapper minheightout">
<form name="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="5" >
	<tr class="personal-ifram-1">
      <td colspan="3" align="left">
      	<span class="personl-ifram-char-1">招聘信息</span>
      </td>
		</tr>
		<tr>
		<td colspan="8" class="hr0">&nbsp;</td>
	</tr>
	<tr class="tableHead" valign="top">
		<td width="20%" align="left" id="workKindNameSort" >
			职位标题
		</td>
		<td width="16%" align="left" id="dutySort" >
			公开设置
		</td>
		<td width="17%" align="left" id="pubDateSort" >
			更新时间
		</td>
		<td width="" align="left" >
			操作
		</td>
		<td>
			<input type="button" value="发布招聘" onclick="window.location.href='<%=path %>/my/toIssueJob.do'">
		</td>
	</tr>

	<tbody>
		<c:forEach items="${listPage.list }" var="tmp" varStatus="st">
			<tr>
				<td align="left">
					${TITLE }&nbsp;
				</td>
				
				<td>
					${tmp.DIS_FLAG == 1 ? "公开" : "保密" }
				</td>
				
				<td align="left">
					<fmt:formatDate value="${tmp.PUBLISH_DATE}" pattern="yyyy-MM-dd"/>&nbsp;
				</td>
				
				<td align="left">
					<a href="javascript:modifyJob(${tmp.WORK_ID })">修改</a>
					<a href="javascript:delJob(${tmp.WORK_ID })">删除</a>
					<a href="javascript:refreshJob(${tmp.WORK_ID })">刷新</a>
					<c:choose>
						<c:when test="${DIS_FLAG == 0 }"><a href="javascript:openJob(${tmp.WORK_ID })">公开招聘</a></c:when>
						<c:otherwise><a href="javascript:hideJob(${tmp.WORK_ID })">隐藏招聘</a></c:otherwise>
					</c:choose>
					<a href="javascript:viewJob('${tmp.WORK_ID }')">查看</a>
					<a href="<%=path %>/zhaopin/toJobDetail.do?wid=${tmp.WORK_ID }" target="_blank">预览</a>
				</td>
				<td>&nbsp;</td>
			</tr>
		</c:forEach>
</tbody>
</table>
<div class="line">
	<jsp:include page="/commons/jsp/pager/simplePager.jsp">
		<jsp:param name="formName" value="frm" />
		<jsp:param name="id" value="1" />
	</jsp:include>
</div>
</form>
</div>
<script type="text/javascript">
	function modifyJob(wid) {
		var reqStr = _contextPath + "/my/editjob/" + wid;
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
