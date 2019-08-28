package ClassiPerCreazioneElementiHTML;

import def.dom.HTMLInputElement;

/**
 * Classe non instanziabile che costruisce e crea un range input html
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
public class HTMLRangeInputElementBuilder extends HTMLInputElementBuilder 
{
	/**
	 * Valore minimo
	 */
	private int min = 0;
	/**
	 * Valore massimo
	 */
	private int max = 10;
	/**
	 * Step tra un valore e l'altro
	 */
	private double step =  1.0;
	
	/**
	 * Non instanziabile
	 */
	protected HTMLRangeInputElementBuilder () {}
	
	/**
	 * Imposta il valore minimo del range
	 * @param min Valore minimo selezionabile
	 * @return Il builder
	 */
	public HTMLRangeInputElementBuilder min (int min)
	{
		this.min = min;
		return this;
	}
	
	/**
	 * Imposta il valore massimo del range
	 * @param max Valore massimo selezionabile
	 * @return Il builder
	 */
	public HTMLRangeInputElementBuilder max (int max)
	{
		this.max = max;
		return this;
	}
	
	/**
	 * Imposta lo step tra un valore e l'altro del range
	 * @param step Intervallo tra un valore e l'altro
 	 * @return Il builder
	 */
	public HTMLRangeInputElementBuilder step (double step)
	{
		this.step = step;
		return this;
	}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Valore dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder Value (String value)
	{
		addValue(value);
		return this;
	}
	
	/**
	 * Imposta il testo in sovrimpressione dell'element e ritorna il builder
	 * @param placeHolder Testo in sovrimpressione
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder PlaceHolder(String placeHolder)
	{
		addPlaceHolder(placeHolder);
		return this;
	}
	
	/**
	 * Imposta l'obbligatorietà del campo e ritorna il builder
	 * @param required Obbligatorietà del campo
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder Required (boolean required)
	{
		addRequired(required);
		return this;
	}
	
	/**
	 * Imposta il tipo dell'imput element e ritorna il builder
	 * @param tipo Tipo dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder Tipo (String tipo)
	{
		addTipo(tipo);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id dell'elemento
	 * @return HTMLRangeInputElementBuilder
	 */
	@Override
	public HTMLRangeInputElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLRangeInputElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLRangeInputElementBuilder newBuilder()
	{
		stringType = "input";
		tipo = "range";
		className = "custom-range";
		return new HTMLRangeInputElementBuilder();
	}

	@Override
	public HTMLInputElement build()
	{
		HTMLInputElement elm=  super.build();
		
		elm.setAttribute("min", ""+min); 
		elm.setAttribute("max", ""+max); 
		elm.setAttribute("step", ""+step); 
		
		return elm;
		
		
	}
}
