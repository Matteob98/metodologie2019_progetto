package it.uniroma1.fabbricasemantica.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import generatoreJson.GeneratoreJson;
import generatoreJson.RecordJson;
import gestioneDatabase.*;

/**
 * Questa classe restituisce i dati necessari per il task ricevuto in input.
 * Il metodo {@link #getData(Task)} restituira' una stringa in formato JSON
 * che le pagine in JSweet andranno a formattare.
 * N.B. Il proprio {@link DataProvider} dovrebbe evitare di avere stringhe codificate, questo e' solo un esempio.
 * @author Matteo
 **/
public class CustomizedDataProvider implements DataProvider
{
	/**
	 * Connessione al DB
	 */
	private Connection conn = null;
	/**
	 * Word presa dal DB
	 */
	private String word;
	/**
	 * Descrizione presa dal DB
	 */
	private String description;
	/**
	 * Iperonimo preso dal DB
	 */
	private String hyperonim;
	/**
	 * Esempio in cui compare la parola
	 */
	private String example;
	
	//Lista di tag per formattare le stringhe json da inviare al front-end
	private static final String descriptionTag = "description";
	private static final String wordTag = "word";
	private static final String hyperonimTag = "hypernym";
	private static final String sensesTag = "senses";
	private static final String senseTag = "sense";
	private static final String translationsTag = "translations";
	private static final String exampleTag = "example";
	
	
	@Override 
	public String getData(Task task) 
	{
		String risultato = null;
		
		conn = gestioneDatabase.myAccessoAlDatabase(); //Si connette al Database
		
		/*
		 * In base allo StandardTask passato in input elaboro la risposta
		 */
		
		if (task == StandardTask.TRANSLATION_ANNOTATION) 
		{
			getWordData(conn);
			
			//Ritorno la stringa Json contenente parola e descrizione
			return GeneratoreJson.generaStringJson(
					new RecordJson<String>(wordTag, word),
					new RecordJson<String>(descriptionTag, description)
					);
			
		}
		else if (task == StandardTask.WORD_ANNOTATION) 
		{
			getWordData(conn);
			
			//Ritorno la stringa json contenente la descrizione
			risultato = GeneratoreJson.generaStringJson(
					new RecordJson<String>(descriptionTag, description)
					);

		}
		else if (task == StandardTask.DEFINITION_ANNOTATION) 
		{			
			getWordData(conn);
			
			//Ritorno la stringa json contenente la parola e l'iperonimo
			risultato =  GeneratoreJson.generaStringJson(
					new RecordJson<String>(wordTag, word),
					new RecordJson<String>(hyperonimTag, hyperonim)
					);
			
		}
		else if (task == StandardTask.SENSE_ANNOTATION) 
		{
			//Prende l'id della parola e il relativo esempio a partire da un esempio casuale
			int idParola = getExample(conn, getRandomExampleRecord(conn));

			//Prende i dati relativi alla parola
			getWordData(conn, idParola);
			
			ArrayList<String> sensiList = new ArrayList<String>();
			
			sensiList = getListOfData(sensiList,
					4, 
					"senso",
					idParola,
					FabbricaSemanticaTag.tabSensi.getTag(),
					conn);
					
			//Restituisco la string json ricavata dai dati inseriti
			risultato = GeneratoreJson.generaStringJson(
					new RecordJson<String>(wordTag, word),
					new RecordJson<String>(exampleTag, example),
					new RecordJson(sensesTag, sensiList.toArray())
					);
		}
		else if (task == StandardTask.TRANSLATION_VALIDATION) 
		{
			ArrayList<String> tradList = new ArrayList<String>();

			//Prende l'id della parola da una traduzione casuale ed aggiunge alla lista delle traduzioni 
			//una traduzione casuale
			int idParola = getTranslation(conn, tradList, getRandomTranslationRecord(conn));

			//Prende i dati relativi alla parola
			getWordData(conn, idParola);
			
			getListOfData(tradList,
					3,
					"traduzione",
					idParola,
					FabbricaSemanticaTag.tabTraduzioni.getTag(),
					conn);
			
			return GeneratoreJson.generaStringJson(
					new RecordJson<String>(wordTag, word),
					new RecordJson<String>(descriptionTag, description),
					new RecordJson(translationsTag, tradList.toArray())
					);
		}
		else if (task == StandardTask.SENSE_VALIDATION) 
		{
			//Prendo un esempio a caso dal database

			int idParola = getExample(conn, getRandomExampleRecord(conn));
			
			getWordData(conn, idParola);			
		
			//Prende 1 record contenente sensi della parola
			ResultSet setSensi = querySelect.newQuery()
					.random()
					.numberOfElement(1)
					.condizioni(new RecordJson<Integer>("idParola", idParola))
					.tabella(FabbricaSemanticaTag.tabSensi.getTag())
					.connection(conn)
					.esegui();

			String senso = null;
			try
			{
				setSensi.next();
				senso = setSensi.getString("senso");
			} 
			catch (SQLException e)
			{				
				e.printStackTrace();
			}

			
			risultato = GeneratoreJson.generaStringJson(
					new RecordJson<String>(wordTag, word),
					new RecordJson<String>(exampleTag, example),
					new RecordJson<String>(senseTag, senso)
					);
			
		}
		else if (task == StandardTask.MY_ANNOTATION)
		{
			
			ArrayList<String> tradList = new ArrayList<String>();
			
			int idParola = getTranslation(conn, tradList, getRandomTranslationRecord(conn));
			
			getWordData(conn, idParola);
			
			tradList = getListOfData(tradList,
					4,
					"traduzione",
					idParola,
					FabbricaSemanticaTag.tabTraduzioni.getTag(),
					conn);

			risultato = GeneratoreJson.generaStringJson(
					new RecordJson<String>(wordTag, word),
					new RecordJson<String>(descriptionTag, description),
					new RecordJson(translationsTag, tradList.toArray())
					);
		}
		
		gestioneDatabase.ChiudiConnessione(conn);
		return risultato; 
	}
	

