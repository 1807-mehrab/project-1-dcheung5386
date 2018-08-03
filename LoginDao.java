package com.revature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class LoginDao {
	public boolean getUserName(String username) {
	System.out.println("moved from servlet to dao");
	PreparedStatement ps = null;
	
	List<String> Users  = new ArrayList <String>();
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "SELECT * FROM CUSTOMER_CREDS"; // check table name
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			String name = rs.getString("CUSTOMER_ID"); // column name
			Users.add(name);
			
		}
		System.out.println("Users");
		rs.close();
		ps.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	
	if(Users.contains(username)) {
	boolean	Dowork = true;
		return Dowork; //returns true if user is right
	}
	else {
	boolean	Dowork = false;
		return Dowork;
	}
}


	
	
	
	public String getPassword(String username) {
		PreparedStatement ps = null;
		
		String pw = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT CUSTPW FROM CUSTOMER_CREDS where  = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				pw = rs.getString("CUSTPW"); // column name
				
			}
			
			
			
		
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return pw;
		
	}
	
	
	

}

/*public int getHotelNumber(int ROOMID) {
	PreparedStatement ps = null;
	
	int result = 0;
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "SELECT ROOMID FROM RESERVATIONID where USERNAME = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, ROOMID);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			 result = rs.getInt("ROOMID");
			 
			
		}
		
		rs.close();
		ps.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	
	return result;
*/






