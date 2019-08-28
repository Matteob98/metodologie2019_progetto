package PagineGestioneUtente;

import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import java.util.Arrays;

import ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder;
import ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLPswAreaBuilder;
import ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder;
import ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLImageElement;
import def.dom.HTMLInputElement;
import def.jquery.JQueryXHR;

/**
 * Classe Java che sarà transipilato in Js
 * Crea la pagina in cui l'utente andrà ad autenticarsi con email e password
 * Se l'utente non ha un account potrà utilizzare il testo per procedere alla registrazione
 * @author Matteo
 *
 */
public class LoginPage 
{
	private static final String LoginSERVLET_URL = "login.jsp";
	private static final String LoginHREFSignup = "signup.html";
	private static final String LoginsubmitText = "Login";
	private static final String LoginSignupLinkText = "Non sei ancora registrato? Registrati ora!";
	
	public static void main(String[] args)
	{
		HTMLFormElement form = creaPaginaDiLogin();
		
		//Aggiungo il form al corpo della pagina
		$("body").addClass("text-center");
		$("body").append(form);
	}
	

	/**
	 * Crea pagina di Login, formata da un immagine, il campo per inserire l'email, il campo per la password, 
	 * un link per il signup ed un pulsante per autenticarsi
	 * @return Il form contenente la pagina di login
	 */
	public static HTMLFormElement creaPaginaDiLogin()
	{
		HTMLImageElement image = HTMLImgElementBuilder.newBuilder()
				.Src("Img\\Logo_completo.png")
				.Width(300)
				.Height(300)
				.NameAndId("LogoElement")
				.build();
		
		//Creo il form		
		return (HTMLFormElement) HTMLFormElementBuilder.newBuilder()
				.elementi(Arrays.asList(
						image,
						createEmailPasswordArea(),
						createSubmitArea(LoginsubmitText, LoginSignupLinkText, LoginHREFSignup)))
				.Action(LoginSERVLET_URL)
				.NameAndId("loginForm")
				.ClassName("form-signin")
				.build();
	}
	
	/**
	 * Crea la pagina di sottomissione, dove è presente il pulsante per fare il submit ed un link che porta alla pagina
	 * di registrazione
	 * @param submitText Il testo da inserire nel pulsante di submit
	 * @param linkText Il testo da inserire nel link per uscire
	 * @param HREFlink L'url a cui indirizzare l'utente se si preme il link
	 * @return Un div contenente un area di sottomissione composta da un pulsante ed un link
	 */
	public static HTMLDivElement createSubmitArea(String submitText, String linkText, String HREFlink)
	{
		
		//Creazione del link alla pagina di registrazione
				HTMLAnchorElement exitLink = (HTMLAnchorElement) HTMLAnchorElementBuilder.newBuilder()
						.Href(HREFlink)
						.InnerHtml(linkText)
						.NameAndId("exitLink")
						.build();
				
		//Creazione del pulsante di sottomissione
		HTMLInputElement submit = (HTMLInputElement) HTMLSubmitElementBuilder.newBuilder()
				.Value(submitText)
				.NameAndId("submitButton")
				.ClassName("btn btn-lg btn-primary btn-block")
				.build();

		return (HTMLDivElement) HTMLVerticalDivElementBuilder.newBuilder()
				.elementi(Arrays.asList(exitLink, submit))
				.NameAndId("submitArea")
				.build();
	}
	
	/**
	 * Crea un DivElement che contiene i campi per inserire Email e Password
	 * @return Un div contenente un area con all'interno campi per inserire email e password
	 */
	public static HTMLDivElement createEmailPasswordArea()
	{
		//Creazione della email area, campo obbligatorio, e forzerà l'inserimenti in formato mail
		HTMLInputElement emailArea = (HTMLInputElement) HTMLEmailAreaBuilder.newBuilder()
				.PlaceHolder("esempio@indirizzo.it")
				.Required(true)
				.NameAndId("emailArea")
				.build();
		
		//Creazione della password area, campo obbligatorio e oscurato
		HTMLInputElement pswArea = (HTMLInputElement) HTMLPswAreaBuilder.newBuilder()
				.PlaceHolder("Inserisci la password")
				.Required(true)
				.NameAndId("pswArea")
				.build();
		
		
		return (HTMLDivElement) HTMLVerticalDivElementBuilder.newBuilder()
				.elementi( Arrays.asList(emailArea, pswArea))
				.NameAndId("emailPswArea")
				.build();
	}
	
	/**
	 * Controlla se l'utente risulta loggato oppure no.
	 * Non ritorna niente ma nel caso in cui l'utente non sia autenticato reindirizza 
	 * alla pagina di login
	 */
	public static void isLogged()
	{
		$.get("isLoggedIn.jsp", (Object result, String a, JQueryXHR ctx) -> {
			if(!((String)result).equals("true"))
				window.location.href = "login.html";
			return null;
			});
	}

}
