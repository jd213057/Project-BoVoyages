package fr.gtm.BoVoyages.DestinationDAO;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.BoVoyages.Entities.DatesVoyages;
import fr.gtm.BoVoyages.Entities.Destination;


/**
 * Date 04/10/2019
 * Classe modelisant un MockDAO qui g�re les Destinations de BoVoyages.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 */
public class DestinationMockDAO implements DestinationDAO {

	/**
	 * @param destinations : parametre de type liste qui contient toutes les destinations de la base de données
	 * Identifiant de type long, unique et non nul servant de Primary Key pour chaque Destination.
	 */
	private List<Destination> destinations = new ArrayList<Destination>();
	private long id = 0;



	/**
	 *Methode simulant la mise en memoire dans la BDD d'une nouvelle Destination.
	 *La methode attribue un identifiant de type long, unique et non nul. Puis cr�ation d'un espace memoire dans la BDD pour la destination.
	 *@param Parametre de type Destination.
	 *@return Pas de retour (Void).  
	 */
	@Override
	public void create(Destination destination) {

		destination.setId(++id);
		destinations.add(destination);
	}

	/**
	 *Methode supprimant dans la BDD la Destination saisie.
	 *La methode efface dans la BDD l'espace m�moire associe à la destination.
	 *@param Parametre de type Destination.
	 *@return Pas de retour (Void). 
	 */
	@Override
	public void delete(Destination destination) {
		destinations.remove(destination);
		
	}

	/**
	 *Methode simulant la mise à jour dans la BDD d'une Destination.
	 *La m�thode parcours le MockDAO à la recherche de l'element voulu puis le remplace par la Destination saisie.
	 *@param Parametre de type Destination.
	 *@return Pas de retour (Void). 
	 */
	@Override
	public void update(Destination destination) {
		
		for (Destination d : destinations) {
			if (d.getId()==destination.getId()) {
			destination.setId(id);
			destination.setDescriptif(destination.getDescriptif());
			destination.setImages(destination.getImages());
			destination.setRegion(destination.getRegion());
			break;
			}
		}
		
	}

	/**
	 *Methode permettant de parcourir le MockDAO Destination et de rajouter dans une nouvelle liste toutes les destinations ayant en commun la region saisie.
	 *@param Parametre de type String (pour une region).
	 *@return Retourne la liste de destinations correspondant à la recherche. 
	 */
	@Override
	public List<Destination> getDestinationsByRegion(String region) {
		List<Destination> destinationsByRegion = new ArrayList<Destination>(); 
		for (Destination d : destinations) {
			if (d.getRegion().equals(region)) {
				destinationsByRegion.add(d);
			}
		}
		return destinationsByRegion;
	}

	/**
	 *Methode permettant de parcourir le MockDAO Destination et de renvoyer la destination correspondant à l'identifiant saisie.
	 *@param Paramètre de type long(identifiant de la destination).
	 *@return Retourne la destination correspondant à l'identifiant. 
	 */
	@Override
	public Destination getDestinationByID(long id) {
		for (Destination d : destinations) {
			if (d.getId()==id) {
				return d;
			}
		}
		 return null;
	}
	
	/**
	 *Methode permettant de parcourir le MockDAO Destination et de renvoyer la liste des dates de voyages correspondant à la destination saisie.
	 *@param Parametre de type Destination.
	 *@return Retourne la destination correspondant à l'identifiant. 
	 */
	@Override
	public List<DatesVoyages> getDatesVoyages(Destination destination) {
		for (Destination d : destinations) {
			if (d.getId() == destination.getId()) {
				return destination.getDatesVoyages();
			}
			}
		return null;
		}


	/**
	 *Methode permettant renvoyer sous forme de liste l'ensemble des destinations entré dans le MockDAO des destinations.
	 *@param Aucun argument/parametre demande.
	 *@return Retourne la liste de toutes les destinations existantes. 
	 */
	@Override
	public List<Destination> getAllDestinations() {
		return destinations;
	}

}