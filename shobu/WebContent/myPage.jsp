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
 	  <div id="id01" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
          <div class="w3-center"><br>
            <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
            <img src="img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
          </div>
          <form class="w3-container" action="/action_page.php">
            <div class="w3-section">
              <label><b>아이디</b></label>
              <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="id" readonly>
              <label><b>닉네임</b></label>
              <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="nickname" required>
              <label><b>비밀번호</b></label>
              <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="Enter Password" name="password" required>
              <label><b>비밀번호 확인</b></label>
              <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="passwordCheck" required>
              <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">변경</button>
            </div>
          </form>
          <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">취소</button>
          </div>
        </div><!-- .w3-modal-content -->
      </div><!-- .w3-modal -->
       <div class="w3-col m6" style="margin-top: -15px;">
         <div class="card w3-card" style="height: 200px;">
           <p>모의 토토 결과</p>
           <p>06/12 +40p</p>
           <p>06/11 +40p</p>
         </div>
       </div>
        </div>
            <div class="card w3-card" style="width: 100%;">
                <p>내가 쓴글</p>
                <p>06/12 가가가가가가가가가가 가가가가가가</p>
            </div>
 	</section>
	<!-- <section>
      <div class="card w3-card w3-container w3-padding-24">
            <form>
                <img src="image/profile/default.png" alt="" width="100px" height="100px">
                <button class="w3-button w3-white w3-border w3-border-white w3-round-large">Button</button>
                <br>
                <label class="w3-text-blue"><b>닉네임</b></label>
                <input class="w3-input w3-border" type="text">
                <label class="w3-text-blue"><b>비밀번호</b></label>
                <input class="w3-input w3-border" type="password">
                <label class="w3-text-blue"><b>비밀번호 확인</b></label>
                <input class="w3-input w3-border" type="password">
                <br>
                <input class="w3-input" type="submit" value="변경">
            </form>
        </div>
     </section> -->
</body>
</html>
