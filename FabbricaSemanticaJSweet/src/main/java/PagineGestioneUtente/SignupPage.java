package PagineGestioneUtente;

import static def.jquery.Globals.$;
import static def.dom.Globals.*;

import java.util.Arrays;
import java.util.List;

import ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder;
import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLPswAreaBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLImageElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLSelectElement;

/**
 * Crea la pagina con cui l'utente andrà a registrarsi al sito
 * Se l'utente ha già un account potrà procedere al login
 * @author Matteo
 *
 */
public class SignupPage 
{
	/**
	 * Livelli riconosciuti per le lingue straniere, eccetto madrelingua
	 */
	private final static List<String> livelliLinguaStraniera = Arrays.asList("Livello", "A1", "A2", "B1", "B2", "C1", "C2");
	/**
	 * Lista di tutte le linghe del mondo
	 */
	public final static List<String> lingueAggiuntive = Arrays.asList(
			"Scegli una lingua",
			"Afrikaans",
			"Albanese",
			"Amharico",
			"Arabo",
			"Armeno",
			"Basco",
			"Bengalese",
			"Bielorusso",
			"Birmano",
			"Bulgaro",
			"Catalano",
			"Ceco",
			"Cinese",
			"Croato",
			"Curdo",
			"Danese",
			"Dari",
			"Dzongkha",
			"Ebraico",
			"Esperanto",
			"Estone",
			"Faroese",
			"Farsi",
			"Finlandese",
			"Francese",
			"Gaelico",
			"Gallego",
			"Gallese",
			"Giapponese",
			"Greco",
			"Hindi",
			"Indonesiano",
			"Inglese",
			"Inuit",
			"Islandese",
			"Italiano",
			"Khmer",
			"Koreano",
			"Laotiano",
			"Lappone",
			"Lettone",
			"Lituano",
			"Macedone",
			"Malay",
			"Maltese",
			"Nepalese",
			"Norvegese",
			"Olandese",
			"Pashtu",
			"Polacco",
			"Portoghese",
			"Rumeno",
			"Russo",
			"Serbo",
			"Slovacco",
			"Sloveno",
			"Somalo",
			"Spagnolo",
			"Svedese",
			"Swahili",
			"Tagalog-Filipino",
			"Tagiko",
			"Tamil",
			"Tedesco",
			"Thai",
			"Tibetano",
			"Tigrinya",
			"Tongan",
			"Turco",
			"Turkmeno"
			);

	/**
	 * URL della servlet per il signup
	 */
	private static final String SignupSERVLET_URL = "singup.jsp";
	/**
	 * URL della pagina di login
	 */
	private static final String SignupHREFLogin = "login.html";
	/**
	 * Testo del pulsante di submit
	 */
	private static final String SignupSubmitText = "Registrati";
	/**
	 * Testo del link che riporta al login
	 */
	private static final String SignupLoginLinkText = "Torna al Login";
	
	
	public static void main(String[] args)
	{
		HTMLFormElement form = (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
						createMenu(SignupHREFLogin, SignupLoginLinkText),
						createSignupArea()))
				.Action(SignupSERVLET_URL)
				.ClassName("form-signup")
				.NameAndId("signupForm")
				.build();
	
