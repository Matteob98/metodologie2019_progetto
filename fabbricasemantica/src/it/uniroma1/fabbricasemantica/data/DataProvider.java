package it.uniroma1.fabbricasemantica.data;

/**
 * Questa interfaccia rappresenta il metodo usato per ottenere i dati necessari ai vari task per funzionare.
 * @author Matteo
 * */
public interface DataProvider 
{
	
	/**
	 * Gestisce, in base al task, la ricerca di dati da passare al front-end
	 * Restituisce un oggetto di tipo String, inf formato Json, per il Task passato in input.
	 * @param task Il task dal quale richiedo i dati
	 * @return Una stringa in formato json con i dati, da restituire al front-end
	 **/
	String getData(Task task);

}
