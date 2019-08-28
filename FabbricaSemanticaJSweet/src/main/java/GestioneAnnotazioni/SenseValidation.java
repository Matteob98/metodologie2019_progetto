package GestioneAnnotazioni;

import static def.jquery.Globals.$;

import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Crea la pagina di sense validation
 * Nella pagina è presente una parola ed una frase di esempio in cui la parola appare.
 * L'utente dovrà fornire la sua traduzione della parola
 * @author Matteo
 *
 */
public class SenseValidation 
{
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String SenseValidationSERVLET_URL = "senseValidation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una parola e una frase in cui appare, "
			+ "indica se il senso fornito è appropriato oppure no!";
	
	/**
	 * Task che serve per la chiamata a JSON
	 */
	private static final String task = "SENSE_VALIDATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "SenseValidationForm";
	
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login
		
		HTMLLabelElement parolaLb = AnnotationPageCreator.createParolaLb();
		
		//Elemento nascosto
		HTMLInputElement hiddParola = AnnotationPageCreator.createHidden("parolaLbHidden");
								
		HTMLLabelElement esempioLb = AnnotationPageCreator.createDescriptionLabel();
							
		//Elemento nascosto
		HTMLInputElement hiddEsempio = AnnotationPageCreator.createHidden("descrizioneLbHidden");

		
		HTMLLabelElement senseLabel = (HTMLLabelElement) HTMLLabelElementBuilder.newBuilder()
				.ClassName("senseLb")
				.NameAndId("senseLabel")
				.build();
					
		//Elemento Nascosto
		HTMLInputElement hiddSense = (HTMLInputElement) HTMLHiddenElementBuilder.newBuilder()
				.NameAndId("senseLbHidden")
				.build();
		
		HTMLDivElement divSense = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.ClassName("form-group")
				.elementi(Arrays.asList(senseLabel, hiddSense))
				.build();
		
		getData(senseLabel, hiddSense, parolaLb, hiddParola, esempioLb, hiddEsempio);
		
		//Div vuoto che serve a distanziare due campi
		HTMLDivElement divSpaziatore = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.ClassName("custom-control")
				.build();
		
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi( Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "Sense Validation"),
							AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola),
							AnnotationPageCreator.createDescriptionDiv(esempioLb, hiddEsempio),
							divSense,
							createChoiceArea(),
							divSpaziatore,
							AnnotationPageCreator.createSubmitArea()))
				.Action(SenseValidationSERVLET_URL)
				.NameAndId(formName)
				.ClassName("form-annotation")
				.build();
		
		$("body").append(form);
	}
	
	/**
	 * Dati, a coppie di label e hidden element, gli elementi per : il senso, la parola e l'esempio, la funzione
	 * prende i dati dal back-end e li salva sugli elementi passati in input
	 * @param senseLabel Label dove sarà caricato il senso da validare
	 * @param hiddSense Elemento nascosto che accompagna la label del senso
	 * @param parolaLb Label dove sarà caricata la parola relativa al senso
	 * @param hiddParola Elemento nascosto che accompagna la label della parola
	 * @param esempioLb Label dove sarà caricato un esempio
	 * @param hiddEsempio Elemento nascosto che accompagna la label dell'esempio
	 */
	private static void getData(HTMLLabelElement senseLabel, HTMLInputElement hiddSense, HTMLLabelElement parolaLb, HTMLInputElement hiddParola, HTMLLabelElement esempioLb, HTMLInputElement hiddEsempio)
	{
		//Vado a prendere le opzioni dal json
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sense = json.$get("sense"); //i.e. json.get("word")
			$(senseLabel).text(sense);
			$(hiddSense).attr("value", sense);
					
			String parola = json.$get("word"); //i.e. json.get("word")
			$(parolaLb).text(parola);
			$(hiddParola).attr("value", parola);
					
			String esempio = json.$get("example"); //i.e. json.get("word")
			$(esempioLb).text(esempio);
			$(hiddEsempio).attr("value", esempio);
					
			return null;
			});
	}
	
	/**
	 * Metodo statico che permette di creare un area in cui l'utente, attraverso un radio button, potrà scegliere
	 *  si o no per dare la sua risposta.
	 * @return Un div con all'interno i radio button per effettuare la scelta
	 */
	private static HTMLDivElement createChoiceArea()
	{
		
		HTMLDivElement siSelector = HTMLSelectionAreaDivElementBuilder.newBuilder()
				.Selector((HTMLInputElement) HTMLRadioButtonElementBuilder.newBuilder()
						.Value("SI")
						.Name("choice")
						.Id("SI")
						.Required(true)
						.build())
				.DivClassName("custom-control custom-checkbox")
				.LabelClassName("custom-control-label")
				.build();
		
		HTMLDivElement noSelector = HTMLSelectionAreaDivElementBuilder.newBuilder()
				.Selector((HTMLInputElement) HTMLRadioButtonElementBuilder.newBuilder()
						.Value("NO")
						.Name("choice")
						.Id("NO")
						.Required(true)
						.build())
				.DivClassName("custom-control custom-checkbox")
				.LabelClassName("custom-control-label")
				.build();
		
		HTMLDivElement siDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(siSelector))
				.ClassName("col")
				.NameAndId("siDiv")
				.build();
		
		HTMLDivElement noDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(noSelector))
				.ClassName("col")
				.NameAndId("noDiv")
				.build();
		
		return HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(siDiv, noDiv))
				.ClassName("row")
				.NameAndId("choicheAreaDiv")
				.build();
	}
}
