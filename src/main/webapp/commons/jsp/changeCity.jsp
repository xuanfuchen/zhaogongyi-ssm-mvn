<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<%@ page import="com.zhaogongyi.model.vo.WorkTypeCountVO" %>
<%@page import="com.zhaogongyi.model.Place"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		/*集中信息板*/
		int colNum = 3;//调整左边的一行显示多少个
		int colNum2 = 3;//调整右边的一行显示多少个
		String border = "0";//是否显示边框，方便调试
		String width = "340";
		int headHght = 50;//招工、招聘和下面的距离
		Place curPlace = (Place) request.getAttribute("curPlace");
	%>
  <head>
    <base href="<%=basePath%>" target="_blank">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="keywords" content="${curPlace.placeName }招工,${curPlace.placeName }招聘,${curPlace.placeName }找工作,${curPlace.placeName }">
	<meta name="description" content="<%=websiteName %>是${curPlace.placeName }最专业的招聘、招工网，免费为求职/找工作者和招工/招聘者提供信息发布及查询服务。<%=websiteName %>，为您提供最新、最全的招工信息！">
	<meta name="robots" content="index, follow" />
	<meta name="googlebot" content="index, follow" />
	<title>${curPlace.placeName }招工,${curPlace.placeName }招聘,${curPlace.placeName }找工作,${curPlace.placeName }求职-<%=websiteName %></title>
	<link href="<%=path %>/commons/jsp/css/main.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		body{
			text-align:center;
			width:100%;
		}
		 
		.main-div {
			text-align: center;
			text-align:left; 
			width:1000px; 
			margin:0 auto; 
		}
		
		.center-div {
			width: 998px;
		}
		
		.logo-div {
			clear: both;
		}
		
		div.diqu-div {
			height: 50px;
			text-align: left;
			clear: both;
			margin: 10px auto;
			border-top: 1px #afcfef solid;
			border-bottom: 1px #afcfef solid;
			
		}
		.diqu-div table {
			margin: 6px auto;
			text-align: left;
			float: left;
		}
		
		
		.bottom-div {
			clear: both;
		}
		.wt-div {
			float: left;
		}
		.ad-div {
			width: 255px;
			float: right;
			margin-top: 4px;
		}
		
		.discuz-div {
			text-align: left;
		}
		.left-wt-div {
			width: 730px;
			margin-top: 15px;
			float: left;
		}
		
		.bottom-ad-div {
			clear: both;
		}
		
		
		/************************************************/
		.tableTitle {
			border-bottom: solid 1px #B6D2E9;
			background: url(<%=path%>/commons/images/common/tableTitle.gif) repeat-x;
			color: #07519A;
			font-size: 14px;
			font-weight: normal;
			text-align: left;
			height: 25px;
			padding-left: 10px;
		}
		
		.cityEnter {
			font-size: 16px;
			font-weight: normal;
		}
		
		/*某某职位，某某求职者*/
		.zhiwei {
			color: #EE091F;
			font-size: 14px;
			font-weight: bold;
		}
		table td{
			height: 27px;
			text-align: left;
		}
		A{
			color: #3950bf;
			cursor: pointer;
			text-decoration: none;
		}
		.ad-bottom td{
			height:5px;
		}
		.cityentry {
			font-family: '宋体';
			margin: 0px 2px;
			
		}
	</style>
</head>

