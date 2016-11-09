<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/include/common.jsp" %>
<%@ page import="com.zhaogongyi.model.vo.WorkTypeCountVO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><%=websiteName %>--选择工种</title>
<link href="<%=path%>/commons/jsp/css/0903main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
     function selectNode(workTypeId, workTypeName){
        var workTypeId_elem = window.parent.document.getElementById("workTypeId");
        var workTypeName_elem = window.parent.document.getElementById("workTypeName");
        if(workTypeId_elem){
        	workTypeId_elem.value = workTypeId;
        }
        if(workTypeName_elem){
        	 workTypeName_elem.value = workTypeName;
        }
      	closeWorkType();
    }
    
    function closeWorkType(){
    	$("#workType",window.parent.document.body).hide();
    }
</script>
</head>
<body bgcolor="#ffffff">
	<table width="100%" border="0"	cellpadding="3" cellspacing="0" id="bigfonttable">
		<tr><td class="top-belt">请选择工种</td>
		<td class="top-belt-right"><span title=关闭 style="cursor: pointer;color:red;font-size:12px;font-weight:bold;margin-right:2px;" onclick='closeWorkType()' >×</span></td></tr>
		<tr>
			<td colspan="2">
				<table  border="0" width="100%">
				<%
				List workTypeList =(List) request.getAttribute("workTypeList");
				int tempNumber = 0;
				String flag = "";
				WorkTypeCountVO wtcVo = null;
				int tradeNumber = 1;//行业的数量
				for(int i=0;i<workTypeList.size();i++){
					wtcVo =(WorkTypeCountVO) workTypeList.get(i);
					
					if ((!wtcVo.getPid().equals(flag)) && i > 0){
						tempNumber = 0;
						out.print("</tr>");
					}													
					if ((tempNumber)%4==0){
						out.print("<tr style='font-size: 13px;' height='20px'>");
					}
					%>
					
					<%
					if (wtcVo.getIsChild() != null && wtcVo.getIsChild().equals("1")){
					%>
					<td width="25%">
						<a href='javascript:void(0)' class="wt-select" onclick="selectNode('<%=wtcVo.getWorkTypeId() %>','<%=wtcVo.getWorkTypeName()%>');"><%=wtcVo.getWorkTypeName()%></a>
							 &nbsp;</td> 
					<%
					} else{
						out.print("<td colspan=\"4\" style='font-size: 14px;font-weight: bold;color: #000000;' >·行业"+tradeNumber+":");
						out.print(wtcVo.getWorkTypeName());
						out.print("</td>");
						tradeNumber++;
					} %>
					 
					 <%
					 
					if (((tempNumber) % 4 == 3)){
						out.print("</tr>");
						tempNumber = 0;
					}else{												
						tempNumber++;
					} 
					flag = wtcVo.getPid();
				}
			 %>
</table>
</body>
</html>
