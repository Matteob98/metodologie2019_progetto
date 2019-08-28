/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un divisore(div) html
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
    class HTMLDivElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.__elementi === undefined)
                this.__elementi = null;
        }
        /**
         * Aggiunge gli elementi al div
         * @param {HTMLElement[]} elements Gli elementi da aggiungere al div
         */
        addElementi(elements) {
            this.__elementi = elements;
        }
        /**
         * Aggiunge gli elementi al div e ne ritorna il builder
         * @param {HTMLElement[]} elements Gli elementi da aggiungere al div
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        elementi(elements) {
            this.addElementi(elements);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        static newBuilder() {
            return new HTMLDivElementBuilder();
        }
        /**
         *
         * @return {HTMLDivElement}
         */
        build() {
            let elm = document.createElement(HTMLDivElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (this.__elementi != null)
                for (let i = 0; i < this.__elementi.length; i++) {
                    $(elm).append(/* get */ this.__elementi[i]);
                }
            return elm;
        }
    }
    /**
     * Tipo del div
     */
    HTMLDivElementBuilder.stringType = "div";
    ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder = HTMLDivElementBuilder;
    HTMLDivElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder";
    HTMLDivElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
