/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un divisore(div) verticale html
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
     * @extends ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder
     * @class
     */
    class HTMLVerticalDivElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder {
        constructor() {
            super();
        }
        /**
         * Aggiunge gli elementi al div
         * @param {HTMLElement[]} elements Gli elementi contenuti nel div
         * @return {ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder} Il builder
         */
        elementi(elements) {
            super.addElementi(elements);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Il nome e l'id del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "form-group";
            return new HTMLVerticalDivElementBuilder();
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder = HTMLVerticalDivElementBuilder;
    HTMLVerticalDivElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLVerticalDivElementBuilder";
    HTMLVerticalDivElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
