<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登录欢迎页</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<style type="text/css">
	body {
		font-size: 14px;
		font-family: '宋体';
	}
	.waiceng {
		line-height: 25px;
	}
	
	.neiceng1 {
		color: #169B00;
		height: 30px;
		font-size: 18px;
		font-weight: bold;
		vertical-align: top;
		border-bottom: 1px solid #AFCFEF;	
	}
	
	.neiceng2 ol li {
		margin: 10px 0px;
	}
	
	.neiceng2 {
		
	}
	strong {
		font-weight: normal;
		color: red;
	}
</style>
</head>
<body>
	<div class="waiceng">
		<div class="neiceng1">
			<span style="float: left;">欢迎您！</span>
		</div>
		
		<div class="neiceng2">
			<ol>
				<li>
					请点击左边菜单的相关选项进行操作。
				</li>
				<li>
					严禁发布虚假简历信息或招聘信息，违者查封帐号，涉及违法犯罪的(如诈骗、拐骗等)移交公安机关处理！
				</li>
			</ol>
		</div>
	</div>
</body>
</html>
