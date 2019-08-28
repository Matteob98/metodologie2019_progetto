package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneDatabase.FabbricaSemanticaTag;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che salva sul database tutti i dati inseriti nel task di sense validation tramite il metodo doSomething
 * @author Matteo
 *
 */
@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che, se non è stato premuto il tasto skip, prende la selezione del radio button e salva la scelta dell'utente 
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
		boolean skipClick =  TaskManagement.ifSkipPress(request);
		if(!skipClick)
		{
			//Prende la parola di cui validare il senso
			String parola = (String) request.getParameter(FabbricaSemanticaTag.parolaLb.getTag()); 
			
			//Prende il senso della parola che si vuole validare
			String senso = (String) request.getParameter(FabbricaSemanticaTag.senseLb.getTag()); 
	
			//Prende la selezione
			String radioSelection = (String) request.getParameter(FabbricaSemanticaTag.choiceAnnotationRadio.getTag()); 
			
			TaskManagement.salvaValidazioneSenso(request, parola, senso, radioSelection.equals("SI"));
		}
		//Reindirizza ad una pagina a caso, oppure resta su questa
		TaskManagement.sendRedirect(request, response, "senseValidation.html");
	}

}
