//유효성 검사

function validate(){
	var id = document.getElementById("cuId");
	if(id.value == ""){
		alert("아이디를 입력하세요.");
		return false;
	}
	
	var pw = document.getElementById("pw").value;
	if(pw == ""){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	var num = pw.search(/[0-9]/g);
	var eng = pw.search(/[a-z]/ig);

 	if(pw.length < 8 || pw.length > 16){
  		alert("비밀번호는 8자리 ~ 16자리 이내로 입력해주세요.");
  		return false;
 	}
    if(pw.search(/\s/) != -1){
  		alert("비밀번호는 공백 없이 입력해주세요.");
  		return false;
 	}
    if(num<0 || eng<0){
        alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다.");
		return false;
    }

	var pw_re = document.getElementById("pw_re").value;
	if(pw != pw_re){
		alert("두 비밀번호가 맞지 않습니다. 다시한번 확인하세요");
		return false;
	}
}