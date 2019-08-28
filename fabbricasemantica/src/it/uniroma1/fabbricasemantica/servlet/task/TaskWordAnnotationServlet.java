package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gestioneDatabase.FabbricaSemanticaTag;
import gestioneDatabase.GetId;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di ricevere i dati inseriti nel task Word Annotation e salvarli nel database attraverso il metodo 
 * doSomething
 * @author Matteo
 */
@WebServlet(name = "TaskWordAnnotationServlet", urlPatterns = "/wordAnnotation.jsp")
public class TaskWordAnnotationServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che, se non è stato premuto il tasto di skip, prende la traduzione offerta dall'utente e la salva 
	 * nel database
	 * @param request Dati che vengono dal front-end
	 * @param response Dati che vengono inviati al front-end
	 * @throws ServletException Sollevata da errori generici della servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Se non è stato premuto skip
		boolean skipClick = TaskManagement.ifSkipPress(request);
		if(!skipClick)
		{
			String descrizione = (String) request.getParameter(FabbricaSemanticaTag.descrizioneLb.getTag()); //Prende la parola da tradurre
			
			TaskManagement.salvaTraduzione(request, GetId.TrovaIdDescrizione(descrizione));
		}
		//Reindirizza ad una pagina a caso, oppure resta su questa
		TaskManagement.sendRedirect(request, response, "wordAnnotation.html");
	}
}
