package com.revature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerQueryBeans;
import com.revature.beans.CustomerQueryResult;

public class CustomerQueryDao {
	public static String CUSTOMERID = "derricktest";
	public CustomerQueryBeans getCustInfo(String CustomerID) {

		PreparedStatement ps = null;
		CustomerQueryBeans c = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT FNAME, LNAME ,EMAIL FROM CUSTOMER_CREDS where CUSTOMERID = ?";
			ps = conn.prepareStatement(sql);
			
		
			ps.setString(1, CustomerID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String Fname = rs.getString("FNAME");
				System.out.println("FNAME");
				String Lname = rs.getString("LNAME");
				String Email = rs.getString("EMAIL");
				
				c = new CustomerQueryBeans(Fname, Lname, Email);
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return c;
	}
}
