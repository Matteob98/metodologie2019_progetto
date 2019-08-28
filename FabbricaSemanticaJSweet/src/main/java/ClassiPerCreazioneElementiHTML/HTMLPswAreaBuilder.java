package ClassiPerCreazioneElementiHTML;


/**
 * Classe non instanziabile che costruisce e crea una password area html
 * All'interno della password area l'utente non vedrà in chiaro il testo che scriverà
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
public class HTMLPswAreaBuilder extends HTMLInputElementBuilder 
{
	/**
	 * Non instanziabile
	 */
	protected HTMLPswAreaBuilder() {}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Il valore dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder Value (String value)
	{
		addValue(value);
		return this;
	}
	
	/**
	 * Imposta il testo in sovrimpressione dell'element e ritorna il builder
	 * @param placeHolder Il testo in sovrimpressione
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder PlaceHolder(String placeHolder)
	{
		addPlaceHolder(placeHolder);
		return this;
	}
	
	/**
	 * Imposta l'obbligatorietà del campo e ritorna il builder
	 * @param required L'obbligatorietà del campo
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder Required (boolean required)
	{
		addRequired(required);
		return this;
	}
	
	/**
	 * Imposta il tipo dell'imput element e ritorna il builder
	 * @param tipo Il tipo dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder Tipo (String tipo)
	{
		addTipo(tipo);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className La classe dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id L'id dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Il nome dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Il nome e l'id dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLPswAreaBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLPswAreaBuilder newBuilder()
	{
		stringType = "input";
		tipo = "password";
		className = "form-control";
		
		return new HTMLPswAreaBuilder();
	}
	
	//Mantiene il build del padre
}
