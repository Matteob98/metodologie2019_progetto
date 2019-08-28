/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un Link html
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
     *
     * @author Matteo
     * @extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder
     * @class
     */
    class HTMLAnchorElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.href === undefined)
                this.href = null;
            if (this.innerHTML === undefined)
                this.innerHTML = null;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "a";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "text-decoration-none";
            return new HTMLAnchorElementBuilder();
        }
        /**
         * Imposta l'indirizzo a cui punta il link
         * @param {string} href Indirizzo a cui punta il link
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        Href(href) {
            this.href = href;
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione
         * @param {string} innerHtml Testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        InnerHtml(innerHtml) {
            this.innerHTML = innerHtml;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e Id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         *
         * @return {HTMLAnchorElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (this.href != null)
                elm.href = this.href;
            if (this.innerHTML != null)
                elm.innerHTML = this.innerHTML;
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder = HTMLAnchorElementBuilder;
    HTMLAnchorElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLAnchorElementBuilder";
    HTMLAnchorElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
