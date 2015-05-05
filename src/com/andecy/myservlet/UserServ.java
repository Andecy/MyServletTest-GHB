package com.andecy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServ extends HttpServlet {
	int i =0;
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("Name");
		String pwd = request.getParameter("Pwd");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("    your account   is£º "+name);
		System.out.println("    your password  is£º "+pwd);
		System.out.println("    your LoginTime is:  "+(i++));
		if (name.equals("xiaoming") && pwd.equals("12345")) {
			
			out.print("1");
		} else {
			
			out.print("0");
		}
		out.flush();
		out.close();
	}

}
