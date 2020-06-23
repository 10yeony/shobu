<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>쇼부</title>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/test.js"></script>
	<script src="js/index.js"></script>

	<link rel="stylesheet" href="css/test.css">
	<link rel="stylesheet" href="css/index.css">
</head>

<body>
	
	<!-- nav -->
	<div class="area"></div>
	<nav class="main-menu">
		<ul>
			<li><a href="http://justinfarrow.com"> <i
					class="fa fa-home fa-2x"></i> <span class="nav-text"> Home </span>
			</a></li>
			<li class="has-subnav"><a href="#"> <i
					class="fa fa-play fa-2x"></i> <span class="nav-text"> Game </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-bar-chart-o fa-2x"></i> <span
					class="nav-text"> Statistics </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-map-marker fa-2x"></i> <span
					class="nav-text"> Maps </span>
			</a></li>
		</ul>

		<ul class="logout">
			<li><a href="#"> <i class="fa fa-power-off fa-2x"></i> <span
					class="nav-text"> Logout </span>
			</a></li>
		</ul>
	</nav>
	
	<!-- main -->
	
	
		<div id="slider">
			  <a id="prev" class="arrow"></a>
			  <ul id="pages">    
			    <li>
			      <div id='game1'>
			    	<div class="away">
			    		<img src="img/team/kiwoom.png" alt="away">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp">최원태</span>
			    	</div>
			    	<div class="graph">
			    		<figure>
							  <div class="graphic">
							    <div class="row">
							      <div class="chart">
							        <span class="block" title="away">
							           <span class="value">43%</span>
							        </span>
							        <span class="block" title="home">
							           <span class="value">57%</span>
							        </span>
							      </div>
							    </div>
							  </div>
							</figure>
			    	</div>
			    	<div class="home">
			    		<img src="img/team/lg.png" alt="home">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 김윤식 </span>
			    	</div>
			      </div>
			  </li>
			  <li>
			   <div id='game2'>
			    	<div class="away">
			    		<img src="img/team/doosan.png" alt="away">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 플렉센 </span>
			    	</div>
			    	<div class="graph">
			    		<figure>
							  <div class="graphic">
							    <div class="row">
							      <div class="chart">
							        <span class="block" title="away">
							           <span class="value">72%</span>
							        </span>
							        <span class="block" title="home">
							           <span class="value">28%</span>
							        </span>
							      </div>
							    </div>
							  </div>
							</figure>
			    	</div>
			    	<div class="home">
			    		<img src="img/team/sk.png" alt="home">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 김태훈 </span>
			    	</div>
			      </div>
			  </li>
			    <li>
			      <div id='game3'>
			    	<div class="away">
			    		<img src="img/team/nc.png" alt="away">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 루친스키</span>
			    	</div>
			    	<div class="graph">
			    		<figure>
							  <div class="graphic">
							    <div class="row">
							      <div class="chart">
							        <span class="block" title="away">
							           <span class="value">62%</span>
							        </span>
							        <span class="block" title="home">
							           <span class="value">38%</span>
							        </span>
							      </div>
							    </div>
							  </div>
							</figure>
			    	</div>
			    	<div class="home">
			    		<img src="img/team/kt.png" alt="home">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 데스파이네 </span>
			    	</div>
			      </div>
			  </li>
			  <li>
			   <div id='game4'>
			    	<div class="away">
			    		<img src="img/team/kia.png" alt="away">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 브룩스</span>
			    	</div>
			    	<div class="graph">
			    		<figure>
							  <div class="graphic">
							    <div class="row">
							      <div class="chart">
							        <span class="block" title="away">
							           <span class="value">53%</span>
							        </span>
							        <span class="block" title="home">
							           <span class="value">47%</span>
							        </span>
							      </div>
							    </div>
							  </div>
							</figure>
			    	</div>
			    	<div class="home">
			    		<img src="img/team/lotte.png" alt="home">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 서준원 </span>
			    	</div>
			      </div> 
			  </li>
			  <li>
			    <div id='game5'>
			    	<div class="away">
			    		<img src="img/team/hanhwa.png" alt="away">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 채드벨 </span>
			    	</div>
			    	<div class="graph">
			    		<figure>
							  <div class="graphic">
							    <div class="row">
							      <div class="chart">
							        <span class="block" title="away">
							           <span class="value">48%</span>
							        </span>
							        <span class="block" title="home">
							           <span class="value">52%</span>
							        </span>
							      </div>
							    </div>
							  </div>
							</figure>
			    	</div>
			    	<div class="home">
			    		<img src="img/team/samsung.png" alt="home">
			    		<br>
			    		<span>선발투수</span><br>
			    		<span class="sp"> 최채흥 </span>
			    	</div>
			      </div>
			  </li>
			</ul>
			<a id="next" class="arrow"></a>
			<ul class="navigation"></ul>
			</div> 

	
	<div class="card" id='bul_history'>
		<table class="content-table">
				<thead>
    				<tr>
    					<th>Team</th>
      					<th>Number</th>
      					<th>Name</th>
      					<th>Position</th>
      					<th>State</th>
    				</tr>
  				</thead>
  				<tbody>
    				<tr>
      					<td>NC</td>
      					<td>25</td>
      					<td>양의지</td>
      					<td>포수</td>
      					<td>등록</td>
					</tr>
					<tr>
      					<td>NC</td>
      					<td>67</td>
      					<td>김진호</td>
      					<td>투수</td>
      					<td>말소</td>
					</tr>
					<tr>
      					<td>LG</td>
      					<td>50</td>
      					<td>손호영</td>
      					<td>내야수</td>
      					<td>말소</td>
					</tr>
					<tr>
      					<td>LG</td>
      					<td>55</td>
      					<td>채은성</td>
      					<td>외야수</td>
      					<td>말소</td>
					</tr>
  				</tbody>
		</table>
	</div>
	
	<div class="card" id='todayLuck'>
		<p>Architect & Engineer</p>
	</div>
	
	<!--Chatting-->
	<div id="chat-circle" class="btn btn-raised">
		<div id="chat-overlay"></div>
		<i class="fa fa-comments fa-2x chatIcon"></i>
	</div>

	<div class="chat-box">
		<div class="chat-box-header">
			ChatBot <span class="chat-box-toggle"><i class="fa fa-times"></i></span>
		</div>
		<div class="chat-box-body">
			<div class="chat-box-overlay"></div>
			<div class="chat-logs"></div>
			<!--chat-log -->
		</div>
		<div class="chat-input">
			<form>
				<input type="text" id="chat-input" placeholder="Send a message..." />
				<button type="submit" class="chat-submit" id="chat-submit">
					<i class="material-icons">send</i>
				</button>
			</form>
		</div>
	</div>
</body>

</html>