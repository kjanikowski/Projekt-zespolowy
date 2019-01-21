package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import src.main.java.controller.UserManager;

@WebServlet("/add")
public class UserTest extends HttpServlet {

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
				"<form action=\"add\" method=\"post\">" +
				"Nazwa: <input type='text' name='email' /> <br />" +
				"Dlugosc: <input type='text' name='haslo' /> <br />" +
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
			um.addUser(new User(request.getParameter("email"),request.getParameter("haslo")));
			
				
			} catch (Exception e) {
				

			}
			response.sendRedirect("/esportsready/mainpage");
			out.close();
			
		
	}

}
