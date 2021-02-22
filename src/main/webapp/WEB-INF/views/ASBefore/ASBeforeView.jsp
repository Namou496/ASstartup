<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<c:set var="ASbefore" value="${ASbeforeMap.ASbefore}"/>
	<c:set var="repearPartList" value="${ASbeforeMap.repearPartList}"/>
	<c:set var="uNo" value="${sessionScope.member.uNo}"/>

    <meta charset="UTF-8">
    <title>Document</title>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />

    <!--jquery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

	<!-- myCss -->
	<link href="${contextPath}/resources/css/ASBeforeView.css" rel="stylesheet" type="text/css" media="screen">
	
    <!--myFunction-->
    <script type="text/javascript">
	    var sta = ${ASbefore.sta};
	    var productNum=${ASbefore.productNo};
	    var contextPath="${contextPath}";
    </script>
    <script type="text/javascript" src="${contextPath}/resources/js/ASBeforeView.js"></script>
</head>

<body>
    <div id="container">
        <div id="contants">
            <div id="customerIfTable">
                <table>
                    <tr class="contantsBox">
                        <th class="headFont">고객명</th>
                        <td>
                            <p class="contantFont">${ASbefore.custoname}</p>
                        </td>
                    </tr>
                    <tr class="contantsBox">
                        <th class="headFont">수리기사ID</th>
                        <td>
                            <p class="contantFont">${ASbefore.cuid}</p>
                        </td>
                    </tr>
                    <tr class="contantsBox">
                        <th class="headFont">고객<br>주소</th>
                        <td>
                            <p class="contantFont">${ASbefore.addr}</p>
                        </td>
                    </tr>
                    <tr class="contantsBox">
                        <th class="headFont">a/s제품 분류</th>
                        <td>
                            <p class="contantFont">${ASbefore.prodgroup}</p>
                        </td>
                    </tr>
                    <tr class="contantsBox">
                        <th class="headFont">제조사명</th>
                        <td>
                            <p class="contantFont">${ASbefore.mcrname}</p>
                        </td>
                    </tr>
                    <tr class="contantsBox">
                        <th class="headFont">모델명</th>
                        <td>
                            <p class="contantFont">${ASbefore.proname}</p>
                        </td>
                    </tr>
                    <tr class="contantsBox">
                        <th class="headFont">방문/<br>내방</th>
                        <td>
                        	<c:if test="${ASbefore.meeting==1}">
                            	<p class="contantFont">방문</p>
                            </c:if>
                            <c:if test="${ASbefore.meeting==2}">
                            	<p class="contantFont">내방</p>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="InfoText">
                <div>
                    <p class="headFont">증상</p>
                </div>
                <div class="form-floating">
                    <textarea class="form-control commentsArea" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px" readonly>${ASbefore.symptoms}</textarea>
                </div>
            </div>

            <div id="serviseCalendar">
                <div class="input-group input-group-sm mb-3">
                    <span class="headFont input-group-text" id="inputGroup-sizing-sm">
                        	희망방문일자
                 	</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${ASbefore.meetDate}" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <span class="headFont input-group-text" id="inputGroup-sizing-sm">
                        	기사방문일
                    </span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${ASbefore.respDate}" readonly>
                </div>
            </div>
            
            <c:if test="${ASbefore.sta==2&&uNo==2}">
				<form id="addForm" action="${contextPath}/ASBefore/addASBefore.do" method="post">
					<input type="hidden" name="asno" value="${ASbefore.asno}">

		            <div class="InfoText">
		                <div>
		                    <p class="headFont">수리기사 의견</p>
		                </div>
		                <div class="form-floating">
		                    <textarea name="asComment" class="form-control commentsArea" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px">내용</textarea>
		                </div>
		            </div>
		            
		            <div id="inputPart">
		                <p class="headFont">소모품 리스트</p>
		                <!--PartList-->
		                <div>
		                    <ul class="partList partListHead">
		                        <li>
		                            <ul>
		                                <li class="headFont">소모품명</li>
		                                <li class="headFont">수량</li>
		                                <li class="headFont">비용</li>
		                            </ul>
		                        </li>
		                    </ul>
		
		                    <ul class="partList partListContants"><!-- 부품 append -->
		                    
		                    </ul>
		                </div>
		            </div>
		            
		            <div id="appendPart">
		                <input id="appendPartButton" class="headFont" type="button" value="소모품 추가">
		            </div>
	            	
		            <div id="costBox">
		            
		                <div class="input-group input-group-sm mb-3">
		                    <span class="headFont input-group-text" id="inputGroup-sizing-sm">출장비</span>
		                    <input 
		                    	name="serviceCost"
		                    	type="text" 
		                    	class="form-control cost" 
		                    	aria-label="Sizing example input" 
		                    	aria-describedby="inputGroup-sizing-sm" 
		                    	value="${ASbefore.serviceCost}" 
		                    	readonly
		                    >
		                </div>
		                
		                <div class="input-group input-group-sm mb-3">
		                    <span class="headFont input-group-text" id="inputGroup-sizing-sm">인건비</span>
		                    <input 
		                    	name="manCost" 
		                    	type="text" 
		                    	class="form-control manPrice cost" 
		                    	aria-label="Sizing example input" 
		                    	aria-describedby="inputGroup-sizing-sm"
		                    >
		                </div>
		                
		                <div class="input-group input-group-sm mb-3">
		                    <span class="headFont  input-group-text" id="inputGroup-sizing-sm">총합</span>
		                    <input 
		                    	type="text"
		                    	class="form-control totalCost" 
		                    	aria-label="Sizing example input" 
		                    	aria-describedby="inputGroup-sizing-sm" 
		                    	readonly 
		                    	value="0"
		                    >
		                </div>
		                
		            </div>
	            </form>
				<c:if test="${ASbefore.sta==2}">
		            <div id="submit">
		                <input type="button" id="submitBtn" class="headFont" value="수리완료">
		            </div>
	            </c:if>
            </c:if>
            
            <c:if test="${ASbefore.sta==3}">
				<input type="hidden" name="asno" value="${ASbefore.asno}">
				
	            <div class="InfoText">
                	<div>
	                    <p class="headFont">수리기사 의견</p>
	                </div>
	                <div class="form-floating">
	                    <textarea class="form-control commentsArea" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px" readonly>${ASbefore.asComment}</textarea>
	                </div>
	            </div>
	            
	            <div id="inputPart">
	                <p class="headFont">소모품 리스트</p>
	                <!--PartList-->
	                <div>
	                    <ul class="partList partListHead">
	                        <li>
	                            <ul>
	                                <li class="headFont">소모품명</li>
	                                <li class="headFont">수량</li>
	                                <li class="headFont">비용</li>
	                            </ul>
	                        </li>
	                    </ul>
	
	                    <ul class="partList partListContants"><!-- 부품 append -->
							<c:if test="${repearPartList != null}">
								<c:forEach var="repearPart" items="${repearPartList}">
								<li>
									<ul>
										<li class="clearLi">
											<select class="form-select partSelect" disabled>
												<option value="${repearPart.price}">${repearPart.name}</option>
											</select>
										</li>
										<li class="input-group mb-3">
											<input type="text" class="amount form-control button-addon2" placeholder="수량입력" aria-describedby="button-addon2" value="${repearPart.amount}" readonly>
										</li>
										<li class="input-group mb-3">
											<input type="text" class="form-control price cost button-addon2" placeholder="0" aria-describedby="button-addon2" readonly>
										</li>
									</ul>
								</li>
								</c:forEach>
							</c:if>
	                    </ul>
	                </div>
	            </div>
            	
	            <div id="costBox">
	                <div class="input-group input-group-sm mb-3">
	                    <span class="headFont input-group-text" id="inputGroup-sizing-sm">출장비</span>
	                    <input 
	                    	name="serviceCost"
	                    	type="text" 
	                    	class="form-control cost" 
	                    	aria-label="Sizing example input" 
	                    	aria-describedby="inputGroup-sizing-sm" 
	                    	value="${ASbefore.serviceCost}" 
	                    	readonly
	                    >
	                </div>
	                
                 	<div class="input-group input-group-sm mb-3">
	                    <span class="headFont input-group-text" id="inputGroup-sizing-sm">인건비</span>
	                    <input
	                    	type="text" 
	                    	class="form-control manPrice cost" 
	                    	aria-label="Sizing example input" 
	                    	aria-describedby="inputGroup-sizing-sm" 
	                    	value="${ASbefore.manCost}" readonly
	                    >
	                </div>
	                		                		                
	                <div class="input-group input-group-sm mb-3">
	                    <span class="headFont  input-group-text" id="inputGroup-sizing-sm">총합</span>
	                    <input 
	                    	type="text"
	                    	class="form-control totalCost" 
	                    	aria-label="Sizing example input" 
	                    	aria-describedby="inputGroup-sizing-sm" 
	                    	readonly 
	                    	value="0"
	                    >
	                </div>
	                
	            </div>
	            
	            <c:choose>
				    <c:when test="${uNo==1 && empty ASbefore.textBox}">
				    <form action="${contextPath}/Asstarrate/callStarrate.do" method="get">
					 	<div id="ReviewSubmit">
							<button id="ReviewSubmitBtn" type="submit" class="btn btn-primary">리뷰작성</button>
						</div>
						<input type="hidden" name="asno" value="${ASbefore.asno}">
					</form>
					</c:when>
				</c:choose>
            </c:if>
        </div>
    </div>
</body>
</html>
