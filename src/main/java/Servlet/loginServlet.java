package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Beans.loginBeans;
import Logic.loginLogic;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		loginBeans input_data = new loginBeans(username, pass);
		
		loginLogic logic = new loginLogic();
		boolean flag = logic.LoginL(input_data); 
		
		if(flag) {
			System.out.println("でーきた");
			session.setAttribute("username", username);
			response.sendRedirect("indexServlet");
			
		} else {
			System.out.println("ログインに失敗しました。");
			request.setAttribute("errorMessage", "ユーザー名またはパスワードが違います。");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
