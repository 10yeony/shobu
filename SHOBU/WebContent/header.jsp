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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <style>
  .menu{
  	width: 25px;
  	margin: 20px 10px;
  	text-decoration:none;
  }
  .menu a:-webkit-any-link, #menu a:-webkit-any-link,#login a:-webkit-any-link{
  	text-decoration:none;
  }
  #login{
 	width:100%;
  	background-color: #343d52;
  	color:#fff;
  	position:absolute; 
  	padding: 3px 20px;
  	bottom:0px;
  }
  
  /* 내 정보 영역 */
  button  {
  	display: inline-block;
  	padding: .5em .75em;
  	color: #fff;
  	font-size: inherit;
  	line-height: normal;
  	vertical-align: middle;
  	background-color: #343D52;
  	cursor: pointer;
  	border: 1px solid #343D52;
  	border-radius: .25em;
  	-webkit-transition: background-color 0.2s;
  	transition: background-color 0.2s;
  }
  button:hover, button:active {
  	background-color: #fff;
  	color: #343D52;
  }
  .leaveBtn {
    display: inline-block;
  	padding: .5em .75em;
  	color: #fff;
  	font-size: inherit;
  	line-height: normal;
  	vertical-align: middle;
  	background-color: #f44336;
  	cursor: pointer;
  	border: 1px solid #f44336;
  	border-radius: .25em;
  	-webkit-transition: background-color 0.2s;
  	transition: background-color 0.2s;
  }
  .leaveBtn:link, .leaveBtn:visited, .leaveBtn:hover, .leaveBtn:active{
    background: #fff;
    color: #f44336;
    border: 1px solid #f44336;
  }
  #nickname, input[name=pwd]{
    display:inline; 
    width:79%; 
  }
  #profileImg:hover{
  	opacity: 0.60;
  }

  /* 결과보기 영역 */
  .resultTable{
    border: 1px solid #343d52;
    border-collapse: collapse;
  	margin: 25px 0;
  	font-size: 0.9em;
  	border-radius: 5px 5px 0 0;
  	overflow: hidden;
  	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
  }
  .resultTable th{
    background-color: #343d52;
  	color: #FFFFFF;
  	text-align: center;
  	font-weight: bold;
  }
  .resultTable thead td {
    background-color: #D9E5FF;
  }
  .resultTable tbody th{
    background: #F15F5F;
  }
  .resultTable tr{
  	text-align: center;
  	font-weight: normal;
  	border: 1px solid #DDDDDD;
  }
  .resultTable th,
  .resultTable td {
  	padding: 12px 15px;
  	border: 1px solid #DDDDDD;
  }
  .resultTable tbody tr {
  	border-bottom: 1px solid #DDDDDD;
  }
  
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
    border-bottom:2px solid #343D52; 
  }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
    
    $(function(){
    	const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#*^])[A-Za-z\d@$!%*?&#*^]{4,10}$/;
    	//정규표현식(대/소문자,숫자,특수문자 포함하여 4글자 이상)
    	var profileImg; //프로필 사진 영역
    	var password; //비밀번호 값
    	var passwordCheck; //비밀번호 확인 값
    	var pwLength; //비밀번호 길이
    	var originNickname; //원래 닉네임
		var nickname; //바꾼 닉네임
    	
    	/* 로고 영역 클릭하면 index.jsp로 이동 */
    	$('#logo').click(function(){
    		location.href = 'index.jsp';
    	});
		
    	$("#profile").on("change", handleImgFileSelect); //이미지 파일 업로드시 함수 호출
    	
    	/* 닉네임 중복 확인 */
    	$('button:eq(0)').click(function(){
    		originNickname = '${member.nickname}';
    		nickname = $('input[name=nickname]').val();
    		var nicknameCheck = $('input[type=hidden]:eq(0)');
    		if(nickname==''){
    			alert("닉네임을 입력하세요");
    		}else if(originNickname==nickname){
    			alert("기존의 닉네임을 그대로 사용합니다");
    			nicknameCheck.attr('value', 'nicknameCheck');
    		}else{
    			$.ajax({
    				//요청
    				type: "post", 
    				url: "nicknameCheck.do", 
    				data: "nickname="+nickname,
    				
    				//응답
    				success:function(data){ 
    					if(!data){
    						alert("사용 가능한 닉네임입니다");
    						nicknameCheck.attr('value', 'nicknameCheck');
    					}else{
    						alert("이미 존재하는 닉네임입니다");
    						$('input[name=nickname]').val("").focus();
    						nicknameCheck.attr('value', 'notNicknameCheck');
    					}
    				}//callback
    			});//ajax
    		}//click
    	});
    	
    	/* 비밀번호 형식 체크 */
    	$('#password').keyup(function(){
    		pwLength = $('#password').val().length;
    		pwCheckLength = $('input[name=passwordCheck]').val().length;
    		password = $('#password').val();
    		passwordCheck = $('input[name=passwordCheck]').val();
    		
    		if(pwLength<1){
    			$('#comparePW').text('비밀번호를 입력하세요');
    		}else if(pwLength<4){
    			$('#comparePW').text('4자 이상 10자 이하로 입력하세요');
    		}else if(!regex.test(password)){
    			$('#comparePW').text('대/소문자, 숫자, 특수문자를 포함하세요');
    		}else if(pwCheckLength>0 && password!=passwordCheck){
    			$('#comparePW').text('입력하신 비밀번호와 다릅니다');
    		}else{
    			$('#comparePW').text(' ');
    		}
    	});
    	
    	/* 회원탈퇴 영역으로 이동 */
    	$('#delete').click(function(){
    		var flag = confirm('탈퇴하면 모든 포인트가 소멸됩니다. 그래도 탈퇴하시겠습니까?');
    		if(!flag) return false;
    		else{
    			document.getElementById('updateArea').style.display='none';
    			document.getElementById('deleteArea').style.display='block';
    			$('#profileImg').css('display', 'none');
    		}
    	});
    	
    	/* 회원정보 수정 Ajax */
    	$('#update').click(function(){
    		var nicknameCheck = $('input[type=hidden]:eq(0)').val();
    		var id = $('input[name=id]:eq(1)').val();
    		originNickname = '${member.nickname}';
    		nickname = $('input[name=nickname]').val();
  		  	password = $('#password').val();
  		  	passwordCheck = $('input[name=passwordCheck]').val();
  		  	if(originNickname!=nickname && nicknameCheck=="notNicknameCheck"){
  				alert("닉네임 중복 확인을 해주세요");
  				return false;
  		  	}else if(password!=passwordCheck){
  				alert("입력하신 비밀번호가 다릅니다");
  				return false;
  		  	}else if(pwLength<4 || pwLength>10){
  				alert("비밀번호를 4자 이상 10자 이하로 입력하세요");
  				return false;
  		  	}else if(!regex.test(password)){
  				alert("비밀번호에 대/소문자, 숫자, 특수문자를 포함하세요");
  				return false;
  		  	}else{
  		  	 	var form = $('form:eq(0)')[0];
  			 	var formData = new FormData(form);
  		       	$.ajax({
  		       		url: 'updateMember.do',
  		       	    processData: false,
  	     	    	    contentType: false,
  		       	    data: formData,
  		       	    type: 'POST',
  		       	    success: function(data){
  		       	    	alert("회원정보가 정상적으로 수정되었습니다");
  		       	    }
  		       	});//ajax
  		  	}
    	});//click
    	
    	/* 회원탈퇴 Ajax */
    	$('#deleteArea button').click(function(){
    		var id = '${member.id}';
    		var password = $('input[name=userPwd]').val();
    		$.ajax({
    			type:'post',
				url:'deleteMember.do',
				data:"id="+id+"&password="+password,
  		       	
  		       	success: function(data){
  		       		$('#deleteResult').css('display', 'block').text(data);
  		       	}
  		    });//회원탈퇴 ajax
    	});//click
    });//JQuery Ready
    
    /* 이미지 업로드 핸들러 함수 시작 */
    function handleImgFileSelect(e) {
      var files = e.target.files;
      var filesArr = Array.prototype.slice.call(files);
        
      if($('input[type=file]').val() != ""){
        filesArr.forEach(function(f) {
        	
          /* 확장자 제한 */
          if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            $('#profile').val("");
            return false;
          }
        	
          /* 용량 제한 */
          var fileSize = document.getElementById('profile').files[0].size;
          var maxSize = 5 * 1024 * 1000;
          if(fileSize > maxSize){
            alert("파일용량 5MB을 초과했습니다.");
            $('#profile').val("");
            return false;
          }
    		
          /* 업로드 이미지 미리보기 */
          profileImg = f;
          var reader = new FileReader();
          reader.onload = function(e) {
            $("#profileImg").attr("src", e.target.result);
          }
          reader.readAsDataURL(f);
        });//forEach
      }//if
    }/* 이미지 업로드 핸들러 함수 끝 */
  </script>
