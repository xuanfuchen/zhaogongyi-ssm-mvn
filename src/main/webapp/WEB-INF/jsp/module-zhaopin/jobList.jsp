<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<%@ page import="com.zhaogongyi.model.vo.WorkTypeCountVO"%>
<%@page import="com.zhaogongyi.model.Place"%>
<%@page import="com.zhaogongyi.model.WorkType"%>
<%@page import="com.zhaogongyi.model.vo.QueryCond"%>
<%
	Place curPlace = (Place) request.getAttribute("curPlace");
	WorkType curWorkType = (WorkType) request.getAttribute("curWorkType");
	QueryCond q = (QueryCond) request.getAttribute("q");
	String title = curPlace.getPlaceName() + curWorkType.getName() + "招工|" + curPlace.getPlaceName()
			+ curWorkType.getName() + "招聘 - " + websiteName;
	String keywords = curPlace.getPlaceName() + curWorkType.getName() + "招工," + curPlace.getPlaceName()
			+ curWorkType.getName() + "招聘";
	String description = websiteName + "是最专业的招工网站,免费为求职者提供招工、招聘信息,免费为单位发布招工、招聘信息";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="keywords" content="<%=keywords%>">
<meta name="description" content="<%=description%>">
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<title><%=title%></title>
<link href="<%=path%>/commons/jsp/css/main.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
h1, h2 {
	display: inline;
	font-size: 14px;
	font-weight: normal;
}

#login {
	position: relative;
	display: none;
	top: 20px;
	left: 30px;
	text-align: left;
	padding: 0px;
	z-index: 10;
}

table {
	width: 100%;
}

div.top-div {
	text-align: left;
	margin-top: 0px;
	width: 770px;
	float: left;
}

div.left-div {
	width: 770px;
	float: left;
}

div.right-div-ads {
	margin-top: 10px;
	width: 220px;
	float: right;
}

/*div 间距，给需要的div提供间距*/
.div-jianju {
	margin-top: 10px;
	margin-bottom: 10px;
}

/*搜索框*/
.searchInp {
	line-height: 24px;
	height: 24px;
	width: 190px;
	border: #999 1px solid;
	margin: 0px;
	padding: 0px;
	font-size: 14px;
	margin-right: 5px;
}
/*搜索按钮*/
.searchBtn {
	height: 28px;
	margin: 0px;
	padding: 0px;
	width: 45px;
}

table {
	width: 100%;
}

table.data-table td {
	line-height: 28px;
	padding-top: 4px;
	padding-bottom: 4px;
	border-bottom: #f1f1f1 1px solid;
	border-top: #fff 1px solid;
}

table.data-table th {
	line-height: 24px;
	padding-top: 4px;
	padding-bottom: 4px;
	border-bottom: #f1f1f1 1px solid;
	border-top: #fff 1px solid;
	font-weight: normal;
	background-color: #fbfbfb;
	font-weight: bold;
}

.gangwei-link {
	font-weight: bold;
}

.searchBar {
	margin-top: 10px;
}

.breadcrumb {
	margin-top: 10px;
	margin-bottom: 5px;
}

.top-div-table {
	line-height: 23px;
	margin-top: 5px;
}

body {
	font-family: '宋体';
}

p.buzhuanhang-p {
	line-height: 20px;
	margin-top: 10px;
	font-family: '宋体';
}

.buzhuanhang-tishi {
	font-size: 13px;
	width: 35px;
	white-space: nowrap;
	float: left;
}

.buzhuanhang-diqu {
	font-size: 13px;
	width: 713px;
	float: left;
}

.buzhuanhang-span {
	margin: 0px;
	padding: 0px;
	margin-right: 6px;
}

.top-ad-left {
	float: left;
	height: 90px;
	width: 380px;
}

