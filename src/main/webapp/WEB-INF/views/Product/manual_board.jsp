<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="productMap"  value="${productMap}" /> <!-- 제품리스트 -->
    <c:set var="uno"  value="${productMap.uno}" /> <!-- 제품리스트 -->
	<c:set var="totProduct"  value="${productMap.totProduct}" /> <!-- 글 갯수 -->
	<c:set var="pageMap"  value="${pageMap}" /> <!-- 로그인된 제조사명 -->
<!-- 제조사명 리스트 -->
	<c:set var="manufacNameList"  value="${productMap.manufacNameList}" />
	<!-- 페이징 -->
	<c:set var="section"  value="${productMap.section}" /> 
	<c:set var="pageNum"  value="${productMap.pageNum}" />
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매뉴얼 상세</title>
  <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="detailpage.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<script type="text/javascript">
	
	/* 검색필터 => 제조사이름 리스트 --> 제품그룹 */
	function manufacSelect(manufacName){
	$.ajax({
    type: "POST",
    async: "true",
	url: "${contextPath}/Manual/selectManufacturer.do",
	dataType: "json",
	data: {param:manufacName},
	success: function(result){
				$("#productGroup").find("option").remove().end().append("<option value=''>제품</option>");
				$.each(result, function(i){
					$("#productGroup").append("<option value='" + result[i] + "'>" + result[i] + "</option>");
				});
			},
    error: function(jqXHR, textStatus, errorThrown){
	alert("오류가 발생하였습니다.");
			}
    	});
	}
	
	</script>
<style>
	#frmSearchProd{
	float:left;
	}
	a{
	 text-decoration: none;
	}
    #manaul_list tr th{border-right: 1px solid #eee;}
</style>
</head>
<body>

<div class="container">
<!-- 	제품검색 	-->
    	<form id="frmSearchProd" action="${contextPath }/Manual/searchProduct.do" method="get">
	<!-- 	ajax 필터기능 = manufacSelect(this.value)	   -->
    	<select id="manufacName" name="manufacName" onchange="manufacSelect(this.value)">
        <option value="">제조사</option>
        	<c:forEach var="manufacNameList" items="${manufacNameList}">
        		<option value="${manufacNameList}">${manufacNameList}</option>
        	</c:forEach>
	    </select>
	    
	    
	    <select id="productGroup" name="productGroup">
	    	<option value="">제품</option>
	    </select>
	    <input type="text" name="productName">
	    <input type="submit" value="검색">
	    </form>

        <table class="table" id="list_view">
            <thead>
                <tr>
                    <th scope="col" style="border-right: 1px solid #eee; width: 45%">제품</th>
                    <th scope="col" style="border-right: 1px solid #eee; width: 20%">분류</th>
                    <th scope="col" style="border-right: 1px solid #eee; width: 20%">제조사</th>
				</tr>
            </thead>
            <tbody>
            <!-- 제품리스트 -->
            <c:choose>
            <c:when test="${productMap == null }">
            <tr>
                    <td scope="row">
	                    <p align="center">
	                    	<b>등록된 제품이 없습니다.</b>
	                    </p>
                    </td>
                    
            </tr> 
            </c:when>
            <c:when test="${productMap != null }">
            
            
	            <c:forEach var="productMap" items="${productMap.productList}">
	                <tr>
	                    <th scope="row"><a href="${contextPath }/Manual/ManualDetail.do?manufacName=${productMap.manufacName }&productNo=${productMap.productNo}&pageNum=${pageNum}&section=${section}&uno=${uno}">
	                    ${productMap.productName }</a></th>
	                    <td>${productMap.productGroup}</td>
	                    <td>${productMap.manufacName}</td>
	                </tr>
				</c:forEach>	
			</c:when>
			</c:choose>
			 <!-- 제품리스트 -->
            </tbody>
        </table>

		<!-- 페이징 페이지 = 10개, 1페이지 = 10개글 -->
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
            <c:if test="${totProduct != null }">
            <c:choose>
            	
            	<c:when test="${totProduct > 100}">
		            <c:forEach var="page" begin="1" end="10" step="1">
		            	<c:if test="${section > 1 && page==1}">
			                <li class="page-item disabled">
			                    <a class="page-link" href="${contextPath }/Manual/listManual.do?section=${section-1}&pageNum=${(section-1)}*10+1" tabindex="-1" aria-disabled="true">Previous</a>
			                </li>
			            </c:if>
			                <li class="page-item"><a class="page-link" href="${contextPath}/Manual/listManual.do?section=${section}&pageNum=${page}">${(section-1)*10 +page }</a></li>
			            <c:if test="${page == 10}">
			                <li class="page-item">
			                    <a class="page-link" href="${contextPath}/Manual/listManual.do?section=${section}&pageNum=${section*10+1}">Next</a>
			                </li>
			            </c:if>
		            </c:forEach>
                </c:when>
                <c:when test="${totProduct == 100}">
                	<c:forEach var="page" begin="1" end="10" step="1">
                		<li class="page-item"><a class="page-link" href="${contextPath}/Manual/listManual.do?section=${section}&pageNum=${page}">${(totArticles/10)*10+page}</a></li>
                	</c:forEach>
                </c:when>
                
                <c:when test="${totProduct < 100}">
                	<c:forEach var="page" begin="1" end="${totProduct/10+1}" step="1">
                		<c:choose>
	                		<c:when test="${page==pageNum }">
	                			<li id="selectPage" class="page-item"><a class="page-link" href="${contextPath}/Manual/listManual.do?section=${section}&pageNum=${page}">${page }</a></li>
	                		</c:when>
                			<c:otherwise>
                				<li class="page-item"><a class="page-link" href="${contextPath}/Manual/listManual.do?section=${section}&pageNum=${page}">${page }</a></li>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach>
                </c:when>
             </c:choose>
             </c:if>
            </ul>
        </nav>

    </div>

</body>
</html>