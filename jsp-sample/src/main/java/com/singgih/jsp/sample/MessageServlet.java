package com.singgih.jsp.sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*
 WebServlet annotation is used to register a Servlet with a container. 
 Below is the complete list of attributes that annotation encapsulates.
 - name
 - description
 - value
 - urlPatterns
 - initParams
 - loadOnStartup
 - asyncSupported
 - smallIcon
 - largeIcon
 */

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger("com.singgih.jsp");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("Entering get method");
		String message = req.getParameter("message");
		req.setAttribute("message", message);
		req.setAttribute("method", req.getMethod());

		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.debug("Entering post method");
		String message = req.getParameter("message");
		req.setAttribute("message", message);
		req.setAttribute("method", req.getMethod());
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
