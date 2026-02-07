package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Beans.insertAuto;
import Beans.insertBeans;
import Dao.insertDao;

@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        
        insertDao dao = new insertDao();
	    List<insertAuto> list = dao.GetData(String.valueOf(username));
	    

        request.setAttribute("insert", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("insert.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        
		String action = request.getParameter("action");
		
        
		if(action.contains("manual")) {
			Random rand = new Random();
			String id = String.format("%06d", rand.nextInt(1000000));
			
			String deadlineStr = request.getParameter("deadline");
			String classs = request.getParameter("classs");
			String category = request.getParameter("category");
			String contents = request.getParameter("contents");
			String other = request.getParameter("other");
			String process = request.getParameter("process");
			String attend = request.getParameter("attendance");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date deadline = null;

			try {
			    if (deadlineStr != null && !deadlineStr.isEmpty()) {
			        deadline = sdf.parse(deadlineStr);
			    }
			} catch (ParseException e) {
			    e.printStackTrace();
			}

			
			insertBeans inputData = new insertBeans(id,deadline,classs,category,contents,other,process,attend,username);
			
			insertDao dao = new insertDao();
			boolean flag = dao.RegistData(inputData);
			
			
			if(flag) {
				response.sendRedirect("indexServlet");
			}else {
				request.setAttribute("message", "エラー。通常タスク登録に失敗しました。");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else {			
			Random rand = new Random();
			String id = "A"+String.format("%06d", rand.nextInt(1000000));
			
			String week = request.getParameter("week");
			String classs = request.getParameter("classs");
			String category = request.getParameter("category");
			String contents = request.getParameter("contents");
			String other = request.getParameter("other");
			String deadprocess = request.getParameter("deadprocess");
			
			insertAuto inputData = new insertAuto(id,week,classs,category,contents,other,deadprocess,username);
			
			insertDao dao = new insertDao();
			boolean flag = dao.AutoRegistData(inputData);
			
			
			if(flag) {
				response.sendRedirect("insertServlet");
			}else {
				request.setAttribute("message", "エラー。自動登録タスク登録に失敗しました。");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}
	}

}
