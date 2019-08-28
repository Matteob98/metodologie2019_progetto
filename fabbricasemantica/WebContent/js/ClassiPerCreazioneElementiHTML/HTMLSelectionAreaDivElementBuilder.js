/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var ClassiPerCreazioneElementiHTML;
(function (ClassiPerCreazioneElementiHTML) {
    /**
     * Classe non instanziabile che costruisce e crea un area in cui sono presenti un elemento html per effettuare
     * una selezione (ad esempio una checkbox), accompagnato da una label.
     * L'elemento viene costruito a partire dall'elemento per effettuare la selezione
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
    class HTMLSelectionAreaDivElementBuilder extends ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder {
        constructor() {
            super();
            if (this.selector === undefined)
                this.selector = null;
            if (this.labelClassName === undefined)
                this.labelClassName = null;
            if (this.divClassName === undefined)
                this.divClassName = null;
        }
        /**
         * Imposta il className del div
         * @param {string} divClassName Classe del div principale
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        DivClassName(divClassName) {
            this.divClassName = divClassName;
            return this;
        }
        /**
         * Imposta il selector sul quale viene costruito il div
         * Il selector pu� essere ad esempio una checkbox, un radio button, un range selector ecc.
         * Al selector verr� in seguito associata la propria label
         * @param {HTMLInputElement} selector Elemento di selezione (es. checkbox, radio button, range selector ecc.)
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        Selector(selector) {
            this.selector = selector;
            return this;
        }
        /**
         * Imposta il class name della label che accompagna il selector
         * @param {string} labelClassName Classe della label che accompagna la selezione
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        LabelClassName(labelClassName) {
            this.labelClassName = labelClassName;
            return this;
        }
        /**
         * Imposta l'id dell'element e ne ritorna il builder
         * @param {string} id Id del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        Id(id) {
            super.addId(id);
            return this;
        }
        /**
         * Imposta il nome dell'element e ne ritorna il builder
         * @param {string} name Nome del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        Name(name) {
            super.addName(name);
            return this;
        }
        /**
         * Imposta il nome e l'id dell'element e ne ritorna il builder
         * @param {string} name Nome e id del div
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        NameAndId(name) {
            super.addNameAndId(name);
            return this;
        }
        /**
         * Aggiunge elementi al div
         * @param {HTMLElement[]} elements Elementi da aggiungere al div
         * @return {ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder} Il builder
         */
        elementi(elements) {
            this.addElementi(elements);
            return this;
        }
        /**
         * Ritorna il builder, necessario per la creazione dell'oggetto
         * @return {ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder} Il builder
         */
        static newBuilder() {
            return new HTMLSelectionAreaDivElementBuilder();
        }
        /**
         *
         * @return {HTMLDivElement}
         */
        build() {
            let labelValue = this.selector.value;
            if (((o1, o2) => { if (o1 && o1.equals) {
                return o1.equals(o2);
            }
            else {
                return o1 === o2;
            } })(this.selector.type, "range")) {
                labelValue = this.selector.id;
                this.labelClassName = null;
            }
            let lb = ClassiPerCreazioneElementiHTML.HTMLLabelElementBuilder.newBuilder().For(this.selector.id).testo(labelValue).Name(this.selector.name).Id(this.selector.id).ClassName(this.labelClassName).build();
            let hidd = ClassiPerCreazioneElementiHTML.HTMLHiddenElementBuilder.newBuilder().Value(this.selector.id).NameAndId("hiddenSelector").build();
            if (((o1, o2) => { if (o1 && o1.equals) {
                return o1.equals(o2);
            }
            else {
                return o1 === o2;
            } })(this.selector.type, "range"))
                this.elementi(/* asList */ [lb, this.selector, hidd]);
            else
                this.elementi(/* asList */ [this.selector, lb, hidd]);
            return ClassiPerCreazioneElementiHTML.HTMLDivElementBuilder.newBuilder().ClassName(this.divClassName).Name(this.name).Id(this.id).elementi(this.__elementi).build();
        }
    }
    ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder = HTMLSelectionAreaDivElementBuilder;
    HTMLSelectionAreaDivElementBuilder["__class"] = "ClassiPerCreazioneElementiHTML.HTMLSelectionAreaDivElementBuilder";
    HTMLSelectionAreaDivElementBuilder["__interfaces"] = ["ClassiPerCreazioneElementiHTML.ElementBuilder"];
})(ClassiPerCreazioneElementiHTML || (ClassiPerCreazioneElementiHTML = {}));
