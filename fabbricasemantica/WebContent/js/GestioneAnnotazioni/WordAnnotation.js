/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina di wordAnnotation
     * Nella pagina sar� presente una definizione di una parola
     * L'utente dovr� scrivere quella che secondo lui � la traduzione della parola descritta sopra
     * @author Matteo
     * @class
     */
    class WordAnnotation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let descrizioneLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddDescrizione = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            WordAnnotation.getDescrizione(descrizioneLb, hiddDescrizione);
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(WordAnnotation.testoLabel, "Word Annotation"), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionAndSubmitArea()]).Action(WordAnnotation.WordAnnotationSERVLET_URL).NameAndId(WordAnnotation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * Passati in input una label e un input element, prende i dati dal back-end e li salva
         * sui due elementi
         * @param {HTMLLabelElement} lb Label dove sar� caricata la descrizione
         * @param {HTMLInputElement} hidd Elemento nascosto che accompagna la label
         * @private
         */
        /*private*/ static getDescrizione(lb, hidd) {
            $.getJSON("nextExample.jsp", "task=" + WordAnnotation.task, (result, a, ctx) => {
                let json = result;
                let risultato = (json["description"]);
                $(lb).text(risultato);
                $(lb).attr("value", risultato);
                $(hidd).text(risultato);
                $(hidd).attr("value", risultato);
                return null;
            });
        }
    }
    /**
     * URL della servlet per la sottomissione
     */
    WordAnnotation.WordAnnotationSERVLET_URL = "wordAnnotation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    WordAnnotation.testoLabel = "Di seguito troverai una definizione in inglese, prova ad indovinare di quale parola stiamo parlando e scrivi la sua traduzione nella tua lingua madre!";
    /**
     * Nome del task per la chiamata a JSon
     */
    WordAnnotation.task = "WORD_ANNOTATION";
    /**
     * Stringa contenente il nome del form
     */
    WordAnnotation.formName = "WordAnnotationForm";
    GestioneAnnotazioni.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "GestioneAnnotazioni.WordAnnotation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.WordAnnotation.main(null);
