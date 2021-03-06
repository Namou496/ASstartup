<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="manufacList" value="${manufacList}" />
<c:set var="manufacDetail" value="${manufacDetail}" />
<c:set var="searchList" value="${searchList}" />

<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet" href="detailpage.css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>


</head>
<body>

	<div class="container">
		<p></p>
		
			<div style="">
			<select class="form-select" aria-label="Default select example"
				style="width: 25%; float: left;">
				<option selected>선택</option>
				<option value="name">제조사명</option>
				<option value="1">제조사번호</option>
				<option value="1">담당자명</option>

			</select>
			<form class="d-flex" style="width: 40%; position: relative;" action="${contextPath}/admin/manufac/adminManufacSearch.do">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">search</button>
			</form>
		</div>
<p></p>
		<table class="table" style="text-align:center">
		
		
		
			<thead>
				<tr>

				<th scope="col" style="border-right: 1px solid #eee; width: 10%; text-align:center">승인번호</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 25% ; text-align:center">제조사명</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 20%;text-align:center">제조사번호</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 15%;text-align:center">담당자명</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 20%;text-align:center">연락처</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 10%;text-align:center">승인상태</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${searchList==null }">

						<tr>
							<td colspan=5 style="text-align: center"><b>검색 결과가
									없습니다</b>
						</tr>
					</c:when>

					<c:when test="${searchList != null }">
		
					
						<c:forEach var="search" items="${searchList }">

							<tr>
							<th>${search.approvalNum}</th>
								<td><a href="${contextPath }/admin/manufac/adminManufacDetail.do?manufacNo=${search.manufacturerNO}">${search.name}</td>
								<td>${search.manufacturerNO}</a></td>
								<td>${search.officer}</td>
								<td>${search.tel}</td>
								<td>${search.approvalStatus}</td>
							</tr>
						</c:forEach>

					</c:when>


				</c:choose>



			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>

	</div>

</body>
</html>