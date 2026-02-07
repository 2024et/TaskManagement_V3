<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.List" %>
<%@ page import="Beans.editBeans" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校課題管理アプリ / 編集</title>
<link rel="stylesheet" href="edit.css">
<link rel="icon" href="icon.ico">
<style>
	footer {
	            background: #333;
	            color: white;
	            padding: 15px;
	            text-align: center;
	        }
</style>
</head>
<body>
 <header>
    
    <div class="header-center">
        <h1>学校課題管理アプリ</h1>
    </div>
    <div class="header-left">
        <p>ユーザーID: <%= request.getAttribute("username") %></p>
    </div>
    <nav class="header-right">
        <a href="indexServlet">ホーム</a>
        <a href="insertServlet">新規登録</a>
        <a href="logoutServlet">ログアウト</a>
    </nav>
</header>
    
    <main>
    <%
                editBeans stock = (editBeans) request.getAttribute("default");
				    if (stock != null) {
			        %>
    <section class="task-table">
            <h2>課題の編集　<button type="button" onclick="openModal()" class="help-btn">？</button></h2>
            <%
            java.util.Date deadline = stock.getDeadline();
            String formattedDate = "";
            if (deadline != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ← ハイフンに変更！
                formattedDate = sdf.format(deadline);
            }
			%>
            <p>課題の締め切り日：<%= formattedDate %></p>
            <table>
                <thead>
                    <tr>
                        <th>締切日</th>
                        <th>授業名</th>
                        <th>カテゴリ</th>
                        <th>内容</th>
                        <th>備考欄</th>
                        <th>進捗状況</th>
                        <th>出欠状況</th>
                    </tr>
                </thead>
                <tbody>
                
                	<form action="editServlet" method="post">
	                	<tr>
	                		<input type="hidden" name="TaskId" value="<%= stock.getTaskId() %>">
		                	<td><input type="date" id="deadline" name="deadline" value ="<%= formattedDate%>"></td>
		                	<td><input type="text" id="classs" name="classs" value="<%= stock.getClasss() %>"></td>
		                	<td><input type="text" id="category" name="category" value="<%= stock.getCategory() %>"></td>
		                	<td><input type="text" id="contents" name="contents" value="<%= stock.getContents() %>"></td>
		                	<td><input type="text" id="other" name="other" value="<%= stock.getOther() %>"></td>
		                	<td><input type="text" id="process" name="process" value="<%= stock.getProcess() %>"></td>
		                	<td><input type="text" id="attend" name="attend" value="<%= stock.getAttend() %>" size=5></td>
	                	</tr>
	                	<tr>
	                        <td colspan="8" style="text-align:center;">
	                        	<input type="submit" name="action" value="更新">
	                        </td>
	                    </tr>
	                     
                	</form>

                	<tr>
                		<td colspan="8" style="text-align:center;">
                		<button  onclick="location.href='indexServlet'">戻る</button>
                		</td>
                	</tr>
                	
                </tbody>
            </table>
        </section>
    </main>
    
    <script>
		  
			  function openModal() {
				    document.getElementById("Modal").classList.add("show");
				    //document.getElementById("resultMessage").textContent = ""; // 初期化
				  }

			  window.addEventListener("DOMContentLoaded", () => {
			    document.addEventListener("keydown", handleKeyPress);
			  });

			  function closeModal() {
			    document.getElementById("Modal").classList.remove("show");
			  }

			  window.addEventListener("DOMContentLoaded", () => {
			    document.addEventListener("keydown", handleKeyPress);
			  });
		</script>
		  
		<div id="Modal" >
			<h2>「編集」</h2>
			<p>登録されているタスクはここで編集することができます。</p>
			<button onclick="closeModal()">閉じる</button>
		</div>
		
		<%
			        }
			        %>
<footer>
    <p style="text-align: center;">
       ©2024-<span id="year"></span> EBATA TAKUMI
     </p>
      <p>学校課題管理アプリ Version3.0</p>
     <script>
       document.getElementById("year").textContent = new Date().getFullYear();
     </script>
</footer>
</body>
</html>