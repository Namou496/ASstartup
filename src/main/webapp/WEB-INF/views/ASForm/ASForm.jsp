<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="productMap"  value="${productMap}" /> <!-- 제품리스트 -->
	<c:set var="totProduct"  value="${productMap.totProduct}" /> <!-- 글 갯수 -->
	<c:set var="pageMap"  value="${pageMap}" /> <!-- 로그인된 제조사명 -->
	<c:set var="manufacSearch"  value="${manufacName}" /> <!-- 제조사명 리스트 -->
	<!-- 페이징 -->
	<c:set var="section"  value="${productMap.section}" /> 
	<c:set var="pageNum"  value="${productMap.pageNum}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>신청서</title>
<!-- css -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<link type="text/css" rel="stylesheet" href="../resources/css/bootstrap.min.css" />

<!-- JavaScript -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../resources/js/asform.js"></script>
<script>
    $(function(){
    	$("#img").css({display:"none"});
    });
    </script>
</head>

<body>
	<main>
		<div class="container">
			<div class="pageName">
				<h1 style="text-align: center">AS신청서</h1>
			</div>
			<div class="form">
				<form class="form-horizontal" name="form-horizontal"
					onsubmit="return validate();" method="post"
					enctype="multipart/form-data"
					action="${contextPath}/ASForm/addForm.do"><br /><br /><br />
					<div class="form-group">
						<h4>
							<label for="memberInfo" class="col-lg-2 control-label">개인정보취급방침</label>
						</h4>
						<div class="col-lg-10" id="memberInfo">
							<textarea class="form-control" rows="8" style="resize: none">
제1조 (개인정보의 처리 목적)
① 개인정보보호위원회는 개인정보를 다음의 목적을 위해 처리합니다. 처리한 개인정보는 다음의 목적이외의 용도로는 사용되지 않으며 이용 목적이 변경되는 경우에는 개인정보 보호법 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.
가. 서비스 제공
교육 콘텐츠 제공, 본인인증, 증명서발급(교육 수료증) 등 서비스 제공에 관련한 목적으로 개인정보를 처리합니다.
협박 사례를 적극 신고하시기 바랍니다.

나. 민원처리
개인정보 열람, 개인정보 정정·삭제, 개인정보 처리정지 요구, 개인정보 유출사고 신고 등 개인정보와 관련된 민원처리를 목적으로 개인정보를 처리합니다.

② 개인정보보호위원회가 개인정보 보호법 제32조에 따라 등록·공개하는 개인정보파일의 처리목적은 다음과 같습니다.
순번	개인정보파일의 명칭	운영근거	처리목적
1	교육서비스 제공 사용자 정보	정보주체 동의	개인정보보호 온라인교육에 대한 본인인증, 교육이력관리, 교육수료증 발급
2	개인정보 열람등요구 처리 사용자 정보	개인정보보호법 제35조-제39조	개인정보 열람등요구 처리 행정업무의 참고 또는 사실 증명
3	유출사고 신고 처리 사용자 정보	개인정보보호법 제34조
신용정보의 이용 및 보호에 관한 법률 제39조	유출사고 신고 처리 행정업무의 참고 또는 사실 증명
4	개인정보보호 전문강사 명단	정보주체 동의	개인정보보호 교육지원(강사풀 제공)
                       제2조 (개인정보의 처리 및 보유 기간)
① 개인정보보호위원회는 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집시에 동의받은 개인정보 보유·이용기간 내에서 개인정보를 처리·보유합니다.
② 각각의 개인정보 처리 및 보유 기간은 다음과 같습니다.
순번	개인정보파일의 명칭	운영근거	보유기간
(목적 달성시)
1	교육서비스 제공 사용자 정보	정보주체 동의	2년
2	개인정보 열람등요구 처리 사용자 정보	개인정보보호법 제35조-제39조	3년
3	유출사고 신고 처리 사용자 정보	개인정보보호법 제34조
신용정보의 이용 및 보호에 관한 법률 제39조	3년
4	개인정보보호 전문강사 명단	정보주체 동의	3년
제3조 (개인정보의 제3자 제공)
① 개인정보보호위원회는 정보주체의 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.
② 개인정보보호위원회는 민원 신청인이 공공기관에 대하여 신청한 개인정보 열람, 정정·삭제, 처리정지민원을 처리하기 위하여 민원 신청인의 개인정보를 개인정보파일 보유기관에게 이송(제공)하고 있으며, (민원사무 처리에 관한 법률)에서 정하는 기간 동안 해당 기관에서 보유 및 이용합니다.
- 이송(제공)하는 개인정보 항목 : 신청인 성명, 생년월일, 전화번호, 주소
                       제7조 (개인정보 파기 절차 및 방법)
