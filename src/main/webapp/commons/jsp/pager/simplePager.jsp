<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<style>
	A{
		color: #3950bf;
		cursor: pointer;
		text-decoration: none;
	}
</style>
<table style="font-size:14px;">
	<tr>
	  <!--	<td valign="bottom">
			共<font color="#FF0000"><b><s:property value="pager.total" /></b></font>条

      		&nbsp;
      	</td>
		<td valign="bottom">
			每页<font color="#FF0000"><b><s:property value="pager.pageSize" /></b></font>条

      		&nbsp;
      	</td>  -->
      	<td valign="bottom">
      		第<font color="#FF0000"><b>${pager.thisPage }</b></font>页

      		&nbsp;
      	</td>
		<td valign="bottom">
			共<font color="#FF0000"><b>${pager.pageCount }</b></font>页

      		&nbsp;
      	</td>
      	<td valign="bottom">
			<a name="firstP" href="javascript:firstPage()">首页</a>
			<a name="preP" href="javascript:prePage()">上一页</a>
			<a name="nextP" href="javascript:nextPage()">下一页</a>
			<a name="lastP" href="javascript:lastPage()">尾页</a>
			&nbsp;
      	</td>
      	<td valign="bottom">
      		跳转到第
			<input type="text" class="borderGray" style="width:40px" id='goPageTxt<%=request.getParameter("id")%>' onkeydown="submitByenter()">
			页
			<input type="button" value=" 跳转 " onclick='goPage<%=request.getParameter("id")%>()' style="width:60px; height:22px" />
		</td>
	</tr>
</table>

<%if(Integer.parseInt(request.getParameter("id")) < 2){ %>
<input type="hidden" id="thisPage" name="pager.thisPage">
<input type="hidden" id="pageCount" name="pager.pageCount">
<input type="hidden" id="sortField" name="pager.sortField">
<input type="hidden" id="sortType" name="pager.sortType">
<input type="hidden" id="excel" name="pager.excel">
<input type="hidden" id="tdx" name="pager.tdx">
<%} %>

<script type="text/javascript">

function submitByenter(){
	if(event.keyCode==13){//13是回车键
		goPage<%=request.getParameter("id")%>();
	}
}

function nextPage()
{
	var thisPage = document.getElementById('thisPage');
	var pageCount = document.getElementById('pageCount');
	if(parseInt(thisPage.value) >= parseInt(pageCount.value))
		return;
		
	thisPage.value = parseInt(thisPage.value) + 1;
	
	var frm = document.<%=request.getParameter("formName")%>;
	frm.submit();
}

function prePage()
{
	var thisPage = document.getElementById('thisPage');
	var pageCount = document.getElementById('pageCount');
	if(parseInt(thisPage.value) <= 1)
		return;
		
	thisPage.value = parseInt(thisPage.value) - 1;
	
	var frm = document.<%=request.getParameter("formName")%>;
	frm.submit();
}

function firstPage()
{
	var thisPage = document.getElementById('thisPage');
	if(parseInt(thisPage.value) <= 1)
		return;
	thisPage.value = 1;
	var frm = document.<%=request.getParameter("formName")%>;
	frm.submit();
	
}

function lastPage()
{
	var thisPage = document.getElementById('thisPage');
	var pageCount = document.getElementById('pageCount');
	if(parseInt(thisPage.value) >= parseInt(pageCount.value))
		return;
	thisPage.value = pageCount.value;
	var frm = document.<%=request.getParameter("formName")%>;
	frm.submit();
}

function goPage<%=request.getParameter("id")%>()
{
	var p = /^[1-9]{1}[0-9]*$/;
	var goPageTxt = document.getElementById('goPageTxt<%=request.getParameter("id")%>');
	if(!p.exec(goPageTxt.value))
	{
		alert('请输入有效的数字');
		return;
	}
	var thisPage = document.getElementById('thisPage');
	var pageCount = document.getElementById('pageCount');
	if(parseInt(goPageTxt.value) < 1)
		goPageTxt.value = 1;
	else if(parseInt(goPageTxt.value) > parseInt(pageCount.value))
		goPageTxt.value = pageCount.value;
	thisPage.value = goPageTxt.value;
	var frm = document.<%=request.getParameter("formName")%>;
	frm.submit();
}

//排序
//field 数据库字段名
function sortByField(field)
{
	var sortField = document.getElementById('sortField');
	var sortType = document.getElementById('sortType');
	sortType.value = (' asc' == sortType.value) ? ' desc' : ' asc';
	
	sortField.value = field;
	document.getElementById('thisPage').value = 1;
	var frm = document.<%=request.getParameter("formName")%>;
	frm.submit();
}


//用这个的时候一定要在td上添加id属性,id随便起
function toSort(field, obj)
{
	var tdx = document.getElementById('tdx');
	tdx.value = obj.id;
	sortByField(field);
}


function initPager()
{
	var id = parseInt('<%=request.getParameter("id")%>');
	var firstP = document.getElementsByName('firstP')[id-1];
	var preP = document.getElementsByName('preP')[id-1];
	var nextP = document.getElementsByName('nextP')[id-1];
	var lastP = document.getElementsByName('lastP')[id-1];
	var pageCount = document.getElementById('pageCount');
	var thisPage = document.getElementById('thisPage');
	var color = 'gray';
	if(parseInt(thisPage.value) <= 1)
	{
		firstP.style.color = color;
		preP.style.color = color;
	}
	if(parseInt(thisPage.value) >= parseInt(pageCount.value))
	{
		nextP.style.color = color;
		lastP.style.color = color;
	}
	
	var tdx = document.getElementById('tdx');
	var sortType = document.getElementById('sortType');
	if('' != tdx.value && tdx.value != null)
	{
		var realTd = document.getElementById('' + tdx.value);
		var sign = '↓';
		if(' asc' == sortType.value)
			sign = '↑';
		realTd.innerHTML += '<span>' + sign + '</span>';
	}
}

initPager();
</script>