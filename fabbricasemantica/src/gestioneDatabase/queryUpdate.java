package gestioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generatoreJson.RecordJson;

/**
 * Classe non instanziabile che permette la modifica di record nel database
 * La classe permette di impostare le modifiche da effettuare, l'id del record da modificae, la tabella
 *  da cui prendere il record ed eventuali altre operazioni, se richieste
 * @author Matteo
 *
 */
public class queryUpdate extends queryModificatrice 
{
	/**
	 * Modifiche da apportare al record
	 */
	protected String modifiche;

	/**
	 * Non instanziabile
	 */
	private queryUpdate() {}
	
	/**
	 * Ritorna un nuovo creatore di query
	 * @return Il builder della query
	 */
	public static queryUpdate newQuery()
	{
		return new queryUpdate();
	}
	
	/**
	 * Inserisce la connessione alla query
	 * @param conn Connessione al database sul quale deve lavorare la query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate connection(Connection conn)
	{
		addConnection(conn);
		return this;
	}
	
	/**
	 * Imposta la colonna dal quale selezionare il record
	 * @param colonna Colonna dal quale selezionare il record
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate colonna(String colonna)
	{
		addColonna(colonna);
		return this;
	}
	
	/**
	 * Imposta la tabella in cui prelevare il record
	 * @param tabella Tabella dal quale prelevare il record
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate tabella(String tabella)
	{
		addTabella(tabella);
		return this;
	}
	
	/**
	 * Imposta l'istruzione della query se è la prima, la aggiunge alle altre precedentemente inserite altrimenti
	 * @param istruzione Istruzione da aggiungere alla query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate Istruzione(String istruzione)
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
	public queryUpdate Operazione(String operazione)
	{
		addOperazione(operazione);
		return this;
	}

	
	/**
	 * Imposta il nome della colonna contenente l'id del record da modificare
	 * @param nomeCampoId Nome della colonna che contiene l'id
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate NomeCampoId(String nomeCampoId)
	{
		AddNomeCampoId(nomeCampoId);
		return this;
	}
	
	/**
	 * Imposta l'id del record da modificare
	 * @param id Id del record da modificare
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate Id(int id)
	{
		AddId(id);
		return this;
	}
	
	/**
	 * Imposta l'id e il nome del campo id del record da modificare ricevendo in input un RecordJson di tipo:
	 *  Tag = NomeCampoId
	 *  Value = Id
	 * @param idJson Record contenente il nome del campo e l'id del record da modificare
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate Id(RecordJson<Integer> idJson)
	{
		AddId(idJson);
		return this;
	}
	
	/**
	 * Passati in input N recordJson contententi come tag il campo da modificare e come valore il nuovo valore da inserire: 
	 * inserisce le modifiche nella query
	 * @param records Numero variabile di modifiche da apportare
	 * @return La query con il nuovo parametro inserito
	 */
	public queryUpdate modifiche(RecordJson<?>...records)
	{
		this.modifiche = elaboraModifiche(records);
		return this;
	}
	
	/**
	 * Dati n record Json contenente il campo da modificare e la modifica, li concatena e li fornisce in output
	 * @param records Numero variabile di modifiche da elaborare
	 * @return La query con il nuovo parametro inserito
	 */
	private static String elaboraModifiche(RecordJson<?>...records)
	{
		String result = "";
		for(int i=0; i<records.length; i++)
			result += records[i].getTag() + "='" + records[i].getValue() + "', ";
		result += records[records.length-1].getTag() + "='" + records[records.length-1].getValue() + "' ";
			
		return result;
	}
	
	@Override
	public String toString()
	{
		return  "update " + tabella +" set " + modifiche + " where " + nomeCampoId + "=" + id;
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
			stm.executeUpdate(super.istruzione);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
