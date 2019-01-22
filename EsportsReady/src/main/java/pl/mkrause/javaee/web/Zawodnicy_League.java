package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/zawodnicyleague")
public class Zawodnicy_League extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		
		PrintWriter printer = response.getWriter();
		
		
		
		printer.println("<!DOCTYPE html><html lang=\"pl-PL\"><head><meta charset=\"UTF-8\"></head><body><h1><center>Profesjonalni gracze Leage of Legends</center></h2>" +
				"<table>" +
				"<tr><td>" +
				"<table align=\"center\" border=0>" +
				"<tr>" +
				"<td> <img src=\"https://liquipedia.net/leagueoflegends/File:SKT_Faker_2018LCK.jpg\" alt=\"faker\" width=\"600\" height=\"400\"></td>" + //faker
				"<td> Lee \"Faker\" Sang-hyeok (born May 7, 1996) is a Korean player who currently plays as a Mid laner for SK Telecom T1. He is known for playing all his matches without using any skins and is considered the best midlaner to ever play the game.</td> " +
				"</tr><tr>" +
				"<td> <img src=\"https://liquipedia.net/commons/images/thumb/6/6d/JankosLEC.png/294px-JankosLEC.png\" alt=\"Jankos\" width=\"600\" height=\"400\"> </td>" + //jankos
				"<td> Marcin \"Jankos\" Jankowski (born July 23, 1995) is a Polish player who is playing for G2 Esports as the Jungler. At the start of the 2016 season, Jankos joined H2k-Gaming after the team were voted to play at IEM Season X - Cologne.  </td> " +
				"</tr><tr>" +
				"<td> <img src=\"https://liquipedia.net/leagueoflegends/File:TSM_Bjergsen_2018NALCS.jpg\" alt=\"Bjergsen\" width=\"600\" height=\"400\"> </td>" + //bjergsen
				"<td> Soren \"Bjergsen\" Bjerg is a Danish player who currently plays as a Mid laner for Team SoloMid.  Having to play a tiebreaker against Misfits Gaming, TSM lost and were eliminated from Worlds in the group stage yet again in a fashion similar to last years'.  </td>" +
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
