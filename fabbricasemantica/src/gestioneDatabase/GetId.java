package gestioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import generatoreJson.RecordJson;

/**
 * Classe non instanziabile che espone metodi per la ricerca di id all'interno del database a partire da valori 
 * che fanno parte del record di cui si vuole trovare l'id
 * @author Matteo
 *
 */
public class GetId 
{
	/**
	 * Classe non instanziabile
	 */
	private GetId() {};
	
	/**
	 * Dato il nome della tabella in cui cercare, la chiave logica, il nome della chiave logica e il nome dell'Id ritorna 
	 * l'id del record cercato
	 * @param nomeTabella Il nome della tabella in cui cercare l'id
	 * @param Chiave Chiave di cui si cerca l'id
	 * @param nomeChiave Nome della colonna che contiene la chiave
	 * @param nomeId Nome dell'id di cui si cerca il valore
	 * @return L'id della chiave passata in input
	 */
	private static int TrovaIdDaChiave(String nomeTabella, String Chiave, String nomeChiave, String nomeId)
	{
		Connection conn = gestioneDatabase.myAccessoAlDatabase();
		
		//Mi ricavo l'id dalla chiave
		ResultSet ricavaId = querySelect.newQuery()
				.condizioni(new RecordJson<String>(nomeChiave, Chiave))
				.tabella(nomeTabella)
				.connection(conn)
				.esegui();
		int Id = 0;
		try 
		{
			ricavaId.next();
			//Mi ricavo l'id (ritorna una String, che devo convertire in intero)
			Id = Integer.parseInt(ricavaId.getString(nomeId));
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		gestioneDatabase.ChiudiConnessione(conn);
		
		return Id;
	}
	
	
	/**
	 * Dato il nome di una lingua ne ritorna l'id, se presente, dal database
	 * @param nomeLingua Lingua di cui si cerca l'id
	 * @return Id della lingua passata in input
	 */
	public static int TrovaIdLingua(String nomeLingua)
	{
		return TrovaIdDaChiave(
				FabbricaSemanticaTag.tabLingue.getTag(),
				nomeLingua,
				"nomeLingua",
				"idLingua");
	}
	
	/**
	 * Dato il nome di un livello ne ritorna l'id, se presente, dal database
	 * @param nomeLivello Livello di cui si cerca l'id
	 * @return Id del livello passato in input
	 */
	public static int TrovaIdLivello(String nomeLivello)
	{
		return TrovaIdDaChiave(FabbricaSemanticaTag.tabLivelli.getTag(),
				nomeLivello,
				"siglaLivello",
				"idLivello");
	}
	
	/**
	 * Data l'email di un utente ne ritorna l'Id, se presente, dal database
	 * @param emailUtente email dell'utente di cui si cerca l'id
	 * @return Id dell'utente relativo all'email passata in input
	 */
	public static int TrovaIdUtente(String emailUtente)
	{
		return TrovaIdDaChiave(FabbricaSemanticaTag.tabUtenti.getTag(),
				emailUtente,
				"email",
				"idUtente");
	}
	
	/**
	 * Data una parola ne ritorna l'Id se presente nella tabella delle parole del database
	 * @param parola Parola di cui si cerca l'id
	 * @return Id della parola passata in input
	 */
	public static int TrovaIdParola(String parola)
	{
		return TrovaIdDaChiave(FabbricaSemanticaTag.tabParole.getTag(),
				parola,
				"parola",
				"idParola");
	}
	
	/**
	 * Data la descrizione ne ritorna l'ID nel database, se presente
	 * @param descr Descrizione di cui si cerca l'id
	 * @return Id della descrizione passata in input
	 */
	public static int TrovaIdDescrizione(String descr)
	{
		return TrovaIdDaChiave(FabbricaSemanticaTag.tabParole.getTag(),
				descr,
				"descrizione",
				"idParola");
	}
	
	

}
