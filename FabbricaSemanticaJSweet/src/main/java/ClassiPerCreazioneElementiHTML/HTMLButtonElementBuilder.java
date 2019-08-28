package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;

import def.dom.HTMLButtonElement;

/**
 * Classe non instanziabile che costruisce e crea un pulsante html
 * Implementa il builder pattern
 * Per creare l'oggetto desiderato utilizzare prima il metodo statico newBuilder() che ritorna il builder, 
 * dopodichè, tramite i metodi della classe impostare gli attributi dell'oggetto. Una volta finito, con il metodo build()
 *  verrà ritornato l'oggetto.
 *  
 *   <br><br><b>Esempio di utilizzo</b><br>
 *  ElementBuilder.newBuilder()<br>
 *  	.className(nome)<br>
 *  	.Id(id)<br>
 *  	.Name(name)<br>
 *  	.build()<br>
 * @author Matteo
 */
public class HTMLButtonElementBuilder extends HTMLElementBuilder
{
	/**
	 * Testo che appare sul pulsane
	 */
	private String value;
	/**
	 * Tipo di pulsante
	 */
	private String tipo;
	/**
	 * Non instanziabile
	 */
	protected HTMLButtonElementBuilder () {}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Testo del pulsante
	 * @return Il builder
	 */
	public HTMLButtonElementBuilder Value (String value)
	{
		this.value = value;
		return this;
	}
	
	/**
	 * Imposta il tipo del bottone
	 * @param tipo Tipo del pulsante
	 * @return Il builder
	 */
	public HTMLButtonElementBuilder Tipo(String tipo)
	{
		this.tipo = tipo;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe del pulsante
	 * @return Il builder
	 */
	public HTMLButtonElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id del pulsante
	 * @return Il builder
	 */
	public HTMLButtonElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome del pulsante
	 * @return Il builder
	 */
	public HTMLButtonElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id del pulsante
	 * @return Il builder
	 */
	public HTMLButtonElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLButtonElementBuilder newBuilder()
	{
		className = "btn btn-success";
		stringType = "button";
		return new HTMLButtonElementBuilder();
	}
	
	public HTMLButtonElement build()
	{
		HTMLButtonElement elm = (HTMLButtonElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(value!=null)
			elm.value = value;
		if(tipo!=null)
			elm.type = tipo;
		
		return elm;
		
	}
}