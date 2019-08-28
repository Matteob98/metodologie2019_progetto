package ClassiPerCreazioneElementiHTML;

import java.util.Arrays;
import java.util.List;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;

/**
 * Classe non instanziabile che costruisce e crea un area in cui sono presenti un elemento html per effettuare
 *  una selezione (ad esempio una checkbox), accompagnato da una label.
 *  L'elemento viene costruito a partire dall'elemento per effettuare la selezione
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
public class HTMLSelectionAreaDivElementBuilder extends HTMLDivElementBuilder
{
	/**
	 * Selector button passato in input al costruttore
	 */
	private HTMLInputElement selector;
	/**
	 * ClassName della label
	 */
	private String labelClassName;
	/**
	 * ClassName del div
	 */
	private String divClassName;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLSelectionAreaDivElementBuilder() {}
	
	/**
	 * Imposta il className del div
	 * @param divClassName Classe del div principale
	 * @return Il builder
	 */
	public HTMLSelectionAreaDivElementBuilder DivClassName (String divClassName)
	{
		this.divClassName = divClassName;
		return this;
	}

	/**
	 * Imposta il selector sul quale viene costruito il div
	 * Il selector può essere ad esempio una checkbox, un radio button, un range selector ecc.
	 * Al selector verrà in seguito associata la propria label
	 * @param selector Elemento di selezione (es. checkbox, radio button, range selector ecc.)
	 * @return Il builder
	 */
	public HTMLSelectionAreaDivElementBuilder Selector(HTMLInputElement selector) 
	{
		this.selector = selector;
		return this;
	}

	/**
	 * Imposta il class name della label che accompagna il selector
	 * @param labelClassName Classe della label che accompagna la selezione
	 * @return Il builder
	 */
	public HTMLSelectionAreaDivElementBuilder LabelClassName(String labelClassName)
	{
		this.labelClassName = labelClassName;
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id del div
	 * @return Il builder
	 */
	@Override
	public HTMLSelectionAreaDivElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome del div
	 * @return Il builder
	 */
	@Override
	public HTMLSelectionAreaDivElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id del div
	 * @return Il builder
	 */
	@Override
	public HTMLSelectionAreaDivElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Aggiunge elementi al div
	 * @param elements Elementi da aggiungere al div
	 * @return Il builder
	 */
	@Override
	public HTMLDivElementBuilder elementi(List<HTMLElement> elements)
	{
		addElementi(elements);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLSelectionAreaDivElementBuilder newBuilder()
	{
		return new HTMLSelectionAreaDivElementBuilder();
	}
	
	@Override
	public HTMLDivElement build()
	{
		//In generale il valore della label è uguale al valore del selector
		String labelValue = selector.value;
		if(selector.type.equals("range"))
		{
			//Se il selector è di tipo range il valore della label è uguale all'id del selector
			labelValue = selector.id;
			//E il className della label è nullo
			labelClassName = null;
		}
		
		//Creo la label che accompagna il selettore
		HTMLLabelElement lb = (HTMLLabelElement) HTMLLabelElementBuilder.newBuilder()
				.For(selector.id)
				.testo(labelValue) //ex value
				.Name(selector.name)
				.Id(selector.id)
				.ClassName(labelClassName)
				.build();
		
		//hidd usato per prendere il value della label
		HTMLInputElement hidd = (HTMLInputElement) HTMLHiddenElementBuilder.newBuilder()
				.Value(selector.id)
				.NameAndId("hiddenSelector")
				.build();
		
		
		
		if(selector.type.equals("range"))
			//Se è un range input vuole prima la label e poi il selector
			elementi(Arrays.asList(lb,selector, hidd));
		else 
			//Altrimenti prima il selector e poi la label
			elementi(Arrays.asList(selector, lb, hidd));
		
		/**
		 * 
		 
		//Creo il div da restituire
		HTMLDivElement elm =  (HTMLDivElement) document.createElement(stringType);
		if(divClassName!=null) 
			elm.className = divClassName;
		if(name!=null)
			elm.setAttribute("name", name);
		if(id!=null)
			elm.id = id;
		if(elementi!=null)
			for(int i=0; i<elementi.size(); i++)
				$(elm).append(elementi.get(i));
		*/
		
		return HTMLDivElementBuilder.newBuilder()
				.ClassName(divClassName)
				.Name(name)
				.Id(id)
				.elementi(elementi)
				.build();
	}
}
