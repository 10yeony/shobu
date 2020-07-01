<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>토토판매점 - 쇼부 Shobu</title>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta charset="utf-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <style>
		#chatBox {
			position: absolute;
			bottom: 5%;
			right: 1%;
		}
		
		#show {
			position: absolute;
			bottom: 5%;
			right: 1%;
		}
		
		#chatlog {
			width: 485px;
			height: 400px;
			resize: none;
		}
		
		#msg {
			width: 330px;
		}
		</style>
		<!-- 채팅 박스 css 끝 -->
		
		<!-- 맵 스타일 시작 -->
		<style>
		#map {
			width: 900px;
			height: 650px;
		}
		
		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}
  </style>
  <!--채팅박스 js 시작 -->
	<script>
	var userId = "jy";	//회원 정보를 담는 용	// 세션에 저장된 id값 넣어야함. 
	
	var ws = new WebSocket("ws://localhost:8888/wschat");	// 서버 아이피 넣어야함.
	ws.onopen = function(){
		 
	};
	
	ws.onmessage = function(message){
	
		document.getElementById("chatlog").textContent += message.data + "\n";
	  
	  scrolldown();	
	};
	
	function postToServer(){	// 서버에 보내는 
	  ws.send(userId+" "+document.getElementById("msg").value);	// userId 추가했음. 
	  document.getElementById("msg").value = "";	// 보내고난 정보 없애는 용도로 사용됨. 
	}
	function closeConnect(){	// 종료부분
	  ws.close();
	}
	
	// Enter Key 누르면 전송되도록
	function checkEnter(){
		  if (window.event.keyCode == 13) {
			  postToServer();
	   }
	}
	
	function scrolldown(){
	  	$('#chatlog').scrollTop($('#chatlog')[0].scrollHeight);
		 }
	
	//JQuery
	$(document).ready(function(){
		  // 클릭하면 보여지고 다시 클릭하 사라지는
	$('#show').click(function(){
		 $('#chatBox').toggle();
		});//~click
	});
	</script>
	<!-- 채팅박스 js 끝 -->
	
	<!-- 맵 스크립트 부분  -->
	<script>
	      var map;
	      function initMap() {
	        map = new google.maps.Map(document.getElementById('map'), {zoom: 15, center: {lat: 37.5665, lng: 126.9780}});
	  	  // 마커로 표현할 판매저 지정해주면 됩니다. 
	  	  var marker;
	  	   marker = new google.maps.Marker({position: {lat: 37.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 36.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 35.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 34.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 33.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 32.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 31.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 30.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 29.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 28.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 27.5665, lng: 126.9780}, map: map});
	  	   marker = new google.maps.Marker({position: {lat: 26.5665, lng: 126.9780}, map: map});
	  	 
	  	   
	        // Try HTML5 geolocation.
	        if (navigator.geolocation) {
	          navigator.geolocation.getCurrentPosition(function(position) {
	            var pos = {
	              lat: position.coords.latitude,
	              lng: position.coords.longitude
	            };
	
	            map.setCenter(pos);
	          }, function() {
	            handleLocationError(true, infoWindow, map.getCenter());
	          });
	        } else {
	          // Browser doesn't support Geolocation
	          handleLocationError(false, infoWindow, map.getCenter());
	        }
	      }
	
	      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	        infoWindow.setPosition(pos);
	        infoWindow.setContent(browserHasGeolocation ?
	                              'Error: The Geolocation service failed.' :
	                              'Error: Your browser doesn\'t support geolocation.');
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
 
	<div style="padding-top: 60px;"></div>
		<div class="w3-third w3-panel w3-padding-16">
			<div>
				<div style="font-size: 25pt;">판매처</div>
				<div id="map"></div>
			</div>
		</div>



		<!-- chatBox -->
		<div id="chatBox" style="background:;">
			<!-- <textarea id="chatlog" readonly></textarea><br/> -->
			<textarea id="chatlog" readonly></textarea>
			<br /> <input id="msg" type="text" onkeydown="checkEnter()" />
			<button type="submit" id="sendButton" onClick="postToServer()">보내기</button>
			<!-- 	    <button type="submit" id="sendButton" onClick="closeConnect()">End!</button> -->
		</div>

		<!--  보이기 버튼 -->
		<button id="show" type="button" class="btn btn-primary">채팅하기
		</button>
		<!-- chatBox -->
 </body>
</html>