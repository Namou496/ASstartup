var selectContent="";
var partNoJson;

function totalCost(){
	var allCost=0;
	$(".cost").each(function(){
		allCost+=Number($(this).val());
	});
	
	$(".totalCost").val(allCost);
	
}

function widthAction(winX){
	if(winX<=685){
		$('#serviseCalendar').css({width:'100%'});
		$('.headFont').css({fontSize:'22px',textAlign: "center"});
		$('#costBox>div').css({width:'100%'});
		$('#submit').css({width:'40%'});
	}else{
		$('#serviseCalendar').removeAttr('style');
		$('.headFont').removeAttr('style');
		$('#costBox>div').removeAttr('style');
		$('#submit').removeAttr('style');
	}
}
    	
function partList(productNum){
	$.ajax({
		type : "post",
		async : "true",
		url : contextPath+"/ASBefore/repearPartList.do",
		dataType : "json",
		data : {
			productNo : productNum
		},
		success : function(prdcutJson) {
			var costJson = prdcutJson[0];
			partNoJson = prdcutJson[1];
			var startKey= Object.keys(costJson)[0];
			selectContent=
				'<li>\n'+
                	'<ul>\n'+
            			  '<li class="clearLi">\n'+
                		  		'<select class="form-select partSelect">\n';
			
			for(var key in costJson){
				selectContent+="<option value='"+costJson[key]+"'>"+key+"</option>\n";
			}
			selectContent +=
								'</select>\n'+
                			'</li>\n'+
                			'<li class="input-group mb-3">\n'+
                				'<input type="text" class="amount form-control button-addon2" placeholder="수량입력" aria-describedby="button-addon2">\n'+
                				'<input type="hidden" class="partNo" value="'+partNoJson[startKey]+'">'+
                			'</li>\n'+
		                    '<li class="input-group mb-3">\n'+
								'<input type="text" class="form-control price cost button-addon2" placeholder="0" aria-describedby="button-addon2" readonly>\n'+
								'<button class="btn btn-outline-secondary deleteBtn">\n'+
									'삭제\n'+
								'</button>\n'+
							'</li>\n'+
                		'</ul>\n'+
                '</li>';
			
		},
		error : function(request, status, error) {
			alert("로그인 오류입니다. 다시확인후 시도해주세요");
			location.href=contextPath+"/main/main.do";
		}
		
	});
	
	
}


$(function() {
	/*처리중, 처리완료일 경우 tage제어*/
	if(sta==2){
		partList(productNum);
	}else{
		$(".amount").each(function(){
			var amount = $(this).val();
			var cost = $(this).parent().parent().find(".partSelect").val();
			var price=$(this).parent().parent().find(".price");
			
			price.val(cost*amount);
		});
		totalCost();
	}
	
	var winX=$(window).width();
	
	widthAction(winX);
	
	$(window).resize(function() {
		winX=$(this).width();
		widthAction(winX);
	});
	
	$("#appendPartButton").click(function(){
		$(".partListContants").append(selectContent);
		
		$(".amount").on("propertychange change keyup paste", function() {
			
			var cost=$(this).parent().parent().find(".partSelect").val();
    		var amount=$(this).val();
    		var price=$(this).parent().parent().find(".price");
			
			var value=$(this).val();
    		
    		var Pattern=/(^0|[a-z]|[~!@\#$%<>^&*\()\-=+_\’/]|[ㄱ-ㅎ|ㅏ-ㅣ|가-힣])/g;
    		
    		if(Pattern.test(value)){
    			alert('부품 수량의 첫번째 자리가 0이거나 문자가 입력되었습니다.');
                $(this).val('');
                price.val(0);
                totalCost();
                return false;
            }
            if(Pattern.test(value)){
            	alert('부품 수량의 첫번째 자리가 0이거나 문자가 입력되었습니다.');
                $(this).val('');
                price.val(0);
                totalCost();
                return false;
            }
			
    		if(amount != null && amount.length!=0){
    			price.val(cost*amount);
    		}else{
    			price.val(cost*0);
    		}
    		totalCost();
    	});
		
		$(".partSelect").change(function(){
			$(this).parent().parent().find(".price").val(0);
			$(this).parent().parent().find(".amount").val(0);
			
			var key=$(this).find("option:selected").text();
			$(this).parent().parent().find(".partNo").val(partNoJson[key]); 

			totalCost();
			
		});
    	
    	$(".deleteBtn").click(function(){
    		$(this).parent().parent().parent().remove();
    		totalCost();
    	});
    	
	});
	
	
	$(".manPrice").on("propertychange change keyup paste", function() {/*정규식 유효성 검사 구현해야됨*/
		var value=$(this).val();
		
		var Pattern=/(^0|[a-z]|[~!@\#$%<>^&*\()\-=+_\’/]|[ㄱ-ㅎ|ㅏ-ㅣ|가-힣])/g;
		
		if(Pattern.test(value)){
			alert('인건비의 첫번째 자리가 0이거나 문자가 입력되었습니다.');
            $(this).val('');
            totalCost();
            return false;
        }
        if(Pattern.test(value)){
        	alert('인건비의 첫번째 자리가 0이거나 문자가 입력되었습니다.');
            $(this).val('');
            totalCost();
            return false;
        }
		totalCost();
	});
	
	$("#submit").click(function(){
		var sw=true;
		var jsonSw=true;
		var costSw=true;
		
		var partNoArray= new Array();
		var amountArray= new Array();
		var totalArray= new Array;
		
		$(".partNo").each(function(){
			partNoArray.push($(this).val());
		});
		
		$(".amount").each(function(){
			amountArray.push(Number($(this).val()));
		});
		
		for(var i=0; i<$(".partNo").length; i++){
			var data = new Object();
			
			if(amountArray[i]>0){
				data.partNo=partNoArray[i];
				data.amount=amountArray[i];
				totalArray.push(data);
			}else{
				jsonSw=false;
			}
		}
		if(jsonSw){
    		if(!totalArray.length>0){
    			var jsonData = "NotPart";
    		}else{
    			var jsonData = JSON.stringify(totalArray);
    		}
    		
    		var inputContent="<input type='hidden' id='partList' value='' name='partList'>";
    		
    		$("#addForm").append(inputContent);
    		
    		$("#partList").val(jsonData);
		}else{
			sw=false;
		}
		
		var manPrice = $('.manPrice').val();
		
		if(manPrice==null||manPrice.length<=0){
			costSw=false;
		}
		
		if(!sw){
			alert("수량이 없는 부품이 있습니다.");
		}
		if(!costSw){
			alert("인건비를 입력해주세요");
		}
		
		if(sw&&costSw){
			$("#addForm").submit();
		}
	});

});