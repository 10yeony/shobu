<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>쇼부 SHOBU</title>
  <style type="text/css">
  </style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	function list() {
		$.ajax({
			type:'post',
			url:'playerlist.do',
			data:'teamName='+$(this).val(),
			
			success:function(data){
				$('#resultView').html(data)
			}
		})//ajax
	}//function
})//ready

</script>
</head>
<body>
	<!-- header -->
	<%@ include file="header.jsp"%>
	
    <section>
      <!-- 상단 여백 처리-->
      <div style="padding-top: 60px;" align="center">
      	<span><a href="#" onclick=list()>전체</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#" onclick=list()>NC</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#" onclick=list()>두산</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">키움</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">LG</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">기아</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">롯데</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">KT</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">삼성</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">SK</a></span>&nbsp;&nbsp;&nbsp;
      	<span><a href="#">한화</a></span>&nbsp;&nbsp;&nbsp;
      </div>
​
      <!-- 카드 클래스안에 데이터만 입력 원하는 비율 선택-->
      <div class="w3-row">
        <div id="detail" class="w3-col w3-panel w3-padding-16" style="width: 20%;">
          <div class="w3-card" align="center">
          	<img alt="" src="https://link-u.co.kr/www/thumbs/intro/basic_user.png" width="180px" height="226px" style="margin-top: 10px">
		  </div>
        </div>
        <div id="list" class="w3-col w3-panel w3-padding-16" style="width: 80%;">
          <div class="w3-card">
          	<table class="w3-table-all w3-hoverable">
          		<thead>
          			<tr>
          				<th>이름</th>
          				<th>ERA</th>
          				<th>경기수</th>
          				<th>이닝</th>
          				<th>승리</th>
          				<th>패배</th>
          				<th>세이브</th>
          				<th>홀드</th>
          				<th>탈삼진</th>
          				<th>피안타</th>
          				<th>실점</th>
          				<th>볼넷</th>
          			</tr>
          		</thead>
          		<tbody>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          			<tr>
          				<td>dd</td>
          			</tr>
          		
          		</tbody>
          	</table>
          </div>
        </div>
      </div>
​
    </section>
  </div> <!-- 없으면 nav영역 어긋남 -->
</body>
</html>