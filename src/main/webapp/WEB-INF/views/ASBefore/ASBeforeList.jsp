<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>게시판양식</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>

<!-- jquery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous"></script>


<!-- myFunction -->


<script type="text/javascript">
	var cont = 0;
	var pagingArray;
	var staNum = 0;
	var pageNum = 1;
	var ASBeforeListArray = new Array;

	function appendPaginNum(pagingArray) { /*1번 하단 페이징 버튼 펑션 생성*/
		$("#pagingNumBtn").empty();
		if (pagingArray[cont] != null) {
			pagingArray[cont].forEach(function(content) {
				$("#pagingNumBtn").append(content);
			});

			$(".page-item").click(function() {
				pageNum = $(this).find("a").text();
				appendASBeforeLists(ASBeforeListArray, pageNum);
			});

		} else {
			var content = '<li class="page-item"><a class="page-link">1</a></li>';
			$("#pagingNumBtn").append(content);

		}

	}
	
	function widthAction(winX){
		if(winX<=630){
			$('.thTdBase').css({fontSize: "10px"});
		}else{
			$('.thTdBase').removeAttr('style');
		}
	}

	function appendASBeforeLists(ASBeforeListArray, pageNum) { /*2번 리스트 생성 펑션 생성*/
		$("#ASBeforeList").empty();
		var last = ((pageNum * 2) * 10) - 1;
		var start = last - 19;

		for (var i = start; i <= last; i++) {
			$("#ASBeforeList").append(ASBeforeListArray[i]);
		}
		
		$(".buttonBox").click(function() {//view 페이지 이동 펑션
			var asno = $(this).find("th").text();
			
			$("#asno").val(asno);
			
			$("#moveFunction").submit();

		});
		
		var winX=$(this).width();
		widthAction(winX);

	}

	function listPagingNumBut(staNum) {
		$.ajax({
			type : "post",
			async : "true",
			url : "${contextPath}/ASBefore/paging.do",
			dataType : "json",
			data : {
				sta : staNum
			},
			success : function(json) {
				var paging = json.paging;
				pagingArray = new Array;
				var pagingNum = paging;
				for (var i = 1; i <= (Math.ceil(paging / 200)); i++) {
					pagingArray[i - 1] = new Array;

					if (pagingNum - 200 > 0) {/*현재 scope에서 버튼이 10개가 생성가능하다면*/
						for (var j = 1; j <= 10; j++) {
							pagingArray[i - 1][j - 1] = '<li class="page-item"><a class="page-link">'
									+ ((i - 1) * 10 + j) + '</a></li>';
						}
						pagingNum = pagingNum - 200;
					} else {/*현재 scope에서 버튼이 10개가 불가능하다면*/
						for (var j = 1; j <= (Math.ceil(pagingNum / 20)); j++) {
							pagingArray[i - 1][j - 1] = '<li class="page-item"><a class="page-link">'
									+ ((i - 1) * 10 + j) + '</a></li>';
						}
					}
				}

				appendPaginNum(pagingArray);/*1번작동*/

			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:"
						+ error);
			}

		});
	}

	function listAjax(staNum) {
		$.ajax({
			type : "post",
			async : "fales",
			url : "${contextPath}/ASBefore/ASBeforeListAjax.do",
			dataType : "json",
			data : {
				sta : staNum
			},
			success : function(json) {
				var ASBeforeListJson = json.ASBeforeList;

				ASBeforeListJson.forEach(function(data, index) {
					var content = '<tr class="buttonBox">'
							+ '<th class="thTdBase" colspan="row">' + data.asno
							+ '</th>' + '<td class="thTdBase">' + data.name
							+ '</td>' + '<td class="thTdBase">'
							+ data.prodgroup + '</td>'
							+ '<td class="thTdBase addr">' + data.addr
							+ '</td>' + '<td class="thTdBase">' + data.meeting
							+ '</td>' + '<td class="thTdBase">' + data.respDate
							+ '</td>' + '<td class="thTdBase">' + data.sta
							+ '</td>' + '</tr>';
					ASBeforeListArray[index] = content;
				});

				appendASBeforeLists(ASBeforeListArray, pageNum);

			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}

		});
	}

	$(function() {
		listPagingNumBut(staNum); /*하단 페이징 넘버 처리*/
		listAjax(staNum);
		
		var winX=$(window).width();
		
		widthAction(winX);
		
		$(window).resize(function(){
			winX=$(this).width();
    		widthAction(winX);
		});

		$("#back").click(function() {
			if (cont <= 0) {
				alert("더이상 이동할수없습니다.");
			} else {
				cont -= 1;
				appendPaginNum(pagingArray); /*1번작동*/
			}
		});

		$("#next").click(function() {
			if (cont >= pagingArray.length - 1) {
				alert("더이상 이동할수없습니다.");
			} else {
				cont += 1;
				appendPaginNum(pagingArray); /*1번작동*/
			}
		});

		$("#staBox>select").change(function() {
			staNum = $(this).val();
			ASBeforeListArray = new Array;
			pageNum = 1;
			cont = 0;
			listAjax(staNum);
			listPagingNumBut(staNum);
		});

	});
</script>

<style>
#staBox {
	width: 10%;
	margin-bottom: 10px;
}

.boardHead {
	border-right: 1px solid #eee;
}

.thTdBase {
	width: 12%;
	text-align: center;
}

.addr {
	width: 24%;
}

.buttonBox {
	cursor: pointer;
}
</style>


</head>

<body>

	<div class="container">
		<div id="staBox">
			<select class="form-select">
				<option selected value="0">전부</option>
				<option value="2">처리중</option>
				<option value="3">처리완료</option>
			</select>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th class="boardHead thTdBase" scope="col">a/s 번호</th>
					<th class="boardHead thTdBase" scope="col">고객명</th>
					<th class="boardHead thTdBase" scope="col">제품군</th>
					<th class="boardHead thTdBase addr" scope="col">고객주소</th>
					<th class="boardHead thTdBase" scope="col">접선방식</th>
					<th class="boardHead thTdBase" scope="col">방문/내방 일시</th>
					<th class="boardHead thTdBase" scope="col">처리단계</th>

				</tr>
			</thead>
			<!-- 이력 리스트 출력 -->
			<tbody id="ASBeforeList">

			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li id="back" class="page-link"><a>Back</a></li>
				<ul id="pagingNumBtn" class="pagination justify-content-center">
				</ul>
				<li id="next" class="page-link"><a>Next</a></li>
			</ul>
		</nav>

	</div>

	<form id="moveFunction"
		action="${contextPath}/ASBefore/viewASBefore.do" method="post">
		<input type="hidden" name="asno" id="asno"> 
	</form>

</body>
</html>


