function checkAge(){
	var age = document.ageFrm.age;
	if(age.value=="") alert("값을 입력해주세요.");
	else if(isNaN(age.value)) alert("나이는 숫자로 입력 바랍니다.");
	else if(age.value>=19) alert(age.value+"는 성인이므로..입장 가능!!");
	else alert("19세 미만은 입장이 불가합니다.");
	age.value="";
	age.focus();
}