<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
function getPlaces(){
	var city_id = document.getElementById("cities").value;
	$.get("<%=request.getContextPath() %>/common/chgWithSelectedCity.do?cityId=" + city_id, function(data){
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
</script>
<select id="cities" onchange="getPlaces()">
	<option value="">
		---请选择---		
	</option>
	<s:iterator status="st" value="#request.cities">
		<option value="${placeId }">${placeName }</option>
	</s:iterator>
</select>
<select id="places" name="cond.placeId" onchange="selectRegion(event)">
	<option value="">
		---请选择---		
	</option>
</select>