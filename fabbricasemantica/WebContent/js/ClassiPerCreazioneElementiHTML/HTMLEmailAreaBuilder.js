/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un email area html
     * Un email area forza l'utente ad inserire una stringa del tipo utente@indirizzo.com
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
     * @extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder
     * @class
     */
    class HTMLEmailAreaBuilder extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder {
        constructor() {
            super();
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Il valore dell'area
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Il testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required L'obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Il tipo dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe dell'area
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} HTMLEmailAreaBuilder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} HTMLEmailAreaBuilder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Il nome e l'id del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} HTMLEmailAreaBuilder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.tipo = "email";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className = "form-control";
            return new HTMLEmailAreaBuilder();
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder = HTMLEmailAreaBuilder;
    HTMLEmailAreaBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLEmailAreaBuilder";
    HTMLEmailAreaBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
