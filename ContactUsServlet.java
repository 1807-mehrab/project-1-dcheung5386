package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ContactUsDao;

import com.revature.beans.ContactFormBean;
import com.revature.beans.LoginCreds;



@WebServlet("/Sent")
public class ContactUsServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println();
		HttpSession session = req.getSession();
		//session.setAttribute(name, value);
		ObjectMapper mapper = new ObjectMapper();
		ContactFormBean CFM = mapper.readValue(req.getInputStream(), ContactFormBean.class);
		String Comment = CFM.getContactForm();
		PrintWriter pw = resp.getWriter();
		
		ContactUsDao CUD = new ContactUsDao();
		//HttpSession session = req.getSession();
		
		//ObjectMapper mapper = new ObjectMapper();
		//LoginCreds LC = mapper.readValue(req.getInputStream(), LoginCreds.class);
		
		//String Username = LC.getUsername(); // get user name from ajax
	//	String Password = LC.getPassword();
		
	
		
	
 
		
			try {
				CUD.inputContactForm(Comment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
}
}