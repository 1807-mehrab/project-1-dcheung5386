package com.revature.servlets;

import javax.servlet.annotation.WebServlet;
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
import com.revature.GetReserveDao;

import com.revature.beans.LoginCreds;
import com.revature.beans.GetReservationBeans;


@WebServlet("/Getreserve")
public class GetReservationServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
			//Creates or retrieves current session
		
		
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//Creates or retrieves current session
			
			
			
			
				
				

}
}