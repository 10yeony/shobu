<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/test.js"></script>
<link rel="stylesheet" href="css/test.css">
<link rel="stylesheet" href="css/table.css">
<script>

</script>
<style>

</style>
</head>
<body>
	
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
	<table>
		<tr>
			<td>
				<div class="card">
					<p>모의 토토</p>
					<div class="progress-wrap progress" data-progress-percent="25">
  						<div class="progress-bar progress"></div>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="card" style="width: 900px;">
					<p>
						<!-- 랭킹 테이블 시작 -->
						<table class="content-table" style="width: 500px; margin: 0 auto;">
  							<thead>
    							<tr>
      								<th>Rank</th>
      								<th>Name</th>
      								<th>Points</th>
    							</tr>
  							</thead>
  							<tbody>
    							<tr>
      								<td>1</td>
      								<td>Domenic</td>
      								<td>88,110</td>
							    </tr>
    							<tr>
      								<td>2</td>
      								<td>Sally</td>
      								<td>72,400</td>
    							</tr>
    							<tr>
      								<td>3</td>
      								<td>Nick</td>
      								<td>52,300</td>
    							</tr>
    							<tr>
      								<td>4</td>
      								<td>Nick</td>
      								<td>52,300</td>
    							</tr>
    							<tr>
      								<td>5</td>
      								<td>Nick</td>
      								<td>52,300</td>
    							</tr>
  							</tbody>
						</table>
					</p>
				</div>
			</td>
		</tr>
	</table>

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