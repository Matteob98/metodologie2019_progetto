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
 * Crea la pagina di SenseAnotation
 * Nella pagina è presente una parola e l'utente deve fornire la sua traduzione
 * @author Matteo
 *
 */
public class SenseAnnotation 
{
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String SenseAnnotationSERVLET_URL = "senseAnnotation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una parola, scegli il suo corretto significato nella frase"
			+ " che segue!";
	
	/**
	 * Task che serve per la chiamata a JSON
	 */
	private static final String task = "SENSE_ANNOTATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "SenseAnnotationForm";
	
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login

		HTMLLabelElement parolaLb = AnnotationPageCreator.createParolaLb();
		
		//Elemento nascosto
		HTMLInputElement hiddParola = AnnotationPageCreator.createHidden("parolaLbHidden");
								
		HTMLLabelElement esempioLb = AnnotationPageCreator.createDescriptionLabel();
							
		//Elemento nascosto
		HTMLInputElement hiddEsempio = AnnotationPageCreator.createHidden("descrizioneLbHidden");

		HTMLDivElement divCheck = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.ClassName("custom-control")
				.build();
		
		getData(divCheck, parolaLb, hiddParola, esempioLb, hiddEsempio);
		
		
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "Sense Annotation"),
							AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola),
							AnnotationPageCreator.createDescriptionDiv(esempioLb, hiddEsempio),
							divCheck,
							AnnotationPageCreator.createSubmitArea()))
				.Action(SenseAnnotationSERVLET_URL)
				.NameAndId(formName)
				.ClassName("form-annotation")
				.build();

		$("body").append(form);
	}
	
	/**
	 * Presi in input un divisore dove inserire i dati nelle checkbox, 
	 * La label e l'hidden relativi alla parola da annotare/validare
	 * La label e l'hidden relativi all'esempio contenente la parola
	 * Prende i dati dal database e li carica sugli elementi
	 * @param divCheck div dove saranno caricate le check-box che utilizzerà l'utente
	 * @param parolaLb Label dove sarà caricata la parola relativa al senso
	 * @param hiddParola Elemento nascosto che accompagna la label della parola
	 * @param esempioLb Label dove sarà caricata la descrizione della parola
	 * @param hiddEsempio Elemento nascosto che accompagna la label della descrizione
	 */
	private static void getData(HTMLDivElement divCheck, HTMLLabelElement parolaLb, HTMLInputElement hiddParola, HTMLLabelElement esempioLb, HTMLInputElement hiddEsempio)
	{
		//Vado a prendere le opzioni dal json
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String[] senses = json.$get("senses"); //i.e. json.get("word")
			for(String str : senses)
			{
				$(divCheck).append(HTMLSelectionAreaDivElementBuilder.newBuilder()
						.Selector((HTMLInputElement) HTMLCheckBoxElementBuilder.newBuilder()
								.Value(str)
								.Id(str)
								.Name("senses")
								.build())
						.DivClassName("custom-control custom-checkbox")
						.LabelClassName("custom-control-label")
						.build());
			}
			String parola = json.$get("word"); //i.e. json.get("word")
			$(parolaLb).text(parola);
			$(hiddParola).attr("value", parola);
					
			String esempio = json.$get( "example"); //i.e. json.get("word")
			$(esempioLb).text(esempio);
			$(hiddEsempio).attr("value", esempio);
					
			return null;
		});		
	}
}
