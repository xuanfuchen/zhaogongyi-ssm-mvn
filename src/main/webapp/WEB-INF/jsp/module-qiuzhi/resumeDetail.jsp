\<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords"
	content="${resumeInfo.placeName }求职,${resumeInfo.placeName }找工作">
<meta http-equiv="description" content="${resumeInfo.placeName }找工作">
<meta name="robots" content="noindex, nofollow" />
<title>求职${resumeInfo.title } - ${resumeInfo.placeName }找工作|${resumeInfo.placeName }求职
	- <%=websiteName%></title>

<link href="<%=path%>/commons/jsp/css/main.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
td {
	word-wrap: break-word;
	word-break: break-all;
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

div {
	text-align: left;
}

* {
	margin: auto;
}

.right-ads {
	width: 220px;
	float: right;
}

.left-content {
	width: 770px;
	float: left;
}

h1 {
	font-weight: normal;
	margin: 0px;
	padding: 0px;
	font-size: 20px;
	font-family: '微软雅黑,黑体';
	margin-bottom: 7px;
	margin-top: 7px;
}

/*div 间距，给需要的div提供间距*/
.div-jianju {
	margin-top: 20px;
	margin-bottom: 20px;
}

table {
	width: 100%;
	padding: 0px;
	margin: 0px;
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
	<div style="text-align: center;">
		<div style="text-align: center; width: 998px;">
			<%-- 头 --%>
			<div>
				<%@ include file="/commons/jsp/header/header.jsp"%>
			</div>
			<%-- 右边的广告 --%>
			<div class="right-ads">
				<div
					style="margin-top: 8px; text-align: center; background-color: #E9E9E7;">
					<img alt="广告" src="<%=path%>/commons/images/ad/160_600_1.jpg">
				</div>
			</div>

			<%-- 左边的内容 --%>
			<div class="left-content">
				<%-- 基本信息 --%>
				<div>
					<table cellpadding="0" cellspacing="0">
						<tr height="32">
							<td>
								<%-- 面包屑 --%> <%--@ include file=""--%>
							</td>
						</tr>
						<tr>
							<td height="37">
								<h1>
									${resumeInfo.fullName } <span style="font-size: 14px;">（
										<c:choose>
											<c:when test="${resumeInfo.gender == 0 }">男</c:when>
											<c:otherwise>女</c:otherwise>
										</c:choose> <c:if test="${resumeInfo.age != null }">，${resumeInfo.age }岁</c:if>）
									</span>
								</h1>
							</td>
						</tr>
					</table>

					<table id="tableDetail" width="100%" border="0" align="center"
						cellpadding="5" cellspacing="1">
						<tr>
							<th width="12%" align="center">工 种</th>
							<td width="35%">${resumeInfo.workTypeName }</td>
							<th width="12%" align="center">从事岗位</th>
							<td width="35%">${resumeInfo.title }</td>
						</tr>

						<tr>
							<th align="center">学 历</th>
							<td>${resumeInfo.education }</td>
							<th align="center">籍 贯</th>
							<td><c:choose>
									<c:when
										test="${resumeInfo.jiguan == null || resumeInfo.jiguan == '' }"><span class="weitianxie">未填写</span>
									</c:when>
									<c:otherwise>${resumeInfo.jiguan }</c:otherwise>
								</c:choose></td>
						</tr>

						<tr>
							<th align="center">工作区域</th>
							<td>${resumeInfo.placeName }</td>
							<th align="center">工作年限</th>
							<td>${resumeInfo.exprTime }</td>
						</tr>

						<tr>
							<th align="center">薪资要求</th>
							<td><c:choose>
									<c:when
										test='${(resumeInfo.slyBegin == null || resumeInfo.slyBegin == "") && (resumeInfo.slyEnd == null || resumeInfo.slyEnd == "")}'>面议</c:when>
									<c:when
										test='${(resumeInfo.slyBegin != null && resumeInfo.slyBegin != "") && (resumeInfo.slyEnd != null && resumeInfo.slyEnd != "") }'>
										${resumeInfo.slyBegin }-${resumeInfo.slyEnd }&nbsp;元
									</c:when>
									<c:when
										test='${(resumeInfo.slyBegin == null || resumeInfo.slyBegin == "") && (resumeInfo.slyEnd != null && resumeInfo.slyEnd != "") }'>
										${resumeInfo.slyEnd }&nbsp;元以下
									</c:when>
								</c:choose></td>
							<th align="center">发布日期</th>
							<td><fmt:formatDate value="${resumeInfo.publishDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th align="center">电子邮箱</th>
							<td class="telNum"><c:choose>
									<c:when
										test="${resumeInfo.email == null || resumeInfo.email == '' }">
										<span class="weitianxie">未填写，请电话联系</span>
									</c:when>
									<c:otherwise>${resumeInfo.email }</c:otherwise>
								</c:choose>
							<th align="center">电 话</th>
							<td class="telNum" colspan="3">${resumeInfo.cellPhone }</td>
						</tr>
					</table>
				</div>

				<%-- 左边第一个广告 --%>
				<div class="div-jianju" style="text-align: center;"></div>


				<%-- 个人工作技能和工作经历介绍 --%>
				<div class="div-jianju">
					<table width="100%" border="0" align="center" cellpadding="3"
						cellspacing="1" class="bigName">
						<%-- 个人工作技能和工作经历介绍 --%>
						<tr>
							<th align="left" class="linebottom">个人工作技能和工作经历介绍</th>
						</tr>
						<tr>
							<td align="left" class="textline"><c:choose>
									<c:when
										test="${resumeInfo.introduce != null && resumeInfo.introduce != '' }">${resumeInfo.introduce }</c:when>
									<c:otherwise>
										<span class="weitianxie">未填写</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
				</div>
				
				<p>评论区</p>
				<p id="warning"></p>
				<textarea id="comment_text" rows="3" cols="108" ></textarea>
				<button type="button" id="comment_sub" class="btn btn-primary btn-xs" >提交评论</button>
				</div>
				
				<br>
				<table border="0" cellspacing="0" cellpadding="5" id="tableDetail">
				<tr>
						<th width="1%">用户<br></th>
						<th width="10%">评论内容 <br></th>
						<th width="5%" >评论时间 <br></th>
				</tr>
									<c:forEach items="${resumeList}" var="comm">
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


				<%-- 左边第二个广告 --%>
				<div class="div-jianju" style="text-align: center; float: left;">

				</div>
				<%-- 左边第三个广告 --%>
				<div class="div-jianju" style="text-align: center; float: left;">

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
				
                //使用ajax来向后台传递数据
                $.ajax({
                 type: "post",
                 url: "<%=path%>/resume/comment",
                 data : {
     				"resumeId":"${resumeInfo.resumeId}",
					"content":$('#comment_text').val()
     			},
     			
                 success: function(msg){
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
    }
    </script>
</body>
</html>