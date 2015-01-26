package com.singgih.jsp.sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger("com.singgih.jsp");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("Entering get method");
		String message = (String) req.getSession().getAttribute("message");
		req.setAttribute("message", message);

		req.getRequestDispatcher("session.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.debug("Entering post method");
		String message = req.getParameter("message");
		req.getSession().setAttribute("message", message);
		resp.sendRedirect("/session");
	}

}
