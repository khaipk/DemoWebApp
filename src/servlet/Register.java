package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.CheckUser;
import connection.MyConnection;

@WebServlet("/register")
public class Register extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String contact = req.getParameter("contact");
		
		boolean register = false;
		CheckUser checkUser = new CheckUser();
		MyConnection myConnection = new MyConnection();
		try {
			Connection connection = myConnection.getConnection();
			register = checkUser.creatUser(connection, username, password, contact);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
			register = false;
		} catch (SQLException e) {
			System.out.println(e.toString());
			register = false;
		}
		if(register) {
			resp.sendRedirect("login");
		} else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
