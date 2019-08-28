/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina di SenseAnotation
     * Nella pagina � presente una parola e l'utente deve fornire la sua traduzione
     * @author Matteo
     * @class
     */
    class SenseAnnotation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let parolaLb = GestioneAnnotazioni.AnnotationPageCreator.createParolaLb();
            let hiddParola = GestioneAnnotazioni.AnnotationPageCreator.createHidden("parolaLbHidden");
            let esempioLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddEsempio = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            let divCheck = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("custom-control").build();
            SenseAnnotation.getData(divCheck, parolaLb, hiddParola, esempioLb, hiddEsempio);
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(SenseAnnotation.testoLabel, "Sense Annotation"), GestioneAnnotazioni.AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(esempioLb, hiddEsempio), divCheck, GestioneAnnotazioni.AnnotationPageCreator.createSubmitArea()]).Action(SenseAnnotation.SenseAnnotationSERVLET_URL).NameAndId(SenseAnnotation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * Presi in input un divisore dove inserire i dati nelle checkbox,
         * La label e l'hidden relativi alla parola da annotare/validare
         * La label e l'hidden relativi all'esempio contenente la parola
         * Prende i dati dal database e li carica sugli elementi
         * @param {HTMLDivElement} divCheck div dove saranno caricate le check-box che utilizzer� l'utente
         * @param {HTMLLabelElement} parolaLb Label dove sar� caricata la parola relativa al senso
         * @param {HTMLInputElement} hiddParola Elemento nascosto che accompagna la label della parola
         * @param {HTMLLabelElement} esempioLb Label dove sar� caricata la descrizione della parola
         * @param {HTMLInputElement} hiddEsempio Elemento nascosto che accompagna la label della descrizione
         * @private
         */
        /*private*/ static getData(divCheck, parolaLb, hiddParola, esempioLb, hiddEsempio) {
            $.getJSON("nextExample.jsp", "task=" + SenseAnnotation.task, (result, a, ctx) => {
                let json = result;
                let senses = (json["senses"]);
                for (let index124 = 0; index124 < senses.length; index124++) {
                    let str = senses[index124];
                    {
                        $(divCheck).append(ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder.newBuilder().Value(str).Id(str).Name("senses").build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build());
                    }
                }
                let parola = (json["word"]);
                $(parolaLb).text(parola);
                $(hiddParola).attr("value", parola);
                let esempio = (json["example"]);
                $(esempioLb).text(esempio);
                $(hiddEsempio).attr("value", esempio);
                return null;
            });
        }
    }
    /**
     * URL della servlet per la sottomissione
     */
    SenseAnnotation.SenseAnnotationSERVLET_URL = "senseAnnotation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    SenseAnnotation.testoLabel = "Di seguito troverai una parola, scegli il suo corretto significato nella frase che segue!";
    /**
     * Task che serve per la chiamata a JSON
     */
    SenseAnnotation.task = "SENSE_ANNOTATION";
    /**
     * Stringa contenente il nome del form
     */
    SenseAnnotation.formName = "SenseAnnotationForm";
    GestioneAnnotazioni.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "GestioneAnnotazioni.SenseAnnotation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.SenseAnnotation.main(null);
