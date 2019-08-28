/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un submit button html
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
    class HTMLSubmitElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder {
        constructor() {
            super();
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Valore del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'url dell'immagine che sostituisce il pulsante
         * @param {string} src Url dell'immagine da associare al pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Src(src) {
            this.addSrc(src);
            return this;
        }
        /**
         * Imposta l'altezza del button
         * @param {number} height altezza del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Height(height) {
            this.addHeight(height);
            return this;
        }
        /**
         * Imposta la larghezza del button
         * @param {number} width Larghezza del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Width(width) {
            this.addWidth(width);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required Obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Tipo del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.tipo = "submit";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "btn btn-primary";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            return new HTMLSubmitElementBuilder();
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder = HTMLSubmitElementBuilder;
    HTMLSubmitElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLSubmitElementBuilder";
    HTMLSubmitElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
