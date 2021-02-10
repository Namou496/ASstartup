<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매뉴얼 상세</title>
  <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="detailpage.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>


<style>
    #manaul_list tr th{border-right: 1px solid #eee;}
</style>
</head>
<body>

  <div class="container">
        
        <table class="table">
            <thead id="manaul_list">
                <tr>
                    <th scope="col" style="width: 45%">제품</th>
                    <th scope="col" style="width: 20%">분류</th>
                    <th scope="col" style="width: 20%">제조사</th>
                    <th scope="col" style="width: 10%; border-right: none;">접근권한</th>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td scope="row"><a href="#">markNote15 LCVVELD-501A3</a></td>
                    <td>tv</td>
                    <td>Mark</td>
                    <td>제조사</td>
                </tr>
                <tr>
                    <td scope="row"><a href="#">markNote15 LCVVELD-501A3</a></td>
                    <td>청소기</td>
                    <td>LG전자</td>
                    <td>제조사</td>
                </tr>
                <tr>
                    <td scope="row"><a href="#">markNote15 LCVVELD-501A3</a></td>
                    <td>tv</td>
                    <td>삼성</td>
                    <td>제조사</td>
                </tr>

                <tr>
                    <td scope="row"><a href="#">markNote15 LCVVELD-501A3</a></td>
                    <td>desktop</td>
                    <td>SK</td>
                    <td>제조사</td>

                </tr>
                <tr>
                    <td scope="row"><a href="#">markNote15 LCVVELD-501A3</a></td>
                    <td>세탁기</td>
                    <td>ACER</td>
                    <td>제조사</td>


                </tr>
                <tr>
                    <td scope="row"><a href="#">markNote15 LCVVELD-501A3</a></td>
                    <td>laptop</td>
                    <td>APPLE</td>
                    <td>제조사</td>
                </tr>

            </tbody>
        </table>

        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>

    </div>

</body>
</html>