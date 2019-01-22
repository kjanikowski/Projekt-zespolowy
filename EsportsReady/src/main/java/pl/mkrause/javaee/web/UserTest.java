package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

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
			um.addUser(new User(request.getParameter("email"),SHAsum(request.getParameter("haslo").getBytes())));
			
				
			} catch (Exception e) {
				

			}
			response.sendRedirect("/esportsready/mainpage");
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
