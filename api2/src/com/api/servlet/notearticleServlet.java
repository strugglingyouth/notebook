package com.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.model.notearticle;
import com.api.model.noteclass;
import com.api.model.user;


public class notearticleServlet extends HttpServlet {

	notearticle nc=new notearticle();
	public notearticleServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	public notearticle GetNotearticle(){
		nc.setId(196);
		nc.setClassid(1);
		nc.setUserid(1);
		nc.setTitle("计算机组成原理");
		nc.setDate("2012-09-08 12:12:12");
		nc.setModified("2012-09-08 12:12:12");
		nc.setDescs("计算机类书籍");
		nc.setContent("计算：    ");
		return nc;
			
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
