package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Beans.indexBeans;
import Dao.indexDao;

@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	String username = (String) session.getAttribute("username");

	    request.setAttribute("username", username);
	    
	    
	    
	    indexDao dao = new indexDao();
	    List<indexBeans> list = dao.GetData(String.valueOf(username));
	    
	    List<indexBeans> noStarted = new ArrayList<>();
	    List<indexBeans> inProgress = new ArrayList<>();
	    List<indexBeans> nearDeadline = new ArrayList<>();
	    List<indexBeans> overDue = new ArrayList<>();
	    
	    Date today = new Date();
	    

	    Calendar cal = Calendar.getInstance();
	    cal.setTime(today);
	    cal.add(Calendar.DAY_OF_MONTH, 2);
	    Date twoDaysLater = cal.getTime();
	    
	    for(indexBeans bean : list) {
	    	if(bean.getProcess().contains("未着手")) {
	    		noStarted.add(bean);
	    	}else {
	    		inProgress.add(bean);
	    	}
	    	
	    	if(bean.getDeadline().before(today)) {
	    		overDue.add(bean);
	    	}else if(bean.getDeadline().after(today) && bean.getDeadline().before(twoDaysLater)){
	    		nearDeadline.add(bean);
	    	}
	    }
	    
	    request.setAttribute("noStarted", noStarted);
	    request.setAttribute("inProgress", inProgress);
	    request.setAttribute("nearDeadline", nearDeadline);
	    request.setAttribute("overDue", overDue);

        request.setAttribute("index", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
