package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.editDao;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TaskId = request.getParameter("TaskId");
		String User = request.getParameter("Username");
		String action = request.getParameter("action");
		System.out.println("取得");
		boolean flag;
		editDao dao = new editDao();
		if(action.contains("sama")) {
			flag = dao.Delete(TaskId,User);
		}else {
			flag = dao.DeleteAuto(TaskId,User);
		}
		
		if(flag) {
			if(action.contains("sama")) {
				response.sendRedirect("indexServlet");
			}else {
				response.sendRedirect("insertServlet");
			}
			
		}else {
			if(action.contains("sama")) {
				request.setAttribute("message", "エラー。通常タスクの削除に失敗しました。");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "エラー。自動登録タスクの削除に失敗しました。");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
