/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina di translation Validation
     * Nella pagina compare una parola ed una sua definizione.
     * L'utente dovr� indicare, tramite apposite check-box, quelle che secondo lui sono le migliori traduzioni
     * @author Matteo
     * @class
     */
    class TranslationValidation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let parolaLb = GestioneAnnotazioni.AnnotationPageCreator.createParolaLb();
            let hiddParola = GestioneAnnotazioni.AnnotationPageCreator.createHidden("parolaLbHidden");
            let descrizioneLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddDescrizione = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            let divCheck = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("custom-control").build();
            TranslationValidation.getData(divCheck, parolaLb, hiddParola, descrizioneLb, hiddDescrizione);
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(TranslationValidation.testoLabel, "Translation Validation"), GestioneAnnotazioni.AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(descrizioneLb, hiddDescrizione), divCheck, GestioneAnnotazioni.AnnotationPageCreator.createSubmitArea()]).Action(TranslationValidation.TranslationValidationSERVLET_URL).NameAndId(TranslationValidation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * Presi in input un divisore dove inserire i dati nelle checkbox,
         * La label e l'hidden relativi alla parola da annotare/validare
         * La label e l'hidden relativi alla descrizione della parola
         * Prende i dati dal database e li carica sugli elementi
         * @param {HTMLDivElement} divCheck Div dove saranno caricate le check-box per la selezione
         * @param {HTMLLabelElement} parolaLb Label dove sar� caricata la parola
         * @param {HTMLInputElement} hiddParola Elemento nascosto che accompagna la label della parola
         * @param {HTMLLabelElement} descrizioneLb Label dove sar� caricata la descrizione
         * @param {HTMLInputElement} hiddDescrizione Elemento nascosto che accompagna la label della descrizione
         * @private
         */
        /*private*/ static getData(divCheck, parolaLb, hiddParola, descrizioneLb, hiddDescrizione) {
            $(divCheck).append(ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder.newBuilder().Value("Nessuna delle seguenti").Id("Nessuna").Name("translations").build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build());
            $.getJSON("nextExample.jsp", "task=" + TranslationValidation.task, (result, a, ctx) => {
                let json = result;
                let translations = (json["translations"]);
                for (let index125 = 0; index125 < translations.length; index125++) {
                    let str = translations[index125];
                    {
                        $(divCheck).append(ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder.newBuilder().Value(str).Id(str).Name("translations").build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build());
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
    TranslationValidation.TranslationValidationSERVLET_URL = "translationValidation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    TranslationValidation.testoLabel = "Di seguito troverai una parola e la sua definizione, scegli quella che secondo te \u00e8 la migliore traduzione!";
    /**
     * Task che serve per la chiamata a JSON
     */
    TranslationValidation.task = "TRANSLATION_VALIDATION";
    /**
     * Stringa contenente il nome del form
     */
    TranslationValidation.formName = "TranslationValidationForm";
    GestioneAnnotazioni.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "GestioneAnnotazioni.TranslationValidation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.TranslationValidation.main(null);
