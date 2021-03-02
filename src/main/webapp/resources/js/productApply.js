function addinput(result){
        if(result=='기타'){
           var html = '<input type="text" name="productGroup" id="input_added">';
           $('#productGroup #td2').append(html);
           $('#productGroup #td2 select').removeAttr('name');
        }else{
           $('#input_added').remove();
           $('#productGroup #td2 select').attr('name', 'productGroup');
        };
     }

	function addCompo(){
        var a = $('.c1').val();
        var b = $('.c2').val();
        var c = $('.c3').val();
        var b1 = $('.c3').val();

	        if(b=='분류'){
	           alert('부품분류를 선택해주세요.');
	        } else if(c==''){
	           alert('부품이름을 입력하세요.');
	        } else{
	        	if(b1.search(/\s/) != -1){
			  		alert("공백 없이 입력해주세요.");
			  		$('.c2').val('분류');
			  		$('.c3').val('');
			  		return false;
	  			}
	        var html = '';
	            html += '<tr>';
	            html += '<td id="td1" scope="row">'+a+'</td>';
	            html += '<td id="td2" scope="row">';
	            html += '<select name="componentPart" style="" readonly>';
	            html += '<input type="hidden" name="componentPart" value='+b+'>';
	            html += '<option>'+b+'</option>';
	            html += '</select>';
	            html += '<textarea name="componentName" id="componentName" style="resize: none" value='+c+' disabled>'+c+'</textarea>';
	             html += '<input type="hidden" name="componentName" value='+ c +'>';
	            html += '</td>'+'</tr>';
	        $("#component").append(html);
	        
	        
	        $('.c1').val('');
	        $('.c2').val('분류');
	        $('.c3').val('');
	        }
	};

    function deleteCompo(){
      $("#component tr:last").remove();
    };
    
	
    function manual(input){
    	var _useManual = $("#Manual1").val().split("\\");
    	var _asManual = $("#Manual2").val().split("\\");
		var useManual = _useManual[_useManual.length-1];
		var asManual = _asManual[_asManual.length-1];
		
    	
		var file = input.files;

    	
		
			if(useManual.length > 0){
				var checkJpg = useManual.substring(useManual.lastIndexOf(".")+1,useManual.length);
				 var checkPng = useManual.substring(useManual.lastIndexOf(".")+1,useManual.length);
				 var checkGif = useManual.substring(useManual.lastIndexOf(".")+1,useManual.length);
				 if(checkJpg == 'jpg' || checkPng == 'png' || checkGif == 'gif'){
									  alert(".jpg, .png, .gif 파일은 업로드 할 수 없습니다.");
									  document.getElementById('Manual1').value="";
				 }else {
						if(file[0].size > 1024 * 1024 * 10){
							// 용량 초과시 경고후 해당 파일의 용량도 보여줌
							alert('10MB이상의 제품매뉴얼은 등록할 수 없습니다.\n\n' + '현재파일 용량 : ' + (Math.round(file[0].size / 1024 / 1024 * 100) / 100) + 'MB');
							document.getElementById('Manual1').value="";
						}
				 }
			 }
			
			if(asManual.length > 0){
				 var checkJpg = asManual.substring(asManual.lastIndexOf(".")+1,asManual.length).search(".jpg");
				 var checkPng = asManual.substring(asManual.lastIndexOf(".")+1,asManual.length).search(".png");
				 var checkGif = asManual.substring(asManual.lastIndexOf(".")+1,asManual.length).search(".gif");
					 if(checkJpg == 'jpg' || checkPng == 'png' || checkGif == 'gif'){
						  alert(".jpg, .png, .gif 파일은 업로드 할 수 없습니다.");
						  document.getElementById('Manual2').value="";
					}else {
							if(file[0].size > 1024 * 1024 * 10){
								// 용량 초과시 경고후 해당 파일의 용량도 보여줌
								alert('10MB이상의 제품매뉴얼은 등록할 수 없습니다.\n\n' + '현재파일 용량 : ' + (Math.round(file[0].size / 1024 / 1024 * 100) / 100) + 'MB');
								document.getElementById('Manual2').value="";
							}
					}
			 }
		}
	function readURL(input){

		var file = input.files;
		// file[0].size 는 파일 용량 정보입니다.
		if(file[0].size > 1024 * 1024 * 2){
			// 용량 초과시 경고후 해당 파일의 용량도 보여줌
			alert('2MB 이하 제품 이미지만 등록할 수 있습니다.\n\n' + '현재파일 용량 : ' + (Math.round(file[0].size / 1024 / 1024 * 100) / 100) + 'MB');
		}
		
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
			$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	};

	function validate(){
		var productName = $('#productName').val();
		if(productName==''){
			alert('제품명을 입력해주세요.');
			return false;
		}
		var productGroup = $('#productGroup1').val();
		var guitar = $('#input_added').val();
		console.log('productGroup1' + productGroup);
		if(productGroup=='분류'){
			alert('제품분류를 입력해주세요.');
			return false;
		}
		if(guitar==""){
			alert('제품분류를 입력해주세요.');
			return false;
		}
		
		var useManual = $('#Manual1').val();
		console.log('useManual' + useManual);
		if(useManual==''){
			alert('사용매뉴얼을 넣어주세요.');
			return false;
		}
		
		var asManual = $('#Manual2').val();
		console.log('asManual' + asManual);
		if(asManual==''){
			alert('AS매뉴얼을 넣어주세요.');
			return false;
		}
		
		var manufacName = $('#productImage').val();
		console.log('productImage' + productImage);
		if(manufacName==''){
			alert('제품사진을 넣어주세요.');
			return false;
		}
		
		var manufacName = $('#productImage').val();
		console.log('productImage' + productImage);
		if(manufacName==''){
			alert('제품사진을 넣어주세요.');
			return false;
		}
		
		var componentName = $('#componentName').val();
		console.log('componentName' + componentName);
		if(componentName==null){
			alert('부품명을 입력해주세요.');
			return false;
		}
		
	}