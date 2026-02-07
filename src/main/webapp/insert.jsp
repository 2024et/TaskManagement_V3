<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.List" %>
<%@ page import="Beans.insertAuto" %>
<%@ page import = "java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校課題管理アプリ / タスク登録</title>
<link rel="stylesheet" href="insert.css">
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
        <%
	Object userIdObj = request.getAttribute("username");
	if (userIdObj == null) {
	    response.sendRedirect("login.jsp");
	}
%>

    <main>
    <section class="task-table">
    <h2>新規登録(Manual)　<button type="button" onclick="openManual()" class="help-btn">？</button></h2>
    <form action="insertServlet" method="post">
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
                <tr>
                	<input type="hidden" name="action" value="manual"/>
                    <td><input type="date" id="deadline" name="deadline" required></td>
                    <td><input type="text" id="classs" name="classs" placeholder="授業名" required></td>
                    <td><input type="text" id="category" name="category" placeholder="カテゴリ" required></td>
                    <td><input type="text" id="contents" name="contents" placeholder="内容" required></td>
                    <td><input type="text" id="other" name="other" placeholder="備考欄" required></td>
                    <td>
                        <select name="process">
                            <option value="未着手">未着手</option>
                            <option value="10%">10%</option>
                            <option value="20%">20%</option>
                            <option value="30%">30%</option>
                            <option value="40%">40%</option>
                            <option value="50%">50%</option>
                            <option value="60%">60%</option>
                            <option value="70%">70%</option>
                            <option value="80%">80%</option>
                            <option value="90%">90%</option>
                            <option value="100%">100%</option>
                        </select>
                    </td>
                    <td>
                        <select name="attendance">
                            <option value="未登録">未登録</option>
                            <option value="出席">出席</option>
                            <option value="欠席">欠席</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="7" style="text-align:center;">
                        <input type="submit" name="ManualAction" value="登録">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</section>

    
    <section class="task-table">
     <h2>時間割登録(旧自動登録機能)<button type="button" onclick="openModal()" class="help-btn">？</button></h2>
     	<table>
     	
                <thead>
                    <tr>
                        <th>登録曜日</th>
                        <th>授業名</th>
                        <th>カテゴリ</th>
                        <th>内容</th>
                        <th>備考欄</th>
                        <th>締切りまでの日数</th>
                    </tr>
                </thead>
                <tbody>
	                <form action="insertServlet" method="post">
	                    <tr>
	                    	<input type="hidden" name="action" value="auto"/>
	                        <td>
		                        <select name="week">
		                            <option value="月曜日">月曜日</option>
		                            <option value="火曜日">火曜日</option>
		                            <option value="水曜日">水曜日</option>
		                            <option value="木曜日">木曜日</option>
		                            <option value="金曜日">金曜日</option>
		                            <option value="土曜日">土曜日</option>
		                            <option value="日曜日">日曜日</option>
		                        </select>
	                        </td>
	                        <td><input type="text" id="classs" name="classs" placeholder="授業名" required></td>
	                        <td><input type="text" id="category" name="category" placeholder="カテゴリ" required></td>
	                        <td><input type="text" id="contents" name="contents" placeholder="内容" required></td>
	                        <td><input type="text" id="other" name="other" placeholder="備考欄" required></td>
	                        <td><input type="number" id="deadprocess" name="deadprocess" placeholder="日数" required></td>
	                     
	                    </tr>
	                    <tr>
	                        <td colspan="8" style="text-align:center;">
	                            <input type="submit" name="AutoAction" value="登録">
	                        </td>
	                    </tr>
	                </form>
                </tbody>
         </table>
                
    </section>
    
    <section class="task-table">
            <h2>時間割</h2>
            <table>
                <thead>
                    <tr>
                        <th>登録用日</th>
                        <th>授業名</th>
                        <th>カテゴリ</th>
                        <th>内容</th>
                        <th>備考欄</th>
                        <th>締切りまでの日数</th>
                        <th>削除</th>
                    </tr>
                </thead>
                <tbody>
                	<%
					List<insertAuto> insert = (List<insertAuto>) request.getAttribute("insert");
				    if (insert != null) {
			        for (insertAuto stock : insert) {
			        %>
			        <tr>
			            <td><%= stock.getDeadline() %></td>
			            <td><%= stock.getClasss() %></td>
			            <td><%= stock.getCategory() %></td>
			            <td><%= stock.getContents() %></td>
			            <td><%= stock.getOther() %></td>
			            <td><%= stock.getDeadprocess() %></td>

			            <td>
			                <form action="deleteServlet" method="get"onsubmit="return confirmDelete();">
			                	<input type="hidden" name="action" value="auto"/>
			                    <input type="hidden" name="TaskId" value="<%=stock.getTaskId()%>"/>
			                    <input type="hidden" name="Username" value="<%= stock.getUserId()%>"/>
			                    <input type="submit" value="削除">
			                </form>
			            </td>
			        </tr>
			        <%
			        }
			        %>

                    
                </tbody>
            </table>
        </section>
    </main>
    <%
    } 
%>
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
 <script>
		function confirmDelete() {
		    return confirm("本当に削除してもよろしいですか？");
		}
		</script>
		
		<script>
		  
			  function openModal() {
				    document.getElementById("summerModal").classList.add("show");
				  }
			  function openManual() {
				    document.getElementById("summerManual").classList.add("show");
				  }

			  window.addEventListener("DOMContentLoaded", () => {
			    document.addEventListener("keydown", handleKeyPress);
			  });

			  function closeModal() {
			    document.getElementById("summerModal").classList.remove("show");
			    document.getElementById("summerManual").classList.remove("show");
			  }

			  window.addEventListener("DOMContentLoaded", () => {
			    document.addEventListener("keydown", handleKeyPress);
			  });
		</script>
		  
		<div id="summerModal" >
			<h2>「時間割登録(旧自動登録機能)」</h2>
			<p>毎週、課題が出される授業がある場合、「新規登録(Auto)」に登録しておくことで、自動で指定曜日にタスクを追加します。そのため、毎回タスクを新規登録する煩わしさを解消します。</p>	
			<p>ここで登録された内容は新規登録ページ下部の「登録中の課題一覧」に表示されます。</p>
			<p>追記：名称を"自動登録機能"から"時間割登録"に変更しました。</p>
			<button onclick="closeModal()">閉じる</button>
		</div>
		  
		<div id="summerManual" >
			<h2>「新規登録(manual)」</h2>
			<p>通常のタスクを一つ登録します。ここで登録された内容はホーム画面の「課題一覧」に表示されます。</p>	
			
			<button onclick="closeModal()">閉じる</button>
		</div>
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