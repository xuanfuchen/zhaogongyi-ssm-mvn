<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
* {
	font-family: '微软雅黑';
}
</style>
<link href="<%=path%>/commons/jsp/css/homestatic.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<table class="mainleft" width="100%" border="0" align="center"
		cellpadding="0" cellspacing="0">
		<tr>
			<th colspan="2" class="tableTitle">最新简历推荐</th>
		<tr>
		<tr>
			<td id="firstRow" colspan="2"></td>
		</tr>
		<c:forEach items="${homeStaticQiuzhiList }" varStatus="st" var="tmp">
			<c:choose>
				<c:when test="${fn:length(tmp.FULL_NAME) == 2}">
					<c:set var="var_full_name"
						value="${fn:substring(tmp.FULL_NAME, 0, 1) } ${fn:substring(tmp.FULL_NAME, 1, 2) }"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="var_full_name" value="${tmp.FULL_NAME }"></c:set>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${fn:length(tmp.FULL_NAME) > 6}">
					<c:set var="var_title" value="${fn:substring(tmp.TITLE, 0, 6) }..."></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="var_title" value="${tmp.TITLE }"></c:set>
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${st.index % 2 == 0 }">
					<tr>
						<td><img
							src='<%=path%>/commons/images/common/arrow1.gif'
							alt="箭头" width="6" height="6"> <a class="font_show"
							href="<%=path%>/resume/detail/${tmp.RESUME_ID}"
							target="_blank">${var_full_name } </a>&nbsp; <span
							class="gender_1">${tmp.GENDER }</span>&nbsp; <span
							class="worktypename_1">${tmp.WORK_TYPE_NAME}</span>&nbsp; <a
							class="font_show_blues"
							href="<%=path%>/resume/detail/${tmp.RESUME_ID}"
							title="${tmp.TITLE }" target="_blank">${var_title } </a>&nbsp; <span
							class="date_1">${tmp.PUBLISH_DATE_DISPLAY}</span>&nbsp;</td>
				</c:when>
				<c:otherwise>
					<td><img
						src='<%=path%>/commons/images/common/arrow1.gif'
						alt="箭头" width="6" height="6"> <a class="font_show"
						href="<%=path%>/resume/detail/${tmp.RESUME_ID}"
						target="_blank"> ${var_full_name} </a>&nbsp; <span
						class="gender_1">${tmp.GENDER}</span>&nbsp; <span
						class="worktypename_1">${tmp.WORK_TYPE_NAME}</span>&nbsp; <a
						class="font_show_blues"
						href="<%=path%>/resume/detail/${tmp.RESUME_ID}"
						title="${tmp.TITLE }" target="_blank"> ${var_title} </a>&nbsp; <span
						class="date_1">${tmp.PUBLISH_DATE_DISPLAY}</span>&nbsp;</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<tr>
			<td colspan="2" id="lastRow"></td>
		</tr>
	</table>
</body>
</html>