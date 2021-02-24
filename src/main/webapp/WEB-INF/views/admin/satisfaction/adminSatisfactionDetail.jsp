<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="satisfactionList" value="${satisfactionList}" />
<c:set var="satisfactionDetail" value="${satisfactionDetail}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>만족도 상세</title>
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
<h3 style="text-align:center">만족도 상세정보</h3>
<p></p>
	<div class="container">
		<table class="table">
			<tbody>
				<c:choose>
					<c:when test="${satisfactionDetail==null }">
						<tr>
							<td colspan=5 style="text-align: center"><b>만족도 상세정보가 없습니다</b>
						</tr>
					</c:when>
					<c:when test="${satisfactionDetail!=null }">

						<tr>
							<td id="td1" scope="row" colspan="1">AS번호:</td>
							<td id="td2" scope="row" colspan="1">${satisfactionDetail.asNo }</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">기사의견:</td>
							<td id="td2" scope="row" colspan="1" name="productName">${satisfactionDetail.ascomment }</td>
						</tr>
						
						<tr>
							<td id="td1" scope="row">인건비:</td>
							<td id="td2" scope="row" name="prodGroup">${satisfactionDetail.manCost}</td>
						</tr>
						<tr>
							<td id="td1" scope="row">출장비:</td>
							<td id="td2" scope="row" name="useManual">${satisfactionDetail.serviceCost}</td>
						</tr>
						<tr>
							<td id="td1" scope="row">만족도:</td>
							<td id="td2" scope="row" name="asManual">${satisfactionDetail.star}</td>
						</tr>
						
						<tr>
							<td id="td1" scope="row">개선사항:</td>
							<td id="td2" scope="row" name="asManual">${satisfactionDetail.textBox}</td>
						</tr>
						
						<tr>
							<td id="td1" scope="row">기사아이디:</td>
							<td id="td2" scope="row" name="asManual">${satisfactionDetail.cuid}</td>
						</tr>

					</c:when>
				</c:choose>
			</tbody>
		</table>
		<p></p>

</body>

</html>
