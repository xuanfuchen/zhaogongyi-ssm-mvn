<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.zhaogongyi.model.AcctInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<style type="text/css">
	.topbar {
		height: 24px;
		color: #666;
		border-bottom: 1px #CDCDCD solid;
		text-align: center;
		background-image: url("<%=request.getContextPath()%>/commons/images/common/topbar.png");
		background-repeat: repeat-x;
		background-position: 0px -6px;
	}
	.clearfix {
		clear: both;
	}
	.top-bd {
		width: 998px;
		margin: auto;
	}
	.top-left {
		float: left;
	}
	.top-right {
		float: right;
		line-height: 22px;
	}
	
	.acct-c {
		font-size: 12px;
	}
	
	.top-left span {
		padding: 0px;
		margin: 0px 3px;
	}
	.topbar span a:link {
		color: #666 !important;
		font-size: 12px;
		text-decoration: none;
	}
	.topbar span a:visited {
		color: #666 !important;
		font-size: 12px;
		text-decoration: none;
	}
	.topbar span a:hover {
		color: #666 !important;
		text-decoration: underline;
		font-size: 12px;
	}
	.gap {
		margin: 0px 6px;
		font-family: Tahoma;
		color: #ccc;
	}
	#login-1 {
		color: blue !important;
	}
</style>

<div class="topbar">
<div class="top-bd clearfix">
	<div class="top-left">
		<span>
			<a href="javascript:setHomepage('<%="http://www.zhaogongyi.com" %>')">设为首页</a>
		</span>
		<span>
			<a href="javascript:addFavorite('<%="http://www.zhaogongyi.com" %>', '招工易网-专业的招工网站')">收藏本站</a>
		</span>
	</div>
	<div class="top-right">
		<span>
			<%String h = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
			<a href="<%=h %>" target="_self">回到首页</a>
		</span>
		<span id="to_cp" class="acct-c">
			<span class="gap">|</span>
		<%
			AcctInfo acctInfo = (AcctInfo) session.getAttribute(com.zhaogongyi.util.Constants.LOGIN_SESSION_KEY);
			boolean hasLogin = acctInfo == null ? false : true;//是否已登录
			request.setAttribute("hasLogin", hasLogin);
			if (hasLogin){
				out.print(acctInfo.getAcctName() + "在线");
			}
			//其他情况不显示
		%>
		
		<c:choose>
			<c:when test="${hasLogin }">
				<a id="login-1" href="<%=request.getContextPath() %>/my/index" target="_self">用户中心</a></span>
			</c:when>
			<c:otherwise>
				<a id="login-1" href="<%=request.getContextPath() %>/reg/login" target="_self">用户登录</a></span>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${hasLogin }">
				<span class="gap">|</span>
				<span>
					<a href="<%=request.getContextPath() %>/reg/logout" target="_self">退出</a>
				</span>
			</c:when>
			<c:otherwise>
				<span class="gap">|</span>
				<span>
					<a href="<%=request.getContextPath() %>/reg/register" target="_self">注册</a>
				</span>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div>
</div>
</div>
<script type="text/javascript">
	function setHomepage(sURL) {
		if(isIE()){
			document.body.style.behavior = 'url(#default#homepage)';
			document.body.setHomePage(sURL);
		} else {
			alert("非 IE 浏览器请手动将本站设为首页");
		}
	}
	
	function isIE(){
      return (document.all && window.ActiveXObject && !window.opera) ? true : false;
	}
	
	function addFavorite(url, title) {
		try {
			window.external.addFavorite(url, title);
		} catch (e){
			try {
				window.sidebar.addPanel(title, url, '');
	        } catch (e) {
				alert("请按 Ctrl+D 键添加到收藏夹");
			}
		}
	} 
</script>