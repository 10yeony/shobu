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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/index.css">
  <!--삭제필요 -->
  <style type="text/css">
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
	  display:contents;
	}
	.bar-graph-horizontal .bar-home{
	  float: right;
	  margin-bottom: 8px;
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
	
	.bar-graph-one .bar-away .bar::after {
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
	
	.bar-graph-one .bar-home .bar::after {
	  -webkit-animation: fade-in-text 2.2s 0.1s forwards;
	  -moz-animation: fade-in-text 2.2s 0.1s forwards;
	  animation: fade-in-text 2.2s 0.1s forwards;
	  color: #fff;
	  content: attr(data-percentage);
	  font-weight: 700;
	  position: absolute;
	  left: 16px;
	  top: 17px;
	}
	
	.bar-graph-one .bar-away .bar {
	  -webkit-animation: show-bar-one 1.2s 0.1s forwards;
	  -moz-animation: show-bar-one 1.2s 0.1s forwards;
	  animation: show-bar-one 1.2s 0.1s forwards;
	}
	
	.bar-graph-one .bar-home .bar {
	  -webkit-animation: show-bar-two 1.2s 0.2s forwards;
	  -moz-animation: show-bar-two 1.2s 0.2s forwards;
	  animation: show-bar-two 1.2s 0.2s forwards;
	}
	
	/* Bar Graph Horizontal Animations */
	@-webkit-keyframes show-bar-one {
	  0% {
	    width: 0;
	  }
	}
	
	@-webkit-keyframes show-bar-two {
	  0% {
	    width: 0;
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
	.carousel-indicators{
	 	z-index: 2;
	}
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
		.content-table tbody tr:last-of-type {
			border-bottom: 2px solid #009879;
		}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="js/index.js"></script>
</head>

<body>
 	
 	<%@ include file="header.jsp"%>
 	
	<section>
      <!-- 상단 여백 처리-->
      <div style="padding-top: 60px;">
      	<div class="w3-col w3-panel w3-padding-16" style="width: 100%;">
      		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			    
			    <!-- Indicators -->
			    <ol class="carousel-indicators"></ol>
			
			    <!-- Wrapper for slides -->
			    <div class="carousel-inner">
			      
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
        </div>
      </div>
     </section>
</body>
</html>
