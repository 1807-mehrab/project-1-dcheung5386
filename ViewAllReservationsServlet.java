package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.LoginDao;
import com.revature.beans.LoginCreds;

import javax.servlet.annotation.WebServlet;

@WebServlet("/loggingIn")

public class ViewAllReservationsServlet extends HttpServlet { // note did not make a ajax call ? pending 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) //use get
			throws ServletException, IOException {
			//Creates or retrieves current session
		
		
		
			HttpSession session = req.getSession();
			
			ObjectMapper mapper = new ObjectMapper();
			
			LoginCreds LC = mapper.readValue(req.getInputStream(), LoginCreds.class);
			
			String Username = LC.getUsername(); // get user name from ajax
			String Password = LC.getPassword(); // get pw from ajax
			
			System.out.println(Username);
			
			
			PrintWriter pw = resp.getWriter();
			
			
			
			LoginDao LDAO = new LoginDao();
	
	

}
