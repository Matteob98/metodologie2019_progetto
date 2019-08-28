package GestioneAnnotazioni;

import static def.jquery.Globals.$;

import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Crea la pagina di wordAnnotation
 * Nella pagina sarà presente una definizione di una parola
 * L'utente dovrà scrivere quella che secondo lui è la traduzione della parola descritta sopra
 * @author Matteo
 */
public class WordAnnotation 
{
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String WordAnnotationSERVLET_URL = "wordAnnotation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una definizione in inglese, "
			+ "prova ad indovinare di quale parola stiamo parlando e"
			+ " scrivi la sua traduzione nella tua lingua madre!";
	
	/**
	 * Nome del task per la chiamata a JSon
	 */
	private static final String task = "WORD_ANNOTATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "WordAnnotationForm";
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login
		
		HTMLLabelElement descrizioneLb = AnnotationPageCreator.createDescriptionLabel();
		
		//Elemento nascosto
		HTMLInputElement hiddDescrizione = AnnotationPageCreator.createHidden("descrizioneLbHidden");
		
		getDescrizione(descrizioneLb, hiddDescrizione);
		
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "Word Annotation"),
							AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione),
							AnnotationPageCreator.createDescriptionAndSubmitArea()))
				.Action(WordAnnotationSERVLET_URL)
				.NameAndId(formName)
				.ClassName("form-annotation")
				.build();
		
		$("body").append(form);
	}
	
	/**
	 * Passati in input una label e un input element, prende i dati dal back-end e li salva 
	 * sui due elementi
	 * @param lb Label dove sarà caricata la descrizione
	 * @param hidd Elemento nascosto che accompagna la label
	 */
	private static void getDescrizione(HTMLLabelElement lb, HTMLInputElement hidd)
	{	
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String risultato = json.$get("description"); //i.e. json.get("word")
			$(lb).text(risultato);
			$(lb).attr("value", risultato);
			$(hidd).text(risultato);
			$(hidd).attr("value", risultato);
				
			return null;
		});

	}
}
