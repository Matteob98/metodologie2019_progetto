package gestioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generatoreJson.RecordJson;

/**
 * Classe non istanziabile che permette di creare una query che cancella record da un database
 * Permette di passare l'id del record da eliminare, il nome del campo id, e la tabella
 * @author Matteo
 *
 */
public class queryDelete extends queryModificatrice 
{
	/**
	 * Non instanziabile
	 */
	private queryDelete() {}
	
	/**
	 * Ritorna un nuovo creatore di query
	 * @return Il builder della query
	 */
	public static queryDelete newQuery()
	{
		return new queryDelete();
	}
	
	/**
	 * Inserisce la connessione alla query
	 * @param conn Connessione al database sul quale lavora la query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete connection(Connection conn)
	{
		addConnection(conn);
		return this;
	}
	
	/**
	 * Imposta la tabella in cui eliminare il record
	 * @param tabella Tabella dal quale eliminare il record
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete tabella(String tabella)
	{
		addTabella(tabella);
		return this;
	}
	
	/**
	 * Imposta l'istruzione della query se è la prima, la aggiunge alle altre precedentemente inserite altrimenti
	 * @param istruzione Istruzione da aggiungere alla query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete Istruzione(String istruzione)
	{
		addIstruzione(istruzione);
		 return this;
	}
	
	/**
	 * Aggiunge un operazione all'ultima istruzione
	 * <br>Es.<br>
	 * Select * from tabella + orderBy rand()
	 * = select * from tabella orderBy rand()
	 * @param operazione Operazione da aggiungere alla query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete Operazione(String operazione)
	{
		addOperazione(operazione);
		return this;
	}
	
	/**
	 * Imposta il nome della colonna contenente l'id
	 * @param nomeCampoId Nome della colonna contenente l'id
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete NomeCampoId(String nomeCampoId)
	{
		AddNomeCampoId(nomeCampoId);
		return this;
	}
	
	/**
	 * Imposta l'id del record da eliminare
	 * @param id Id del record da eliminare
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete Id(int id)
	{
		AddId(id);
		return this;
	}
	
	/**
	 * Imposta l'id e il nome del campo id del record da eliminare ricevendo in input un RecordJson di tipo: <br>
	 *  Tag = NomeCampoId <br>
	 *  Value = Id <br>
	 * @param idJson RecordJson contenente come tag il nome del campo contenente l'id e come value l'id del record da eliminare
	 * @return La query con il nuovo parametro inserito
	 */
	public queryDelete Id(RecordJson<Integer> idJson)
	{
		AddId(idJson);
		return this;
	}
	
	@Override
	public String toString()
	{
		return "delete from " + tabella + " where " + nomeCampoId + "="+ id;
	}
	
	@Override
	public ResultSet esegui()
	{
		istruzione = this.toString();
		
		Statement stm;
		try 
		{
			stm = conn.createStatement();
			//Salva il risultato dell'esecuzione della query
			stm.executeUpdate(istruzione);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