		//Aggiungo il form al corpo della pagina
		$("body").append(form);
	}
	

	/**
	 * Crea un div contenente due campi per inserire nome e cognome dell'utente
	 * @return Un div contenente campi per inserire nome e cognome
	 */
	private static HTMLDivElement createFirstSecondName()
	{
		HTMLInputElement nomeTb = (HTMLInputElement) HTMLInputElementBuilder.newBuilder()
				.Required(true)
				.PlaceHolder("Inserisci il tuo nome")
				.NameAndId("nomeTb")
				.ClassName("form-control")
				.build();
		
		HTMLDivElement nomeDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(nomeTb))
				.ClassName("col-md-5 mb-3")
				.NameAndId("nomeDiv")
				.build();
		
		HTMLInputElement cognomeTb = (HTMLInputElement) HTMLInputElementBuilder.newBuilder()
				.Required(true)
				.PlaceHolder("Inserisci il tuo cognome")
				.NameAndId("cognomeTb")
				.ClassName("form-control")
				.build();

		HTMLDivElement cognomeDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(cognomeTb))
				.ClassName("col-md-5 mb-3")
				.NameAndId("cognomeTb")
				.build();
		
		return (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(nomeDiv,cognomeDiv))
				.ClassName("row")
				.NameAndId("firstSecondNameDiv")
				.build();
	}
	
	/**
	 * Crea il div per la registrazione dell'utente
	 * Contiene il logo del sito, i campi per inserire nome e cognome, il campo per inserire l'email, il campo per inserire
	 * la password, il campo per ripetere la psw, un div in cui inserire la lingua madre ed uno in cui inserire eventuali lingue aggiuntive
	 * Implementa il controllo di uguaglianza tra il campo per inserire la psw e quello per ripeterla, nel caso in cui
	 * uno dei due campi non corrisponda all'altro lancia un alert
	 * @return Un div con all'interno i campi per la registrazione dell'utente
	 */
	public static HTMLDivElement createSignupArea()
	{
		//Carico l'immagine
		HTMLImageElement image = HTMLImgElementBuilder.newBuilder()
				.Src("Img\\Logo_completo.png")
				.Width(300)
				.Height(300)
				.NameAndId("LogoElement")
				.build();
		
		//Inserisco l'immagine in un div
		HTMLDivElement imageDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(image))
				.ClassName("text-center")
				.NameAndId("imageDiv")
				.build();
		
		//Carico l'area per inserire nome e cognome
		HTMLDivElement nameAreaDiv = createFirstSecondName();
		
		//Carico l'area per inserire email e password
		HTMLDivElement emailPswDiv = createEmailPswArea();
		
		
		HTMLDivElement textAreaDiv = HTMLVerticalDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(nameAreaDiv, emailPswDiv))
				.ClassName("col-md-7 order-md-1")
				.NameAndId("textAreaInputDiv")
				.build();
		
		//Creo il Div in cui l'utente selezionerà le lingue parlate come madrelingua
		HTMLDivElement madreLinguaDiv = createMadreLinguaArea();
				
		//Creo il Div in cui l'utente selezionerà le altre lingue parlate
		HTMLDivElement lingueOpzionaliDiv = createAltreLingueArea();
		
		HTMLDivElement submitDiv = createSubmitArea(SignupSubmitText);
		
		HTMLDivElement lingueDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(madreLinguaDiv, lingueOpzionaliDiv))
				.ClassName("col-md-5 order-md-2 mb-4")
				.NameAndId("lingueAreaDiv")
				.build();
		
		
		
		HTMLDivElement signupDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(textAreaDiv, lingueDiv))
				.ClassName("row")
				.NameAndId("signupDiv")
				.build();

		
		return (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(imageDiv, signupDiv, submitDiv))
				.NameAndId("signupAreaForm")
				.ClassName("form-group")
				.build();
	}
	
	/**
	 * Crea un area dove l'utente può inserire email e password. E' inoltre presente un campo dove ripetere la psw per sicurezza.
	 * Implementa il controllo nel caso in cui l'utente non inserisca la stessa psw nei due campi, in tal caso invia un alert
	 * @return Un area con all'interno i campi per inserire email e password
	 */
	private static HTMLDivElement createEmailPswArea()
	{
		
		//Creazione della email area, campo obbligatorio, e forzerà l'inserimenti in formato mail
		HTMLInputElement emailArea = (HTMLInputElement) HTMLEmailAreaBuilder.newBuilder()
				.PlaceHolder("esempio@indirizzo.it")
				.Required(true)
				.NameAndId("emailArea")
				.build();
		
		HTMLDivElement emailAreaDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(emailArea))
				.ClassName("col-md-5 mb-3")
				.NameAndId("emailAreaDiv")
				.build();
		
		HTMLDivElement emailAreaRow = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(emailAreaDiv))
				.ClassName("row")
				.NameAndId("emailAreaRow")
				.build();
				 
		//Creazione della password area, campo obbligatorio e oscurato
		HTMLInputElement pswArea = (HTMLInputElement) HTMLPswAreaBuilder.newBuilder()
				.PlaceHolder("Inserisci la password")
				.Required(true)
				.NameAndId("pswArea")
				.build();
		
		HTMLDivElement pswAreaDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(pswArea))
				.ClassName("col-md-5 mb-3")
				.NameAndId("pswAreaDiv")
				.build();

		//Crea il secondo campo password dove l'utente convalida la password
		HTMLInputElement repeatPswArea = (HTMLInputElement) HTMLPswAreaBuilder.newBuilder()
					.PlaceHolder("Ripeti la password")
					.Required(true)
					.NameAndId("repeatPswArea")
					.build();
		
		HTMLDivElement repeatPswDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(repeatPswArea))
				.ClassName("col-md-5 mb-3")
				.NameAndId("repeatPswDiv")
				.build();

		//Imposta il controllo sulla psw
		$(pswArea).focusout((x)->
		{
			if(pswArea.value!= "" && repeatPswArea.value!="" && repeatPswArea.value!=pswArea.value)
				alert("La password non corrisponde");
			return x;
		});
		
		$(repeatPswArea).focusout((x)->
		{
			if(pswArea.value!= "" && repeatPswArea.value!="" && repeatPswArea.value!=pswArea.value)
				alert("La password non corrisponde");
			return x;
		});

		HTMLDivElement pswDiv = HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(pswAreaDiv, repeatPswDiv))
				.ClassName("row")
				.NameAndId("pswDivArea")
				.build();
				
		return HTMLDivElementBuilder.newBuilder()
					.elementi( Arrays.asList(emailAreaRow, pswDiv))
					.ClassName("mb-3")
					.NameAndId("emailPswArea")
					.build();
	}
	
	/**
	 * Crea l'area in cui l'utente, attraverso check-box, inserirà le lingue parlate come madrelingua
	 * @return Un div con all'interno i campi per inserire la lingua madre
	 */
	private static HTMLDivElement createMadreLinguaArea()
	{		
		//Creo l'area in cui chiedo all'utente di inserire le lingue parlate come madrelingua
		
		HTMLDivElement ItalianoDiv = (HTMLDivElement) HTMLSelectionAreaDivElementBuilder.newBuilder()
				.Selector((HTMLInputElement) HTMLCheckBoxElementBuilder.newBuilder()
						.Value("Italiano")
						.Name("madreLinguaCB")
						.Id("ItalianoCB")
						.build())
				.DivClassName("custom-control custom-checkbox")
				.LabelClassName("custom-control-label")				
				.build();
		
		HTMLDivElement IngleseDiv = HTMLSelectionAreaDivElementBuilder.newBuilder()
				.Selector((HTMLInputElement) HTMLCheckBoxElementBuilder.newBuilder()
						.Value("Inglese")
						.Name("madreLinguaCB")
						.Id("ingleseCB")
						.build())
				.DivClassName("custom-control custom-checkbox")
				.LabelClassName("custom-control-label")		
				.build();

	
		//Crea una label
		HTMLLabelElement madrelinguaLb  = (HTMLLabelElement) HTMLLabelElementBuilder.newBuilder()
				.testo("Lingue parlate come madrelingua")
				.NameAndId("madrelinguaLb")
				.ClassName("signupLb")
				.build();
		
		HTMLDivElement checkDiv = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(ItalianoDiv, IngleseDiv))
				.ClassName("form-group")
				.NameAndId("CheckBoxArea")
				.build();
		
		
		return (HTMLDivElement) HTMLVerticalDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(madrelinguaLb, checkDiv))
				.NameAndId("MadreLinguaArea")
				.build();
	}
	
	/**
	 * Crea l'area in cui l'utente, attraverso dei selector, inserirà le lingue parlate con il relativo livello
	 * @return Un div con all'interno i campi per inserire le lingue parlate dall'utente
	 */
	private static HTMLDivElement createAltreLingueArea()
	{
		//Creo l'area in cui chiedo all'utente le altre lingue parlate (opzionale)
				//Creo una label
		HTMLLabelElement altreLingueLb = (HTMLLabelElement) HTMLLabelElementBuilder.newBuilder()
				.testo("Altre lingue parlate")
				.NameAndId("altreLingueLb")
				.ClassName("signupLb")
				.build();
		
		/**
		 * Viene effettuato un ciclo in cui vengono creati 3(modificabile) gruppi di select element
		 * Ogni gruppo contiene due select element, uno per selezionare la lingua ed uno per il livello
		 * I select vengono a loro volta messi dentro dei div, ed infine vengono aggiungi all'array di div chiamato
		 *  divLingue 
		 */
		String[] lingue = {"prima", "seconda", "terza"};
		HTMLDivElement[] divLingue = new HTMLDivElement[lingue.length];
		
		for(int i=0; i<lingue.length; i++)
		{
			//Creo il select per la selezione della lingua opzionale
			HTMLSelectElement linguaOpzionale = (HTMLSelectElement) HTMLSelectElementBuilder.newBuilder()
					.opzioni(lingueAggiuntive)
					.NameAndId(lingue[i]+"LinguaOpzionale") //es. primaLinguaOpzionale
					.build();
			
			//Creo il div dove lo inserisco
			HTMLDivElement LinguaOpzionaleDiv = HTMLDivElementBuilder.newBuilder()
					.elementi(Arrays.asList(linguaOpzionale))
					.ClassName("col-md-5 mb-3")
					.NameAndId(lingue[i]+"LinguaOpzionaleDiv") //es. primaLinguaOpzionaleDiv
					.build();
			
			//Es. prima -> Prima
			String nrLingua = lingue[i].substring(0,1).toUpperCase() +
							lingue[i].substring(1, lingue[i].length()).toLowerCase();
			
			//Creo il select per la selezione del livello di conoscenza della lingua
			HTMLSelectElement livelloLingua = (HTMLSelectElement) HTMLSelectElementBuilder.newBuilder()
					.opzioni(livelliLinguaStraniera)
					.NameAndId("livello"+ nrLingua + "Lingua") //es. livelloPrimaLingua
					.build();
			
			//Creo il div dove lo inserisco
			HTMLDivElement livelloLinguaDiv = HTMLDivElementBuilder.newBuilder()
					.elementi(Arrays.asList(livelloLingua))
					.ClassName("col-md-5 mb-3")
					.NameAndId("livello"+nrLingua+"LinguaDiv") //es. livelloPrimaLingua
					.build();
			
			//Inserisco entrambi i div in un unico div che inserisco nell'array di div
			divLingue[i] = (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
					.elementi(Arrays.asList(LinguaOpzionaleDiv, livelloLinguaDiv))
					.ClassName("row")
					.NameAndId(lingue[i]+"LinguaDiv")
					.build();
			
		}
	
		//Metto tutte e tre le scelte per le lingue opzionali in un unico div Verticale per migliorare l'organizzazione
		return (HTMLDivElement) HTMLVerticalDivElementBuilder.newBuilder()
				.elementi( Arrays.asList(altreLingueLb, divLingue[0], divLingue[1], divLingue[2]))
				.NameAndId("altreLingueArea")
				.build();
	
	}
	
	/**
	 * Crea HTMlDivElement contenente il pulsante di submit che registra l'utente
	 * @param submitText Testo che appare nel pulsante di sottomissione
	 * @return Un div contentne il pulsante per la sottomissione
	 */
	public static HTMLDivElement createSubmitArea(String submitText)
	{
		//Creazione del pulsante di sottomissione
		HTMLInputElement submit = (HTMLInputElement) HTMLSubmitElementBuilder.newBuilder()
				.Value(submitText)
				.NameAndId("submitButton")
				.build();
		
		return (HTMLDivElement) HTMLDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(submit))
				.ClassName("submit-row")
				.NameAndId("submitArea")
				.build();
	}
	
	/**
	 * Crea il menu per il signup, composto dal solo link per tornare alla pagina di login
	 * @param HREFlink URl a cui porta il link del menu
	 * @param linkText Testo del link nel menu
	 * @return Un menu da posizionare nella parte superiore del body
	 */
	public static HTMLElement createMenu(String HREFlink, String linkText)
	{
		//Creazione del link alla pagina di registrazione
		HTMLAnchorElement exitLink = (HTMLAnchorElement) HTMLAnchorElementBuilder.newBuilder()
						.Href(HREFlink)
						.InnerHtml(linkText)
						.NameAndId("exitLink")
						.ClassName("navbar-brand")
						.build();
		
		HTMLDivElement divAppoggio = HTMLDivElementBuilder.newBuilder()
						.ClassName("collapse navbar-collapse")
						.build();
		
		return HTMLNavElementBuilder.newBuilder()
				.elementi(Arrays.asList(divAppoggio, exitLink))
				.NameAndId("signupNav")
				.build();
		
		
	}
}
