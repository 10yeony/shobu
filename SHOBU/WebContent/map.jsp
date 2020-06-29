<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>토토판매점 - 쇼부 Shobu</title>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta charset="utf-8">
  <style>
   /* Always set the map height explicitly to define the size of the div
    * element that contains the map. */
   #map {
    height: 100%;
   }
   /* Optional: Makes the sample page fill the window. */
   html, body {
    height: 100%;
    margin: 0;
    padding: 0;
   }
  </style>
 </head>
 <body>
 
 <%@ include file="header.jsp"%>
  <div id="map"></div>
  <script>
   // Note: This example requires that you consent to location sharing when
   // prompted by your browser. If you see the error "The Geolocation service
   // failed.", it means you probably did not give permission for the browser to
   // locate you.
   var map;
   function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {zoom: 15, center: {lat: 37.5665, lng: 126.9780}});
 	 // The marker, positioned at Uluru
 	 var marker;
  	 marker = new google.maps.Marker({position: {lat: 37.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 36.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 35.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 34.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 33.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 32.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 31.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 30.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 29.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 28.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 27.5665, lng: 126.9780}, map: map});
  	 marker = new google.maps.Marker({position: {lat: 26.5665, lng: 126.9780}, map: map});
 	 
 	  
    // Try HTML5 geolocation.
    if (navigator.geolocation) {
     navigator.geolocation.getCurrentPosition(function(position) {
      var pos = {
       lat: position.coords.latitude,
       lng: position.coords.longitude
      };
      map.setCenter(pos);
     }, function() {
      handleLocationError(true, infoWindow, map.getCenter());
     });
    } else {
     // Browser doesn't support Geolocation
     handleLocationError(false, infoWindow, map.getCenter());
    }
   }
   function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
               'Error: The Geolocation service failed.' :
               'Error: Your browser doesn\'t support geolocation.');
   }
  </script>
  <script async defer
  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0085qYvaQZv0nFw1TGj1lWGUdjnv16jU&callback=initMap">
  </script>
 </body>
</html>