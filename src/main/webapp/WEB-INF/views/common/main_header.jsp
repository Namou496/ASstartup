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

        *{
            margin: 0px;
            padding: 0px;
        }
        .whole {
            padding: 0px;
            background: lightgray;
            height: 600px;
            margin-bottom: 30px;
        }
        
        .navbar{
        	height: 20%;
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
        #img{
            object-fit: cover;
            width: 100%;
            height: 80%;
        }
        #helpWhat{
            position: relative;
            display: flex;
            justify-content: center;
            color: white;
            font-size: 1.9em;
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
            text-align: center
            width: 40%;
        }
        a:hover{
            color: purple;
        }
        #logo{
            padding-left: 25px;
        }
        @media screen and (max-width:992px){
            #navbarNavAltMarkup{
                display: block;
            }
            #logo{
                padding-left: 0px;
                margin: 0 auto;
            }
            #find{
                display: none;
            }
            
        }
        
         @media screen and (min-width: 992px){
            .navbar-nav li{
                padding-right: 100px;
            }
        }
        #basic-addon2{
        	cursor: pointer;
        }

    </style>

	<script type="text/javascript">
		/*김태수*/
		var uNo=${uNo};
		var contextPath='${contextPath}';
		/*안두용*/
		function resizeNav(){
            var wth = $(this).width();
            if(wth <= 992){
                $('.nav-link').removeAttr('style');
          	}
      	}
		
		$(function(){
			/*김태수*/
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
                    $('#logo').attr('style', 'margin:0 auto;');
                    $('.nav-link').removeAttr('style');
                    $('#find').attr('style','display:none;');
                } else if(wth >= 992){
                    $('#find').attr('style','display:flex');
                    $('.a').attr('style', a);
                    $('.b').attr('style', b);
                    $('.c').attr('style', c);
                    $('.d').attr('style', d);
                    $('.e').attr('style', e);
                    $('.f').attr('style', f);
                }
            });
            
            $("#basic-addon2").click(function(){
            	if(!uNo>0){
					alert('로그인후 이용가능합니다.');
				}else{
            		$("#submit").submit();
				}
            });
		});
	</script>

</head>
<body>
    <div class="container-fluid whole">

        <!--      navbar   -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid navbar">
                <a class="navbar-brand" href="${contextPath}/main/main.do" id="logo"><img src="${contextPath}/resources/img/21.png" alt="" style="width: 110px; height: 100px; padding-left: 0px;"></a>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                    	<c:choose>
                    		<c:when test="${uNo<=1}">
                        		<li><a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/ASForm/ASForm.do" style="">신청서</a></li>
                        		<li><a class="nav-link b actionBtn" href="${contextPath}/ASAfter/selectUserASAfterList.do" style="">A/S신청 목록</a></li>
                        		<li><a class="nav-link c actionBtn" href="${contextPath}/ASBefore/listASBefore.do" style="">A/S이력 목록</a></li>
                        		<a class="nav-link d actionBtn" href="${contextPath}/Manual/listManual.do" tabindex="-1" aria-disabled="true" style="">매뉴얼 리스트</a>
                        	</c:when>
                        	<c:when test="${uNo==2}">
                        		<li><a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/ASAfter/selectASAfterList.do" style="">A/S신청 목록</a></li>
                        		<li><a class="nav-link b actionBtn" href="${contextPath}/ASBefore/listASBefore.do" style="">A/S이력 목록</a></li>
                        		<li><a class="nav-link c actionBtn" href="${contextPath}/Manual/listManual.do" style="">매뉴얼 리스트</a></li>
                        	</c:when>
                        	<c:when test="${uNo==3}">
                        		<li><a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/Product/listProduct.do" style="">제품등록 게시판</a></li>
                        		<li><a class="nav-link b actionBtn" href="${contextPath}/Manual/listManual.do" style="">매뉴얼 게시판</a></li>
                        		<li><a class="nav-link c actionBtn" href="${contextPath}/ASAfter/selectMfrASAfterList.do" style="">A/S신청 목록</a></li>
                        		<a class="nav-link d actionBtn" href="${contextPath}/ASBefore/listASBefore.do" tabindex="-1" aria-disabled="true" style="">A/S이력 목록</a>
                        	</c:when>
                        	<c:when test="${uNo==4}">
                        		<li><a class="nav-link active a actionBtn" aria-current="page" href="${contextPath}/admin/product/adminProductList.do" style="">제품등록승인</a></li>
                        		<li><a class="nav-link b actionBtn" href="${contextPath}/admin/manufac/adminManufacList.do" style="">제조사등록승인</a></li>
                        		<li><a class="nav-link c actionBtn" href="${contextPath}/admin/member/adminMemberList.do" style="">사용자관리</a></li>
                        		<a class="nav-link d actionBtn" href="${contextPath}/admin/satisfaction/adminSatisfactionList.do" tabindex="-1" aria-disabled="true" style="">소비자만족도확인</a>
                        	</c:when>
                        </c:choose>
                    </div>
                    <c:choose>
                   		<c:when test="${uNo==0}">
                        	<a class="nav-link e" href="${contextPath}/member/login.do" tabindex="-1">로그인</a>
                        	<a class="nav-link f" href="${contextPath}/member/selectMember.do" tabindex="-1" style="display: relative; left: 100px; float:right">회원가입</a>
                       	</c:when>
                       	
                       	<c:when test="${uNo!=0}">
                       		<a class="nav-link e actionBtn" href="${contextPath}/member/logout.do" tabindex="-1">로그아웃</a>
                       	</c:when>
                   	</c:choose>
                </div>

            </div>
        </nav>
        
        <img src="${contextPath}/resources/img/19.png" alt="" id="img">

        <div class="container" id="find">
        <p id="helpWhat">어떤 제품을 수리하실건가요?</p>
        	<form id="submit" action="${contextPath}/Manual/searchProduct.do" method="get">
	            <div class="input-group mb-3" id="find_prod"> 
	                  <input type="text" name="productName" class="form-control" placeholder="제품이름을 검색하세요" aria-label="Recipient's username" aria-describedby="basic-addon2" >
	                  <span class="input-group-text" id="basic-addon2">검색</span>
	            </div>
            </form>
        </div>
    </div>
</body>
</html>