/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea una checkbox html
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
    class HTMLCheckBoxElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder {
        constructor() {
            super();
            if (this.checked === undefined)
                this.checked = false;
        }
        /**
         * Imposta il checked/unchecked della checkbox
         * @param {boolean} checked True se la casella parte gi� spuntata, false altrimenti
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        Checked(checked) {
            this.checked = checked;
            return this;
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Valore della casella
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required Obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Tipo dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'elelemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id della casella
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome della casella
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id della casella
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.tipo = "checkbox";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "custom-control-input";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            return new HTMLCheckBoxElementBuilder();
        }
        /**
         *
         * @return {HTMLInputElement}
         */
        build() {
            let elm = super.build();
            elm.checked = this.checked;
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder = HTMLCheckBoxElementBuilder;
    HTMLCheckBoxElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLCheckBoxElementBuilder";
    HTMLCheckBoxElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
