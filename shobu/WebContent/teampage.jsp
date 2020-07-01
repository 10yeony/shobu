<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
​
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript">
  var team = "ALL";
  function selectTeam(setTeam){
		team = setTeam;
		search(team);
	}
  
  function search(team){
	  $.ajax({
		  type:'post',
		  url:'/teaminfo.do',
		  data:'teamCode='+team,
		  dataType:'json',
		  
		  success:function(data){
			  $('#team-info').empty();
			  $('#team-article').empty();
			  $('#pitcher-era').empty();
			  $('#pitcher-win').empty();
			  $('#pitcher-save').empty();
			  $('#pitcher-so').empty();
			  $('#hitter-rate').empty();
			  $('#hitter-rbi').empty();
			  $('#hitter-hr').empty();
			  $('#hitter-hits').empty();
			  
			  $.each(data.teamlist, function(index, teamlist){
				  $('#team-info').append("<img alt='' src='"+teamlist.image+"'>");
				  $('#team-info').append("<div>순위"+teamlist.rank+"위</div>");
				  $('#team-info').append("<div>팀 방어율"+teamlist.rankERA+"위</div>");
				  $('#team-info').append("<div>팀 타율"+teamlist.rankAVG+"위</div>");
			  });
		  }//success
	  })//ajax
  }//function
  
  $(function() {
	search(team);
});
  </script>
</head>
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
      <div style="padding-top: 30px; font-size: 0.9em;" align="center">
      	<span id="search"><a href="javascript:selectTeam('ALL')" >전체</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('NC')">NC</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('OB')">두산</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('WO')">키움</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('LG')">LG</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('HT')">기아</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('LT')">롯데</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('KT')">KT</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('SS')">삼성</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('SK')">SK</a></span>&nbsp;&nbsp;&nbsp;
      	<span id="search"><a href="javascript:selectTeam('HH')">한화</a></span>&nbsp;&nbsp;&nbsp;
      </div>
      <hr>
​
      <!-- 카드 클래스안에 데이터만 입력 원하는 비율 선택-->
      <div class="w3-row">
     	<div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="team-info" align="center">1/4</div>
        </div>
        
        <div class="w3-threequarter w3-panel w3-padding-16">
          <div class="w3-card" id="team-article">3/4</div>
        </div>
      </div>
      
      
      <div class="w3-row">
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-era">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-win">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-save">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-so">1/4</div>
        </div>
      </div>
      
      <div class="w3-row">
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-rate">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-rbi">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-hr">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-hits">1/4</div>
        </div>
      </div>	
     </section>
    </div>

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