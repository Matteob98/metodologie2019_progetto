/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un radio button html
     * Implementa il builder pattern
     * Per creare l'oggetto desiderato utilizzare prima il metodo statico newBuilder() che ritorna il builder,
     * dopodich�, tramite i metodi della classe impostare gli attributi dell'oggetto. Una volta finito, con il metodo build()
     * verr� ritornato l'oggetto.
     *
     * <br><br><b>Esempio di utilizzo</b><br>
     * ElementBuilder.newBuilder()<br>
     * .className(nome)<br>
     * .Id(id)<br>
     * .Name(name)<br>
     * .build()<br>
     * @author Matteo
     * @extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder
     * @class
     */
    class HTMLRadioButtonElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder {
        constructor() {
            super();
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Il valore dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Il testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required L'obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Il tipo dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Il nome e l'id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.tipo = "radio";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "custom-control-input";
            return new HTMLRadioButtonElementBuilder();
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder = HTMLRadioButtonElementBuilder;
    HTMLRadioButtonElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLRadioButtonElementBuilder";
    HTMLRadioButtonElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
