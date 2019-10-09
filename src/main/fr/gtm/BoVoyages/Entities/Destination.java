package fr.gtm.BoVoyages.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 04/10/2019
 * Classe modelisant une Destination.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class Destination {

	/**
	 * @param region, descriptif de type String.
	 * @param images de type liste<String>.
	 * @param id de type long.
	 * @param datesVoyages de type liste<String>.
	 */
	private String region, descriptif;

	private List<String> images = new ArrayList<String>();

	private long id;

	List<DatesVoyages> datesVoyages = new ArrayList<DatesVoyages>();

	/**
	 * Constructeur par défaut Destination().
	 */
	public Destination() {

	}

	/**
	 * Constructeur Destination(String region, String descriptif):
	 * @param region
	 * @param descriptif
	 */
	public Destination(String region, String descriptif) {
		super();
		this.region = region;
		this.descriptif = descriptif;
	}
	
	/**
	 * Constructeur Destination(String region, String descriptif):
	 * @param region
	 * @param descriptif
	 */
	public Destination(String region, String descriptif, List<String> images) {
		super();
		this.region = region;
		this.descriptif = descriptif;
		this.images = images;
	}
	
	/**
	 * Constructeur Destination(String region, String descriptif, List<String> images, List<DatesVoyages> datesVoyages):
	 * @param region
	 * @param descriptif
	 * @param images
	 * @param datesVoyages
	 */
	public Destination(String region, String descriptif, List<String> images, List<DatesVoyages> datesVoyages) {
		super();
		this.region = region;
		this.descriptif = descriptif;
		this.images = images;
		this.datesVoyages = datesVoyages;
	}

	/**
	 * Constructeur Destination(String region, String descriptif, long id):
	 * @param region
	 * @param descriptif
	 * @param id
	 */
	public Destination(long id,String region, String descriptif) {
		super();
		this.region = region;
		this.descriptif = descriptif;
		this.id = id;
	}
 
	/**
	 * Constructeur Destination(String region, String descriptif, long id, List<String> datesVoyages):
	 * @param region
	 * @param descriptif
	 * @param id
	 * @param images
	 */
	public Destination( long id, String region, String descriptif, List<String> images) {
		super();
		this.region = region;
		this.descriptif = descriptif;
		this.id = id;
		this.images = images;
	}
	
	/**
	 * Constructeur Destination(String region, String descriptif, long id, List<DatesVoyages> datesVoyages):
	 * @param region
	 * @param descriptif
	 * @param id
	 * @param datesVoyages
	 */
//	public Destination( long id, String region, String descriptif, List<DatesVoyages> datesVoyages) {
//		super();
//		this.region = region;
//		this.descriptif = descriptif;
//		this.id = id;
//		this.datesVoyages = datesVoyages;
//	}
	
	/**
	 * Constructeur Destination(String region, String descriptif, List<String> images, List<DatesVoyages> datesVoyages):
	 * @param region
	 * @param descriptif
	 * @param images
	 * @param datesVoyages
	 */
	public Destination( long id, String region, String descriptif, List<String> images, List<DatesVoyages> datesVoyages) {
		super();
		this.id = id;
		this.region = region;
		this.descriptif = descriptif;
		this.images = images;
		this.datesVoyages = datesVoyages;
	}

	/**
	 * @return Renvois une liste de dates de voyage.
	 */
	public List<DatesVoyages> getDatesVoyages() {
		return datesVoyages;
	}

	/**
	 * Attribue des dates de voyages à une destination.
	 * @param datesVoyages de type DatesVoyages.
	 */
	public void setDatesVoyages(List<DatesVoyages> datesVoyages) {
		this.datesVoyages = datesVoyages;
	}

	/**
	 * @return Renvois la region de la destination.
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Attribue la region à une destination.
	 * @param region de type String.
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return Renvois le descriptif d'une destination.
	 */
	public String getDescriptif() {
		return descriptif;
	}

	/**
	 * Attribue le descriptif d'une destination.
	 * @param descriptif de type String.
	 */
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	/**.
	 * @param Ajoute une image a liste images
	 */
	
	public void addImages(String image) {
		this.images.add(image);
	}

	/**
	 * @return Renvois la liste d'images de type String d'une destination.
	 */
	public List<String> getImages() {
		return images;
	}

	/**
	 * Configure la liste d'images d'une destination.
	 * @param images de type list<String>.
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}

	/**
	 * @return Renvois l'identifiant lié à la destination.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Attribue l'identifiant à une destination.
	 * @param id de type long.
	 */
	public void setId(long id) {
		this.id = id;
	}

}

