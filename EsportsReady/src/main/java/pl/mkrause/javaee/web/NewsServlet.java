package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.NewsManager;


@WebServlet("/news")
public class NewsServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
		PrintWriter printer = response.getWriter();
		NewsManager nm = new NewsManager();
		
		if (getServletContext().getAttribute("nm") == null)
			getServletContext().setAttribute("nm", new NewsManager());
		else 
	        nm = (NewsManager) getServletContext().getAttribute("nm");


		printer.println(" <!DOCTYPE html><html lang=\\\"pl-PL\\\"><head><meta charset=\\\"UTF-8\\\"></head><body><h2>Artyku³y</h2> ");
		
		int j = 0;
		
		while(nm.getAll().size() > j) {
			printer.print("<center><h2>" + nm.getAll().get(j).getTitle() + "</h2>");
			
			printer.println(nm.getAll().get(j).getContent() + "</center></br></br>");
			
			printer.println("Autor: " + nm.getAll().get(j).getAuthor() + "<br>");
			j++;
			
		}
		
		printer.println("<br><br><br><a href=\"http://localhost:8080/esportsready/addnews\">Dodaj artyku³</a><br>");
		 
		printer.close();
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
