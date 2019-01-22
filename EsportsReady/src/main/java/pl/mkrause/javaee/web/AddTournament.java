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
import domain.Tournament;
import src.main.java.controller.NewsManager;
import src.main.java.controller.TournamentManager;
@WebServlet("/addtournament")
public class AddTournament extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@EJB
	TournamentManager tm;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body><h2>Dodaj turniej</h2>" +
				"<form action=\"addtournament\" method=\"post\">" +
				"Gra: <input type='text' name='game' /> <br />" +
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
		tm.addTournament(new Tournament(request.getParameter("game")));
		
		
		
		
		
		out.println("Dodano!");
		response.sendRedirect("/esportsready/tournament");
		out.close();
		
		
		
		
		} catch (Exception e) {
			

		}
	}
}
