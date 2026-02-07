<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="Beans.indexBeans" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校課題管理アプリ</title>
<link rel="stylesheet" href="style.css">
<style>
	footer {
        background: #333;
        color: white;
        padding: 15px;
        text-align: center;
    }
</style>
<link rel="icon" href="icon.ico">
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
        <section class="task-sections">
            <div class="task-box">
			    <h2>未着手課題</h2>
			    <div class="task-list">
			        <table>
			        <%
			            List<indexBeans> noStarted = (List<indexBeans>) request.getAttribute("noStarted");
			            if (noStarted != null) {
			                for (indexBeans start : noStarted) {
			        %>
			            <tr>
			                <td><%= start.getClasss() %></td>
			            </tr>
			        <%
			                }
			            }
			        %>
			        </table>
			    </div>
			</div>

            <div class="task-box">
                <h2>進行中課題</h2>
                <div class="task-list">
                   	<table>
			        <%
			            List<indexBeans> inProgress = (List<indexBeans>) request.getAttribute("inProgress");
			            if (inProgress != null) {
			                for (indexBeans progress : inProgress) {
			        %>
			            <tr>
			                <td><%= progress.getClasss() %></td>
			            </tr>
			        <%
			                }
			            }
			        %>
			        </table>
                </div>
            </div>
            <div class="task-box">
                <h2>締切間近の課題</h2>
                <div class="task-list">
                    <table>
			        <%
			            List<indexBeans> nearDeadline = (List<indexBeans>) request.getAttribute("nearDeadline");
			            if (nearDeadline != null) {
			                for (indexBeans near : nearDeadline) {
			        %>
			            <tr>
			                <td><%= near.getClasss() %></td>
			            </tr>
			        <%
			                }
			            }
			        %>
			        </table>
                </div>
            </div>
            <div class="task-box">
                <h2>締切超過中の課題</h2>
                <div class="task-list">
                    <table>
			        <%
			            List<indexBeans> overDue = (List<indexBeans>) request.getAttribute("overDue");
			            if (overDue != null) {
			                for (indexBeans over : overDue) {
			        %>
			            <tr>
			                <td><%= over.getClasss() %></td>
			            </tr>
			        <%
			                }
			            }
			        %>
			        </table>
                </div>
            </div>
        </section>
        
        <section class="task-table">
            <h2>課題一覧</h2>
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
                        <th>編集</th>
                        <th>削除</th>
                    </tr>
                </thead>
                <tbody>
					<%
					List<indexBeans> index = (List<indexBeans>) request.getAttribute("index");
				    if (index != null) {
			        for (indexBeans stock : index) {
			        %>
			        <tr>
			            <td><%= stock.getDeadline() %></td>
			            <td><%= stock.getClasss() %></td>
			            <td><%= stock.getCategory() %></td>
			            <td><%= stock.getContents() %></td>
			            <td><%= stock.getOther() %></td>
			            <td><%= stock.getProcess() %></td>
			            <td><%= stock.getAttend() %></td>
			            <td>
			                <form action="editServlet" method="get">
			                    <input type="hidden" name="TaskId" value="<%=stock.getTaskId()%>"/>
			                    <input type="hidden" name="deadline" value="<%=stock.getDeadline()%>"/>
			                    <input type="hidden" name="classs" value="<%=stock.getClasss()%>"/>
			                    <input type="hidden" name="category" value="<%=stock.getCategory()%>"/>
			                    <input type="hidden" name="contents" value="<%=stock.getContents()%>"/>
			                    <input type="hidden" name="other" value="<%=stock.getOther()%>"/>
			                    <input type="hidden" name="process" value="<%=stock.getProcess()%>"/>
			                    <input type="hidden" name="attend" value="<%=stock.getAttend()%>"/>
			                    <button type="submit" name="action" value="編集">
						        	<img src="edit.png" alt="編集アイコン" width="16" height="16">
							        編集
							    </button>
			                   
			                </form>
			            </td>
			            <td>
			                <form action="deleteServlet" method="get"onsubmit="return confirmDelete();">
			                	<input type="hidden" name="action" value="sama"/>
			                    <input type="hidden" name="TaskId" value="<%=stock.getTaskId()%>"/>
			                    <input type="hidden" name="Username" value="<%= request.getAttribute("username") %>"/>
			                    <button type="submit"  value="削除">
						        	<img src="trush.png" alt="削除アイコン" width="16" height="16">
							        削除
							    </button>
			                </form>
			            </td>
			        </tr>
			        <%
			        }
			        %>
                    
                </tbody>
            </table>
        </section>
        <script>
		function confirmDelete() {
		    return confirm("本当に削除してもよろしいですか？");
		}
		</script>
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