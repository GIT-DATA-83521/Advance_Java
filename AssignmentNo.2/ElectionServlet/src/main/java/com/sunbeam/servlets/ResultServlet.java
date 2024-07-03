package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
	        out.println("<h3>Online Voting</h3>");
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

	        out.println("<table>");
	        out.println("<tr><th>ID</th><th>Name</th><th>Party</th><th>Votes</th></tr>");
	        for (Candidate c : list) {
	            out.println("<tr>");
	            out.printf("<td>%d</td><td>%s</td><td>%s</td><td>%d</td>",
	                    c.getId(), c.getName(), c.getParty(), c.getVotes());
	            out.printf("<td><form method='post' ><input type='hidden' name='candidateId' value='%d'/></form></td>",
	                    c.getId());
	            out.println("</tr>");
	        }
	        out.println("</table>");
	        out.println("</body>");
	        out.println("</html>");
		}

}