	/**
	 * Ritorna un qualsiasi record della tabella parole
	 * @param conn Connessione al database dal quale prendere la parola
	 * @return Un ResultSet contenente un solo record contenente una parola random
	 */
	private static ResultSet getRandomWordRecord(Connection conn)
	{
		return  querySelect.newQuery()
				.random()
				.numberOfElement(1)
				.tabella(FabbricaSemanticaTag.tabParole.getTag())
				.connection(conn)
				.esegui();
	}
	
	/**
	 * Ritorna un qualsiasi record della tabella esempi
	 * @param conn Connessione al database dal quale prendere gli esempi
	 * @return Un ResultSet contenente un solo record contenente un esempio random
	 */
	private static ResultSet getRandomExampleRecord(Connection conn)
	{
		return querySelect.newQuery()
					.random()
					.numberOfElement(1)
					.tabella(FabbricaSemanticaTag.tabEsempi.getTag())
					.connection(conn)
					.esegui();
	}
	
	/**
	 * Ritorna un qualsiasi record della tabella traduzioni
	 * @param conn Connessione al database dal quale prendere la traduzione
	 * @return Un ResultSet contenente un solo record contenente una sola traduzione random
	 */
	private static ResultSet getRandomTranslationRecord(Connection conn)
	{
		return querySelect.newQuery()
				.random()
				.numberOfElement(1)
				.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
				.connection(conn)
				.esegui();
	}
	
