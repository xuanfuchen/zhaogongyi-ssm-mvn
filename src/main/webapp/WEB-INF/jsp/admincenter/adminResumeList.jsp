<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript">
		function modifyRsm(rid) {
			var reqStr = _contextPath + "/my/toEditRsm.do?rid=" + rid;
			document.frm.action = reqStr;
			document.frm.submit();
		}
		function delRsm(rid) {
			if (!confirm("是否删除？删除后不能恢复！")) {
				return;
			}
			var reqStr = _contextPath + "/my/delRsm.do?rid=" + rid;
			document.frm.action = reqStr;
			document.frm.submit();
		}
		function refreshRsm(rid) {
			if (!confirm("是否刷新简历的最新时间？")) {
				return;
			}
			var reqStr = _contextPath + "/my/refreshRsm.do?rid=" + rid;
			document.frm.action = reqStr;
			document.frm.submit();
		}
		function openRsm(rid) {
			if (!confirm("是否公开简历，公开后用人单位能搜到你的简历？")) {
				return;
			}
			var reqStr = _contextPath + "/my/openRsm.do?rid=" + rid;
			document.frm.action = reqStr;
			document.frm.submit();
		}
		function hideRsm(rid) {
			if (!confirm("是否关闭公开，关闭后任何人都查不到你的简历？")) {
				return;
			}
			var reqStr = _contextPath + "/my/hideRsm.do?rid=" + rid;
			document.frm.action = reqStr;
			document.frm.submit();
		}
		function viewRsm(rid) {
			var reqStr = _contextPath + "/my/viewRsm.do?rid=" + rid;
			document.frm.action = reqStr;
			document.frm.submit();
		}
	</script>
</head>
<body>
<div class="wrapper minheightout">
<s:form name="frm" id="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="5" id="myTable">
	<tr class="personal-ifram-1">
      <td colspan="3" align="left">
      	<span class="personl-ifram-char-1">管理简历信息</span>
      </td>
	</tr>
	<tr>
		<td colspan="8" class="hr0">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="100%">
			<%@ include file="/WEB-INF/jsp/admincenter/adminQryResumeHeader.jsp" %>
		</td>
	</tr>
	<tr class="tableHead" valign="top">
		<td width="6%" align="center">
        	<input type="checkbox" onclick="cbCheck(this, 'cbGroup')" />
        </td>
		<td width="20%" align="left" id="workKindNameSort" >
			简历名称
		</td>
		<td width="14%" align="left" id="workKindNameSort" >
			姓名
		</td>
		<td width="5%" align="left" id="workKindNameSort" >
			地点
		</td>
		<td width="10%" align="left" id="workKindNameSort" >
			工种
		</td>
		<td width="20%" align="left" id="workKindNameSort" >
			标题
		</td>
		<td width="8%" align="left" id="dutySort" >
			状态
		</td>
		<td width="" align="left" id="pubDateSort" >
			更新时间
		</td>
	</tr>

	<tbody>
		<s:iterator value="listPage.list" status="s">
			<tr
				<s:if test="(#s.index + 1) % 2 == 0">class="tableRow2" onmousemove="this.className='tableRow3'" onmouseout="this.className='tableRow2'"</s:if>
				<s:else>class="tableRow1" onmousemove="this.className='tableRow3'" onmouseout="this.className='tableRow1'"</s:else>
			         >
			<td align="center">
	             <input type="checkbox" name="cbGroup" value="${RESUME_ID }" />
            </td>
			<td align="left">
				[${RESUME_ID }]<a href="<%=path %>/qiuzhi/toResumeDetail.do?rid=${RESUME_ID }" target="_blank">${RESUME_TITLE }</a>
			</td>
			<td align="left">
				${FULL_NAME }(<s:property value='GENDER == 0 ? "男" : "女"'/>,${AGE })
			</td>
			<td align="left">
				${PLACE_NAME }
			</td>
			<td align="left">
				${WORK_TYPE_NAME }
			</td>
			<td align="left">
				${TITLE }
			</td>
			<td>
				<s:if test='DIS_FLAG == 1'>公开</s:if><s:else>保密</s:else>
			</td>
			
			<td align="left">
				<s:date name="PUBLISH_DATE" format="yyyy-MM-dd HH:mm" />&nbsp;
			</td>
		</tr>
	</s:iterator>
</tbody>
</table>
<div class="line">
	<jsp:include page="/commons/jsp/pager/simplePager.jsp">
		<jsp:param name="formName" value="frm" />
		<jsp:param name="id" value="1" />
	</jsp:include>
</div>
</s:form>
</body>
</html>
