<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load('current', {
      'packages': ['map'],
      // Note: you will need to get a mapsApiKey for your project.
      // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
      'mapsApiKey': 'AIzaSyBL2DiCnUsDFYiLygKGh3s4jiMrzPQALrI'
    });
    google.charts.setOnLoadCallback(drawMap);

    function drawMap () {
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Address');
      data.addColumn('string', 'Location');

      data.addRows([
        ['Lake Buena Vista, FL 32830, United States',                  'Walt Disney World'],
        ['6000 Universal Boulevard, Orlando, FL 32819, United States', 'Universal Studios'],
        ['7007 Sea World Drive, Orlando, FL 32821, United States',     'Seaworld Orlando' ]
      ]);

      var options = {
        mapType: 'styledMap',
        zoomLevel: 12,
        showTooltip: true,
        showInfoWindow: true,
        useMapTypeControl: true,
        maps: {
          // Your custom mapTypeId holding custom map styles.
          styledMap: {
            name: 'Styled Map', // This name will be displayed in the map type control.
            styles: [
              {featureType: 'poi.attraction',
               stylers: [{color: '#fce8b2'}]
              },
              {featureType: 'road.highway',
               stylers: [{hue: '#0277bd'}, {saturation: -50}]
              },
              {featureType: 'road.highway',
               elementType: 'labels.icon',
               stylers: [{hue: '#000'}, {saturation: 100}, {lightness: 50}]
              },
              {featureType: 'landscape',
               stylers: [{hue: '#259b24'}, {saturation: 10}, {lightness: -22}]
              }
        ]}}      };

      var map = new google.visualization.Map(document.getElementById('map_div'));

      map.draw(data, options);
    }
  </script>
    
<title>Document</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/test.js"></script>
<link rel="stylesheet" href="css/test.css">
</head>
<body>
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
	<div class="search-wrapper">
		<div class="input-holder">
			<input type="text" class="search-input" placeholder="Type to search" />
			<button class="search-icon" onclick="searchToggle(this, event);">
				<span></span>
			</button>
		</div>
		<span class="close" onclick="searchToggle(this, event);"></span>
	</div>
	<div id="map"></div>
	<table style="margin: 0 auto; padding: 150px;">
		<tr>
			<td>
				<div class="card">
					<div id="map_div" style="height: 500px; width: 900px"></div>
				</div>
			</td>
		</tr>
	</table>

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