<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>쇼부 Shobu</title>
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
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/index.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
  <!-- 슬라이드 메뉴바 -->
  <nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="nav">
    <div style="background-color: #00907e; height: 60px;">토토</div>
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="navClose()">Close</a>
    <!-- 입력 -->
    <a href="index.jsp">메인</a><br>
    <a href="#">선수정보</a><br>
    <a href="#">경기일정</a><br>
    <a href="#">모의토토</a><br>
    <a href="#">토토 판매점</a><br>
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
      <div style="padding-top: 60px;"></div>
​
       <div class="w3-col w3-panel w3-padding-16" style="width: 100%;">
          	<div id="myCarousel" class="carousel slide" data-ride="carousel">
			    <!-- Indicators -->
			    <ol class="carousel-indicators">
			      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			      <li data-target="#myCarousel" data-slide-to="1"></li>
			      <li data-target="#myCarousel" data-slide-to="2"></li>
			      <li data-target="#myCarousel" data-slide-to="3"></li>
			      <li data-target="#myCarousel" data-slide-to="4"></li>
			    </ol>
			
			    <!-- Wrapper for slides -->
			    <div class="carousel-inner">
			      <div class="item active">
			      <table class="game">
			      	<tr>
			      		<td class="home"><img class="teamlogo" src="img/team/hanhwa.png"></td> 
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
			      		<td class="away"><img class="teamlogo" src="img/team/samsung.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td>시간</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			
			      <div class="item">
			       <table class="game">
			      	<tr>
			      		<td class="home"><img class="teamlogo" src="img/team/kiwoom.png"></td> 
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
			      		<td class="away"><img class="teamlogo" src="img/team/lg.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td>시간</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			    
			      <div class="item">
			        <table class="game">
			      	<tr>
			      		<td class="home"><img class="teamlogo" src="img/team/doosan.png"></td> 
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
			      		<td class="away"><img class="teamlogo" src="img/team/sk.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td>시간</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			      
			       <div class="item">
			        <table class="game">
			      	<tr>
			      		<td class="home"><img class="teamlogo" src="img/team/nc.png"></td> 
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
			      		<td class="away"><img class="teamlogo" src="img/team/kt.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td >시간</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
			      </div>
			      
			       <div class="item">
			        <table class="game">
			      	<tr>
			      		<td class="home"><img class="teamlogo" src="img/team/kia.png"></td> 
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
			      		<td class="away"><img class="teamlogo" src="img/team/lotte.png"></td>
			      	</tr>
			      	<tr class='bold'>
			      		<td>선발투수</td> <td>경기장</td> <td>선발투수</td>
			      	</tr>
			      	<tr>
			      		<td>이름ㅇ</td> <td>시간</td> <td>이름ㅇ</td>
			      	</tr>
			      </table>
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
        </div>
     	
    </section>
  </div>
</body>
</html>
