package ClassiPerCreazioneElementiHTML;

/**
 * Builder che permette, se ereditato, di creare oggetti html in maniera modulare
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
public abstract class HTMLElementBuilder implements ElementBuilder
{
	/**
	 * Il tipo dell'elemento (input, label ecc.)
	 */
	protected static String stringType;
	/**
	 * Il className per la formattazione bootstrap
	 */
	protected static String className;
	/**
	 * Nome dell'elemento
	 */
	protected String name;
	
	/**
	 * Id dell'elemento
	 */
	protected String id;

	/**
	 * Non instanziabile
	 */
	protected HTMLElementBuilder(){};
	
	/**
	 * Imposta il className dell'oggetto che si vuole creare
	 * @param newClassName La classe dell'elemento
	 */
	protected void addClassName( String newClassName)
	{ 
		className = newClassName; 
	}

	/**
	 * Imposta il tipo dell'oggetto che si vuole creare
	 * @param newStringType Il tipo di elemento da creare
	 */
	protected void addStringType(String newStringType)
	{ 
		stringType = newStringType; 
	}

	/**
	 * Imposta il nome dell'oggetto che si vuole creare
	 * @param name Il nome dell'elemento
	 */
	protected void addName(String name) 
	{
		this.name = name;
	}

	/**
	 * Imposta l'id dell'oggetto che si vuole creare
	 * @param id L'id dell'elemento
	 */
	protected void addId(String id)
	{ 
		this.id = id;
	}
	
	/**
	 * Imposta il nome e l'id dell'oggetto che si vuole creare allo stesso valore
	 * @param name Il nome e l'id dell'elemento
	 */
	protected void addNameAndId(String name)
	{
		this.name = name;
		this.id = name;
	}

}

