/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un immagine html
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
    class HTMLImgElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.src === undefined)
                this.src = null;
            if (this.width === undefined)
                this.width = 0;
            if (this.height === undefined)
                this.height = 0;
        }
        /**
         * Imposta la larghezza dell'immagine
         * @param {number} width Larghezza dell'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        Width(width) {
            this.width = width;
            return this;
        }
        /**
         * Imposta l'altezza dell'immagine
         * @param {number} height Altezza dell'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        Height(height) {
            this.height = height;
            return this;
        }
        /**
         * Imposta l'url da dove prendere l'immagine
         * @param {string} src Url da dove prendere l'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        Src(src) {
            this.src = src;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id dell'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome dell'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id dell'immagine
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "mb-4";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "img";
            return new HTMLImgElementBuilder();
        }
        /**
         *
         * @return {HTMLImageElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (this.src != null)
                elm.src = this.src;
            elm.width = this.width;
            elm.height = this.height;
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder = HTMLImgElementBuilder;
    HTMLImgElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLImgElementBuilder";
    HTMLImgElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
