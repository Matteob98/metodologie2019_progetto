/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un men� a cascata html
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
    class HTMLSelectElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.__opzioni === undefined)
                this.__opzioni = null;
        }
        /**
         * Aggiunge le opzioni selezionabili nell'elemento e ne ritorna il builder
         * @param {string[]} opzioni Lista di ozpzioni da inserire nel select
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder} Il builder
         */
        opzioni(opzioni) {
            this.__opzioni = opzioni;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "select";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "custom-select";
            return new HTMLSelectElementBuilder();
        }
        /**
         *
         * @return {HTMLSelectElement}
         */
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            for (let index122 = 0; index122 < this.__opzioni.length; index122++) {
                let opt = this.__opzioni[index122];
                $(elm).append("<option>" + opt);
            }
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder = HTMLSelectElementBuilder;
    HTMLSelectElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLSelectElementBuilder";
    HTMLSelectElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
