package fr.gtm.BoVoyages.Entities;

import java.util.Date;

/**
 * Date 04/10/2019
 * Classe modelisant un Voyageur.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class Voyageur {
	
	/**
	 * @param civilite, nom, prenom de type String.
	 * @param dateDeNaissance de type Date.
	 * @param id de type long.
	 */
	private String civilite;
	private String nom;
	private String prenom;
	
	private Date dateDeNaissance; 
	
	private long id;
	
	/**
	 * Constructeur par défaut de Voyageur().
	 */
	public Voyageur() {
		
	}
	
	/**
	 * Constructeur Voyageur(Date dateNaissance, String civilite, String nom, String prenom):
	 * @param dateDeNaissance
	 * @param civilite
	 * @param nom
	 * @param prenom
	 */
	public Voyageur(Date dateNaissance, String civilite, String nom, String prenom){
		this.dateDeNaissance = dateNaissance;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Constructeur Voyageur(String civilite, String nom, String prenom, Date dateDeNaissance, long id):
	 * @param civilite
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param id
	 */
	public Voyageur(Date dateNaissance, String civilite, String nom, String prenom, long id) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateNaissance;
		this.id = id;
	}

	/**
	 * @return Renvois la civilité du client.
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * Attribue la civilité du client.
	 * @param civilite
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	/**
	 * @return Renvois le nom du Client.
	 */
	public String getNom() {
		return nom;
	}

	/**Attribue le nom d'un Client.
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Renvois le prénom du Client.
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Attribue le prénom du Client. 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return Renvois la date de naissance du Client.
	 */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * Attribue la date de naissance du Client.
	 * @param dateDeNaissance
	 */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return Renvois l'identifiant du Client.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Attribue l'identifiant à un client.
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	} 

}
