<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<head>
<meta charset="UTF-8">
<title>A/S 현황</title>

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
	crossorigin="anonymous">
	
</script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script>
	$(function() {
		$("input[name='sort']").on("click", function() {
			var count = $("input:checked[name='sort']").length;

			if (count > 3) {
				$(this).prop("checked", false);
				alert("최대 3개까지 선택가능합니다.");
			}
		});
	});
</script>

<style>
h1 {
	padding: 15px;
	text-align: center;
}

.title {
	width: auto;
	text-align: center;
}

.content {
	width: auto;
	text-align: center;
}

.selectbox {
	width: auto;
	padding-bottom: 20px;
}

.selectbox select {
	padding-right: 15px;
}

label {
	margin-left: 30px;
	margin-right: 10px;
}

input[type="checkbox"] {
	margin-right: 10px;
}

.search {
	text-align: right;
	padding-bottom: 20px;
}

.search input[type="text"] {
	padding-right: 24px;
}

.search input[type="button"] {
	padding: 0px 20px;
}

.title {
	border-right: 1px solid #eee;
	width: auto;
}
</style>
</head>

<body>
	<div class="container">
		<h1>A/S 현황</h1>
		<div class="select">
			<div class="selectbox">
				<select name="region">
					<option value="">지역</option>
					<option value="서구">서구</option>
					<option value="중구">중구</option>
					<option value="동구">동구</option>
					<option value="유성구">유성구</option>
				</select> <label> <input type="checkbox" name="sort" value="TV">TV
				</label> <label> <input type="checkbox" name="sort" value="컴퓨터">컴퓨터
				</label> <label> <input type="checkbox" name="sort" value="세탁기">세탁기
				</label> <label> <input type="checkbox" name="sort" value="라디오">라디오
				</label> <label> <input type="checkbox" name="sort" value="전자레인지">전자레인지
				</label>
			</div>
		</div>
		<div class="search">
			<input type="text" placeholder="내용을 입력해주세요."> <input
				type="button" value="검색">
		</div>

		<table class="table">
			<thead>
				<tr>
					<th class=title scope="col">no</th>
					<th class=title scope="col">희망날짜</th>
					<th class=title scope="col">제품명</th>
					<th class=title scope="col">제품종류</th>
					<th class=title scope="col">주소</th>
					<th class=title scope="col">작성자</th>
					<th class=title scope="col">처리현황</th>
					<th class=title scope="col">상세</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ASAfter" items="${ASAfterList}">
					<form action="${contextPath}/ASAfter/ASAfterListDetail.do">
						<tr class=content>
							<th scope="row">${ASAfter.asNo}</th>
							<td>${ASAfter.meetDate}</td>
							<td>${ASAfter.pname}</td>
							<td>${ASAfter.prodGroup}</td>
							<td>${ASAfter.addr}</td>
							<td>${ASAfter.uname}</td>
							<c:if test="${ASAfter.sta == 1}">
								<td>처리전</td>
							</c:if>
							<c:if test="${ASAfter.sta == 2}">
								<td>처리중</td>
							</c:if>
							<c:if test="${ASAfter.sta == 3}">
								<td>처리완료</td>
							</c:if>
							<input type="hidden" name="asno" value="${ASAfter.asNo}">
							<td><input type="submit" value="상세정보"></td>
						</tr>
					</form>
				</c:forEach>
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