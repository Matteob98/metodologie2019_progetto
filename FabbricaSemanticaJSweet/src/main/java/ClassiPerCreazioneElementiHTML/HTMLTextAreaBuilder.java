package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;

import def.dom.HTMLTextAreaElement;

/**
 * Classe non instanziabile che costruisce e crea una text area html
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
 * @author Matteo
 */
public class HTMLTextAreaBuilder extends HTMLElementBuilder
{	
	/**
	 * Testo in sovrimpressione
	 */
	protected String placeHolder;
	/**
	 * Obbligatorietà del campo
	 */
	protected boolean required;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLTextAreaBuilder() {}
	
	/**
	 * Imposta il testo il sovrimpressione
	 * @param placeHolder Il testo in sovrimpressione
	 * @return Il builder
	 */
	public HTMLTextAreaBuilder placeHolder(String placeHolder)
	{
		this.placeHolder = placeHolder;
		return this;
	}
	
	/**
	 * Imposta l'obbligatorietà del campo
	 * @param required L'obbligatorietà del campo
	 * @return Il builder
	 */
	public HTMLTextAreaBuilder required(boolean required)
	{
		this.required = required;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className La classe del campo
	 * @return Il builder
	 */
	public HTMLTextAreaBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id L'id del campo
	 * @return Il builder
	 */
	public HTMLTextAreaBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Il nome del campo
	 * @return Il builder
	 */
	public HTMLTextAreaBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Il nome e l'id del campo
	 * @return Il builder
	 */
	public HTMLTextAreaBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLTextAreaBuilder newBuilder()
	{
		stringType = "textarea";
		className = "form-control";
		return new HTMLTextAreaBuilder();
	}

	@Override
	public HTMLTextAreaElement build()
	{
		HTMLTextAreaElement elm =  (HTMLTextAreaElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(this.placeHolder!=null)
			elm.placeholder = this.placeHolder;
		elm.required = this.required;
		
		return elm;
	}

}
