/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea una text area html
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
     * @extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder
     * @class
     */
    class HTMLTextAreaBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.__placeHolder === undefined)
                this.__placeHolder = null;
            if (this.__required === undefined)
                this.__required = false;
        }
        /**
         * Imposta il testo il sovrimpressione
         * @param {string} placeHolder Il testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        placeHolder(placeHolder) {
            this.__placeHolder = placeHolder;
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo
         * @param {boolean} required L'obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        required(required) {
            this.__required = required;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Il nome e l'id del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "textarea";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "form-control";
            return new HTMLTextAreaBuilder();
        }
        /**
         *
         * @return {HTMLTextAreaElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (this.__placeHolder != null)
                elm.placeholder = this.__placeHolder;
            elm.required = this.__required;
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder = HTMLTextAreaBuilder;
    HTMLTextAreaBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLTextAreaBuilder";
    HTMLTextAreaBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
