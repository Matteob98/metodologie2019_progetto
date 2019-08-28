package ClassiPerCreazioneElementiHTML;

import java.util.List;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLElement;
import def.dom.HTMLFormElement;

/**
 * Classe non instanziabile che costruisce e crea un form html
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
public class HTMLFormElementBuilder extends HTMLElementBuilder
{
	/**
	 * Dipo del form
	 */
	protected static String stringType = "form";

	/**
	 * Metodo con cui il form invia i dati in submit
	 */
	protected static final String method = "POST";
	
	/**
	 * Azione del form alla pressione del submit
	 */
	private String Action;
	
	/**
	 * Elementi che fanno parte del form
	 */
	private List<HTMLElement> elementi;
	
	/**
	 * Margini del form
	 */
	private String margin;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLFormElementBuilder() {}
	
	/**
	 * Imposta l'azione nel form
	 * @param action L'azione del form al momento del submit
	 * @return Il builder
	 */
	public HTMLFormElementBuilder Action(String action)
	{
		this.Action = action;
		return this;
	}
	
	/**
	 * Imposta i margini del form
	 * del tipo "N% M%" , dove N e M sono le distanze orizzontali e verticali dal bordo
	 * @param margin I margini del form rispetto al body
	 * @return Il builder
	 */
	public HTMLFormElementBuilder Margin (String margin)
	{
		this.margin = margin; 
		return this;
	}
	
	/**
	 * Inserisce nel form gli elementi passati in input
	 * @param elementi Gli elementi che fanno parte del form
	 * @return Il builder
	 */
	public HTMLFormElementBuilder elementi(List<HTMLElement> elementi)
	{
		this.elementi = elementi;
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className La classe del form
	 * @return Il builder
	 */
	public HTMLFormElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id L'id del form
	 * @return Il builder
	 */
	public HTMLFormElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Il nome del form
	 * @return Il builder
	 */
	public HTMLFormElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id del form
	 * @return Il builder
	 */
	public HTMLFormElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLFormElementBuilder newBuilder()
	{
		return new HTMLFormElementBuilder();
	}
	
	@Override
	public HTMLFormElement build()
	{
		HTMLFormElement elm =  (HTMLFormElement) document.createElement(stringType);
		if(className!=null) 
			elm.className = className;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		elm.method = method;		
		if(Action!=null)
			elm.action = Action;
		if(margin!=null)
			//Spazio ai lati del form
			$(elm).css("margin",margin); 
		
		try
		{
			for(HTMLElement e: elementi)
				$(elm).append(e);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return elm;
		
	}
}
