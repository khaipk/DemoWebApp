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
import javax.servlet.http.HttpSession;

import connection.CheckUser;
import connection.MyConnection;

@WebServlet("/change-password")
public class ChangePassword extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/changePassword.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String password = req.getParameter("newPassword");
		String rePassword = req.getParameter("rePassword");

		// while re-password is not correct 
		if(!password.equals(rePassword)) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/changePassword.jsp");
			dispatcher.forward(req, resp);
		} else {
			// start change password
			boolean update = false;
			CheckUser checkUser = new CheckUser();
			MyConnection myConnection = new MyConnection();
			try {
				Connection connection = myConnection.getConnection();
				update = checkUser.changePassword(connection, username, rePassword);

			} catch (ClassNotFoundException e) {
				System.out.println(e.toString());
				update = false;
			} catch (SQLException e) {
				System.out.println(e.toString());
				update = false;
			}
			// change success, send to user info
			if(update) {
				resp.sendRedirect("user-info");
			// fail, re-change	
			} else {
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/changePassword.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}
}
