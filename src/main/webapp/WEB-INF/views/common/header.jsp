<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:choose>
	    <c:when test="${sessionScope.member!=null}">
	    	<c:set var="uNo" value="${sessionScope.member.uNo}"/>
	    </c:when>
	    <c:when test="${sessionScope.member==null}">
	    	<c:set var="uNo" value="0"/>		
	    </c:when>
    </c:choose>
<meta charset="UTF-8">
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${contextPath}/resources/css/common.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous"></script>
	
	<script type="text/javascript">
		var uNo=${uNo};
		var contextPath='${contextPath}';
		$(function(){
			$('.actionBtn').click(function(e){
				e.preventDefault();
				if(!uNo>0){
					alert('로그인후 이용가능합니다.');
				}else{
					var url = contextPath+$(this).attr('href');
					location.href=url;
				}
			});
			
			$('.loginBtn').click(function(){
				var url=contextPath+'/member/login.do';
				location.href=url;
			});
			
			$('.logoutBtn').click(function(){
				var url=contextPath+'/member/logout.do';
				location.href=url;
			});
			
		});
	</script>

</head>
<body>
    <div class="container-fluid">

        <div class="row">

            <div class="col" id="header">
                <div class="container">

                    <!-- <p>헤더</p>-->
					<a href="${contextPath}/main/main.do">
                    	<img src="${contextPath}/resources/img/logo_transparent%20(4).png" alt="">
                    </a>
					
                    <div class="menubar">
                        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        	<c:choose>
	                        	<c:when test="${uNo<=1}">
		                            <div class="container-fluid">
		                                <a class="navbar-brand" href="#">MENU</a>
		                                <button 
		                                	class="navbar-toggler" 
		                                	type="button" 
		                                	data-bs-toggle="collapse" 
		                                	data-bs-target="#navbarSupportedContent" 
		                                	aria-controls="navbarSupportedContent" 
		                                	aria-expanded="false" 
		                                	aria-label="Toggle navigation"
		                                >
		                                    <span class="navbar-toggler-icon"></span>
		                                </button>
		                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
		                                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASForm/ASForm.do">A/S신청</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASAfter/selectUserASAfterList.do">A/S신청 목록</a>
		                                        </li>
		
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASBefore/listASBefore.do">A/S이력 목록</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/Manual/listManual.do">매뉴얼 리스트</a>
		                                        </li>
		                                    </ul>
		                                    <c:choose>
			                                    <c:when test="${uNo==0}">
			                                    	<button class="loginBtn btn-outline-success" type="button">로그인</button>
			                                    </c:when>
			                                    <c:when test="${uNo != 0}">
			                                    	<button class="logoutBtn btn-outline-success" type="button">로그아웃</button>
			                                    </c:when>
		                                    </c:choose>
		                                </div>
		                            </div>
	                            </c:when>
	                            <c:when test="${uNo==2}">
		                            <div class="container-fluid">
		                                <a class="navbar-brand" href="#">MENU</a>
		                                <button 
		                                	class="navbar-toggler" 
		                                	type="button" 
		                                	data-bs-toggle="collapse" 
		                                	data-bs-target="#navbarSupportedContent" 
		                                	aria-controls="navbarSupportedContent" 
		                                	aria-expanded="false" 
		                                	aria-label="Toggle navigation"
		                                >
		                                    <span class="navbar-toggler-icon"></span>
		                                </button>
		                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
		                                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASAfter/selectASAfterList.do">A/S신청 목록</a>
		                                        </li>
		
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASBefore/listASBefore.do">A/S이력 목록</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/Manual/listManual.do">매뉴얼 리스트</a>
		                                        </li>
		                                    </ul>
		                                    <button class="logoutBtn btn-outline-success" type="button">로그아웃</button>
		                                </div>
		                            </div>
	                            </c:when>
	                            <c:when test="${uNo==3}">
		                            <div class="container-fluid">
		                                <a class="navbar-brand" href="#">MENU</a>
		                                <button 
		                                	class="navbar-toggler" 
		                                	type="button" 
		                                	data-bs-toggle="collapse" 
		                                	data-bs-target="#navbarSupportedContent" 
		                                	aria-controls="navbarSupportedContent" 
		                                	aria-expanded="false" 
		                                	aria-label="Toggle navigation"
		                                >
		                                    <span class="navbar-toggler-icon"></span>
		                                </button>
		                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
		                                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/Product/listProduct.do">제품등록 게시판</a>
		                                        </li>
		
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/Manual/listManual.do">매뉴얼 게시판</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASAfter/selectMfrASAfterList.do">A/S신청 목록</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/ASBefore/listASBefore.do">A/S이력 목록</a>
		                                        </li>
		                                    </ul>
		                                    
		                                    <button class="logoutBtn btn-outline-success" type="button">로그아웃</button>
		                                </div>
		                            </div>
	                            </c:when>
	                            
	                            <c:when test="${uNo==4}">
		                            <div class="container-fluid">
		                                <a class="navbar-brand" href="#">MENU</a>
		                                <button 
		                                	class="navbar-toggler" 
		                                	type="button" 
		                                	data-bs-toggle="collapse" 
		                                	data-bs-target="#navbarSupportedContent" 
		                                	aria-controls="navbarSupportedContent" 
		                                	aria-expanded="false" 
		                                	aria-label="Toggle navigation"
		                                >
		                                    <span class="navbar-toggler-icon"></span>
		                                </button>
		                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
		                                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/admin/product/adminProductList.do">제품등록승인</a>
		                                        </li>
		
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/admin/manufac/adminManufacList.do">제조사등록승인</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/admin/member/adminMemberList.do">사용자관리</a>
		                                        </li>
		                                        
		                                        <li class="nav-item">
		                                            <a class="nav-link actionBtn" href="/admin/satisfaction/adminSatisfactionList.do">소비자만족도확인</a>
		                                        </li>
		                                    </ul>
		                                    
		                                    <button class="logoutBtn btn-outline-success" type="button">로그아웃</button>
		                                </div>
		                            </div>
	                            </c:when>
                            </c:choose>
                        </nav>

                    </div>
                </div>

             
            </div>

        </div>
    </div>
</body>
</html>