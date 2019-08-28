package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gestioneDatabase.FabbricaSemanticaTag;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di salvare i dati inseriti nel task My Annotation tramite il metodo doSomething
 * @author Matteo
 *
 */
@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet 
{
	/**
	 * Versione dell'ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Valore massimo del range dove l'utente valuta la qualità della traduzione
	 */
	private static final int maxRangeValue = 10;
	

	/**
	 * Il metodo, se non è stato premuto il tasto di skip, prende tutte le valutazioni che l'utente ha dato 
	 *  alle traduzioni fornite ed, una ad una, le valuta
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
			//Prende la parola di cui validare la traduzione
			String parola = (String) request.getParameter(FabbricaSemanticaTag.parolaLb.getTag());
			
			//Prende tutte le valutazioni 
			String[] valutazioni = request.getParameterValues(FabbricaSemanticaTag.rangeSelectorTranslation.getTag());
			
			//Prende tutte le parole valutate
			String[] traduzioni = request.getParameterValues(FabbricaSemanticaTag.textSelector.getTag());
			
			//Per ogni valutazione ne salva la validazione
			for(int i=0; i<valutazioni.length; i++)
			{
				TaskManagement.salvaValidazioneTraduzione(request, parola, traduzioni[i], Integer.parseInt(valutazioni[i]), maxRangeValue);
			}
		}
		//Reindirizza ad una pagina a caso, oppure resta su questa
		TaskManagement.sendRedirect(request, response, "myAnnotation.html");
	}

}
