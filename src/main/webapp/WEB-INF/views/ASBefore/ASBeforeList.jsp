<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<meta charset="UTF-8">
	<title>게시판양식</title>
	
	<!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
		crossorigin="anonymous">
	
	<meta name="viewport"
		content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link
		href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
		rel="stylesheet">
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>
	
	<!-- jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
	
	<!-- myCss -->
	<link href="${contextPath}/resources/css/ASBeforeList.css" rel="stylesheet" type="text/css" media="screen">
	<!-- myFunction -->
	<script type="text/javascript">
		var contextPath = "${contextPath}";
	</script>
	<script type="text/javascript" src="${contextPath}/resources/js/ASBeforeList.js"></script>
</head>

<body>

	<div class="container">
		<div id="staBox">
			<select class="form-select">
				<option selected value="0">전부</option>
				<option value="2">처리중</option>
				<option value="3">처리완료</option>
			</select>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th class="boardHead thTdBase" scope="col">a/s 번호</th>
					<th class="boardHead thTdBase" scope="col">고객명</th>
					<th class="boardHead thTdBase" scope="col">제품군</th>
					<th class="boardHead thTdBase addr" scope="col">고객주소</th>
					<th class="boardHead thTdBase" scope="col">접선방식</th>
					<th class="boardHead thTdBase" scope="col">방문/내방 일시</th>
					<th class="boardHead thTdBase" scope="col">처리단계</th>

				</tr>
			</thead>
			<!-- 이력 리스트 출력 -->
			<tbody id="ASBeforeList">

			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li id="back" class="page-link"><a>Back</a></li>
				<ul id="pagingNumBtn" class="pagination justify-content-center">
				</ul>
				<li id="next" class="page-link"><a>Next</a></li>
			</ul>
		</nav>

	</div>

	<form id="moveFunction"
		action="${contextPath}/ASBefore/viewASBefore.do" method="post">
		<input type="hidden" name="asno" id="asno"> 
	</form>

</body>
</html>


