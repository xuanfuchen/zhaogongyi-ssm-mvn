<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="keywords" content="${workInfo.companyName },${workInfo.title },${workInfo.placeName }招工,${workInfo.placeName }招聘,<%=websiteName %>">
<meta name="description" content="${workInfo.companyName }${workInfo.placeName }招工、招聘${workInfo.title }。">
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<title>${workInfo.companyName }招${workInfo.title }-${workInfo.placeName }招工|${workInfo.placeName }招聘-<%=websiteName%></title>
<link href="<%=path%>/commons/jsp/css/main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
* {
	margin: 0 auto;
}

body {
	text-align: center;
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

.main-col-9 { /*width: 258px;*/
	width: 220px; /*增长20px*/
	float: right;
	height: 700px;
	/*border-left: #ccc 1px solid;*/
}

.main-col-9 {
	zoom: 1;
}

.main-col-9:after {
	display: block;
	height: 0px;
	visibility: hidden;
	clear: both;
	overflow: hidden;
	content: ".";
}

.main-col-10 { /*width: 495px;*/
	width: 770px; /*缩短16px*/
	float: left;
}

.main-col-10 {
	zoom: 1;
}

.main-col-10:after {
	display: block;
	height: 0px;
	visibility: hidden;
	clear: both;
	overflow: hidden;
	content: ".";
}

.DIV {
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
	margin: 0px;
}

.area-main {
	width: 998px;
	float: none;
}

.area-main {
	zoom: 1;
}

.area-main:after {
	display: block;
	height: 0px;
	visibility: hidden;
	clear: both;
	overflow: hidden;
	content: ".";
}

h1 {
	font-weight: normal;
	margin: 0px;
	padding: 0px;
	font-size: 20px;
	font-family: '微软雅黑,黑体'
}

div {
	text-align: left;
}

table {
	width: 100%;
	padding: 0px;
	margin: 0px;
}

/*div 间距，给需要的div提供间距*/
.div-jianju {
	margin-top: 10px;
	margin-bottom: 10px;
}

.tableHeadGray td {
	border-top: none;
}

table.same-ent-jobs th {
	font-size: 14px;
	text-align: left;
	line-height: 24px;
	padding-top: 4px;
	padding-bottom: 4px;
	border-bottom: #f1f1f1 1px solid;
	border-top: #fff 1px solid;
	font-weight: normal;
	background-color: #DEF1FF;
}

table.same-ent-jobs td {
	text-align: left;
	line-height: 28px;
	padding-top: 4px;
	padding-bottom: 4px;
	border-bottom: #f1f1f1 1px solid;
	border-top: #fff 1px solid;
}

a:link {
	font-size: 14px;
	color: #3950bf;
	text-decoration: none;
}

a:hover {
	font-size: 14px;
	color: #e37a7a !important;
	text-decoration: underline !important;
}

a:visited {
	font-size: 14px;
	color: #3950bf;
	text-decoration: none;
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

.fav_one {
	color: #999999;
	font-weight: bold;
}

.fav_two {
	cursor: pointer;
	color: #e37a7a;
	font-weight: bold;
}
</style>


</head>
<body>
	<div style="width: 100%; text-align: center; margin-top: 0px;">
		<%-- 头·logo --%>
		<div style="margin-top: 0px; margin-bottom: 0px; text-align: center;">
			<%@ include file="/commons/jsp/header/header.jsp"%>
		</div>
		<%-- firefox和chrome兼容，设置边框为1px白色，设置为透明不兼容ie6 --%>
		<div class="area-main" style="margin-top: 0px; margin-bottom: 0px; border: 1px solid white;">

			<%-- 右侧的广告 --%>
			<div class="main-col-9">
				<div style="margin-top: 8px; text-align: center; background-color: #E9E9E7;">
					<img alt="广告" src="<%=path%>/commons/images/ad/160_600_2.jpg">
				</div>
			</div>
			<%-- /右侧的广告 --%>

			<div class="main-col-10" style="margin-top: 0px; margin-bottom: 0px;">
				<%-- 基本信息 --%>
				<div>
					<table cellpadding="5" cellspacing="0" border="0" style="padding-top: 0px; margin-top: 0px;">
						<tr>
							<td><h1>${workInfo.title }</h1></td>
						</tr>

						<tr>
							<td height="37"><span style="font-size: 14px; line-height: 25px;"> 公司名称：${workInfo.companyName } <br> <span
									style="float: left;"> 公司行业：${company.trade }&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp; 公司性质：${company.type }&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
										公司规模：${company.grand }</span>
							</span></td>
						</tr>
					</table>
					<table id="tableDetail" border="0" align="center" cellpadding="5" cellspacing="1">
						<tr>
							<th width="12%" align="center">招聘人数</th>
							<td width="35%"><c:choose>
									<c:when test="${workInfo.num == null ||  workInfo.num == 0}">
										若干
									</c:when>
									<c:otherwise>${workInfo.num }人</c:otherwise>
								</c:choose></td>

							<th width="12%" align="center">工资水平</th>
							<td width="35%"><c:choose>
									<c:when test='${(workInfo.slyBegin == null || workInfo.slyBegin == "") && (workInfo.slyEnd == null || workInfo.slyEnd == "")}'>面议</c:when>
									<c:when test='${(workInfo.slyBegin != null && workInfo.slyBegin != "") && (workInfo.slyEnd != null && workInfo.slyEnd != "") }'>
										${workInfo.slyBegin }-${workInfo.slyEnd }&nbsp;元
									</c:when>
									<c:when test='${(workInfo.slyBegin == null || workInfo.slyBegin == "") && (workInfo.slyEnd != null && workInfo.slyEnd != "") }'>
										${workInfo.slyEnd }&nbsp;元以下
									</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<th align="center">学历要求</th>
							<td>
								<c:choose>
									<c:when test='${workInfo.education == null || "" == workInfo.education }'>不限</c:when> 
									<c:otherwise>${workInfo.education}</c:otherwise>
								</c:choose>
							
							</td>
							<th align="center">工作年限</th>
							<td>
								<c:choose>
									<c:when test='${workInfo.exprTime == null || "" == workInfo.exprTime }'>不限</c:when> 
									<c:otherwise>${workInfo.exprTime}</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th align="center">联 系 人</th>
							<td>${workInfo.contactPerson }</td>
							<th align="center">发布日期</th>
							<td>
								<fmt:formatDate value="${workInfo.publishDate}" pattern="yyyy-MM-dd"/> 
							</td>
						</tr>
						<tr>
							<th align="center">工作区域</th>
							<td>${workInfo.placeName }</td>
							<th align="center">联系邮箱</th>
							<td>
								<c:choose>
									<c:when test='${workInfo.workEmail == null || "" == workInfo.workEmail }'><span class="weitianxie">未填写（请电话联系）</span></c:when> 
									<c:otherwise>${workInfo.workEmail}</c:otherwise>
								</c:choose>
						</tr>
						<tr>
							<th align="center">联系电话</th>
							<td colspan="3"><span class="telNumber"> ${workInfo.contactPhone } </span></td>
						</tr>
					</table>
					<br>
					<table cellpadding="0" cellspacing="0">
						<tr>
							<%-- 发送邮件按钮 --%>
							<td colspan="1">
								<table cellpadding="0" cellspacing="0" style="border-collapse: collapse;">
									<tr>
										<td rowspan="2" width="125"><span style="float: left;"> 
										<c:choose>
											<c:when test='${workInfo.workEmail == null || "" == workInfo.workEmail }'>
												<input type="button" value="立刻投简历" disabled="disabled" class="bigButton" />
											</c:when> 
											<c:otherwise>
												<input type="button" value="立刻投简历" onclick='alert("实现中")' class="bigButton" />
											</c:otherwise>
										</c:choose>
										</span></td>
									</tr>
									<c:if test="${workInfo.workEmail == null || workInfo.workEmail == '' }">
										<tr>
											<td>&nbsp; <span style="color: black; font-size: 14px;">（该企业未留邮箱，请电话联系）</span>
											</td>
										</tr>
									</c:if>
								</table>
							</td>
						</tr>
						<tr>
							<td style="font-size: 14px; height: 30px;">联系我时，请一定说明在<%=websiteName%>看到的。该职位信息如有不实之处，请向<%=websiteName%>客服QQ举报
							</td>
						</tr>
					</table>
				</div>

				<%-- 左侧第一个广告 --%>
				<div class="div-jianju" style="text-align: center;"></div>

				<%-- /左侧第一个广告 --%>

				<%-- 文字信息 --%>
				<div>
					<div class="div-jianju">
						<table style="text-align: left;" border="0" align="center" cellpadding="3" cellspacing="1" class="bigName">
							<tr>
								<th align="left" class="linebottom">岗位要求</th>
							</tr>
							<tr>
								<td align="left" class="textline">${workInfo.dutyReq }</td>
							</tr>
						</table>
					</div>

					<div class="div-jianju">
						<table>
							<tr>
								<th align="left" class="linebottom">公司介绍</th>
							</tr>
							<tr>
								<td align="left" class="textline">${company.remark }</td>
							</tr>
						</table>
					</div>

					<div class="div-jianju">
						<table>
							<tr>
								<th align="left" class="linebottom">公司地址</th>
							</tr>
							<tr>
								<td align="left" class="textline">${company.addr }</td>
							</tr>
						</table>
					</div>
				
					<%-- 左侧第二个广告 --%>
					<div class="div-jianju" style="text-align: center;"></div>
					<%-- /左侧第二个广告 --%>
				</div>

				<%-- ★该公司所有职位★ --%>
				<div class="div-jianju">
					<br>
					<c:if test="${fn:length(workInfoList) > 0 }">
						<table>
							<tr>
								<th align="left">该公司最近发布的职位 <br></th>
							</tr>
							<tr>
								<td>
									<table border="0" cellspacing="0" cellpadding="5" class="same-ent-jobs">
										<tr>
											<th width="14%">工种 <br></th>
											<th width="25%">工作岗位 <br></th>
											<th width="10%">招聘人数 <br></th>
											<th width="18%">工资 <br></th>
											<th width="19%">工作区域 <br></th>
											<th width="14%">发布日期 <br></th>
										</tr>
										<c:forEach items="${workInfoList }" varStatus="st" var="tmp">
											<tr style="text-align: left;">
												<%-- 工种 --%>
												<td>${tmp.workTypeName }<br></td>
												<%-- 工作岗位 --%>
												<td><a target="_blank" href="<%=path %>/job/detail/${tmp.workId }" class="menuBlue"> ${tmp.title } </a> <br></td>
												<%-- 招聘人数 --%>
												<td>
												<c:choose>
												<c:when test="${tmp.num == null || tmp.num == '' }">若干</c:when>
												<c:otherwise>${tmp.num }</c:otherwise>
											</c:choose>
												
												</td>

												<%-- 工资 --%>
												<td>
													<c:choose>
														<c:when test="${(tmp.slyBegin != null && tmp.slyBegin != '') && (tmp.slyEnd == null || tmp.slyEnd == '') }">${tmp.slyBegin }元以上</c:when>
														<c:when test="${(tmp.slyBegin == null || tmp.slyBegin == '') && (tmp.slyEnd != null && tmp.slyEnd != '') }">${tmp.slyEnd }元以下</c:when>
														<c:when test="${tmp.slyBegin != null && tmp.slyBegin != '' && tmp.slyEnd != null && tmp.slyEnd!='' }">${tmp.slyBegin }元-${tmp.slyEnd }元</c:when>
														<c:otherwise>面议</c:otherwise>
													</c:choose>
													<br></td>
												<%-- 工作区域 --%>
												<td>${tmp.placeName }<br></td>
												<%-- 发布日期 --%>
												<td><fmt:formatDate value="${tmp.publishDate}" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</table>
					</c:if>
				</div>

				<div>
				<p class=small>评论区</p>
				<%-- 空评论警告 --%>
				<p id="warning"></p>
				<textarea id="comment_text" rows="3" cols="108" ></textarea>
				<button type="button" id="comment_sub" class="btn btn-primary btn-xs" >提交评论</button>
				</div>
				
				<br>
				<table border="0" cellspacing="0" cellpadding="5" class="same-ent-jobs">
				<tr>
						<th width="14%">用户<br></th>
						<th width="20%">评论内容 <br></th>
						<th width="10%" >评论时间 <br></th>
				</tr>
									<c:forEach items="${commentInfoList}" var="comm">
											<tr style="text-align: left;">
												<%-- 用户名 --%>
												<td style="text-align:left">${comm.acctName}<br></td>
												<%-- 评论内容 --%>
												<td> ${comm.content} <br></td>
												<%-- 创建时间--%>
												<td><fmt:formatDate value="${comm.createTime}" pattern="yyyy-MM-dd hh:mm"/> <br></td>
											</tr>
									</c:forEach>
									</table>
					     </div>
				  <div>

				<%-- 左边第三个广告 --%>
				<div class="div-jianju" style="margin-top: 20px;"></div>
				<%-- /左边第三个广告 --%>
			</div>
		</div>
	</div>
	
    <script type="text/javascript">
    
    $(document).ready(function(){
        $("#comment_sub").click(function(){
            if($('#comment_text').val() === ''){
              $('#warning').html("<div class='alert alert-warning' role='alert'>评论内容不能为空!</div>");
            }else{
                //将警告区域的信息清除
                $('#warning').html("");
                var content = $('#comment_text').val();
                var mydate = new Date();

                //alert(content);
                //$('#content').append(mydate.toLocaleDateString() + "：<br>" + content + "<hr>");
                
                //使用ajax来向后台传递数据
                $.ajax({
                 type: "post",
                 url: "<%=path%>/job/comment",
                 data : {
     				"workId":"${workInfo.workId}",
					"content":$('#comment_text').val()
     			},
                 success: function(msg){  
                	 alert("评论成功！");
                	 location.reload();
                 },
                 
                 error: function(msg){
                	 if("${CommentAction.loginUser == null}")
                     alert("先登录才能评论")
                	 else
                 	 alert("评论失败！")
                 }
                 });
                //清空文本区域
                $('#comment_text').val("");
            } 
        });
    });
    
    $(function() {
        $(function() {
            $("#comment_sub").click(settime);
        });
    });
    var countdown = 3;
    function settime() {
        if(countdown == 0) {
            $("#comment_sub").attr("disabled", false);
            countdown = 3;
        } else {
            $("#comment_sub").attr("disabled", true);
            countdown--;
            setTimeout(settime, 1000)
        }
    }</script>
</body>
</html>