package gestioneDatabase;

import generatoreJson.RecordJson;

/**
 * Classe astratta che estende la queryBase
 * Aggiunge altre componenenti alla query per rendere le sue sottoclassi delle classi in grado di implementare query
 *  per la modifica di database,
 * Per modifica si intende sostanzialmente la cancellazione di record e la modifica di record
 * @author Matteo
 */
public abstract class queryModificatrice extends queryBase
{
	/**
	 * Id del record da eliminare
	 */
	protected int id = 0;

	/**
	 * nome della colonna contenente l'id
	 */
	protected String nomeCampoId = "";
	
	/**
	 * Imposta il nome della colonna contenente l'id
	 * @param nomeCampoId Nome della colonna contenente l'id
	 */
	public void AddNomeCampoId(String nomeCampoId) { this.nomeCampoId = nomeCampoId; }
	
	/**
	 * Imposta l'id del record da modificare/eliminare
	 * @param id Id del record da modificare/eliminare
	 */
	public void AddId(int id) { this.id = id;}
	
	/**
	 * Imposta l'id e il nome del campo id del record da modificare/eliminare ricevendo in input un RecordJson di tipo:
	 *  <br>Tag = NomeCampoId<br>
	 *  Value = Id
	 * @param idJson Record contenente il nome del campo e l'id
	 */
	public void AddId(RecordJson<Integer> idJson)
	{
		this.nomeCampoId = idJson.getTag();
		this.id = idJson.getValue();
	}
}
