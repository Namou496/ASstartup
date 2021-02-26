<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="memberList" value="${memberList}" />
<c:set var="memberDetail" value="${memberDetail}" />
<c:set var="memberDelete" value="${memberDelete}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>멤버 상세</title>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous"></script>

<script>
	$(function() {
		var cuId = $("#cuId").text();
		
		$("#mod").click(function() {
			$("#id2").val(cuId);
			console.log(cuId);
			$("#frmModify").submit();
			alert('수정 페이지로 이동')

		});

		$("#del").click(function() {
			$("#id").val(cuId);
			console.log(cuId);
			$("#frmDelete").submit();
			alert('삭제가 완료되었습니다.')
		});

	});
</script>


<style>
#td1 {
	width: 50%;
	text-align: right;
	padding-right: 30px;
}

#td2 {
	width: 50%;
	text-align: left;
	padding-left: 30px;
}

#product_image a img {
	width: 100px;
	height: 50px;
}

.approvalBtn {
	text-align: center;
}
</style>



</head>

<body>
	<p></p>
	<h3 style="text-align: center">멤버 상세정보</h3>
	<p></p>
	<div class="container">
		<table class="table">
			<tbody>
				<c:choose>
					<c:when test="${memberDetail==null }">
						<tr>
							<td colspan=5 style="text-align: center"><b>회원 상세정보가
									등록되지 않았습니다</b>
						</tr>
					</c:when>
					<c:when test="${memberDetail!=null }">


						<tr>
							<td id="td1" scope="row" colspan="1">아이디:</td>
							<td id="cuId" scope="row" colspan="1" name="cuId">${memberDetail.cuId }</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">이름:</td>
							<td id="td2" scope="row" colspan="1" name="productName">${memberDetail.name }</td>
						</tr>

						<tr>
							<td id="td1" scope="row">주소:</td>
							<td id="td2" scope="row" name="prodGroup">${memberDetail.addr}</td>
						</tr>
						<tr>
							<td id="td1" scope="row">이메일:</td>
							<td id="td2" scope="row" name="useManual">${memberDetail.email }</td>
						</tr>

						<tr>
							<td id="td1" scope="row">이메일:</td>
							<td id="td2" scope="row" name="email">
							<div class="input-group mb-3">
								<input type="text" class="form-control" value="${memberDetail.email }">
							</div></td>
						</tr>


					</c:when>
				</c:choose>
			</tbody>
		</table>

		<p></p>
		<div class="approvalBtn">
			<button class="btn btn-outline-primary" id="mod">수정</button>
			<button class="btn btn-outline-primary" id="del">삭제</button>
		</div>

		<p></p>
	</div>
	<form id="frmDelete"
		action="${contextPath }/admin/member/adminMemberDelete.do">

		<input type="hidden" id="id" name="cuId">
		

	</form>

	<form id="frmModify" action="${contextPath }/admin/member/adminMemberModifyPage.do">

		<input type="hidden" id="id2" name="cuId">

	</form>
</body>

</html>
