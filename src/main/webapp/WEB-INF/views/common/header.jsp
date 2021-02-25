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

<style>
* {
	margin: 0px;
	padding: 0px;
}

.whole {
	padding: 0px;
	background: lightgray;
}

.navbar {
	height: 6.6%;
}

.navbar-brand>img {
	width: 100px;
	height: 60px;
}

#navbarNavAltMarkup {
	text-align: center;
}

.navbar-nav {
	margin: 0 auto;
}

.navbark {
	background: #524F4F;
}

#imgBanner {
	width: 100%;
	height: 30%;
}

#imgBanner img {
	height: 100%;
	width: 100%;
}

#helpWhat {
	position: relative;
	display: flex;
	justify-content: center;
	color: white;
	font-size: 1.9em;
}

a:hover {
	color: purple;
}

#imgBanner {
	object-fit: cover;
}

.container, .container-fluid, .container-lg, .container-md,
	.container-sm, .container-xl, .container-xxl {
	padding: 0;
}

.loginZon>ul {
	padding: 0px;
	margin-bottom: 0px;
}

.loginZon>ul>li {
	list-style: none;
	float: left;
}
/*         buttons */
*:before, *:after {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.headerBody {
	font-family: "Open Sans", Helvetica, Arial, sans-serif;
}

.buttons {
	text-align: center;
}

.blob-btn {
	z-index: 1;
	position: relative;
	padding: 20px 50px;
	text-align: center;
	text-transform: uppercase;
	color: #0fe0f5;
	font-size: 16px;
	font-weight: bold;
	background-color: transparent;
	outline: none;
	border: none;
	transition: color 0.5s;
	cursor: pointer;
}

.blob-btn:before {
	content: "";
	z-index: 1;
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
}

.blob-btn:hover {
	color: #222;
}

.blob-btn:hover:after {
	transition: all 0.3s;
	left: 0;
	top: 0;
}

.blob-btn__inner {
	z-index: -1;
	overflow: hidden;
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
}

.blob-btn__blobs {
	position: relative;
	display: block;
	height: 100%;
	filter: url("#goo");
}

.blob-btn__blob {
	position: absolute;
	top: 6px;
	width: 25%;
	height: 100%;
	background: #0fe0f5;
	border-radius: 100%;
	transform: translate3d(0, 150%, 0) scale(1.7);
	transition: transform 0.45s;
}

@
supports (filter: url( "#goo ")) { .blob-btn__blob { transform:translate3d(0,
	150%, 0)scale(1.4);
}

}
.blob-btn__blob:nth-child(1) {
	left: 0%;
	transition-delay: 0s;
}

.blob-btn__blob:nth-child(2) {
	left: 30%;
	transition-delay: 0.08s;
}

.blob-btn__blob:nth-child(3) {
	left: 60%;
	transition-delay: 0.16s;
}

.blob-btn__blob:nth-child(4) {
	left: 90%;
	transition-delay: 0.24s;
}

.blob-btn:hover .blob-btn__blob {
	transform: translateZ(0) scale(1.7);
}

@
supports (filter: url( "#goo ")) { .
	blob-btn: hover .blob-btn__blob{
                transform: translateZ(0) scale(1.4);
}

}
.manuBtns {
	margin: 0px;
	padding: 0px;
}

.manuBtns>li {
	list-style: none;
	float: left;
}
</style>

<script type="text/javascript">
		var uNo=${uNo};
		var contextPath='${contextPath}';
		function resizeNav(){
            var wth = $(this).width();
            if(wth <= 1000){
                $('.nav-link').removeAttr('style');
                $('.manuBtns>li').css({borderTop:"1px solid #786B6B",float:"none"});
                $('.loginZon>ul>li').css({borderTop:"1px solid #786B6B",float:"none"});
          	}
      	};
		
		$(function(){
			$('.actionBtn').click(function(e){
				e.preventDefault();
				if(!uNo>0){
					alert('로그인후 이용가능합니다.');
				}else{
					var url = $(this).attr('href');
					location.href=url;
				}
			});
			
            $(window).resize(function(){
                var wth = $(this).width();
                if(wth <= 1000){
                    $('.nav-link').removeAttr('style');
                }else{
                	$('.manuBtns>li').removeAttr('style');
                    $('.loginZon>ul>li').removeAttr('style');
                }
               
            });
            
            console.log('img:',$('#imgBanner').attr('displey'));

		});
	</script>

</head>
<body>
	<div class="container-fluid whole headerBody" style="padding: 0;">
		<!--navbar-->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
		<div id="imgBanner">
			<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="${contextPath}/resources/img/background.png" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="${contextPath}/resources/img/background.png" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="${contextPath}/resources/img/background.png" class="d-block w-100" alt="...">
			    </div>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>