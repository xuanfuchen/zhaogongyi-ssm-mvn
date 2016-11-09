<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<html>
<head>
<%
	String border = "0";//显示表格边框
	String ttwidth = "20%";//
	String h = "20px";
%>
<style type="text/css">
	body {
		margin: 0px auto;
		text-align: center;
	}
	.select-sty{
		height: 30px;
		border-bottom:#d4d4d4 1px solid;
		border-left:#d4d4d4 1px solid;
		padding-bottom:2px;
		margin-top:2px;
		padding-left:2px;
		padding-right:2px;
		vertical-align:middle;
		border-top:#d4d4d4 1px solid;
		border-right:#d4d4d4 1px solid;
		padding-top:2px;
	}
	
	.tb-class{
		text-align: center;
	}
	.zhanghaoxinxi{
		padding-bottom:30px;
		border-bottom: #dce5f1 1px solid;
	}
	.jibenziliao{
		padding-bottom:30px;
		border-bottom: #dce5f1 1px solid;
	}
	.zhaogongyixiang{
		border-bottom: #dce5f1 1px solid;
	}
	
	.tb-class table td{
		height: 32px;
	}
	.registered {
		font-size: 17px;
	}
</style>
</head>
<body>
<s:form id="frm" name="frm" method="POST">
	<table width="100%" border="0" cellspacing="0" cellpadding="5" >
		<tr class="personal-ifram-1">
	     <td colspan="3" align="left">
	     	<span class="personl-ifram-char-1">招聘信息</span>
	     </td>
		</tr>
		<tr>
			<td colspan="8" class="hr0">&nbsp;</td>
		</tr>
	</table>
	<table class="tb-class" width="100%" border="<%=border%>" bordercolor="red" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td align="center">
			<div style="border-width: 0px 0px 0px 0px;border-color:  #AACDE9;border-style: solid;">
					<%-- 基本资料信息 --%>
					<div class="jibenziliao">
						<table width="100%" border="<%=border%>" bordercolor="green" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" colspan="2" class="fenlan">
									简历资料
								</td>
								<td align="right"><a href="javascript:window.history.go(-1)" style="font-weight: bold;">返回</a></td>
							</tr>
							<tr>
								<td align="right" width="<%=ttwidth%>">
									简历名称：
								</td>
								<td style="border-right-width: 0;" colspan="2">
									${resumeInfo.resumeTitle }
								</td>
							</tr>
							<tr>
								<td align="left" colspan="3" class="fenlan">
									基本资料
								</td>
							</tr>
							<tr>
								<td align="right" width="<%=ttwidth%>">
									姓　　名：
								</td>
								<td style="border-right-width: 0;" colspan="2">
									${resumeInfo.fullName }
								</td>
							</tr>
							<tr>
								<td align="right">
									性　　别：
								</td>
								<td style="border-right-width: 0;" colspan="2">
									<c:choose>
										<c:when test="${resumeInfo.gender == 0 }">男</c:when>
										<c:otherwise>女</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td align="right">
									年　　龄：
								</td>
								<td style="border-right-width: 0;" colspan="2">
									${resumeInfo.age }岁
								</td>
							</tr>
							<tr>
								<td align="right">
									手机号码：
								</td>
								<td style="border-right-width: 0" colspan="2">
									${resumeInfo.cellPhone }
								</td>
							</tr>
							<tr>
								<td align="right">
									籍　　贯：
								</td>
								<td colspan="2" style="border-right-width: 0">
									${resumeInfo.jiguan }
								</td>
							</tr>
							<tr>
								<td align="right">
									学　　历：
								</td>
								<td style="border-right-width: 0" colspan="2">
									${resumeInfo.education }
								</td>
							</tr>
						</table>
					</div>

					<%-- 找工意向信息 --%>
					<div class="zhaogongyixiang">
						<table width="100%" border="<%=border%>" bordercolor="green" cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="3" align="left" class="fenlan">
									求职信息
								</td>
							</tr>
							
							<tr>
								<td align="right">
									求职标题：
								</td>
								<td style="border-right-width: 0" colspan="2">
									${resumeInfo.title }
								</td>
							</tr>
							<tr>
								<td align="right">
									联系邮箱：
								</td>
								<td style="border-right-width: 0" colspan="2">
									${resumeInfo.email }
								</td>
							</tr>
							
							<tr>
								<td align="right" width="<%=ttwidth%>">
									工作地点：
								</td>
								<td style="border-right-width: 0" colspan="2">
									${displayWorkPlace }
								</td>
							</tr>

							<tr>
								<td align="right" width="<%=ttwidth%>">
									工　　种：
								</td>
								<td width="160" style="border-right-width: 0">
									[${resumeInfo.workTypeIdFk }]${resumeInfo.workTypeName }
								</td>
								<td style="border-right-width: 0px;" width="452">
									&nbsp;
								</td>
							</tr>

							<tr>
								<td align="right">
									期望工资：
								</td>
								<td colspan="2">
									<c:choose>
										<c:when test="${resumeInfo.slyBegin != null && resumeInfo.slyEnd != null }">
											${resumeInfo.slyBegin }&nbsp;&nbsp;至&nbsp;&nbsp;${resumeInfo.slyEnd }&nbsp;&nbsp;元
										</c:when>
										<c:when test="${resumeInfo.slyBegin != null && resumeInfo.slyEnd == null }">
											${resumeInfo.slyBegin }&nbsp;&nbsp;以上
										</c:when>
										<c:when test="${resumeInfo.slyBegin == null && resumeInfo.slyEnd != null }">
											${resumeInfo.slyEnd }&nbsp;&nbsp;以下
										</c:when>
										<c:otherwise>面议</c:otherwise>
									</c:choose>
								</td>
							</tr>

							<tr>
								<td align="right">
									工作经验：
								</td>
								<td style="border-right-width: 0" colspan="2">
									${resumeInfo.exprTime }
								</td>
							</tr>

							<tr>
								<td align="right"> 
									介绍： 
								</td>
								<td colspan="2">
									<c:out value="${resumeInfo.introduce }"></c:out>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div style="height: <%=h %>;"></div>
				</div>
			</td>
		</tr>
	</table>
</s:form>
</body>
</html>
