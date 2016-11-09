<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function modifyRsm(rid) {
		var reqStr = _contextPath + "/my/showedit/" + rid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function delRsm(rid) {
		if (!confirm("是否删除？删除后不能恢复！")) {
			return;
		}
		var reqStr = _contextPath + "/my/del/" + rid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function refreshRsm(rid) {
		if (!confirm("是否刷新简历的最新时间？")) {
			return;
		}
		var reqStr = _contextPath + "/my/refresh/" + rid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function openRsm(rid) {
		if (!confirm("是否公开简历，公开后用人单位能搜到你的简历？")) {
			return;
		}
		var reqStr = _contextPath + "/my/open/" + rid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function hideRsm(rid) {
		if (!confirm("是否关闭公开，关闭后任何人都查不到你的简历？")) {
			return;
		}
		var reqStr = _contextPath + "/my/hide/" + rid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function viewRsm(rid) {
		var reqStr = _contextPath + "/my/view/" + rid;
		document.frm.action = reqStr;
		document.frm.submit();
	}
</script>
</head>
<body>
	<div class="wrapper minheightout">
		<form name="frm" id="frm" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="5" id="myTable">
				<tr class="personal-ifram-1">
					<td colspan="3" align="left"><span class="personl-ifram-char-1">我的简历</span></td>
				</tr>
				<tr>
					<td colspan="8" class="hr0">&nbsp;</td>
				</tr>
				<tr class="tableHead" valign="top">
					<td width="25%" align="left" id="workKindNameSort">简历名称</td>
					<td width="16%" align="left" id="dutySort">公开设置</td>
					<td width="17%" align="left" id="pubDateSort">更新时间</td>
					<td width="" align="left">操作</td>
					<td><input type="button" value="添加简历" onclick="window.location.href='<%=path%>/my/addresume'"></td>
				</tr>

				<tbody>
					<c:forEach items="${listPage.list }" varStatus="st" var="tmp">
						<tr>
							<td align="left">[${tmp.RESUME_ID }]${tmp.RESUME_TITLE }&nbsp;</td>

							<td><c:choose>
									<c:when test="${tmp.DIS_FLAG == 1 }">公开</c:when>
									<c:otherwise>保密</c:otherwise>
								</c:choose></td>

							<td align="left"><fmt:formatDate value="${tmp.PUBLISH_DATE}" pattern="yyyy-MM-dd HH:mm:ss" />&nbsp;</td>

							<td align="left"><a href="javascript:modifyRsm('${tmp.RESUME_ID }')">修改</a> <a href="javascript:delRsm('${tmp.RESUME_ID }')">删除</a> <a
								href="javascript:refreshRsm('${tmp.RESUME_ID }')">刷新</a> <c:choose>
									<c:when test="${tmp.DIS_FLAG == 0 }">
										<a href="javascript:openRsm('${tmp.RESUME_ID }')">公开简历</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:hideRsm('${tmp.RESUME_ID }')">隐藏简历</a>
									</c:otherwise>
								</c:choose> <a href="javascript:viewRsm('${tmp.RESUME_ID }')">查看</a> <a href="<%=path %>/resume/detail/${tmp.RESUME_ID }" target="_blank">预览</a></td>
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
</body>
</html>
