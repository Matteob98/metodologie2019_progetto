package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import generatoreJson.RecordJson;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import gestioneDatabase.*;

/**
 * Servlet che permette di interagire con la pagina di login per autenticare l'utente in base ai dati inseriti
 * @author Matteo
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 8484501789787L;
		
	/**
	 * URL della pagina home
	 */
	private static String homePage = "home.html";
	/**
	 * URL della pagina login
	 */
	private static String loginPage = "login.html";
	

	
	/**
	 * Prende dal front-end email e password e controlla se esiste nel database un utente simile
	 * Se esiste reindirizza alla home e autentica l'utente
	 * Altrimenti reindirizza alla login page
	 * @param request Dati ricevuti dal front-end
	 * @param response Dati da inviare al front-end
	 * @throws ServletException Sollevata da errori generici nell servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		boolean accesso = false; //Diventa true se l'utente si autentifica
		
		//Prendo i dati dal front-end
		String email = (String) request.getParameter(FabbricaSemanticaTag.emailAreaName.getTag()); //prendo l'email dal front end
		String psw = (String) request.getParameter(FabbricaSemanticaTag.pswAreaName.getTag()); //prendo la password dal back end
		 
		//Si connette al Database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
		
		
		//Seleziono, se esistente, l'utente con l'email inserita
		ResultSet rs = querySelect.newQuery()
				.condizioni(new RecordJson<String>("email", email))
				.tabella(FabbricaSemanticaTag.tabUtenti.getTag())
				.connection(conn)
				.esegui();
						 
		try 
		{
			rs.next(); //Prendo l'utente trovato			
			{
				if(psw.equals(rs.getString("password"))) //Se la password corrisponde autentifico
				{
					
					HttpSession session = request.getSession();
					session.setAttribute("username", email);
					accesso = true;
					response.sendRedirect(homePage);
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			gestioneDatabase.ChiudiConnessione(conn); //Chiude la connessione
		}
		
		
		if(!accesso) //Se l'utente non esiste o la password è sbagliata torna indietro
			response.sendRedirect(loginPage);
	}

}
