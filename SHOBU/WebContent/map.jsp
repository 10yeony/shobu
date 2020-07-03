<%@page import="com.shobu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>토토판매점 - 쇼부 Shobu</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!-- 맵 스타일 시작 -->
<style>
#map {
	width: 100%;
	height: 70%;
	margin: 0 auto;
}

.mapBox {
	margin-top: 50px;
	width: 100%;
	height: 800px;
	align-content: center;
}
</style>


<!-- 맵 스크립트 부분  -->
<script>
	var map;
	function initMap() {

		map = new google.maps.Map(document.getElementById('map'), {
			zoom : 14,
			center : {
				lat : 37.4865187,
				lng : 127.0200871
			}
		});
		<c:forEach items="${mapList}" var="mapArr">
		var marker = new google.maps.Marker({position: {lat: ${mapArr.localY}, lng: ${mapArr.localX}}, map: map}); 
		</c:forEach>
		
<%-- 		<%
		
		
		for(int i=0;i<)
		
		
		%> --%>
		
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
					lat : position.coords.latitude,
					lng : position.coords.longitude
				};

				map.setCenter(pos);
			}, function() {
				handleLocationError(true, infoWindow, map.getCenter());
			});
		} else {
			handleLocationError(false, infoWindow, map.getCenter());
		}
		
		
	}

	function handleLocationError(browserHasGeolocation, infoWindow, pos) {
		infoWindow.setPosition(pos);
		infoWindow
				.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
						: 'Error: Your browser doesn\'t support geolocation.');
	}
</script>
<!-- Map 개인 키 부분 -->
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0085qYvaQZv0nFw1TGj1lWGUdjnv16jU&callback=initMap">
</script>
<!-- 맵 스크립트 부분 끝 -->


</head>
<body>

	<%@ include file="header.jsp"%>
	<%@ include file="chat.jsp"%>
	
	<div class="mapBox">
		<div style="font-size: 40pt; text-align: center;">토토 판매점</div>
		<br />
		<div id="map"></div>
	</div>



</body>
</html>