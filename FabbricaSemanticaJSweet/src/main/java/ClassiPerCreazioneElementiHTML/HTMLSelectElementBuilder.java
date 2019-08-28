package ClassiPerCreazioneElementiHTML;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import java.util.List;
import def.dom.HTMLSelectElement;

/**
 * Classe non instanziabile che costruisce e crea un menù a cascata html
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
public class HTMLSelectElementBuilder extends HTMLElementBuilder
{
	/**
	 * Opzioni contenute nel select
	 */
	private List<String> opzioni;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLSelectElementBuilder() {}
	
	/**
	 * Aggiunge le opzioni selezionabili nell'elemento e ne ritorna il builder
	 * @param opzioni Lista di ozpzioni da inserire nel select
	 * @return Il builder
	 */
	public HTMLSelectElementBuilder opzioni(List<String> opzioni)
	{
		this.opzioni = opzioni;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'elemento
	 * @return Il builder
	 */
	public HTMLSelectElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id dell'elemento
	 * @return Il builder
	 */
	public HTMLSelectElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome dell'elemento
	 * @return Il builder
	 */
	public HTMLSelectElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id dell'elemento
	 * @return Il builder
	 */
	public HTMLSelectElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLSelectElementBuilder newBuilder()
	{
		stringType = "select";
		className = "custom-select";
		return new HTMLSelectElementBuilder();
	}
	
	@Override
	public HTMLSelectElement build()
	{
		HTMLSelectElement elm =  (HTMLSelectElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		for(String opt : opzioni)
			$(elm).append("<option>"+opt);
		return elm;
	}
	
}
