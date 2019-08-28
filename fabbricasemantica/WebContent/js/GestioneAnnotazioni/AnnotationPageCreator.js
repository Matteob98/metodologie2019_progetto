/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Classe non instanziabile che permette di creare in maniera modulare le pagine di annotazione e validazione
     * Tramite i metodi statici ritorna gli elementi per le pagine di annotazione/validazione
     * @author Matteo
     * @class
     */
    class AnnotationPageCreator {
        constructor() {
        }
        static listaPagineAnnotazioneValidazione_$LI$() { if (AnnotationPageCreator.listaPagineAnnotazioneValidazione == null)
            AnnotationPageCreator.listaPagineAnnotazioneValidazione = ["wordAnnotation.html", "translationAnnotation.html", "definitionAnnotation.html", "senseAnnotation.html", "translationValidation.html", "senseValidation.html", "myAnnotation.html"]; return AnnotationPageCreator.listaPagineAnnotazioneValidazione; }
        ;
        /**
         * Crea un div contenente il logo, il nome della pagina ed una label con le istruzioni passate in input
         * @param {string} testo Istruzioni da mostrare
         * @param {string} nomePagina nome della pagine di cui si deve creare il form
         * @return {HTMLDivElement} Un div contenente il logo, il nome della pagina e le istruzioni relative
         */
        static createLogoAndIstructionArea(testo, nomePagina) {
            let image = ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder.newBuilder().Src("Img\\Logo_no_scritte.png").Width(200).Height(200).NameAndId("LogoElement").build();
            let imageDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [image]).ClassName("text-center").NameAndId("imageDiv").build();
            let istruzioniLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().ClassName("istruction-lb").testo(testo).Name("istruzioniLb").Id("istruzioniLb").build();
            let istructionDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("text-center").NameAndId("istructionDiv").elementi(/* asList */ [istruzioniLb]).build();
            let titoloLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().ClassName("title-lb").testo(nomePagina).NameAndId("titoloLb").build();
            let titoloDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("text-center").NameAndId("titoloDiv").elementi(/* asList */ [titoloLb]).build();
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [imageDiv, titoloDiv, istructionDiv]).NameAndId("istructionDiv").build();
        }
        /**
         * Crea un Div orizzontale che contiene pulsante di submit E di skip.
         * Il primo invia la risposta dell'utente al database.
         * Il secondo fa saltare l'annotazione/validazione e ne fornisce un'altra
         * home e per andare al logout
         * @return {HTMLDivElement} Un div contenente un pulsante per la sottomissione
         */
        static createSubmitArea() {
            let submit = ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder.newBuilder().Value("Avanti").NameAndId("next").build();
            let submitDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("col").elementi(/* asList */ [submit]).NameAndId("submitDiv").build();
            let skip = ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder.newBuilder().InnerHtml("Salta").Href(AnnotationPageCreator.getRandomAnnotationPage()).NameAndId("skip_button").ClassName("btn btn-secondary").build();
            let skipDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("col").elementi(/* asList */ [skip]).NameAndId("skipDiv").build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [skipDiv, submitDiv]).ClassName("row").NameAndId("buttonDiv").build();
        }
        /**
         * Crea un nav bar (menu) contenente un link per tornare alla home, i dati utente ed un link al logout
         * @return {HTMLElement} Un menu da posizionare nella parte alta del body
         */
        static createMenu() {
            let homeLink = ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder.newBuilder().Href("home.html").InnerHtml("Home").NameAndId("homeLink").ClassName("navbar-brand").build();
            let logoutLink = ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder.newBuilder().Href("logout.jsp").InnerHtml("Logout").NameAndId("logoutLink").ClassName("navbar-brand").build();
            let datiUtenteLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().ClassName("datiUtenteLb").NameAndId("datiUtenteLb").build();
            AnnotationPageCreator.getUserData(datiUtenteLb);
            let datiUtenteDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [datiUtenteLb]).ClassName("collapse navbar-collapse justify-content-md-center").NameAndId("datiUtenteDiv").build();
            return ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder.newBuilder().elementi(/* asList */ [homeLink, datiUtenteDiv, logoutLink]).NameAndId("navHome").build();
        }
        /**
         * Crea un area dove � presente una TextArea dove l'utente inserisce la sua riposta
         * e un Div orizzontale dove sono presenti i vari pulsanti per la sottomissione
         * @return {HTMLDivElement} Div con all'interno un area in cui inserire la traduzione e l'area per la sottomissione
         */
        static createDescriptionAndSubmitArea() {
            let traduzioneTb = ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder.newBuilder().placeHolder("Inserisci la traduzione").NameAndId("traduzioneTb").build();
            let traduzioneDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("form-group").NameAndId("traduzioneDiv").elementi(/* asList */ [traduzioneTb]).build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [traduzioneDiv, AnnotationPageCreator.createSubmitArea()]).ClassName("form-group").NameAndId("annotationDescriptionAndSubmitArea").build();
        }
        /**
         * Dato in input un HTMLElement o sottotipo, imposta il testo dell'element al valore ricevuto dalla
         * servlet userData (es. Ciao X Y. Traduzioni effettuate: W)
         * @param <T> HTMLElement o sottotipo
         * @param {HTMLElement} elm Elemento in cui inserire i dati dell'utente
         */
        static getUserData(elm) {
            $.get("userData.jsp", (result, a, ctx) => {
                $(elm).text(result);
                return null;
            });
        }
        /**
         * Crea e formatta una label con il className e il Name passati in input
         * @param {string} classAndName Classe e nome della label
         * @return {HTMLLabelElement} Una label per le pagine di annotazione/validazione
         * @private
         */
        /*private*/ static createLabel(classAndName) {
            return ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().ClassName(classAndName).NameAndId(classAndName).build();
        }
        /**
         * Crea e formatta la label che conterr� la parola da annotare/validare
         * @return {HTMLLabelElement} Una label in cui inserire la parola per le pagine di annotazione/validazione
         */
        static createParolaLb() {
            return AnnotationPageCreator.createLabel("parolaLb");
        }
        /**
         * Crea e formatta la label che conterr� la descrizione, l'iperonimo o l'esempio
         * per le pagine di annotazione/validazione
         * @return {HTMLLabelElement} Una label in cui inserire la descrizione per le pagine di annotazione/validazione
         */
        static createDescriptionLabel() {
            return AnnotationPageCreator.createLabel("descrizioneLb");
        }
        /**
         * Data in input la label che contiene la parola da annotare/validare ed un elemento
         * nascosto ad essa associato, ritorna un div che contiene la label
         * ed un elemento nascosto, utile per prendere i dati della
         * label nel back-end
         * @param {HTMLLabelElement} label Label che contiene la parola da annotare/validare
         * @param {HTMLInputElement} hidd Elemento nascosto associato alla label
         * @return {HTMLDivElement} Un div che contiene la parola da annotare/validare
         */
        static createParolaDiv(label, hidd) {
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [label, hidd]).NameAndId("LabelDiv").build();
        }
        /**
         * Data in input la label che contiene la descrizione/iperonimo/esempio da annotare/validare ed un
         * elemento nascosto ad essa associato,
         * ritorna un div che contiene la label ed un elemento nascosto, utile per prendere i dati della
         * label nel back-end
         * @param {HTMLLabelElement} label Label che contiene la descrizione della parola da annotare/validare
         * @param {HTMLInputElement} hidd Elemento nascosto associato alla label
         * @return {HTMLDivElement} Un div che contiene la descrizione della parola da annotare/validare
         */
        static createDescriptionDiv(label, hidd) {
            return ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder.newBuilder().elementi(/* asList */ [label, hidd]).NameAndId("DescriptionDiv").build();
        }
        /**
         * Crea un elemento hidden, utile per prendere dati nel back-end
         * ATTENZIONE: I dati che contiene saranno nascosti solo alla vista,
         * ma saranno accessibile ispezionando l'html della pagina
         * @param {string} name Nome dell'elemento nascosto
         * @return {HTMLInputElement} Elemento nascosto, utile per prendere i dati nel back-end
         */
        static createHidden(name) {
            return ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder.newBuilder().NameAndId(name).build();
        }
        /**
         * Ritorna un numero casuale tra 0 e la dimensione dell'array contenente i nomi delle pagine di validazione
         * @return {number} numero casuale
         * @private
         */
        /*private*/ static randomIndex() {
            return ((Math.random() * 100) | 0) % AnnotationPageCreator.listaPagineAnnotazioneValidazione_$LI$().length;
        }
        /**
         * Ritorna una pagina di annotazione casuale
         * @return {string} Il nome di una pagina casuale
         */
        static getRandomAnnotationPage() {
            return AnnotationPageCreator.listaPagineAnnotazioneValidazione_$LI$()[AnnotationPageCreator.randomIndex()];
        }
    }
    GestioneAnnotazioni.AnnotationPageCreator = AnnotationPageCreator;
    AnnotationPageCreator["__class"] = "GestioneAnnotazioni.AnnotationPageCreator";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.AnnotationPageCreator.listaPagineAnnotazioneValidazione_$LI$();
