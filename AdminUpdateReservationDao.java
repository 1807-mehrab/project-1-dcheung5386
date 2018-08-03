package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class AdminUpdateReservationDao { // change default pending status to approve or decline 

	public boolean sendSQL(int ReservationID, String Status) {
	CallableStatement cs = null;
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "{CALL SP_UPDATE_RESERVATION(?,?)}"; 
		// make sql Stored proc like" 	
		//CREATE OR REPLACE PROCEDURE SP_ADMIN_UPDATE_RES
		//(ReservationID IN Number , Status IN varchar2) AS
		//BEGIN
		  //  --SAVEPOINT; --Needed for rollback if you want to test the procedure without commiting data
		    //
		
		//UPDATE reservationid <----table
		//SET  Status=(Status)
		//		WHERE Reservation=(reservationid);

		   // --ROLLBACK
		   // COMMIT;
		//END;
		cs = conn.prepareCall(sql);
		cs.setInt(1, ReservationID);//
		cs.setString(2, Status);    //
		
		
		Boolean result = cs.execute();
		if (!result) {
			System.out.println("Table succes");
			
		} else {
			System.out.println("Failed");
		}
		
		cs.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	return false;
}
	}
