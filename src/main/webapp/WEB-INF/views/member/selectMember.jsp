<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원선택</title>
    <script src="../resources/js/login.js"></script>
    <link type="text/css" rel="stylesheet" href="../resources/css/selectMember.css">
</head>

<body>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                <div class="selectMem">
                    <div class="selectMember">
                        <label class="selectMemberFont">회원가입</label>
                    </div>
                </div>
                <div class="card-group">
                    <div class="card"><a href="${contextPath}/member/join.do">
                            <img src="../resources/img/user.png" class="card-img-top"></a>
                        <div class="card-body">
                            <br>
                            <h5 class="card-title">사용자 / 수리기사</h5>
                        </div>
                    </div>
                    <div class="card"><a href="${contextPath}/member/manufacJoinView.do">
                            <img src="../resources/img/manufac.png" class="card-img-top"></a>
                        <div class="card-body">
                            <br>
                            <h5 class="card-title">제조사</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body></html>