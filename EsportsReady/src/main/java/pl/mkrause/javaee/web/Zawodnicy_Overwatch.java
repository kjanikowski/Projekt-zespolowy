package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/zawodnicyoverwatch")
public class Zawodnicy_Overwatch extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		
		PrintWriter printer = response.getWriter();
		
		
		
		printer.println("<!DOCTYPE html><html lang=\"pl-PL\"><head><meta charset=\"UTF-8\"></head><body><h1><center>Profesjonalni gracze Overwatch</center></h2>" +
				"<table>" +
				"<tr><td>" +
				"<table align=\"center\" border=0>" +
				"<tr>" +
				"<td> <img src=\"https://i.imgur.com/qu5VwfC.jpg\" alt=\"xQc\" width=\"600\" height=\"400\"></td>" + //xqc
				"<td> Félix Lengyel (born November 12, 1995), better known as xQc or xQcOW is a Canadian professional Overwatch player and Twitch streamer who played the Main Tank position for the Dallas Fuel in the Overwatch League for part of the inaugural season, before being released due to repeated controversy. xQc has also played in the Overwatch World Cup as the Main Tank for Team Canada in 2017 & 2018.</td> " +
				"</tr><tr>" +
				"<td> <img src=\"https://i.imgur.com/SJD4tAK.jpg\" alt=\"Overwatch\" width=\"600\" height=\"400\"> </td>" + //jjonak
				"<td> iBang Sung-hyeon (Hangul: 방성현), better known by his online alias JJonak (JO-nak), is a South Korean professional eSports player, best known as a competitive Overwatch player for New York Excelsior. He was named most valuable player of the league's first season. </td> " +
				"</tr><tr>" +
				"<td> <img src=\"https://i.imgur.com/4u7FAFj.jpg\" alt=\"Overwatch\" width=\"600\" height=\"400\"> </td>" + //seagull
				"<td> Brandon \"Seagull\" Larned is a retired American player who last played for the Dallas Fuel in the Overwatch League Inaugural Season. On 7th August 2018, he announced his retirement from professional play to focus on his streaming career after the first season of the Overwatch League. </td>" +
				"</tr><tr>" +
				"</table>" +
				"</td><td>" +
				"<table align=\"center\" width=\"60%\">" + // tabela prawa, zeby zrobic border bo wyglada jak rzygi.
				"<tr><td><br>"+
				"<img src=\"https://i.imgur.com/FDE7c3J.png\" alt=\"GhettoBorder\" align=\"right\"></td></tr>" + //wyjątkowo ghetto zrobiony border, ale działa.
				"</table>" +
				"</td></tr>" +
				"</table>" + "<br> <form action=\"/esportsready/mainpage\">\r\n" + 
				"    <input type=\"submit\" value=\"Strona glowna\" />\r\n" + 
				"</form>"+
 				"</body>" + 
				"</html>");
		printer.close();
		
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
}
