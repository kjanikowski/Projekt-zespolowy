package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/zawodnicycsgo")
public class Zawodnicy_Csgo extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		
		PrintWriter printer = response.getWriter();
		
		
		
		printer.println("<!DOCTYPE html><html lang=\"pl-PL\"><head><meta charset=\"UTF-8\"></head><body><h1><center>Profesjonalni gracze CS:GO</center></h2>" +
				"<table>" +
				"<tr><td>" +
				"<table align=\"center\" border=0>" +
				"<tr>" +
				"<td> <img src=\"https://liquipedia.net/commons/images/thumb/c/c2/Pasha_at_StarLadder_i-League_StarSeries_S4.jpg/600px-Pasha_at_StarLadder_i-League_StarSeries_S4.jpg\" alt=\"pasha\" width=\"600\" height=\"400\"></td>" + //pasha
				"<td> Jaroslaw \"pashaBiceps\" Jarząbkowski (born April 11, 1988) is a Polish professional Counter-Strike: Global Offensive player and former Counter-Strike player. Jarząbkowski is a part of the famous Polish group of players known as the Golden Five who were arguably one of the most successful teams in Counter-Strike and on top in terms of winnings. He currently plays for Virtus.pro. </td> " +
				"</tr><tr>" +
				"<td> <img src=\"https://liquipedia.net/commons/images/thumb/8/87/S1mple_at_StarLadder_i-League_StarSeries_S4.jpg/600px-S1mple_at_StarLadder_i-League_StarSeries_S4.jpg\" alt=\"S1mple\" width=\"600\" height=\"400\"> </td>" + //s1mple
				"<td> Oleksandr \"s1mple\" Kostyliev (born October 2, 1997) is an Ukrainian professional Counter-Strike: Global Offensive player. He currently plays for Natus Vincere as an AWPer.  </td> " +
				"</tr><tr>" +
				"<td> <img src=\"https://liquipedia.net/commons/images/thumb/3/33/KennyS_at_Dreamhack_Masters_Marseille_2018.jpg/600px-KennyS_at_Dreamhack_Masters_Marseille_2018.jpg\" alt=\"KennyS\" width=\"600\" height=\"400\"> </td>" + //kennyS
				"<td> Kenny \"kennyS\" Schrub (born May 19, 1995) is a French professional Counter-Strike: Global Offensive player and a former Counter-Strike: Source player. Known for being a former Counter-Strike: Source player, kennyS is currently playing for G2 Esports. </td>" +
				"</tr><tr>" +
				"</table>" +
				"</td><td>" +
				"<table align=\"center\" width=\"60%\">" + // tabela prawa, zeby zrobic border bo wyglada jak rzygi.
				"<tr><td><br>"+
				"<img src=\"https://i.imgur.com/FDE7c3J.png\" alt=\"GhettoBorder\" align=\"right\"></td></tr>" + //wyjątkowo ghetto zrobiony border, ale działa.
				"</table>" +
				"</td></tr>" +
				"</table>" +
 				"</body>" + 
				"</html>");
		printer.close();
		
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
}
