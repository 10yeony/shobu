<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css"
		rel="stylesheet" type="text/css"/>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript">
var infoWindow=new google.maps.InfoWindow();
$(document).ready(function(){
		initLocation();
});
function initLocation(){
	var myLoc=getLocation();
	if(myLoc==null)
		return false;	
	myLocation(myLoc);
}
function getLocation(){
	if(navigator.geolocation){
		return navigator.geolocation;
	}

	document.getElementById("disp").innerHTML="위치 정보 지원 안됨";
	return null;
}
function myLocation(myLoc){
	myLoc.getCurrentPosition(function(position){
		var lat=position.coords.latitude;
		var lon=position.coords.longitude;
		var initLoc=new google.maps.LatLng(lat,lon);
		var map=new google.maps.Map(
				document.getElementById("map_canvas"),
				{
					zoom:16,
					mapTypeId:google.maps.MapTypeId.ROADMAP
				}
		);
		map.setCenter(initLoc);
		infoWindow.setContent("현재 내 위치");//말풍선
		infoWindow.setPosition(initLoc);
		infoWindow.open(map);
	});
}
</script>
</head>
<body>
<input type="text" placeholder="주소를 입력하세요."> <input type="button" value="SEARCH">
<div id="map_canvas" style="width:100%;height:100%;"></div>
</body>
</html>