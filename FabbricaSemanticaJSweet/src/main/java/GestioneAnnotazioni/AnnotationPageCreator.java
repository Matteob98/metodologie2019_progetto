package GestioneAnnotazioni;

import static def.jquery.Globals.$;


import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder;
import ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLImageElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.Math;

/**
 * Classe non instanziabile che permette di creare in maniera modulare le pagine di annotazione e validazione
 * Tramite i metodi statici ritorna gli elementi per le pagine di annotazione/validazione
 * @author Matteo
 *
 */
public class AnnotationPageCreator 
{	
	/**
	 * String[] di tutte le pagine html di annotazione o validazione
	 */
	private static final String[] listaPagineAnnotazioneValidazione =
		{
				"wordAnnotation.html",
				"translationAnnotation.html",
				"definitionAnnotation.html",
				"senseAnnotation.html",
				"translationValidation.html",
				"senseValidation.html",
				"myAnnotation.html"
		};
	
	/**
	 * Costruttore privato in modo che la classe non possa essere instanziata
	 */
	private AnnotationPageCreator() {}
		
	/**
	 * Crea un div contenente il logo, il nome della pagina ed una label con le istruzioni passate in input
	 * @param testo Istruzioni da mostrare
	 * @param nomePagina nome della pagine di cui si deve creare il form
	 * @return Un div contenente il logo, il nome della pagina e le istruzioni relative
	 */
	public static HTMLDivElement createLogoAndIstructionArea(String testo, String nomePagina)
	{
		//Creo l'immagine
				HTMLImageElement image = HTMLImgElementBuilder.newBuilder()
						.Src("Img\\Logo_no_scritte.png")
						.Width(200)
						.Height(200)
						.NameAndId("LogoElement")
						.build();
		//Metto l'immagine in un div
		HTMLDivElement imageDiv = HTMLDivElementBuilder.newBuilder()
						.elementi(Arrays.asList(image))
						.ClassName("text-center")
						.NameAndId("imageDiv")
						.build();
				
		//Crea una label contentente le istruzioni
		HTMLLabelElement istruzioniLb = (HTMLLabelElement) HTMLLabelElementBuilder.newBuilder()
				.ClassName("istruction-lb")
				.testo(testo)
				.Name("istruzioniLb")
				.Id("istruzioniLb")
				.build();
		
		HTMLDivElement istructionDiv = HTMLDivElementBuilder.newBuilder()
				.ClassName("text-center")
				.NameAndId("istructionDiv")
				.elementi(Arrays.asList(istruzioniLb))
				.build();
		
		//Creo la label contenente il titolo
		HTMLLabelElement titoloLb = (HTMLLabelElement) HTMLLabelElementBuilder.newBuilder()
				.ClassName("title-lb")
				.testo(nomePagina)
				.NameAndId("titoloLb")
				.build();
		
		HTMLDivElement titoloDiv = HTMLDivElementBuilder.newBuilder()
				.ClassName("text-center")
				.NameAndId("titoloDiv")
				.elementi(Arrays.asList(titoloLb))
				.build();
		
		return HTMLVerticalDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(imageDiv,titoloDiv, istructionDiv))
				.NameAndId("istructionDiv")
				.build();
	}

	/**
	 * Crea un Div orizzontale che contiene pulsante di submit E di skip.
	 * Il primo invia la risposta dell'utente al database.
	 * Il secondo fa saltare l'annotazione/validazione e ne fornisce un'altra
	 * home e per andare al logout
	 * @return Un div contenente un pulsante per la sottomissione 
	 */
	public static HTMLDivElement createSubmitArea()
	{
		HTMLInputElement submit = (HTMLInputElement) HTMLSubmitElementBuilder.newBuilder()
				.Value("Avanti")
				.NameAndId("next")
				.build();
		
		HTMLDivElement submitDiv = HTMLDivElementBuilder.newBuilder()
				.ClassName("col")
				.elementi(Arrays.asList(submit))
				.NameAndId("submitDiv")
				.build();

		HTMLAnchorElement skip = HTMLAnchorElementBuilder.newBuilder()
				.InnerHtml("Salta")
				.Href(getRandomAnnotationPage())
				.NameAndId("skip_button")
				.ClassName("btn btn-secondary")
				.build();
		
		HTMLDivElement skipDiv = HTMLDivElementBuilder.newBuilder()
				.ClassName("col")
				.elementi(Arrays.asList(skip))
				.NameAndId("skipDiv")
				.build();

		
		return HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(skipDiv, submitDiv))
				.ClassName("row")
				.NameAndId("buttonDiv")
				.build();
	}
	
	/**
	 * Crea un nav bar (menu) contenente un link per tornare alla home, i dati utente ed un link al logout
	 * @return Un menu da posizionare nella parte alta del body
	 */
	public static HTMLElement createMenu()
	{
		HTMLAnchorElement homeLink = (HTMLAnchorElement) HTMLAnchorElementBuilder.newBuilder()
				.Href("home.html")
				.InnerHtml("Home")
				.NameAndId("homeLink")
				.ClassName("navbar-brand")
				.build();
		
		HTMLAnchorElement logoutLink = (HTMLAnchorElement) HTMLAnchorElementBuilder.newBuilder()
				.Href("logout.jsp")
				.InnerHtml("Logout")
				.NameAndId("logoutLink")
				.ClassName("navbar-brand")
				.build();
		
		HTMLLabelElement datiUtenteLb = HTMLLabelElementBuilder.newBuilder()
				.ClassName("datiUtenteLb")
				.NameAndId("datiUtenteLb")
				.build();
		
		AnnotationPageCreator.getUserData(datiUtenteLb);

		
		HTMLDivElement datiUtenteDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(datiUtenteLb))
				.ClassName("collapse navbar-collapse justify-content-md-center")
				.NameAndId("datiUtenteDiv")
				.build();
		
		return HTMLNavElementBuilder.newBuilder()
				.elementi(Arrays.asList(homeLink, datiUtenteDiv, logoutLink))
				.NameAndId("navHome")
				.build();
	}

	/**
	 * Crea un area dove è presente una TextArea dove l'utente inserisce la sua riposta
	 * e un Div orizzontale dove sono presenti i vari pulsanti per la sottomissione
	 * @return Div con all'interno un area in cui inserire la traduzione e l'area per la sottomissione
	 */
	public static HTMLDivElement createDescriptionAndSubmitArea()
	{
		HTMLTextAreaElement traduzioneTb = (HTMLTextAreaElement) HTMLTextAreaBuilder.newBuilder()
				.placeHolder("Inserisci la traduzione")
				.NameAndId("traduzioneTb")
				.build();
		
		HTMLDivElement traduzioneDiv = HTMLDivElementBuilder.newBuilder()
				.ClassName("form-group")
				.NameAndId("traduzioneDiv")
				.elementi(Arrays.asList(traduzioneTb))
				.build();
		
		return HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(traduzioneDiv, createSubmitArea()))
				.ClassName("form-group")
				.NameAndId("annotationDescriptionAndSubmitArea")
				.build();


	}

	/**
	 * Dato in input un HTMLElement o sottotipo, imposta il testo dell'element al valore ricevuto dalla
	 *  servlet userData (es. Ciao X Y. Traduzioni effettuate: W)
	 *  @param <T> HTMLElement o sottotipo
	 * @param elm Elemento in cui inserire i dati dell'utente
	 */
	public static <T extends HTMLElement> void getUserData(T elm)
	{
		$.get("userData.jsp", (Object result, String a, JQueryXHR ctx) -> {
			$(elm).text((String)result);
			return null;
			});
	}
	
	/**
	 * Crea e formatta una label con il className e il Name passati in input
	 * @param classAndName Classe e nome della label 
	 * @return Una label per le pagine di annotazione/validazione
	 */
	private static HTMLLabelElement createLabel(String classAndName)
	{
		return  HTMLLabelElementBuilder.newBuilder()
				.ClassName(classAndName)
				.NameAndId(classAndName)
				.build();
	}
	
	/**
	 * Crea e formatta la label che conterrà la parola da annotare/validare
	 * @return Una label in cui inserire la parola per le pagine di annotazione/validazione
	 */
	public static HTMLLabelElement createParolaLb()
	{
		return createLabel("parolaLb");
	}
	
	/**
	 * Crea e formatta la label che conterrà la descrizione, l'iperonimo o l'esempio 
	 * per le pagine di annotazione/validazione
	 * @return Una label in cui inserire la descrizione per le pagine di annotazione/validazione
	 */
	public static HTMLLabelElement createDescriptionLabel()
	{
		return createLabel("descrizioneLb");
	}

	
	/**
	 * Data in input la label che contiene la parola da annotare/validare ed un elemento
	 * nascosto ad essa associato, ritorna un div che contiene la label 
	 * ed un elemento nascosto, utile per prendere i dati della 
	 * label nel back-end
	 * @param label Label che contiene la parola da annotare/validare
	 * @param hidd Elemento nascosto associato alla label
	 * @return Un div che contiene la parola da annotare/validare
	 */
	public static HTMLDivElement createParolaDiv(HTMLLabelElement label, HTMLInputElement hidd)
	{
		return HTMLVerticalDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(label, hidd))
				.NameAndId("LabelDiv")
				.build();
	}
	
	
	/**
	 * Data in input la label che contiene la descrizione/iperonimo/esempio da annotare/validare ed un
	 * elemento nascosto ad essa associato,
	 *  ritorna un div che contiene la label ed un elemento nascosto, utile per prendere i dati della 
	 * label nel back-end
	 * @param label Label che contiene la descrizione della parola da annotare/validare
	 * @param hidd Elemento nascosto associato alla label
	 * @return Un div che contiene la descrizione della parola da annotare/validare
	 */
	public static HTMLDivElement createDescriptionDiv(HTMLLabelElement label, HTMLInputElement hidd)
	{
		return HTMLVerticalDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(label, hidd))
				.NameAndId("DescriptionDiv")
				.build();
	}
	
	/**
	 * Crea un elemento hidden, utile per prendere dati nel back-end
	 * ATTENZIONE: I dati che contiene saranno nascosti solo alla vista, 
	 * ma saranno accessibile ispezionando l'html della pagina
	 * @param name Nome dell'elemento nascosto
	 * @return Elemento nascosto, utile per prendere i dati nel back-end
	 */
	public static HTMLInputElement createHidden(String name)
	{
		return HTMLHiddenElementBuilder.newBuilder()
				.NameAndId(name)
				.build();
	}
	
	/**
	 * Ritorna un numero casuale tra 0 e la dimensione dell'array contenente i nomi delle pagine di validazione
	 * @return numero casuale
	 */
	private static int randomIndex()
	{
		return (int)(Math.random() * 100) % listaPagineAnnotazioneValidazione.length;
	}
	
	/**
	 * Ritorna una pagina di annotazione casuale
	 * @return Il nome di una pagina casuale
	 */
	protected static String getRandomAnnotationPage()
	{
		return listaPagineAnnotazioneValidazione[randomIndex()];
	}
}
