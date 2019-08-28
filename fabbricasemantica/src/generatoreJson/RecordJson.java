package generatoreJson;

/**
 * Classe che permette di creare record Json
 * Un record json è in formato key:value
 * Tramite la classe GeneratoreJson le stringhe possono essere composte e stampate
 * @author Matteo
 **/
public class RecordJson <T>
{
	/**
	 * Tag della stringa
	 */
	private String tag;
	/*
	 * Valore se singolo
	 */
	private T value;
	/**
	 * Valori se multpli
	 */
	private T[] values;
	
	/**
	 * Inizializza un Record in formato Json a partire dal tag e dal value
	 * @param tag tag del record
	 * @param value valore del record (di tipo generico)
	 */
	public RecordJson(String tag, T value)
	{
		this.tag = tag;
		this.value = value;
		this.values = null;
	}
	
	/**
	 * Inizializza un Record in formato Json a partire dal tag e da un vettore di valori
	 * @param tag tag del record
	 * @param values un vettore di valori di tipo generico
	 */
	public RecordJson(String tag, T[] values)
	{
		this.tag = tag;
		this.values = values;
		this.value = null;
	}
	
	/**
	 * Ritorna il tag
	 * @return il tag 
	 */
	public String getTag() { return this.tag; }
	/**
	 * Ritorna il valore, se presenti
	 * @return valore del record
	 */
	public T getValue() { return this.value; }
	
	/**
	 * Ritorna un array di valori, se presenti
	 * @return array di valori del record
	 */
	public T[] getValues() {return this.values; }
	
	public String toString()
	{
		//Se l'array è nullo devo restituire solo la stringa value
		if(values == null)
			return "\"" + tag + "\": \"" + value + "\"";
		
		//Se la stringa è nulla devo restituire l'array values
		if(value == null)
		{
			String ret = "\"" + tag + "\": [";
			for(int i=0; i<values.length-1; i++)
				ret+= "\"" + values[i] + "\",";
			ret+="\"" + values[values.length-1] + "\"]";
			
			return ret;
		}
		
		return null;
			
	}

}
