/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina home
     * In caso l'utente non sia loggato la servlet rimanda alla loginPage
     * Altrimenti permette o di iniziare a validare/annotare o di andare al logout
     * @author Matteo
     * @class
     */
    class HomePage {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let form = HomePage.creaPaginaHome();
            $("body").append(form);
        }
        /**
         * Crea la pagina home e ne restituisce il form
         * @return {HTMLFormElement} Il form con all'interno tutti gli elementi che fanno parte della pagina di home
         * @private
         */
        /*private*/ static creaPaginaHome() {
            let image = ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder.newBuilder().Src("Img\\Logo_completo.png").Width(300).Height(300).NameAndId("LogoElement").build();
            let imageDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [image]).ClassName("form-group").NameAndId("imageDiv").build();
            let introduzioneLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().testo(HomePage.testoIntroduzione).ClassName("introduzioneLb").NameAndId("introduzioneLb").build();
            let introduzioneDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [introduzioneLb]).ClassName("form-group").NameAndId("introduzioneDiv").build();
            let submit = ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder.newBuilder().Src("Img\\Play.png").ClassName(null).Tipo("image").NameAndId("submit").Height(80).Width(80).build();
            let submitDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [submit]).ClassName("form-play").NameAndId("submitDiv").build();
            let link = ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder.newBuilder().InnerHtml("Logout").ClassName("navbar-brand").Href(HomePage.LogoutSERVLET_URL).NameAndId("linkLogout").build();
            let datiUtenteLb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().ClassName("datiUtenteLb").NameAndId("datiUtenteLb").build();
            GestioneAnnotazioni.AnnotationPageCreator.getUserData(datiUtenteLb);
            let datiUtenteDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [datiUtenteLb]).ClassName("collapse navbar-collapse").NameAndId("datiUtenteDiv").build();
            let nav = ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder.newBuilder().elementi(/* asList */ [datiUtenteDiv, link]).NameAndId("navHome").build();
            let Action = GestioneAnnotazioni.AnnotationPageCreator.getRandomAnnotationPage();
            return ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [nav, imageDiv, introduzioneDiv, submitDiv]).Action(Action).NameAndId("paginaHomeForm").ClassName("form-home").build();
        }
    }
    /**
     * Testo di introduzione che appare nella pagina di home
     */
    HomePage.testoIntroduzione = "Fabbrica Semantica \u00e8 una piattaforma collaborativa di annotazione e validazione di dati linguistici e visuali. Ogni utente potr\u00e0 fornire delle proprie traduzioni di termini, frasi o concetti, ed inoltre potr\u00e0 validare le traduzioni offerte da altri utenti.";
    /**
     * URL della servlet per il logout
     */
    HomePage.LogoutSERVLET_URL = "logout.jsp";
    GestioneAnnotazioni.HomePage = HomePage;
    HomePage["__class"] = "GestioneAnnotazioni.HomePage";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.HomePage.main(null);
