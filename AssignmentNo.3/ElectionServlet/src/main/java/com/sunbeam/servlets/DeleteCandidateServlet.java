package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String idstr = req.getParameter("id");
			int id = Integer.parseInt(idstr);
			try (CandidateDao candDao = new CandidateDaoImpl()){
				int count = candDao.deleteById(id);
				String msg = "Candidate deleted : "+ count;
				req.setAttribute("message", msg);
				//RequestDispatcher rd = req.getRequestDispatcher("result");
				ServletContext ctx = this.getServletContext();
				RequestDispatcher rd = ctx.getRequestDispatcher("/result");
				rd.forward(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
	}

}
