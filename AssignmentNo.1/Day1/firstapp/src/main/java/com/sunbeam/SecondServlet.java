package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value ="/ha" , loadOnStartup = 8,
initParams = { @WebInitParam(name = "color" , value = "pink")})

public class SecondServlet extends HttpServlet{
	private String color ="";
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init second called");
		color = config.getInitParameter("color");
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy second called");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		System.out.println("Get second called");
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		System.out.println("Post second called");
		processRequest(req, resp);
	}
	private void processRequest(HttpServletRequest req , HttpServletResponse resp) throws  ServletException ,IOException{
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Second servlet</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>\n" , color);
		out.println("<h1>Hello Second servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
