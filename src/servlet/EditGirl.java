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

import connection.CheckGirl;
import connection.MyConnection;

@WebServlet("/edit-girl")
public class EditGirl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("code");
		req.setAttribute("code", code);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/editGirl.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		boolean update = false;
		String code = req.getParameter("code");
		String name = req.getParameter("name");
		int year = Integer.parseInt(req.getParameter("year"));
		String address = req.getParameter("address");
		
		MyConnection myConnection = new MyConnection();
		CheckGirl checkGirl = new CheckGirl();
		System.out.println(code+name+year+address);
		try {
			Connection connection = myConnection.getConnection();
			update = checkGirl.editGirl(connection, code, name, year, address);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
			update = false;
		} catch (SQLException e) {
			System.out.println(e.toString());
			update = false;
		}
		
		if(update) {
			resp.sendRedirect("view-girl");
		} else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/editGirl.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
