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
<title>Main</title>
</head>
<body>
<div class="container main">
        <div class="row">

            <div class="col-sm">

                <!-- <p>메인</p>-->




            </div>

            <p></p>
            <h4>공지사항 <span class="badge bg-primary">New</span></h4>



           <table class="table">
  <thead>
    <tr>
      
      <th scope="col" style="border-right: 1px solid #eee; width: 55%">제목</th>
      <th scope="col" style="border-right: 1px solid #eee; width: 25%">날짜</th>
      <th scope="col" style="border-right: 1px solid #eee; width: 20%">작성자</th>
     
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">※AS신청서 양식※</th>
      <td>2020-12-12</td>
      <td>Mark</td>
     
    </tr>
    <tr>
      <th scope="row">※AS신청시 주의사항※</th>
      <td>2020-12-12</td>
      <td>안두용</td>
    
     
    </tr>
    <tr>
      <th scope="row">※AS기사 유의사항※</th>
      <td>2020-12-12</td>
      <td>김지은</td>
    </tr>
  </tbody>
     </table>

            <p></p>

            <h4>최근게시물 <span class="badge bg-primary">New</span></h4>

            <div>

            </div>
            <div class="card" style="width: 18rem;">
                <img src="img/air-conditioner.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">에어컨이 고장나서 뜨거운 바람만 나와요</p>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <img src="img/microwave.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">전자레인지 작동이 되지 않습니다</p>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <img src="img/washing-machine.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">소음이 심하고 빨래를 해도 세탁이 제대로 되지 않습니다</p>
                </div>
            </div>


            <p></p>
            <p></p>
            <p></p>
        </div>
    </div>
</body>
</html>