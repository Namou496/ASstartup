<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="productNo"  value="${product.productNo}" />
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록</title>
  <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="detailpage.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<script type="text/javascript">
	function addCompo(){
        var a = $('.c1').val();
        var b = $('.c2').val();
        var c = $('.c3').val();
        if(b=='분류'){
           alert('제품분류를 선택해주세요.');
        } else if(c==''){
           alert('제품이름을 입력하세요.');
        } else{
        var html = '';
            html += '<tr>';
            html += '<td id="td1" scope="row">'+a+'</td>';
            html += '<td id="td2" scope="row">';
            html += '<select name="componentPart" disabled>';
            html += '<input type="hidden" name="componentPart" value='+b+'>';
            html += '<option>'+b+'</option>';
            html += '</select>';
            html += '<input type="text" name="componentName" value='+c+' disabled>';
            html += '<input type="hidden" name="componentName" value='+c+'>';
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
    
    function nextPage(){
    	document.getElementById('frmProductApply').submit();
    };
	</script>
<style>
    #td1{width: 50%; text-align: right;padding-right: 30px;}
    #td2{width: 50%;text-align: left; padding-left: 30px;}
    #product_image a img{width: 200px;height: 150px;}
</style>
</head>
<body>

 <div class="container">
 	<form id="frmProductApply" method="post" action="${contextPath }/Product/applyProduct.do" enctype="multipart/form-data">
        <table class="table">
            <tbody>
                
                
                <tr>
                    <td id="td1" scope="row" colspan="1">제품명:</td>
                    <td id="td2" scope="row" colspan="1"><input type="text" name="productName"></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">제조사:</td>
                    <td id="td2" scope="row" >
						<span name="manufacName">${pageMap.manufacName}</span>
                    </td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">분류:</td>
                    <td id="td2" scope="row">
                        <select name="productGroup">
                            <option>분류</option>
                            <option>TV</option>
                            <option>DESKTOP</option>
                            <option>세탁기</option>
                            <option>냉장고</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">사용매뉴얼:</td>
                    <td id="td2" scope="row"><input type="file" name="useManual"></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">AS매뉴얼:</td>
                    <td id="td2" scope="row"><input type="file" name="asManual"></td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">이미지:</td>
                    <td id="td2" scope="row"><input type="file" name="productImage"></td>
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
		                    <input type="text" class="c3">
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