package gestioneDatabase;

/**
 * Classe che contiene stringhe statiche contententi i nomi delle tabelle, 
 * delle colonne, dei tag ecc. di database e front-end
 * @author Matteo
 *
 */
public enum FabbricaSemanticaTag 
{
	
	/**
	 * -----------------------------------
	 * --
	 * Area in cui sono presenti tutti gli enum relativi al front-end
	 * --
	 * -----------------------------------
	 */

	/**
	 * Nome dell'email area del front end
	 */
	emailAreaName("emailArea"),

	/**
	 * Nome della password area del front end
	 */
	pswAreaName("pswArea"),

	/**
	 * Nome della text box dove l'utente inserisce il proprio nome nel front end
	 */
	nomeAreaName ("nomeTb"),

	/**
	 * Nome della text box dove l'utente inserisce il proprio nome nel front end
	 */
	cognomeAreaName("cognomeTb"),

	/**
	 * nome della password area dove l'utente ripete la password per sicurezza nel front end
	 */
	repeatPswAreaName("repeatPswArea"),

	/**
	 * Nome della select per la prima lingua opzionale nel front end
	 */
	primaLinguaScelta("primaLinguaOpzionale"),
	
	/**
	 * Nome della select per il livello della prima lingua opzionale nel front end
	 */
	primaLinguaLivello ("livelloPrimaLingua"),

	/**
	 *  Nome della select per la seconda lingua opzionale nel front end
	 */
	secondaLinguaScelta ("secondaLinguaOpzionale"),
	
	/**
	 * Nome della select per il livello della seconda lingua opzionale nel front end
	 */
	secondaLinguaLivello ("livelloSecondaLingua"),

	/**
	 *  Nome della select per la terza lingua opzionale nel front end
	 */
	terzaLinguaScelta ("terzaLinguaOpzionale"),

	/**
	 * Nome della select per il livello della terza lingua opzionale nel front end
	 */
	terzaLinguaLivello ("livelloTerzaLingua"),

	/**
	 * Nome della textBox dove l'utente inserisce la traduzione nel front end
	 */
	traduzioneTB ("traduzioneTb"),

	/**
	 * Nome dell'hidden che accompagna la parola nel front end
	 */
	parolaLb ("parolaLbHidden"),
	
	/**
	 * Nome delle checkbox per la selezione della lingua madre nel front end
	 */
	madreLinguaCB("madreLinguaCB"),
	
	/**
	 * Nome delle checkbox dove l'utente annota i sensi nel front end
	 */
	senseAnnotationCheckBox ("senses"),
	
	/**
	 * Nome del radio button dove l'utente annota il senso nel front end
	 */
	choiceAnnotationRadio ("choice"),
	
	/**
	 * Nome delle checkbox dove l'utente valida le traduzioni nel front end
	 */
	translationAnnotationCheckBox ("translations"),

	/**
	 * Nome dell'elemento nascosto che accompagna la label della descrizione nel front end
	 */
	descrizioneLb ("descrizioneLbHidden"),
	
	/**
	 * Nome dell'elemento nascosto che accompagna i sensi nel front end
	 */
	senseLb("senseLbHidden"),
	
	/**
	 * Nome dell'elemento nascosto che accompagna i selector nel front end
	 */
	textSelector("hiddenSelector"),

	/**
	 * Nome del range element di my annotation nel front end
	 */
	rangeSelectorTranslation("translations"),
	
	/**
	 * Valore dato quando l'utente sceglie di non validare nessuna delle traduzioni proposte  nel front end
	 */
	nessunaSelezione ("Nessuna delle seguenti"),
	
	/**
	 * Nome del pulsante di submit nel front end
	 */
	submitButton("next"),
	
	/**
	 * Nome del link di submit nel front end
	 */
	skipLink("skip_button"),
	
	
	/**
	 * ---------------------------------------
	 * --
	 * Area in cui sono presenti tutti i tag relativi alle tabelle del database
	 * --
	 * ---------------------------------------
	 */
	
	
	/**
	 * Nome della tabella dove sono salvati gli utenti registrati
	 */
	tabUtenti ("fabbricasemantica.usr_utenti"),
	/**
	 * Nome della tabella dove sono salvate le relazioni tra utenti, lingue e livello
	 */
	tabUtentiLingue ("fabbricasemantica.usr_utenti_lingue"),
	
	/**
	 * Nome della tabella dove sono salvate le lingue
	 */
	tabLingue ("fabbricasemantica.usr_lingue"),
	
	/**
	 * Nome della tabella dove sono salvati i livello
	 */
	tabLivelli ("fabbricasemantica.usr_livelli"),
	
	/**
	 * Nome della tabella dove sono salvate le traduzioni
	 */
	tabTraduzioni ("fabbricasemantica.fab_traduzioni"),
	
	/**
	 * Nome della tabella dove sono salvate le parole
	 */
	tabParole ("fabbricasemantica.fab_parole"),
	
	/**
	 * Nome della tabella dove sono salvati i sensi delle parole
	 */
	tabSensi("fabbricasemantica.fab_sensi"),
	
	/**
	 * Nome tabella dove è salvato il dizionario dei termini in inglese
	 */
	tabDizionarioInglese("fabbricasemantica.fab_dizionario_inglese"),
	
	/**
	 * Nome della tabella dove sono salvati gli esempi
	 */
	tabEsempi("fabbricasemantica.fab_esempi");

	
	/**
	 * String tag
	 */
    private String tag; 
    
    /**
     * Ritorna sotto forma di string l'enum relativo al tag del front-end selezionato
     * @return tag selezonato
     */
    public String getTag() 
    { 
        return this.tag; 
    } 
  
    /**
     * Costruttore privato che inizializza il tag
     * @param tag tag
     */
    private FabbricaSemanticaTag(String tag) 
    { 
        this.tag = tag; 
    } 
    

	
}
