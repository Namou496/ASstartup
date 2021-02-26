<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="productNo"  value="${product.productNo}" />
        <c:set var="productGroup"  value="${pageMap.GroupList}" />
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록</title>

	<script type="text/javascript">
	
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
        console.log(c);
        if(b=='분류'){
           alert('부품분류를 선택해주세요.');
        } else if(c==''){
           alert('부품이름을 입력하세요.');
        } else{
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

	
	</script>
<style>
    #td1{width: 50%; text-align: right;padding-right: 30px;}
    #td2{width: 50%;text-align: left; padding-left: 30px;}
    #preview{max-width: 50%; max-height: 50%;}
    	a{text-decoration: none; color:black;}
    textarea{height: 21px;positon:relative;vertical-align: top;}
    
    @media only screen and (max-width: 992px){
    	#td1{padding-right: 10px;}
    	#td2{padding-left: 0px;}
    }
</style>
</head>
<body>

 <div class="container">
 	<form id="frmProductApply" method="post" action="${contextPath }/Product/applyProduct.do"  onsubmit="return validate();" enctype="multipart/form-data">
        <table class="table">
            <tbody>
                
                
                <tr>
                    <td id="td1" scope="row" colspan="1">제품명:</td>
                    <td id="td2" scope="row" colspan="1"><input type="text" name="productName" id="productName"></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">제조사:</td>
                    <td id="td2" scope="row" >
						<span name="manufacName" id="manufacName">${pageMap.manufacName}</span>
                    </td>
                </tr>
                <tr id="productGroup"> 
                    <td id="td1" scope="row">분류:</td>
                    <td id="td2" scope="row">
                        <select name="productGroup" id="productGroup1"  onchange="addinput(this.value);">
                            <option>분류</option>
							<c:forEach var="productGroup" items="${productGroup }">
							<option value="${productGroup }">${productGroup }</option>
							</c:forEach>
							<option value="기타">기타</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">사용매뉴얼:</td>
                    <td id="td2" scope="row"><input type="file" name="useManual" id="Manual1" onchange="manual(this);"></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">AS매뉴얼:</td>
                    <td id="td2" scope="row"><input type="file" name="asManual" id="Manual2" onchange="manual(this);"></td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">이미지:</td>
                    <td id="td2" scope="row">
                    <img id="preview" src="#">
                    <input type="file" name="productImage" id="productImage" accept="image/gif, image/jpeg, image/png" onchange="readURL(this);"/>
                    </td>
                </tr>
                <tbody id="component">
	                <tr> 
	                    <td id="td1" scope="row" class="c1">부품:</td>
	                    <td id="td2" scope="row">                        
		                    <select class="c2">
		                            <option>분류</option>
		                            <option>부품</option>
		                            <option>소모품</option>
		                    </select>
		                    <textarea class="c3" style="resize: none"></textarea>
		                    <input type="button" onclick="addCompo()" value="+">
	                        <input type="button" onclick="deleteCompo()" value="-">
	                   </td>
	                </tr>
                </tbody>
                <tr style="text-align: center">
                   <td style="width: 100%" colspan=2>
                   	<input type="submit" value="승인요청">
                   <button><a href="${contextPath }/Product/listProduct.do?pageNum=${pageMap.pageNum}&section=${pageMap.section}">이전화면</a></button>
                   </td>
                </tr>
            </tbody>
        </table>
    </form>
    </div>

</body>
</html>