package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;

import def.dom.HTMLInputElement;

/**
 * Classe non instanziabile che costruisce e crea un elemento input html
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
public class HTMLInputElementBuilder extends HTMLElementBuilder
{	
	/**
	 * Eventuale immagine dell'src che sostituisce l'input
	 */
	private String src;
	/**
	 * Altezza dell'elemento
	 */
	private int height;
	/**
	 * Larghezza dell'elemento
	 */
	private int width;
	
	/**
	 * Tipo dell'input
	 */
	protected static String tipo = "input";
	/**
	 * Testo che appare in sovrimpressione
	 */
	protected String placeHolder;
	/**
	 * Obbligatorietà del campo
	 */
	protected boolean required;
	
	/**
	 * Valore dell'elemento
	 */
	protected String value;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLInputElementBuilder() {}
	
	/**
	 * Aggiunge il valore all'elemento
	 * @param value Valore dell'elemento
	 */
	protected void addValue(String value)
	{
		this.value = value;
	}
	
	/**
	 * Aggiunge il testo in sovrimpressione
	 * @param placeHolder Testo in sovrimpressione
	 */
	protected void addPlaceHolder(String placeHolder)
	{
		this.placeHolder = placeHolder;
	}
	
	/**
	 * Aggiunge l'obbligatorietà del campo
	 * @param required Obbligatorietà del campo
	 */
	protected void addRequired(boolean required)
	{
		this.required = required;
	}
	
	/**
	 * Imposta l'src dell'elemento
	 * @param src Url collegato all'elemento
	 */
	protected void addSrc(String src)
	{
		this.src = src;
	}
	
	/**
	 * Imposta l'altezza dell'elemento
	 * @param height Altezza dell'elemento
	 */
	protected void addHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 * Imposta la larghezza dell'elemento
	 * @param width Larghezza dell'elemento
	 */
	protected void addWidth(int width)
	{
		this.width = width;
	}

	/**
	 * Aggiunge il tipo
	 * @param newTipo Tipo dell'elemento
	 */
	protected void addTipo(String newTipo)
	{
		tipo = newTipo;
	}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Valore dell'elemento
	 * @return Il builder
	 */
	public HTMLInputElementBuilder Value (String value)
	{
		addValue(value);
		return this;
	}
	
	/**
	 * Imposta il testo in sovrimpressione dell'element e ritorna il builder
	 * @param placeHolder Testo in sovrimpressione
	 * @return Il builder
	 */
	public HTMLInputElementBuilder PlaceHolder(String placeHolder)
	{
		addPlaceHolder(placeHolder);
		return this;
	}
	
	/**
	 * Imposta l'obbligatorietà del campo e ritorna il builder
	 * @param required Obbligatorietà del campo
	 * @return Il builder
	 */
	public HTMLInputElementBuilder Required (boolean required)
	{
		addRequired(required);
		return this;
	}
	
	/**
	 * Imposta il tipo dell'imput element e ritorna il builder
	 * @param tipo Tipo dell'elemento
	 * @return Il builder
	 */
	public HTMLInputElementBuilder Tipo (String tipo)
	{
		addTipo(tipo);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'elemento
	 * @return Il builder
	 */
	public HTMLInputElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id dell'elemento
	 * @return Il builder
	 */
	public HTMLInputElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome dell'elemento
	 * @return Il builder
	 */
	public HTMLInputElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id dell'elemento
	 * @return Il builder
	 */
	public HTMLInputElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLInputElementBuilder newBuilder()
	{
		stringType = "input";
		tipo = "input";
		return new HTMLInputElementBuilder();
	}
	
	@Override
	public HTMLInputElement build()
	{		
		HTMLInputElement elm =  (HTMLInputElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(tipo != null)
			elm.type = tipo;
		if(placeHolder!= null)
			elm.placeholder = placeHolder;
		elm.required = required;
		if(value!=null)
			elm.value = value;
		if(src!=null)
			elm.src = src;
		if(height!=0)
			elm.height = Integer.toString(height);
		if(width!=0)
			elm.width = Integer.toString(width);
		
		return elm;
		
	}
	
}
