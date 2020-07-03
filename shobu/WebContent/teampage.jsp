<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style type="text/css">
  	#title{font-weight: bold; color: white; background-color: #343d52; padding: 5px;}
  	#detail{font-size: 1.5em; font-weight:bold; color: red; margin-top: 5px; font-family: Sans-serif;}
  	#name{font-size: 1.1em; font-weight: bold; margin-top: 5px; font-family: Sans-serif;}
  	#team-info-table{text-align: center;}
  	#team-info{background-color: #343d52; text-align: center;}
  	#tr-1 td{color: white; font-weight: bold; font-family: Sans-serif;}
  	#tr-2 td{color: white; font-weight: bold; font-family: Sans-serif;}
  </style>
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
				  if(teamlist.teamCode == "ALL")
			  		$('#team-info').append("<img alt='' src='image/team/KBO.png'>");
				  else{
					$('#team-info').append("<table width='100%' id='team-info-table'>");
					$('#team-info-table').append("<tr id='tr-1'>");
					$('#tr-1').append("<td rowspan='2' width='25%'><img alt='' src='"+teamlist.image+"'></td>");
					$('#tr-1').append("<td width='25%'><span style='font-size:2.0em;'>순위</span></td>");
					$('#tr-1').append("<td width='25%'><span style='font-size:2.0em;'>팀방어율</span></td>");
					$('#tr-1').append("<td width='25%'><span style='font-size:2.0em;'>팀타율</span></td>");
					$('#team-info-table').append("</tr>");
					$('#team-info-table').append("<tr id='tr-2'>");
					$('#tr-2').append("<td><span style='font-size:4.0em;'>"+teamlist.rank+"</span><span style='font-size:1.0em;'>위<span></td>");
					$('#tr-2').append("<td><span style='font-size:4.0em;'>"+teamlist.rankERA+"</span><span style='font-size:1.0em;'>위<span></td>");
					$('#tr-2').append("<td><span style='font-size:4.0em;'>"+teamlist.rankAVG+"</span><span style='font-size:1.0em;'>위<span></td>");
					$('#team-info-table').append("</tr>");
					$('#team-info').append("</table>");
				  }
			  });
			  
			  //방어율 1위
				$('#pitcher-era').append("<div id='title'><h3>방어율</h3></div>");
				$('#pitcher-era').append("<br/>");
				$('#pitcher-era').append("<img alt='' src='image/player/"+data.pitcherlist[0].playerId+".jpg' width='150px' height='190px'>");
				$('#pitcher-era').append("<div id='name'>"+data.pitcherlist[0].name+"</div>");
				$('#pitcher-era').append("<div id='detail'>"+data.pitcherlist[0].era.toFixed(2)+"</div><br/>");
				  
			  //다승 1위
			  	$('#pitcher-win').append("<div id='title'><h3>승리</h3></div>");
			  	$('#pitcher-win').append("<br/>");
			  	$('#pitcher-win').append("<img alt='' src='image/player/"+data.pitcherlist[1].playerId+".jpg' width='150px' height='190px'>");
				$('#pitcher-win').append("<div id='name'>"+data.pitcherlist[1].name+"</div>");
				$('#pitcher-win').append("<div id='detail'>"+data.pitcherlist[1].win+"</div><br/>");
			  //세이브 1위
			  	$('#pitcher-save').append("<div id='title'><h3>세이브</h3></div>");
			  	$('#pitcher-save').append("<br/>");
			  	$('#pitcher-save').append("<img alt='' src='image/player/"+data.pitcherlist[2].playerId+".jpg' width='150px' height='190px'>");
				$('#pitcher-save').append("<div id='name'>"+data.pitcherlist[2].name+"</div>");
				$('#pitcher-save').append("<div id='detail'>"+data.pitcherlist[2].save+"</div><br/>");
			  //삼진 1위
			  	$('#pitcher-so').append("<div id='title'><h3>탈삼진</h3></div>");
			  	$('#pitcher-so').append("<br/>");
			  	$('#pitcher-so').append("<img alt='' src='image/player/"+data.pitcherlist[3].playerId+".jpg' width='150px' height='190px'>");
				$('#pitcher-so').append("<div id='name'>"+data.pitcherlist[3].name+"</div>");
				$('#pitcher-so').append("<div id='detail'>"+data.pitcherlist[3].so+"</div><br/>");
			  //타율 1위
			  	$('#hitter-rate').append("<div id='title'><h3>타율</h3></div>");
			  	$('#hitter-rate').append("<br/>");
			  	$('#hitter-rate').append("<img alt='' src='image/player/"+data.hitterlist[0].playerId+".jpg' width='150px' height='190px'>");
			  	$('#hitter-rate').append("<div id='name'>"+data.hitterlist[0].name+"</div>");
			  	$('#hitter-rate').append("<div id='detail'>"+data.hitterlist[0].rate.toFixed(3)+"</div><br/>");			  	
			  //타점 1위
			  	$('#hitter-rbi').append("<div id='title'><h3>타점</h3></div>");
			  	$('#hitter-rbi').append("<br/>");
			  	$('#hitter-rbi').append("<img alt='' src='image/player/"+data.hitterlist[1].playerId+".jpg' width='150px' height='190px'>");
			  	$('#hitter-rbi').append("<div id='name'>"+data.hitterlist[1].name+"</div>");
			  	$('#hitter-rbi').append("<div id='detail'>"+data.hitterlist[1].rbi+"</div><br/>");	
			  //홈런 1위
			  	$('#hitter-hr').append("<div id='title'><h3>홈런</h3></div>");
			  	$('#hitter-hr').append("<br/>");
			  	$('#hitter-hr').append("<img alt='' src='image/player/"+data.hitterlist[2].playerId+".jpg' width='150px' height='190px'>");
			  	$('#hitter-hr').append("<div id='name'>"+data.hitterlist[2].name+"</div>");
			  	$('#hitter-hr').append("<div id='detail'>"+data.hitterlist[2].hr+"</div><br/>");	
			  //안타 1위
			  	$('#hitter-hits').append("<div id='title'><h3>안타</h3></div>");
			  	$('#hitter-hits').append("<br/>");
			  	$('#hitter-hits').append("<img alt='' src='image/player/"+data.hitterlist[3].playerId+".jpg' width='150px' height='190px'>");
			  	$('#hitter-hits').append("<div id='name'>"+data.hitterlist[3].name+"</div>");
			  	$('#hitter-hits').append("<div id='detail'>"+data.hitterlist[3].hits+"</div><br/>");	
		  }//success
	  })//ajax
  }//function
  
  $(function() {
	search(team);
});
  </script>
</head>
<body>
 	<%@ include file="header.jsp"%>
	<%@ include file="chat.jsp"%>

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
     	<div class="w3-full w3-panel w3-padding-16">
          <div class="w3-card" id="team-info"></div>
        </div>
      </div>
      <hr>
      
      <div class="w3-row" id="record">
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-era" align="center">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-win" align="center">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-save" align="center">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="pitcher-so" align="center">1/4</div>
        </div>
      </div>
      
      <div class="w3-row">
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-rate" align="center">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-rbi" align="center">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-hr" align="center">1/4</div>
        </div>
        <div class="w3-quarter w3-panel w3-padding-16">
          <div class="w3-card" id="hitter-hits" align="center">1/4</div>
        </div>
      </div>	
     </section>
    </div> <!-- /div 지우지마세 -->
</body>
</html>