<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table width="100%" border="0" cellpadding="3" cellspacing="0">
<tr>
	<td>
		公司名<s:textfield name="cond.companyName" />&nbsp;
		公司介绍<s:textfield name="cond.remark" />&nbsp;
		公司ID<s:textfield name="cond.companyId" cssStyle="width:60px;"/>&nbsp;
		&nbsp;&nbsp;<input type="button" value="查询" onclick="submitForm()">
	</td>
</tr>
<tr>
	<td>
		<a href="javascript:del()">删除</a>
	</td>
</tr>
</table>
<script type="text/javascript">
	var _contextPath = "<%=request.getContextPath() %>";
	var OPER_TYPE_RESUME = "<%=com.zhaogongyi.util.Constants.OPER_TYPE_CPY%>";
	function del() {
		if (!hasCheck('cbGroup')) {
			return;
		}
		if (!confirm("是否删除？如果删除公司信息，则该公司发布的招聘\n\n信息也会删除，删除后不可以恢复，请慎重操作!")) {
			return;
		}
		var reqStr = _contextPath + "/admin/del.do?type=" + OPER_TYPE_RESUME;
		document.frm.action = reqStr;
		document.frm.submit();
	}
	function submitForm() {
		var reqStr = _contextPath + "/admin/myAdminCompanyList.do?pager.thisPage=1";
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