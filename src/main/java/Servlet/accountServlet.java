package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Beans.accountBeans;
import Dao.accountDao;

@WebServlet("/accountServlet")
public class accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		//正規化と重複チェック
		if(!pass1.equals(pass2)) {
			request.setAttribute("errorMessage", "パスワードが異なります。");
		    request.getRequestDispatcher("/account.jsp").forward(request, response);
			return;
		}
		
		accountDao dao = new accountDao();
		boolean IDFlag = dao.Duplication(username);
		
		
		
		if(IDFlag) {
			request.setAttribute("errorMessage", "すでにこのユーザー名は使われています。別のIDを設定してください。");
		    request.getRequestDispatcher("/account.jsp").forward(request, response);
		    return;
		}
		
		
		accountBeans inputData = new accountBeans(username,pass1);
		
		boolean flag = dao.RegistData(inputData);
		
		
		if(flag) {
			response.sendRedirect("loginServlet");
		}else {
			response.sendRedirect("accountServlet");
		}
	}

}
