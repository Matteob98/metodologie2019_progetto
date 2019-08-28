/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea una label html
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
    class HTMLLabelElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.__testo === undefined)
                this.__testo = null;
            if (this.__For === undefined)
                this.__For = null;
        }
        /**
         * Imposta il testo della Label
         * @param {string} testo Il testo della label
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        testo(testo) {
            this.__testo = testo;
            return this;
        }
        /**
         * Dato l'id di un altro elemento html, imposta l'elemento a cui la label si appoggia.
         * Utile quando si lavora ad esempio con checkbox, radio button ecc.
         * @param {string} For Id dell'elemento a cui la label si appoggia
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        For(For) {
            this.__For = For;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id della label
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome della label
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e Id della label
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "label";
            return new HTMLLabelElementBuilder();
        }
        /**
         *
         * @return {HTMLLabelElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (this.__testo != null)
                $(elm).text(this.__testo);
            if (this.__For != null)
                elm.htmlFor = this.__For;
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder = HTMLLabelElementBuilder;
    HTMLLabelElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder";
    HTMLLabelElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
