package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Girl;

public class CheckGirl {
	
	 
	
	public List<Girl> getList(Connection connection) throws SQLException{
		List<Girl> list = new ArrayList<>();
		
		String sqlCommand = "Select * from `girl_data`";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sqlCommand);
		
		while(rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			int year = rs.getInt("Year");
			String address = rs.getString("Address");
			list.add(new Girl(code, name, year, address));
		}
		
		return list;
	}
	
	public boolean addGirl(Connection connection, String code, String name, int year, String address) throws SQLException {
		
		String sqlCommand = "Insert into `girl_data` value(?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, code);
		pst.setString(2, name);
		pst.setInt(3, year);
		pst.setString(4, address);
		
		if(pst.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	public boolean editGirl(Connection connection, String code, String name, int year, String address) throws SQLException {
		
		String sqlCommand = "Update `girl_data` set Name=?, Year=?, Address=? where Code=?";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, name);
		pst.setInt(2, year);
		pst.setString(3, address);
		pst.setString(4, code);
		
		if(pst.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteGirl(Connection connection, String code) throws SQLException {
		
		String sqlCommand = "Delete from `girl_data` where Code=?";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, code);
		
		if(pst.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	public Girl findInfoGirl(Connection connection, String code) throws SQLException {
		Girl girl = null;
		
		String sqlCommand = "Select * from `girl_data` where Code=?";
		PreparedStatement pst = connection.prepareStatement(sqlCommand);
		pst.setString(1, code);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("Name");
			int year = rs.getInt("Year");
			String address = rs.getString("Address");
			girl = new Girl(code, name, year, address);
		}
		return girl;
	}
}
