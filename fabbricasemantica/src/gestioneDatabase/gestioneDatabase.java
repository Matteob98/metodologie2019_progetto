package gestioneDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe non instanziabile contenente metodi per la gestione dei database
 * @author Matteo
 *
 */
public class gestioneDatabase 
{
	/**
	 * Nome del database
	 */
	private static final String nomeDB = "fabbricasemantica";
	/**
	 * Timezone in cui lavora il server
	 */
	private static final String serverTimezone = "Europe/Berlin";
	/**
	 * Nome utente
	 */
	private static final String user = "root";
	/**
	 * Password
	 */
	private static final String password = "matteob98";
	
	/**
	 * Costruttore privato, classe non instanziabile
	 */
	private gestioneDatabase() {};
	
	/**
	 * Esegue l'accesso al database gestendo eventuali eccezioni causate dalla connessione e ne ritorna la connection.
	 * L'accesso viene eseguito con i valori presi dai campi statici e finali della classe
	 * @return La connessione al database
	 */
	public static Connection myAccessoAlDatabase()
	{
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionString = "jdbc:mysql://localhost/" + nomeDB + 
					"?serverTimezone=" + serverTimezone +
					"&user="+ user + 
					"&password=" + password;
			
			conn = DriverManager.getConnection(connectionString);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}	
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Chiude la connessione al Database e ne gestisce le eventuali eccezioni
	 * @param conn La connessione al database da chiudere
	 */
	public static void ChiudiConnessione(Connection conn)
	{
		try 
		{
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
