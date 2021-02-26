<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="productList" value="${productList}" />
<c:set var="productDetail" value="${productDetail}" />
<c:set var="componentList" value="${componentList}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>제품상세</title>
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
		var productNO = $("#productNO").text();

		$("#approvalNo").click(function() {
			var rejectionReason = $("#rejectionReason").val();
			$("#status").val(2);
			$("#reason").val(rejectionReason);
			$("#no").val(productNO);
			$("#frmApproval").submit();
			alert('승인거절이 완료되었습니다.')
		});

		$("#approvalOk").click(function() {
			$("#status").val(1);
			$("#reason").val("승인완료");
			$("#no").val(productNO);
			$("#frmApproval").submit();
			alert('승인이 완료되었습니다.')
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
	<h3 style="text-align: center">제품 상세정보</h3>
	<p></p>
	<div class="container">
		<table class="table">
			<tbody>
				<c:choose>
					<c:when test="${productDetail==null }">
						<tr>
							<td colspan=5 style="text-align: center"><b>제품 정보가 아직
									등록되지 않았습니다</b>
						</tr>
					</c:when>
					<c:when test="${productDetail!=null }">
						<tr>
							<td id="td1" scope="row">이미지:</td>
							<td id="td2" scope="row">
								<div id="product_image">
									<a href="#"><img src="img/as.png"></a>
								</div>
							</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">제품번호:</td>
							<td id="productNO" scope="row" colspan="1">${productDetail.productNO }</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">제품명:</td>
							<td id="td2" scope="row" colspan="1" name="productName">${productDetail.name }</td>
						</tr>

						<tr>
							<td id="td1" scope="row">제조사:</td>
							<td id="td2" scope="row" name="manufacName">${productDetail.manufacturerName }</td>
						</tr>
						<tr>
							<td id="td1" scope="row">분류:</td>
							<td id="td2" scope="row" name="prodGroup">${productDetail.prodGroup }</td>
						</tr>
						<tr>
							<td id="td1" scope="row">사용매뉴얼:</td>
							<td id="td2" scope="row" name="useManual">${productDetail.useManual }</td>
						</tr>
						<tr>
							<td id="td1" scope="row">AS매뉴얼:</td>
							<td id="td2" scope="row" name="asManual">${productDetail.ASManual }</td>
						</tr>

						<tr >
							<td id="td1" scope="col">부품목록</td>
						
						</tr>

					</c:when>
				</c:choose>
			</tbody>
		</table>


		<table style="text-align:center; margin:0 auto;">
			<tr>
				<td style="border-right: 1px solid #eee; width: 15%">부품명</td>
				<td style="border-right: 1px solid #eee; width: 15%">가격</td>
				<td style="border-right: 1px solid #eee; width: 15%">분류</td>
			</tr>
			<c:forEach var="com" items="${componentList}">
				<tr>
					<td>${com.componentName}</td>
					<td>${com.price}</td>
					<td>${com.part}</td>
				</tr>
			</c:forEach>
		</table>
		
		<p></p>

		<div class="input-group"
			style="width: 80%; text-align: center; margin: 0 auto;">
			<span class="input-group-text">승인불가 사유</span>
			<textarea class="form-control" aria-label="With textarea"
				id="rejectionReason" placeholder="승인 불가시에만 입력"></textarea>


		</div>
		<p></p>
		<div class="approvalBtn">
			<button class="btn btn-outline-primary" id="approvalOk">승인</button>
			<button class="btn btn-outline-primary" id="approvalNo">승인불가</button>
		</div>

		<p></p>
	</div>
	<form id="frmApproval"
		action="${contextPath }/admin/product/adminProductApproval.do">
		<input type="hidden" id="status" name="approvalStatus"> <input
			type="hidden" id="no" name="productNO"> <input type="hidden"
			id="reason" name="rejectionReason">
	</form>
</body>

</html>
