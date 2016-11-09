<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"><!-- comment -->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>用户中心</title>
<style type="text/css">
td {
	font-size: 14px;
}

A {
	color: #3950bf;
	cursor: pointer;
	text-decoration: none;
}

/*弹出的具体的div*/
table.consume-detail {
	border: 1px solid green;
	border-collapse: collapse;
	width: 100%;
	height: 100%;
}

table.consume-detail th,table.consume-detail td {
	text-align: left;
	line-height: 25px;
}

table.consume-detail th {
	font-weight: normal;
	text-align: right;
	width: 30%;
}

table.consume-detail td {
	padding-left: 10px;
}

#invoice_note,#detail_note {
	padding-right: 10px;
}

#fpsqqr {
	font-size: 12px;
	width: 512px;
	border: 1px solid #999999;
}

.title2 {
	width: 512px;
	height: 30px;
	border-bottom: 1px solid #999999;
	background: #F9F9F9;
	font-weight: bold;
	line-height: 28px;
	text-indent: 12px;
}

.conValue {
	font-weight: bold;
}
body {
	margin: 0 auto;
	text-align: center;
}

</style>
<script type="text/javascript"> 
	// 用户中心选中后改变样式
	function changeStyle(obj,itementry) {
		var objs = $("a[name='"+itementry+"']");
		if(objs){
			for(var i = 0; i < objs.length; i++) {
				$(objs[i]).removeClass("chosen-item");
			}
			for(var i = 0; i < objs.length; i++) {
				if(obj == objs[i]){
					$(obj).addClass("chosen-item");
					break;
				}
			}
		}
	}
</script>	
</head>
<body id="vipindex">
<%@ include file="/commons/jsp/header/header.jsp"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="width: 998px;"  align="center">
<tr>
<td valign="top" background="<%=path %>/commons/images/usercenter/index_top_bg.gif" style="background-repeat: repeat-x">
<table align="center"  id="allwidth" width="998">
<tr>
<td width="200" class="rightline" valign="top"><%-- 左边的导航 --%>
	<table class="navigator-table-1" cellpadding='0' cellspacing='0' id='secondTb' border="0">
		<tr>
			<td class="tableTitle">
				<div align="left">
					<span class="">用户中心</span>
				</div>
 			</td>
		</tr>
		<tr><%-- 第二个tr START --%>
			<td style="padding:0px 0px 0px 20px;">
				<table width='100%' cellpadding='0' cellspacing='0'>
					
					<%-- 密码安全 --%>
					<tr>
						<td valign="top" height='24px'>
							<table width='100%' cellpadding='0' cellspacing='0' border="0" id='havesub'>
					    		<tr onclick='displayOrNot("tr1","")'>
									<td align='left' class="menuTitle">
									 帐户安全
									</td>
								</tr>
								<tr id="tr1">
									<td style="padding: 0px 0px 0px 20px;">
										<table width='100%' cellpadding='0' cellspacing='0' class="subitem-1">
						    				<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/pwd" target="userFrame">修改密码</a>
												</td>
											</tr>
											<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/email" target="userFrame">修改邮箱</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					
					<tr>
						<td valign="top" height='24px'>
							<%-- 有子归类2 --%>
							<table width='100%' cellpadding='0' cellspacing='0' border="0" id='havesub'>
					    		<tr onclick='displayOrNot("tr2","")'>
									<td align='left' class="menuTitle">
									 求职模块
									</td>
								</tr>
								<tr id="tr2">
									<td style="padding: 0px 0px 0px 20px;">
										<table width='100%' cellpadding='0' cellspacing='0' class="subitem-1">
						    				<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/rlist/1" target="userFrame">我的简历</a>
												</td>
											</tr>
											<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/addresume" target="userFrame">添加简历</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table><%-- /有子归类 --%>
						</td>
					</tr>
					<%-- 
					<tr>
						<td valign="top" height='24px'>
							<table width='100%' cellpadding='0' cellspacing='0' border="0" id='havesub'>
					    		<tr onclick='displayOrNot("tr3","")'>
									<td align='left' class="menuTitle">
									 招聘模块(未完成)
									</td>
								</tr>
								<tr id="tr3">
									<td style="padding: 0px 0px 0px 20px;">
										<table width='100%' cellpadding='0' cellspacing='0' class="subitem-1">
											<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/jlist/1" target="userFrame">我的招聘</a>
												</td>
											</tr>
											
											<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/toIssueJob.do" target="userFrame">发布招聘</a>
												</td>
											</tr>
											
						    				<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="<%=path %>/my/cinfo" target="userFrame">公司资料</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>--%>
					
					<%-- 
					<tr>
						<td valign="top" height='24px'>
							<table width='100%' cellpadding='0' cellspacing='0' border="0" id='havesub'>
					    		<tr onclick='displayOrNot("tr4","")'>
									<td align='left' class="menuTitle">
									 其他功能
									</td>
								</tr>
								<tr id="tr4">
									<td style="padding: 0px 0px 0px 20px;">
										<table width='100%' cellpadding='0' cellspacing='0' class="subitem-1">
						    				<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="" target="userFrame">我的收藏</a>
												</td>
											</tr>
											<tr>
												<td align='left' height='24px'>
													<a onclick="changeStyle(this,'itementry')" name="itementry" href="" target="userFrame">系统消息</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr> --%>
				</table>
			</td>
		</tr><%-- 第二个tr END --%>
	</table>
</td><%-- 左边的导航 --%>
<td><%-- 右边的iframe --%>
	<iframe id="userFrame" name="userFrame" src="<%=path %>/usercenter/userFrame" width="100%" height="900" frameborder="0" scrolling="auto"></iframe>
</td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>