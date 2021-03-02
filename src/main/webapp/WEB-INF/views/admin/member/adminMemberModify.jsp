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
<c:set var="memberModifyPage" value="${memberModifyPage}" />
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

<script>
	$(function() {
		var cuId = $("#cuId").text();

		$("#mod").click(function() {
			
			var name=$("#name").val();
			var addr=$("#addr").val();
			var email=$("#email").val();
			
			$("#id").val(cuId);
			$("#modName").val(name);
			$("#modAddr").val(addr);
			$("#modEmail").val(email);
			
			console.log(cuId);
			console.log(name);
			console.log(addr);
			console.log(email);
			
			$("#frmModify").submit();
			alert('수정이 완료되었습니다.')

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
					<c:when test="${memberModifyPage==null }">
						<tr>
							<td colspan=5 style="text-align: center"><b>회원 상세정보가 없습니다</b>
						</tr>
					</c:when>
					<c:when test="${memberModifyPage!=null }">


						<tr>
							<td id="td1" scope="row" colspan="1">아이디:</td>
							<td id="cuId" scope="row" colspan="1" name="cuId">${memberModifyPage.cuId}</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">이름:</td>
							<td id="td2" scope="row" colspan="1" ><div class="input-group mb-3">
								<input id="name" type="text" class="form-control" value="${memberModifyPage.name }">
							</div></td>
						</tr>

						<tr>
							<td id="td1" scope="row">주소:</td>
							<td id="td2" scope="row" ><div class="input-group mb-3">
								<input id="addr" type="text" class="form-control" value="${memberModifyPage.addr}">
							</div></td>
						</tr>
						
							<tr>
							<td id="td1" scope="row">이메일:</td>
							<td id="td2" scope="row" >
							<div class="input-group mb-3">
								<input id="email" type="text" class="form-control" value="${memberModifyPage.email }">
							</div></td>
						</tr>
					


					</c:when>
				</c:choose>
			</tbody>
		</table>

		<p></p>
		<div class="approvalBtn">
			<button class="btn btn-outline-primary" id="mod">수정완료</button>
		</div>

		<p></p>
	</div>


	<form id="frmModify" action="${contextPath }/admin/member/adminMemberModify.do">

		<input type="hidden" id="id" name="cuId">
		<input type="hidden" id="modName" name="name">
		<input type="hidden" id="modAddr" name="addr">
		<input type="hidden" id="modEmail" name="email">

	</form>
</body>




</head>
<body>

</body>
</html>