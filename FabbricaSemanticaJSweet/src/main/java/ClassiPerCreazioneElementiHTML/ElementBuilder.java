package ClassiPerCreazioneElementiHTML;

import def.dom.HTMLElement;

/**
 * Rende la classe un Builder di HTMLElement tramite il metodo build()
 * @author Matteo
 */
public interface ElementBuilder 
{
	/**
	 * Ritorna un HTMLElement (o sottoclasse) costruito (build) con tutti i dati passati al builder di riferimento
	 * @return Un elemento html generico o un elemento più specifico (es. button, submit, input ecc.)
	 */
	public HTMLElement build();

	
}
