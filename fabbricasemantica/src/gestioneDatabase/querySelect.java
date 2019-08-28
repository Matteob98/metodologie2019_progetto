package gestioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generatoreJson.RecordJson;

/**
 * Classe non instanziabile che permette di creare una query per la selezione di record
 * Permette di passare in input la colonna, la tabella e le condizioni
 * @author Matteo
 *
 */
public class querySelect extends queryBase
{
	/**
	 * Se diverso da null il campo distinct sarà la colonna che contiene valori che non devono ripetersi nella select
	 */
	protected String distinct;
	/**
	 * Eventuali condizioni a cui deve sottostare la select
	 */
	protected String condizioni;
	
	/**
	 * Eventuali opzioni nella selezione
	 */
	protected String opzioni;
	
	/**
	 * Non instanziabile
	 */
	protected querySelect() {}
	
	/**
	 * Ritorna un nuovo creatore di query
	 * @return Il builder della query
	 */
	public static querySelect newQuery()
	{
		return new querySelect();
	}
	
	/**
	 * Inserisce la connessione alla query
	 * @param conn Connessione al database sul quale lavora la query
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect connection(Connection conn)
	{
		addConnection(conn);
		return this;
	}
	
	/**
	 * Imposta la colonna dal quale selezionare il record
	 * @param colonna Colonna dal quale selezionare il record
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect colonna(String colonna)
	{
		addColonna(colonna);
		return this;
	}
	
	/**
	 * Imposta la tabella in cui prelevare il record
	 * @param tabella dal quale prelevare il record
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect tabella(String tabella)
	{
		addTabella(tabella);
		return this;
	}
	
	/**
	 * Imposta l'istruzione della query se è la prima, la aggiunge alle altre precedentemente inserite altrimenti
	 * @param istruzione Istruzione da aggiungere alla query
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect Istruzione(String istruzione)
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
	public querySelect Operazione(String operazione)
	{
		addOperazione(operazione);

		return this;
	}
	
	/**
	 * Imposta la query in modo che tutti i record ritornati siano diversi tra loro in base al nome della 
	 * colonna passata in input
	 * @param colonna Colonna per il quale devono essere distinti i campi
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect distinct(String colonna)
	{
		this.distinct = colonna;
		return this;
	}
	
	/**
	 * Imposta le condizioni a cui deve sottostare la select
	 * @param condizioni Condizioni al quale deve sottostare la select
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect condizioni(RecordJson<?>... condizioni)
	{
		this.condizioni = elaboraCondizione(true, condizioni);
		return this;
	}
	
	/**
	 * Imposta le condizione che non deve verificarsi nel record.
	 * Ad esempio nome != 'matteo'
	 * @param condizioni Condizioni che NON devono verificarsi nel record
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect condizioniNegative(RecordJson<?>... condizioni)
	{
		this.condizioni = elaboraCondizione(false, condizioni);
		return this;
	}
	
	/**
	 * Ordina in maniera casuale gli elementi trovati.
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect random()
	{
		if(opzioni==null)
			opzioni = " ORDER BY RAND()";
		else
			opzioni += " ORDER BY RAND()";
		return this;
	}
	
	/**
	 * Imposta il numero di elementi da selezionare in maniera random
	 * @param numberOfElement Numero di elementi da selezionare dal database
	 * @return La query con il nuovo parametro inserito
	 */
	public querySelect numberOfElement(int numberOfElement)
	{
		if(opzioni==null)
			opzioni = " LIMIT " + numberOfElement;
		else
			opzioni += (" LIMIT " + numberOfElement);
		return this;
	}
	
	/**
	 * Dato un record Json elabora la condizione del tipo tag='valore' se posivite = true
	 * tag != 'valore' se positivo = false
	 * @param positive Decreta se la condizione deve essere positiva, cioè di uguaglianza, o negativa, di disuguaglianza
	 * @param condizioni Insieme delle condizioni al quale deve sottostare la select
	 * @return stringa del tipo tag='valore'
	 */
	private static String elaboraCondizione(boolean positive, RecordJson<?>... condizioni)
	{
		String comparatore = "=";
		if(!positive)
			comparatore = "!=";
		//Se non ci sono condizioni non ritorna nulla
		if(condizioni.length == 0) return "";
		
		//Se c'è una condizione sola la ritorna
		else if (condizioni.length == 1)
			return " where " + condizioni[0].getTag()+comparatore+"'"+condizioni[0].getValue()+"'";
		
		//Altrimenti concatena le diverse condizioni
		else
		{
			String ret = " where (";
			for(int i=0; i<condizioni.length-1; i++)
				ret += condizioni[i].getTag() + comparatore +"'" + condizioni[i].getValue()+"' AND ";
			ret+= condizioni[condizioni.length-1].getTag() + comparatore +"'" + condizioni[condizioni.length-1].getValue()+"')";
			return ret;
		}
	}
	
	/**
	 * Data la query costruita e il nome del campo id ritorna l'indice del primo record trovato, se presente, -1 altrimenti
	 * @param nomeCampoId Nome della colonna che contiene l'id
	 * @param query Query nel quale controllare
	 * @return -1(false) 0+(true)
	 */
	public static int isPresent(String nomeCampoId, queryBase query)
	{
		ResultSet rs = query.esegui();
		
		try 
		{
			//Ritorno l'indice del primo record utile trovato, altrimenti ritorno -1
			while(rs.next())
				return rs.getInt(nomeCampoId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//Se non ci sono risultati nella query ritorno -1
		return -1;
	}
	
	/**
	 * Ritorna il numero di record trovati eseguendo la query passata in inout
	 * @param query Query del quale effettuare il conteggio
	 * @return numero di record trovati nel database
	 */
	public static int count(queryBase query)
	{
		ResultSet rs = query.esegui();
		int count = 0;
		
		try 
		{
			while(rs.next())
				count++;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//Ritorno i record contati
		return count;
		
	}
	
	@Override
	public String toString()
	{
		if(distinct==null)
			 istruzione = "select " + colonna;
		 else
			 istruzione ="select distinct " + distinct;
		 
		 istruzione+=  " from " + tabella;
		 
		 if(condizioni!=null)
			 istruzione+=condizioni;
		 
		 if(opzioni!=null)
			 istruzione+=opzioni;
		 
		 return istruzione;
	}
	
	@Override
	public ResultSet esegui()
	{	
		 istruzione = this.toString();
		 
		 ResultSet rs = null;
		 Statement stm;
		 try 
		 {
			 stm = conn.createStatement();
			 //Salva il risultato dell'esecuzione della query
			 rs = stm.executeQuery(istruzione);
		 } 
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }
			
		 return rs;
	}


}
