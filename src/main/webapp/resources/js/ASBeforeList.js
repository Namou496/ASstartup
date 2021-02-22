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
		url : contextPath+"/ASBefore/paging.do",
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
			alert("로그인 오류입니다. 다시확인후 시도해주세요");
			location.href=contextPath+"/main/main.do";
		}

	});
}

function listAjax(staNum) {
	$.ajax({
		type : "post",
		async : "fales",
		url : contextPath+"/ASBefore/ASBeforeListAjax.do",
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
			alert("로그인 오류입니다. 다시확인후 시도해주세요");
			location.href=contextPath+"/main/main.do";
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
