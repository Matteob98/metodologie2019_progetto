package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gestioneDatabase.FabbricaSemanticaTag;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di ricevere i dati inseriti nel task Translation Validation ed inserirli nel database attraverso 
 * il metodo doSomething
 * @author Matteo
 *
 */
@WebServlet(name = "TaskTranslationValidationServlet", urlPatterns = "/translationValidation.jsp")
public class TaskTranslationValidationServlet extends BaseServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che, se non è stato premuto il tasto skip, prende tutte le traduzioni selezionate dall'utente e le 
	 * valida, aggiornando i relativi dati nel database
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
			//Prende la parola di cui validare la traduzione
			String parola = (String) request.getParameter(FabbricaSemanticaTag.parolaLb.getTag()); 
					
			//Prende la selezione
			String[] translationSelection =  request.getParameterValues(FabbricaSemanticaTag.translationAnnotationCheckBox.getTag()); 
	
			if(translationSelection!=null)
				for(String selezione : translationSelection)
				{
					//Se l'utente ha selezionato "nessuna traduzione" esco e non salvo niente
					if(selezione.equals(FabbricaSemanticaTag.nessunaSelezione.getTag())) break;
					else
						TaskManagement.salvaValidazioneTraduzione(request, parola, selezione);
				}
					
		}
		//Reindirizza ad una pagina a caso, oppure resta su questa
		TaskManagement.sendRedirect(request, response, "translationValidation.html");
	}

}
