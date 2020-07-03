<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>쇼부 Shobu</title>
<style>
/* 공통 css */
@charset "UTF-8";
.game{
	width:70%;
	margin: 20px auto 70px auto;
	text-align:center;
	margin-bottom:0; 
}
.teamlogo{
	width:50px; 
	height:50px; 
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
  max-width:100%;
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
  height: 30px;
  float: left;
  overflow: hidden;
  position: relative;
  width: 0;
}

.bar-graph-horizontal .bar-home .bar {
  border-radius: 3px;
  height: 30px;
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
	  font-weight: 600;
	  position: absolute;
	  right: 16px;
	  top: 5px;
      font-size: 12px;
	}
	
	.bar-graph-one .bar-home .bar::after {
	  -webkit-animation: fade-in-text 2.2s 0.1s forwards;
	  -moz-animation: fade-in-text 2.2s 0.1s forwards;
	  animation: fade-in-text 2.2s 0.1s forwards;
	  color: #fff;
	  content: attr(data-percentage);
	  font-weight: 600;
	  position: absolute;
	  left: 16px;
	  top: 5px;
   	  font-size: 12px;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		/* 같은 날 중복 투표 방지 */
		var toto = '${toto.id}';
		if(toto==''){
			$('#voteToto').css('display', 'block');
			$('#checkToto').css('display', 'none');
		}else{
			$('#voteToto').css('display', 'none');
			$('#checkToto').css('display', 'block');
		}
		
		/* 체크박스 선택시 둘 중 하나만 선택되게 함 */
		$('input[name=match0]').click(function(){
	        $('input[name=match0]').not($(this)).prop('checked',false);
		});
		$('input[name=match1]').click(function(){
	        $('input[name=match1]').not($(this)).prop('checked',false);
		});
		$('input[name=match2]').click(function(){
	        $('input[name=match2]').not($(this)).prop('checked',false);
		});
		$('input[name=match3]').click(function(){
	        $('input[name=match3]').not($(this)).prop('checked',false);
		});
		$('input[name=match4]').click(function(){
	        $('input[name=match4]').not($(this)).prop('checked',false);
		});
		
		/* 모의토토 제출 */
		$('.select').click(function(){
			/* 아이디 할당 */
			var id = '${member.id}';
			
			/* 오늘 날짜 할당 */ 
			var temp = new Date();   
			var year = temp.getFullYear(); // 년도
			var month = temp.getMonth() + 1;  // 월
			var date = temp.getDate();  // 날짜
			var day = temp.getDay(); //요일
			if(month<10){
				month = "0"+month;
			}
			if(date<10){
				date = "0"+date;
			}
			const today = year+"-"+month+"-"+date;
			
			/* 총 선택 개수 할당 */
			var totalCount = 0;
			/* game 변수에 각각 원정팀/홈팀/선택한팀 선언 */
			var game1;
			var game2;
			var game3;
			var game4;
			var game5;
			$('input[name=match0]:checked').each(function(){
				totalCount++;
				game1 = $(this).siblings('div').text() + $(this).val() + "/false";
			});
			$('input[name=match1]:checked').each(function(){
				totalCount++;
				game2 = $(this).siblings('div').text() + $(this).val() + "/false";
			});
			$('input[name=match2]:checked').each(function(){
				totalCount++;
				game3 = $(this).siblings('div').text() + $(this).val() + "/false";
			});
			$('input[name=match3]:checked').each(function(){
				totalCount++;
				game4 = $(this).siblings('div').text() + $(this).val() + "/false";
			});
			$('input[name=match4]:checked').each(function(){
				totalCount++;
				game5 = $(this).siblings('div').text() + $(this).val() + "/false";
			});
			
			
			/* 선택 버튼 클릭시 예외 처리 */
			if(day==0){//오늘이 일요일이면 다음날인 월요일에 경기를 하지 않음
				alert("내일은 경기가 없습니다");
				return false;
			}else if(id==''){//로그인해야 투표 가능
				alert("로그인하세요");
				return false;
			}else if(totalCount==0){//한 경기도 선택하지 않았을 때
				alert("적어도 한 경기는 선택하세요");
				return false;
			}
			
			/* ajax로 폼값 보내고 결과적으로 toto 테이블에 저장 */
			$.ajax({
    			type:'post',
				url:'voteToto.do',
				data:"id="+id+"&date="+today+"&game1="+game1+"&game2="+game2+"&game3="+game3+"&game4="+game4+"&game5="+game5+"&totalCount="+totalCount,
  		       	
  		       	success: function(data){
  		       		console.log(data);
  		       		$('.select').prop("disabled",true);
  		       		$('.select').css("background-color","gray");
  		       		$('.select').css("border","1px solid gray");
  		       		$('.select').css("cursor","default");
  		       		$('.checkbox').prop("disabled",true);
  		       		
  		       	}//~sucess
  		    });//ajax
  		    
		});
	});
</script>
</head>

<body>
 	<!-- header -->
 	<%@ include file="header.jsp"%>
	<%@ include file="chat.jsp"%>
	
    <section>
      <!-- 상단 여백 처리-->
      <div style="padding-top: 20px;"></div>
       <div class="w3-col w3-panel w3-padding-16" style="width: 100%;">
       
       <!-- 모의 토토 시작 -->
       <h3 style="text-align: center;">모의 토토</h3>
       <div id=voteToto>
       <form action="toto.do" method="post">
         <!-- 선택지 -->
         <c:choose>
         	<c:when test="${ f:length(matchs)==0}">
         		<p style="text-align:center; padding: 8% 0; font-weight: bold;">오늘은 경기가 없습니다.</p>
         	</c:when>
         	<c:otherwise>
		         <c:forEach items="${matchs}" var="match" varStatus="s">
				     <table class="game">
				       <tr>
					     <td class="away">
					       <div style="display:none;">${match.away}/${match.home}/</div>
					       <img class="teamlogo" src="${match.awayImg}">
					       <input type="checkbox" class="checkbox" name="match${s.index}" value="${match.away}"><br>
					       <span>${match.awayPitcher}</span>
					     </td> 
						 <td class="graph"> 
						   <section class="bar-graph bar-graph-horizontal bar-graph-one">
							 <div class="bar-away">
							   <div class="bar" data-percentage="<fmt:formatNumber value="${match.awayRatio}" pattern="#.00"/>%" style="width:${match.awayRatio}%; background-color:${match.awayColor};"></div>
							 </div>
							 <div class="bar-home">
							   <div class="bar" data-percentage="<fmt:formatNumber value="${match.homeRatio}" pattern="#.00"/>%" style="width:${match.homeRatio}%; background-color:${match.homeColor};"></div>
							 </div>
						   </section>
						 </td> 
						 <td class="home">
						   <div style="display:none;">${match.away}/${match.home}/</div>
						   <input type="checkbox" class="checkbox" name="match${s.index}" value="${match.home}">
						   <img class="teamlogo" src="${match.homeImg}" width="50"><br>
						   <span>${match.homePitcher}</span>
						 </td>
					   </tr>
					 </table>
				 </c:forEach>
				</c:otherwise>
			</c:choose>
		 
		 <p style="text-align:center; margin-top:20px;">
	    	<button type="button" class="select">선택</button>
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