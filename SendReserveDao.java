package com.revature;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class SendReserveDao { //insert reservations!!
	public String inputResForm( 
			String Username,
			String FName,
			String Lname,
			Date Datein ,
			Date Dateout,
			String RoomType) throws SQLException, IOException {
				CallableStatement cs = null;
		
					try(Connection conn = ConnectionUtil.getConnection()) { //try get connection
		
			String sql = "{CALL SP_SEND_RES(?,?,?,?,?,?)}"; //make a sql statement that inserts 6 types with a 7th element that always inputs "pending"
															// varchar , varchar, varchar, date ,date,date,varchar
			cs = conn.prepareCall(sql); //turns sql into  statement 
			//cs.setString(1, Email);
		 cs.setString(1, Username);
		 cs.setString(2, FName);
		 cs.setString(3, Lname);
		 cs.setDate(4, Datein);
		 cs.setDate(5, Dateout);
		 cs.setString(6, RoomType);
			
		 cs.execute();
		
			
			cs.close();	
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		
		return("sent");
		
	
	}
}