	/**
	 * Ritorna un senso casuale dalla tabella sensi
	 * @param conn Connessione al database dal quale prendere il senso
	 * @return Una stringa contenente un senso random
	 */
	private static String getRandomSense(Connection conn)
	{
		ResultSet rs = querySelect.newQuery()
				.random()
				.numberOfElement(1)
				.tabella(FabbricaSemanticaTag.tabSensi.getTag())
				.connection(conn)
				.esegui();
		String senso = null;
		try
		{
			rs.next();
			senso = rs.getString("senso");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return senso;
		
	}
	
	/**
	 * Ritorna una traduzione a caso tra quelle presenti nella tabella raduzioni
	 * @param conn Connessione al database dal quale prendere la traduzione
	 * @return Un stringa contenente una traduzione random
	 */
	private static String getRandomTranslation(Connection conn)
	{
		ResultSet rs = querySelect.newQuery()
				.random()
				.numberOfElement(1)
				.tabella(FabbricaSemanticaTag.tabTraduzioni.getTag())
				.connection(conn)
				.esegui();
		String trad = null;
		try
		{
			rs.next();
			trad = rs.getString("traduzione");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return trad;
	}
	
	/**
	 * Metodo privato che, data in input la connessione al database, prende una parola casuale dalla tabella delle parole
	 * e salva la parola stessa, la sua descrizione e l'iperonimo nei campi word, description e hyperonim
	 * @param conn Connessione al database dal quale prendere i dati della parola
	 */
	private void getWordData(Connection conn)
	{
		ResultSet wordSet = getRandomWordRecord(conn); //prendo un record qualsiasi talla tabella parole
		getWordData(conn, wordSet);
		
	}
	
	/**
	 * Metodo che si aspetta nel ResultSet la chiamata ad una query sulla tabella delle parole
	 * Metodo privato che, data in input la connessione al database e il risultato di una query sulla tabella parole,
	 * salva la parola stessa, la sua descrizione e l'iperonimo nei campi word, description e hyperonim
	 * @param conn Connessione al database dal quale prendere i dati della parola
	 * @param wordSet Risultato di una query chiamata sulla tabella delle parole
	 */
	private void getWordData(Connection conn, ResultSet wordSet)
	{
		//Prendo dal record la parola e la descrizione
		try 
		{
			wordSet.next();
			word = wordSet.getString("parola");
			description = wordSet.getString("descrizione");
			hyperonim = wordSet.getString("iperonimo_wnet");
		} 
		catch (SQLException e2)
		{
			e2.printStackTrace();
		}
	}
	
	/**
	 * Metodo privato che, data in input una connessione al database e l'id di una parola, interroga il database con una
	 * query per ricevere il record che contiene la parola all'interno della tabella parole del database.
	 * Salva la parola stessa, la sua descrizione e l'iperonimo nei campi word, description e hyperonim
	 * @param conn Connessione al database dal quale prendere i dati della parola
	 * @param idParola Id della parola del quale vogliamo ricavare i dati
	 */
	private void getWordData(Connection conn, int idParola)
	{
		//Prende il record contenente la parola relativa all'indice trovato prima
		ResultSet setParola = querySelect.newQuery()
				.condizioni(new RecordJson<Integer>("idParola", idParola))
				.tabella(FabbricaSemanticaTag.tabParole.getTag())
				.connection(conn)
				.esegui();
		
		getWordData(conn, setParola);
	}
	
	/**
	 * Metodo che si aspetta di ricevere in input la chiamata ad una query nella tabella esempi
	 * Metodo privato che data in input la connessione e il risultato di una chiamata alla query:
	 * ritorna l'id della parola e imposta il campo esempio al valore trovato nel record
	 * @param conn Connessione al database dal quale prendere i dati della parola
	 * @param setEsempio Risultato della chiamata ad una query sulla tabella esempi
	 * @return idParola Id della parola del quale si è ricavato l'esempio
	 */
	private int getExample(Connection conn, ResultSet setEsempio)
	{
		int idParola = -1;
		//Prendo dal record l'esempio e l'id della parola
		try 
		{
			setEsempio.next();
			idParola = setEsempio.getInt("idParola");
			example = setEsempio.getString("esempio");

		} 
		catch (SQLException e2)
		{
			e2.printStackTrace();
		}
		
		return idParola;
	}
	
	/**
	 * Metodo che si aspetta in input la chiamata ad una query della tabella traduzioni
	 * Dati in input la connessione al database, l'array list dove inserire la traduzione trovata e 
	 * il risultato di una query chiamata nella tabella delle traduzioni:
	 * Ritorna l'id della parola tradotta e inserisce nell'array delle traduzioni la traduzione trovata
	 * @param conn Connessione al database dal quale prendere i dati della parola
	 * @param tradList Lista dove salvare le traduzioni
	 * @param setTranslation Risultato della chiamata ad una query sulla tabella delle traduzioni
	 * @return idParola Id della parola del quale si è presa la traduzione
	 */
	private int getTranslation(Connection conn, ArrayList<String> tradList, ResultSet setTranslation)
	{
		int idParola = 0;
		//Prendo dal record l'esempio e l'id della parola
		try 
		{
			setTranslation.next();
			tradList.add(setTranslation.getString("traduzione"));
			idParola = setTranslation.getInt("idParola");
		} 
		catch (SQLException e2)
		{
			e2.printStackTrace();
		}
		
		return idParola;
	}
	
	/**
	 * Ritorna una lista di dati, di dimensione pari al parametro numberOfElement passato in input.
	 * I dati vengono presi dalla colonna passata in input della tabella passata in input.
	 * La priorità viene data ai dati collegati all'id della parola passata in input.
	 * In caso di dati insufficenti per arrivare alla dimensione prefissata, i rimanenti vengono presi da dati non collegati 
	 * all'id passato in input
	 * @param List Lista sul quale salvare i dati
	 * @param numberOfElement Numero di elementi da prendere
	 * @param colonna Colonna dal quale prendere i dati
	 * @param idParola Id della parola del quale prendere i dati, se presenti
	 * @param tabella Tabella dal quale prendere i dati
	 * @param conn Connessione al database dal quale prendere i dati
	 * @return una lista di dati presi dal database
	 */
	private ArrayList<String> getListOfData(ArrayList<String> List, int numberOfElement, String colonna, int idParola, String tabella, Connection conn)
	{
		//Prendo un numero di dati massimo (in base al limite passato in input)
		//dal database dalla tabella e dalla colonna passate in input, collegati all'id passato in input.
		//Tutti distinti in base al campo colonna
		ResultSet dataQuery = querySelect.newQuery()
				.random()
				.numberOfElement(numberOfElement) //Numero di elementi da cercare
				.distinct(colonna)
				.condizioni(new RecordJson<Integer>("idParola", idParola))
				.tabella(tabella)
				.connection(conn)
				.esegui();				
		
		try
		{	
			//Finchè ho dati e per un massimo di elementi: prendo i dati dal resultSet e, se non sono già
			//presenti nella lista li aggiungo
			while(dataQuery.next() && List.size()<numberOfElement)
			{
				String data = dataQuery.getString(colonna);
				if(!(List.contains(data)))
					List.add(data);
			}		
		} 
		catch (SQLException e)
		{				
			e.printStackTrace();
		}
		
		//Se ho trovato meno di N dati ne prendo altri a caso dal database
		//Finchè ho meno dati di quelli checerco
		while(List.size()<numberOfElement)
		{
			String data = tabella.equals(FabbricaSemanticaTag.tabTraduzioni.getTag()) 
					? getRandomTranslation(conn) 
							: getRandomSense(conn);
			if(!(List.contains(data))) //Se non è già presente le aggiungo, altrimenti continuo
				List.add(data);
		}
		
		return List;
	}
}
