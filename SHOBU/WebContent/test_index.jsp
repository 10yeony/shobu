<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="content-script-type" content="text/javascript">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>쇼부 Shobu</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/index.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script src="js/index.js"></script>
</head>

<body>
	<!-- contents영역 -->
	
	<section>
      <!-- 상단 여백 처리-->
      <div style="padding-top: 60px;"></div>
      	<div class="w3-col w3-panel w3-padding-16" style="width: 100%;">
      		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			    <!-- Indicators -->
			    <ol class="carousel-indicators"></ol>
			
			    <!-- Wrapper for slides -->
			    <div class="carousel-inner">
			      <!-- <div class="item active">
			      <table class="game">
			      	<tr>
			      		<td class="away"><img class="teamlogo" src="image/team/HH.png"></td> 
			      		<td class="graph"> 
			      			<section class="bar-graph bar-graph-horizontal bar-graph-one">
							  <div class="bar-away">
							    <div class="bar" data-percentage="69.6%"></div>
							   </div>
							    <div class="bar-home">
							    <div class="bar" data-percentage="30.4%"></div>
							  </div>
							</section>
						</td> 
			      		<td class="home"><img class="teamlogo" src="image/team/SS.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장<br>시간ㄴ</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">유</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">경기</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">승패</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">이닝</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">ERA</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			
			      <div class="item">
			       <table class="game">
			      	<tr>
			      		<td class="away"><img class="teamlogo" src="image/team/WO.png"></td> 
			      		<td class="graph"> 
			      			<section class="bar-graph bar-graph-horizontal bar-graph-one">
							  <div class="bar-away">
							    <div class="bar" data-percentage="69.6%"></div>
							   </div>
							    <div class="bar-home">
							    <div class="bar" data-percentage="30.4%"></div>
							  </div>
							</section>
						</td> 
			      		<td class="home"><img class="teamlogo" src="image/team/LG.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장<br>시간ㄴ</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">경기</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">승패</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">이닝</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">ERA</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			    
			      <div class="item">
			        <table class="game">
			      	<tr>
			      		<td class="away"><img class="teamlogo" src="image/team/OB.png"></td> 
			      		<td class="graph"> 
			      			<section class="bar-graph bar-graph-horizontal bar-graph-one">
							  <div class="bar-away">
							    <div class="bar" data-percentage="69.6%"></div>
							   </div>
							    <div class="bar-home">
							    <div class="bar" data-percentage="30.4%"></div>
							  </div>
							</section>
						</td> 
			      		<td class="home"><img class="teamlogo" src="image/team/SK.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장<br>시간ㄴ</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">경기</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">승패</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">이닝</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">ERA</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			      
			       <div class="item">
			        <table class="game">
			      	<tr>
			      		<td class="away"><img class="teamlogo" src="image/team/NC.png"></td> 
			      		<td class="graph"> 
			      			<section class="bar-graph bar-graph-horizontal bar-graph-one">
							  <div class="bar-away">
							    <div class="bar" data-percentage="69.6%"></div>
							   </div>
							    <div class="bar-home">
							    <div class="bar" data-percentage="30.4%"></div>
							  </div>
							</section>
						</td> 
			      		<td class="home"><img class="teamlogo" src="image/team/KT.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장<br>시간ㄴ</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">경기</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">승패</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">이닝</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">ERA</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			      
			       <div class="item">
			        <table class="game">
			      	<tr>
			      		<td class="away"><img class="teamlogo" src="image/team/HT.png"></td> 
			      		<td class="graph"> 
			      			<section class="bar-graph bar-graph-horizontal bar-graph-one">
							  <div class="bar-away">
							    <div class="bar" data-percentage="69.6%"></div>
							   </div>
							    <div class="bar-home">
							    <div class="bar" data-percentage="30.4%"></div>
							  </div>
							</section>
						</td> 
			      		<td class="home"><img class="teamlogo" src="image/team/LT.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장<br>시간ㄴ</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">경기</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">승패</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">이닝</td> <td>이름ㅇ</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td class="lab">ERA</td> <td>이름ㅇ</td>
			      	</tr>
			      </table> -->
			    </div>
			
			    <!-- Left and right controls -->
			    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
			      <span class="glyphicon glyphicon-chevron-left"></span>
			      <span class="sr-only">Previous</span>
			    </a>
			    <a class="right carousel-control" href="#myCarousel" data-slide="next">
			      <span class="glyphicon glyphicon-chevron-right"></span>
			      <span class="sr-only">Next</span>
			    </a>
			  </div>
			  </div>
			  <!-- ~slider -->
			  <p>
			  <!-- team Rank -->
			  	<table class="content-table" style="width: 100%; margin: 0 auto;">
  							<thead>
    							<tr>
      								<th>순위</th>
      								<th>팀이름</th>
      								<th>승</th>
      								<th>무</th>
      								<th>패</th>
      								<th>승률</th>
      								<th>게임차</th>
      								<th>팀타율</th>
      								<th>팀방어율</th>
      								<th>연승</th>
      								<th>최근10경기</th>
    							</tr>
  							</thead>
  							<tbody id="teamrank">
  							</tbody>
						</table>
        		<!-- ~TEAM Rank -->
</body>
</html>
