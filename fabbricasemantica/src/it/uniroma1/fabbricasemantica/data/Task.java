package it.uniroma1.fabbricasemantica.data;

/**
 * Interfaccia che permette di prendere i valori da una classe enum
 * @author Matteo
 *
 */
public interface Task 
{
	/**
	 * Resituisce il testo di un enum
	 * @return Stringa contenente il testo relativo ad un enum
	 */
	default String getTaskID() 
	{
		return toString();
	}
	
}
