package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

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
		out.println("<html><body><h2>Logowanie</h2>" +
				"<form action=\"login\" method=\"post\">" +
				"Nick: <input type='text' name='email' /> <br />" +
				"Haslo: <input type='password' name='haslo' /> <br />" +
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
			
			if(um.login(request.getParameter("email"), SHAsum(request.getParameter("haslo").getBytes()))== true) {
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
			}else {
				response.sendRedirect("/esportsready/add");
			}
			
				
			} catch (Exception e) {
				

			}
			out.close();
		
		
	}
		
		public static String SHAsum(byte[] convertme) throws NoSuchAlgorithmException{
		    MessageDigest md = MessageDigest.getInstance("SHA-1"); 
		    return byteArray2Hex(md.digest(convertme));
		}

		private static String byteArray2Hex(final byte[] hash) {
		    Formatter formatter = new Formatter();
		    for (byte b : hash) {
		        formatter.format("%02x", b);
		    }
		    return formatter.toString();
		}
}
