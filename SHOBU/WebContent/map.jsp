<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		 
<!-- 채팅 박스 css -->
<style type="text/css">
#chatBox {
	position: fixed;
	bottom: 150px;
	right: 100px;
	background: #170B3B;
	width: 320px;
	height: 350px;
	text-align: center;
	padding-top: 10px;
	border-radius: 10px;
}

#chatlog {
	width: 300px;
	height: 300px;
	resize: none;
}

#msg {
	width: 240px;
}

#show {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	display: block;
	margin: 20px auto;
	max-width: 180px;
	text-decoration: none;
	border-radius: 4px;
	padding: 10px 15px;
	position: fixed;
	bottom: 50px;
	right: 50px;
	width: 100px;
	height: 100px]
}

#show.button {
	color: rgba(30, 22, 54, 0.6);
	box-shadow: rgba(30, 22, 200, 0.4) 0 0px 0px 2px inset;
}

#show.button:hover {
	color: rgba(255, 255, 255, 0.85);
	box-shadow: rgba(0, 0, 102, 0.7) 0 0px 0px 40px inset;
}
</style>
<!-- 채팅 박스 css 끝 -->

<!-- 맵 스타일 시작 -->
<style>
#map {
	width: 1800px;
	height: 700px;
	margin: 0 auto;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

.mapBox {
	width: 1800px;
	height: 800px;
}
</style>
<!-- 맵 스타일  -->


<!--채팅박스 js 시작 -->
<script>
	/* var userId = '$(member.id}'; */
	var userId = "jy"; // 확인용

	var ws = new WebSocket("ws://localhost:8888/wschat"); // 서버 아이피 넣어야함.
	ws.onopen = function() {
	};

	ws.onmessage = function(message) {
		var temp = message.data;
		var temp1 = temp.indexOf(":");
		var idPart = temp.substring(0, temp1 - 1); // 세션 아이디랑 동일한지 확인용
		var textPart = temp.substring(temp1 + 1, temp.length);
		var displayId;
		if (idPart == userId) {
			displayId = "My";
		} else {
			displayId = idPart;
		}
		document.getElementById("chatlog").textContent += displayId + " : "
				+ textPart + "\n";
		scrolldown();
	};
	function postToServer() { // 서버에 보내는 
		ws.send(userId + " " + document.getElementById("msg").value); //userId 추가했음. 
		document.getElementById("msg").value = ""; // 보내고난 정보 없애는 용도로 사용됨. 
	}
	function closeConnect() { // 종료부분
		ws.close();
	}

	// Enter Key 누르면 전송되도록
	function checkEnter() {
		if (window.event.keyCode == 13) {
			postToServer();
		}
	}

	function scrolldown() {
		$('#chatlog').scrollTop($('#chatlog')[0].scrollHeight);
	}

	//JQuery
	$(document).ready(function() {
		$('#chatBox').hide();
		// 클릭하면 보여지고 다시 클릭하 사라지는
		$('#show').click(function() {
			$('#chatBox').fadeToggle();
		});

	});
</script>
<!-- 채팅박스 js 끝 -->

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

	<div class="mapBox">
		<div style="font-size: 25pt; text-align: center;">판매처</div>
		<div id="map"></div>
	</div>




	<!-- chatBox -->
	<div id="chatBox" style="background:;">
		<textarea id="chatlog" readonly></textarea>
		<br /> <input id="msg" type="text" onkeydown="checkEnter()" />
		<button type="submit" id="sendButton" onClick="postToServer()">send</button>
	</div>
	<!--  보이기 버튼 -->
	<!-- 		<button id="show" type="button" class="btn btn-primary">채팅하기
		</button> -->
	<button id="show" type="button" class="button">잡담참여</button>
	<!-- chatBox -->

</body>
</html>