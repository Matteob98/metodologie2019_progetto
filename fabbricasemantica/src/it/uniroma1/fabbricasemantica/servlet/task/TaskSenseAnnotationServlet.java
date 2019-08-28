package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gestioneDatabase.FabbricaSemanticaTag;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che salva sul database i dati inseriti nel task di sense annotation tramite il metodo doSomething
 * @author Matteo
 *
 */
@WebServlet(name = "TaskSenseAnnotationServlet", urlPatterns = "/senseAnnotation.jsp")
public class TaskSenseAnnotationServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Il metodo, se non è stato premuto skip, prende la parola e tutti i sensi che l'utente ha selezionato, ed ogni 
	 * senso viene salvato nel database
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
			//Prende la parola di cui annotare il senso
			String parola = (String) request.getParameter(FabbricaSemanticaTag.parolaLb.getTag()); 
			
			//Prende tutte le selezioni
			String[] senseSelection =  request.getParameterValues(FabbricaSemanticaTag.senseAnnotationCheckBox.getTag()); 
	
			//Per ogni selezione, salva la selezione nel database
			if(senseSelection!=null)
				for(String selezione : senseSelection)
					TaskManagement.salvaSenso(request, parola, selezione);

		}
		//Reindirizza ad una pagina a caso, oppure resta su questa
		TaskManagement.sendRedirect(request, response, "senseAnnotation.html");
	}
}
