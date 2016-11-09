<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>您所访问的页面不存在</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.bigCenter{
			font-size: 25px;
			color: red;
			font-weight: bold;
			
		}
		.bigCenter2{
			font-size: 22px;
			color: black;
			font-weight: bold;
			
		}
		table td{
			height: 30px;
		}
	</style>
  </head>
  
  <body>
    <table width="100%">
    	<tr>
    		<td>
    			<%@ include file="/commons/jsp/header/header.jsp" %>
    		</td>
    	</tr>
    </table>
    <table width="80%" border="0" style="border-collapse: collapse;" align="center">
    	<tr>
    		<td align="right" colspan="2">
    			<img src="<%=path %>/commons/images/usercenter/redo.gif" alt="返回首页"><a href="<%=home%>">返回首页</a>
    		</td>
    	</tr>
    	<tr>
    		<td width="30%">
    			&nbsp;
    		</td>
    		<td align="left" colspan="1">
    			<span class="bigCenter">对不起，您查看的内容已被删除</span>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2">&nbsp;</td>
    	</tr>
    	<tr>
    		<td>&nbsp;</td>
    		<td align="left">
    			<span class="bigCenter2">您还可以：</span><br>
    		</td>
    	</tr>
    	<tr>
    		<td width="400">&nbsp;</td>
    		<td align="left">
    			1、检查刚才的输入
    		</td>
    	</tr>
   		<tr>
	   		<td width="400">&nbsp;</td>
	   		<td align="left">
	   			2、选择<a href="<%=home%>">返回首页</a>
	   		</td>
	   	</tr>
    </table>
  </body>
</html>
