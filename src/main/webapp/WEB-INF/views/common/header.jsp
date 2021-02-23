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
	
	<style>
	* {
    margin: 0px;
    padding: 0px;
    }
        .navbar{
           padding: 0px;
        }
        .navbar-brand img{
            width: 100px;
            height: 100px;
        }
        #navbarNavAltMarkup{
            text-align: center;
        }
        .navbar-nav{
            margin: 0 auto;
        }
        
        #find{
            position: relative;
            display: flex;
            justify-content: ;
            flex-direction: column;
            width: 35%;
            bottom: 210px;
            margin: 0 auto;
        }
        #find_prod{
            position: relative;
            display: flex;
            text-align: center;
            width: 100%;
        }
        
        a:hover{
            color: purple;
        }
        #img{
            object-fit: cover;
        }
        .container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
        	padding: 0;
        }
        .on{
        margin-top:200px;
        }
    </style>

	<script type="text/javascript">
		/*김태수*/
		var uNo=${uNo};
		var contextPath='${contextPath}';
		/*안두용*/
		var sw = 0;
		function resizeNav(){
            var wth = $(this).width();
            
            if(wth <= 992){
                $('.nav-link').removeAttr('style');
                if(sw == 0){
                	$('#board').css({'margin-top':"200px"});
                	sw = 1;
                }else{
                	$('#board').css({'margin-top':"0px"});
                	sw = 0;
                }
                
	        }
		}
		
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
			/*안두용*/
			var a = $('.a').attr('style');
            var b = $('.b').attr('style');
            var c = $('.c').attr('style');
            var d = $('.d').attr('style');
            var e = $('.e').attr('style');
            var f = $('.f').attr('style');
          
            $(window).resize(function(){
                var wth = $(this).width();
                if(wth <= 992){
                    $('.nav-link').removeAttr('style');
                    
                } else if(wth >= 992){
                    $('.a').attr('style', a);
                    $('.b').attr('style', b);
                    $('.c').attr('style', c);
                    $('.d').attr('style', d);
                    $('.e').attr('style', e);
                    $('.f').attr('style', f);
                }
            });
			
		});
	</script>

</head>
<body>
    <div class="container-fluid whole" style="padding: 0;">
        <!--navbar-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid navbar2">
                
                <a class="navbar-brand" href="${contextPath}/main/main.do"><img src="${contextPath}/resources/img/21.png" alt="" style="width: 110px; height: 100px; padding-left: 10px;"></a>
                
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation" onclick="resizeNav();">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                    	<c:choose>
                    		<c:when test="${uNo<=1}">
                        		<a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/ASForm/ASForm.do" style="padding-right:80px;">신청서</a>
                        		<a class="nav-link b actionBtn" href="${contextPath}/ASAfter/selectUserASAfterList.do" style="padding-right:80px;">A/S신청 목록</a>
                        		<a class="nav-link c actionBtn" href="${contextPath}/ASBefore/listASBefore.do" style="padding-right:80px;">A/S이력 목록</a>
                        		<a class="nav-link d actionBtn" href="${contextPath}/Manual/listManual.do" tabindex="-1" aria-disabled="true" style="padding-right:30px;">매뉴얼 리스트</a>
                        	</c:when>
                        	<c:when test="${uNo==2}">
                        		<a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/ASAfter/selectASAfterList.do" style="padding-right:80px;">A/S신청 목록</a>
                        		<a class="nav-link b actionBtn" href="${contextPath}/ASBefore/listASBefore.do" style="padding-right:80px;">A/S이력 목록</a>
                        		<a class="nav-link c actionBtn" href="${contextPath}/Manual/listManual.do" style="padding-right:80px;">매뉴얼 리스트</a>
                        	</c:when>
                        	<c:when test="${uNo==3}">
                        		<a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/Product/listProduct.do" style="padding-right:80px;">제품등록 게시판</a>
                        		<a class="nav-link b actionBtn" href="${contextPath}/Manual/listManual.do" style="padding-right:80px;">매뉴얼 게시판</a>
                        		<a class="nav-link c actionBtn" href="${contextPath}/ASAfter/selectMfrASAfterList.do" style="padding-right:80px;">A/S신청 목록</a>
                        		<a class="nav-link d actionBtn" href="${contextPath}/ASBefore/listASBefore.do" tabindex="-1" aria-disabled="true" style="padding-right:30px;">A/S이력 목록</a>
                        	</c:when>
                        	<c:when test="${uNo==4}">
                        		<a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/admin/product/adminProductList.do" style="padding-right:80px;">제품등록승인</a>
                        		<a class="nav-link b actionBtn" href="${contextPath}/admin/manufac/adminManufacList.do" style="padding-right:80px;">제조사등록승인</a>
                        		<a class="nav-link c actionBtn" href="${contextPath}/admin/member/adminMemberList.do" style="padding-right:80px;">사용자관리</a>
                        		<a class="nav-link d actionBtn" href="${contextPath}/admin/satisfaction/adminSatisfactionList.do" tabindex="-1" aria-disabled="true" style="padding-right:30px;">소비자만족도확인</a>
                        	</c:when>
                    	</c:choose>
                    </div>
                    <a class="nav-link e actionBtn" href="${contextPath}/member/logout.do" tabindex="-1">로그아웃</a>
                </div>
            </div>
      		</nav>
        <img src="${contextPath}/resources/img/19.png" alt="" id="img">
    </div>
</body>
</html>