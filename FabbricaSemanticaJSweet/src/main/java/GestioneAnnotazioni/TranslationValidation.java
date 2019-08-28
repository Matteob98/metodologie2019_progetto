package GestioneAnnotazioni;

import static def.jquery.Globals.$;

import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Crea la pagina di translation Validation
 * Nella pagina compare una parola ed una sua definizione.
 * L'utente dovrà indicare, tramite apposite check-box, quelle che secondo lui sono le migliori traduzioni
 * @author Matteo
 *
 */
public class TranslationValidation 
{
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String TranslationValidationSERVLET_URL = "translationValidation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una parola e la sua definizione, "
			+ "scegli quella che secondo te è la migliore traduzione!";
	
	/**
	 * Task che serve per la chiamata a JSON
	 */
	private static final String task = "TRANSLATION_VALIDATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "TranslationValidationForm";
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login
		
		HTMLLabelElement parolaLb = AnnotationPageCreator.createParolaLb();
		
		//Elemento nascosto
		HTMLInputElement hiddParola = AnnotationPageCreator.createHidden("parolaLbHidden");
								
		HTMLLabelElement descrizioneLb = AnnotationPageCreator.createDescriptionLabel();
							
		//Elemento nascosto
		HTMLInputElement hiddDescrizione = AnnotationPageCreator.createHidden("descrizioneLbHidden");
				
		HTMLDivElement divCheck = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.ClassName("custom-control")
				.build();
		
		getData(divCheck, parolaLb, hiddParola, descrizioneLb, hiddDescrizione);
		
		
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "Translation Validation"),
							AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola),
							AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione),
							divCheck,
							AnnotationPageCreator.createSubmitArea()))
				.Action(TranslationValidationSERVLET_URL)
				.NameAndId(formName)
				.ClassName("form-annotation")
				.build();

		
		$("body").append(form);

	}
	
	/**
	 * Presi in input un divisore dove inserire i dati nelle checkbox, 
	 * La label e l'hidden relativi alla parola da annotare/validare
	 * La label e l'hidden relativi alla descrizione della parola
	 * Prende i dati dal database e li carica sugli elementi
	 * @param divCheck Div dove saranno caricate le check-box per la selezione
	 * @param parolaLb Label dove sarà caricata la parola
	 * @param hiddParola Elemento nascosto che accompagna la label della parola
	 * @param descrizioneLb Label dove sarà caricata la descrizione
	 * @param hiddDescrizione Elemento nascosto che accompagna la label della descrizione
	 */
	private static void getData(HTMLDivElement divCheck, HTMLLabelElement parolaLb, HTMLInputElement hiddParola, HTMLLabelElement descrizioneLb, HTMLInputElement hiddDescrizione)
	{
		$(divCheck).append(HTMLSelectionAreaDivElementBuilder.newBuilder()
				.Selector((HTMLInputElement) HTMLCheckBoxElementBuilder.newBuilder()
						.Value("Nessuna delle seguenti")
						.Id("Nessuna")
						.Name("translations")
						.build())
				.DivClassName("custom-control custom-checkbox")
				.LabelClassName("custom-control-label")
				.build());
				
				
		//Vado a prendere le opzioni dal json
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String[] translations = json.$get("translations"); //i.e. json.get("word")
			for(String str : translations)
			{
				$(divCheck).append(HTMLSelectionAreaDivElementBuilder.newBuilder()
						.Selector((HTMLInputElement) HTMLCheckBoxElementBuilder.newBuilder()
								.Value(str)
								.Id(str)
								.Name("translations")
								.build())
						.DivClassName("custom-control custom-checkbox")
						.LabelClassName("custom-control-label")
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
