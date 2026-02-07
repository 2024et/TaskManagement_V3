<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校課題管理アプリ / エラー</title>
</head>
<body>
	<h1>エラーが発生しました。</h1>
	<p>解決処理</p>
	<p>ご利用ブラウザからキャッシュを削除し、アプリを再起動、操作をやり直してください。</p>
	<p>それでも解決しない場合は、以下のメッセージを含めた本ページをスクリーンショットし開発者へご連絡ください。</p>
	<hr>
	<p>${requestScope.message}</p>
	
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