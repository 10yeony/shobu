<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
#chatBox {
	position: fixed;
	bottom: 100px;
	right: 5px;
	background: #170B3B;
	width: 320px;
	height: 350px;
	text-align: center;
	padding-top: 10px;
	border-radius: 10px;
	z-index: 1;
}

#chatlog {
	width: 300px;
	height: 300px;
	resize: none;
}

#msg {
	width: 240px;
}

.button-wrapper {
	display: inline-block;
	margin: 20px 5px;
	padding: 10px;
}

.dark-button-2 {
	background: #333;
}

.show {
	background: #fff;
	border: none;
	padding: 2px;
	cursor: pointer;
	display: block;
	position: relative;
	overflow: hidden;
	transition: all .35s ease-in-out .35s;
	margin: 0 auto;
	width: 150px;
	text-align: center;
}

.dark-button-2 .show, .dark-button-2 .show span {
	background: #333;
	color: #fff;
}

.dark-button-2 .show:after, .dark-button-2 .show:before, .dark-button-2 .show:hover span
	{
	background: #fff;
	color: #444;
}

.show span {
	display: block;
	padding: 15px 30px;
	background: #fff;
	z-index: 100;
	position: relative;
	transition: all .35s ease-in-out .35s;
	padding: 10px 0px;
}

.show:hover span {
	background: #36B4C7;
	color: #fff;
	transition: all .35s ease-in-out .35s;
}

.show:after {
	bottom: -100%;
	right: -100%;
	content: "";
	width: 100%;
	height: 100%;
	position: absolute;
	background: #36B4C7;
	transition: all .35s ease-in-out .5s;
}

.show:hover:after {
	right: 0;
	bottom: 0;
	transition: all ease-in-out .35s;
}

.show:before {
	top: -100%;
	left: -100%;
	content: "";
	width: 100%;
	height: 100%;
	position: absolute;
	background: #36B4C7;
	transition: all .35s ease-in-out .5s;
}

.show:hover:before {
	left: 0;
	top: 0;
	transition: all ease-in-out .35s;
}

#showBox {
	position: fixed;
	bottom: 0px;
	right: 5px;
	z-index: 1;
}
</style>
<!-- 채팅 박스 css 끝 -->
<!--채팅박스 js 시작 -->
<script>
	

	//JQuery
	$(function(){
		$('#chatBox').hide();
		// 클릭하면 보여지고 다시 클릭하 사라지는
		$('#show').click(function() {
			$('#chatBox').slideToggle();
			scrolldown();
		});
	});
	
	function scrolldown() {
		$('#chatlog').scrollTop($('#chatlog')[0].scrollHeight);
	}
	
	var userId = "${sessionScope.member.id}";
	var ws = new WebSocket("ws://192.168.0.48:8888/wschat"); // 서버 아이피 넣어야함.
	ws.onopen = function() {
<%-- 		<% /* 시험용 */
		MemberVO member = new MemberVO();
		member.setId("jjy");
		member.setNickname("jjy2");
		member.setPassword("jjy3");
		request.getSession().setAttribute("member", member);
	%>  --%>
	
	};

	ws.onmessage = function(message) {
		var temp = message.data;
		var temp1 = temp.indexOf(":");
		var idPart = temp.substring(0, temp1 - 1); // 세션 아이디랑 동일한지 확인용
		var textPart = temp.substring(temp1 + 1, temp.length);
		var displayId;
		if (idPart == "${sessionScope.member.id}") {
			displayId = "My";
		} else {
			displayId = idPart;//
		}
		document.getElementById("chatlog").textContent += displayId + " : "
				+ textPart + "\n";
		
		scrolldown();
	};
	

	
/* 	function closeConnect() { // 종료부분
		ws.close();
	}; */
	
	function postToServer() { // 서버에 보내는 
		ws.send("${sessionScope.member.id}"+"!!"+ document.getElementById("msg").value); //userId 추가했음. 
		document.getElementById("msg").value = ""; // 보내고난 정보 없애는 용도로 사용됨. 
	};
	// Enter Key 누르면 전송되도록
	function checkEnter() {
		if (window.event.keyCode == 13) {
			postToServer();
		}
	}
</script>
<!-- 채팅박스 js 끝 -->

</head>
<body>




	<!-- chatBox -->
	<div id="chatBox">
		<textarea id="chatlog" readonly></textarea>
		<br /> <input id="msg" type="text" onkeydown="checkEnter()" />
		<button type="button" id="sendButton" onClick="postToServer()">send</button>
	</div>
	<div class="dark-button-2 button-wrapper" id="showBox">
		<div class="show" id="show">
			<span >잡담 참여</span>
		</div>
	</div>
	<!-- chatBox -->
</body>
</html>