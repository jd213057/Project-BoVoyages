package fr.gtm.BoVoyages.Entities;

/**
 * Date 04/10/2019
 * Classe modelisant un Client.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class Client {
	
	/**
	 * @param nom de type String.
	 * @param id de type long.
	 */
	private String nom;
	private long id;
	
	/**
	 * Constructeur par défaut Client()
	 */
	public Client() {
		
	}
	
	/**
	 * Constructeur Client(String nom)
	 * @param nom
	 */
	
	public Client(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Constructeur Client(long id)
	 * @param id
	 */
	
	public Client(long id) {
		this.id = id;
	}
	
	
	/**
	 * Constructeur Client(String nom, long id)
	 * @param nom
	 * @param id
	 */
	public Client(String nom, long id) {
		super();
		this.nom = nom;
		this.id = id;
	}
	/**
	 * @return Renvois le nom d'un client.
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Attribue un nom à un client.
	 * @param nom de type String.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return Renvois l'identifiant d'un client.
	 */
	public long getId() {
		return id;
	}
	/**
	 * Attribue un identifiant à un client.
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

}
