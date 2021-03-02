<%@page import="com.myspring.startup.ASAfter.vo.ASAfterDetailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="uNo" value="${sessionScope.member.uNo}" />

<head>
<meta charset="UTF-8">
<title>A/S 현황 상세정보</title>

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

<style>
h1 {
	padding: 15px;
	text-align: center;
}

.content {
	width: 100%;
	height: 50%;
	border: 1px solid #000;
	display: inline-block;
}

.leftcontent {
	width: 50%;
	height: 100%;
	float: left;
}

.leftcontent input[type="text"] {
	margin-bottom: 10px;
}

#addr {
	width: 80%;
	text-align: center;
}

.rightcontent {
	width: 50%;
	height: 100%;
	float: right;
}

.menu1 {
	width: 33%;
	float: left;
}

.menu1>input[type="text"] {
	width: auto;
	height: 20px;
}

.menu2 {
	float: left;
}

.menu2>label>input[type="radio"] {
	margin-left: 10px;
	margin-right: 10px;
}

.rightcontent>input[type="button"] {
	float: right;
}

.leftmenu {
	width: 50%;
	float: left;
}

.rightmenu {
	width: 50%;
	float: right;
}

.sysptom textarea {
	width: 100%;
	height: 120px;
	resize: none;
}

.submit {
	text-align: center;
}
</style>
</head>

<body>
	<div class="container">
		<form action="${contextPath}/ASAfter/insertASrespond.do" method="post">
			<h1>상세 정보</h1>
			<div class="content">

				<div class="leftcontent">

					<h5>신청자이름</h5>
					<c:forEach items="${ASAfterView}" var="view">
						<input type="text" value="${view.uname}"
							style="text-align: center" disabled="disabled">
					</c:forEach>
					<h5>전화번호</h5>
					<c:forEach items="${ASAfterView}" var="view">
						<input type="text" value="${view.tel}" style="text-align: center"
							disabled="disabled">
					</c:forEach>
					<h5>주소</h5>
					<c:forEach items="${ASAfterView}" var="view">
						<input type="text" value="${view.addr}" id="addr"
							disabled="disabled">
					</c:forEach>

					<div class="menu1">
						<span>제품종류</span><br> <select name="prod" disabled="disabled">
							<c:forEach items="${ASAfterView}" var="view">
								<option value="${view.prodGroup}">${view.prodGroup}</option>
							</c:forEach>
						</select>
					</div>
					<div class="menu1">
						<span>제조사</span><br> <select name="manufacturer"
							disabled="disabled">
							<c:forEach items="${ASAfterView}" var="view">
								<option value="${view.mname}">${view.mname}</option>
							</c:forEach>
						</select>
					</div>
					<div class="menu1">
						<span>제품명</span><br>
						<c:forEach items="${ASAfterView}" var="view">
							<input type="text" value="${view.pname}"
								style="text-align: center" disabled="disabled">
						</c:forEach>
					</div>
					<div class="menu2">
						<a>방문방식</a><br>
						<c:forEach items="${ASAfterView}" var="view">
							<c:if test="${view.meeting == 1}">
								<label><input type="radio" name="visit" value="1"
									checked="checked" disabled="disabled">수리기사 방문</label>
								<label><input type="radio" name="visit" value="2"
									disabled="disabled">A/S지점 방문</label>
								<br>
							</c:if>
							<c:if test="${view.meeting == 2}">
								<label><input type="radio" name="visit" value="1"
									disabled="disabled">수리기사 방문</label>
								<label><input type="radio" name="visit" value="2"
									checked="checked" disabled="disabled">A/S지점 방문</label>
								<br>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="rightcontent"></div>
			</div>
			<div class="leftmenu">
				<c:forEach items="${ASAfterView}" var="view">
					<span>방문희망일자</span>
					<br>
					<input type="date" value="${view.meetDate}" disabled="disabled">
				</c:forEach>
			</div>
			<div class="rightmenu">
				<span>방문예정일자</span><br> <input type="date" name="respDate"><br>
			</div>
			<div class="sysptom">
				<c:forEach items="${ASAfterView}" var="view">
					<span>증상</span>
					<br>
					<p>
						<textarea disabled="disabled">${view.symptoms}</textarea>
					</p>
				</c:forEach>
			</div>

			<div class="submit">
				<c:if test="${uNo == 2}">
					<input type="submit" value="승인">
				</c:if>
				<input type="hidden" name="asno" value="${asno}"> <input
					type="hidden" name="cuId" value="${sessionScope.member.cuId}">
			</div>
		</form>
	</div>
</body>
</html>