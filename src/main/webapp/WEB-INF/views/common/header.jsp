<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:choose>
	<c:when test="${sessionScope.member!=null}">
		<c:set var="uNo" value="${sessionScope.member.uNo}" />
	</c:when>
	<c:when test="${sessionScope.member==null}">
		<c:set var="uNo" value="0" />
	</c:when>
</c:choose>
<meta charset="UTF-8">
<!-- createCss -->
<link href="${contextPath}/resources/css/header.css" rel="stylesheet" type="text/css" media="screen">
<!-- createFunction -->
<script type="text/javascript">
		var uNo=${uNo};
		var contextPath='${contextPath}';
</script>
<script type="text/javascript" src="${contextPath}/resources/js/header.js"></script>

</head>
<body>
	<div class="container-fluid headerBody" style="padding: 0;">
		<!--navbar-->
		<nav class="navbar navbar-expand-lg navbar-light bg-light" style="height: 8.1%">
			<div class="container-fluid navbark" style="padding: 0;">

				<a class="navbar-brand" href="${contextPath}/main/main.do"
					style="padding-bottom: 0;"><img
					src="${contextPath}/resources/img/logo.png" alt=""></a>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation" onclick="resizeNav();">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<ul class="manuBtns">
							<c:choose>
								<c:when test="${uNo<=1}">
									<li class="buttons"><a
										href="${contextPath}/ASForm/ASForm.do">
											<button class="blob-btn">
												신청서 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
									<li class="buttons"><a
										href="${contextPath}/ASAfter/selectUserASAfterList.do">
											<button class="blob-btn">
												A/S신청 목록 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
									<li class="buttons"><a
										href="${contextPath}/ASBefore/listASBefore.do">
											<button class="blob-btn">
												A/S이력 목록 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
									<li class="buttons"><a
										href="${contextPath}/Manual/listManual.do">
											<button class="blob-btn">
												매뉴얼 리스트 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
								</c:when>

								<c:when test="${uNo==2}">
									<li class="buttons"><a
										href="${contextPath}/ASAfter/selectASAfterList.do">
											<button class="blob-btn">
												A/S신청 목록 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/ASBefore/listASBefore.do">
											<button class="blob-btn">
												A/S이력 목록 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/Manual/listManual.do">
											<button class="blob-btn">
												매뉴얼 리스트 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
								</c:when>

								<c:when test="${uNo==3}">
									<li class="buttons"><a
										href="${contextPath}/Product/listProduct.do">
											<button class="blob-btn">
												제품등록 게시판 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/Manual/listManual.do">
											<button class="blob-btn">
												매뉴얼 게시판 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/ASAfter/selectMfrASAfterList.do">
											<button class="blob-btn">
												A/S신청 목록 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/ASBefore/listASBefore.do">
											<button class="blob-btn">
												A/S이력 목록 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
								</c:when>

								<c:when test="${uNo==4}">
									<li class="buttons"><a
										href="${contextPath}/admin/product/adminProductList.do">
											<button class="blob-btn">
												제품등록승인 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/admin/manufac/adminManufacList.do">
											<button class="blob-btn">
												제조사등록승인 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/admin/member/adminMemberList.do">
											<button class="blob-btn">
												사용자관리 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li class="buttons"><a
										href="${contextPath}/admin/satisfaction/adminSatisfactionList.do">
											<button class="blob-btn">
												소비자만족도확인 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
								</c:when>
							</c:choose>
							<svg xmlns="http://www.w3.org/2000/svg" version="1.1"
								style="width: 0px; height: 0px;">
					            <defs>
					                <filter id="goo">
					                    <feGaussianBlur in="SourceGraphic"
									result="blur" stdDeviation="10"></feGaussianBlur>
					                    <feColorMatrix in="blur" mode="matrix"
									values="1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 21 -7" result="goo"></feColorMatrix>
					                    <feBlend in2="goo" in="SourceGraphic"
									result="mix"></feBlend>
					                </filter>
					            </defs>
					        </svg>
						</ul>
					</div>
					<div class="loginZon">
						<c:choose>
							<c:when test="${uNo==0}">
								<ul>
									<li><a href="${contextPath}/member/login.do">
											<button class="blob-btn">
												로그인 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>

									<li><a href="${contextPath}/member/selectMember.do">
											<button class="blob-btn">
												회원가입 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
								</ul>
							</c:when>
							<c:when test="${uNo!=0}">
								<ul>
									<li><a href="${contextPath}/member/logout.do">
											<button class="blob-btn">
												로그아웃 <span class="blob-btn__inner"> <span
													class="blob-btn__blobs"> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span> <span
														class="blob-btn__blob"></span>
												</span>
												</span>
											</button>
									</a></li>
								</ul>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</nav>
		<div id="imgBanner"style="display: block;">
			<div id="carouselExampleSlidesOnly" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${contextPath}/resources/img/background.png"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${contextPath}/resources/img/background.png"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${contextPath}/resources/img/background.png"
							class="d-block w-100" alt="...">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>