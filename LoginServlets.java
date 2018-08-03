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
import com.revature.LoginDao;
import com.revature.beans.LoginCreds;
import com.revature.beans.LoginResult;


@WebServlet("/loggingIn")
        
public class LoginServlets extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;
	
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		
			System.out.println("GET: login worked.");
			
		}*/
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
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
			
	

	
			/*if(LDAO.getUserName(Username)) { 
				
				String realpassword = LDAO.getPassword(Username);
				if(Password.equals(realpassword)) {
					session.setAttribute("username", Username);
					LoginResult LR = new LoginResult("true");
					String outputstring = mapper.writeValueAsString(LR);
					
					pw.println(outputstring);
					
				} else {
					LoginResult LR = new LoginResult("false");
					String outputstring = mapper.writeValueAsString(LR);
					pw.println(outputstring);
				}
			} else {
				LoginResult LR = new LoginResult("false");
				String outputstring = mapper.writeValueAsString(LR);
				pw.println(outputstring);
			*/

			
			
			if(LDAO.getUserName(Username) == true ) { 
				System.out.println("hi world");
				
				if(Password.equals(LDAO.getPassword(Username))) {
					session.setAttribute("username", Username);
					LoginResult LR = new LoginResult(true);
					String outputstring = mapper.writeValueAsString(LR);
					
					
					pw.println(outputstring);
					//old code ? pw.println(outputstring);
					
				} else {
					LoginResult LR = new LoginResult(false);
					String outputstring = mapper.writeValueAsString(LR);
					System.out.println(outputstring +"2");
					pw.println(outputstring);
				}
			} else {
				LoginResult LR = new LoginResult(false);
				String outputstring = mapper.writeValueAsString(LR);
				System.out.println(outputstring + "3");
				pw.println(outputstring);
			}
		}	
		}
			

	