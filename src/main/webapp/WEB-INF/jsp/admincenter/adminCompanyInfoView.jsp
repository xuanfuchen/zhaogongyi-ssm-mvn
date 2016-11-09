<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function editCompanyInfo(cid) {
		document.frm.action = _contextPath + '/my/toEditCompanyInfo.do?cid=' + cid;
		document.frm.submit();
	}
</script>
<style type="text/css">
	* {
		margin: 0 auto;
		text-align: center;
	}
	.main_table td {
		text-align: left;
	}
	.main_table th {
		text-align: right;
	}
	
	.main_table {
		margin-top: 40px;
	}
	.remarkdivtr {
		
	}
	.remarkdiv {
		margin: 10 0 10 0;
		background-color: #F5F5F5;
		text-align: left;
		padding: 10px;
	}
	.sub_table {
		margin-left: 30px;
	}
	table.same-ent-jobs th{
		font-size: 14px;
		text-align:left;
		line-height:24px;
		padding-top: 4px;
		padding-bottom: 4px;
		border-bottom: #f1f1f1 1px solid;
		border-top: #fff 1px solid;
		font-weight: normal;
		background-color: #DEF1FF;
	}
	table.same-ent-jobs td{
		text-align:left;
		line-height: 28px;
		padding-top: 4px;
		padding-bottom: 4px;
		border-bottom: #f1f1f1 1px solid;
		border-top: #fff 1px solid;
	}
</style>
</head>
<body>
<div class="wrapper minheightout">
<s:form name="frm" id="frm" method="post">
<table width="800px;" border="0" cellspacing="0" cellpadding="5" class="main_table">
<tr class="personal-ifram-1">
     <td colspan="100%" align="left">
     	<span class="personl-ifram-char-1" style="float: left;">管理员查看公司资料</span><a href="javascript:window.close()" style="font-size: 16px;font-weight: bold;color: #0000FF;float: right;">关闭</a>
     </td>
</tr>
<tr>
	<td colspan="100%" class="hr0">&nbsp;</td>
</tr>
<tr>
	<th align="right" width="15%">
		公司名称：
	</th>
	<td>
		${company.name }
	</td>
</tr>

<tr>
	<th align="right">
		行　　业：
	</th>
	<td>
		${company.trade }
	</td>
</tr>
<tr>
	<th align="right">
		公司性质：
	</th>
	<td>
		${company.type }
	</td>
</tr>
<tr>
	<th align="right">
		规　　模：
	</th>
	<td>
		${company.grand }
	</td>
</tr>
<tr>
	<th align="right">
		联系电话：
	</th>
	<td>
		${company.comPhone }
	</td>
</tr>
<tr>
	<th align="right">
		联系邮箱：
	</th>
	<td>
		${company.comEmail }&nbsp;
	</td>
</tr>
<tr>
	<th align="right">
		公司地址：
	</th>
	<td>
		${company.addr }
	</td>
</tr>
<tr class="remarkdivtr">
	<th align="right">
		企业简介：
	</th>
	<td>
		<div class="remarkdiv">${company.remark }</div>
	</td>
</tr>

<tr>
	<td colspan="100%">
		<table class="sub_table" width="100%" border="0">
		<tr>
			<td>
				<span style="font-weight: bold;">该公司所有的工作(包括保密的)：</span>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" cellspacing="0" cellpadding="5" class="same-ent-jobs" width="100%">
					<tr>
						<th width="14%">
							工种
						</th>
						<th width="28%">
							工作岗位
						</th>
						<th width="10%">
							招聘人数
						</th>
						<th width="12%">
							工资
						</th>
						<th width="12%">
							工作区域
						</th>
						<th width="">
							状态
						</th>
						<th width="">
							发布日期
						</th>
					</tr>
					<s:if test="workInfoList == null || workInfoList.size() <=0 ">
						<tr>
							<td colspan="100%">该公司还未发布任何工作</td>
						</tr>
					</s:if>
					<s:else>
					<s:iterator status="st" value="workInfoList">
						<tr style="text-align: left;" <s:if test="#st.even==true">class="tableRowSameWork2" onmouseout="this.className='tableRowSameWork2'"</s:if> <s:else>class="tableRowSameWork1" onmouseout="this.className='tableRowSameWork1'"</s:else> onmouseover="this.className='tableRowSameWork3'">
							<%-- 工种 --%>
							<td>
								${workTypeName }
							<br></td>
							<%-- 工作岗位 --%>
							<td>
								[${workId }]
								<a target="_blank" href="<%=path %>/zhaopin/toJobDetail.do?wid=${workId }" class="menuBlue">
									${title }
								</a>
							<br></td>
							<%-- 招聘人数 --%>
							<td>
								<s:if test="num == null || num == ''">若干</s:if>
								<s:else>${num }</s:else>
							<br></td>
							
							<%-- 工资 --%>
							<td>
								<s:if test="(slyBegin != null && slyBegin != '') && (slyEnd == null || slyEnd == '')">
									${slyBegin }元以上
								</s:if>
								<s:elseif test="(slyBegin == null || slyBegin == '') && (slyEnd != null && slyEnd != '')">
									${slyEnd }元以下
								</s:elseif>
								<s:elseif test="slyBegin != null && slyBegin != '' && slyEnd != null && slyEnd!=''">
									${slyBegin }元-${slyEnd }元
								</s:elseif>
								<s:elseif test="(slyBegin == null || slyBegin == '') && (slyEnd == null || slyEnd == '')">	
									面议
								</s:elseif>
							<br></td>
							<%-- 工作区域 --%>
							<td>
								${placeName }
							<br></td>
							<%-- 工作区域 --%>
							<td>
								<s:property value='disFlag == 0 ? "保密" : "公开"'/>
							<br></td>
							<%-- 发布日期 --%>
							<td>
								<s:date name="publishDate" format="yyyy-MM-dd HH:mm" />
							</td>
						</tr>
					</s:iterator>
					</s:else>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
</s:form>
</body>
</html>
