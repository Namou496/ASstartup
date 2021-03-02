<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 변경</title>
    <script src="../resources/js/re_pw.js"></script>
    <link type="text/css" rel="stylesheet" href="../resources/css/lost.css">
</head>
<body>
    <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">

				<form class="login100-form validate-form" onsubmit="return validate();" method="post" action="${contextPath}/member/updatePw.do">
					<span class="login100-form-title">
				        비밀번호 변경
					</span>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" id="cuId" name="cuId" placeholder="아이디">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user-circle" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" id="pw" name="pw" placeholder="비밀번호">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" id="pw_re" name="pw_re" placeholder="비밀번호 확인">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user-plus" aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							비밀번호 변경
						</button>
					</div>
                    <!-- 회원가입 폼으로 -->
					<div class="text-center p-t-136">
						<a class="txt2" href="/join.html">
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>