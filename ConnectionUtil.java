package com.revature;
import java.io.*;
import java.sql.*;
//import java.util.Properties;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, IOException {
	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	return DriverManager.getConnection(
			"jdbc:oracle:thin:@hotelapp.cgn5sd7fgfd0.us-east-2.rds.amazonaws.com:1521:ORCL"
			, "dcheung5386"
			, "Password");
	
	
	
	
}
}