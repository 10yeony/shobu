<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>쇼부</title>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/test.js"></script>
	<script src="js/index.js"></script>
	<link rel="stylesheet" href="css/test.css">
	<link rel="stylesheet" href="css/index.css">
</head>

<body>
	
	<!-- nav -->
	<div class="area"></div>
	<nav class="main-menu">
		<ul>
			<li><a href="http://justinfarrow.com"> <i
					class="fa fa-home fa-2x"></i> <span class="nav-text"> Home </span>
			</a></li>
			<li class="has-subnav"><a href="#"> <i
					class="fa fa-play fa-2x"></i> <span class="nav-text"> Game </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-bar-chart-o fa-2x"></i> <span
					class="nav-text"> Statistics </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-map-marker fa-2x"></i> <span
					class="nav-text"> Maps </span>
			</a></li>
		</ul>

		<ul class="logout">
			<li><a href="#"> <i class="fa fa-power-off fa-2x"></i> <span
					class="nav-text"> Logout </span>
			</a></li>
		</ul>
	</nav>
	
	<!-- main -->
	
	<div class="card" id='versus'>
		<button></button>
		<div id="slider">
			  <a id="prev" class="arrow"></a>
			  <ul id="pages">    
			    <li>
			      <div id='game1'>
			    	팀로고 두개
			    	선발투수 이름
			    	가운데막대그래프
			    	배당률?
			      </div>
			  </li>
			  <li>
			   <div id='game2'>
			    	팀로고 두개
			    	선발투수 이름
			    	가운데막대그래프
			    	배당률?
			      </div>
			  </li>
			    <li>
			      <div id='game3'>
			    	팀로고 두개
			    	선발투수 이름
			    	가운데막대그래프
			    	배당률?
			      </div>
			  </li>
			  <li>
			   <div id='game4'>
			    	팀로고 두개
			    	선발투수 이름
			    	가운데막대그래프
			    	배당률?
			      </div> 
			  </li>
			  <li>
			    <div id='game5'>
			    	팀로고 두개
			    	선발투수 이름
			    	가운데막대그래프
			    	배당률?
			      </div>
			  </li>
			</ul>
			<a id="next" class="arrow"></a>
			<ul class="navigation"></ul>
			</div> 
	</div>
	
	<div class="card" id='bul_history'>
		<table></table>
	</div>
	
	<div class="card" id='todayLuck'>
		<p>Architect & Engineer</p>
	</div>
	
	<!--Chatting-->
	<div id="chat-circle" class="btn btn-raised">
		<div id="chat-overlay"></div>
		<i class="fa fa-comments fa-2x chatIcon"></i>
	</div>

	<div class="chat-box">
		<div class="chat-box-header">
			ChatBot <span class="chat-box-toggle"><i class="fa fa-times"></i></span>
		</div>
		<div class="chat-box-body">
			<div class="chat-box-overlay"></div>
			<div class="chat-logs"></div>
			<!--chat-log -->
		</div>
		<div class="chat-input">
			<form>
				<input type="text" id="chat-input" placeholder="Send a message..." />
				<button type="submit" class="chat-submit" id="chat-submit">
					<i class="material-icons">send</i>
				</button>
			</form>
		</div>
	</div>
</body>

</html>