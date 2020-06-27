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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script src="js/index.js"></script>
</head>

<body>
  <!-- 슬라이드 메뉴바 -->
  <nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="nav">
    <div style="background-color: #343d52; height: 60px;">토토</div>
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="navClose()">Close</a>
    <!-- 입력 -->
    <a href="#" id="main">메인</a><br>
    <a href="#" id="team">팀정보</a><br>
    <a href="#">선수정보</a><br>
    <a href="#" id="toto">모의토토</a><br>
    <a href="#">토토 판매점</a><br>
  </nav>
​
  <!-- 메뉴바 클릭 시 화면 어둡게 처리 -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="navClose()" style="cursor:pointer" id="overlay">
  </div>
​
  <!-- 상단 서치바, 유저정보(썸네일, 아이디) -->
  <div class="w3-main" style="margin-left:250px;">
    <header class="w3-container w3-top" style="background-color: #343d52; color: white; height: 60px;">
      <a href="../login.html">로그인</a> 
      <a href="logout.do">로그아웃</a>
      <i class="fa fa-bars w3-button w3-hide-large w3-display-left" onclick="navOpen()"></i>
      <span class="w3-hide-large w3-right w3-animate-opacity" style="position: relative; top: 25%;">
      	<img src="${member.image}" width="40px" height="40px">
      </span>
      <span class="w3-hide-large w3-right w3-animate-opacity" style="position: relative; top: 25%;">
      	${member.name} 님
      </span>
​
      <div class="w3-hide-small w3-hide-medium w3-animate-opacity"
        style="width:100%; height: 100%; text-align: right; margin-left: -250px;">
        <span style="position: relative; top: 25%;">
          <img src="${member.image}" width="40px" height="40px">
        </span>
        <span style="position: relative; top: 25%;">
          ${member.name} 님
        </span>
      </div>
    </header>
​	
	<!-- contents영역 -->
	
	<section>
      <div class="container-fluid">
        <div class="load-html" id="body" data-source="index.jsp"></div>
      </div>
    </section>
   </div>
    
<script>
$(function () {
    $('.load-html').each(function () {
        $(this).load(this.dataset.source);
    });
    
    $('#main').click(function(){
    	$('#body').attr('data-source','index.jsp');
    	$('.load-html').each(function () {
            $(this).load(this.dataset.source);
        });
    });
    
    $('#team').click(function(){
    	$('#body').attr('data-source','team.html');
    	$('.load-html').each(function () {
            $(this).load(this.dataset.source);
        });
    });
	
    $('#toto').click(function(){
    	$('#body').attr('data-source','toto.jsp');
    	$('.load-html').each(function () {
            $(this).load(this.dataset.source);
        });
    });
});
</script>

</body>
</html>
