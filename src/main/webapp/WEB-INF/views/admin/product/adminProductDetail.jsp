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
	crossorigin="anonymous"></script>

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

<script>
function fn_adminApproval(productNO,approvalType){
	var value;
	var frm_adminApproval;
		if(approvalType=='rejectionReason'){
			value=frm_adminApproval.RejectionReason;
			
		}else if(mod_type==''){
			
	}
}


</script>



</head>

<body>

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
								<td id="td1" scope="row" colspan="1">제품번호</td>
								<td id="td2" scope="row" colspan="1" name="productNO">${productDetail.productNO }</td>
							</tr>
							
							<tr>
								<td id="td1" scope="row" colspan="1">제품명:</td>
								<td id="td2" scope="row" colspan="1" name="productName">${productDetail.name }</td>
							</tr>
							<tr>
								<td id="td1" scope="row" colspan="1">상태:</td>
								<td id="td2" scope="row" colspan="1" name="approvalStatus">${productDetail.approvalStatus }</td>
							</tr>
							<tr>
								<td id="td1" scope="row">제조사:</td>
								<td id="td2" scope="row" name="manufacName"></td>
							</tr>
							<tr>
								<td id="td1" scope="row">분류:</td>
								<td id="td2" scope="row" name="prodGroup">${productDetail.prodGroup }</td>
							</tr>
							<tr>
								<td id="td1" scope="row">사용매뉴얼:</td>
								<td id="td2" scope="row" name="useManual"></td>
							</tr>
							<tr>
								<td id="td1" scope="row">AS매뉴얼:</td>
								<td id="td2" scope="row" name="asManual"><a href="#"></a></td>
							</tr>

					</c:when>
				</c:choose>
			</tbody>
		</table>
		<p></p>
		
		<form name="frm_adminApproval">
		<div class="input-group"
			style="width: 80%; text-align: center; margin: 0 auto;">
			<span class="input-group-text">승인불가 사유</span>
			<textarea class="form-control" aria-label="With textarea" name="rejectionReason" value=""></textarea>
		</div>
		<p></p>
		<div class="approvalBtn">
			<input class="btn btn-outline-primary" type="button" name="ok" value="승인" >
			<input class="btn btn-outline-primary" type="button" name="no" value="승인불가">
		</div>
		</form>
		
		<p></p>
	</div>

</body>

</html>
