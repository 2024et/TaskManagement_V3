package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Beans.editBeans;
import Dao.editDao;


@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        
        String TaskId = request.getParameter("TaskId");
		String deadlineStr = request.getParameter("deadline");
		String classs = request.getParameter("classs");
		String category = request.getParameter("category");
		String contents = request.getParameter("contents");
		String other = request.getParameter("other");
		String process = request.getParameter("process");
		String attend = request.getParameter("attend");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date deadline = null;

		try {
		    if (deadlineStr != null && !deadlineStr.isEmpty()) {
		        deadline = sdf.parse(deadlineStr);
		    }
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		editBeans inputData = new editBeans(TaskId,deadline,classs,category,contents,other,process,attend,username);
		
		request.setAttribute("default", inputData);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
		
		
		
		String TaskId = request.getParameter("TaskId");
		String deadlineStr = request.getParameter("deadline");
		String classs = request.getParameter("classs");
		String category = request.getParameter("category");
		String contents = request.getParameter("contents");
		String other = request.getParameter("other");
		String process = request.getParameter("process");
		String attend = request.getParameter("attend");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date deadline = null;

		try {
		    if (deadlineStr != null && !deadlineStr.isEmpty()) {
		        deadline = sdf.parse(deadlineStr);
		    }
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		
		editBeans inputData = new editBeans(TaskId,deadline,classs,category,contents,other,process,attend,username);
		
		editDao dao = new editDao();
		boolean flag = dao.UpdateData(inputData);
		
		
		if(flag) {
			response.sendRedirect("indexServlet");
		}else {
			request.setAttribute("message", "エラー。タスク編集に失敗しました。");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
