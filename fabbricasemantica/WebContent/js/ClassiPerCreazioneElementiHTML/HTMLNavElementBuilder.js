/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea una nav bar html (barra per men� solitamente posizionata in alto)
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
    class HTMLNavElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.__elementi === undefined)
                this.__elementi = null;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "nav";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "navbar navbar-expand-md navbar-dark bg-dark mb-4";
            return new HTMLNavElementBuilder();
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Il nome e l'id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Aggiunge gli elementi al nav e ne ritorna il builder
         * @param {HTMLElement[]} elements Gli elementi da aggiungere al nav
         * @return {ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder} Il builder
         */
        elementi(elements) {
            this.__elementi = elements;
            return this;
        }
        /**
         *
         * @return {HTMLElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
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
    ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder = HTMLNavElementBuilder;
    HTMLNavElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLNavElementBuilder";
    HTMLNavElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
