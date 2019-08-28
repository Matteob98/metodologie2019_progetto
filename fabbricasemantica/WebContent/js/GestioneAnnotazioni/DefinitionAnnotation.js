/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina di definition annotation
     * Nella pagina � presente una parola ed una sua generalizzazione in inglese.
     * In questa pagina l'utente deve fornire una sua traduzione della parola
     * @author Matteo
     * @class
     */
    class DefinitionAnnotation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let parolaLb = GestioneAnnotazioni.AnnotationPageCreator.createParolaLb();
            let hiddParola = GestioneAnnotazioni.AnnotationPageCreator.createHidden("parolaLbHidden");
            let iperonimoLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddIperonimo = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            DefinitionAnnotation.getData(parolaLb, hiddParola, iperonimoLb, hiddIperonimo);
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(DefinitionAnnotation.testoLabel, "Definition Annotation"), GestioneAnnotazioni.AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(iperonimoLb, hiddIperonimo), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionAndSubmitArea()]).Action(DefinitionAnnotation.DefinitionAnnotationSERVLET_URL).Name(DefinitionAnnotation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * La label e l'hidden relativi alla parola da annotare/validare
         * La label e l'hidden relativi all'iperonimo della parola
         * Prende i dati dal database e li carica sugli elementi
         * @param {HTMLLabelElement} parolaLb Label dove inserire la parola da caricare
         * @param {HTMLInputElement} hiddParola Elemento nascosto che accompagna la label
         * @param {HTMLLabelElement} iperonimoLb Label dove inserire la descrizione da caricare
         * @param {HTMLInputElement} hiddIperonimo Elemento nascosto che accompagna la descrizione
         * @private
         */
        /*private*/ static getData(parolaLb, hiddParola, iperonimoLb, hiddIperonimo) {
            $.getJSON("nextExample.jsp", "task=" + DefinitionAnnotation.task, (result, a, ctx) => {
                let json = result;
                let parola = (json["word"]);
                $(parolaLb).text(parola);
                $(hiddParola).attr("value", parola);
                let iperonimo = (json["hypernym"]);
                $(iperonimoLb).text(iperonimo);
                $(hiddIperonimo).attr("value", iperonimo);
                return null;
            });
        }
    }
    /**
     * URL della servlet per la sottomissione
     */
    DefinitionAnnotation.DefinitionAnnotationSERVLET_URL = "definitionAnnotation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    DefinitionAnnotation.testoLabel = "Di seguito troverai una parola e una sua generalizzazione in inglese, fornisci una traduzione della parola nella tua lingua madre!";
    /**
     * Task che serve per la chiamata a JSON
     */
    DefinitionAnnotation.task = "DEFINITION_ANNOTATION";
    /**
     * Stringa contenente il nome del form
     */
    DefinitionAnnotation.formName = "DefinitionAnnotationForm";
    GestioneAnnotazioni.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "GestioneAnnotazioni.DefinitionAnnotation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.DefinitionAnnotation.main(null);
