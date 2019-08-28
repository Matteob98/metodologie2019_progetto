package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import generatoreJson.RecordJson;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import gestioneDatabase.*;

/**
 * Servlet che riceve i dati dalla pagina di signup e, se i dati inseriti sono corretti, registra l'utente 
 * aggiungendone i dati nel database. Alla fine reindirizza alla pagina home
 * Se invece la registrazione non va a buon fine torna alla pagina di signup
 * @author Matteo
 *
 */
@WebServlet(name="SignupServlet", urlPatterns="/singup.jsp")
public class SignupServlet extends BaseServlet 
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
	private static String signupPage = "signup.html";

	/**
	 * Metodo che prende tutti i dati inseriti nel form di signup, controlla la correttezza delle informazioni ed infine
	 * aggiunge i dati nel database.
	 * Salva il nome, il cognome, l'email, la password e tutte le lingue parlate con i relativi livelli
	 * Una volta registrato l'utente viene autenticato e reindirizzato alla pagina di home
	 * @param request Dati ricevuti dal front-end
	 * @param response Dati da inviare al front-end
	 * @throws ServletException Sollevata da errori generici nell servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		

		String nome = (String) request.getParameter(FabbricaSemanticaTag.nomeAreaName.getTag());
		String cognome = (String) request.getParameter(FabbricaSemanticaTag.cognomeAreaName.getTag());
		String email = (String) request.getParameter(FabbricaSemanticaTag.emailAreaName.getTag()); //prendo l'email dal front end
		String psw = (String) request.getParameter(FabbricaSemanticaTag.pswAreaName.getTag()); //prendo la password dal back end
		String repeatPsw = (String) request.getParameter(FabbricaSemanticaTag.repeatPswAreaName.getTag());
		String[] madreLinguaCB = request.getParameterValues(FabbricaSemanticaTag.madreLinguaCB.getTag());
		String primaLinguaScelta = (String) request.getParameter(FabbricaSemanticaTag.primaLinguaScelta.getTag()); //Lingua
		String primaLinguaLivello = (String) request.getParameter(FabbricaSemanticaTag.primaLinguaLivello.getTag()); //Livello
		String secondaLinguaScelta = (String) request.getParameter(FabbricaSemanticaTag.secondaLinguaScelta.getTag()); //Lingua
		String secondaLinguaLivello = (String) request.getParameter(FabbricaSemanticaTag.secondaLinguaLivello.getTag()); //Livello
		String terzaLinguaScelta = (String) request.getParameter(FabbricaSemanticaTag.terzaLinguaScelta.getTag()); //Lingua
		String terzaLinguaLivello = (String) request.getParameter(FabbricaSemanticaTag.terzaLinguaLivello.getTag()); //Livello
		
		//Controlla se l'email è già nel database e/o se la password non coincide
		boolean registrazioneCorretta = correttaRegistrazione(psw, repeatPsw, email);
		if(!registrazioneCorretta)
			response.sendRedirect(signupPage);
		
		//Connette al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
		

		//matteo -> Matteo
		nome = nome.substring(0,1).toUpperCase() + nome.substring(1, nome.length()).toLowerCase();
		cognome =  cognome.substring(0,1).toUpperCase() + cognome.substring(1, cognome.length()).toLowerCase();
		
		//Inserisce l'utente nel database
		queryInsert.newQuery()
		.valoriDaInserire(new RecordJson<String>("email", email),
				new RecordJson<String>("nome", nome),
				new RecordJson<String>("cognome", cognome),
				new RecordJson<String>("password", psw))
		.tabella(FabbricaSemanticaTag.tabUtenti.getTag())
		.connection(conn)
		.esegui();

		 //Controllo quali lingue parla l'utente

		//Nota: nel front-end "Scegli una lingua" e "Livello" sono all'interno del select e quindi teoricamente 
		//selezionabili. Vengono usati per capire quando l'utente non ha effettuato una scelta.
		
		if(primaLinguaScelta!="Scegli una lingua" && primaLinguaLivello!="Livello") //Se l'utente ha selezionato un livello ed una lingua
			insertLingua(email, primaLinguaScelta, primaLinguaLivello, conn); //Inserisci la lingua e il livello

		if(secondaLinguaScelta!="Scegli una lingua" && secondaLinguaLivello!="Livello")
			insertLingua(email, secondaLinguaScelta, secondaLinguaLivello, conn);

			
		if(terzaLinguaScelta!="Scegli una lingua" && terzaLinguaLivello!="Livello")
			insertLingua(email, terzaLinguaScelta, terzaLinguaLivello, conn);

		//Aggiungo ora tutte le lingue parlate come madrelingua
		if(madreLinguaCB!=null)
			for(String lingua: madreLinguaCB)
				insertLingua(email, lingua, "ML", conn);

		gestioneDatabase.ChiudiConnessione(conn); //Chiudo la connessione
		
		//L'utente appena registrato viene anche autenticato, in modo che non debba fare nuovamente il login
		HttpSession session = request.getSession();
		session.setAttribute("username", email);		
		
		if(registrazioneCorretta)
			response.sendRedirect(homePage);
		
		
	}
	
	/**
	 * Data l'email (identificativo utente) la lingua, il livello e la connessione,
	 * aggiunge al database la lingua parlata dall'utente con il relativo livello
	 * @param email Email identificativa dell'utente
	 * @param Lingua Lingua parlata dall'utente
	 * @param Livello Livello di conoscenza della lingua da parte dell'utente
	 * @param conn Connessione al database in cui inserire la lingua
	 */
	private void insertLingua(String email, String Lingua, String Livello, Connection conn)
	{
		queryInsert.newQuery()
		.valoriDaInserire(new RecordJson<Integer>("idUtente", GetId.TrovaIdUtente(email)),
					new RecordJson<Integer>("idLingua", GetId.TrovaIdLingua(Lingua)),
					new RecordJson<Integer>("idLivello", GetId.TrovaIdLivello(Livello)))
		.tabella(FabbricaSemanticaTag.tabUtentiLingue.getTag())
		.connection(conn)
		.esegui();
	}
	
	/**
	 * Date la password, la ripetizione della password e l'email interroga il database per vedere se l'utente 
	 * ha inserito correttamente i dati per essere registrato
	 * @param psw Password inserita dall'utente
	 * @param repeatPsw Password ripetuta dall'utente
	 * @param email Email inserita dall'utente
	 * @return True se la registrazione è andata a buon fine, False altrimenti
	 */
	private static boolean correttaRegistrazione(String psw, String repeatPsw, String email)
	{
		boolean registrazioneCorretta = true;
		//Se la password è diversa la registrazione non è andata a buon fine
		if(!(psw.equals(repeatPsw))) 
			registrazioneCorretta = false;
				
		//Connetto al database
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
				
		//Controllo se nel database esiste già un utente con l'email inserita
		int giaPresente = querySelect.isPresent("idUtente",
				querySelect.newQuery()
					.condizioni(new RecordJson<String>("email", email))
					.tabella(FabbricaSemanticaTag.tabUtenti.getTag())
					.connection(conn));
		
		//Se la mail è già presente
		if(giaPresente!=-1)
			registrazioneCorretta = false; //La registrazione non è corretta
		
		return registrazioneCorretta;
	}
	
	
	

}
