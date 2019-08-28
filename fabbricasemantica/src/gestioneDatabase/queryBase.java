package gestioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Classe astratta che costituisce la base per la creazione di una query
 * Se implementata attraverso il metodo esegui consente di interrogare il database con i dati inseriti in precedenza
 * @author Matteo
 *
 */
public abstract class queryBase implements queryEseguibile
{
	/**
	 * Istruzione che esegue la query
	 */
	protected String istruzione;
	/**
	 * Connessione al database
	 */
	protected Connection conn;
	
	/**
	 * Colonna da selezionare
	 */
	protected String colonna = "*";
	/**
	 * Tabella da cui selezionare il campo
	 */
	protected String tabella;
	
	/**
	 * Classe non instanziabile
	 */
	protected queryBase() {}
	
	/**
	 * Inserisce la connessione alla query
	 * @param conn Connessione al database su cui la query deve lavorare
	 */
	public void addConnection(Connection conn)
	{
		this.conn = conn;
	}
	
	/**
	 * Imposta la colonna dal quale selezionare il record
	 * @param colonna Colonna dal quale selezionare il record
	 */
	public void addColonna(String colonna)
	{
		this.colonna = colonna;
	}
	
	/**
	 * Imposta la tabella in cui prelevare il record
	 * @param tabella  Tabella dal quale selezionare il record
	 */
	public void addTabella(String tabella)
	{
		this.tabella = tabella;
	}
	
	/**
	 * Imposta l'istruzione della query se è la prima, la aggiunge alle altre precedentemente inserite altrimenti
	 * @param istruzione Istruzione da aggiungere alla query
	 */
	public void addIstruzione(String istruzione)
	{
		if(this.istruzione == null)
			this.istruzione = istruzione;
		else
			this.istruzione += "; " + istruzione;
	}
	
	/**
	 * Aggiunge un operazione all'ultima istruzione
	 * <br>
	 * Es.
	 * <br>
	 * Select * from tabella + orderBy rand()
	 * = select * from tabella orderBy rand()
	 * @param newOperazione Operazione da aggiungere alla query
	 */
	public void addOperazione(String newOperazione)
	{
		if(this.istruzione==null)
			this.istruzione = newOperazione;
		else
			this.istruzione += " " + newOperazione;
	}
	
	
	public abstract ResultSet esegui();

}
