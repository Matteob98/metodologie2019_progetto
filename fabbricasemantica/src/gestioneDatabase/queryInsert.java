package gestioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generatoreJson.RecordJson;

/**
 * Classe non istanziabile che permette di creare una query
 *  per l'inserimento di valori in un database
 * @author Matteo
 *
 */
public class queryInsert extends queryBase 
{
	/**
	 * Non instanziabile
	 */
	private queryInsert() {}
	
	/**
	 * Ritorna un nuovo creatore di query
	 * @return Il builder della query
	 */
	public static queryInsert newQuery()
	{
		return new queryInsert();
	}
	
	/**
	 * Inserisce la connessione alla query
	 * @param conn Connessione al database sul quale la query lavora
	 * @return La query con il nuovo parametro inserito
	 */
	public queryInsert connection(Connection conn)
	{
		addConnection(conn);
		return this;
	}
	
	/**
	 * Imposta la colonna dal quale selezionare il record
	 * @param colonna Colonna contenente i record da selezionare
	 * @return La query con il nuovo parametro inserito
	 */
	public queryInsert colonna(String colonna)
	{
		addColonna(colonna);
		return this;
	}
	
	/**
	 * Imposta la tabella in cui prelevare il record
	 * @param tabella Tabella dal quale prelevare i record
	 * @return La query con il nuovo parametro inserito
	 */
	public queryInsert tabella(String tabella)
	{
		addTabella(tabella);
		return this;
	}
	
	/**
	 * Imposta l'istruzione della query se è la prima, la aggiunge alle altre precedentemente inserite altrimenti
	 * @param istruzione Istruzione da aggiungere alla query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryInsert Istruzione(String istruzione)
	{
		addIstruzione(istruzione);
		 return this;
	}
	
	/**
	 * Aggiunge un operazione all'ultima istruzione
	 * <br> Es. <br>
	 * Select * from tabella + orderBy rand()
	 * = select * from tabella orderBy rand()
	 * @param operazione Operazione da aggiungere alla query
	 * @return La query con il nuovo parametro inserito
	 */
	public queryInsert Operazione(String operazione)
	{
		addOperazione(operazione);
		return this;
	}

	/**
	 * Dati n recordJson passati in input contententi l'indice della colonna e il dato da inserire,
	 *  imposta i valori da inserire con la query
	 * @param records Record contenente i dati da inserire
	 * @return La query con il nuovo parametro inserito
	 */
	public queryInsert valoriDaInserire(RecordJson<?>...records)
	{
		this.istruzione = generaIndiciColonna(records) + " values " + generaValoriDaInserire(records);
		return this;
	}
	
	/**
	 * Dati n record con tag di valori da inserire ritorna una stringa del tipo
	 *  (tag1, tag2, tagn)
	 * @param records Record contenenti i dati da inserire
	 * @return stringa in formato (tag1, tag2 ... tagn) per la creazione della query 
	 */
	private static String generaIndiciColonna(RecordJson<?>... records)
	{
		//Se non ci sono record ritorna ""
		if (records.length == 0)
			return "";
		
		String result = "(";
		
		for(int i=0; i<records.length-1; i++)
			result+= records[i].getTag() + ", ";
		result += records[records.length-1].getTag() + ")";
			
		return result;
	}

	/**
	 * Dati n record con valori da inserire ritorna una stringa del tipo
	 *  (valore 1, valore 2, valore n)
	 * @param records Record contenenti i dati da inserire
	 * @return stringa in formato (valore1, valore2 ... valoreN) per la creazione della query 
	 */
	private static String generaValoriDaInserire(RecordJson<?>... records)
	{
		//Se non ci sono record torna ""
		if (records.length == 0)
			return "";
		
		String result = "(";
		
		for(int i=0; i<records.length-1; i++)
			result+= "'" + records[i].getValue() + "', ";
		result += "'" + records[records.length-1].getValue() + "')";
			
		return result;
	}
	
	@Override
	public String toString()
	{
		return "insert into " + tabella + istruzione;
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
