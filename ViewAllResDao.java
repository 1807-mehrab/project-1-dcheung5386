package com.revature;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReservationBeans;

public class ViewAllResDao {
	
	public List<String> getAllReservations(){

		PreparedStatement ps = null;
		String c = null;
		List<String> Reservations = new ArrayList <String>(); 
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM CUST_RESERVE";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			String username = rs.getString("CUSTO_ID_FK"); //Reservation
				String fname = rs.getString("Fname"); //input table names
				String lname = rs.getString("lname"); //reservation_id ,custo_id_fk, roomid_fk, room_type_fk,Fname,lname,Date_in,date_out) values (1,'derricktest','12','DELUXE','Derrick','Test',01012018,02022018) 

				Date datein = rs.getDate("Date_in");
				Date dateout = rs.getDate("date_out");
				String roomtype = rs.getString("room_type");
				int roomid = rs.getInt("roomid"); //will be inputted by host , will usually be null until host place them in a room 
				String status = rs.getString("status"); //** should be pending when originally sent 
				
				while (rs.next()) {
				c = new ReservationBeans(username, fname, lname, datein, dateout, roomtype, roomid, status); //no work
				Reservations.add(c);
			}
			
			rs.close();
			ps.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return Reservations;
	
	}

}
