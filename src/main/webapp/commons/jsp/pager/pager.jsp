<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zhaogongyi.commons.pager.Pager"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Pager pager =(Pager) request.getAttribute("pager");
%>
<script type="text/javascript">
function mouseOver(obj)
{	var ChildNodes = obj.childNodes;
	if (obj.id=="pro"){
		obj.style.backgroundPosition = "0px -284px";
		ChildNodes[0].style.backgroundPosition = "right -173px";
		ChildNodes[0].style.color="#fff";
	}else if(obj.id=="next"){
		obj.style.backgroundPosition = "0px -173px";
		ChildNodes[0].style.backgroundPosition = "right -284px";
		ChildNodes[0].style.color="#fff";
	}else{
		obj.style.backgroundPosition = "0px -173px";
		obj.style.color="#fff";
		ChildNodes[0].style.color="#fff";
		ChildNodes[0].style.backgroundPosition = "right -173px";
	}

}

function mouseOut(obj)
{	var ChildNodes = obj.childNodes;
	if (obj.id=="pro"){
		obj.style.backgroundPosition = " 0px -261px";
		ChildNodes[0].style.backgroundPosition = "right -217px";
		ChildNodes[0].style.color="#3950bf";
	}else if(obj.id=="next"){
		ChildNodes[0].style.backgroundPosition = "right -261px";
		ChildNodes[0].style.color="#3950bf";
		obj.style.backgroundPosition = " 0px -217px";
		
	}else{
		//ChildNodes[0].style.backgroundPosition = "0 -173px";
		//obj.style.color="blue";
		//obj.style.backgroundPosition = "0 -173px";
		obj.style.backgroundPosition = " 0px -261px";
        ChildNodes[0].style.backgroundPosition = "right -217px";
        ChildNodes[0].style.color="#3950bf";
	}


}
</script>
<div id="pager" class="pager">
<c:if test="${pager.thisPage!=1 }">
	<a id="pro" onmouseover="javaScript:mouseOver(this);" onmouseout="javaScript:mouseOut(this)" class="prv" href="<%=pager.replacePageNum(pager.getThisPage() - 1) %>" ><span >上一页</span></a>
</c:if>
<%
int start = pager.getThisPage() - 4 < 1 ? 1 : pager.getThisPage() - 4;
int end = pager.getThisPage() + 6 > 11 ? pager.getThisPage() + 6 : 11;
end = end > pager.getPageCount() ? pager.getPageCount() : end;
for(int i = 1; i < start; i++) {
	if (i > 3 || i+1 > start) {
		out.print("...");
		break;
	}
	%>
	<a name="pn" href='<%=pager.replacePageNum(i) %>'>
	<span  ><%=i %></span>
	</a>
	<%
}

for(int i = start; i < end + 1; i++) {
if(i == pager.getThisPage()) {
	%>
	<strong name="pn" href='<%=pager.replacePageNum(i) %>'>
	<span><%=i %></span></strong>
	<% 
		}else{
	%>
	<a name="pn" href='<%=pager.replacePageNum(i) %>'>
	<span ><%=i %></span></a>
	<% 
	 }
}
%>
<c:if test="${pager.pageCount>pager.thisPage }">
	<a id="next" class="next" href="<%=pager.replacePageNum(pager.getThisPage() + 1) %>" ><span>下一页</span></a>
</c:if>
</div>

<style type="text/css">
.pager{
	text-align:center;
	line-height: 22px;
	font-family: "宋体"; BACKGROUND: #fff;
	margin: 9px;
}
A{
	color: #3950bf;
	cursor: pointer;
	text-decoration: none;
}
	
.pager A{
	background-image: url(<%=path %>/commons/images/pager/pager.png) !important;
	background-repeat: no-repeat;
	}
.pager A{
	padding-bottom:0px;
	margin: 0px 1px;
	padding-left: 1px;
	padding-right: 0px;
	display:inline-block ;
	text-decoration:none;
	background-position: 0px -217px;
	padding-top: 0px; 
	
}
.pager A.prv{
	padding-left: 11px;
	background-position: 0px -261px;
}
.pager A.next span{
	padding-right: 18px;
	background-position: right -261px;
}
.pager A span{
	background-image: url(<%=path %>/commons/images/pager/pager.png) !important;
	background-repeat: no-repeat;
}
.pager A span{
	padding-bottom:0px;
	padding-left: 6px;
	padding-right: 7px;
	display: inline-block;
	background-position: right -217px;
	padding-top: 0px;
}

.pager A:hover{
	background-image:url(<%=path %>/commons/images/pager/pager.png) !important;
	background-repeat: no-repeat;
	background-position: 0px -173px;
	color:#fff;
}
.pager A:hover span{
	background-image: url(<%=path %>/commons/images/pager/pager.png) !important;
	background-position: right -173px;
	background-repeat: no-repeat;
	color:#fff;
}

.pager strong{
	background-image:url(<%=path %>/commons/images/pager/pager.png) !important;
	background-repeat: no-repeat;
}
.pager strong{
	padding-bottom: 0px;
	margin: 0px 1px;
	padding-left: 1px;
	padding-right:0px;
	display: inline-block;
	background-position: 0px -217px;
	padding-top: 0px;
}
.pager strong{
	background-position:0px -173px;
	color: #fff;
	text-decoration:none;
	
}
.pager strong{
	font-weight: 700;
}
.pager strong span{
	background-image:url(<%=path %>/commons/images/pager/pager.png) !important;
	background-repeat: no-repeat;
}
.pager strong span{
	padding-bottom: 0px;
	padding-left: 6px;
	padding-right: 7px;
	display: inline-block;
	background-position:right -217px;
	padding-top: 0px;
}
.pager strong span{
	background-position:right -173px;
}
</style>