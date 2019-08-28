package ClassiPerCreazioneElementiHTML;

import java.util.List;
import def.dom.HTMLElement;

/**
 * Classe non instanziabile che costruisce e crea un divisore(div) verticale html
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
public class HTMLVerticalDivElementBuilder extends HTMLDivElementBuilder 
{
	
	/**
	 * Non instanziabile
	 */
	protected HTMLVerticalDivElementBuilder() {}
	
	/**
	 * Aggiunge gli elementi al div
	 * @param elements Gli elementi contenuti nel div
	 * @return Il builder
	 */
	@Override
	public HTMLVerticalDivElementBuilder elementi(List<HTMLElement> elements)
	{
		super.addElementi(elements);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className La classe del div
	 * @return Il builder
	 */
	@Override
	public HTMLVerticalDivElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id L'id del div
	 * @return Il builder
	 */
	@Override
	public HTMLVerticalDivElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Il nome del div
	 * @return Il builder
	 */
	@Override
	public HTMLVerticalDivElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Il nome e l'id del div
	 * @return Il builder
	 */
	@Override
	public HTMLVerticalDivElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLVerticalDivElementBuilder newBuilder()
	{
		className = "form-group";
		return new HTMLVerticalDivElementBuilder();
	}
	
	//Mantiene lo stesso build del padre
}
