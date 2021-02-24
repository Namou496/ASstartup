<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="memberList" value="${memberMap.memberList}" />
<c:set var="secNum" value="${memberMap.secNum}" />
<c:set var="lastPageNum" value="${memberMap.lastPageNum}" />
<c:set var="memberDetail" value="${memberDetail}" />


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

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<p></p>

		<div style="">
			<select class="form-select" aria-label="Default select example"
				style="width: 25%; float: left;">
				<option selected>사용자</option>
				<option value="name">공급자</option>
				<option value="1">제조사</option>


			</select>
			<form class="d-flex" style="width: 40%; position: relative;"
				action="${contextPath}/admin/member/adminMemberSearch.do">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="name">
				<button class="btn btn-outline-success" type="submit">search</button>
			</form>
		</div>
		<p></p>

		<table class="table">
			<thead>

				<tr>
					<th scope="col"
						style="border-right: 1px solid #eee; width: 30%; text-align: center">아이디</th>
					<th scope="col"
						style="border-right: 1px solid #eee; width: 30%; text-align: center">이름</th>

					<th scope="col"
						style="border-right: 1px solid #eee; width: 20%; text-align: center">권한</th>
					<th scope="col"
						style="border-right: 1px solid #eee; width: 20%; text-align: center">상세</th>


				</tr>
			</thead>
			<tbody style="text-align: center">
				<c:choose>
					<c:when test="${memberList==null }">

						<tr>
							<td colspan=5 style="text-align: center"><b>등록된 회원이 없습니다</b>
						</tr>

					</c:when>

					<c:when test="${memberList != null }">


						<c:forEach var="adminMem" items="${memberList}">
							<tr>

								<td>${adminMem.cuId}</td>
								<td>${adminMem.name}</td>

								<td>${adminMem.uNo}</td>

								<td><a
									href="${contextPath }/admin/member/adminMemberDetail.do?cuId=${adminMem.cuId}">상세보기</a></td>
							</tr>
						</c:forEach>

					</c:when>


				</c:choose>



			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link"
					href="${contextPath}/admin/member/adminMemberList.do?section=${secNum_-1}"
					tabindex="-1">Previous</a></li>

				<c:forEach var="pageNum" begin="${(secNum-1)*10+1}"
					end="${(secNum-1)*10+lastPageNum}" step="1">
					<li class="page-item"><a class="page-link"
						href="${contextPath}/admin/member/adminMemberList.do?section=${secNum}&page=${pageNum}">${pageNum}</a></li>
				</c:forEach>

				<li class="page-item"><a class="page-link"
					href="${contextPath}/admin/member/adminMemberist.do?section=${secNum+1}">Next</a></li>
			</ul>
		</nav>

	</div>



</body>
</html>