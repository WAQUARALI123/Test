package com.mindprove.hotemanagment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mindprove.hotemanagment.dto.HotelDTO;

public class HotelService {

	public boolean save(HotelDTO hoteldto) {
		
		Connection con=null;
		PreparedStatement ps=null;
		
	    try {
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load the Driver");
				
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
			 System.out.println("connection created successfully");
   
	ps = con.prepareStatement("INSERT INTO hoteldata(name, email, address, phone, feedback) VALUES (?, ?, ?, ?, ?)");

	
	ps.setString(1, hoteldto.getName());
	ps.setString(2, hoteldto.getEmail());
	ps.setString(3, hoteldto.getAddress());
	ps.setString(4, hoteldto.getPhone());
	ps.setString(5, hoteldto.getFeedback());
	
	int row= ps.executeUpdate();
	
	return row>0;
	
	    }
	    catch(Exception e) {
	    
	    e.printStackTrace();
	    }
		
		
      return false;
	}	
	
	
	
	
	}


