package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import generatoreJson.RecordJson;
import gestioneDatabase.FabbricaSemanticaTag;
import gestioneDatabase.GetId;
import gestioneDatabase.gestioneDatabase;
import gestioneDatabase.queryInsert;
import gestioneDatabase.querySelect;
import gestioneDatabase.queryUpdate;

/**
 * Classe che permette di gestire il salvataggio delle informazioni ricevute dalle varie servlet di gestione dei task.
 * La classe, non instanziabile, permette di salvare traduzioni e validare traduzioni e sensi
 * @author Matteo
 *
 */
public class TaskManagement 
{
	/**
	 * Lista di tutte le pagine html di annotazione o validazione in cui reindirizzare l'utente
	 */
	private static final String[] listaPagineAnnotazioneValidazione =
		{
				"wordAnnotation.html",
				"translationAnnotation.html",
				"definitionAnnotation.html",
				"senseAnnotation.html",
				"translationValidation.html",
				"senseValidation.html",
				"myAnnotation.html"
		};
	
	/**
	 * Valore se la traduzione è validata al 100%
	 */
	private static int valutazioneAnnotazione = 10;
	
	/**
	 * Indica che la traduzione è stata validata almeno una volta
	 */
	private static final int validato = 1;
	
	/**
	 * Classe non instanziabile
	 */
	private TaskManagement() {};
	
	/**
	 * Data una parola e un senso, se il senso è già associato alla parola allora richiama la validazione del senso, altrimenti 
	 * aggiunge il senso alla parola
	 * @param request Dati ricevuti dal front-end
	 * @param parola Parola di cui si deve salvare il senso
	 * @param senso Senso da salvare
	 */
	public static void salvaSenso(HttpServletRequest request, String parola, String senso)
	{
		// senso -> Senso
		senso = senso.substring(0, 1).toUpperCase() + senso.substring(1, senso.length()).toLowerCase();
		
		int idParola = GetId.TrovaIdParola(parola);
		
		//Connetto al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
		
		//Controllo se il senso è già associato alla parola
		int sensoId = querySelect.isPresent("idSenso" ,
				querySelect.newQuery()
					.condizioni(new RecordJson<Integer>("idParola", idParola),
							new RecordJson<String>("senso", senso))
					.tabella(FabbricaSemanticaTag.tabSensi.getTag())
					.connection(conn));
		
		
		if(sensoId==-1) //Se non è associato allora inserisco nel database il senso legato alla parola
			queryInsert.newQuery()
			.valoriDaInserire(new RecordJson<Integer>("idParola", idParola),
					new RecordJson<String>("senso", senso))
			.tabella(FabbricaSemanticaTag.tabSensi.getTag())
			.connection(conn)
			.esegui();
		else //Altrimenti considero il senso come validato
		{
			salvaValidazioneSenso(request, parola, senso, true);
		}
				
		//Chiudo la connessione al database
		gestioneDatabase.ChiudiConnessione(conn);
		
	}
	
