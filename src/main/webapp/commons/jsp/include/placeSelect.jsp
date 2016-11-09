<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script type="text/javascript" src="<%=request.getContextPath() %>/commons/js/jquery.js"></script>
<script type="text/javascript">
<%
	String curPlace = request.getParameter("curPlace") == null ? "" : request.getParameter("curPlace");
	String curCity = "";
	if (!curPlace.equals("")) {
		curCity = curPlace.substring(0, 4);
	}
	request.setAttribute("curCity", curCity);
	request.setAttribute("curPlace", curPlace);
	String curPlaceName = request.getParameter("curPlaceName") == null ? "" : request.getParameter("curPlaceName");
	
	String selectNameValue = request.getParameter("selectNameValue");
	String hiddenNameValue = request.getParameter("hiddenNameValue");
	if (selectNameValue == null || hiddenNameValue == null || selectNameValue.trim().equals("") || hiddenNameValue.trim().equals("")) {
		throw new Exception("必须提供存放Place的id和名称的字段");
	}
%>
var curCity = '<%=curCity %>';
var curPlace = '<%=curPlace %>';
function init() {
	if (curCity && curPlace) {
		getPlaces();
	}
}
function getPlaces(){
	var city_id = document.getElementById("cities").value;
	$.get("<%=request.getContextPath() %>/place/list/" + city_id, function(data){
		var places = document.getElementById("places");
		var placeList = eval('('+data+')');
        places.options.length = 0;// 清空
		try{
			places.add(new Option("---请选择---", ""));
		}catch(e){
			places.add(new Option("---请选择---",""), null);
		}
		for(var i = 0; i < placeList.length; i++) {
		   	var plcId = placeList[i].placeId;
		   	var plcName = placeList[i].placeName;
			try{
				if(i == 0){//排在第一个的肯定是城市
					places.add(new Option("不限定区域", plcId));
				}else{
					places.add(new Option(plcName, plcId));
				}
			}catch(e){
				if(i == 0){
					places.add(new Option("不限定区域", plcId), null);
				}else{
					places.add(new Option(plcName, plcId), null);
				}
			}
			if(curPlace && plcId == curPlace){
		   		places.options[i+1].selected = 'selected';
		   	}
		}
	});
}

function selectRegion(firefox_event){
	var o = window.event ? window.event.srcElement : firefox_event.target;
	var index = o.selectedIndex; //序号，取当前选中选项的序号
	var val = "";<%--中文地区 --%>
	if (index == 1 || index == 0) {<%--如果选择是不限定区域就选择都城市的中文 --%>
		val = document.getElementById('cities').options[document.getElementById('cities').selectedIndex].text;
	}else{
		val = o.options[index].text;
	}
	document.getElementById('region').value = val;
}
function hasSelectPlace() {
	var v1 = document.getElementById("cities").value;
	var v2 = document.getElementById("places").value;
	if (v1 == "" || v2 == "") {
		alert("请选择工作地点");
		return false;
	}
	return true;
}
window.onload = function() {
	init();
}
</script>
<select id="cities" onchange="getPlaces()">
	<c:if test='${curCity == "" && curPlace == "" }'>
		<option value="">
			---请选择---		
		</option>
	</c:if>
	<c:forEach items="${cities }" var="tmp" varStatus="st">
		<c:choose>
			<c:when test='${curCity != "" && tmp.placeId == curCity }'>
				<option value="${tmp.placeId }" selected="selected">${tmp.placeName }</option>
			</c:when>
			<c:otherwise>
				<option value="${tmp.placeId }">${tmp.placeName }</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>
<select id="places" name="<%=selectNameValue %>" onchange="selectRegion(event)">
	<option value="">
		---请选择---		
	</option>
</select>
<input id="region" type="hidden" name="<%=hiddenNameValue %>" value="<%=curPlaceName %>">