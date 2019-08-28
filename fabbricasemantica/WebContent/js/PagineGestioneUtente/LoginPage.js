/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var PagineGestioneUtente;
(function (PagineGestioneUtente) {
    /**
     * Classe Java che sar� transipilato in Js
     * Crea la pagina in cui l'utente andr� ad autenticarsi con email e password
     * Se l'utente non ha un account potr� utilizzare il testo per procedere alla registrazione
     * @author Matteo
     * @class
     */
    class LoginPage {
        static main(args) {
            let form = LoginPage.creaPaginaDiLogin();
            $("body").addClass("text-center");
            $("body").append(form);
        }
        /**
         * Crea pagina di Login, formata da un immagine, il campo per inserire l'email, il campo per la password,
         * un link per il signup ed un pulsante per autenticarsi
         * @return {HTMLFormElement} Il form contenente la pagina di login
         */
        static creaPaginaDiLogin() {
            let image = ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder.newBuilder().Src("Img\\Logo_completo.png").Width(300).Height(300).NameAndId("LogoElement").build();
            return ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [image, LoginPage.createEmailPasswordArea(), LoginPage.createSubmitArea(LoginPage.LoginsubmitText, LoginPage.LoginSignupLinkText, LoginPage.LoginHREFSignup)]).Action(LoginPage.LoginSERVLET_URL).NameAndId("loginForm").ClassName("form-signin").build();
        }
        /**
         * Crea la pagina di sottomissione, dove � presente il pulsante per fare il submit ed un link che porta alla pagina
         * di registrazione
         * @param {string} submitText Il testo da inserire nel pulsante di submit
         * @param {string} linkText Il testo da inserire nel link per uscire
         * @param {string} HREFlink L'url a cui indirizzare l'utente se si preme il link
         * @return {HTMLDivElement} Un div contenente un area di sottomissione composta da un pulsante ed un link
         */
        static createSubmitArea(submitText, linkText, HREFlink) {
            let exitLink = ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder.newBuilder().Href(HREFlink).InnerHtml(linkText).NameAndId("exitLink").build();
            let submit = ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder.newBuilder().Value(submitText).NameAndId("submitButton").ClassName("btn btn-lg btn-primary btn-block").build();
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [exitLink, submit]).NameAndId("submitArea").build();
        }
        /**
         * Crea un DivElement che contiene i campi per inserire Email e Password
         * @return {HTMLDivElement} Un div contenente un area con all'interno campi per inserire email e password
         */
        static createEmailPasswordArea() {
            let emailArea = ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder.newBuilder().PlaceHolder("esempio@indirizzo.it").Required(true).NameAndId("emailArea").build();
            let pswArea = ClassiPerCreazioneElementiHTML.HTMLPswAreaBuilder.newBuilder().PlaceHolder("Inserisci la password").Required(true).NameAndId("pswArea").build();
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [emailArea, pswArea]).NameAndId("emailPswArea").build();
        }
        /**
         * Controlla se l'utente risulta loggato oppure no.
         * Non ritorna niente ma nel caso in cui l'utente non sia autenticato reindirizza
         * alla pagina di login
         */
        static isLogged() {
            $.get("isLoggedIn.jsp", (result, a, ctx) => {
                if (!((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(result, "true"))
                    window.location.href = "login.html";
                return null;
            });
        }
    }
    LoginPage.LoginSERVLET_URL = "login.jsp";
    LoginPage.LoginHREFSignup = "signup.html";
    LoginPage.LoginsubmitText = "Login";
    LoginPage.LoginSignupLinkText = "Non sei ancora registrato? Registrati ora!";
    PagineGestioneUtente.LoginPage = LoginPage;
    LoginPage["__class"] = "PagineGestioneUtente.LoginPage";
})(PagineGestioneUtente || (PagineGestioneUtente = {}));
PagineGestioneUtente.LoginPage.main(null);
