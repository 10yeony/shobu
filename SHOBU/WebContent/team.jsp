<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>쇼부 Shobu</title>
  <style type="text/css">
  body{height: 100%;}
  #list {
  		width: 80%;
  		font-size: 0.9em;
  		}
  #list-div{
  		height: 415px;
  		overflow: auto;
  }
  #list-table{
  		font-size: 0.9em;
  }
  #review{
  		font-size: 0.8em;
  		font-weight: bold;
  		color: #FFFFFF;
  		background-color: #343d52;
  }
  #list-table thead tr{
		background-color: #343d52;
  		color: #FFFFFF;
  		}
  #search:hover{
  		font-weight: bold;
  		color: red;
  }
  </style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
					
					if(list.teamCode=="OB") list.teamCode = "두산";
					else if(list.teamCode=="SS") list.teamCode = "삼성";
					else if(list.teamCode=="HH") list.teamCode = "한화";
					else if(list.teamCode=="HT") list.teamCode = "기아";
					else if(list.teamCode=="LT") list.teamCode = "롯데";
					else if(list.teamCode=="WO") list.teamCode = "키움";
					
					$('#list-body').append("<tr id="+list.playerId+">");
					$('#'+list.playerId).append("<td>"+list.teamCode+"</td>");
					$('#'+list.playerId).append("<td>"+list.name+"</td>");
					$('#'+list.playerId).append("<td>"+list.games+"</td>");
					$('#'+list.playerId).append("<td>"+list.inning+"</td>");
					$('#'+list.playerId).append("<td style='font-weight:bold;'>"+list.era.toFixed(2)+"</td>");
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
					
					if(list.teamCode=="OB") list.teamCode = "두산";
					else if(list.teamCode=="SS") list.teamCode = "삼성";
					else if(list.teamCode=="HH") list.teamCode = "한화";
					else if(list.teamCode=="HT") list.teamCode = "기아";
					else if(list.teamCode=="LT") list.teamCode = "롯데";
					else if(list.teamCode=="WO") list.teamCode = "키움";
					
					$('#list-body').append("<tr id="+list.playerId+">");
					$('#'+list.playerId).append("<td>"+list.teamCode+"</td>");
					$('#'+list.playerId).append("<td>"+list.name+"</td>");
					$('#'+list.playerId).append("<td>"+list.games+"</td>");
					$('#'+list.playerId).append("<td style='font-weight:bold;'>"+list.rate.toFixed(3)+"</td>");
					$('#'+list.playerId).append("<td>"+list.ab+"</td>");
					$('#'+list.playerId).append("<td>"+list.hits+"</td>");
					$('#'+list.playerId).append("<td>"+list.hr+"</td>");
					$('#'+list.playerId).append("<td>"+list.rbi+"</td>");
					$('#'+list.playerId).append("<td>"+list.runs+"</td>");
					$('#'+list.playerId).append("<td>"+list.so+"</td>");
					$('#'+list.playerId).append("<td>"+list.bb+"</td>");
					$('#'+list.playerId).append("<td>"+list.obp.toFixed(3)+"</td>");
					$('#'+list.playerId).append("<td>"+list.slg.toFixed(3)+"</td>");
					$('#'+list.playerId).append("<td>"+list.ops.toFixed(3)+"</td>");
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
						$('#review').append("<img alt='' src='image/player/"+list.playerId+".jpg' width='80%'style='margin-top: 10px'><br/>");
						$('#review').append("<hr><div>"+list.name+" ("+list.position+")</div><br/>");
						$('#review').append("<div>NO. "+list.number+"</div><br/>");
						$('#review').append("<div>"+list.birth+"</div><br/>");
						$('#review').append("<div>"+list.type+"</div><br/>");
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
      <div align="center" style="font-size: 1.0em;">
      	<span id="search"><a href="javascript:selectMode('pitcher')">투수기록</a></span>
      	<span> | </span>
      	<span id="search"><a href="javascript:selectMode('hitter')">타자기록</a></span>
      </div>
​
      <!-- 카드 클래스안에 데이터만 입력 원하는 비율 선택-->
      <div class="w3-row">
      
        <div id="detail" class="w3-col w3-panel w3-padding-16" style="width: 20%;">
          <div class="w3-card" align="center" id="review">
          	<img alt="" src="image/profile/default.png" width="180px" height="226px" style="margin-top: 5px;">
          	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
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
  </div> <!-- </div>태그 지우면 nav깨짐 -->
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