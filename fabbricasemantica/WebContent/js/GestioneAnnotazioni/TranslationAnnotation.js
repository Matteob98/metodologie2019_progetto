/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina di translationAnnotation
     * Nella pagina compare una parola e una sua definizione.
     * L'utente deve fornire una traduzione della parola
     * @author Matteo
     * @class
     */
    class TranslationAnnotation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let parolaLb = GestioneAnnotazioni.AnnotationPageCreator.createParolaLb();
            let hiddParola = GestioneAnnotazioni.AnnotationPageCreator.createHidden("parolaLbHidden");
            let descrizioneLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddDescrizione = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            TranslationAnnotation.getData(parolaLb, hiddParola, descrizioneLb, hiddDescrizione);
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(TranslationAnnotation.testoLabel, "Translation Annotation"), GestioneAnnotazioni.AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionAndSubmitArea()]).Action(TranslationAnnotation.TranslationAnnotationSERVLET_URL).NameAndId(TranslationAnnotation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * Presi in input:
         * La label e l'hidden relativi alla parola da annotare/validare
         * La label e l'hidden relativi alla descrizione della parola
         * Prende i dati dal database e li carica sugli elementi
         * @param {HTMLLabelElement} parolaLb Label dove sar� caricata la parola
         * @param {HTMLInputElement} hiddParola Elemento nascosto che accompagna la label della parola
         * @param {HTMLLabelElement} descrizioneLb Label dove sar� caricata la descrizione della parola
         * @param {HTMLInputElement} hiddDescrizione Elemento nascosto che accompagna la label della descrizione
         * @private
         */
        /*private*/ static getData(parolaLb, hiddParola, descrizioneLb, hiddDescrizione) {
            $.getJSON("nextExample.jsp", "task=" + TranslationAnnotation.task, (result, a, ctx) => {
                let json = result;
                let parola = (json["word"]);
                $(parolaLb).text(parola);
                $(hiddParola).attr("value", parola);
                let descrizione = (json["description"]);
                $(descrizioneLb).text(descrizione);
                $(hiddDescrizione).attr("value", descrizione);
                return null;
            });
        }
    }
    /**
     * URL della servlet per la sottomissione
     */
    TranslationAnnotation.TranslationAnnotationSERVLET_URL = "translationAnnotation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    TranslationAnnotation.testoLabel = "Di seguito troverai una parola e la sua definizione in inglese, fornisci una traduzione nella tua lingua madre!";
    /**
     * Task che serve per la chiamata a JSON
     */
    TranslationAnnotation.task = "TRANSLATION_ANNOTATION";
    /**
     * Stringa contenente il nome del form
     */
    TranslationAnnotation.formName = "TranslationAnnotationForm";
    GestioneAnnotazioni.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "GestioneAnnotazioni.TranslationAnnotation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.TranslationAnnotation.main(null);
