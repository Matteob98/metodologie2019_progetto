package ClassiPerCreazioneElementiHTML;

/**
 * Classe non instanziabile che costruisce e crea un elemento nascosto html
 * Utile per salvare su una pagina html dati senza mostrarli direttamente all'utente
 * Utile nel back-end per prendere dati dalla pagina, che altrimenti con elementi statici come le label
 *  non sarebbe stato possibile prendere.
 *  -----
 * ATTEZIONE!!! L'utente non vedrà direttamente i dati, ma potrà accedervi andando ad ispezionare la pagina
 * -----
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
public class HTMLHiddenElementBuilder extends HTMLInputElementBuilder 
{
	/**
	 * Non instanziabile
	 */
	protected HTMLHiddenElementBuilder() {}
	
	/**
	 * Imposta il valore dell'element e ritorna il builder
	 * @param value Il valore dell'elemento
	 * @return Il builder
	 */
	@Override
	public HTMLHiddenElementBuilder Value (String value)
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
	public HTMLHiddenElementBuilder PlaceHolder(String placeHolder)
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
	public HTMLHiddenElementBuilder Required (boolean required)
	{
		addRequired(required);
		return this;
	}
	
	/**
	 * Imposta il tipo dell'imput element e ritorna il builder
	 * @param tipo Il tipo del campo
	 * @return Il builder
	 */
	@Override
	public HTMLHiddenElementBuilder Tipo (String tipo)
	{
		addTipo(tipo);
		return this;
	}
	
	/**
	 * Imposta il className dell'element e ne ritorna il builder
	 * @param className La classe del campo
	 * @return Il builder
	 */
	@Override
	public HTMLHiddenElementBuilder ClassName(String className)
	{
		super.addClassName(className);
		return this;
	}
	
	/**
	 * Imposta l'id dell'element e ne ritorna il builder
	 * @param id L'id del campo
	 * @return Il builder
	 */
	@Override
	public HTMLHiddenElementBuilder Id(String id)
	{
		super.addId(id);
		return this;
	}
	
	/**
	 * Imposta il nome dell'element e ne ritorna il builder
	 * @param name Il nome del campo
	 * @return Il builder
	 */
	@Override
	public HTMLHiddenElementBuilder Name(String name)
	{
		super.addName(name);
		return this;
	}
	
	/**
	 * Imposta il nome e l'id dell'element e ne ritorna il builder
	 * @param name Nome e Id del campo
	 * @return Il builder
	 */
	@Override
	public HTMLHiddenElementBuilder NameAndId(String name)
	{
		super.addNameAndId(name);
		return this;
	}
	
	/**
	 * Ritorna il builder, necessario per la creazione dell'oggetto
	 * @return Il builder
	 */
	public static HTMLHiddenElementBuilder newBuilder()
	{
		tipo = "hidden";
		stringType = "input";
		return new HTMLHiddenElementBuilder();
	}
	
	//Mantiene il build del padre
}
