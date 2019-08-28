/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var PagineGestioneUtente;
(function (PagineGestioneUtente) {
    /**
     * Crea la pagina con cui l'utente andr� a registrarsi al sito
     * Se l'utente ha gi� un account potr� procedere al login
     * @author Matteo
     * @class
     */
    class SignupPage {
        static livelliLinguaStraniera_$LI$() { if (SignupPage.livelliLinguaStraniera == null)
            SignupPage.livelliLinguaStraniera = ["Livello", "A1", "A2", "B1", "B2", "C1", "C2"]; return SignupPage.livelliLinguaStraniera; }
        ;
        static lingueAggiuntive_$LI$() { if (SignupPage.lingueAggiuntive == null)
            SignupPage.lingueAggiuntive = ["Scegli una lingua", "Afrikaans", "Albanese", "Amharico", "Arabo", "Armeno", "Basco", "Bengalese", "Bielorusso", "Birmano", "Bulgaro", "Catalano", "Ceco", "Cinese", "Croato", "Curdo", "Danese", "Dari", "Dzongkha", "Ebraico", "Esperanto", "Estone", "Faroese", "Farsi", "Finlandese", "Francese", "Gaelico", "Gallego", "Gallese", "Giapponese", "Greco", "Hindi", "Indonesiano", "Inglese", "Inuit", "Islandese", "Italiano", "Khmer", "Koreano", "Laotiano", "Lappone", "Lettone", "Lituano", "Macedone", "Malay", "Maltese", "Nepalese", "Norvegese", "Olandese", "Pashtu", "Polacco", "Portoghese", "Rumeno", "Russo", "Serbo", "Slovacco", "Sloveno", "Somalo", "Spagnolo", "Svedese", "Swahili", "Tagalog-Filipino", "Tagiko", "Tamil", "Tedesco", "Thai", "Tibetano", "Tigrinya", "Tongan", "Turco", "Turkmeno"]; return SignupPage.lingueAggiuntive; }
        ;
        static main(args) {
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [SignupPage.createMenu(SignupPage.SignupHREFLogin, SignupPage.SignupLoginLinkText), SignupPage.createSignupArea()]).Action(SignupPage.SignupSERVLET_URL).ClassName("form-signup").NameAndId("signupForm").build();
            $("body").append(form);
        }
        /**
         * Crea un div contenente due campi per inserire nome e cognome dell'utente
         * @return {HTMLDivElement} Un div contenente campi per inserire nome e cognome
         * @private
         */
        /*private*/ static createFirstSecondName() {
            let nomeTb = ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.newBuilder().Required(true).PlaceHolder("Inserisci il tuo nome").NameAndId("nomeTb").ClassName("form-control").build();
            let nomeDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [nomeTb]).ClassName("col-md-5 mb-3").NameAndId("nomeDiv").build();
            let cognomeTb = ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.newBuilder().Required(true).PlaceHolder("Inserisci il tuo cognome").NameAndId("cognomeTb").ClassName("form-control").build();
            let cognomeDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [cognomeTb]).ClassName("col-md-5 mb-3").NameAndId("cognomeTb").build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [nomeDiv, cognomeDiv]).ClassName("row").NameAndId("firstSecondNameDiv").build();
        }
        /**
         * Crea il div per la registrazione dell'utente
         * Contiene il logo del sito, i campi per inserire nome e cognome, il campo per inserire l'email, il campo per inserire
         * la password, il campo per ripetere la psw, un div in cui inserire la lingua madre ed uno in cui inserire eventuali lingue aggiuntive
         * Implementa il controllo di uguaglianza tra il campo per inserire la psw e quello per ripeterla, nel caso in cui
         * uno dei due campi non corrisponda all'altro lancia un alert
         * @return {HTMLDivElement} Un div con all'interno i campi per la registrazione dell'utente
         */
        static createSignupArea() {
            let image = ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder.newBuilder().Src("Img\\Logo_completo.png").Width(300).Height(300).NameAndId("LogoElement").build();
            let imageDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [image]).ClassName("text-center").NameAndId("imageDiv").build();
            let nameAreaDiv = SignupPage.createFirstSecondName();
            let emailPswDiv = SignupPage.createEmailPswArea();
            let textAreaDiv = ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [nameAreaDiv, emailPswDiv]).ClassName("col-md-7 order-md-1").NameAndId("textAreaInputDiv").build();
            let madreLinguaDiv = SignupPage.createMadreLinguaArea();
            let lingueOpzionaliDiv = SignupPage.createAltreLingueArea();
            let submitDiv = SignupPage.createSubmitArea(SignupPage.SignupSubmitText);
            let lingueDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [madreLinguaDiv, lingueOpzionaliDiv]).ClassName("col-md-5 order-md-2 mb-4").NameAndId("lingueAreaDiv").build();
            let signupDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [textAreaDiv, lingueDiv]).ClassName("row").NameAndId("signupDiv").build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [imageDiv, signupDiv, submitDiv]).NameAndId("signupAreaForm").ClassName("form-group").build();
        }
        /**
         * Crea un area dove l'utente pu� inserire email e password. E' inoltre presente un campo dove ripetere la psw per sicurezza.
         * Implementa il controllo nel caso in cui l'utente non inserisca la stessa psw nei due campi, in tal caso invia un alert
         * @return {HTMLDivElement} Un area con all'interno i campi per inserire email e password
         * @private
         */
        /*private*/ static createEmailPswArea() {
            let emailArea = ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder.newBuilder().PlaceHolder("esempio@indirizzo.it").Required(true).NameAndId("emailArea").build();
            let emailAreaDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [emailArea]).ClassName("col-md-5 mb-3").NameAndId("emailAreaDiv").build();
            let emailAreaRow = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [emailAreaDiv]).ClassName("row").NameAndId("emailAreaRow").build();
            let pswArea = ClassiPerCreazioneElementiHTML.HTMLPswAreaBuilder.newBuilder().PlaceHolder("Inserisci la password").Required(true).NameAndId("pswArea").build();
            let pswAreaDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [pswArea]).ClassName("col-md-5 mb-3").NameAndId("pswAreaDiv").build();
            let repeatPswArea = ClassiPerCreazioneElementiHTML.HTMLPswAreaBuilder.newBuilder().PlaceHolder("Ripeti la password").Required(true).NameAndId("repeatPswArea").build();
            let repeatPswDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [repeatPswArea]).ClassName("col-md-5 mb-3").NameAndId("repeatPswDiv").build();
            $(pswArea).focusout(((pswArea, repeatPswArea) => {
                return (x) => {
                    if (pswArea.value !== "" && repeatPswArea.value !== "" && repeatPswArea.value !== pswArea.value)
                        alert("La password non corrisponde");
                    return x;
                };
            })(pswArea, repeatPswArea));
            $(repeatPswArea).focusout(((pswArea, repeatPswArea) => {
                return (x) => {
                    if (pswArea.value !== "" && repeatPswArea.value !== "" && repeatPswArea.value !== pswArea.value)
                        alert("La password non corrisponde");
                    return x;
                };
            })(pswArea, repeatPswArea));
            let pswDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [pswAreaDiv, repeatPswDiv]).ClassName("row").NameAndId("pswDivArea").build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [emailAreaRow, pswDiv]).ClassName("mb-3").NameAndId("emailPswArea").build();
        }
        /**
         * Crea l'area in cui l'utente, attraverso check-box, inserir� le lingue parlate come madrelingua
         * @return {HTMLDivElement} Un div con all'interno i campi per inserire la lingua madre
         * @private
         */
        /*private*/ static createMadreLinguaArea() {
            let ItalianoDiv = ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder.newBuilder().Value("Italiano").Name("madreLinguaCB").Id("ItalianoCB").build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build();
            let IngleseDiv = ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder.newBuilder().Value("Inglese").Name("madreLinguaCB").Id("ingleseCB").build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build();
            let madrelinguaLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().testo("Lingue parlate come madrelingua").NameAndId("madrelinguaLb").ClassName("signupLb").build();
            let checkDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [ItalianoDiv, IngleseDiv]).ClassName("form-group").NameAndId("CheckBoxArea").build();
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [madrelinguaLb, checkDiv]).NameAndId("MadreLinguaArea").build();
        }
        /**
         * Crea l'area in cui l'utente, attraverso dei selector, inserir� le lingue parlate con il relativo livello
         * @return {HTMLDivElement} Un div con all'interno i campi per inserire le lingue parlate dall'utente
         * @private
         */
        /*private*/ static createAltreLingueArea() {
            let altreLingueLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().testo("Altre lingue parlate").NameAndId("altreLingueLb").ClassName("signupLb").build();
            let lingue = ["prima", "seconda", "terza"];
            let divLingue = (s => { let a = []; while (s-- > 0)
                a.push(null); return a; })(lingue.length);
            for (let i = 0; i < lingue.length; i++) {
                {
                    let linguaOpzionale = ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder.newBuilder().opzioni(SignupPage.lingueAggiuntive_$LI$()).NameAndId(lingue[i] + "LinguaOpzionale").build();
                    let LinguaOpzionaleDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [linguaOpzionale]).ClassName("col-md-5 mb-3").NameAndId(lingue[i] + "LinguaOpzionaleDiv").build();
                    let nrLingua = lingue[i].substring(0, 1).toUpperCase() + lingue[i].substring(1, lingue[i].length).toLowerCase();
                    let livelloLingua = ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder.newBuilder().opzioni(SignupPage.livelliLinguaStraniera_$LI$()).NameAndId("livello" + nrLingua + "Lingua").build();
                    let livelloLinguaDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [livelloLingua]).ClassName("col-md-5 mb-3").NameAndId("livello" + nrLingua + "LinguaDiv").build();
                    divLingue[i] = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [LinguaOpzionaleDiv, livelloLinguaDiv]).ClassName("row").NameAndId(lingue[i] + "LinguaDiv").build();
                }
                ;
            }
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [altreLingueLb, divLingue[0], divLingue[1], divLingue[2]]).NameAndId("altreLingueArea").build();
        }
        /**
         * Crea HTMlDivElement contenente il pulsante di submit che registra l'utente
         * @param {string} submitText Testo che appare nel pulsante di sottomissione
         * @return {HTMLDivElement} Un div contentne il pulsante per la sottomissione
         */
        static createSubmitArea(submitText) {
            let submit = ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder.newBuilder().Value(submitText).NameAndId("submitButton").build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [submit]).ClassName("submit-row").NameAndId("submitArea").build();
        }
        /**
         * Crea il menu per il signup, composto dal solo link per tornare alla pagina di login
         * @param {string} HREFlink URl a cui porta il link del menu
         * @param {string} linkText Testo del link nel menu
         * @return {HTMLElement} Un menu da posizionare nella parte superiore del body
         */
        static createMenu(HREFlink, linkText) {
            let exitLink = ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder.newBuilder().Href(HREFlink).InnerHtml(linkText).NameAndId("exitLink").ClassName("navbar-brand").build();
            let divAppoggio = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("collapse navbar-collapse").build();
            return ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder.newBuilder().elementi(/* asList */ [divAppoggio, exitLink]).NameAndId("signupNav").build();
        }
    }
    /**
     * URL della servlet per il signup
     */
    SignupPage.SignupSERVLET_URL = "singup.jsp";
    /**
     * URL della pagina di login
     */
    SignupPage.SignupHREFLogin = "login.html";
    /**
     * Testo del pulsante di submit
     */
    SignupPage.SignupSubmitText = "Registrati";
    /**
     * Testo del link che riporta al login
     */
    SignupPage.SignupLoginLinkText = "Torna al Login";
    PagineGestioneUtente.SignupPage = SignupPage;
    SignupPage["__class"] = "PagineGestioneUtente.SignupPage";
})(PagineGestioneUtente || (PagineGestioneUtente = {}));
PagineGestioneUtente.SignupPage.lingueAggiuntive_$LI$();
PagineGestioneUtente.SignupPage.livelliLinguaStraniera_$LI$();
PagineGestioneUtente.SignupPage.main(null);
