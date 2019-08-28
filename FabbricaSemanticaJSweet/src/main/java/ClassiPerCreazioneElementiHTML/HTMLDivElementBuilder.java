package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;

/**
 * Classe non instanziabile che costruisce e crea un divisore(div) html
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
public class HTMLDivElementBuilder extends HTMLElementBuilder
{	
	/**
	 * Tipo del div
	 */
	protected static String stringType = "div";

	/**
	 * Elementi che fanno parte del div
	 */
	protected  List<HTMLElement> elementi;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLDivElementBuilder() {}
	
	/**
	 * Aggiunge gli elementi al div
	 * @param elements Gli elementi da aggiungere al div
	 */
	protected void addElementi(List<HTMLElement> elements)
	{
		elementi = elements;
	}
	
	/**
	 * Aggiunge gli elementi al div e ne ritorna il builder
	 * @param elements Gli elementi da aggiungere al div
	 * @return Il builder
	 */
	public HTMLDivElementBuilder elementi(List<HTMLElement> elements)
	{
		addElementi(elements);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe del div
	 * @return Il builder
	 */
	public HTMLDivElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id del div
	 * @return Il builder
	 */
	public HTMLDivElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome del div
	 * @return Il builder
	 */
	public HTMLDivElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id del div
	 * @return Il builder
	 */
	public HTMLDivElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLDivElementBuilder newBuilder()
	{
		return new HTMLDivElementBuilder();
	}
	
	@Override
	public HTMLDivElement build()
	{
		HTMLDivElement elm =  (HTMLDivElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(elementi!=null)
			for(int i=0; i<elementi.size(); i++)
				$(elm).append(elementi.get(i));

		return elm;
	}
}
