<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="productList" value="${productMap.productList}" />
<c:set var="secNum" value="${productMap.secNum}" />
<c:set var="lastPageNum" value="${productMap.lastPageNum}" />
<c:set var="productDetail" value="${productDetail}" />
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
				<option value="name">제품명</option>
				<option value="1">제조사명</option>
				<option value="productNO">제품번호</option>

			</select>
			<form class="d-flex" style="width: 40%; position: relative;" action="${contextPath}/admin/product/adminProductSearch.do">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="name">
				<button class="btn btn-outline-success" type="submit">search</button>
			</form>
		</div>
<p></p>
		<table class="table" style="text-align:center">
		
			<thead>
				<tr>
				<th scope="col" style="border-right: 1px solid #eee; width: 15%">승인번호</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 15%">제품번호</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 25%">제품명</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 15%">분류</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 15%">승인상태</th>
					<th scope="col" style="border-right: 1px solid #eee; width: 15%">상세</th>

				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${productList==null }">

						<tr>
							<td colspan=5 style="text-align: center"><b>등록 요청된 제품이
									없습니다</b>
						</tr>

					</c:when>

					<c:when test="${productList != null }">
		
					
						<c:forEach var="adminPro" items="${productList}">
							<tr>
							<th>${adminPro.approvalNum}</th>
								<td>${adminPro.productNO}</td>
								<td>${adminPro.name}</td>
								<td>${adminPro.prodGroup}</td>
								
								<td>${adminPro.approvalStatus}</td>
								<td><a href="${contextPath }/admin/product/adminProductDetail.do?productNO=${adminPro.productNO}">상세보기</a></td>
							</tr>
						</c:forEach>

					</c:when>


				</c:choose>



			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="${contextPath}/admin/product/adminProductList.do?section=${secNum_-1}"
					tabindex="-1" >Previous</a></li>
					
					<c:forEach var="pageNum" begin="${(secNum-1)*10+1}" end="${(secNum-1)*10+lastPageNum}" step="1">
						<li class="page-item"><a class="page-link" href="${contextPath}/admin/product/adminProductList.do?section=${secNum}&page=${pageNum}">${pageNum}</a></li>
					</c:forEach>
					
				<li class="page-item"><a class="page-link" href="${contextPath}/admin/product/adminProductList.do?section=${secNum+1}">Next</a></li>
			</ul>
		</nav>

	</div>

</body>
</html>