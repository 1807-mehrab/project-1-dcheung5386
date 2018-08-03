package com.revature;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;



public class ContactUsDao {
	public void inputContactForm(String CONTACTFORM) throws SQLException, IOException {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) { //try get connection
		
			String sql = "{CALL SP_CREATE_COMMENT(?)}"; // do select all from table
			cs = conn.prepareCall(sql); //turns sql into  statement 
			//cs.setString(1, Email);
		 cs.setString(1, CONTACTFORM);
			
		 cs.execute();
		
			
			
			
			
			cs.close();	
		 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		
	
	}
}

