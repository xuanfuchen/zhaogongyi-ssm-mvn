<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.10 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function submitForm() {
		if(!validateCheck(document.frm)) {
			return;
		}
		if (!hasSelectPlace()) {
			return;
		}
	   	document.frm.action = _contextPath + "/my/issueJob.do";
	   	document.frm.submit();
 	}
 	function clearValue(obj) {
		if(obj.value.Trim() == '若干') {
			obj.style.color = "#000000";//黑色
			obj.value="";
		} 
	}
	function displayValue(obj) {
	   if(obj.value.Trim() == ''){
	   	  obj.style.color="gray";//灰色
	      obj.value= '若干';
	   }
	}
</script>
</head>
<body>
<div class="wrapper minheightout">
<s:form name="frm" id="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tr class="personal-ifram-1">
     <td colspan="100%" align="left">
     	<span class="personl-ifram-char-1">发布招聘</span>
     </td>
</tr>
<tr>
	<td colspan="100%" class="hr0">&nbsp;</td>
</tr>
<tr>
	<td align="right" width="15%">
		公司名称：
	</td>
	<td>
		${company.name }
		<s:hidden name="workInfo.companyName" value="%{company.name}" />
		<s:hidden name="workInfo.company.companyId" value="%{company.companyId}"/>
	</td>
	<td>
		<a href="javascript:window.history.go(-1)" style="font-weight: bold;">返回</a>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>招聘标题：</td>
	<td>
		<s:textfield name="workInfo.title" id="duty" cssStyle="text2" maxLength="50" 
		cssClass=".notNull newinp" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess3","招聘标题描述你想招什么工人，必填")' 
		onfocus="chngBorderColorShowMsgDiv('','招聘标题描述你想招什么工人，必填',this)" />
		<label id="mess3"></label>
	</td>
</tr>

<tr>
	<td align="right">
		<span class="redChar">*</span>工　　种：
	</td>
	<td>
		<s:textfield name="workInfo.workTypeName" id="workTypeName" 
				cssClass=".notNull newinp" cssStyle="cursor: pointer;" readonly="readonly"
				onclick="showWorkType('workTypeName')" 
				/>
		<s:hidden id="workTypeId" name="workInfo.workType.workTypeId" />
		<a href="javascript:showWorkType('workTypeName')" class="choose-wt2">选择工种</a>
		<div id='workType' style='display: none;position: absolute; z-index:10;TOP: 840px; LEFT: 520px'><iframe frameborder="0" id="wtIframe" src='<%=path %>/common/listWorkType.do' scrolling='no' width='400' height='440'></iframe></div>
	</td>
</tr>

<tr>
	<td align="right">
		<span style="color: red;" ></span>招聘人数：
	</td>
	<td>
		<s:textfield name="workInfo.num" cssClass=".isHireNum newinp" id="personNum" value='若干'
			cssStyle="text3;color:gray;ime-mode:Disabled;width:50px;" maxLength="3"
			onfocus="clearValue(this);chngBorderColorShowMsgDiv('','请填入招聘数字，不填默认招聘若干人',this)"
			onblur='displayValue(this);chngBorderColorHideMsgDiv(this);checkId(this,"","mess5","招聘人数必须是大于0的人数")'
			/><label id="mess5"></label>
		</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>经验要求：
	</td>
	<td>
		<s:select name="workInfo.exprTime"
			list="#{'不限':'不限','1年以下':'1年以下','1-3年':'1-3年','3-5年':'3-5年','5-10年':'5-10年','10年以上':'10年以上'}"
			label="工作年限"></s:select>
	</td>
</tr>
<tr>
	<td align="right">																		
		<span class="redChar">*</span>学历要求：
	</td>
	<td>
		<s:select name="workInfo.education"
			list="#{'不限':'不限','初中':'初中','高中':'高中','技校':'技校','中专':'中专','大专':'大专','本科':'本科'}"
			value="'不限'" label="学历要求"></s:select>
	</td>
</tr>
<tr>
	<td align="right">
		<span style="color: red;" ></span>提供薪水：
	</td>
	<td>
		<s:textfield maxlength="5" size="3" 
		cssClass=".isSalary xiaoshurukuang" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess17","请输入合法的数字")' 
		onfocus="chngBorderColorShowMsgDiv('','',this)" 
		name="workInfo.slyBegin"/>
		&nbsp;&nbsp;至
		<s:textfield maxlength="5"  size="3" 
		cssClass=".isSalary xiaoshurukuang" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess17","请输入合法的数字")' 
		onfocus="chngBorderColorShowMsgDiv('','',this)" 
		name="workInfo.slyEnd"/>
		&nbsp;&nbsp;元 &nbsp;
		<label id="mess17"></label>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>工作地点：
	</td>
	<td style="border-right-width: 0" colspan="1">
		<jsp:include page="/commons/jsp/include/placeSelect.jsp">
			<jsp:param name="selectNameValue" value="workInfo.place.placeId"/>
			<jsp:param name="hiddenNameValue" value="workInfo.placeName"/>
		</jsp:include>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>职位要求：
	</td>
	<td>
		<s:textarea name="workInfo.dutyReq" cssStyle="width:400px;height:150px;word-break:break-all"
		cssClass=".notNull newinp" 
		onfocus="chngBorderColorShowMsgDiv('','必填，请详细描述招聘要求',this)" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess18","必填，请详细描述招聘要求")'
		></s:textarea>
		<label id="mess18"></label>
	</td>
</tr>			
<tr>
	<td align="right">
		<span class="redChar">*</span>联 系 人：
	</td>
	<td>
		<s:textfield name="workInfo.contactPerson"
			cssStyle="text2" maxLength="50"
			cssClass=".notNull newinp" 
			onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess8","招聘联系人不能为空，50字以内")' 
			onfocus="chngBorderColorShowMsgDiv('','招聘联系人不能为空，50字以内',this)"/>
			<label id="mess8"></label>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>联系电话：
	</td>
	<td>
		<s:textfield name="workInfo.contactPhone"
		cssClass=".isPhone .notNull newinp" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess7","联系电话必填，请填入正确的格式");' 
		onfocus="chngBorderColorShowMsgDiv('','联系电话必填，请填入正确的格式',this)"
		/>
		<label id="mess7"></label>
	</td>
</tr>
<tr>
	<td align="right">
		<span class="redChar">*</span>电子邮箱：
	</td>
	<td align="left">
		<s:textfield name="workInfo.workEmail" value="%{workInfo.workEmail}" maxlength="40" 
		cssClass=".notNull .isEmail newinp" 
		onblur='chngBorderColorHideMsgDiv(this);checkId(this,"","mess11","请输入正确的邮箱地址")'
		onfocus="chngBorderColorShowMsgDiv('','默认使用帐号的邮箱，可以修改',this)"
		/>
		<label id="mess11"></label>
	</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td><input type="button" class="confirm-verify"
		onclick="submitForm()" value="发布招聘信息" />
	</td>
</tr>
</table>
</s:form>
</body>
</html>
