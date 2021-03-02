<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="cuId"  value="${_cuId}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
    <script src="../resources/js/login.js"></script>
    <link type="text/css" rel="stylesheet" href="../resources/css/lost.css">
</head>
<body>
    <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">

				<form class="login100-form validate-form" method="post" action="${contextPath}/member/login.do">
					<span class="login100-form-title">
				        아이디는
					</span>
					<div>
					    <span class="login100-form-title">
                            <h3>${cuId}</h3>
					    </span>
					</div>
					
					<div>
					    <span class="login100-form-title">
					        입니다.
					    </span>
					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							확인
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1"></span>
						<a class="txt2" href="#"></a>
					</div>
                    <!-- 회원가입 폼으로 -->
					<div class="text-center p-t-136">
                        <a class="txt2" href="#"></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>