① 개인정보보호위원회는 원칙적으로 개인정보 처리목적이 달성된 경우에는 지체없이 해당 개인정보를 파기합니다. 다만, 다른 법률에 따라 보존하여야하는 경우에는 그러하지 않습니다. 파기의 절차, 기한 및 방법은 다음과 같습니다.
가. 파기절차
불필요한 개인정보 및 개인정보파일은 개인정보책임자의 책임 하에 내부방침 절차에 따라 다음과 같이 처리하고 있습니다.
- 개인정보의 파기
보유기간이 경과한 개인정보는 종료일로부터 지체 없이 파기합니다.
- 개인정보파일의 파기
개인정보파일의 처리 목적 달성, 해당 서비스의 폐지, 사업의 종료 등 그 개인정보파일이 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 지체 없이 그 개인정보파일을 파기합니다.
나. 파기방법
1) 전자적 형태의 정보는 기록을 재생할 수 없는 기술적 방법을 사용합니다.
2) 종이에 출력된 개인정보는 분쇄기로 분쇄하거나 소각을 통하여 파기합니다.
                       제9조 (개인정보의 안전성 확보 조치)
개인정보보호위원회는 「개인정보보호법」 제29조에 따라 다음과 같이 안전성 확보에 필요한 기술적, 관리적, 물리적 조치를 하고 있습니다.

1. 내부관리계획의 수립 및 시행
개인정보보호위원회의 내부관리계획 수립 및 시행은 개인정보보호위원회의 내부관리 지침을 준수하여 시행합니다.

2. 개인정보 취급 담당자의 최소화 및 교육
개인정보를 취급하는 담당자를 지정하고 최소화하여 개인정보를 관리하는 대책을 시행하고 있습니다.

3. 개인정보에 대한 접근 제한
개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여, 변경, 말소를 통하여 개인정보에 대한 접근통제를 위하여 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다.

4. 접속기록의 보관 및 위변조 방지
개인정보처리시스템에 접속한 기록(웹 로그, 요약정보 등)을 최소 1년 이상 보관, 관리하고 있으며, 접속 기록이 위변조 및 도난, 분실되지 않도록 보안기능을 사용하고 있습니다.

5. 개인정보의 암호화
이용자의 개인정보는 암호화 되어 저장 및 관리되고 있습니다. 또한 중요한 데이터는 저장 및 전송 시 암호화하여 사용하는 등의 별도 보안기능을 사용하고 있습니다.

6. 해킹 등에 대비한 기술적 대책
개인정보보호위원회는 해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여 보안프로그램을 설치하고 주기적인 갱신·점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적/물리적으로 감시 및 차단하고 있습니다. 또한 네트워크 트래픽의 통제(Monitoring)는 물론 불법적으로 정보를 변경하는 등의 시도를 탐지하고 있습니다.

7. 비인가자에 대한 출입 통제
개인정보를 보관하고 있는 개인정보시스템의 물리적 보관 장소를 별도로 두고 이에 대해 출입통제 절차를 수립, 운영하고 있습니다.

제10조 (권익침해 구제방법)
정보주체는 아래의 기관에 대해 개인정보 침해에 대한 피해구제, 상담 등을 문의하실 수 있습니다. (아래의 기관은 개인정보보호 포털과는 별개의 기관으로서, 개인정보보호 포털의 자체적인 개인정보 불만처리, 피해구제 결과에 만족하지 못하시거나 보다 자세한 도움이 필요하시면 문의하여 주시기 바랍니다)

▶ 개인정보 침해신고센터 (한국인터넷진흥원 운영)
- 소관업무 : 개인정보 침해사실 신고, 상담 신청
- 홈페이지 : privacy.kisa.or.kr
- 전화 : (국번없이) 118
- 주소 : 전라남도 나주시 진흥길 9 한국인터넷진흥원
▶ 개인정보 분쟁조정위원회
- 소관업무 : 개인정보 분쟁조정신청, 집단분쟁조정 (민사적 해결)
- 홈페이지 : www.kopico.go.kr
- 전화 : 1833-6972
- 주소 : 서울특별시 종로구 세종대로 209 정부서울청사 12층
▶ 대검찰청 사이버범죄수사단 :
- (국번없이) 1301, privacy@spo.go.kr (www.spo.go.kr)
▶ 경찰청 사이버안전국
- (국번없이) 182 (cyberbureau.police.go.kr)
또한, 개인정보의 열람, 정정·삭제, 처리정지 등에 대한 정보주체자의 요구에 대하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익을 침해 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.

