<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>错误提示</title>
	<style type="text/css">
* {
	margin: 0 auto;
	text-align: center;
}

.hint {
	font-size: 22px;
	font-weight: bold;
	font-family: '微软雅黑';
	margin: auto 10px;
	vertical-align: top;
}

.bgdiv {
	width: 400px;
	height: 300px;
	/*background-color: #E9E9E7;*/
	margin-top: 100px;
}
</style>
<script type="text/javascript">	
	var time = parseInt(${time});
	$(function(){
		var timeShow = $('#timeShow');
		timeShow.text(time / 1000);
		showTime();
	});
	function showTime() {
		var timeShow = $('#timeShow');
		timeShow.text(time / 1000);
		time -= 1000;
		if(time < 0) {
			window.location.href = "<%=path%>${url}";
			timeShow.text(0);
			return;
		}
		setTimeout('showTime()', 1000);
	}
</script>
</head>
<body>
<div class="bgdiv">
<span><img alt="勾" src="<%=path %>/commons/images/common/icon_error.gif"></span>
<span class="hint">
<s:if test="#request.hint != null">
	${hint }
</s:if>
<s:else>操作失败</s:else>
系统将在<span style="color:blue" id="timeShow"></span>秒自动返回。<br>
</span>
</div>
</body>
</html>