package com.sunbeam.dao;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int id =   Integer.parseInt(req.getParameter("id"));
	

	
	
	try (CandidateDao canDao= new CandidateDaoImpl()){
		
		int count = canDao.deleteById(id);
		String msg = "Candidate deleted : "+count;
		req.setAttribute("message", msg);
		RequestDispatcher rd= req.getRequestDispatcher("result");
		rd.forward(req, resp);
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		throw new ServletException(e);
		
	}
	
	}
	
}
