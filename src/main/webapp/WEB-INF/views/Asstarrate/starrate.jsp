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
<style>
    @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    html,
    body {
        display: grid;
        height: 100%;
        place-items: center;
        text-align: center;

    }

    .container {
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

    .container .post {
        display: none;
    }

    .container .text {
        font-size: 25px;
        color: #666;
        font-weight: 500;
    }

    .container .edit {
        position: absolute;
        right: 10px;
        top: 5px;
        font-size: 16px;
        color: #666;
        font-weight: 500;
        cursor: pointer;
    }

    .container .edit:hover {
        text-decoration: underline;
    }

    .container .star-widget input {
        display: none;
    }

    .star-widget label {
        font-size: 40px;
        color: #444;
        padding: 10px;
        float: right;
        transition: all 0.2s ease;
    }

    input:not(:checked)~label:hover,
    input:not(:checked)~label:hover~label {
        color: #0A6eff;
    }

    input:checked~label {
        color: #0A6eff;
    }

    input#rate-5:checked~label {
        color: #0000ff;
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

    form header {
        width: 100%;
        font-size: 25px;
        color: #000000;
        font-weight: 500;
        margin: 5px 0 20px 0;
        text-align: center;
        transition: all 0.2s ease;
    }

    form .textarea {
        height: 100px;
        width: 100%;
        overflow: hidden;
        
    }

    form .textarea textarea {
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

    .textarea textarea:focus {
        border-color: #444;
    }

    form .btn {
        height: 45px;
        width: 100%;
        margin: 15px 0;
    }

    form .btn button {
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

    form .btn button:hover {
        background: #1b1b1b;
    }

</style>

<head>
<meta charset="UTF-8">
<title>설문지</title>
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${contextPath }/resources/css/common.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</head>
<body>
    <meta charset="UTF-8">
    <title>설문지</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>

<body>
    <div class="container">
        <div class="post">
            <div class="text">이용해 주셔서 감사합니다.</div>
            <div class="edit">뒤로</div>
        </div>
        <div class="star-widget">
            <input type="radio" name="rate" id="rate-5">
            <label for="rate-5" class="fas fa-star"></label>
            <input type="radio" name="rate" id="rate-4">
            <label for="rate-4" class="fas fa-star"></label>
            <input type="radio" name="rate" id="rate-3">
            <label for="rate-3" class="fas fa-star"></label>
            <input type="radio" name="rate" id="rate-2">
            <label for="rate-2" class="fas fa-star"></label>
            <input type="radio" name="rate" id="rate-1">
            <label for="rate-1" class="fas fa-star"></label>
            <form class="rate" method="get" action="#">
                <header>

                </header>
                <div class="textarea">
                    <textarea cols="30" placeholder="서비스 후기를 남겨주세요.."></textarea>
                </div>
                <div class="btn">
                    <button type="submit">설문완료</button>
                </div>
            </form>
        </div>
        </div>
        <script>
            const btn = document.querySelector("button");
            const post = document.querySelector(".post");
            const widget = document.querySelector(".star-widget");
            const editBtn = document.querySelector(".edit");
            btn.onclick = () => {
                widget.style.display = "none";
                post.style.display = "block";

                editBtn.onclick = () => {
                    widget.style.display = "block";
                    post.style.display = "none";
                }
                return false;
            }

        </script>
</body>
</html>