<body>
<%@ include file="/commons/jsp/header/header.jsp" %>
<div class="main-div">
<div class="center-div">
	<div style="clear: both;"></div>
	
	<%-- 地区 --%>
	<div class="diqu-div">
		<table>
			<tr>
				<td valign="top">
					<span style="line-height:20px;">
					<font class="cityEnter" style="color: #EE091F;" >地区入口&nbsp;</font></span>
				</td>
				<td valign="top">
					<span style="line-height:20px;">
					<c:forEach items="${curPlaceList }" var="tmp" varStatus="st">
						<c:choose>
							<c:when test="${st.index == 0 }"><font class="cityEnter"><a target="_self" id="plc_${tmp.placeId }" class="menuArea" href="<%=path%>/worktype/list/${tmp.placeId }"><span class="cityentry">全${tmp.placeName }</span></a></font></c:when>
							<c:when test="${st.count%23!=0 }"><font class="cityEnter"><a target="_self" id="plc_${tmp.placeId }" class="menuArea" href="<%=path%>/worktype/list/${tmp.placeId }"><span class="cityentry">${tmp.placeName }</span></a></font></c:when>
							<c:when test="${st.count%23==0 }"><br></c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:forEach>
					</span>
				</td>
			</tr>
		</table>
		<%-- 加粗用户选中的城市和工种 --%>
		<jsp:include page="/commons/jsp/header/statusRecorder.jsp">
			<jsp:param name="wtId" value=''/>
			<jsp:param name="plcPy" value='${curPlace.placeId}'/>
			<jsp:param name="cssClass" value='selected-qry-condition16'/>
		</jsp:include>
		<%-- /加粗用户选中的城市和工种 --%>
	</div>
	
	<%-- 主体 --%>
	<div class="bottom-div">
		<div class="wt-div"><%-- 左边 --%>
		   	<div class="left-wt-div"><%-- 工种 --%>
		   		<table border="<%=border%>" bordercolor="red" style="border-collapse: collapse;" width="100%" height="100%">
   			<tr>
   				<td style="vertical-align: top;">
   					<table width="100%" border="<%=border%>" bordercolor="green">
   						<tr>
   					<%-- 找工作 --%>
   					<td width="<%=width %>">
   						<table border="<%=border%>" width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table border="<%=border%>" id="tab1" width="100%" height="100%" cellpadding="0" cellspacing="0">
										<%-- 生产制造类职位 --%>
										<%
											int ctrl = 0;
											WorkTypeCountVO wtvo = null;
										%>
										 
										 <%-- XX招工 --%>
										 <tr>
											<th align="left" style="color: black;font-size: 16px;font-weight: bold;" colspan="<%=colNum%>" height="<%=headHght%>">
												${curPlace.placeName }招工<hr>
											</th>
										</tr>
										 
										 <%-- 服务、后勤、销售类职位 --%>
										 <%
										 	ctrl = 0;
										 	List fwhqxsList = (ArrayList) request.getAttribute("fwhqxs_jobs");
										 	for (int i = 0; i < fwhqxsList.size(); i++) {
										 		wtvo = (WorkTypeCountVO) fwhqxsList.get(i);
										 		String fwhqxsUrl = path + "/job/list/" + curPlace.getPlaceId() + "_" + wtvo.getWorkTypeId() + "__1";
										 %>
										 <%
										 	if (i == 0) {
										 %>
										  	<tr style="vertical-align: middle;height: 35px;"><th align="left" colspan="<%=colNum%>" class="zhiwei"><%=wtvo.getWorkTypeName()%>职位</th></tr>
										  <%
										  	} else if (i % colNum == 1) {
										  %>
										 		<tr><td>
										 		<a href='<%=fwhqxsUrl %>' class="menuBlue2"><%=wtvo.getWorkTypeName()%></a><span class="numberClass"><%=wtvo.getCount()==null?"":wtvo.getCount()%></span>
										 		<%ctrl++;%>
										 		</td>
										 	<%
										 		} else {
										 	%>	
										 		<td>
										 		<a href='<%=fwhqxsUrl %>' class="menuBlue2"><%=wtvo.getWorkTypeName()%></a><span class="numberClass"><%=wtvo.getCount()==null?"":wtvo.getCount()%></span>
										 		</td>
										 		<%ctrl++;%>
										 	 <%
										 	 	}
										 	 %>
										 	 <%
										 	 	if (ctrl == colNum) {
										 	 %>
												</tr>
											<%
												}
											%>
										 <%
										 	}
										 %>
										 
										 
										 <%-- 生产制造类 --%>
										 <%
										 	List sczzList = (ArrayList) request.getAttribute("sczz_jobs");
	 									 	for (int i = 0; i < sczzList.size(); i++) {
	 									 		wtvo = (WorkTypeCountVO) sczzList.get(i);
	 									 		String sczzUrl = path + "/job/list/" + curPlace.getPlaceId() + "_" + wtvo.getWorkTypeId() + "__1";
	 									 %>
										 <%
										 	if (i == 0) {
										 %>
										  	<tr style="vertical-align: middle;height: 35px;"><th align="left" colspan="<%=colNum%>" class="zhiwei"><%=wtvo.getWorkTypeName()%>职位</th></tr>
										  <%
										  	} else if (i % colNum == 1) {
										  %>
										 		<tr><td><a href='<%=sczzUrl %>' class="menuBlue2"><%=wtvo.getWorkTypeName()%></a><span class="numberClass"><%=wtvo.getCount()==null?"":wtvo.getCount()%></span>
										 			<%ctrl++;%>
										 		</td>
										 	<%
										 		} else {
										 	%>	
										 		<td>
										 		<a href='<%=sczzUrl %>' class="menuBlue2"><%=wtvo.getWorkTypeName()%></a><span class="numberClass"><%=wtvo.getCount()==null?"":wtvo.getCount()%></span>
										 		</td>
										 		<%ctrl++;%>
										 	 <%
										 	 	}
										 	 %>
										 	 <%
										 	 	if (ctrl == colNum) {
										 	 %>
												</tr>
											<%
												}
											%>
										 <%
										 	}
										 %>
										 
										 
										
										<%-- 建筑工地类职位 --%> 
										 <%
										 	ctrl = 0;
	 									 	List jzgdList = (ArrayList) request.getAttribute("jzgd_jobs");
										 	for (int i = 0; i < jzgdList.size(); i++) {
										 		wtvo = (WorkTypeCountVO) jzgdList.get(i);
										 		String jzgdUrl = path + "/job/list/" + curPlace.getPlaceId() + "_" + wtvo.getWorkTypeId() + "__1";
										 %>
										 <%
										 	if (i == 0) {
										 %>
										  	<tr style="vertical-align: middle;height: 35px;"><th align="left" colspan="<%=colNum%>" class="zhiwei"><%=wtvo.getWorkTypeName()%>职位</th></tr>
										  <%
										  	} else if (i % colNum == 1) {
										  %>
										 		<tr><td>
										 			<a href='<%=jzgdUrl %>' class="menuBlue2"><%=wtvo.getWorkTypeName()%></a><span class="numberClass"><%=wtvo.getCount()==null?"":wtvo.getCount()%></span>
										 			<%ctrl++;%>
										 		</td>
										 	<%
										 		} else {
										 	%>	
										 		<td>
										 		<a href='<%=jzgdUrl %>' class="menuBlue2"><%=wtvo.getWorkTypeName()%></a><span class="numberClass"><%=wtvo.getCount()==null?"":wtvo.getCount()%></span>
										 		</td>
										 		<%ctrl++;%>
										 	 <%
										 	 	}
										 	 %>
										 	 <%
										 	 	if (ctrl == colNum) {
										 	 %>
												</tr>
											<%
												}
											%>
										 <%
										 	}
										 %>
										 
										</table>
									</td>
								</tr>
						</table>
   					</td>
   					
   					<td width="40">&nbsp;</td>
   					
   					<%-- 找工人 --%>
   					<td width="<%=width %>">
   						<table border="<%=border%>" width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left">
									<table border="<%=border%>" id="tab2" width="100%" height="100%" cellpadding="0" cellspacing="0">
										
										
										<%
											int ctrl2 = 0;
											WorkTypeCountVO wctVo2 = null;
										%>
										 
										  <%-- XX求职 --%>
										 <tr>
											<th align="left" style="color: black;font-size: 16px;font-weight: bold;" colspan="<%=colNum2%>" height="<%=headHght%>">
												${curPlace.placeName }求职<hr>
											</th>
										</tr>
										 
										 <%-- 服务、后勤、销售类求职者 --%>
										 <%
										 	ctrl2 = 0;
										 	List fwhqxsList2 = (ArrayList) request.getAttribute("fwhqxs_wkrs");
										 %>
										 <%
										 	for (int i = 0; i < fwhqxsList2.size(); i++) {
										 		wctVo2 = (WorkTypeCountVO) fwhqxsList2.get(i);
										 		String fwhqxsUrl2 = path + "/resume/list/" + curPlace.getPlaceId() + "_" + wctVo2.getWorkTypeId() + "__1";
										 %>
										 <%
										 	if (i == 0) {
										 %>
										  	<tr style="vertical-align: middle;height: 35px;"><th align="left" colspan="<%=colNum2%>" class="zhiwei"><%=wctVo2.getWorkTypeName()%>求职者</th></tr>
										  <%
										  	} else if (i % colNum2 == 1) {
										  %>
										 		<tr><td>
										 		<a href='<%=fwhqxsUrl2 %>' class="menuBlue2"><%=wctVo2.getWorkTypeName()%></a><span class="numberClass"><%=wctVo2.getCount()==null?"":wctVo2.getCount()%></span>
										 		<%ctrl2++;%>
										 		</td>
										 	<%
										 		} else {
										 	%>	
										 		<td>
										 		<a href='<%=fwhqxsUrl2 %>' class="menuBlue2"><%=wctVo2.getWorkTypeName()%></a><span class="numberClass"><%=wctVo2.getCount()==null?"":wctVo2.getCount()%></span>
										 		</td>
										 		<%ctrl2++;%>
										 	 <%
										 	 	}
										 	 %>
										 	 <%
										 	 	if (ctrl2 == colNum2) {
										 	 %>
												</tr>
											<%
												}
											%>
										 <%
										 	}
										 %>
										
										<%-- 生产制造类求职者 --%>
										 <%
										 	List sczzList2 = (ArrayList) request.getAttribute("sczz_wkrs");
										 	for (int i = 0; i < sczzList2.size(); i++) {
										 		wctVo2 = (WorkTypeCountVO) sczzList2.get(i);
										 		String sczzUrl2 = path + "/resume/list/" + curPlace.getPlaceId() + "_" + wctVo2.getWorkTypeId() + "__1";
										 %>
										 <%
										 	if (i == 0) {
										 %>
										  	<tr style="vertical-align: middle;height: 35px;"><th align="left" colspan="<%=colNum2%>" class="zhiwei"><%=wctVo2.getWorkTypeName()%>求职者</th></tr>
										  <%
										  	} else if (i % colNum2 == 1) {
										  %>
										 		<tr><td>
										 		<a href='<%=sczzUrl2 %>' class="menuBlue2"><%=wctVo2.getWorkTypeName()%></a><span class="numberClass"><%=wctVo2.getCount()==null?"":wctVo2.getCount()%></span>
										 			<%ctrl2++;%>
										 		</td>
										 	<%
										 		} else {
										 	%>	
										 		<td>
										 		<a href='<%=sczzUrl2 %>' class="menuBlue2"><%=wctVo2.getWorkTypeName()%></a><span class="numberClass"><%=wctVo2.getCount()==null?"":wctVo2.getCount()%></span>
										 		</td>
										 		<%ctrl2++;%>
										 	 <%
										 	 	}
										 	 %>
										 	 <%
										 	 	if (ctrl2 == colNum2) {
										 	 %>
												</tr>
											<%
												}
											%>
										 <%
										 	}
										 %>
										
										<%-- 建筑工地类求职者 --%> 
										 <%
	 									 	ctrl2 = 0;
	 									 	List jzgdList2 = (ArrayList) request.getAttribute("jzgd_wkrs");
	 									 %>
										 <%
										 	for (int i = 0; i < jzgdList2.size(); i++) {
										 		wctVo2 = (WorkTypeCountVO) jzgdList2.get(i);
										 		String jzgdUrl2 = path + "/resume/list/" + curPlace.getPlaceId() + "_" + wctVo2.getWorkTypeId() + "__1";
										 %>
										 <%
										 	if (i == 0) {
										 %>
										  	<tr style="vertical-align: middle;height: 35px;"><th align="left" colspan="<%=colNum2%>" class="zhiwei"><%=wctVo2.getWorkTypeName()%>求职者</th></tr>
										  <%
										  	} else if (i % colNum2 == 1) {
										  %>
										 		<tr><td>
										 		<a href='<%=jzgdUrl2 %>' class="menuBlue2"><%=wctVo2.getWorkTypeName()%></a><span class="numberClass"><%=wctVo2.getCount()==null?"":wctVo2.getCount()%></span>
										 			<%ctrl2++;%>
										 		</td>
										 	<%
										 		} else {
										 	%>	
										 		<td>
										 		<a href='<%=jzgdUrl2 %>' class="menuBlue2"><%=wctVo2.getWorkTypeName()%></a><span class="numberClass"><%=wctVo2.getCount()==null?"":wctVo2.getCount()%></span>
										 		</td>
										 		<%ctrl2++;%>
										 	 <%
										 	 	}
										 	 %>
										 	 <%
										 	 	if (ctrl2 == colNum2) {
										 	 %>
												</tr>
											<%
												}
											%>
										 <%
										 	}
										 %>					
									
										
										</table>
									</td>
								</tr>
							</table>
	   					</td>
	   				</tr>
	   			</table>
	   		</td>
	   					
	   					<td width="10">&nbsp;</td>
	   				</tr>
	   			</table>
		   	</div>	
		</div>
		
		<%-- 右边广告 --%>
		<div class="ad-div">
			<%-- 广告·右边第一个 --%>
			<div style="float:left;margin-bottom: 10px;margin-top:0px;margin-left:0px;margin-right:0px;overflow:hidden;width:255px;height:250px;">
			 	<img alt="广告" src="<%=path %>/commons/images/ad/ad_250_250_6.jpg">
			 </div>
			
			<%-- 广告·右边第二个 --%>
			<div style="float: left; margin-bottom: 10px; margin-top: 0px; margin-left: 0px; margin-right: 0px; overflow: hidden; width: 255px; height: 250px;">
			 	<img alt="广告" src="<%=path %>/commons/images/ad/ad_250_250_5.jpg">
			</div>
			
			<%-- 广告·右边第三个 --%>
			  <div style="float:left;margin-bottom: 10px;margin-top:0px;margin-left:0px;margin-right:0px;overflow:hidden;width:255px;height:250px;">
			 	<img alt="广告" src="<%=path %>/commons/images/ad/ad_250_250_4.jpg">
			 </div>
		</div>
		
		
	</div>
	
	<div style="text-align: center;">
		<%@ include file="/commons/jsp/include/aboutus.jsp" %>
	</div>
