package GestioneAnnotazioni;

import static def.jquery.Globals.$;

import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLImageElement;

/**
 * Crea la pagina home
 * In caso l'utente non sia loggato la servlet rimanda alla loginPage
 * Altrimenti permette o di iniziare a validare/annotare o di andare al logout
 * @author Matteo
 *
 */
public class HomePage 
{
	/**
	 * Testo di introduzione che appare nella pagina di home
	 */
	private static final String testoIntroduzione = "Fabbrica Semantica è una piattaforma collaborativa di annotazione "
			+ "e validazione di dati linguistici e visuali. Ogni utente potrà fornire delle proprie traduzioni "
			+ "di termini, frasi o concetti, ed inoltre potrà validare le traduzioni offerte da altri utenti.";
	
	
	/**
	 * URL della servlet per il logout
	 */
	private static final String LogoutSERVLET_URL = "logout.jsp";
	
	public static void main(String[] args)
	{
		PagineGestioneUtente.LoginPage.isLogged(); //Controlla se l'utente è loggato, altrimenti reindirizza al login
		
		HTMLFormElement form = creaPaginaHome();
		
		$("body").append(form);
	}
	
	/**
	 * Crea la pagina home e ne restituisce il form
	 * @return Il form con all'interno tutti gli elementi che fanno parte della pagina di home
	 */
	private static HTMLFormElement creaPaginaHome()
	{		
		//Creo l'immagine
		HTMLImageElement image = HTMLImgElementBuilder.newBuilder()
						.Src("Img\\Logo_completo.png")
						.Width(300)
						.Height(300)
						.NameAndId("LogoElement")
						.build();
		
		HTMLDivElement imageDiv = HTMLDivElementBuilder.newBuilder()
						.elementi(Arrays.asList(image))
						.ClassName("form-group")
						.NameAndId("imageDiv")
						.build();
		
		HTMLLabelElement introduzioneLb = HTMLLabelElementBuilder.newBuilder()
				.testo(testoIntroduzione)
				.ClassName("introduzioneLb")
				.NameAndId("introduzioneLb")
				.build();
		
		HTMLDivElement introduzioneDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(introduzioneLb))
				.ClassName("form-group")
				.NameAndId("introduzioneDiv")
				.build();
		
		//Pulsante per proseguire
		HTMLInputElement submit = HTMLSubmitElementBuilder.newBuilder()
				.Src("Img\\Play.png")
				.ClassName(null)
				.Tipo("image")
				.NameAndId("submit")
				.Height(80)
				.Width(80)
				.build();
		
		HTMLDivElement submitDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(submit))
				.ClassName("form-play")
				.NameAndId("submitDiv")
				.build();

		

		HTMLAnchorElement link = (HTMLAnchorElement) HTMLAnchorElementBuilder.newBuilder()
				.InnerHtml("Logout")
				.ClassName("navbar-brand")
				.Href(LogoutSERVLET_URL)
				.NameAndId("linkLogout")
				.build();

		
		HTMLLabelElement datiUtenteLb = HTMLLabelElementBuilder.newBuilder()
				.ClassName("datiUtenteLb")
				.NameAndId("datiUtenteLb")
				.build();
		
		AnnotationPageCreator.getUserData(datiUtenteLb);

		
		HTMLDivElement datiUtenteDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(datiUtenteLb))
				.ClassName("collapse navbar-collapse")
				.NameAndId("datiUtenteDiv")
				.build();
		
		HTMLElement nav = HTMLNavElementBuilder.newBuilder()
				.elementi(Arrays.asList(datiUtenteDiv, link))
				.NameAndId("navHome")
				.build();
		
		
		String Action = AnnotationPageCreator.getRandomAnnotationPage();
		
		return (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi( Arrays.asList(nav, imageDiv,introduzioneDiv, submitDiv))
				.Action(Action)
				.NameAndId("paginaHomeForm")
				.ClassName("form-home")
				.build();
		
	}
	

}
