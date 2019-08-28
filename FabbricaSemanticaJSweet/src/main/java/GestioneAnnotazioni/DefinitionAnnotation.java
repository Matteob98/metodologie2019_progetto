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
 * Crea la pagina di definition annotation
 * Nella pagina è presente una parola ed una sua generalizzazione in inglese.
 * In questa pagina l'utente deve fornire una sua traduzione della parola
 * @author Matteo
 *
 */
public class DefinitionAnnotation 
{
	/**
	 * URL della servlet per la sottomissione
	 */
	private static final String DefinitionAnnotationSERVLET_URL = "definitionAnnotation.jsp";
	
	/**
	 * Testo della label di istruzione che andrà ad inizio Form
	 */
	private static final String testoLabel = 
			"Di seguito troverai una parola e una sua generalizzazione in inglese, "
			+ "fornisci una traduzione della parola nella tua lingua madre!";
	
	/**
	 * Task che serve per la chiamata a JSON
	 */
	private static final String task = "DEFINITION_ANNOTATION";
	
	/**
	 * Stringa contenente il nome del form
	 */
	private static final String formName = "DefinitionAnnotationForm";
	
	
	public static void main(String[] args)
	{
		//Controlla se l'utente è loggato, altrimenti reindirizza al login
		PagineGestioneUtente.LoginPage.isLogged(); 
		
		HTMLLabelElement parolaLb = AnnotationPageCreator.createParolaLb();
		
		//Elemento nascosto
		HTMLInputElement hiddParola = AnnotationPageCreator.createHidden("parolaLbHidden");
								
		HTMLLabelElement iperonimoLb = AnnotationPageCreator.createDescriptionLabel();
							
		//Elemento nascosto
		HTMLInputElement hiddIperonimo = AnnotationPageCreator.createHidden("descrizioneLbHidden");

		getData(parolaLb, hiddParola, iperonimoLb, hiddIperonimo);
		
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
							AnnotationPageCreator.createMenu(),
							AnnotationPageCreator.createLogoAndIstructionArea(testoLabel, "Definition Annotation"),
							AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola),
							AnnotationPageCreator.createDescriptionDiv(iperonimoLb, hiddIperonimo),
							AnnotationPageCreator.createDescriptionAndSubmitArea()
							))
				.Action(DefinitionAnnotationSERVLET_URL)
				.Name(formName)
				.ClassName("form-annotation")
				.build();
		
		$("body").append(form);
	}
	
	/**
	 * La label e l'hidden relativi alla parola da annotare/validare
	 * La label e l'hidden relativi all'iperonimo della parola
	 * Prende i dati dal database e li carica sugli elementi
	 * @param parolaLb Label dove inserire la parola da caricare
	 * @param hiddParola Elemento nascosto che accompagna la label
	 * @param iperonimoLb Label dove inserire la descrizione da caricare
	 * @param hiddIperonimo Elemento nascosto che accompagna la descrizione
	 */
	private static void getData(HTMLLabelElement parolaLb, HTMLInputElement hiddParola, HTMLLabelElement iperonimoLb, HTMLInputElement hiddIperonimo)
	{
		//Vado a prendere le opzioni dal json
		$.getJSON("nextExample.jsp", "task="+task, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
					
			String parola = json.$get("word"); //i.e. json.get("word")
			$(parolaLb).text(parola);
			$(hiddParola).attr("value", parola);
					
			String iperonimo = json.$get("hypernym"); //i.e. json.get("word")
			$(iperonimoLb).text(iperonimo);
			$(hiddIperonimo).attr("value", iperonimo);
					
			return null;
		});
	}
	

}
