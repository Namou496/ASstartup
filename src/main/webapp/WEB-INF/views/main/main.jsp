<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- createCss -->
<link href="${contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" media="screen">
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script> -->
<!--     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous"> -->
<!--     <link rel="preconnect" href="https://fonts.gstatic.com"> -->
<!--     <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> -->
<!--     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script> -->
<!-- createFunction -->
<script type="text/javascript" src="${contextPath}/resources/js/main.js"></script>
</head>
<body>
<div class="container-fluid main">
   <div id="intro">

    <!--            사용자                -->
        <div class="row" id="body">
            <div id="title">
                <img src="${contextPath}/resources/img/guid.png" alt="">
            </div>
            <div id="member" class="user">
               <div id="member_title">
                    <img src="${contextPath}/resources/img/member.png" alt="">
               </div>
               <div id="user_intro">
                    <div id="apply" class="apply">
                        <img src="${contextPath}/resources/img/apply_logo_1.png" alt="" id="apply_pic">
                        <img src="${contextPath}/resources/img/text_apply.png" alt=""  id="apply_text">
                    </div>
                    <div id="apply_next"><img src="${contextPath}/resources/img/next-logo.png" alt=""></div>
                    <div id="apply_end" class="apply">
                        <img src="${contextPath}/resources/img/send_logo.png" alt="" id="apply_pic">
                        <img src="${contextPath}/resources/img/text_applyEnd.png" alt="" id="apply_text">
                    </div>
                    <div id="apply_next"><img src="${contextPath}/img/next-logo.png" alt=""></div>
                    <div id="apply_visit" class="apply">
                        <img src="${contextPath}/resources/img/house.png" alt="" id="apply_pic">
                        <img src="${contextPath}/resources/img/text_visit.png" alt="" id="apply_text">
                    </div>
               </div>
            </div>
    <!--            as기사                -->
           <div id="member" class="supplyer">
               <div id="member_title">
                    <img src="${contextPath}/resources/img/member_as.png" alt="">
               </div>
               <div id="user_intro">
                    <div id="apply_location" class="apply">
                        <img src="${contextPath}/resources/img/location.png" alt="" id="as_location">
                        <img src="${contextPath}/resources/img/as_select.png" alt=""  id="as_location_text">
                    </div>
                    <div id="apply_next"><img src="${contextPath}/img/next-logo.png" alt=""></div>
                    <div id="apply_end" class="apply as_request">
                        <img src="${contextPath}/resources/img/apply.png" alt="" id="as_request">
                        <img src="${contextPath}/resources/img/as_request.png" alt="" id="as_request_text">
                    </div>
                    <div id="apply_next"><img src="${contextPath}/img/next-logo.png" alt=""></div>
                    <div id="apply_approval" class="apply">
                        <img src="${contextPath}/resources/img/approval2.png" alt="" id="apply_pic">
                        <img src="${contextPath}/resources/img/as_approval.png" alt="" id="apply_text">
                    </div>
                    <div id="apply_next"><img src="${contextPath}/resources/img/next-logo.png" alt=""></div>
                    <div id="as_visit" class="apply as_visit">
                        <img src="${contextPath}/resources/img/visit.png" alt="" id="apply_pic">
                        <img src="${contextPath}/resources/img/as_visit.png" alt="" id="apply_text">
                    </div>
               </div>
           </div>
    <!--            제조사                -->
           <div id="member" class="manufacturer">
               <div id="member_title">
                    <img src="${contextPath}/resources/img/member_manufac.png" alt="">
               </div>
               <div id="user_intro" >
                        <div id="manufac_member" class="apply">
                            <img src="${contextPath}/resources/img/manufac_approval2.png" alt="" id="apply_pic">
                            <img src="${contextPath}/resources/img/Play__11_-removebg-preview.png" alt=""  id="apply_text">
                        </div>
                        <div id="apply_next"><img src="${contextPath}/resources/img/next-logo.png" alt=""></div>
                        <div id="manufac_product" class="apply">
                            <img src="${contextPath}/resources/img/manufac_approval.png" alt="" id="apply_pic">
                            <img src="${contextPath}/resources/img/Play__12_-removebg-preview.png" alt="" id="apply_text">
                        </div>
               </div>
            </div>
       </div>
    </div>
</div>
</body>
</html>