package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojo.Candidate;

public class ResultServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<Candidate>();
			try(CandidateDao candDao = new CandidateDaoImpl()) {
				list=candDao.findAll();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Candidates</title>");
	     
	        
	        out.println("</head>");
	        out.println("<body>");
	        //out.println("<h3>Online Voting</h3>");
	        ServletContext app = this.getServletContext();
			String appTitle = app.getInitParameter("AppTitle");
			out.printf("<h3>%s</h3>", appTitle);
	        String userName = "";
			Cookie[] arr=req.getCookies();
			if(arr!=null) {
				for (Cookie c : arr)
				{
					if(c.getName().equals("uname")) {
						userName = c.getValue();
						break;
					}
				}
			}
	      
	        out.printf("Hello %s<hr/>\n", userName);
	        out.println("<a href=\"ChangePassword.html\">Change Password</a><br/><br/>");
	        out.println("<table border='1'>");
	        out.println("<tr><th>ID</th><th>Name</th><th>Party</th><th>Votes</th><th>Actions</th></tr>");
	        for (Candidate c : list) {
	        	out.println("<tr>");
	        	out.printf("<td>%d</td>\n", c.getId());
	        	out.printf("<td>%s</td>\n", c.getName());
	        	out.printf("<td>%s</td>\n", c.getParty());
	     		out.printf("<td>%d</td>\n", c.getVotes());
	        	//out.printf("<td>%d</td>\n", c.getId());
	     		//out.printf("<td><a href='delcand?id=%d'><img width='24' height='24' src='C:\\Users\\AKSHATA\\OneDrive\\Desktop'/></a></td>\n", c.getId());
	     		out.printf("<td><a href='editcand?id=%d'><img width='24' height='24' src='Images\\edit.jpg'/></a> <a href='delcand?id=%d'><img width='24' height='24' src='Images\\delete.png'/></a></td>\n", c.getId(), c.getId());
	        	out.println("</tr>");
	        }
	        out.println("</table>");
	        String msg = (String) req.getAttribute("message");
	        if(msg != null)
	        	out.println("<br/><br/>" + msg + "<br/><br/>");
	        out.println("<br/><a href='announcement.html'>Announcement</a>");
	        out.println("<a href='logout'>Sign Out</a>");
	        out.println("</body>");
	        out.println("</html>");
		}

}
