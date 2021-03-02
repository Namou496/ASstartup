<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<style>
 @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
    .actionColor {
      color:#0A6eff;
    }
    
    
    .starcontainer {
      padding: 0;
	  box-sizing: border-box;
	  margin: 0 auto;
	  margin-top: 3%;
	  font-family: 'Poppins', sans-serif;
	  width: 35%;
    }
/*
    html,
    .starcontainer {
        display: grid;
        height: 100%;
        place-items: center;
        text-align: center;

    }
*/
    .ratingcontainer {
        position: relative;
        width: 400px;
        padding: 20px 30px;
        border: 1px solid #444;
        border-radius: 5px;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
    }

    .ratingcontainer .star-post {
        display: none;
    }

    .ratingcontainer .star-text {
        font-size: 25px;
        color: #666;
        font-weight: 500;
    }

    .ratingcontainer .star-edit {
        position: absolute;
        right: 10px;
        top: 5px;
        font-size: 16px;
        color: #666;
        font-weight: 500;
        cursor: pointer;
    }

    .ratingcontainer .star-edit:hover {
        text-decoration: underline;
    }
    
    .ratingcontainer .star-exit {
        position: absolute;
        right: 10px;
        bottom: 5px;
        font-size: 11px;
        color: #666;
        font-weight: 500;
        
    }

    .ratingcontainer .star-widget input {
        display: none;
    }

    .star-widget label {
        font-size: 40px;
        color: #444;
        padding: 10px;
        float: right;
        transition: all 0.2s ease;
    }
    
    .star-widget input:not(:checked)~label:hover,
    .star-widget input:not(:checked)~label:hover~label {
        color: #0A6eff;
    }

    .star-widget input:checked~label {
        color: #0A6eff;
    }

    input#rate-5:checked~label {
        text-shadow: 0 0 20px #96a5ff;
    }

    
    #rate-1:checked~form header:before {
        content: "매우불만족 ";
    }

    #rate-2:checked~form header:before {
        content: "불만족 ";
    }

    #rate-3:checked~form header:before {
        content: "보통 ";
    }

    #rate-4:checked~form header:before {
        content: "만족 ";
    }

    #rate-5:checked~form header:before {
        content: "매우만족 ";
    }



    input:checked~form {
        display: block;
    }
/*
    form header {
        width: 100%;
        font-size: 25px;
        color: #000000;
        font-weight: 500;
        margin: 5px 0 20px 0;
        text-align: center;
        transition: all 0.2s ease;
    }
*/
    form .star-textarea {
        height: 100px;
        width: 100%;
        overflow: hidden;
        
    }

    form .star-textarea textarea {
        height: 100%;
        width: 100%;
        outline: none;
        color: #000000;
        border: 1px solid #333;
        background: #eee;
        padding: 10px;
        font-size: 17px;
        resize: none;
        
    }

    .star-textarea textarea:focus {
        border-color: #444;
    }

    form .star-btn {
        height: 45px;
        width: 100%;
        margin: 15px 0;
    }

    form .star-btn button {
        height: 100%;
        width: 100%;
        border: 1px solid #444;
        outline: none;
        background: #eee;
        color: #000000;
        font-size: 17px;
        font-weight: 500;
        text-transform: uppercase;
        cursor: pointer;
        transition: all 0.3s ease;
    }
   
    
    
</style>
<head>
    <meta charset="UTF-8">
    <title>설문지</title>
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="https://kit.fontawesome.com/f8c3b0091f.js" crossorigin="anonymous"></script>
    <script>
    	$(function(){
    		$(".starpoint").click(function(){
    			var num = $(this).val();
    			$("#num").val(num);
    			
    		});
    	});
    </script>
</head>

<body>
    <div class="starcontainer">
	    <div class="ratingcontainer">
	        <div class="star-post">
	            <div class="star-text">이용해 주셔서 감사합니다.</div>
	            <div class="star-edit">뒤로</div>
	            <div class="star-exit">메인으로</div>
	        </div>
		        <div class="star-widget">
		            <input type="radio" name="rate" value="5" class="starpoint" id="rate-5" >
		            <label for="rate-5" class="fas fa-star"></label>
		            <input type="radio" name="rate" value="4" class="starpoint" id="rate-4">
		            <label for="rate-4" class="fas fa-star"></label>
		            <input type="radio" name="rate" value="3" class="starpoint" id="rate-3">
		            <label for="rate-3" class="fas fa-star"></label>
		            <input type="radio" name="rate" value="2" class="starpoint" id="rate-2">
		            <label for="rate-2" class="fas fa-star"></label>
		            <input type="radio" name="rate" value="1" class="starpoint" id="rate-1">
		            <label for="rate-1" class="fas fa-star"></label>
		            <form class="rate" method="get" action="${contextPath}/Asstarrate/fillAsstarrate.do">
		            	<header>
		            		
		            	</header>
		            	<input type="hidden" id="num" name="resultcontainer" value="1"> 
			            <input type="hidden" name="asNo" value="${asno}">
			            <div class="star-textarea">
			                <textarea cols="30" name="textBox" placeholder="서비스 후기를 남겨주세요.."></textarea>
			            </div>
			            
			            <div class="star-btn">
			                <button type="submit">설문완료</button>
			            </div>
		            </form>
		        </div>
	        </div>
        </div> 
        
        
</body>

</html>
