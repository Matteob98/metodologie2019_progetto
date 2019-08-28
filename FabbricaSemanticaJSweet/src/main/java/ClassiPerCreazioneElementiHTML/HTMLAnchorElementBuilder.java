package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;

import def.dom.HTMLAnchorElement;

/**
 * Classe non instanziabile che costruisce e crea un Link html
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
 *  
 *  
 * @author Matteo
 */
public class HTMLAnchorElementBuilder extends HTMLElementBuilder
{
	/**
	 * L'url a cui punta il link
	 */
	protected String href;
	/**
	 * Il testo che appare come link
	 */
	protected String innerHTML;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLAnchorElementBuilder() {};
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLAnchorElementBuilder newBuilder()
	{
		stringType = "a";
		className = "text-decoration-none";
		return new HTMLAnchorElementBuilder();
	}
	
	/**
	 * Imposta l'indirizzo a cui punta il link
	 * @param href Indirizzo a cui punta il link
	 * @return Il builder
	 */
	public HTMLAnchorElementBuilder Href (String href) 
	{
		this.href = href; 
		return this;
	}
	/**
	 * Imposta il testo in sovrimpressione
	 * @param innerHtml Testo in sovrimpressione
	 * @return Il builder
	 */
	public HTMLAnchorElementBuilder InnerHtml(String innerHtml) 
	{
		this.innerHTML = innerHtml;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'elemento
	 * @return Il builder
	 */
	public HTMLAnchorElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id dell'elemento
	 * @return Il builder
	 */
	public HTMLAnchorElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome dell'elemento
	 * @return Il builder
	 */
	public HTMLAnchorElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e Id dell'elemento
	 * @return Il builder
	 */
	public HTMLAnchorElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	@Override
	public HTMLAnchorElement build()
	{		
		HTMLAnchorElement elm =  (HTMLAnchorElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(href!=null)
			elm.href = this.href;
		if(innerHTML!=null)
			elm.innerHTML = this.innerHTML;
		
		return elm;
	}
}
