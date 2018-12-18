package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.NewsManager;
import domain.News;





@WebServlet("/addnews")
public class AddNews extends javax.servlet.http.HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Dodaj artykul</h2>" +
				"<form action=\"addnews\" method=\"post\">" +
				"Tytu³ <input type='text' name='title' /> <br />" +
				"Artyku³: <input type='text' name='content' /> <br />" +
				"Autor: <input type='text' name='author' /> <br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        NewsManager nm = (NewsManager) getServletContext().getAttribute("nm");
        nm.addNews(new News(request.getParameter("title"), request.getParameter("content"), request.getParameter("author") ));
        getServletContext().setAttribute("nm", nm);
		
		PrintWriter printer = response.getWriter();

		printer.println("<br><br><br><a href=\"http://localhost:8080/esportsready/news\">Wroæ do Artyku³ów</a><br>");

		
		
	}

}
