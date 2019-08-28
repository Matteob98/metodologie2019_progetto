/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un elemento nascosto html
     * Utile per salvare su una pagina html dati senza mostrarli direttamente all'utente
     * Utile nel back-end per prendere dati dalla pagina, che altrimenti con elementi statici come le label
     * non sarebbe stato possibile prendere.
     * -----
     * ATTEZIONE!!! L'utente non vedr� direttamente i dati, ma potr� accedervi andando ad ispezionare la pagina
     * -----
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
    class HTMLHiddenElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder {
        constructor() {
            super();
        }
        /**
         * Imposta il valore dell'element e ritorna il builder
         * @param {string} value Il valore dell'elemento
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        Value(value) {
            this.addValue(value);
            return this;
        }
        /**
         * Imposta il testo in sovrimpressione dell'element e ritorna il builder
         * @param {string} placeHolder Il testo in sovrimpressione
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        PlaceHolder(placeHolder) {
            this.addPlaceHolder(placeHolder);
            return this;
        }
        /**
         * Imposta l'obbligatoriet� del campo e ritorna il builder
         * @param {boolean} required L'obbligatoriet� del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        Required(required) {
            this.addRequired(required);
            return this;
        }
        /**
         * Imposta il tipo dell'imput element e ritorna il builder
         * @param {string} tipo Il tipo del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        Tipo(tipo) {
            this.addTipo(tipo);
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e Id del campo
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder} Il builder
         */
        static newBuilder() {
            ClassiPerCreazioneElementiHTML.HTMLInputElementBuilder.tipo = "hidden";
            ClassiPerCreazioneElementiHTML.HTMLElementBuilder.stringType = "input";
            return new HTMLHiddenElementBuilder();
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder = HTMLHiddenElementBuilder;
    HTMLHiddenElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder";
    HTMLHiddenElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
