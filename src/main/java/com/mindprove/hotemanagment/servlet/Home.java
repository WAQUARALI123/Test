package com.mindprove.hotemanagment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindprove.hotemanagment.dto.HotelDTO;
import com.mindprove.hotemanagment.service.HotelService;

@WebServlet("/homee")
public class Home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		

		out.println("<html>");
		
		out.println("<head>");
		
		out.println("</head>");
		
		out.println("<form action= '/HotelManagment/homee' method= 'post'>");
		
		out.println("<label for ='name'>Name :</label>");
		out.println("<input type='text' name=name>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for ='name'> Email :</label>");
		out.println("<input type ='text' name=email>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for='name'> Address :</label>");
		out.println("<input type ='text' name=address>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for= 'name'> Phone :</label>");
		out.println("<input type= 'text' name=phone>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<label for ='name'> FeedBack :</label>");
		out.println("<input type ='text' name=feedback>");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<input type='submit' value= 'regester'>");
		
		out.println("</form>");
		out.println("</html>"); 
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		
		 String name= req.getParameter("name");
		 String email= req.getParameter("email");
		 String address= req.getParameter("address");
		 String phone= req.getParameter("phone");
		 String feedback= req.getParameter("feedback");
		
		 
		 HotelDTO data= new HotelDTO();
		 
		 data.setName(name);
		 data.setEmail(email);
		 data.setAddress(address);
		 data.setPhone(phone);
		 data.setFeedback(feedback);
		 
		 
		 HotelService service =new HotelService();
		 
		boolean isregister =service.save(data);
		
		if(isregister) {
			
			out.println("<h1> regester successfullyyyy");
		}
		else {
			
			out.println("<h1> regester not  successfullyyy");
		}
		
	}
	
}
