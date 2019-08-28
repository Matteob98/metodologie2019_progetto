package it.uniroma1.fabbricasemantica.servlet.service;

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
import gestioneDatabase.FabbricaSemanticaTag;
import gestioneDatabase.GetId;
import gestioneDatabase.gestioneDatabase;
import gestioneDatabase.querySelect;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che permette alla pagina html di ricevere i dati relativi all'utente sotto forma di stringa
 * @author Matteo
 *
 */
@WebServlet(name = "UserDataService", urlPatterns = "/userData.jsp")
public class UserDataService extends BaseServlet 
{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che, accedendo al database, permette alla pagina html di ricevere una stringa in formato:
	 * Ciao nome cognome. Traduzioni offerte fino ad ora nr
	 * @param request Dati che vengono dal front-end
	 * @param response Dati che vengono inviati al front-end
	 * @throws ServletException Sollevata da errori generici della servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Connetto al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
				
		//Prendo l'email dell'utente
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username");
		
		//Mi trovo l'id dell'utente
		int idUtente = GetId.TrovaIdUtente(email);
		
		//Trovo l'utente nel database
		ResultSet utenteQuery= querySelect.newQuery()
				.condizioni(new RecordJson<Integer>("idUtente", idUtente))
				.tabella(FabbricaSemanticaTag.tabUtenti.getTag())
				.connection(conn)
				.esegui();
		
		String nomeUtente = null;
		String cognomeUtente = null;
		
		//Prendo il nome e il cognome dal record trovato
		try 
		{
			utenteQuery.next();
			nomeUtente = utenteQuery.getString("nome");
			cognomeUtente = utenteQuery.getString("cognome");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//Cerco nel database quante traduzioni ha già effettuato l'utente
		int numeroTraduzioni = querySelect.count(querySelect.newQuery()
				.condizioni(new RecordJson<Integer>("idUtente", idUtente))
				.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
				.connection(conn));

		
		response.getWriter().write("Ciao " + nomeUtente + " " + cognomeUtente + ". Traduzioni offerte fino ad ora: " + numeroTraduzioni);
	}

}
