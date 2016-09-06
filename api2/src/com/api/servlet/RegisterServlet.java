package com.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.model.user;


public class RegisterServlet extends HttpServlet {
	user us=new user();
	public RegisterServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		us.setId(/*request.getParameter("user")*/23);
		us.setUser(/*request.getParameter("user")*/"w");
		us.setEmail(/*request.getParameter("email")*/"123");
		us.setTel(/*request.getParameter("tel")*/"123");
		us.setUserimg(/*request.getParameter("userimg")*/"d:");
		us.setPassswd(request.getParameter(/*"passwd"*/"123"));
}
public user GetUser(){
	us.setId(/*request.getParameter("user")*/1);
	us.setUser(/*request.getParameter("user")*/"w");
	us.setEmail(/*request.getParameter("email")*/"123");
	us.setTel(/*request.getParameter("tel")*/"123");
	us.setUserimg(/*request.getParameter("userimg")*/"d:");
	us.setPassswd(/*request.getParameter("passwd"*/"123");
	return us;
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
}

	
	public void init() throws ServletException {
		
	}

}
