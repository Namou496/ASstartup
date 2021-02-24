<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="manufacList" value="${manufacList}" />
<c:set var="manufacDetail" value="${manufacDetail}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>제조사상세</title>
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
	$(function(){
		var cuId=$("#cuId").text();
		console.log(cuId);
		
		$("#approvalNo").click(function(){
			console.log("1");
			var rejectionReason=$("#rejectionReason").val();
			$("#status").val(2);
			$("#reason").val(rejectionReason);
			$("#id").val(cuId);
			$("#frmApproval").submit();
			alert('승인거절이 완료되었습니다.');
		});
		
		$("#approvalOk").click(function(){
			console.log("2");
			$("#status").val(1);
			$("#reason").val("승인완료");
			$("#id").val(cuId);
			$("#frmApproval").submit();
			alert('승인이 완료되었습니다.');
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


.approvalBtn {
	text-align: center;
}
</style>



</head>

<body>
<p></p>
<h3 style="text-align:center">제조사 승인 상세</h3>
<p></p>
	<div class="container">
		<table class="table">
			<tbody>
				<c:choose>
					<c:when test="${manufacDetail==null }">
						<tr>
							<td colspan=5 style="text-align: center"><b>제품 정보가 아직
									등록되지 않았습니다</b>
						</tr>
					</c:when>
					<c:when test="${manufacDetail!=null }">

						<tr>
							<td id="td1" scope="row" colspan="1">제조사명:</td>
							<td id="td2" scope="row" colspan="1" name="name">${manufacDetail.name }</td>
						</tr>
						<tr>
							<td id="td1" scope="row" colspan="1">아이디:</td>
							<td id="cuId" scope="row" colspan="1" name="cuId">${manufacDetail.cuId}</td>
						</tr>
						
						<tr>
							<td id="td1" scope="row" colspan="1">제조사번호:</td>
							<td id="td2" scope="row" colspan="1" name="manufacturerNO">${manufacDetail.manufacturerNO }</td>
						</tr>
						
						<tr>
							<td id="td1" scope="row" colspan="1">담당자명:</td>
							<td id="td2" scope="row" colspan="1" name="officer">${manufacDetail.officer }</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">연락처:</td>
							<td id="td2" scope="row" colspan="1" name="tel">${manufacDetail.tel}</td>
						</tr>

						<tr>
							<td id="td1" scope="row" colspan="1">주소:</td>
							<td id="td2" scope="row" colspan="1" name="addr">${manufacDetail.addr}</td>
						</tr>
						

					</c:when>
				</c:choose>
			</tbody>
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
	<form id="frmApproval" action="${contextPath }/admin/manufac/adminManufacApproval.do">
		<input type="hidden" id="status" name="approvalStatus">
		<input type="hidden" id="id" name="cuId">
		<input type="hidden" id="reason" name="rejectionReason">
	</form>
	
</body>

</html>
