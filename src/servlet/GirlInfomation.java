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

import beans.Girl;
import connection.CheckGirl;
import connection.MyConnection;

@WebServlet("/girl-info")
public class GirlInfomation extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("code");
		Girl girl = null;
		CheckGirl checkGirl = new CheckGirl();
		MyConnection myConnection = new MyConnection();
		try {
			Connection connection = myConnection.getConnection();
			girl = checkGirl.findInfoGirl(connection, code);
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		if(girl != null) {
			req.setAttribute("code", code);
			req.setAttribute("name", girl.getName());
			req.setAttribute("year", girl.getYear());
			req.setAttribute("address", girl.getAddress());
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/girlInfo.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
