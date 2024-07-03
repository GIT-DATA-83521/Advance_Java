package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	private String color ="";
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("Init third called");
		color = config.getInitParameter("color");
	}
	@Override
	public void destroy() {
		
		System.out.println("Destroy third called");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Get third called");
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Post third called");
		processRequest(req, resp);
	}
protected void processRequest(HttpServletRequest req , HttpServletResponse resp) throws  ServletException ,IOException{
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Third servlet</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>\n" , color);
		out.println("<h1>Hello Third servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
