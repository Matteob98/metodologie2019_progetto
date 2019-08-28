package ClassiPerCreazioneElementiHTML;


/**
 * Classe non instanziabile che costruisce e crea un submit button html
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
public class HTMLSubmitElementBuilder extends HTMLInputElementBuilder
{
	/**
	 * Non instanziabile
	 */
	protected HTMLSubmitElementBuilder () {}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Valore del pulsante
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder Value (String value)
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
	public HTMLSubmitElementBuilder PlaceHolder(String placeHolder)
	{
		addPlaceHolder(placeHolder);
		return this;
	}
	
	/**
	 * Imposta l'url dell'immagine che sostituisce il pulsante
	 * @param src Url dell'immagine da associare al pulsante
	 * @return Il builder
	 */
	public HTMLSubmitElementBuilder Src(String src)
	{
		addSrc(src);
		return this;
	}
	
	/**
	 * Imposta l'altezza del button
	 * @param height altezza del pulsante
	 * @return Il builder
	 */
	public HTMLSubmitElementBuilder Height(int height)
	{
		addHeight(height);
		return this;
	}
	
	/**
	 * Imposta la larghezza del button
	 * @param width Larghezza del pulsante
	 * @return Il builder
	 */
	public HTMLSubmitElementBuilder Width(int width)
	{
		addWidth(width);
		return this;
	}
	
	/**
	 * Imposta l'obbligatorietà del campo e ritorna il builder
	 * @param required Obbligatorietà del campo
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder Required (boolean required)
	{
		addRequired(required);
		return this;
	}
	
	/**
	 * Imposta il tipo dell'imput element e ritorna il builder
	 * @param tipo Tipo del pulsante
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder Tipo (String tipo)
	{
		addTipo(tipo);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className Classe del pulsante
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id Id del pulsante
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Nome del pulsante
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e id del pulsante
	 * @return Il builder
	 */
	@Override
	public HTMLSubmitElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLSubmitElementBuilder newBuilder()
	{		
		tipo = "submit";
		className = "btn btn-primary";
		stringType = "input";
		return new HTMLSubmitElementBuilder();
	}
	//Mantiene il build del padre

}
