package com.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.model.noteclass;
import com.api.model.user;


public class addNoteclassServlet extends HttpServlet {

	noteclass ns=new noteclass();
	public addNoteclassServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	public noteclass GetNoteclass(){
		ns.setId(/*request.getParameter("user")*/2);
		ns.setClassname(/*request.getParameter("user")*/"w");
		ns.setClassdesc(/*request.getParameter("email")*/"123");
		ns.setArticlenum(/*request.getParameter("tel")*/123);
		ns.setUserid(2);
		
		return ns;
			
		}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void init() throws ServletException {
		
	}

}
