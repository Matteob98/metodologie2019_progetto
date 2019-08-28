package ClassiPerCreazioneElementiHTML;

import def.dom.HTMLLabelElement;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

/**
 * Classe non instanziabile che costruisce e crea una label html
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
public class HTMLLabelElementBuilder extends HTMLElementBuilder
{
	/**
	 * Testo che appare sulla label
	 */
	private String testo;	
	
	/**
	 * Nome dell'elemento al quale la label è collegata
	 */
	private String For;
		
	/**
	 * Non instanziabile
	 */
	protected HTMLLabelElementBuilder() {}
	
	/**
	 * Imposta il testo della Label
	 * @param testo Il testo della label
	 * @return Il builder
	 */
	public HTMLLabelElementBuilder testo(String testo)
	{
		this.testo = testo;
		return this;
	}
	
	/**
	 * Dato l'id di un altro elemento html, imposta l'elemento a cui la label si appoggia. 
	 * Utile quando si lavora ad esempio con checkbox, radio button ecc.
	 * @param For Id dell'elemento a cui la label si appoggia
	 * @return Il builder
	 */
	public HTMLLabelElementBuilder For(String For)
	{
		this.For = For;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'elemento
	 * @return Il builder
	 */
	public HTMLLabelElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id della label
	 * @return Il builder
	 */
	public HTMLLabelElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome della label
	 * @return Il builder
	 */
	public HTMLLabelElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e Id della label
	 * @return Il builder
	 */
	public HTMLLabelElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	 
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLLabelElementBuilder newBuilder()
	{
		stringType= "label"; 
		return new HTMLLabelElementBuilder();
	}
	
	
	@Override
	public HTMLLabelElement build()
	{
		HTMLLabelElement elm =  (HTMLLabelElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(testo!=null)
			$(elm).text(testo);
		if(For!=null)
			elm.htmlFor = For;
		
		return elm;
	}
}