</div>
</div>

<script type="text/javascript">
	function login(){
	var t = document.getElementsByName('enterprise.profession');
	var tmp = null;
	//alert("gg"+t.value);
	for(var i=0;i<t.length;i++){
		if(t[i].checked){
			tmp = t[i];
			break;
		}
	}
	if(tmp.value==1){
		if(checkLoginInput()){
			document.forms[0].action='<%=path %>/userLogin.action';
			document.forms[0].submit();
		}
	}else if(tmp.value=='QY'){//QY
		if(checkLoginInput()){
			document.forms[0].action='<%=path %>/enterprise_login.action';
			document.forms[0].submit();
		}
	}else{//ZJ
		if(checkLoginInput()){
			document.forms[0].action='<%=path %>/agency/enterprise_login.action';
			document.forms[0].submit();
		}
	}
}

//个人用户登录
function checkLoginInput(){
<%--设置类型--%>

	var userType = $("input[name='enterprise.profession']:checked").val();
	if (userType==1){
		$("#loginForm").attr("action","userLogin.action");
	}else{
		$("#loginForm").attr("action", "enterprise_login.action");
	}
	var userId = $("#userName");//  document.getElementById("userName");
	var userPassword = $("#userPassword"); //document.getElementById("userPassword");
	if ($.trim(userId.val())==""){
		alert("请输入用户名!");
		userId.focus();
		return false;
	}
	if ($.trim(userPassword.val())==""){
		alert("请输入密码!");
		userPassword.focus();
		return false;
	}
	return true;
}

</script>
</body>
</html>
