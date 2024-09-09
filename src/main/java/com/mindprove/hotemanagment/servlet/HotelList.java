package com.mindprove.hotemanagment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

@WebServlet("/homelist")
public class HotelList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 PrintWriter out=resp.getWriter();
	 resp.setContentType("text/html");
	 
	 try {
		 
		 Connection con =null;
		 PreparedStatement ps=null;
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 System.out.println("load the driver");
		 
 
	
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
	 System.out.println("connection created successfully");
	 
	 ps=con.prepareStatement("SELECT * from hoteldata ");
	 
	 ResultSet rs= ps.executeQuery();
	 
	rs.next();
	
	while(rs.next()) {
		
	  String name= rs.getString(1);
	   String email= rs.getString(2);
	   String address= rs.getString(3);
	  String phone= rs.getString(4);
	  String feedback= rs.getString(5);
	  
	  out.println("<h1>"+ name +"<h1>");
	  out.println("<h1>"+ email +"<h1>");
	  out.println("<h1>"+ address +"<h1>");
	 out.println("<h1>"+ phone +"<h1>");
	 out.println("<h1>"+ feedback +"<h1>");
	 
	}
	 
	 }
	 catch(Exception  e) {
		 
		 
		 
	 }
		
	}
	

}
