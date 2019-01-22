package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Comment;
import domain.News;
import domain.Tournament;
import domain.User;
import src.main.java.controller.TournamentManager;
@WebServlet("/tournament")
public class TournamentPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	TournamentManager tm;
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		String role= null;
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("rola")) role = cookie.getValue();
		}
		
		for(Tournament tournament : tm.getAll()) {
			out.println("-----------------------------------------------<br> " + tournament.getGame() + 
					"<br>" );
					for(User user : tournament.getuserList()) {
						out.print(""
								+ "<br>Gracz: "+ user.getEmail());
					}
					if(role != null) {
					if(role.equals("user")||role.equals("Admin"))
					if(tournament.getuserList().size() < 4) {
						out.print("<br><br><form action=\"tournament\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
								+ tournament.getId()+ "\">" + "<input type=\"submit\" value=\"Dolacz!\"></form><br>");
					}
					}
					out.println("<br>-----------------------------------------------");
					

		}
		if(role != null) {
		if(role.equals("user")||role.equals("Admin"))
		out.println("<br> <form action=\"/esportsready/addtournament\">\r\n" + 
				"    <input type=\"submit\" value=\"Dodaj turniej\" />\r\n" + 
				"</form><br>");
		}
		out.println("<br> <form action=\"/esportsready/mainpage\">\r\n" + 
				"    <input type=\"submit\" value=\"Strona glowna\" />\r\n" + 
				"</form>");
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	PrintWriter out = response.getWriter();

	try {
	response.setContentType("text/html");
	//PrintWriter out = response.getWriter();
	String login= null;
	Cookie[] cookies = request.getCookies();
	
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("login")) login = cookie.getValue();
	}
	if(login == null) { response.sendRedirect("/esportsready/login");	
	}else {
	tm.addUser(Long.parseLong(request.getParameter("id")) , login);
	response.sendRedirect("/esportsready/tournament");
	}
	} catch (Exception e) {
		

	}
	out.close();


}
	

}
