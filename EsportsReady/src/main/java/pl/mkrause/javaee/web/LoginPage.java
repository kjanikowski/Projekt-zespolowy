package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import src.main.java.controller.UserManager;

@WebServlet("/login")
public class LoginPage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	UserManager um;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Rejestracja</h2>" +
				"<form action=\"login\" method=\"post\">" +
				"Email: <input type='text' name='email' /> <br />" +
				"Haslo: <input type='text' name='haslo' /> <br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
			PrintWriter out = response.getWriter();

			try {
			response.setContentType("text/html");
			//PrintWriter out = response.getWriter();
			
			if(um.login(request.getParameter("email"), request.getParameter("haslo"))== true) {
				out.println("Zalogowano");
				
	            HttpSession newSession = request.getSession(true);
	            newSession.setMaxInactiveInterval(5*60);
				
				Cookie email = new Cookie("login",request.getParameter("email"));
				Cookie role = new Cookie("rola",um.getRole(request.getParameter("email")));
				email.setMaxAge(300);
				role.setMaxAge(300);
				response.addCookie(email);
				response.addCookie(role);
				response.sendRedirect("/esportsready/mainpage");
			}
			
				
			} catch (Exception e) {
				

			}
			out.close();
		
		
	}
}