.top-ad-right {
	float: right;
	height: 90px;
	width: 380px;
}
</style>
</head>
<body>
	<%@ include file="/commons/jsp/header/header.jsp"%>
	<div style="width: 100%; text-align: center;">
		<div style="width: 998px; margin: auto; text-align: center;">
			<%-- 顶部div --%>
			<div class="top-div" style="background-color: #E9E9E7;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table class="top-div-table" width="100%" border="0" align="left"
								cellpadding="0" cellspacing="0">
								<%
									int ctrl = 0;
									int colNum = 6;//一行显示多少个
									List<WorkTypeCountVO> curWorkTypeList = (List<WorkTypeCountVO>) request.getAttribute("curWorkTypeList");
									WorkTypeCountVO wtcVo = null;
									for (int i = 0; i < curWorkTypeList.size(); i++) {
										wtcVo = (WorkTypeCountVO) curWorkTypeList.get(i);
										String chgWorkTypeUrl = path + "/job/list/" + curPlace.getPlaceId() + "_" + wtcVo.getWorkTypeId()
												+ "__1";
								%>
								<%
									if (i == 0) {
								%>
								<tr>
									<td colspan="100%">
										<h1 style="color: 000000; font-size: 14px; font-weight: bold;"><%=wtcVo.getWorkTypeName()%></h1>
									</td>
								</tr>
								<%
									} else {
								%>
								<%
									if (i % colNum == 1) {
								%>
								<tr>
									<td><a id="wt_<%=wtcVo.getWorkTypeId()%>"
										href='<%=chgWorkTypeUrl%>' class="gz-query"> <%=wtcVo.getWorkTypeName()%></a>
										<span style="color: gray; font-size: 12px;"></span>&nbsp; <%
 	ctrl++;
 %></td>
									<%
										} else {
									%>
									<td><a id="wt_<%=wtcVo.getWorkTypeId()%>"
										href='<%=chgWorkTypeUrl%>' class="gz-query"> <%=wtcVo.getWorkTypeName()%></a>
										<span style="color: gray; font-size: 12px;"></span>&nbsp; <%
 	ctrl++;
 %></td>
									<%
										}
									%>
									<%
										if (ctrl % colNum == 0 || ctrl == curWorkTypeList.size() - 1) {
									%>
								</tr>
								<%
									}
								%>
								<%
									}
								%>
								<%
									}
								%>
							</table>
						</td>
					</tr>

					<%-- 区域 --%>
					<tr>
						<td>
							<p class="buzhuanhang-p">
								<span class="buzhuanhang-tishi"> 区域 </span> <span
									class="buzhuanhang-diqu"> <c:forEach
										items="${curPlaceList }" var="tmp" varStatus="st">
										<span class="buzhuanhang-span"> <c:choose>
												<c:when test="${st.index == 0 }">
													<a id='plc_${tmp.placeId }'
														href='<%=path %>/job/list/${tmp.placeId }_<%=curWorkType.getWorkTypeId() %>_<%=q.getKw() %>_1'
														class="gz-query">全${tmp.placeName }</a>
												</c:when>
												<c:otherwise>
													<a id='plc_${tmp.placeId }'
														href='<%=path %>/job/list/${tmp.placeId }_<%=curWorkType.getWorkTypeId() %>_<%=q.getKw() %>_1'
														class="gz-query">${tmp.placeName }</a>
												</c:otherwise>
											</c:choose>
										</span>
										<c:if test="${st.count%17==0 }">
											<br>
										</c:if>
									</c:forEach>
								</span>
							</p>
						</td>
					</tr>
					<%-- 选中用户的选择 --%>
					<jsp:include page="/commons/jsp/header/statusRecorder.jsp">
						<jsp:param name="wtId" value='${q.wtid}' />
						<jsp:param name="plcPy" value='${curPlace.placeId }' />
						<jsp:param name="cssClass" value='selected-qry-condition' />
					</jsp:include>
					<%-- /选中用户的选择 --%>
				</table>

				<%-- 搜索 --%>
				<div class="searchBar">
					<form action="" id="frm" name="frm" method="get">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td width="1%"><input id="so_input" value="${q.kw }" onkeydown="func()">
								</td>
								<td><input class="searchBtn" type="button" value="搜索"
									onclick="goToSearch()"></td>
							</tr>
						</table>
					</form>
				</div>

			</div>
			<%-- /顶部div 完 --%>

			<%-- 右边广告 --%>
			<div class="right-div-ads" style="background-color: #E9E9E7;">
				<div style="text-align: center;">
					<img alt="广告" src="<%=path%>/commons/images/ad/200_200_1.jpg">
				</div>
				<div style="margin-top: 20px; text-align: center;">
					<img alt="广告" src="<%=path%>/commons/images/ad/160_600_2.jpg">
				</div>
				<div style="margin-top: 20px; text-align: center;"></div>
			</div>


			<%-- 左边数据 --%>
			<div class="left-div">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="data-table">
					<thead>
						<tr class="tableHead">
							<th width="27%" align="left" id="dutySort">工作岗位</th>
							<th width="29%" align="left" id="nameSort">公司名称</th>
							<th width="16%" align="left">工 资</th>
							<th width="14%" align="left" id="personNumSort">工作区域</th>
							<th width="14%" align="left" id="pubDateSort">发布日期</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listPage.list }" var="tmp" varStatus="st">
							<tr>
								<%-- 工作岗位 --%>
								<td align="left" class="gangwei-link"><a target="_blank"
									href='<%=path %>/job/detail/${tmp.WORK_ID }' class="menuBlue"<%--onmouseover="showEnterpriseWorkPrompt('<s:property value="workTime" />','<s:property value="education" />','<s:property value="personNum" />','<s:property value="areaSection" />','<s:property value="dutyRequire" escape="false"/>')" onmouseout="hideEnterpriseWorkPrompt()"--%>>
										<c:out value="${tmp.TITLE }"></c:out>
								</a></td>

								<%-- 公司名称 --%>
								<td align="left" title="${tmp.COMPANY_NAME }"><c:choose>
										<c:when test="${fn:length(tmp) > 11 }">
											${fn:substring(tmp.COMPANY_NAME ,0, 11) }
										</c:when>
										<c:otherwise>${tmp.COMPANY_NAME }</c:otherwise>
									</c:choose></td>

								<%-- 工资 --%>
								<td align="left"><c:choose>
										<c:when test='${tmp.SLY_BEGIN != "" && tmp.SLY_END != ""}'>
											${tmp.SLY_BEGIN }-${tmp.SLY_END }&nbsp;元
										
										</c:when>
										<c:when test='${tmp.SLY_BEGIN != "" && tmp.SLY_END == "" }'>
											${tmp.SLY_BEGIN }&nbsp;元以上
										</c:when>
										<c:when test='${tmp.SLY_BEGIN == "" && tmp.SLY_END != "" }'>
											${tmp.SLY_END }&nbsp;元以下
										</c:when>
										<c:otherwise>面议</c:otherwise>
									</c:choose></td>

								<%-- 工作区域 --%>
								<td align="left">${tmp.PLACE_NAME }&nbsp;</td>

								<%-- 发布日期 --%>
								<td align="left"><fmt:formatDate
										value="${tmp.PUBLISH_DATE}" pattern="yyyy-MM-dd" /> &nbsp;</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="line" style="border-top: 1px solid #f1f1f1">
					<jsp:include page="/commons/jsp/pager/pager.jsp"></jsp:include>
				</div>
			</div>

		</div>
		<div
			style="clear: both; margin: auto; text-align: center; width: 998px;"
			class="div-jianju">
			<span style="font-size: 12px;"> <%@ include
					file="/commons/jsp/include/aboutus.jsp"%>
			</span>
		</div>
	</div>


	<script type="text/javascript">
		function goToSearch() {
			if (!$.trim($('#so_input').val())) {
				alert("请输入查询关键字！");
				return;
			}
			document.frm.action = _contextPath + "/job/list/"
					+ "${curPlace.placeId }" + "_"
					+ "${curWorkType.workTypeId }" + "_" + encodeURI(encodeURI($("#so_input").val()))
					+ "_1";
			//alert(document.frm.action);
			document.frm.submit();
		}
		
		function func() {
			if(event.keyCode==13) {
				goToSearch();
			}
		}
	</script>
</body>
</html>
