$(function() {
	var string;
	$.ajax({
		type:'post',
		url:'/main.do',
		dataType:'json',
		
		success:function(r){
			console.log("Main.jsp get Json");
			console.log(r.matchs.length);
			if (r.matchs.length == 0) {
				$(".carousel-indicators").append('<li data-target="#myCarousel" data-slide-to=0></li>');
				$(".carousel-inner").append('<div class="item active"> <table class="game"><tr><th>오늘은 경기가 없습니다.</th></tr></table></div>');
			}
			
			else{
				$.each(r.matchs,function(idx,match){
					
					//build indicator
					if(idx==0){
						$(".carousel-indicators").prepend('<li data-target="#myCarousel" data-slide-to="'+idx+'" class="active"></li>');
					}else{
						$(".carousel-indicators").prepend('<li data-target="#myCarousel" data-slide-to="'+idx+'"></li>');
					}
					
					//input carousel-inner
					//변경시 String만 수정
					string = '<table class="game">'+
								 	'<tr>'+
								 		'<td class="away"><img class="teamlogo" src="'+match.awayImg+'"></td>'+
								 		'<td class="graph">'+
								 			'<section class="bar-graph bar-graph-horizontal bar-graph-one">'+
								 				'<div class="bar-away">'+
								 					'<div class="bar" data-percentage='+(match.awayRatio).toFixed(2)+'% style="width:'+match.awayRatio+'%;background-color:'
								 					+match.awayColor+'"></div>'+
								 				'</div>'+
								 				'<div class="bar-home">'+
								 					'<div class="bar" data-percentage='+(match.homeRatio).toFixed(2)+'% style="width:'+match.homeRatio+'%;background-color:'
								 					+match.homeColor+'"></div>'+
								 				'</div>'+
								 			'</section> </td>'+
								 		'<td class="home"><img class="teamlogo" src='+match.homeImg+'></td>'+
								 	'</tr>'+
								 	'<tr class ="bold">'+
								 		'<td>'+match.awayPitcher+'</td> <td>'+match.place+'<br>'+match.time+'</td> <td>'+match.homePitcher+'</td>'+
								 	'</tr>'+
								 	'<tr><td colspan="3"><br></td></tr>'+
								 	'<tr>'+
								 		'<td class="infoLab">'+match.awayPitcherGames+'</td> <td class="lab">경기</td> <td class="infoLab">'+match.homePitcherGames+'</td>'+
								 	'</tr>'+
								 	'<tr>'+
							 			'<td class="infoLab">'+match.awayWinLose+'</td> <td class="lab">승패</td> <td class="infoLab">'+match.homeWinLose+'</td>'+
							 		'</tr>'+
							 		'<tr>'+
							 			'<td class="infoLab">'+match.awayInning+'</td> <td class="lab">이닝</td> <td class="infoLab">'+match.homeInning+'</td>'+
							 		'</tr>'+
							 		'<tr>'+
							 			'<td class="infoLab">'+match.awayERA+'</td> <td class="lab">ERA</td> <td class="infoLab">'+match.homeERA+'</td>'+
							 		'</tr>'+
								 '</table>'+
								'</div>';
				
					if(idx==0) $(".carousel-inner").prepend('<div class="item active">'+string+'</div>');
					else $(".carousel-inner").prepend('<div class="item">'+string+'</div>');
					
					
				});//~Match each
			}
			
			$.each(r.teams,function(index,teams){
				$("#teamrank").append("<tr>");
				$("#teamrank").append("<td>"+teams.ranking+"</td>");
				$("#teamrank").append("<td>"+teams.teamName+"</td>");
				$("#teamrank").append("<td>"+teams.win+"</td>");
				$("#teamrank").append("<td>"+teams.draw+"</td>");
				$("#teamrank").append("<td>"+teams.lose+"</td>");
				$("#teamrank").append("<td>"+(teams.rate).toFixed(3)+"</td>");
				$("#teamrank").append("<td>"+(teams.distance).toFixed(1)+"</td>");
				$("#teamrank").append("<td>"+(teams.teamAVG).toFixed(3)+"</td>");
				$("#teamrank").append("<td>"+(teams.teamEra).toFixed(2)+"</td>");
				$("#teamrank").append("<td>"+teams.stream+"</td>");
				$("#teamrank").append("<td>"+teams.games10+"</td>");
				$("#teamrank").append("</tr>");
			});//~Team each
			
		},//~callback
		
	});//~ajax
})//~reday