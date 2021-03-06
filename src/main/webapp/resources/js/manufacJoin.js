//유효성 검사

function validate(){
	if($("input[id=provisionYn]:radio:checked").length == 0){
		alert("회원가입약관에 동의를 체크해 주세요.");
		return false;
	}
	
	var mem = document.getElementById("memberInfoYn");
	if($("input[id=memberInfoYn]:radio:checked").length == 0){
		alert("개인정보 동의를 체크해 주세요.");
		return false;
	}
	
	var id = document.getElementById("cuId");
	if(id.value == ""){
		alert("아이디를 입력하세요.");
		return false;
	}
	
	var hid = document.getElementById("che").value;
	if(hid != 1){
		alert("아이디 중복검사를 해주세요");
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
		console.log("적용");
		return false;
	}
	//
	var manufacName = document.getElementById("manufacName").value;
	if(manufacName == ""){
	 	alert("제조사이름을 입력하세요.");
	 	return false;
	}
	
	var add1 = document.getElementById("addr1").value;	
	if(add1 == ""){
		alert("주소를 검색하세요.");
		return false;
	}
	var add2 = document.getElementById("addr2").value;
	if(add2 == ""){
		alert("상세주소를 입력하세요.");
		return false;
	}
	
	var officer = document.getElementById("officer");
	if(officer.value == ""){
	 alert("담당자명을 입력하세요.");
	 return false;
	}
	
	var regExp = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	var result = $("#phone").val();
	
	if(!regExp.test(result)){
		alert("잘못된 휴대폰 번호입니다.");
		return false;
	}
	
}

//카카오지도 API
var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

      function sample5_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    var addr = data.address; // 최종 주소 변수
					console.log(addr);
                    // 주소 정보를 해당 필드에 넣는다.
                    document.getElementById("addr1").value = addr;
					document.getElementById("postCode").value = data.zonecode;
                }
            }).open();
        }

	//아이디 중복검사
	function overlap(){
	var cuId = document.getElementById("cuId").value;
	if(cuId == ""){
		alert("아이디를 입력하세요.");
		return false;
	}
	if(cuId.search(/\s/) != -1){
  		alert("공백 없이 입력해주세요.");
  		return false;
 	}
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	if(special_pattern.test(cuId) == true) {
		alert("특수문자 없이 입력해주세요.");
		return false; 
	}

	$.ajax({
    type: "POST",
    async: "true",
	url: "../member/overlapId.do",
	dataType: "json",
	data: {param:cuId},
	success: function(json){
		if(json[0]==null){
			alert("사용가능한 아이디 입니다.");
			document.getElementById("che").value = 1;
		}else{
		alert("이미 사용중인 아이디 입니다.");
		    document.getElementById("che").value = 0;
		}
			},
    error: function(jqXHR, textStatus, errorThrown){
	alert("오류가 발생하였습니다.");
			}
    	});
	}