<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校課題管理アプリ / ログイン</title>
<link rel="stylesheet" href="login.css">
<link rel="icon" href="icon.ico">
</head>
<body>
	<div class="box">
        <h2>ログイン</h2>
        <form action="loginServlet" method="post">
            <label for="username">ユーザー名:</label><br>
            <input type="text" name="username" id="username" required maxlength="30"><br><br>
            <label for="pass">パスワード:</label><br>
            <input type="password" name="pass" required maxlength="16"><br><br>
            <input type="submit" name="submit" id="roguinsuru" value="ログインする"><br>
        </form>
        <a href="account.jsp" id="sinki">&emsp;新規登録&emsp;</a>
        
    </div>
        <% 
    String error = (String) request.getAttribute("errorMessage"); 
    if (error != null) { 
%>
    <script>
        alert("<%= error.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "") %>");
    </script>
<% 
    } 
%>
<footer>
    <p style="text-align: center;">
       ©2024-<span id="year"></span> EBATA TAKUMI
     </p>
     
     <script>
       document.getElementById("year").textContent = new Date().getFullYear();
     </script>
</footer>
</body>
</html>