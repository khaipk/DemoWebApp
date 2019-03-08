package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class CheckUser {
	
	public User findUser(Connection connection, String username, String password) throws SQLException {
		User user = null;
		
		String sqlCommand = "Select a.Username, a.Password, a.Contact from `user_data` a where a.Username=? and a.Password=?";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String contact = rs.getString("Contact");
			user = new User(username, password, contact);
		}
		return user;
	}
	
	public boolean creatUser(Connection connection, String username, String password, String contact) throws SQLException {
		
		String sqlCommand = "Insert into `user_data` value(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, username);
		pst.setString(2, password);
		pst.setString(3, contact);
		
		if(pst.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	public boolean changePassword(Connection connection, String username, String password) throws SQLException {
		
		String sqlCommand = "Update `user_data` set Password=? where Username=?";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, password);
		pst.setString(2, username);
		
		if(pst.executeUpdate()>0) {
			return true;
		}
		return false;
	}
}
