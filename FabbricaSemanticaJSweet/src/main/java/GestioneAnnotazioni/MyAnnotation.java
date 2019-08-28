package GestioneAnnotazioni;

import static def.jquery.Globals.$;

import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * PAGINA DI VALIDAZIONE
 * Crea la pagina con l'annotazione personalizzata
 * Consiste in una pagina dove l'utente ha a disposizione una parola ed una sua descrizione seguite da 4 possibili traduzioni
 *  Per ogni traduzione l'utente dovrà valutare con un range input la qualità della stessa.
 * @author Matteo
 *
 */
public class MyAnnotation 
{
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String MyAnnotationSERVLET_URL = "myAnnotation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una parola e una sua descrizione, "
			+ "indica la qualità di ognuna delle traduzioni proposte";
	
	/**
	 * Task che serve per la chiamata a JSON
	 */
	private static final String task = "MY_ANNOTATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "MyAnnotationForm";
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login
		
		HTMLLabelElement parolaLb = AnnotationPageCreator.createParolaLb();
		
		//Elemento nascosto
		HTMLInputElement hiddParola = AnnotationPageCreator.createHidden("parolaLbHidden");
								
		HTMLLabelElement descrizioneLb = AnnotationPageCreator.createDescriptionLabel();
							
		//Elemento nascosto
		HTMLInputElement hiddDescrizione = AnnotationPageCreator.createHidden("descrizioneLbHidden");
		
		HTMLDivElement divRange = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.ClassName("custom-control")
				.NameAndId("multipleRangeDiv")
				.build();
		
		getData(divRange, parolaLb, hiddParola, descrizioneLb, hiddDescrizione);
		
		
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "My Annotation"),
							AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola),
							AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione),
							divRange,
							AnnotationPageCreator.createSubmitArea()))
				.Action(MyAnnotationSERVLET_URL)
				.NameAndId(formName)
				.ClassName("form-annotation")
				.build();

		
		$("body").append(form);
	}
	
	/**
	 * Presi in input un divisore dove inserire i dati nei range element, 
	 * La label e l'hidden relativi alla parola da annotare/validare
	 * La label e l'hidden relativi alla descrizione della parola
	 * Prende i dati dal database e li carica sugli elementi
	 * @param divRange Div dove vengono inseriti i range che l'utente utilizzera per selezionare la traduzione
	 * @param parolaLb Label dove sarà caricata la parola
	 * @param hiddParola Elemento nascosto che accompagna la label per la parola
	 * @param descrizioneLb Label dove sarà caricata la descrizione della parola
	 * @param hiddDescrizione Elemento nascosto che accompagna la label della descrizione
	 */
	private static void getData(HTMLDivElement divRange, HTMLLabelElement parolaLb, HTMLInputElement hiddParola, HTMLLabelElement descrizioneLb, HTMLInputElement hiddDescrizione)
	{
		//Vado a prendere le opzioni dal json
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String[] translations = json.$get("translations"); //i.e. json.get("word")
			for(String str : translations)
			{
				$(divRange).append(HTMLSelectionAreaDivElementBuilder.newBuilder()
						.Selector((HTMLInputElement) HTMLRangeInputElementBuilder.newBuilder()
								.Name("translations")
								.Id(str)
								.build())
						.DivClassName("form-group")
						.build());
			}
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
