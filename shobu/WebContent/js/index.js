$(function() {
	$.ajax({
		type:'post',
		url:'/main.do',
		dataType:'json',
		
		success:function(r){
			console.log("Main.jsp get Json");
			
			$.each(r.matchs,function(idx,match){
				
				//build indicator
				if(idx==0){
					$(".carousel-indicators").append('<li data-target="#myCarousel" data-slide-to="'+idx+'" class="active"></li>');
				}else{
					$(".carousel-indicators").append('<li data-target="#myCarousel" data-slide-to="'+idx+'"></li>');
				}
				
				//input carousel-inner
				if(idx==0){
					$(".carousel-inner").append('<div class="item active">');
				}else{
					$(".carousel-inner").append('<div class="item">');
				}
			});//~Match each
			
			$.each(r.teams,function(index,teams){
				$("#teamrank").append("<tr>");
				$("#teamrank").append("<td>"+teams.ranking+"</td>");
				$("#teamrank").append("<td>"+teams.teamName+"</td>");
				$("#teamrank").append("<td>"+teams.win+"</td>");
				$("#teamrank").append("<td>"+teams.draw+"</td>");
				$("#teamrank").append("<td>"+teams.lose+"</td>");
				$("#teamrank").append("<td>"+teams.rate+"</td>");
				$("#teamrank").append("<td>"+teams.distance+"</td>");
				$("#teamrank").append("<td>"+teams.teamAVG+"</td>");
				$("#teamrank").append("<td>"+teams.teamEra+"</td>");
				$("#teamrank").append("<td>"+teams.stream+"</td>");
				$("#teamrank").append("<td>"+teams.games10+"</td>");
				$("#teamrank").append("</tr>");
			});//~Team each
			
		}//~callback
		
	});//~ajax
})//~reday