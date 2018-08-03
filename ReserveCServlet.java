package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.beans.ReservationBeans;

@WebServlet("/sendRes")
public class ReserveCServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Creates or retrieves current session
System.out.println("1");
		// HttpSession session = req.getSession();

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("2");
		ReservationBeans Res = mapper.readValue(req.getInputStream(), ReservationBeans.class);
		System.out.println("3");
		String Username = Res.getUsername();
		String FName = Res.getFname();
		String LName = Res.getLname();
		Date Datein = Res.getDatein();
		Date Dateout = Res.getDateout();
		String RoomType = Res.getRoomtype();

		System.out.println(Username);
		System.out.println(FName);
		System.out.println(LName);
		System.out.println(Datein);
		System.out.println(Dateout);
		System.out.println(RoomType);

		 PrintWriter pw = resp.getWriter();

	}
}
