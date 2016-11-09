<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"	content="text/html; charset=UTF-8">
<title><%=websiteName%>-招工,招工信息,求职,找工作,招聘</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="Keywords" content="招工,招工信息,招工网,求职,找工作,招聘">
<meta name="description" content="<%=websiteName %>是最专业的招聘、招工网，免费为求职/找工作者和招工/招聘者提供信息发布及查询服务。<%=websiteName %>，为您提供最新、最全的招工信息！">
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<link href="<%=path%>/commons/jsp/css/0903main.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/commons/jsp/css/home.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center;" id="homebody">
<%@ include file="/commons/jsp/header/header.jsp"%>
<table width="100%" style="margin: 0px;">
<tr>
	<td width="100%" align="center">
		<div class="area">
			<div style="margin-top: 0px; margin-bottom: 0px; height: 40px;">
				<div style="width: 558px; float: left; text-align: left; height: 40px; line-height: 40px;">
					<font class="cityEnter" style="">
						<strong>&nbsp;城市入口&nbsp;</strong>
					</font>
					<font class="cityEnter"><strong>
					<a href="<%=path%>/worktype/list/4401" class="menuArea2">广州站</a>&nbsp;
					<a href="<%=path%>/worktype/list/4402" class="menuArea2">深圳站</a>&nbsp;
					<a href='javascript:joke()' class="menuArea2">邵阳站</a>&nbsp;
					</strong></font>
				</div>
			</div>

			<div class="area-main">
				<div class="main-col-10">
					<div style="margin-right: 10px; margin-bottom: 10px;">
						<%@ include file="zhaogongyi/module-zhaopin/new-jobs.htm"%>
					</div>

					<%-- 首页左边中间广告 --%>
					<div style="margin-right: 10px; margin-bottom: 10px;">
						<img alt="中间横幅" src="<%=path%>/commons/images/ad/home_middle_ad.jpg">
					</div>
					<%-- /首页左边中间广告 --%>

					<div style="margin-right: 10px; margin-bottom: 10px;">
						<%@ include file="zhaogongyi/module-qiuzhi/new-workers.htm"%>
					</div>
				</div>

				<div class="main-col-9">
					<%-- 右边第一个广告 --%>
					<div style="float: left; margin-bottom: 10px; margin-top: 0px; margin-left: 0px; margin-right: 0px; overflow: hidden; width: 255px; height: 250px;">
						<img alt="小屁孩都不相信..." src="<%=path %>/commons/images/ad/ad_250_250_4.jpg">
					</div>

					<%-- 右边第二个广告 --%>
					<div style="float: left; margin-bottom: 10px; margin-top: 0px; margin-left: 0px; margin-right: 0px; overflow: hidden; width: 255px; height: 250px;">
						<img alt="广告" src="<%=path %>/commons/images/ad/250_250_1.jpg">
					</div>

					<%-- 右边第三个广告 --%>
					<div style="float: left; margin-bottom: 10px; margin-top: 0px; margin-left: 0px; margin-right: 0px; overflow: hidden; width: 255px; height: 250px;">
						<img alt="广告" src="<%=path %>/commons/images/ad/250_250_2.jpg">
					</div>
				</div>
			</div>
		</div>
	</td>
</tr>
<tr>
	<td align="center">
		<%-- 友情链接 --%>
		<div style="margin: 0px auto;width: 998px;">
			<%@ include file="/commons/jsp/include/flink.jsp" %>
		</div>
	</td>
</tr>
	
<tr>
	<td width="100%" align="center">
		<%@ include file="/commons/jsp/include/aboutus.jsp" %>
	</td>
</tr>
</table>
</body>
</html>