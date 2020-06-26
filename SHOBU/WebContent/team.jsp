<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style type="text/css">
  </style>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	function list() {
		$.ajax({
			type:'post',
			url:'playerlist.do',
			data:'teamName='+$(this).val(),
			
			success:function(data){
				$('#resultView').html(data)
			}
		})//ajax
	}//function
})//ready

</script>
<body>
  <!-- 슬라이드 메뉴바 -->
  <nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="nav">
    <div style="background-color: #00907e; height: 60px;">토토</div>
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="navClose()">Close</a>
    <!-- 입력 -->
    기록실
  </nav>
​
  <!-- 메뉴바 클릭 시 화면 어둡게 처리 -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="navClose()" style="cursor:pointer" id="overlay">
  </div>
​
  <!-- 상단 서치바, 유저정보(썸네일, 아이디) -->
  <div class="w3-main" style="margin-left:250px;">
    <header class="w3-container w3-top" style="background-color: #00c3aa; height: 60px;">
      <i class="fa fa-bars w3-button w3-hide-large w3-display-left" onclick="navOpen()"></i>
      <span class="w3-hide-large w3-right w3-animate-opacity" style="position: relative; top: 25%;">썸네일</span>
      <span class="w3-hide-large w3-right w3-animate-opacity" style="position: relative; top: 25%;">아이디</span>
​
      <div class="w3-hide-small w3-hide-medium w3-animate-opacity"
        style="width:100%; height: 100%; text-align: right; margin-left: -250px;">
        <span style="position: relative; top: 25%;">썸네일</span>
        <span style="position: relative; top: 25%;">아이디</span>
      </div>
    </header>
​
    <section>
      <!-- 상단 여백 처리-->
      <div style="padding-top: 60px;" align="center">
      	<span><a href="#" onclick=list()>전체</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#" onclick=list()>NC</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#" onclick=list()>두산</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">키움</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">LG</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">기아</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">롯데</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">KT</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">삼성</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">SK</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">한화</a></span>&nbsp;&nbsp;&nbsp;
      </div>
​
      <!-- 카드 클래스안에 데이터만 입력 원하는 비율 선택-->
      <div class="w3-row">
        <div id="detail" class="w3-col w3-panel w3-padding-16" style="width: 20%;">
          <div class="w3-card" align="center">
          	<img alt="" src="https://link-u.co.kr/www/thumbs/intro/basic_user.png" width="180px" height="226px" style="margin-top: 10px">
		  </div>
        </div>
        <div id="list" class="w3-col w3-panel w3-padding-16" style="width: 80%;">
          <div class="w3-card">
          	<table class="w3-table-all w3-hoverable">
          		<thead>
          			<tr>
          				<th>이름</th>
          				<th>ERA</th>
          				<th>경기수</th>
          				<th>이닝</th>
          				<th>승리</th>
          				<th>패배</th>
          				<th>세이브</th>
          				<th>홀드</th>
          				<th>탈삼진</th>
          				<th>피안타</th>
          				<th>실점</th>
          				<th>볼넷</th>
          			</tr>
          		</thead>
          		<tbody>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          		
          		</tbody>
          	</table>
          </div>
        </div>
      </div>
​
    </section>
  </div>
​
  <script>
    // Open and close the sidebar on medium and small screens
    function navOpen() {
      document.getElementById("nav").style.display = "block";
      document.getElementById("overlay").style.display = "block";
    }
​
    function navClose() {
      document.getElementById("nav").style.display = "none";
      document.getElementById("overlay").style.display = "none";
    }
  </script>
</body>
​
</html>