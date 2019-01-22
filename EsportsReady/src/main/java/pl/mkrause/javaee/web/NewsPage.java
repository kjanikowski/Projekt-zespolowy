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

import domain.Comment;
import domain.News;
import src.main.java.controller.NewsManager;
import src.main.java.controller.UserManager;
@WebServlet("/news")
public class NewsPage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	NewsManager um;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		String role= null;
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("rola")) role = cookie.getValue();
		}
		
		for(News news : um.getAll()) {
			out.println(""
					+ "-----------------------------------------------<br>Autor: "
					+ news.getAuthor()
					+ "<h2><br>"
					+ news.getTitle()
					+ "</h2><br>"
					+ news.getContent()
					+ "<br><br>-----------------------------------------<br><br>Komantarze: <br>-----------------------------------------<br>");
			for(Comment com : news.getComments()) {
				out.println("Autor komentarza: "
						+ com.getAuthor()
						+ "<br>"
						+ com.getContent()
						+ "<br>-----------------------------------------<br>");
			}
			if(role != null) {
			if(role.equals("user")||role.equals("Admin"))
			out.print("<br><br><form action=\"news\" method=\"post\">" + "<input type=\"hidden\" name=\"id\" value=\""
					+ news.getId()+ "\">" + "Komentarz: <input type='text' name='content' /> <br /> <input type=\"submit\" value=\"Dodaj komentarz!\"></form><br>");
			}
			
		}
		if(role != null) {
		if(role.equals("Admin"))
		out.println("<br> <form action=\"/esportsready/addnews\">\r\n" + 
				"    <input type=\"submit\" value=\"Dodaj artykul\" />\r\n" + 
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
		if(login == null) response.sendRedirect("/esportsready/login");	
		
		um.addCom(new Comment(request.getParameter("content"), login ), Long.parseLong(request.getParameter("id")));
		response.sendRedirect("/esportsready/news");
			
		} catch (Exception e) {
			

		}
		out.close();
	
	
}

}
