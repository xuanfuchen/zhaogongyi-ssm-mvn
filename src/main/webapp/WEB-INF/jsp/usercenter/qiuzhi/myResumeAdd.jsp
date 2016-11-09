<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

.select-sty {
	height: 30px;
	border-bottom: #d4d4d4 1px solid;
	border-left: #d4d4d4 1px solid;
	padding-bottom: 2px;
	margin-top: 2px;
	padding-left: 2px;
	padding-right: 2px;
	vertical-align: middle;
	border-top: #d4d4d4 1px solid;
	border-right: #d4d4d4 1px solid;
	padding-top: 2px;
}

.tb-class {
	text-align: center;
}

.zhanghaoxinxi {
	padding-bottom: 30px;
	border-bottom: #dce5f1 1px solid;
}

.jibenziliao {
	padding-bottom: 30px;
	border-bottom: #dce5f1 1px solid;
}

.zhaogongyixiang {
	border-bottom: #dce5f1 0px solid;
}

.tb-class table td {
	height: 32px;
}

.registered {
	font-size: 17px;
}
</style>

<script type="text/javascript">
	function submitForm() {
		if (!validateCheck(document.frm)) {
			return;
		}
		if (!hasSelectPlace()) {
			return;
		}
		document.frm.action = _contextPath + '/my/addMyResume.do';
		document.frm.submit();
	}
