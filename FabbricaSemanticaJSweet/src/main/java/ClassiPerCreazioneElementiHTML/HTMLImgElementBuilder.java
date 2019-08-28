package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;
import def.dom.HTMLImageElement;

/**
 * Classe non instanziabile che costruisce e crea un immagine html
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
public class HTMLImgElementBuilder extends HTMLElementBuilder 
{	
	/**
	 * URL da dove viene presa l'immagine
	 */
	protected String src;
	
	/**
	 * Larghezza dell'immagine
	 */
	protected int width;
	/**
	 * Altezza dell'immagine
	 */
	protected int height;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLImgElementBuilder() {};
	
	/**
	 * Imposta la larghezza dell'immagine
	 * @param width Larghezza dell'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder Width(int width)
	{
		this.width = width;
		return this;
	}
	
	/**
	 * Imposta l'altezza dell'immagine
	 * @param height Altezza dell'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder Height(int height)
	{
		this.height = height;
		return this;
	}
	
	
	/**
	 * Imposta l'url da dove prendere l'immagine
	 * @param src Url da dove prendere l'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder Src(String src)
	{
		this.src = src;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id dell'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome dell'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id dell'immagine
	 * @return Il builder
	 */
	public HTMLImgElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}

	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLImgElementBuilder newBuilder()
	{
		className = "mb-4";
		stringType = "img";
		return new HTMLImgElementBuilder();
	}
	
	@Override
	public HTMLImageElement build() 
	{
		HTMLImageElement elm = (HTMLImageElement) document.createElement(stringType);
		
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(src!=null)
			elm.src = src;
		elm.width = width;
		elm.height = height;
		
		return elm;
	}

}
