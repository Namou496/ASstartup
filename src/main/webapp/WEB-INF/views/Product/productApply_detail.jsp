<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set  var="pageMap"  value="${pageMap}" />
    <c:set  var="product"  value="${product}" />
    <c:set  var="componentList"  value="${componentList}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세</title>
<style>
	a{text-decoration: none; color:black;}
    #td1{width: 50%; text-align: right;padding-right: 30px;}
    #td2{width: 50%;text-align: left; padding-left: 30px;}
    #product_image a img{width: 100px;height: 50px;}
    #rejectText{color: red;}
</style>
</head>
<body>

 <div class="container">
        <table class="table">
            <tbody>
                
                <tr> 
                    <td id="td1" scope="row">이미지:</td>
                    <td id="td2" scope="row">
                        
<!--                       제품이미지 jpg 파일을 보여준다.(기능구현)              -->
                        <div id="product_image">
                        <a href="#"><img src="${contextPath}/download?productName=${product.productName }&productImage=${product.productImage}&filePart=3"></a></div>
                    </td>
                </tr>
                <tr>
                    <td id="td1" scope="row" colspan="1">제품명:</td>
                    <td id="td2" scope="row" colspan="1" name="productName">${product.productName }</td>
                </tr>
                <tr>
                    <td id="td1" scope="row" colspan="1">상태:</td>
                    <c:choose>
                    	<c:when test="${product.approvalStatus==1}">
                    		<td id="td2" scope="row" colspan="1" name="approvalStatus">승인</td>
                    	</c:when>
                    	<c:when test="${product.approvalStatus==2}">
                    		<td id="td2" scope="row" colspan="1" name="approvalStatus">승인불가</td>
                    		<tr>
                    			<td id="td1" scope="row" colspan="1"></td>
                    			<td id="td2" scope="row" colspan="1" name="approvalStatus"><span id="rejectText">&nbsp;&nbsp;└${product.rejectionReason}</span></td>
                    		</tr>
                    	</c:when>
                    	<c:when test="${product.approvalStatus==3}">
                    		<td id="td2" scope="row" colspan="1" name="approvalStatus">승인대기</td>
                    	</c:when>
                    </c:choose>
                </tr>
                <tr>
                    <td id="td1" scope="row">제조사:</td>
                    <td id="td2" scope="row" name="manufacName">${product.manufacName }</td>                
                </tr>
                <tr> 
                    <td id="td1" scope="row">분류:</td>
                    <td id="td2" scope="row" name="productGroup">${product.productGroup }</td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">사용매뉴얼:</td>
                    <td id="td2" scope="row" name="useManual">${product.useManual }</td>
                </tr>
                <tr>
                    <td id="td1" scope="row">AS매뉴얼:</td>
                    <td id="td2" scope="row" name="asManual"><a href="#">${product.asManual }</a></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">부품:</td>
				<c:forEach var="cL" items="${componentList}">
                    <td id="td2" scope="row" name="asManual">${cL.componentName} : ${cL.componentPrice}</td>
                </tr>
                <tr>
                	<td id="td1" scope="row"></td>
                </c:forEach>
                </tr>
                <tr style="text-align: center">
                    <td style="width: 100%" colspan=2>
                   <button><a href="${contextPath }/Product/listProduct.do?pageNum=${pageMap.pageNum}&section=${pageMap.section}">이전화면</a></button>
                   </td>
                </tr>
            </tbody>
        </table>
        
    </div>

</body>
</html>