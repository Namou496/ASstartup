//유효성 검사
var manufacName;
function validate(){
	var mem = document.getElementById("memberInfoYn");

	if($("input[id=memberInfoYn]:radio:checked").length == 0){
		alert("개인정보 동의를 체크해 주세요.");
		return false;
	};
	
	var mname = document.getElementById("productName");
	if(mname.value==""){
		alert("제품을 선택하세요.")
		return false;
	}
	
	var regExp = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	var result = $("#phone").val();
	
	if(!regExp.test(result)){
		alert("잘못된 휴대폰 번호입니다.");
		$("#phone").focus();
		return false;
	};
	
	var add1 = document.getElementById("addr1");	
	if(add1.value == ""){
		alert("주소를 검색하세요.");
		return false;
	}
	var add2 = document.getElementById("addr2");
	if(add2.value == ""){
		alert("상세주소를 입력하세요.");
		return false;
	}
	
	var mee = document.getElementById("meetDate");
	if(mee.value==""){
		alert("날짜를 선택하세요.");
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

                    // 주소 정보를 해당 필드에 넣는다.
                    document.getElementById("addr1").value = addr;
					document.getElementById("postCode").value = data.zonecode;
                }
            }).open();
        }

//전화번호 하이픈 자동입력

//var autoHypenPhone = function(str){
//      str = str.replace(/[^0-9]/g, '');
//      var tmp = '';
//      if( str.length < 4){
//          return str;
//      }else if(str.length < 7){
//          tmp += str.substr(0, 3);
//          tmp += '-';
//          tmp += str.substr(3);
//          return tmp;
//      }else if(str.length < 11){
//          tmp += str.substr(0, 3);
//          tmp += '-';
//          tmp += str.substr(3, 3);
//          tmp += '-';
//          tmp += str.substr(6);
//          return tmp;
//      }else{              
//          tmp += str.substr(0, 3);
//          tmp += '-';
//          tmp += str.substr(3, 4);
//          tmp += '-';
//          tmp += str.substr(7);
//          return tmp;
//      }
//  
//      return str;
//}
//
//var phoneNum = document.getElementById('phone');
//
//phoneNum.onkeyup = function(){
//  console.log(this.value);
//  this.value = autoHypenPhone( this.value ) ;  
//}



/* 검색필터 => 제조사이름 리스트 --> 제품그룹 */
function manufacSelectName(manufacName){
	$.ajax({
    type: "POST",
    async: "true",
	url: "../Product/selectManufacturer.do",
	dataType: "json",
	data: {param:manufacName},
	success: function(result){
				$("#productGroup").find("option").remove().end().append("<option value=''>제품 분류</option>");
				$.each(result, function(i){
					$("#productGroup").append("<option value='" + result[i] + "'>" + result[i] + "</option>");
				});
			},
    error: function(jqXHR, textStatus, errorThrown){
	alert("오류가 발생하였습니다.");
			}
    	});
	}
/* 제품명 */
$(function(){
	$('#manufacName').on("change", function(){
		manufacName = $("#manufacName option:selected").val();
			console.log(manufacName);

	});
});
	function manufacSelectGroup(productGroup, manufacName){
	var manufacName = $("#manufacName option:selected").val();
	console.log(manufacName);
	console.log(productGroup);
	$.ajax({
    type: "POST",
    async: "true",
	url: "../ASForm/selectProductName.do",
	dataType: "json",
	data: {param1:productGroup, param2:manufacName},
	success: function(result){
				$("#productName").find("option").remove().end().append("<option value=''>제품명</option>");
				$.each(result, function(i){
					$("#productName").append("<option value='" + result[i] + "'>" + result[i] + "</option>");
				});
			},
    error: function(jqXHR, textStatus, errorThrown){
	alert("오류가 발생하였습니다.");
			}
    	});
	}