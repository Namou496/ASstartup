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
        .whole {
            padding: 0px;
            background: lightgray;
            height: 600px;
            
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
                    $('#find').attr('style','display:none;');
                } else if(wth >= 992){
                    $('#find').attr('style','display:flex;');
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
            <div class="container-fluid navbark">
                
                <a class="navbar-brand" href="${contextPath}/main/main.do"><img src="${contextPath}/resources/img/21.png" alt="" style="width: 110px; height: 100px; padding-left: 10px;"></a>
                
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation" onclick="resizeNav();">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                    </div>
                </div>
            </div>
      		</nav>
    </div>
</body>
</html>