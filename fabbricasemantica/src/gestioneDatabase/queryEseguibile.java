package gestioneDatabase;

import java.sql.ResultSet;

/**
 * Rende eseguibile una query attraverso il metodo esegui() che dovrà essere implementato da tutte le classi
 * che implementano questa interfaccia
 * @author Matteo
 *
 */
public interface queryEseguibile 
{
	/**
	 * Esegue la query creata con i valori passati alla query
	 * Ritorna un insieme di risultati, ognuno dei quali è un record del database.
	 * Torna un resultSet vuoto se non trova nulla
	 * @return Un insieme di record in formato ResultSet contenente tutti i record trovati eseguendo la query creata
	 */
	public ResultSet esegui();
}
