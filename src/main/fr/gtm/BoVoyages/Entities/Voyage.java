package fr.gtm.BoVoyages.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 04/10/2019
 * Classe modelisant un Voyage.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class Voyage {

	/**
	 * @param region de type String.
	 * @param descriptif de type String.
	 * @param PrixTotalHT de type double.
	 * @param id de type long.
	 * @param datesVoyages de type DatesVoyages.
	 * @param voyageur de type Voyageur.
	 * @param client de type Client.
	 * @param destination de type Destination.
	 * @param voyageurs de type List<Voyageur>
	 */
	
	private String region;
	private String descriptif;
    double PrixTotalHT;
	private long id;
	private List<Voyageur> voyageurs = new ArrayList<Voyageur>();
	
	private DatesVoyages datesVoyages;

	private Voyageur voyageur;

	private Client client;

	/**
	 * Constructeur par défaut Voyage().
	 */
	public Voyage() {

	}

	/**
	 * Constructeur Voyage(DatesVoyages datesVoyage, String region, String descriptif).
	 * @param datesVoyages
	 * @param region
	 * @param descriptif
	 */
	
	public Voyage(DatesVoyages datesVoyage, String region, String descriptif) {
		this.datesVoyages = datesVoyage;
		this.region = region;
		this.descriptif = descriptif;
	}
	
	/**
	 * Constructeur Voyage(String region, String descriptif, long id).
	 * @param region
	 * @param descriptif
	 * @param id
	 */
	public Voyage(String region, String descriptif, long id) {
		super();
		this.region = region;
		this.descriptif = descriptif;
		this.id = id;
	}
	
	/**
	 * Constructeur Voyage(List<Voyageur> voyageurs, DatesVoyages datesVoyage, String region, String descriptif).
	 * @param voyageurs
	 * @param datesVoyages
	 * @param region
	 * @param descriptif
	 */
	public Voyage(List<Voyageur> voyageurs, DatesVoyages datesVoyage, String region, String descriptif) {
		this.voyageurs = voyageurs;
		this.datesVoyages = datesVoyage;
		this.region = region;
		this.descriptif = descriptif;
	}
	
	/**
	 * Constructeur Voyage(Client client, DatesVoyages datesVoyage, String region, String descriptif).
	 * @param client
	 * @param datesVoyages
	 * @param region
	 * @param descriptif
	 */
	public Voyage(Client client, DatesVoyages datesVoyage, String region, String descriptif) {
		this.client = client;
		this.datesVoyages = datesVoyage;
		this.region = region;
		this.descriptif = descriptif;
	}
	
	/**
	 * Constructeur Voyage(List<Voyageur> voyageurs,Client client, DatesVoyages datesVoyage, String region, String descriptif).
	 * @param voyageurs
	 * @param client
	 * @param datesVoyages
	 * @param region
	 * @param descriptif
	 */
	public Voyage(List<Voyageur> voyageurs,Client client, DatesVoyages datesVoyage, String region, String descriptif) {
		this.voyageurs = voyageurs;
		this.client = client;
		this.datesVoyages = datesVoyage;
		this.region = region;
		this.descriptif = descriptif;
	}

	/**
	 * @return Renvois les dates de voyages correspondant à une destination.
	 */
	public DatesVoyages getDatesVoyages() {
		return datesVoyages;
	}

	/**
	 * Attribue les dates de voyages d'une destination.
	 * @param datesVoyages de type DatesVoyages.
	 */
	public void setDatesVoyages(DatesVoyages datesVoyages) {
		this.datesVoyages = datesVoyages;
	}

	/**
	 * @return Renvois le voyageur liè à un voyage.
	 */
	public Voyageur getVoyageur() {
		return voyageur;
	}

	/**
	 * Attribue le voyageur à un voyage.
	 * @param voyageur de type Voyageur.
	 */
	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}

	/**
	 * @return Renvois le client liè au voyage.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Attribue le client à un voyage.
	 * @param client de type Client.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return Renvois la région lié à un voyage.
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Attribue une région à un voyage.
	 * @param region de type String.
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return Renvois le descriptif d'une destination lié à un voyage.
	 */
	public String getDescriptif() {
		return descriptif;
	}

	/**
	 * Attribue un descriptif à un voyage.
	 * @param descriptif de type String.
	 */
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	/**
	 * @return Renvois l'identifiant lié au voyage.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Attribue l'identifiant lié au voyage.
	 * @param id de type long.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return Renvois le prix Hors Taxes d'un voyage.
	 */
	public double getPrixTotalHT() {
		return PrixTotalHT;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setPrixTotalHT(double prixTotalHT) {
		PrixTotalHT = prixTotalHT;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

}
