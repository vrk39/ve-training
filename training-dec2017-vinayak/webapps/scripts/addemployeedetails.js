function patternCheck(element){
	var regx="/^[A-Za_z]+$/";
		return element.value.match(regx) ? true : false;
}

function empDetailsValidation(){
	var firstName = document.querySelector(".first_name");
	var lastName =  document.querySelector(".last_name");
	var company =  document.querySelector(".company");
	var age =  document.querySelector(".age");
	var phoneno = document.querySelector(".phoneNo");
	var address  =  document.querySelector(".address");
	var zipcode =   document.querySelector(".zipcode");
	var salary =   document.querySelector(".salary");
	
	if(firstName.value =='' || patternCheck(firstName)){
		alert("first name contain only string");
		
	}else if(lastName.value==''|| patternCheck(lastName)){
		alert("last name contain only string");
	}else if(company.value ==''|| patternCheck(company)){
		alert("company name contain only string");
	}else if(age.value ==''|| parseInt(age.valuemployeeServlete) <= 0){
		alert("enter proper age");
	}else if(phoneno.value ='' || phoneno.value.length<10){
		alert("enter proper mobile no");
	}else if(address.value ='' || patternCheck(address)){
		alert("enter proper adderess");
	}else if(zipcode.value ='' || zipcode.value.length<6){
		alert("enter proper zipcode");
	}else{
		if(parseInt(salary.value)< 0){
			alert("enter salary should be greater than zero");
		}
	}
	
}

function addEmployeeWithValidation(){
	if(empDetailsValidation()){
		document.location.href ="employeeServlet";
	}
}

var addbutton =document.querySelector(".add-button");
addbutton.addEventListener("click",empDetailsValidation);