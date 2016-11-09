<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table width="100%" border="0" cellpadding="3" cellspacing="0">
<tr>
	<td>
		公司名<s:textfield name="cond.companyName" />&nbsp;
		工作ID<s:textfield name="cond.workId" cssStyle="width:60px;"/>&nbsp;
		城市
		<jsp:include page="/commons/jsp/include/placeSelect.jsp">
			<jsp:param name="curPlace" value="${cond.placeId }"/>
			<jsp:param name="curPlaceName" value=""/>
			<jsp:param name="selectNameValue" value="cond.placeId"/>
			<jsp:param name="hiddenNameValue" value="cond.placeName"/>
		</jsp:include>
	</td>
</tr>
<tr>
	<td>
		标　题<s:textfield name="cond.title" />&nbsp;
		　　从<input name="cond.publishDateBegin" id="beginTime" value="${cond.publishDateBegin }"
		onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" readonly="readonly"/>&nbsp;&nbsp;到
    	<input name="cond.publishDateEnd" id="endTime" value="${cond.publishDateEnd }"
    	onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" readonly="readonly" />
    	&nbsp;&nbsp;<input type="button" value="查询" onclick="submitForm()">
	</td>
</tr>
<tr>
	<td>
		<a href="javascript:del()">删除</a>
    	<a href="javascript:hide()">隐藏</a>
    	<a href="javascript:open()">显示</a>
    	<a href="javascript:refresh()">刷新</a>
	</td>
</tr>
</table>
<script type="text/javascript">
	var _contextPath = "<%=request.getContextPath() %>";
	var OPER_TYPE_RESUME = "<%=com.zhaogongyi.util.Constants.OPER_TYPE_JOB%>";
	function del() {
		if (!hasCheck('cbGroup')) {
			return;
		}
		if (!confirm("是否删除？删除后不可以恢复，请慎重操作!")) {
			return;
		}
		var reqStr = _contextPath + "/admin/del.do?type=" + OPER_TYPE_RESUME;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function hide() {
		if (!hasCheck('cbGroup')) {
			return;
		}
		if (!confirm("是否全部隐藏？")) {
			return;
		}
		var reqStr = _contextPath + "/admin/hide.do?type=" + OPER_TYPE_RESUME;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function open() {
		if (!hasCheck('cbGroup')) {
			return;
		}
		if (!confirm("是否全部公开？")) {
			return;
		}
		var reqStr = _contextPath + "/admin/open.do?type=" + OPER_TYPE_RESUME;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function refresh() {
		if (!hasCheck('cbGroup')) {
			return;
		}
		if (!confirm("是否刷新全部最新发布时间？")) {
			return;
		}
		var reqStr = _contextPath + "/admin/refresh.do?type=" + OPER_TYPE_RESUME;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function submitForm() {
		if (!compareDate(document.getElementById("beginTime"), document.getElementById("endTime"))) {
			return;
		}
		var reqStr = _contextPath + "/admin/myAdminJobList.do?pager.thisPage=1";
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function hasCheck(name) {
		var flag = false;
		var len = 0;
		var chkboxes = document.getElementsByName(name);
		if(chkboxes){
			for(var i=0;i<chkboxes.length;i++){
				if(chkboxes[i].checked){
					len++;
				}
			}
		}
		if(len==0){
			alert("请先选择记录！");
		}else{
			flag = true;
		}
		return flag;
	}
</script>