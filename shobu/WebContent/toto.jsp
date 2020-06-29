<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>쇼부 Shobu</title>
<link rel="stylesheet" href="css/index.css">
<style>
/* 공통 css */
@charset "UTF-8";
.game{
	width:70%;
	margin: 20px auto 70px auto;
	text-align:center;
}
.teamlogo{
	width:100%;
}

.bold{
	font-weight: bold;
	font-size:medium;
}

.lab{
	color: #9FA2A6;
	font-weight: bold;
}

.graph{
	width: 60%;
	margin: 0  auto;
}

/* Bar Graph Horizontal */
.bar-graph{
  -webkit-animation: fade-in-text 2.2s 0.1s forwards;
  -moz-animation: fade-in-text 2.2s 0.1s forwards;
  animation: fade-in-text 2.2s 0.1s forwards;
  opacity: 0;
}

.bar-graph-horizontal {
  max-width: 90%;
  margin: 0 auto;
}

.bar-graph-horizontal .bar-away{
  float: left;
  margin-bottom: 8px;
  width: 69.6%; /*변경*/
  display:contents;
}
.bar-graph-horizontal .bar-home{
  float: right;
  margin-bottom: 8px;
  width: 30.4%; /*변경*/
   display:contents;
}

.bar-graph-horizontal .bar-away .bar {
  border-radius: 3px;
  height: 55px;
  float: left;
  overflow: hidden;
  position: relative;
  width: 0;
}

.bar-graph-horizontal .bar-home .bar {
  border-radius: 3px;
  height: 55px;
  float: right;
  overflow: hidden;
  position: relative;
  width: 0;
}

.bar-graph-one .bar::after {
  -webkit-animation: fade-in-text 2.2s 0.1s forwards;
  -moz-animation: fade-in-text 2.2s 0.1s forwards;
  animation: fade-in-text 2.2s 0.1s forwards;
  color: #fff;
  content: attr(data-percentage);
  font-weight: 700;
  position: absolute;
  right: 16px;
  top: 17px;
}

.bar-graph-one .bar-away .bar {
  background-color: #64b2d1;
  -webkit-animation: show-bar-one 1.2s 0.1s forwards;
  -moz-animation: show-bar-one 1.2s 0.1s forwards;
  animation: show-bar-one 1.2s 0.1s forwards;
}

.bar-graph-one .bar-home .bar {
  background-color: #5292ac;
  -webkit-animation: show-bar-two 1.2s 0.2s forwards;
  -moz-animation: show-bar-two 1.2s 0.2s forwards;
  animation: show-bar-two 1.2s 0.2s forwards;
}

/* Bar Graph Horizontal Animations */
@-webkit-keyframes show-bar-one {
  0% {
    width: 0;
  }
  100% {
    width: 69.6%; /*변경*/
  }
}

@-webkit-keyframes show-bar-two {
  0% {
    width: 0;
  }
  100% {
    width: 30.4%; /*변경*/
  }
}
@-webkit-keyframes fade-in-text {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
/*~Graph*/

/*carosel Control button shodow*/
.carousel-control {
    opacity: .1;
}

/*carosel dot*/
.carousel-indicators li {
    border: 1px solid #343D52;
}

.carousel-indicators .active {
    background-color: #343D52;
}

/*Team Ranking Talbe*/

.content-table {
  		border-collapse: collapse;
  		margin: 25px 0;
  		font-size: 0.9em;
  		min-width: 400px;
  		border-radius: 5px 5px 0 0;
  		overflow: hidden;
  		box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	}
	.content-table thead tr {
  		background-color: #343d52;
  		color: #FFFFFF;
  		text-align: left;
  		font-weight: bold;
	}
	.content-table th,
	.content-table td {
  		padding: 12px 15px;
	}
	.content-table tbody tr {
		border-bottom: 1px solid #DDDDDD;
	}
	.content-table tbody tr:nth-of-type(even) {
		background-color: #F3F3F3;
		color: #343d52;
	}
	.content-table tbody tr:nth-of-type(odd) {
		background-color: #FFFFFF;
	}
	
		
	/* 모의토토 페이지 css */
	.game { margin-bottom:0; }
	
	.teamlogo{ width:50px; height:50px; }
	
	.bar-graph-horizontal .bar-away .bar, .bar-graph-horizontal .bar-home .bar { height:30px; }
	
	.bar-graph-one .bar::after{ top:6px; }
	
	.bar-graph-horizontal { max-width:100%; }
	
	.content-table tbody tr:last-of-type { border-bottom:2px solid #343D52; }
	
	#select {
		display:inline-block;
		padding:.5em .75em;
		color:#fff;
  		font-size:inherit;
  		line-height:normal;
  		vertical-align:middle;
  		background-color:#343D52;
  		cursor:pointer;
		border:1px solid #343D52;
  		border-radius:.25em;
  		-webkit-transition:background-color 0.2s;
  		transition:background-color 0.2s;
	}

	#select:hover { background-color:#fff; color:#343D52; }

	#select:active { background-color:#fff; color:#343D52; }
</style>
<script>
	
</script>
</head>

<body>
 	<!-- header -->
 	<%@ include file="header.jsp"%>
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
	        <button type="submit" id="select">선택</button>
	      </p>
	    </form><!-- 모의 토토 끝 -->
		  
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
  			    <c:forEach var="i" begin="1" end="5">
    		    <tr>
      		        <td>${i}</td>
      			    <td>${memberList[i-1].nickname}</td>
      			    <td>${memberList[i-1].point}</td>
			    </tr>
			    </c:forEach>
  			</tbody>
		  </table><!-- 회원 랭킹 끝 -->
        </div>
    </section>
  </div> <!-- 이거 지우면 nav영역 어긋남 -->
</body>
</html>