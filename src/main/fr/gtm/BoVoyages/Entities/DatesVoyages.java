package fr.gtm.BoVoyages.Entities;

import java.util.Date;

/**
 * Date 04/10/2019
 * Classe modelisant des dates de voyages.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class DatesVoyages {

	/**
	 * @param dateAller, dateRetour de type DatesVoyages. 
	 * @param tarifUnitaireHT de type double.
	 * @param identifiant de type long.
	 */
	private Date dateAller;
	private Date dateRetour;
	
	private double tarifUnitaireHT;
	
	private long id;
	
	/**
	 * Constructeur par défaut DatesVoyages()
	 */
	public DatesVoyages() {
		
	}
	
	
	/**
	 * Constructeur DatesVoyages(Date dateAller, Date dateRetour):
	 * @param dateAller
	 * @param dateRetour
	 */
	public DatesVoyages(Date dateAller, Date dateRetour) {
		super();
		this.dateAller = dateAller;
		this.dateRetour = dateRetour;
	}
	
	/**
	 * Constructeur DatesVoyages(Date dateAller, Date dateRetour, long id):
	 * @param dateAller
	 * @param dateRetour
	 * @param tarifUnitaireHT
	 */
	
	   public DatesVoyages(Date dateAller, Date dateRetour, double tarifUnitaireHT){
		   this.dateAller = dateAller;
		   this.dateRetour = dateRetour;
		   this.tarifUnitaireHT = tarifUnitaireHT;
	   }


	/**
	 * Constructeur DatesVoyages(Date dateAller, Date dateRetour, long id):
	 * @param dateAller
	 * @param dateRetour
	 * @param id
	 */
	public DatesVoyages(Date dateAller, Date dateRetour, long id) {
		super();
		this.dateAller = dateAller;
		this.dateRetour = dateRetour;
		this.id = id;
	}


	/**
	 * Constructeur DatesVoyages(Date dateAller, Date dateRetour, double tarifUnitaireHT, long id):
	 * @param dateAller
	 * @param dateRetour
	 * @param tarifUnitaireHT
	 * @param id
	 */
	public DatesVoyages(Date dateAller, Date dateRetour, double tarifUnitaireHT, long id) {
		super();
		this.dateAller = dateAller;
		this.dateRetour = dateRetour;
		this.tarifUnitaireHT = tarifUnitaireHT;
		this.id = id;
	}


	/**
	 * @return Renvois la date aller.
	 */
	public Date getDateAller() {
		return dateAller;
	}

	/**
	 * Attribue la date aller.
	 * @param dateAller de type DatesVoyages
	 */
	public void setDateAller(Date dateAller) {
		this.dateAller = dateAller;
	}

	/**
	 * @return Renvois la date retour.
	 */
	public Date getDateRetour() {
		return dateRetour;
	}

	/**
	 * Attribue la date retour.
	 * @param dateRetour
	 */
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * @return Renvois le tarif HT d'un voyage.
	 */
	public double getTarifUnitaireHT() {
		return tarifUnitaireHT;
	}

	/**
	 * Attribue le tarif HT d'un voyage.
	 * @param tarifUnitaireHT de type double.
	 */
	public void setTarifUnitaireHT(double tarifUnitaireHT) {
		this.tarifUnitaireHT = tarifUnitaireHT;
	}

	/**
	 * @return Renvois l'identifiant.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Attribue un identifiant.
	 * @param id de type long.
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}