</head>

<body>
  <!-- 슬라이드 메뉴바 -->
  <nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="nav">
    <div style="background-color: #343d52; height: 60px; padding-top:8px; padding-left:10px;">
      <span id="logo">
        <img src="image/logo/frontlogo.png" style="width:40px; height:40px;">
        <img src="image/logo/backlogo.png" style="width:100px; height:20px;">
      </span>
    </div>
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="navClose()">Close</a>
    <!-- 입력 -->
    <div id='menu' style="padding: 10px 20px;">
	    <a href="index.jsp"><img class="menu" src="image/menu/main.png">메인</a><br>
	    <a href="teampage.jsp"><img class="menu" src="image/menu/team.png">팀정보</a><br>
	    <a href="team.jsp"><img class="menu" src="image/menu/player.png">선수정보</a><br>
	    <a href="toto.do"><img class="menu" src="image/menu/toto.png">모의토토</a><br>
	    <a href="map.jsp"><img class="menu" src="image/menu/map.png">토토 판매점</a><br>
	</div>
	<div id="login">
		<c:choose>
			<c:when test="${member != null}">
				<a href="logout.do"><img class="menu" src="image/menu/logout.png">로그아웃</a> 
			</c:when>
			<c:otherwise>
				<a href="../login.html"><img class="menu" src="image/menu/login.png">로그인</a> 
			</c:otherwise>
		</c:choose>
	</div>
  </nav>
