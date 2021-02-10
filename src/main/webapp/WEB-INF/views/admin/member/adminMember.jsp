<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet"
	type="text/css" media="screen">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

 <div class="container">

        <p></p>

        <div class="input-group mb-3" style="width: 70%;margin: 0 auto;">
           <select class="form-select" aria-label="Default select example">
  <option selected>분류선택</option>
  <option value="1">사용자</option>
  <option value="2">공급자</option>
  <option value="3">제조사</option>
</select>
          
            <input type="text" class="form-control" aria-label="Text input with dropdown button">
            
            <input class="btn btn-primary" type="submit" value="검색">
            
            
        </div>
        <p></p>

        <table class="table">
            <thead>
                <tr>

                    <th scope="col" style="border-right: 1px solid #eee; width: 20%">no</th>
                    <th scope="col" style="border-right: 1px solid #eee; width: 20%">이름</th>
                    <th scope="col" style="border-right: 1px solid #eee; width: 20%">분류</th>
                    <th scope="col" style="border-right: 1px solid #eee; width: 20%">가입일</th>


                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>

                <tr>
                    <th scope="row">2</th>
                    <td>김박최</td>
                    <td>사용자</td>
                    <td>2021-01-20</td>

                </tr>

                <tr>
                    <th scope="row">3</th>
                    <td>김박최</td>
                    <td>제조사</td>
                    <td>2021-01-20</td>

                </tr>

                <tr>
                    <th scope="row">4</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>

                <tr>
                    <th scope="row">5</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>김박최</td>
                    <td>사용자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>


                <tr>
                    <th scope="row">9</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">11</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">12</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">13</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>

                <tr>
                    <th scope="row">14</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

                </tr>
                <tr>
                    <th scope="row">15</th>
                    <td>김박최</td>
                    <td>공급자</td>
                    <td>2021-01-20</td>

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