</script>
</head>
<body>
	<form:form id="frm" name="frm" method="POST" commandName="resumeInfo">
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr class="personal-ifram-1">
				<td colspan="3" align="left"><span class="personl-ifram-char-1">招聘信息</span></td>
			</tr>
			<tr>
				<td colspan="8" class="hr0">&nbsp;</td>
			</tr>
		</table>
		<table class="tb-class" width="100%" border="<%=border%>" bordercolor="red" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td align="center">
					<div style="border-width: 0px 0px 0px 0px; border-color: #AACDE9; border-style: solid;">
						<%-- 基本资料信息 --%>
						<div class="jibenziliao">
							<table width="100%" border="<%=border%>" bordercolor="green" cellspacing="0" cellpadding="0">
								<tr>
									<td align="left" colspan="2" class="fenlan">简历资料</td>
									<td align="right"><a href="javascript:window.history.go(-1)" style="font-weight: bold;">返回</a></td>
								</tr>
								<tr>
									<td align="right" width="<%=ttwidth%>"><span class="redChar">*</span>简历名称：</td>
									<td style="border-right-width: 0;" colspan="2"><form:input path="resumeTitle" maxlength="10" cssClass=".notNull newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this, "", "mess0", "简历名称不能为空");' onfocus="chngBorderColorShowMsgDiv('', '简历名称不能为空', this)" />
										<label id="mess0"></label></td>
								</tr>
								<tr>
									<td align="left" colspan="3" class="fenlan">基本资料</td>
								</tr>
								<tr>
									<td align="right" width="<%=ttwidth%>"><span class="redChar">*</span>姓 名：</td>
									<td style="border-right-width: 0;" colspan="2"><form:input path="fullName" cssClass=".notNull newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this, "", "mess1", "姓名不能为空");' onfocus="chngBorderColorShowMsgDiv('', '姓名不能为空', this)" />
										<label id="mess1"></label></td>
								</tr>
								<tr>
									<td align="right"><span class="redChar">*</span>性 别：</td>
									<td style="border-right-width: 0;" colspan="2">
										<%
											Map<String, String> genders = new LinkedHashMap<String, String>();
												genders.put("0", "男");
												genders.put("1", "女");
												request.setAttribute("genders", genders);
										%> <form:radiobuttons path="gender" items="${genders }" />
									</td>
								</tr>
								<tr>
									<td align="right"><span class="redChar">*</span>年 龄：</td>
									<td style="border-right-width: 0;" colspan="2"><form:input path="age" cssClass=".notNull .isAge xiaoshurukuang"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this, "", "mess2", "年龄不能为空，格式正确");'
											onfocus="chngBorderColorShowMsgDiv('', '年龄不能为空，格式正确', this)" />岁 <label id="mess2"></label></td>
								</tr>
								<tr>
									<td align="right"><span class="redChar">*</span>手机号码：</td>
									<td style="border-right-width: 0" colspan="2"><form:input path="cellPhone" cssClass=".notNull .isMobile newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this, "", "mess3", "手机号码不能为空，格式正确");'
											onfocus="chngBorderColorShowMsgDiv('', '手机号码不能为空，格式正确', this)" /> <label id="mess3"></label></td>
								</tr>
								<tr>
									<td align="right"><span class="redChar">*</span>籍 贯：</td>
									<td colspan="2" style="border-right-width: 0"><form:input path="jiguan" id="jiguan" maxlength="15" cssClass=".notNull newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess4","请填写籍贯，长度为1-15位。")'
											onfocus="chngBorderColorShowMsgDiv('', '请填写籍贯，长度为1-15位。', this)" /> <label id="mess4"></label></td>
								</tr>
								<tr>
									<td align="right"><span class="redChar">*</span>学 历：</td>
									<td style="border-right-width: 0" colspan="2">
										<%
											Map<String, String> educations = new LinkedHashMap<String, String>();
												educations.put("初中以下", "初中以下");
												educations.put("初中", "初中");
												educations.put("高中", "高中");
												educations.put("技校", "技校");
												educations.put("中专", "中专");
												educations.put("大专", "大专");
												educations.put("本科", "本科");
												request.setAttribute("educations", educations);
										%> <form:select path="education" items="${educations }" cssClass="select-sty"></form:select>
									</td>
								</tr>
							</table>
						</div>

						<%-- 找工意向信息 --%>
						<div class="zhaogongyixiang">
							<table width="100%" border="<%=border%>" bordercolor="green" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="3" align="left" class="fenlan">求职信息</td>
								</tr>

								<tr>
									<td align="right"><span class="redChar">*</span>求职标题：</td>
									<td style="border-right-width: 0" colspan="2"><form:input maxlength="20" path="title" id="title" cssClass=".notNull newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess5","填入你想干的具体工作，字数不超过20个字。")'
											onfocus="chngBorderColorShowMsgDiv('','请填入你想干的具体工作，字数不超过20个汉字。',this)" /> <label id="mess5"></label></td>
								</tr>
								<tr>
									<td align="right"><span class="redChar">*</span>联系邮箱：</td>
									<td style="border-right-width: 0" colspan="2"><form:input maxlength="20" path="email" id="email" cssClass=".notNull .isEmail newinp"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess6","填入你的常用邮箱，你也可以使用注册帐号的默认邮箱")'
											onfocus="chngBorderColorShowMsgDiv('','填入你的常用邮箱，你也可以使用注册帐号的默认邮箱',this)" /> <label id="mess6"></label></td>
								</tr>

								<tr>
									<td align="right" width="<%=ttwidth%>"><span class="redChar">*</span>工作地点：<%-- 城市叫city，地区叫region，统称叫place --%></td>
									<td style="border-right-width: 0" colspan="2"><jsp:include page="/commons/jsp/include/placeSelect.jsp">
											<jsp:param name="selectNameValue" value="placeIdFk" />
											<jsp:param name="hiddenNameValue" value="placeName" />
										</jsp:include></td>
								</tr>

								<tr>
									<td align="right" width="<%=ttwidth%>"><span class="redChar">*</span>工 种：</td>
									<td width="160" style="border-right-width: 0"><form:input path="workTypeName" id="workTypeName" cssClass=".notNull newinp"
											cssStyle="cursor: pointer;" readonly="readonly" onclick="showWorkType('workTypeName')"
											onkeydown="if (window.event.keyCode!=8) execCommand('undo')" onkeyup="if (window.event.keyCode!=8) execCommand('undo')" /> <form:hidden
											path="workTypeIdFk" id="workTypeId" /></td>
									<td style="border-right-width: 0px;" width="452">&nbsp; <a href="javascript:showWorkType('workTypeName')" class="choose-wt2">选择工种</a>
										<div id='workType' style='display: none; position: absolute; z-index: 10; TOP: 840px; LEFT: 520px'>
											<iframe frameborder="0" id="wtIframe" src='<%=path%>/worktype/list' scrolling='no' width='400' height='440'></iframe>
										</div>
									</td>
								</tr>

								<tr>
									<td align="right">期望工资：</td>
									<td colspan="2"><form:input maxlength="5" size="3" cssClass=".isSalary xiaoshurukuang"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess17","请输入合法的数字")' onfocus="chngBorderColorShowMsgDiv('','',this);"
											path="slyBegin" /> &nbsp;&nbsp;至 <form:input maxlength="5" size="3" cssClass=".isSalary xiaoshurukuang"
											onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess17","请输入合法的数字")' onfocus="chngBorderColorShowMsgDiv('','',this);"
											path="slyEnd" /> &nbsp;&nbsp;元 &nbsp; <label id="mess17"></label></td>
								</tr>

								<tr>
									<td align="right"><span class="redChar">*</span>工作经验：</td>
									<td style="border-right-width: 0" colspan="2">
									
									<%
											Map<String, String> exprTimes = new LinkedHashMap<String, String>();
											exprTimes.put("1年以下", "1年以下");
											exprTimes.put("1-3年", "1-3年");
											exprTimes.put("3-5年", "3-5年");
											exprTimes.put("5-10年", "5-10年");
											exprTimes.put("10年以上", "10年以上");
											request.setAttribute("exprTimes", exprTimes);
										%>
										<form:select path="exprTime" items="${exprTimes }" cssClass="select-sty"></form:select>年
								</tr>

								<tr>
									<td align="right"><span class="redChar">*</span>介绍：</td>
									<td colspan="2"><form:textarea path="introduce" cols="50" rows="8" id="introduce" cssClass=".notNull text"
											onfocus='chngBorderColorShowMsgDiv("","",this);checkId(this,"","mess8","请输入自我介绍")' onblur="chngBorderColorHideMsgDiv(this)" />
										<label id="mess8"></label></td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<td colspan="2"><input type="button" value="确定" onclick="submitForm()" style="padding-top: 4px;" class="confirm-verify">&nbsp;&nbsp;
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div style="height: <%=h%>;"></div>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
