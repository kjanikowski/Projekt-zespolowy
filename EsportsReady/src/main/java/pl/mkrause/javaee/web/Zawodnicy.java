package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/zawodnicy")
public class Zawodnicy extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		
		PrintWriter printer = response.getWriter();
		
		
		
		printer.println("<!DOCTYPE html><html lang=\"pl-PL\"><head><meta charset=\"UTF-8\"></head><body><h1><center>Wybierz grę</center></h2>" +
				"<table align=\"center\" border=0>" +
				"<tr>" +
				"<td> <a href=\"http://localhost:8080/esportsready/zawodnicyoverwatch\"> <img src=\"https://i.imgur.com/GjzBs0z.jpg\" alt=\"Overwatch\" </a>" +
				"<td> <a href=\"http://localhost:8080/esportsready/zawodnicycsgo\"> <img src=\"https://i.imgur.com/p5JQpMu.png\" alt=\"CSGO\" </a>" +
				"<td> <a href=\"http://localhost:8080/esportsready/zawodnicyleague\"> <img src=\"https://i.imgur.com/4eS7s23.png\" alt=\"Lol\" </a>" +
				"<td> <a href=\"http://localhost:8080/esportsready/zawodnicydota\"> <img src=\"https://i.imgur.com/2NMRGXX.png\" alt=\"DotA\" </a>" +
				"</table>" +
 				"</body>" + 
				"</html>");
		printer.close();
		
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
}
