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
<script type="text/javascript" src="${contextPath}/resources/js/productApply.js"></script>
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