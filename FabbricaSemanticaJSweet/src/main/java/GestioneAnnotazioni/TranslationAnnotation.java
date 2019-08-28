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
 * Crea la pagina di translationAnnotation
 * Nella pagina compare una parola e una sua definizione.
 * L'utente deve fornire una traduzione della parola
 * @author Matteo
 */
public class TranslationAnnotation 
{	
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String TranslationAnnotationSERVLET_URL = "translationAnnotation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una parola e la sua definizione in inglese, "
			+ "fornisci una traduzione nella tua lingua madre!";
	
	/**
	 * Task che serve per la chiamata a JSON
	 */
	private static final String task = "TRANSLATION_ANNOTATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "TranslationAnnotationForm";
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login
		
		HTMLLabelElement parolaLb = AnnotationPageCreator.createParolaLb();
		
		//Elemento nascosto
		HTMLInputElement hiddParola = AnnotationPageCreator.createHidden("parolaLbHidden");
								
		HTMLLabelElement descrizioneLb = AnnotationPageCreator.createDescriptionLabel();
		
		//Elemento nascosto
		HTMLInputElement hiddDescrizione = AnnotationPageCreator.createHidden("descrizioneLbHidden");
		
		getData(parolaLb, hiddParola, descrizioneLb, hiddDescrizione);
									
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "Translation Annotation"),
							AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola),
							AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione),
							AnnotationPageCreator.createDescriptionAndSubmitArea()))
				.Action(TranslationAnnotationSERVLET_URL)
				.NameAndId(formName)
				.ClassName("form-annotation")
				.build();
		
		$("body").append(form);
	}
	
	
	/**
	 * Presi in input: 
	 * La label e l'hidden relativi alla parola da annotare/validare
	 * La label e l'hidden relativi alla descrizione della parola
	 * Prende i dati dal database e li carica sugli elementi
	 * @param parolaLb Label dove sarà caricata la parola 
	 * @param hiddParola Elemento nascosto che accompagna la label della parola
	 * @param descrizioneLb Label dove sarà caricata la descrizione della parola
	 * @param hiddDescrizione Elemento nascosto che accompagna la label della descrizione
	 */
	private static void getData(HTMLLabelElement parolaLb, HTMLInputElement hiddParola, HTMLLabelElement descrizioneLb, HTMLInputElement hiddDescrizione)
	{
		//Vado a prendere le opzioni dal json
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
					
			String parola = json.$get("word"); //i.e. json.get("word")
			$(parolaLb).text(parola);
			$(hiddParola).attr("value", parola);
					
			String descrizione = json.$get("description"); //i.e. json.get("word")
			$(descrizioneLb).text(descrizione);
			$(hiddDescrizione).attr("value", descrizione);
					
			return null;
		});		
	}
	

}
