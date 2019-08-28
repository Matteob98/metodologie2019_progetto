/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un pulsante html
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
    class HTMLButtonElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.value === undefined)
                this.value = null;
            if (this.tipo === undefined)
                this.tipo = null;
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Testo del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        Value(value) {
            this.value = value;
            return this;
        }
        /**
         * Imposta il tipo del bottone
         * @param {string} tipo Tipo del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.tipo = tipo;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className Classe del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id del pulsante
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "btn btn-success";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "button";
            return new HTMLButtonElementBuilder();
        }
        build() {
            let elm = document.createElement(ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            if (this.value != null)
                elm.value = this.value;
            if (this.tipo != null)
                elm.type = this.tipo;
            return elm;
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder = HTMLButtonElementBuilder;
    HTMLButtonElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLButtonElementBuilder";
    HTMLButtonElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
