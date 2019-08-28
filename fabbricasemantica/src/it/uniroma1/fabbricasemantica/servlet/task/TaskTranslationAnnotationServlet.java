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
 * Servlet che consente di prendere i dati ricevuti dal task Translation Annotation e salvarli sul database, 
 * tramite il metodo doSomething
 * @author Matteo
 *
 */
@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che, se non è stato premuto il tasto skip, prende la traduzione offerta dall'utente e la salva sul 
	 * database
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
		TaskManagement.sendRedirect(request, response, "translationAnnotation.html");
	}

}
