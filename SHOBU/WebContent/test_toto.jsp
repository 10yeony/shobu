<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		$('button').click(function(){
			
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
				game1 = $(this).siblings('div').text() + $(this).val();
			});
			$('input[name=match1]:checked').each(function(){
				totalCount++;
				game2 = $(this).siblings('div').text() + $(this).val();
			});
			$('input[name=match2]:checked').each(function(){
				totalCount++;
				game3 = $(this).siblings('div').text() + $(this).val();
			});
			$('input[name=match3]:checked').each(function(){
				totalCount++;
				game4 = $(this).siblings('div').text() + $(this).val();
			});
			$('input[name=match4]:checked').each(function(){
				totalCount++;
				game5 = $(this).siblings('div').text() + $(this).val();
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
				dataType:'json',
				data:"id="+id+"&date="+today+"&game1="+game1+"&game2="+game2+"&game3="+game3+"&game4="+game4+"&game5="+game5+"&totalCount="+totalCount,
  		       	
  		       	success: function(data){
  		       		alert("성공");
  		       		$('#voteToto').css('display', 'none');
  					$('#checkToto').css('display', 'block');
  		       	}
  		    });//ajax
		});
	});
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
       <div id=voteToto>
       <form action="toto.do" method="post">
         <!-- 선택지 -->
				     <table class="game">
				       <tr>
					     <td class="away">
					       <div style="display:none;">삼성/롯데/</div>
					       <img class="teamlogo" src="image/team/SS.png">
					       <input type="checkbox" name="match0" value="삼성"><br>
					       <span>백정현</span>
					     </td> 
						 <td class="graph"> 
						   <section class="bar-graph bar-graph-horizontal bar-graph-one">
							 <div class="bar-away">
							   <div class="bar" data-percentage="30%" style="width:30%; background-color:red;"></div>
							 </div>
							 <div class="bar-home">
							   <div class="bar" data-percentage="70%" style="width:70%; background-color:blue;"></div>
							 </div>
						   </section>
						 </td> 
						 <td class="home">
						   <div style="display:none;">삼성/롯데/</div>
						   <input type="checkbox" name="match0" value="롯데">
						   <img class="teamlogo" src="image/team/LT.png" width="50"><br>
						   <span>샘슨</span>
						 </td>
					   </tr>
				       <tr>
					     <td class="away">
					       <div style="display:none;">NC/두산/</div>
					       <img class="teamlogo" src="image/team/NC.png">
					       <input type="checkbox" name="match1" value="NC"><br>
					       <span>배재환</span>
					     </td> 
						 <td class="graph"> 
						   <section class="bar-graph bar-graph-horizontal bar-graph-one">
							 <div class="bar-away">
							   <div class="bar" data-percentage="30%" style="width:30%; background-color:red;"></div>
							 </div>
							 <div class="bar-home">
							   <div class="bar" data-percentage="70%" style="width:70%; background-color:blue;"></div>
							 </div>
						   </section>
						 </td> 
						 <td class="home">
						   <div style="display:none;">NC/두산/</div>
						   <input type="checkbox" name="match1" value="두산">
						   <img class="teamlogo" src="image/team/OB.png" width="50"><br>
						   <span>함덕주</span>
						 </td>
					   </tr>
				       <tr>
					     <td class="away">
					       <div style="display:none;">LG/SK/</div>
					       <img class="teamlogo" src="image/team/LG.png">
					       <input type="checkbox" name="match2" value="LG"><br>
					       <span>핀토</span>
					     </td> 
						 <td class="graph"> 
						   <section class="bar-graph bar-graph-horizontal bar-graph-one">
							 <div class="bar-away">
							   <div class="bar" data-percentage="30%" style="width:30%; background-color:red;"></div>
							 </div>
							 <div class="bar-home">
							   <div class="bar" data-percentage="70%" style="width:70%; background-color:blue;"></div>
							 </div>
						   </section>
						 </td> 
						 <td class="home">
						   <div style="display:none;">LG/SK/</div>
						   <input type="checkbox" name="match2" value="SK">
						   <img class="teamlogo" src="image/team/SK.png" width="50"><br>
						   <span>정찬헌</span>
						 </td>
					   </tr>
				       <tr>
					     <td class="away">
					       <div style="display:none;">KT/한화/</div>
					       <img class="teamlogo" src="image/team/KT.png">
					       <input type="checkbox" name="match3" value="KT"><br>
					       <span>쿠에바스</span>
					     </td> 
						 <td class="graph"> 
						   <section class="bar-graph bar-graph-horizontal bar-graph-one">
							 <div class="bar-away">
							   <div class="bar" data-percentage="30%" style="width:30%; background-color:red;"></div>
							 </div>
							 <div class="bar-home">
							   <div class="bar" data-percentage="70%" style="width:70%; background-color:blue;"></div>
							 </div>
						   </section>
						 </td> 
						 <td class="home">
						   <div style="display:none;">KT/한화/</div>
						   <input type="checkbox" name="match3" value="한화">
						   <img class="teamlogo" src="image/team/HH.png" width="50"><br>
						   <span>김민우</span>
						 </td>
					   </tr>
				       <tr>
					     <td class="away">
					       <div style="display:none;">기아/키움/</div>
					       <img class="teamlogo" src="image/team/HT.png">
					       <input type="checkbox" name="match4" value="기아"><br>
					       <span>양현종</span>
					     </td> 
						 <td class="graph"> 
						   <section class="bar-graph bar-graph-horizontal bar-graph-one">
							 <div class="bar-away">
							   <div class="bar" data-percentage="30%" style="width:30%; background-color:red;"></div>
							 </div>
							 <div class="bar-home">
							   <div class="bar" data-percentage="70%" style="width:70%; background-color:blue;"></div>
							 </div>
						   </section>
						 </td> 
						 <td class="home">
						   <div style="display:none;">기아/키움/</div>
						   <input type="checkbox" name="match4" value="키움">
						   <img class="teamlogo" src="image/team/WO.png" width="50"><br>
						   <span>요키시</span>
						 </td>
					   </tr>
					 </table>
		 
		 <p style="text-align:center; margin-top:20px;">
	    	<button type="button" id=“select”>선택</button>
	   	</p>
	    </form>
	    </div>
	    <div id="checkToto" style="display:none">
	       <p>나의 선택</p>
	       <p>${toto.game1}</p>
	       <p>${toto.game2}</p>
	       <p>${toto.game3}</p>
	       <p>${toto.game4}</p>
	       <p>${toto.game5}</p>
	    </div>
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