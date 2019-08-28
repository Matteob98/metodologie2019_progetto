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
 * Servlet che permette di salvare i dati ricevuti dal task Definition Annotation tramite il metodo doSomething
 * @author Matteo
 */
@WebServlet(name = "TaskDefinitionAnnotationServlet", urlPatterns = "/definitionAnnotation.jsp")
public class TaskDefinitionAnnotationServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Se l'utente non ha premuto il tasto di skip, salva la traduzione della parola nel database.
	 * @param request Dati che vengono dal front-end
	 * @param response Dati che vengono inviati al front-end
	 * @throws ServletException Sollevata da errori generici della servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Se non è stato premuto skip
		boolean skipClick =  TaskManagement.ifSkipPress(request);
		if(!skipClick)
		{
			String parola = (String) request.getParameter(FabbricaSemanticaTag.parolaLb.getTag()); //Prende la parola da tradurre
			
			TaskManagement.salvaTraduzione(request, GetId.TrovaIdParola(parola));
		}
		//Reindirizza ad una pagina a caso, oppure resta su questa
		TaskManagement.sendRedirect(request, response, "definitionAnnotation.html");
	}

}
