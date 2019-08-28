/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Builder che permette, se ereditato, di creare oggetti html in maniera modulare
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
     * @class
     */
    class HTMLElementBuilder {
        constructor() {
            if (this.name === undefined)
                this.name = null;
            if (this.id === undefined)
                this.id = null;
        }
        /**
         * Imposta il className dell'oggetto che si vuole creare
         * @param {string} newClassName La classe dell'elemento
         */
        addClassName(newClassName) {
            HTMLElementBuilder.className = newClassName;
        }
        /**
         * Imposta il tipo dell'oggetto che si vuole creare
         * @param {string} newStringType Il tipo di elemento da creare
         */
        addStringType(newStringType) {
            HTMLElementBuilder.stringType = newStringType;
        }
        /**
         * Imposta il nome dell'oggetto che si vuole creare
         * @param {string} name Il nome dell'elemento
         */
        addName(name) {
            this.name = name;
        }
        /**
         * Imposta l'id dell'oggetto che si vuole creare
         * @param {string} id L'id dell'elemento
         */
        addId(id) {
            this.id = id;
        }
        /**
         * Imposta il nome e l'id dell'oggetto che si vuole creare allo stesso valore
         * @param {string} name Il nome e l'id dell'elemento
         */
        addNameAndId(name) {
            this.name = name;
            this.id = name;
        }
    }
    /**
     * Il tipo dell'elemento (input, label ecc.)
     */
    HTMLElementBuilder.stringType = null;
    /**
     * Il className per la formattazione bootstrap
     */
    HTMLElementBuilder.className = null;
    ClassiPerCreazioneElementiHTML.HTMLElementBuilder = HTMLElementBuilder;
    HTMLElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLElementBuilder";
    HTMLElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
