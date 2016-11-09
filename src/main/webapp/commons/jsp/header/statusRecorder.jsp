<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 选中用户的选择 --%>
<script type="text/javascript">
	var wt = '<%=request.getParameter("wtId")%>';//工种
	var plc = '<%=request.getParameter("plcPy")%>';//地方(城市或地区)
	var cssClass = '<%=request.getParameter("cssClass")%>';
	//alert(wt+"<-->"+plc);
	var elem_wt = document.getElementById('wt_'+wt);
	var elem_plc = document.getElementById('plc_'+plc);
	if(elem_wt){
		//alert("in");
		if(cssClass){
			elem_wt.className = cssClass;
		}else{
			elem_wt.className = 'selected-qry-condition';
		}
	}
	if(elem_plc){
	//alert("in2");
		if(cssClass){
			elem_plc.className = cssClass;
		}else{
			elem_plc.className = 'selected-qry-condition';
		}
	}
</script>
<%-- /选中用户的选择 --%>
