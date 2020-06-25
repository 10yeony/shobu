<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>쇼부 Shobu</title>
  	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<link rel="stylesheet" href="css/index.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
		.game{ margin-bottom: 0; }
		.teamlogo{ width:50px; height:50px; }
		.bar-graph-horizontal .bar-away .bar, .bar-graph-horizontal .bar-home .bar { height:30px; }
		.bar-graph-one .bar::after{ top: 6px; }
		.bar-graph-horizontal { max-width:100%; }
	</style>  
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
   function init(){
	  	//alert("!");
   }
  </script>
</head>

<body onload="init();">
  <!-- 슬라이드 메뉴바 -->
  <nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="nav">
    <div style="background-color: #343d52; height: 60px;">토토</div>
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="navClose()">Close</a>
    <!-- 입력 -->
    <a href="index.jsp">메인</a><br>
    <a href="#">팀정보</a><br>
    <a href="#">선수정보</a><br>
    <a href="toto.jsp">모의토토</a><br>
    <a href="#">토토 판매점</a><br>
  </nav>
​
  <!-- 메뉴바 클릭 시 화면 어둡게 처리 -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="navClose()" style="cursor:pointer" id="overlay">
  </div>
  
  <!-- 상단 서치바, 유저정보(썸네일, 아이디) -->
  <div class="w3-main" style="margin-left:250px;">
    <header class="w3-container w3-top" style="background-color: #343d52; height: 60px;">
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
      <div style="padding-top: 20px;"></div>
       <div class="w3-col w3-panel w3-padding-16" style="width: 100%;">
       
       <!-- 모의 토토 시작 -->
       
       <h3 style="text-align: center;">모의 토토</h3>
       <form action="toto.do" method="post">
         <!-- 첫번째 선택지 -->
	     <table class="game">
	       <tr>
		     <td class="away">
		       <img class="teamlogo" src="image/team/HH.png">
		       <input type="radio" name="match1" value="HH">
		     </td> 
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
			 <td class="home">
			   <input type="radio" name="match1" value="SS">
			   <img class="teamlogo" src="image/team/SS.png" width="50">
			 </td>
		   </tr>
		 </table>
		 
		 <!-- 두번째 선택지 -->
		 <table class="game">
		   <tr>
		     <td class="away">
		       <img class="teamlogo" src="image/team/WO.png">
		       <input type="radio" name="match2" value="WO">
		     </td> 
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
			 <td class="home">
			   <input type="radio" name="match2" value="LG">
			   <img class="teamlogo" src="image/team/LG.png">
			 </td>
		   </tr>
		 </table>
		 
		 <!-- 세번째 선택지 -->
		 <table class="game">
		   <tr>
		     <td class="away">
		       <img class="teamlogo" src="image/team/OB.png">
		       <input type="radio" name="match3" value="OB">
		     </td> 
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
			 <td class="home">
			   <input type="radio" name="match3" value="SK">
			   <img class="teamlogo" src="image/team/SK.png">
			 </td>
		   </tr>
		 </table>
		 
		 <!-- 네번째 선택지 -->
		 <table class="game">
		   <tr>
		     <td class="away">
		       <img class="teamlogo" src="image/team/NC.png">
		       <input type="radio" name="match4" value="NC">
		     </td> 
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
			 <td class="home">
			   <input type="radio" name="match4" value="KT">
			   <img class="teamlogo" src="image/team/KT.png">
			 </td>
		   </tr>
	     </table>
	     
	     <!-- 다섯번째 선택지 -->
	     <table class="game">
		   <tr>
		     <td class="away">
		       <img class="teamlogo" src="image/team/HT.png">
		       <input type="radio" name="match5" value="HT">
		     </td> 
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
			  <td class="home">
			    <input type="radio" name="match5" value="LT">
			    <img class="teamlogo" src="image/team/LT.png">
			  </td>
			</tr>
	      </table>
	      <p style="text-align:center; margin-top:20px;">
	        <button type="submit" class="w3-button w3-black">선택</button>
	      </p>
	    </form>
	      
	      <!-- 모의 토토 끝 -->
		  
	      <!-- 회원 랭킹 시작 -->
	      <h3 style="text-align: center; margin-top:80px; margin-bottom:20px;">회원 랭킹</h3>
		  <table class="content-table" style="width: 50%; margin: 0 auto;">
  		    <thead>
    		  <tr>
      		    <th>순위</th>
      			<th>닉네임</th>
      			<th>포인트</th>
    		  </tr>
  			</thead>
  			<tbody>
    		  <tr>
      		    <td>1</td>
      			<td>토토사랑</td>
      			<td>88,110</td>
			  </tr>
    		  <tr>
      		    <td>2</td>
      			<td>토쟁이</td>
      			<td>72,400</td>
    		  </tr>
    		  <tr>
      		    <td>3</td>
      			<td>부자</td>
      			<td>52,300</td>
    		  </tr>
    		  <tr>
      		    <td>4</td>
      			<td>벼락부자</td>
      			<td>52,300</td>
    		  </tr>
    		  <tr>
      		    <td>5</td>
      			<td>토신</td>
      			<td>52,300</td>
    		  </tr>
  			</tbody>
		  </table>
		  <!-- 회원 랭킹 끝 -->
        </div>
    </section>
  </div>
</body>
</html>