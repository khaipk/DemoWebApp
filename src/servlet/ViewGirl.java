package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Girl;
import connection.CheckGirl;
import connection.MyConnection;

@WebServlet("/view-girl")
public class ViewGirl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");

		if(username == null) {
			resp.sendRedirect("login");
		} else {
			List<Girl> list = new ArrayList<Girl>();

			MyConnection myConnection = new MyConnection();
			CheckGirl checkGirl = new CheckGirl();
			try {
				Connection connection = myConnection.getConnection();
				list = checkGirl.getList(connection);
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.toString());
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
			req.setAttribute("list", list);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/viewGirl.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
