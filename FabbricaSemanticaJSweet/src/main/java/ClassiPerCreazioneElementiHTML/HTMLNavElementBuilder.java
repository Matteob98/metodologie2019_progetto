package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import java.util.List;
import def.dom.HTMLElement;

/**
 * Classe non instanziabile che costruisce e crea una nav bar html (barra per menù solitamente posizionata in alto)
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
public class HTMLNavElementBuilder extends HTMLElementBuilder
{
	/**
	 * Elementi che fanno parte del nav
	 */
	protected  List<HTMLElement> elementi;
	
	/**
	 * Non instanziabile
	 */
	private HTMLNavElementBuilder() {}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLNavElementBuilder newBuilder()
	{
		stringType = "nav";
		className = "navbar navbar-expand-md navbar-dark bg-dark mb-4";
		return new HTMLNavElementBuilder();
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className La classe dell'elemento
	 * @return Il builder
	 */
	public HTMLNavElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id L'id dell'elemento
	 * @return Il builder
	 */
	public HTMLNavElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Il nome dell'elemento
	 * @return Il builder
	 */
	public HTMLNavElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Il nome e l'id dell'elemento
	 * @return Il builder
	 */
	public HTMLNavElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Aggiunge gli elementi al nav e ne ritorna il builder
	 * @param elements Gli elementi da aggiungere al nav
	 * @return Il builder
	 */
	public HTMLNavElementBuilder elementi(List<HTMLElement> elements)
	{
		this.elementi = elements;
		return this;
	}
	
	@Override
	public HTMLElement build() 
	{
		HTMLElement elm =  document.createElement(stringType);
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
