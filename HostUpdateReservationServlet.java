package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.AdminUpdateReservationDao;


import com.revature.beans.ReservationBeans;

public class HostUpdateReservationServlet extends HttpServlet {//specfically made to approve or decline reservations VIEW ALL RESERVATION
	//possibly from html select , to ajax function that send to here

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//Creates or retrieves current session
		
			HttpSession session = req.getSession();
			
			ObjectMapper mapper = new ObjectMapper();
			
			ReservationBeans RB = mapper.readValue(req.getInputStream(), ReservationBeans.class);
			
			int ReservationID = RB.getReservationID();  // reservation from ajax is not made
			String Status = RB.getStatus(); // get pw from ajax
			
			PrintWriter pw = resp.getWriter();
			
			AdminUpdateReservationDao adrd = new AdminUpdateReservationDao ();
			
			//now i have to implement dao to send values to database
			
			adrd.sendSQL(ReservationID, Status);
			
			//now sql should update , should refresh 
}
}