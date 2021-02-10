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
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세</title>
  <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="detailpage.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<style>
    #td1{width: 50%; text-align: right;padding-right: 30px;}
    #td2{width: 50%;text-align: left; padding-left: 30px;}
    #product_image a img{width: 100px;height: 50px;}
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
                        <a href="#"><img src="img/as.png"></a></div>
                    </td>
                </tr>
                <tr>
                    <td id="td1" scope="row" colspan="1">제품명:</td>
                    <td id="td2" scope="row" colspan="1" name="productName">${product.productName }</td>
                </tr>
                <tr>
                    <td id="td1" scope="row" colspan="1">상태:</td>
                    <td id="td2" scope="row" colspan="1" name="approvalStatus">${product.approvalStatus }</td>
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