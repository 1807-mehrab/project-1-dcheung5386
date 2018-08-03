package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetReserveDao {
	public List<String> getReservation(String username) throws SQLException, IOException {

	PreparedStatement ps = null;
	
	List<String> Reservations  = new ArrayList <String>();
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "SELECT custo_id_fk, roomid_fk, room_type_fk,Fname,lname,Date_in,date_out FROM cust_reserve where USERID = ?"; // check table name
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		 
		ps.setString(1, username);
		
			while (rs.next()) {
			
			String gotRes = rs.getString("custo_id_fk, roomid_fk, room_type_fk,Fname,lname,Date_in,date_out"); // column name
			
				
				 // column name
				Reservations.add(gotRes);
				
			}
			
		}
	return Reservations;

}
}
