package pl.mkrause.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/mainpage")
public class Mainpage extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		
		PrintWriter printer = response.getWriter();
		
		
		
		printer.println("<!DOCTYPE html><html lang=\"pl-PL\"><head><meta charset=\"UTF-8\"></head><body><h1><center>Esports Ready</center></h2>" +
				"<table border=0>" +
				"<tr><td>" + //ponizej tabela lewa - menu kontekstowe
				"<table align=\"left\">" +
				"<tr>" +
				"<th>Podstrony</th>" +
				"</tr>" +
				"<tr>" +
				"<td><br><a href=\"http://localhost:8080/esportsready/news\"> Newsy </a></td><td></td>" +
				"</tr>" +
				"<tr>" +
				"<td><br><a href=\"http://localhost:8080/esportsready/zawodnicy\">O Zawodnikach</a></td><td></td>" + 
				"</tr>" +
				"<tr>" +
				"<td><br><a href=\"URL\">Obecne turnieje</a></td><td></td>" + // tu wstawić url obecnych turniei
				"</tr>" +
				"<tr>" +
				"<td><br><a href=\"URL\">Strefa amatorska</a></td><td></td>" + // tu wstawić url strefy amatorskiej
				"</tr>" +
				"<tr>" +
				"<td><br><a href=\"http://localhost:8080/esportsready/rankingftp\"> Ranking F2P </a></td><td></td>" +
				"</tr>" +
				"</table>" +		
				"</td><td>" + //ponizej tabela srodkowa - newsy
				"<table align=\"left\" width=\"40%\">" +
				"<tr>" +
				"<img src=\"https://i.imgur.com/LD3c5BI.png\" alt=\"Igrzyska\" align=\"bottom\">" +
				"<br><br><br><br>" +
				"<img src=\"https://i.imgur.com/s7PSap3.jpg\" alt=\"Player\" align=\"right\">" +
				"<strong>" + //bold
				"Igrzyska Azji Południowo-Wschodniej podobnie jak Igrzyska Azjatyckie dodają" +
				"esport do listy dyscyplin, jednak tym razem najlepsi esportowcy zostaną nagrodzeni medalami." +
				"</strong>" +
				"<br><br>" +
				"Podczas tegorocznych Asian Games po raz pierwszy zobaczyliśmy obok sportowców, profesjonalnych graczy, który rywalizowali w takie tytuły jak League of Legends, StarCraft II czy też Arena of Valor. Esport ponownie zagości na wydarzeniu bezpośrednio związanym ze sportem, lecz tym razem w pełnoprawnym wydaniu.\n" + 
				"\n" + 
				"Podczas SEA Games 2019, czyli Igrzysk Azji Południowo-Wschodniej sporty elektroniczne będą dyscypliną medalową. Krążkami zostaną nagrodzeni zawodnicy najlepsi w sześciu grach, dwie komputerowe, dwie konsolowe oraz dwie mobilne. Jedynym potwierdzonym tytułem jest Mobile Legends: Bang Bang, czyli komórkowa gra MOBA ciesząca się sporą popularnością w Azji. Cała reszta ma zostać ogłoszona wkrótce, lecz według Międzynarodowego Komitetu Olimpijskiego nie powinny one promować kultury przemocy oraz hazardu. Dodatkowo dowiedzieliśmy się, że do zawodów nie będzie bezpośrednich zaproszeń, a wszyscy uczestnicy zostaną wyłonieni z otwartych turniejów kwalifikacyjnych.\n" + 
				"\n" + 
				"Igrzyska Azji Południowo-Wschodniej są organizowane od 1959 roku, cyklicznie co dwa lata. W zawodach bierze udział 11 państw w tym m.in. Wietnam, Tajlandia czy Indonezja. W 2019 wydarzenie odbędzie się na Filipinach i rozpoczną się 30 listopada. Do puli 56 dyscyplin sportowych m.in. lekkoatletyki, koszykówki, tenisa czy siatkówki zostanie dodany sport elektroniczny. Oficjalnym partnerem turniejów esportowych został Razer." +				
				"</td></tr></table>" + 
				"</td><td>" +
				"<table align=\"center\" width=\"60%\">" + // tabela prawa, zeby zrobic border bo wyglada jak rzygi.
				"<tr><td><br>"+
				"<img src=\"https://i.imgur.com/FDE7c3J.png\" alt=\"GhettoBorder\" align=\"right\"></td></tr>" + //wyjątkowo ghetto zrobiony border, ale działa.
				"</table>" +
				"</tr>" +
				"</table>" +
 				"</body>" + 
				"</html>");
		printer.close();
		
		
	}
	
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
}
