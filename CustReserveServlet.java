package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ConnectionUtil;
import com.revature.LoginDao;
import com.revature.beans.LoginCreds;

@WebServlet("/CustomerReseration")
public class CustReserveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//Creates or retrieves current session
		
		
		
			HttpSession session = req.getSession();
			
			ObjectMapper mapper = new ObjectMapper();
			
			LoginCreds LC = mapper.readValue(req.getInputStream(), LoginCreds.class);
			
			String Username = LC.getUsername(); // get user name from input stream 
			String Password = LC.getPassword(); // get pw from input stream
			
			PrintWriter pw = resp.getWriter();
			
			
			
			//LoginDao LDAO = new LoginDao(); insert
	
	
	
	

}
}