	/**
	 * Data una parola e la traduzione validata, il metodo salva la validazione della parola
	 * @param request Dati ricevuti dal front-end
	 * @param parola Parola di cui si deve validare la traduzione
	 * @param traduzione Traduzione da validare
	 */
	public static void salvaValidazioneTraduzione(HttpServletRequest request, String parola, String traduzione)
	{
		//Connetto al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
		
		//Seleziono la traduzione da validare
		ResultSet rs = querySelect.newQuery()
				.condizioni(new RecordJson<Integer>("idParola", GetId.TrovaIdParola(parola)),
						new RecordJson<String>("traduzione", traduzione))
				.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
				.connection(conn)
				.esegui();
		try 
		{
			rs.next(); //Prendo il valore
			
			//Prendo la valutazione da aggiornare
			int valutazione = rs.getInt("valutazioneTraduzione");
			//Prendo l'id della traduzione
			int idTrad = rs.getInt("idTraduzione");

			//Aggiorno il valore
			queryUpdate.newQuery()
					.modifiche(new RecordJson<Integer>("validazione", validato),
								new RecordJson<Integer>("valutazioneTraduzione", valutazione+valutazioneAnnotazione))
					.Id(new RecordJson<Integer>("idTraduzione" , idTrad))
					.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
					.connection(conn)
					.esegui();
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		valutazioneAnnotazione = 10; //Reimposta il valore a 10
		
		//Chiudo la connessione al database
		gestioneDatabase.ChiudiConnessione(conn);
	}
	
	/**
	 * Data una parola, la sua traduzione e la valutazione della traduzione, il metodo salva la validazione della parola.
	 * La valutazione della traduzione viene espressa in termini di valore in base ad un massimo: entrambi passati in input
	 * @param request Dati ricevuti dal front-end
	 * @param parola Parola di cui si deve validare la traduzione
	 * @param traduzione Traduzione da validare
	 * @param val Valore con cui è stata validata la traduzione
	 * @param max Valore massimo con cui la traduzione poteva essere validata
	 */
	public static void salvaValidazioneTraduzione(HttpServletRequest request,String parola, String traduzione, int val, int max)
	{
		valutazioneAnnotazione = (valutazioneAnnotazione*val)/max;
		salvaValidazioneTraduzione(request, parola, traduzione);
	}
	
	/**
	 * Data una parola, un suo senso e un boolean che è true se l'utente ha validato, false altrimenti:
	 *  valida il senso della parola
	 * @param request Dati ricevuti dal front-end
	 * @param parola Parola di cui validare il senso
	 * @param senso Senso da validare
	 * @param validate True se il senso è stato validato, False altrimenti
	 */
	public static void salvaValidazioneSenso(HttpServletRequest request, String parola, String senso, boolean validate)
	{
		//Connetto al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();

		//Seleziono la traduzione da validare
		ResultSet rs = querySelect.newQuery()
				.condizioni(new RecordJson<Integer>("idParola", GetId.TrovaIdParola(parola)),
							new RecordJson<String>("senso", senso))
				.tabella(FabbricaSemanticaTag.tabSensi.getTag())
				.connection(conn)
				.esegui();
		
		try 
		{
			rs.next(); //Prendo il valore
			
			//Prendo la valutazione da aggiornare
			int valutazione = rs.getInt("valutazioneSenso");
			//Prendo l'id della traduzione
			int idSenso = rs.getInt("idSenso");
			
			//Aggiorno il valore
			queryUpdate.newQuery()
			.modifiche(new RecordJson<Integer>("validazione", validate ? validato : 0),
						new RecordJson<Integer>("valutazioneSenso", validate ? valutazione+valutazioneAnnotazione : 
																	valutazione-valutazioneAnnotazione))
			.Id(new RecordJson<Integer>("idSenso" , idSenso))
			.tabella(FabbricaSemanticaTag.tabSensi.getTag())
			.connection(conn)
			.esegui();
		
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		valutazioneAnnotazione = 10; //Reimposta a 10 il valore della valutazione
		
		//Chiudo la connessione al database
		gestioneDatabase.ChiudiConnessione(conn);
	}
	
	/**
	 * Data la request e l'Id della parola di cui si cerca la traduzione, inserisce nel database la traduzione della parola
	 * @param request Dati ricevuti dal front-end
	 * @param IdParola Id della parola di cui è stata offerta la traduzione
	 */
	public static void salvaTraduzione(HttpServletRequest request, int IdParola)
	{	
		//Connetto al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
		
		//Prendo l'email dell'utente autenticato
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username");
		
		//prendo la traduzione dal front end tutta minuscola
		String traduzione = ((String) request.getParameter(FabbricaSemanticaTag.traduzioneTB.getTag()));
		traduzione = traduzione.substring(0,1).toUpperCase() + traduzione.substring(1, traduzione.length()).toLowerCase();
				
		//Controllo se l'utente ha già offerto una traduzione di questa parola
		int isPresent  = querySelect.isPresent("idTraduzione",
				querySelect.newQuery()
					.condizioni(new RecordJson<Integer>("idUtente", GetId.TrovaIdUtente(email)),
							new RecordJson<Integer>("idParola", IdParola))
					.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
					.connection(conn)
				);
		
		
		//Se l'utente ha già tradotto questa parola in passato modifico la traduzione
		if(isPresent != -1)
		{
			queryUpdate.newQuery()
				.modifiche(new RecordJson<String>("traduzione", traduzione))
				.Id(new RecordJson<Integer>("idTraduzione", isPresent))
				.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
				.connection(conn)
				.esegui();

		}
		
		//Altrimenti ne inserisco una nuova
		else
			queryInsert.newQuery()
				.valoriDaInserire(new RecordJson<Integer>("idUtente", GetId.TrovaIdUtente(email)),
									new RecordJson<Integer>("idParola", IdParola),
									new RecordJson<String>("traduzione", traduzione))
				.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
				.connection(conn)
				.esegui();

		
		//Chiudo la connessione al database
		gestioneDatabase.ChiudiConnessione(conn);
	}
	
	/**
	 * Data una lista contentente URL, ne ritorna uno preso a caso
	 * @param lista Lista di URL da cui prenderne uno a caso
	 * @return Url a caso
	 */
	private static String getRandomUrl(String[] lista)
	{
		int index = (int)(Math.random() * 100) % lista.length;
		return lista[index];
	}
	
	/**
	 * Ritorna uno URL a caso in cui reindirizzare l'utente
	 * @return Url a caso
	 */
	public static String getRandomUrl()
	{
		return getRandomUrl(listaPagineAnnotazioneValidazione);
	}
	
	/**
	 * Se è stato premuto il pulsante di submit, rindirizza ad una pagina casuale, altrimenti resta
	 *  sulla stessa pagina
	 * @param request Dati ricevuti dal front-end
	 * @param response Dati da inviare al front-end
	 * @param urlDestination url di destinazione dove reindirizzare l'utente
	 * @throws IOException Sollevata da eccezioni di input/output
	 */
	public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String urlDestination) throws IOException
	{
		boolean skipClick = (String) request.getParameter(FabbricaSemanticaTag.skipLink.getTag()) != null ? true : false;
		boolean submitClick = (String) request.getParameter(FabbricaSemanticaTag.submitButton.getTag()) != null ? true : false;
		
		//Se submit è stato premuto reindirizza ad una pagina causale
		if(submitClick || skipClick)
			response.sendRedirect(TaskManagement.getRandomUrl());
		//Altrimenti resta sulla pagina
		else
			response.sendRedirect(urlDestination);
	}
	
	/**
	 * Ritorna vero se è stato premuto il pulsante di skip, false altrimenti
	 * @param request Dati ricevuti dal front-end
	 * @return True se è stato premuto il pulsante di skip, false altrimenti
	 */
	public static boolean ifSkipPress(HttpServletRequest request)
	{
		return (String) request.getParameter(FabbricaSemanticaTag.skipLink.getTag()) != null ? true : false;
	}
}
