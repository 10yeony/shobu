$(function() {
	$.ajax({
		type:'post',
		url:'/main.do',
		dataType:'json',
		
		success:function(r){
			console.log("Main.jsp get Json");
			console.log("data.teams:"+r.teams);
			$("#teamrank").html(r.teams);
		}//~callback
		
	});//~ajax
})//~reday