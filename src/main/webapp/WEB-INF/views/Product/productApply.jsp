<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set  var="pageMap"  value="${pageMap}" />
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

<style>
    #td1{width: 50%; text-align: right;padding-right: 30px;}
    #td2{width: 50%;text-align: left; padding-left: 30px;}
    #product_image a img{width: 200px;height: 150px;}
</style>
</head>
<body>

 <div class="container">
        <table class="table">
            <tbody>
                
                
                <tr>
                    <td id="td1" scope="row" colspan="1">제품명:</td>
                    <td id="td2" scope="row" colspan="1"><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">제조사:</td>
                    <td id="td2" scope="row">
                        <select>
                            <option>제조사</option>
                            <option>samsung</option>
                            <option>LG</option>
                            <option>apple</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">분류:</td>
                    <td id="td2" scope="row">
                        <select>
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
                    <td id="td2" scope="row"><input type="file"></td>
                </tr>
                <tr>
                    <td id="td1" scope="row">AS매뉴얼:</td>
                    <td id="td2" scope="row"><input type="file"></td>
                </tr>
                <tr> 
                    <td id="td1" scope="row">이미지:</td>
                    <td id="td2" scope="row"><input type="file"></td>
                </tr>
                <tr style="text-align: center">
                    <td style="width: 100%" colspan=2>
                   <button>승인요청</button>
                   <button><a href="${contextPath }/Product/listProduct.do?pageNum=${pageMap.pageNum}&section=${pageMap.section}">이전화면</a></button>
                   </td>
                </tr>
            </tbody>
        </table>
        
    </div>

</body>
</html>