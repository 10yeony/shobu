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
  body{height: 100%;}
  #list {
  		width: 80%;
  		
  		}
  #list-div{
  		height: 500px;
  		overflow: auto;
  		
  }
  </style>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
var team = "ALL";
var mode = "pitcher";

function selectTeam(setTeam){
	team = setTeam;
	search(mode,team);
}
function selectMode(setMode){
	mode = setMode;
	search(mode,team);
}
function search(mode, team) {
	$.ajax({
		type:'post',
		url:'/'+mode+'.do',
		data:'teamCode='+team,
		dataType:'json',
		
		success:function(data){
			$('#list-table').empty();
			
			if(mode=="pitcher"){
				$('#list-table').append("<thead id='list-head'>");
				$('#list-head').append("<tr><th>소속</th>");
				$('#list-head tr').append("<th>이름</th>");
				$('#list-head tr').append("<th>경기</th>");
				$('#list-head tr').append("<th>이닝</th>");
				$('#list-head tr').append("<th>방어율</th>");
				$('#list-head tr').append("<th>승리</th>");
				$('#list-head tr').append("<th>패배</th>");
				$('#list-head tr').append("<th>세이브</th>");
				$('#list-head tr').append("<th>홀드</th>");
				$('#list-head tr').append("<th>실점</th>");
				$('#list-head tr').append("<th>안타</th>");
				$('#list-head tr').append("<th>삼진</th>");
				$('#list-head tr').append("<th>볼넷</th></tr>");
				$('#list-table').append("</thead>");
				$('#list-table').append("<tbody id='list-body'>");
				
				$.each(data.list, function(index, list){
					$('#list-body').append("<tr id="+list.playerId+">");
					$('#'+list.playerId).append("<td>"+list.teamCode+"</td>");
					$('#'+list.playerId).append("<td>"+list.name+"</td>");
					$('#'+list.playerId).append("<td>"+list.games+"</td>");
					$('#'+list.playerId).append("<td>"+list.inning+"</td>");
					$('#'+list.playerId).append("<td>"+list.era+"</td>");
					$('#'+list.playerId).append("<td>"+list.win+"</td>");
					$('#'+list.playerId).append("<td>"+list.lose+"</td>");
					$('#'+list.playerId).append("<td>"+list.save+"</td>");
					$('#'+list.playerId).append("<td>"+list.hold+"</td>");
					$('#'+list.playerId).append("<td>"+list.runs+"</td>");
					$('#'+list.playerId).append("<td>"+list.hits+"</td>");
					$('#'+list.playerId).append("<td>"+list.so+"</td>");
					$('#'+list.playerId).append("<td>"+list.bb+"</td></tr>");
				});//each
				$('#list-table').append("</tbody>");
				
			}else{
				$('#list-table').append("<thead id='list-head'>");
				$('#list-head').append("<tr><th>소속</th>");
				$('#list-head tr').append("<th>이름</th>");
				$('#list-head tr').append("<th>경기</th>");
				$('#list-head tr').append("<th>타율</th>");
				$('#list-head tr').append("<th>타수</th>");
				$('#list-head tr').append("<th>안타</th>");
				$('#list-head tr').append("<th>홈런</th>");
				$('#list-head tr').append("<th>타점</th>");
				$('#list-head tr').append("<th>득점</th>");
				$('#list-head tr').append("<th>삼진</th>");
				$('#list-head tr').append("<th>볼넷</th>");
				$('#list-head tr').append("<th>출루율</th>");
				$('#list-head tr').append("<th>장타율</th>");
				$('#list-head tr').append("<th>OPS</th>");
				$('#list-head tr').append("<th>도루</th>");
				$('#list-head tr').append("<th>실책</th></tr>");
				$('#list-table').append("</thead>");
				$('#list-table').append("<tbody id='list-body'>");
				
				$.each(data.list, function(index, list){
					$('#list-body').append("<tr id="+list.playerId+">");
					$('#'+list.playerId).append("<td>"+list.teamCode+"</td>");
					$('#'+list.playerId).append("<td>"+list.name+"</td>");
					$('#'+list.playerId).append("<td>"+list.games+"</td>");
					$('#'+list.playerId).append("<td>"+list.rate+"</td>");
					$('#'+list.playerId).append("<td>"+list.ab+"</td>");
					$('#'+list.playerId).append("<td>"+list.hits+"</td>");
					$('#'+list.playerId).append("<td>"+list.hr+"</td>");
					$('#'+list.playerId).append("<td>"+list.rbi+"</td>");
					$('#'+list.playerId).append("<td>"+list.runs+"</td>");
					$('#'+list.playerId).append("<td>"+list.so+"</td>");
					$('#'+list.playerId).append("<td>"+list.bb+"</td>");
					$('#'+list.playerId).append("<td>"+list.obp+"</td>");
					$('#'+list.playerId).append("<td>"+list.slg+"</td>");
					$('#'+list.playerId).append("<td>"+list.ops+"</td>");
					$('#'+list.playerId).append("<td>"+list.steal+"</td>");
					$('#'+list.playerId).append("<td>"+list.error+"</td></tr>");
				});//each
				
				$('#list-table').append("</tbody>");
			};
			
			$('#list-body tr').hover(function() {
				var playerId = $(this).attr("id");
			 	$.ajax({
					type:'post',
					url:'/display.do',
					data:'playerId='+playerId,
					dataType:'json',
					
					success:function(data){
						$.each(data.list, function(index, list){
						$('#review').empty();
						$('#review').append("<img alt='' src='image/player/"+list.playerId+".jpg' width='180px' height='226px' style='margin-top: 10px'><br/>");
						$('#review').append("<hr><br/><div>"+list.name+"</div><br/>");
						$('#review').append("<div>"+list.number+" 번</div><br/>");
						$('#review').append("<div>"+list.birth+"</div><br/>");
						$('#review').append("<div>"+list.type+"</div><br/><br/>");
						})
					}//success
				})//ajax  
			})//hover
			
			}//success
	});//ajax
};//function



$(function() {
	search(mode,team);
	


});//ready
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
      <div style="padding-top: 60px; font-size: 20px" align="center">
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
      </div><br/>
      <hr>
      <div align="center" style="font-size: 30px">
      	<span id="search"><a href="javascript:selectMode('pitcher')">투수기록</a></span>
      	<span> | </span>
      	<span id="search"><a href="javascript:selectMode('hitter')">타자기록</a></span>
      </div>
​
      <!-- 카드 클래스안에 데이터만 입력 원하는 비율 선택-->
      <div class="w3-row">
      
      	
        <div id="detail" class="w3-col w3-panel w3-padding-16" style="width: 20%;">
          <div class="w3-card" align="center" id="review">
          	<img alt="" src="https://link-u.co.kr/www/thumbs/intro/basic_user.png" width="180px" height="226px" style="margin-top: 10px">
          	
		  </div>
        </div>
        
        
        <div id="list" class="w3-col w3-panel w3-padding-16">
          <div id="list-div" class="w3-card">
          	<table id="list-table" class="w3-table-all w3-hoverable">
          		<thead></thead>
          		<tbody></tbody>
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
    function navClose() {
      document.getElementById("nav").style.display = "none";
      document.getElementById("overlay").style.display = "none";
    }
  </script>
</body>
</html>