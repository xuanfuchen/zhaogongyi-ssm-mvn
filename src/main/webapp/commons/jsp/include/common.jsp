<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String websiteName = "招工易" + "网";
	String website = "zhaogongyi";
	String home = basePath;
	String company = "招工易信息技术有限公司";
%>
<script type="text/javascript">
	var _contextPath = '<%=request.getContextPath()%>';
</script>
<script type="text/javascript" src="<%=path%>/commons/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/commons/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/commons/js/prompt.js"></script>
<script type="text/javascript" src="<%=path%>/commons/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=path%>/commons/jsp/css/main.css" rel="stylesheet" type="text/css" />