​
  <!-- 메뉴바 클릭 시 화면 어둡게 처리 -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="navClose()" style="cursor:pointer" id="overlay">
  </div>
​
  <!-- 상단 서치바, 유저정보(썸네일, 아이디) -->
  <div class="w3-main" style="margin-left:250px;">
    <header class="w3-container w3-top" style="background-color: #343d52; color: white; height: 60px;">
      <i class="fa fa-bars w3-button w3-hide-large w3-display-left" onclick="navOpen()"></i>
      <span class="w3-hide-large w3-right w3-animate-opacity" style="position: relative; top: 20%;">
      <c:choose>
			<c:when test="${member != null}">
				<img src="${member.image}" width="40px" height="40px" alt="memberImg">
			</c:when>
		</c:choose>
      </span>
      <span class="w3-hide-large w3-right w3-animate-opacity" style="position: relative; top: 20%;">
      	<c:choose>
			<c:when test="${member != null}">
				<span>${member.nickname} 님 &nbsp;&nbsp;&nbsp;&nbsp;</span>
				<a class="menu" href="#" onclick="document.getElementById('id01').style.display='block'">
				  내 정보
				</a>
				<span> | </span>
				<a class="menu" href="#" onclick="document.getElementById('id02').style.display='block'">
				  결과 보기
				</a>
			</c:when>
		</c:choose>
      </span>
​
      <div class="w3-hide-small w3-hide-medium w3-animate-opacity"
        style="width:100%; height: 100%; text-align: right; margin-left: -250px;">
        <span style="position: relative; top: -10px;">
          <c:choose>
			<c:when test="${member != null}">
				<img src="${member.image}" width="40px" height="40px" alt="memberImg"> 
			</c:when>
		</c:choose>
        </span>
        <span style="position: relative; top: 3px;">
          <c:choose>
			<c:when test="${member != null}">
				<span>${member.nickname} 님 &nbsp;&nbsp;&nbsp;&nbsp;</span>
				<a class="menu" href="#" onclick="document.getElementById('id01').style.display='block'">
				  내 정보
				</a>
				<span> | </span>
				<a class="menu" href="#" onclick="document.getElementById('id02').style.display='block'">
				  결과 보기
				</a>
			</c:when>
		</c:choose>
        </span>
      </div>
    </header>
