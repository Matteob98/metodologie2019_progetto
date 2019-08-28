/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un elemento input html
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
     * @extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder
     * @class
     */
    class HTMLInputElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.src === undefined)
                this.src = null;
            if (this.height === undefined)
                this.height = 0;
            if (this.width === undefined)
                this.width = 0;
            if (this.placeHolder === undefined)
                this.placeHolder = null;
            if (this.required === undefined)
                this.required = false;
            if (this.value === undefined)
                this.value = null;
        }
        /**
         * Aggiunge il valore all'elemento
         * @param {string} value Valore dell'elemento
         */
        addValue(value) {
            this.value = value;
        }
        /**
         * Aggiunge il testo in sovrimpressione
         * @param {string} placeHolder Testo in sovrimpressione
         */
        addPlaceHolder(placeHolder) {
            this.placeHolder = placeHolder;
        }
        /**
         * Aggiunge l'obbligatoriet� del campo
         * @param {boolean} required Obbligatoriet� del campo
         */
        addRequired(required) {
            this.required = required;
        }
        /**
         * Imposta l'src dell'elemento
         * @param {string} src Url collegato all'elemento
         */
        addSrc(src) {
            this.src = src;
        }
        /**
         * Imposta l'altezza dell'elemento
         * @param {number} height Altezza dell'elemento
         */
        addHeight(height) {
            this.height = height;
        }
        /**
         * Imposta la larghezza dell'elemento
         * @param {number} width Larghezza dell'elemento
         */
        addWidth(width) {
            this.width = width;
        }
        /**
         * Aggiunge il tipo
         * @param {string} newTipo Tipo dell'elemento
         */
        addTipo(newTipo) {
            HTMLInputElementBuilder.tipo = newTipo;
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Valore dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required Obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Tipo dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            HTMLInputElementBuilder.tipo = "input";
            return new HTMLInputElementBuilder();
        }
        /**
         *
         * @return {HTMLInputElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (HTMLInputElementBuilder.tipo != null)
                elm.type = HTMLInputElementBuilder.tipo;
            if (this.placeHolder != null)
                elm.placeholder = this.placeHolder;
            elm.required = this.required;
            if (this.value != null)
                elm.value = this.value;
            if (this.src != null)
                elm.src = this.src;
            if (this.height !== 0)
                elm.height = ('' + (this.height));
            if (this.width !== 0)
                elm.width = ('' + (this.width));
            return elm;
        }
    }
    /**
     * Tipo dell'input
     */
    HTMLInputElementBuilder.tipo = "input";
    ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder = HTMLInputElementBuilder;
    HTMLInputElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder";
    HTMLInputElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
