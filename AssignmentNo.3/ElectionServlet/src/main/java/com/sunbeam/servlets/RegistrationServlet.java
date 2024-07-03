package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojo.User;

public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		String firstname = req.getParameter("first_name");
		String lastname = req.getParameter("last_name");
		String dobStr = req.getParameter("birth"); 
		Date birth = Date.valueOf(dobStr);
		int status = Integer.parseInt(req.getParameter("status"));
		String role = req.getParameter("role");
		int id = Integer.parseInt(req.getParameter("id"));
		try(UserDao userDao = new UserDaoImpl()){
			int result = userDao.save(new User(id,firstname,lastname,email,passwd,birth,status,role));
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration</title>");
            out.println("</head>");
            out.println("<body>");
            if (result > 0) {
                out.println("<h2>Registration Successful</h2>");
                out.println("<p>Thank you for registering.</p>");
                out.println("<a href='index.html'>Login Here</a>");
            } else {
                out.println("<h2>Registration Failed</h2>");
                out.println("<a href='register.html'>Register Again</a>");
            }
            out.println("</body>");
            out.println("</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}

	}
}
