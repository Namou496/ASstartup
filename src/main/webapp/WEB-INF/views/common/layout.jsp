<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet"
	type="text/css" media="screen">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</head>
<body>

<!-- ㅁㄴㅇㄹ -->
	<div class="container-fluid">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div class="clear"></div>
	</div>
	
<!-- 	<aside> -->
<%-- 		<tiles:insertAttribute name="side" /> --%>
<!-- 	</aside> -->

	<div class="container">
		<article>
			<tiles:insertAttribute name="body" />
		</article>
		<div class="clear"></div>
	</div>

	<div class="container-fluid">
		<footer style="position: fixed;
			    bottom: 0;
			    width: 98%;
			    margin: 0 auto;"
		>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>



</body>

