package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.News;
import src.main.java.controller.NewsManager;

@WebServlet("/addnews")
public class AddNews extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@EJB
	NewsManager um;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>Rejestracja</h2>" +
				"<form action=\"addnews\" method=\"post\">" +
				"Tytuł: <input type='text' name='title' /> <br />" +
				"Tresc: <input type='text' name='content' /> <br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		
		out.close();
	
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String login= null;
		
		try {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("login")) login = cookie.getValue();
		}
		if(login == null) response.sendRedirect("/esportsready/login");	
		um.addNews(new News(request.getParameter("title"), request.getParameter("content"), login));
		
		
		
		
		
		out.println("Dodano!");
		response.sendRedirect("/esportsready/news");
		out.close();
		
		
		
		
		} catch (Exception e) {
			

		}
	}
	
}