​	
	<!-- contents영역 -->
	
	<!-- 내 정보 시작 -->
	<form method="post" class="w3-container" enctype="multipart/form-data">
      <div class="w3-container">
        <div id="id01" class="w3-modal">
          <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
            <div class="w3-center"><br>
              <span onclick="document.getElementById('id01').style.display='none'; location.reload()" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">
                &times;
              </span>
              <input type=file name='profile' id="profile" style='display: none;'> 
              <img src="${member.image}" style="width:200px; height:200px;" class="w3-circle w3-margin-top" id="profileImg" onclick='document.all.profile.click()'>
            </div><!-- .w3-center -->
            <!-- 업데이트 시작 -->
            <div id="updateArea" class="w3-section" style="padding:40px;">
              <label>
                <b>아이디</b>
              </label>
              <input class="w3-input w3-border w3-margin-bottom" type="text" value="${member.id}" name="id" readonly>
              <label>
                <b>닉네임</b>
              </label>
              <div>
                <input id="nickname" class="w3-input w3-border w3-margin-bottom" type="text" value="${member.nickname}" name="nickname" required>
                <input type="hidden" value="notNicknameCheck">
                <button class="w3-section w3-padding" type="button">중복 확인</button>
              </div>
              <label>
                <b>비밀번호</b>
              </label>
              <input id="password" class="w3-input w3-border w3-margin-bottom" type="password" value="${member.password}" name="password" maxlength="10" required>
              <label>
                <b>비밀번호 확인</b>
              </label>
              <input class="w3-input w3-border" type="password" value="${member.password}" name="passwordCheck" maxlength="10" required>
              <div id="comparePW" style="color:red"></div>
              <button class="w3-section w3-padding" id="update" type="button">변경</button>
              <button class="w3-section w3-padding leaveBtn" id="delete" type="button" style="float:right;">회원탈퇴</button>
            </div><!-- 업데이트 끝 .w3-section -->
            <!-- 회원탈퇴 시작 -->
            <div id="deleteArea" class="w3-section" style="padding:40px; display:none;">
              <label>
                <b>비밀번호를 입력하세요</b>
              </label>
              <div>
                <form method="post" class="w3-container">
                  <input class="w3-input w3-border w3-margin-bottom" type="password" name="userPwd" required>
                  <button class="w3-section w3-padding" type="button">확인</button>
                  <div id="deleteResult" style="color:red;"></div>
                </form>
            </div><!-- 회원탈퇴 끝 .w3-section -->
          </div><!-- .w3-modal-content -->
        </div><!-- .w3-modal -->
      </div><!-- .w3-container -->
    </form>
    <!-- 내 정보 끝 -->
  
    <!-- 결과보기 시작 -->
    <div class="w3-container">
      <div id="id02" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:800px">
          <div class="w3-center"><br>
            <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
          </div><!-- w3-center -->
          <div class="w3-section" style="padding:40px;">
            <h6 style="text-align:center;"><b>내가 맞힌 승부</b></h6>
              <table class="resultTable" style="margin: 0 auto;">
  		        <thead>
                  <p style="text-align:right;">6/12 경기</p>
    		      <tr>
    		        <th>원정 vs 홈</th>
      		        <td>팀1 vs 팀2</td>
      			    <td>팀3 vs 팀4</td>
      			    <td>팀5 vs 팀6</td>
                    <td>팀7 vs 팀8</td>
                    <td>팀9 vs 팀10</td>
    		      </tr>
  			    </thead>
  			    <tbody>
    		      <tr>
    		        <th>승리팀</th>
      		        <td style="background:#FFD8D8;">로고1</td>
      			    <td>로고2</td>
      			    <td style="background:#FFD8D8;">로고3</td>
                    <td style="background:#FFD8D8;">로고4</td>
                    <td>로고5</td>
			      </tr>
  			    </tbody>
		      </table>
              <h6 style="text-align:center; margin-top:50px;"><b>내 포인트 현황</b></h6>
              <table class="content-table" style="width: 50%; margin: 0 auto;">
  		        <thead>
    		      <tr>
      		        <th>날짜</th>
      			    <th>획득한 포인트</th>
      			    <th>누적 포인트</th>
    		      </tr>
  			    </thead>
  			    <tbody>
    		      <tr>
      		        <td>06/12</td>
      			    <td>+16p</td>
      			    <td>128p</td>
			      </tr>
                  <tr>
      		        <td>06/11</td>
      			    <td>+16p</td>
      			    <td>112p</td>
			      </tr>
  			    </tbody>
		      </table>
            </div><!-- .w3-section -->
          </div><!-- .w3-modal-content -->
        </div><!-- .w3-modal -->
      </div><!-- .w3-container -->
      <!-- 결과보기 끝 -->
</body>
</html>
