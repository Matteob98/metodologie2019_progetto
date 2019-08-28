package ClassiPerCreazioneElementiHTML;

import def.dom.HTMLInputElement;

/**
 * Classe non instanziabile che costruisce e crea una checkbox html
 * Implementa il builder pattern
 * Per creare l'oggetto desiderato utilizzare prima il metodo statico newBuilder() che ritorna il builder, 
 * dopodichè, tramite i metodi della classe impostare gli attributi dell'oggetto. Una volta finito, con il metodo build()
 *  verrà ritornato l'oggetto.
 *  
 *  <br><br><b>Esempio di utilizzo</b><br>
 *  ElementBuilder.newBuilder()<br>
 *  	.className(nome)<br>
 *  	.Id(id)<br>
 *  	.Name(name)<br>
 *  	.build()<br>
 * @author Matteo
 */
public class HTMLCheckBoxElementBuilder extends HTMLInputElementBuilder
{
	/**
	 * Booleano che indica se la casella parte già spuntata o no
	 */
	protected boolean checked;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLCheckBoxElementBuilder() {}
	
	/**
	 * Imposta il checked/unchecked della checkbox
	 * @param checked True se la casella parte già spuntata, false altrimenti
	 * @return Il builder
	 */
	public HTMLCheckBoxElementBuilder Checked (boolean checked)
	{
		this.checked = checked;
		return this;
	}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Valore della casella
	 * @return Il builder
	 */
	@Override
	public HTMLCheckBoxElementBuilder Value (String value)
	{
		addValue(value);
		return this;
	}
	
	/**
	 * Imposta il testo in sovrimpressione dell'element e ritorna il builder
	 * @param placeHolder Testo in sovrimpressione
	 * @return Il builder
	 */
	 @Override
	public HTMLCheckBoxElementBuilder PlaceHolder(String placeHolder)
	{
		addPlaceHolder(placeHolder);
		return this;
	}
	
	/**
	 * Imposta l'obbligatorietà del campo e ritorna il builder
	 * @param required Obbligatorietà del campo
	 * @return Il builder
	 */
	 @Override
	public HTMLCheckBoxElementBuilder Required (boolean required)
	{
		addRequired(required);
		return this;
	}
	
	/**
	 * Imposta il tipo dell'imput element e ritorna il builder
	 * @param tipo Tipo dell'elemento
	 * @return Il builder
	 */
	 @Override
	public HTMLCheckBoxElementBuilder Tipo (String tipo)
	{
		addTipo(tipo);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'elelemento
	 * @return Il builder
	 */
	@Override
	public HTMLCheckBoxElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id della casella
	 * @return Il builder
	 */
	@Override
	public HTMLCheckBoxElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome della casella
	 * @return Il builder
	 */
	@Override
	public HTMLCheckBoxElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id della casella
	 * @return Il builder
	 */
	@Override
	public HTMLCheckBoxElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLCheckBoxElementBuilder newBuilder()
	{
		tipo = "checkbox";
		className = "custom-control-input";
		stringType = "input";
		return new HTMLCheckBoxElementBuilder();
	}
	
	@Override
	public HTMLInputElement build()
	{
		HTMLInputElement elm = super.build();
		
		elm.checked = this.checked;
		return elm;
	}
}
