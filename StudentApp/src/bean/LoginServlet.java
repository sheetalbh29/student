package bean;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoClass;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	HttpSession session=request.getSession(true);
	String name=request.getParameter("name");
	String pass=request.getParameter("password");
	DaoClass dao=new DaoClass();
	try {
		boolean check=dao.CheckStudent(name,pass);
		if(check) {
			session.setAttribute("name", name);
			response.sendRedirect("StudentData.jsp");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}

}
