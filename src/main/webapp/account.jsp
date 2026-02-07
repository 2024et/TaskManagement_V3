<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校課題管理アプリ / アカウント</title>
<link rel="stylesheet" href="account.css">
<link rel="icon" href="icon.ico">
</head>

<body>
	<div class="box">
        <h2>新規登録</h2>
        
        <form action="accountServlet" method="post" >
            <label for="username">ユーザーネーム(表示される名前):</label><br>
            <input type="text" id="username" name="username" required maxlength="30"><br><br>

            <label for="pass1">パスワードを作成してください(6文字以上16文字以下):</label><br>
            <input type="password" id="pass1" name="pass1" required maxlength="16"><br><br>

            <label for="pass2">パスワードを再度入力してください。:</label><br>
            <input type="password" id="pass2" name="pass2" required maxlength="16"><br><br>
            
            <input type="checkbox" id="scales" name="scales" required/>
            <label for="scales"><a href="policy.jsp">利用規約</a>に同意します。</label><br><br>

            <input type="submit" name="submit" id="sinki" value="登録する"><br><br>
        </form>
        <a href="login.jsp" id="sinki">すでに登録済みの方</a>
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