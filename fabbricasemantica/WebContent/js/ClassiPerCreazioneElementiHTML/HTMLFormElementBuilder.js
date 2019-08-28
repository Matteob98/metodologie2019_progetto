/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un form html
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
    class HTMLFormElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLElementBuilder {
        constructor() {
            super();
            if (this.__Action === undefined)
                this.__Action = null;
            if (this.__elementi === undefined)
                this.__elementi = null;
            if (this.margin === undefined)
                this.margin = null;
        }
        /**
         * Imposta l'azione nel form
         * @param {string} action L'azione del form al momento del submit
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        Action(action) {
            this.__Action = action;
            return this;
        }
        /**
         * Imposta i margini del form
         * del tipo "N% M%" , dove N e M sono le distanze orizzontali e verticali dal bordo
         * @param {string} margin I margini del form rispetto al body
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        Margin(margin) {
            this.margin = margin;
            return this;
        }
        /**
         * Inserisce nel form gli elementi passati in input
         * @param {HTMLElement[]} elementi Gli elementi che fanno parte del form
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        elementi(elementi) {
            this.__elementi = elementi;
            return this;
        }
        /**
         * Imposta il className dell'element e ne ritorna il builder
         * @param {string} className La classe del form
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        ClassName(className) {
            super.addClassName(className);
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id L'id del form
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Il nome del form
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id del form
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder} Il builder
         */
        static newBuilder() {
            return new HTMLFormElementBuilder();
        }
        /**
         *
         * @return {HTMLFormElement}
         */
        build() {
            let elm = document.createElement(HTMLFormElementBuilder.stringType);
            if (ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className != null)
                elm.className = ClassiPerCreazioneElementiHTML.HTMLElementBuilder.className;
            if (this.name != null)
                elm.setAttribute("name", this.name);
            if (this.id != null)
                elm.id = this.id;
            elm.method = HTMLFormElementBuilder.method;
            if (this.__Action != null)
                elm.action = this.__Action;
            if (this.margin != null)
                $(elm).css("margin", this.margin);
            try {
                for (let index121 = 0; index121 < this.__elementi.length; index121++) {
                    let e = this.__elementi[index121];
                    $(elm).append(e);
                }
            }
            catch (e) {
                console.error(e.message, e);
            }
            ;
            return elm;
        }
    }
    /**
     * Dipo del form
     */
    HTMLFormElementBuilder.stringType = "form";
    /**
     * Metodo con cui il form invia i dati in submit
     */
    HTMLFormElementBuilder.method = "POST";
    ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder = HTMLFormElementBuilder;
    HTMLFormElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLFormElementBuilder";
    HTMLFormElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
