<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%--@ include file="/commons/jsp/include/common.jsp" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"	content="text/html; charset=UTF-8">
<title>招工,招工信息,求职,找工作,招聘</title>

<meta name="googlebot" content="index, follow" />
<%-- <link href="<%=path%>/commons/jsp/css/0903main.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/commons/jsp/css/home.css" rel="stylesheet" type="text/css" /> --%>
</head>
<body style="text-align: center;" id="homebody">
<%
	request.getRequestDispatcher("/worktype/list/4401").forward(request, response);
%>
</body>
</html>