<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://d3js.org/d3.v3.min.js" charset="utf-8"></script>
  
  <script src="https://www.amcharts.com/lib/4/core.js"></script>
  <script src="https://www.amcharts.com/lib/4/charts.js"></script>
  <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
  
  <link rel="stylesheet" href="css/teampage.css">
  <script src="js/teampage.js"></script>
</head>

<body>
  	
  	<%@ include file="header.jsp"%>

    <section>
      <!-- 상단 여백 처리-->
      <div style="padding-top: 60px;"></div>

      <!-- 카드 클래스안에 데이터만 입력 원하는 비율 선택-->
      
    <!-- 팀목록 버튼 -->  
<div class="select" tabindex="1">
  <input class="selectopt" name="test" type="radio" id="opt1" checked>
  <label for="opt1" class="option">두산베어스</label>
  <input class="selectopt" name="test" type="radio" id="opt2">
  <label for="opt2" class="option">기아타이거즈</label>
  <input class="selectopt" name="test" type="radio" id="opt3">
  <label for="opt3" class="option">NC다이노스</label>
  <input class="selectopt" name="test" type="radio" id="opt4">
  <label for="opt4" class="option">KT</label>
  <input class="selectopt" name="test" type="radio" id="opt5">
  <label for="opt5" class="option">LG</label>
  <input class="selectopt" name="test" type="radio" id="opt5">
  <label for="opt5" class="option">SK</label>
  <input class="selectopt" name="test" type="radio" id="opt5">
  <label for="opt5" class="option">롯데</label>
  <input class="selectopt" name="test" type="radio" id="opt5">
  <label for="opt5" class="option">키움</label>
  <input class="selectopt" name="test" type="radio" id="opt5">
  <label for="opt5" class="option">삼성</label>
</div>      
      
      
      
      
      
	<!--팀 로고, 팀네 -->
 	<div class="w3-row">
        <div class="w3-third w3-panel w3-padding-16">
          <div >
          	<img alt="" src="./img/team/doosan.png" class="teamLogo" >
          	<span class="teamName">두산베어스</span>
          </div>
        </div>
        <div class="w3-twothird w3-panel w3-padding-16">
          <div class="w3-card">
          
   <div class="chart-container">
    <ul class="horizontal-bar-chart">
      <li>
        <span class="index" style="width: 70%">70%</span>
      </li>
        <p>방어율</p>
      <li>
        <span class="index" style="width: 35%">35%</span>
      </li>
      <p>팀승률</p>
      <li>
        <span class="index" style="width: 20%">20%</span>
      </li>
      <p>기여도</p>
      
      <li>
        <span class="index" style="width: 10%">10%</span>
      </li>
      <p>승부</p>
    </ul>
  </div>
          	          	
          </div>
        </div>
        
<!-- 방사형 정보 -->
<script>
am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

/* Create chart instance */
var chart = am4core.create("chartdiv", am4charts.RadarChart);

/* Add data *//* 선수데이터 삽입하는  */
chart.data = [{
  "country": "방어율",
  "litres": 10
}, {
  "country": "타자율",
  "litres": 9
}, {
  "country": "승률",
  "litres": 2
}, {
  "country": "기여도",
  "litres": 3
}];

/* Create axes */
var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "country";

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.renderer.axisFills.template.fill = chart.colors.getIndex(2);
valueAxis.renderer.axisFills.template.fillOpacity = 0.05;

/* Create and configure series */
var series = chart.series.push(new am4charts.RadarSeries());
series.dataFields.valueY = "litres";
series.dataFields.categoryX = "country";
series.name = "Sales";
series.strokeWidth = 3;

}); // end am4core.ready()
</script>

 <!-- 방사형 정보 막 -->
        
</div>     
      

      
<!-- 선발 정보 -->
      <div class="w3-row">
        <div class="w3-third w3-panel w3-padding-16">
          <div class="w3-card">
          <div class="w3-container">
       <h2>선수정보</h2>
    </div>
          	<img alt="" src="./img/player/doosan/1.jpg" >	
          	<span class="teamName">유희관</span>
          	<div id="chartdiv" style="width:100%; height: 300px;"></div>
          </div>
        </div>
        <div class="w3-twothird w3-panel w3-padding-16">
          <div class="w3-card">
          	<div class="w3-container">
  <h2>선수단</h2>
  <div>
<!--   	<form class="positionBtn">
	<div class="switch-field">
		<input type="radio" id="radio-one" name="switch-one" value="yes" checked/>
		<label for="radio-one">투수</label>
		<input type="radio" id="radio-two" name="switch-one" value="no" />
		<label for="radio-two">타자</label>
	</div>
	</form> -->
  </div>
  <table class="w3-table-all w3-hoverable">
    <thead>
      <tr class="w3-light-grey">
        <th>등번</th>
        <th>프로필</th>
        <th>선수명</th>
        <th>포지션</th>        
        <th>타율</th>
      </tr>
    </thead>
    <!-- 반복문 돌려서 출력 -->
    <tr>
      <td>1</td>
      <td><img alt="" src="./img/player/doosan/1.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
    <tr>
      <td>2</td>
      <td><img alt="" src="./img/player/doosan/50.jpg"> </td>
      <td>유희관</td>
      <td>투수</td>
      <td>50</td>
    </tr>
  </table>
</div>
          
          </div>
        </div>
      </div>
      
<!--채팅 부분 -->      
 
 
<!-- 채팅 부분 -->
   
      
      
    </section>
  </div> <!-- 없으면 nav영역 어긋남 -->

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
</body>

</html>