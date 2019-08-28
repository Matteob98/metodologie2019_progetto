/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un range input html
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
     *
     * @author Matteo
     * @extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder
     * @class
     */
    class HTMLRangeInputElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder {
        constructor() {
            super();
            /**
             * Valore minimo
             */
            /*private*/ this.__min = 0;
            /**
             * Valore massimo
             */
            /*private*/ this.__max = 10;
            /**
             * Step tra un valore e l'altro
             */
            /*private*/ this.__step = 1.0;
        }
        /**
         * Imposta il valore minimo del range
         * @param {number} min Valore minimo selezionabile
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        min(min) {
            this.__min = min;
            return this;
        }
        /**
         * Imposta il valore massimo del range
         * @param {number} max Valore massimo selezionabile
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        max(max) {
            this.__max = max;
            return this;
        }
        /**
         * Imposta lo step tra un valore e l'altro del range
         * @param {number} step Intervallo tra un valore e l'altro
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        step(step) {
            this.__step = step;
            return this;
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Valore dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required Obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Tipo dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} HTMLRangeInputElementBuilder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.tipo = "range";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "custom-range";
            return new HTMLRangeInputElementBuilder();
        }
        /**
         *
         * @return {HTMLInputElement}
         */
        build() {
            let elm = super.build();
            elm.setAttribute("min", "" + this.__min);
            elm.setAttribute("max", "" + this.__max);
            elm.setAttribute("step", "" + this.__step);
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder = HTMLRangeInputElementBuilder;
    HTMLRangeInputElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLRangeInputElementBuilder";
    HTMLRangeInputElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
