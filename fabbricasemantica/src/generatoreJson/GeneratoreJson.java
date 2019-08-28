package generatoreJson;

/**
 * Classe non instanziabile che tramite il suo unico metodo statico generaStringJson permette di ricevere in output
 *  una stringa in formato json
 * @author Matteo
 *
 */
public class GeneratoreJson 
{
	/**
	 * Non instanziabile
	 */
	private GeneratoreJson() {};
	
	/**
	 * Genera una stringa in formato json dati in input n record in formato Json e la restituisce
	 * @param record un numero variabile di recordJson
	 * @return Stringa generata a partire dai record in input
	 */
	public static String generaStringJson(RecordJson<?>... record)
	{
		String json;
		//Se mi passano 0 record ritorno stringa vuota
		if (record.length == 0) json = "";
		//Se mi passano 1 record ritorno quel record
		else if(record.length ==1) json = "{" + record[0].toString() + "}";
		//Altrimenti concateno tutti i record
		else
		{
			json = "{";
			for(int i=0; i<record.length-1; i++)
				json+= record[i].toString() + ","; //Virgola tra un record e l'altro
			json += record[record.length-1] + "}";
		}
		return json;
	}
}
