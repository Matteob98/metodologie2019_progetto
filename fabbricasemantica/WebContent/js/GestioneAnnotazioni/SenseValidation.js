/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var GestioneAnnotazioni;
(function (GestioneAnnotazioni) {
    /**
     * Crea la pagina di sense validation
     * Nella pagina � presente una parola ed una frase di esempio in cui la parola appare.
     * L'utente dovr� fornire la sua traduzione della parola
     * @author Matteo
     * @class
     */
    class SenseValidation {
        static main(args) {
            PagineGestioneUtente.LoginPage.isLogged();
            let parolaLb = GestioneAnnotazioni.AnnotationPageCreator.createParolaLb();
            let hiddParola = GestioneAnnotazioni.AnnotationPageCreator.createHidden("parolaLbHidden");
            let esempioLb = GestioneAnnotazioni.AnnotationPageCreator.createDescriptionLabel();
            let hiddEsempio = GestioneAnnotazioni.AnnotationPageCreator.createHidden("descrizioneLbHidden");
            let senseLabel = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().ClassName("senseLb").NameAndId("senseLabel").build();
            let hiddSense = ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder.newBuilder().NameAndId("senseLbHidden").build();
            let divSense = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("form-group").elementi(/* asList */ [senseLabel, hiddSense]).build();
            SenseValidation.getData(senseLabel, hiddSense, parolaLb, hiddParola, esempioLb, hiddEsempio);
            let divSpaziatore = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName("custom-control").build();
            let form = ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder.newBuilder().elementi(/* asList */ [GestioneAnnotazioni.AnnotationPageCreator.createMenu(), GestioneAnnotazioni.AnnotationPageCreator.createLogoAndIstructionArea(SenseValidation.testoLabel, "Sense Validation"), GestioneAnnotazioni.AnnotationPageCreator.createParolaDiv(parolaLb, hiddParola), GestioneAnnotazioni.AnnotationPageCreator.createDescriptionDiv(esempioLb, hiddEsempio), divSense, SenseValidation.createChoiceArea(), divSpaziatore, GestioneAnnotazioni.AnnotationPageCreator.createSubmitArea()]).Action(SenseValidation.SenseValidationSERVLET_URL).NameAndId(SenseValidation.formName).ClassName("form-annotation").build();
            $("body").append(form);
        }
        /**
         * Dati, a coppie di label e hidden element, gli elementi per : il senso, la parola e l'esempio, la funzione
         * prende i dati dal back-end e li salva sugli elementi passati in input
         * @param {HTMLLabelElement} senseLabel Label dove sar� caricato il senso da validare
         * @param {HTMLInputElement} hiddSense Elemento nascosto che accompagna la label del senso
         * @param {HTMLLabelElement} parolaLb Label dove sar� caricata la parola relativa al senso
         * @param {HTMLInputElement} hiddParola Elemento nascosto che accompagna la label della parola
         * @param {HTMLLabelElement} esempioLb Label dove sar� caricato un esempio
         * @param {HTMLInputElement} hiddEsempio Elemento nascosto che accompagna la label dell'esempio
         * @private
         */
        /*private*/ static getData(senseLabel, hiddSense, parolaLb, hiddParola, esempioLb, hiddEsempio) {
            $.getJSON("nextExample.jsp", "task=" + SenseValidation.task, (result, a, ctx) => {
                let json = result;
                let sense = (json["sense"]);
                $(senseLabel).text(sense);
                $(hiddSense).attr("value", sense);
                let parola = (json["word"]);
                $(parolaLb).text(parola);
                $(hiddParola).attr("value", parola);
                let esempio = (json["example"]);
                $(esempioLb).text(esempio);
                $(hiddEsempio).attr("value", esempio);
                return null;
            });
        }
        /**
         * Metodo statico che permette di creare un area in cui l'utente, attraverso un radio button, potr� scegliere
         * si o no per dare la sua risposta.
         * @return {HTMLDivElement} Un div con all'interno i radio button per effettuare la scelta
         * @private
         */
        /*private*/ static createChoiceArea() {
            let siSelector = ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder.newBuilder().Value("SI").Name("choice").Id("SI").Required(true).build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build();
            let noSelector = ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder.newBuilder().Selector(ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder.newBuilder().Value("NO").Name("choice").Id("NO").Required(true).build()).DivClassName("custom-control custom-checkbox").LabelClassName("custom-control-label").build();
            let siDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [siSelector]).ClassName("col").NameAndId("siDiv").build();
            let noDiv = ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [noSelector]).ClassName("col").NameAndId("noDiv").build();
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().elementi(/* asList */ [siDiv, noDiv]).ClassName("row").NameAndId("choicheAreaDiv").build();
        }
    }
    /**
     * URL della servlet per la sottomissione
     */
    SenseValidation.SenseValidationSERVLET_URL = "senseValidation.jsp";
    /**
     * Testo della label di istruzione che andr� ad inizio Form
     */
    SenseValidation.testoLabel = "Di seguito troverai una parola e una frase in cui appare, indica se il senso fornito \u00e8 appropriato oppure no!";
    /**
     * Task che serve per la chiamata a JSON
     */
    SenseValidation.task = "SENSE_VALIDATION";
    /**
     * Stringa contenente il nome del form
     */
    SenseValidation.formName = "SenseValidationForm";
    GestioneAnnotazioni.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "GestioneAnnotazioni.SenseValidation";
})(GestioneAnnotazioni || (GestioneAnnotazioni = {}));
GestioneAnnotazioni.SenseValidation.main(null);
