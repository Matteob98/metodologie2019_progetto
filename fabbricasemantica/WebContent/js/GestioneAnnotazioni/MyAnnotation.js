/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * PAGINA DI VALIDAZIONE
     * Crea la pagina con l'annotazione personalizzata
     * Consiste in una pagina dove l'utente ha a disposizione una parola ed una sua descrizione seguite da 4 possibili traduzioni
     * Per ogni traduzione l'utente dovr� valutare con un range input la qualit� della stessa.
     * @author Matteo
     * @class
     */
    class MyAnnotation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let parolaLb = GestioneAnnotazioni.AnnotationPageCreator.createParolaLb();
            let hiddParola = GestioneAnnotazioni.AnnotationPageCreator.createHidden("parolaLbHidden");
            let descrizioneLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddDescrizione = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            let divRange = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("custom-control").NameAndId("multipleRangeDiv").build();
            MyAnnotation.getData(divRange, parolaLb, hiddParola, descrizioneLb, hiddDescrizione);
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(MyAnnotation.testoLabel, "My Annotation"), GestioneAnnotazioni.AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione), divRange, GestioneAnnotazioni.AnnotationPageCreator.createSubmitArea()]).Action(MyAnnotation.MyAnnotationSERVLET_URL).NameAndId(MyAnnotation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * Presi in input un divisore dove inserire i dati nei range element,
         * La label e l'hidden relativi alla parola da annotare/validare
         * La label e l'hidden relativi alla descrizione della parola
         * Prende i dati dal database e li carica sugli elementi
         * @param {HTMLDivElement} divRange Div dove vengono inseriti i range che l'utente utilizzera per selezionare la traduzione
         * @param {HTMLLabelElement} parolaLb Label dove sar� caricata la parola
         * @param {HTMLInputElement} hiddParola Elemento nascosto che accompagna la label per la parola
         * @param {HTMLLabelElement} descrizioneLb Label dove sar� caricata la descrizione della parola
         * @param {HTMLInputElement} hiddDescrizione Elemento nascosto che accompagna la label della descrizione
         * @private
         */
        /*private*/ static getData(divRange, parolaLb, hiddParola, descrizioneLb, hiddDescrizione) {
            $.getJSON("nextExample.jsp", "task=" + MyAnnotation.task, (result, a, ctx) => {
                let json = result;
                let translations = (json["translations"]);
                for (let index123 = 0; index123 < translations.length; index123++) {
                    let str = translations[index123];
                    {
                        $(divRange).append(ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder.newBuilder().Name("translations").Id(str).build()).DivClassName("form-group").build());
                    }
                }
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
    MyAnnotation.MyAnnotationSERVLET_URL = "myAnnotation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    MyAnnotation.testoLabel = "Di seguito troverai una parola e una sua descrizione, indica la qualit\u00e0 di ognuna delle traduzioni proposte";
    /**
     * Task che serve per la chiamata a JSON
     */
    MyAnnotation.task = "MY_ANNOTATION";
    /**
     * Stringa contenente il nome del form
     */
    MyAnnotation.formName = "MyAnnotationForm";
    GestioneAnnotazioni.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "GestioneAnnotazioni.MyAnnotation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.MyAnnotation.main(null);