☞ 중앙행정심판위원회(www.simpan.go.kr)의 전화번호 안내 참조
                        </textarea>
							<div class="radio">
								<label> <input type="radio" id="memberInfoYn">
									개인정보 취급 방침에 동의합니다.
								</label>
							</div>
							</div>
							<br /> <input type="hidden" id="sta" name="sta" value="1">
							<div class="form-group">
							<!-- 대분류 중분류 소분류 -->
                            <div class="form-group col-lg-10">
                                <select id="manufacName" class="form-control-first" name="manufacName" title="제조사" onchange="manufacSelectName(this.value)">
                                    <option value="" selected>제조사</option>
                                    <c:forEach var="manufacSearch" items="${manufacSearch }">
                                    	<option value="${manufacSearch }">${manufacSearch }</option>
                                    </c:forEach>
                                </select>

                                <select id="productGroup" class="form-control-second" name="productGroup" title="제품분류" onchange="manufacSelectGroup(this.value)">
                                    <option value="" selected>제품 분류</option>
                                </select>

                                <select id="productName" class="form-control-third" name="productName" title="제품명">
                                    <option value="" selected>제품명</option>
                                </select>
							</div><br/>
							<div class="form-group col-lg-10">
								<h5>
									<label for="vistype" class="col-lg-2 control-label">방문
										구분</label>
								</h5>
								<div class="col-lg-10">
									<label class="radio-inline"> <input type="radio"
										id="meeting" name="meeting" value="1" checked> 수리지점 방문
									</label> <label class="radio-inline"> <input type="radio"
										id="meeting" name="meeting" value="2"> A/S기사 직접 방문
									</label>
								</div>
							</div>
							<br />
							<div class="form-group col-lg-10" id="divId">
								<label for="phonenum" class="col-lg-2 control-label">전화번호</label>
								<div class="col-lg-12">
									<input type="text" class="form-control"
										id="phone" name="phone" data-rule-required="true"
										placeholder="-빼고 입력해주세요." maxlength="13">
								</div>
							</div>
							<br />
							<div class="form-group col-lg-10" id="divNickname">
								<label for="addr" class="col-lg-2 control-label">주소</label>
								<div class="col-lg-12">
									<input type="text" class="col-lg-4" id="postCode"
										style="padding: 5px; border-radius: 5px;" name="postCode"
										data-rule-required="true" placeholder="우편주소" maxlength="30"
										disabled> <input type="button"
										class="col-lg-2 btn btn-primary"
										onclick="sample5_execDaumPostcode()" value="주소 검색"> 
										<input type="text" class="form-control" id="addr1" name="addr1"
										data-rule-required="true" placeholder="주소" maxlength="30"
										readonly> 
										<input type="text" class="form-control"
										id="addr2" name="addr2" data-rule-required="true"
										placeholder="상세 주소" maxlength="30"> <br>
								</div>
							</div>
							<br />
							<div class="form-group col-lg-10" id="divPhoneNumber">
								<label for="meetDate" class="col-lg-2 control-label">희망방문
									날짜</label>
								<div class="col-lg-12">
									<input type="date" class="form-control onlyNumber"
										id="meetDate" name="meetDate" data-rule-required="true">
								</div>
							</div>
							<br />
							<div class="form-group col-lg-10" id="divEmail">
								<label for="symptoms" class="col-lg-2 control-label">증상</label>
								<div class="col-lg-12">
									<textarea class="form-control" id="symptoms" name="symptoms"
										data-rule-required="true"
										placeholder="고장난 기기의 증상을 입력해주세요. 1000" maxlength="1000"></textarea>
								</div>
							</div>
							<br />
							<div class="form-group col-lg-10" id="divPasswordCheck">
								<label for="fileinput" class="col-lg-2 control-label">첨부파일</label>
								<div class="col-lg-12">
									<input type="file" class="form-control" id="fileimg"
										name="fileimg" accept="image/*">
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button type="submit" class="btn btn-primary form-control">접수</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>

