package fr.gtm.BoVoyages.DestinationFacade;

import java.util.List;

import fr.gtm.BoVoyages.DestinationDAO.DestinationDAO;
import fr.gtm.BoVoyages.DestinationDAO.DestinationMockDAO;
import fr.gtm.BoVoyages.DestinationDAO.VoyageDAO;
import fr.gtm.BoVoyages.Entities.DatesVoyages;
import fr.gtm.BoVoyages.Entities.Destination;

/**
 * Date 04/10/2019
 * Classe modelisant la "Facade" Destinations de la couche Presentation du livrable.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class DestinationsFacade {
	private DestinationDAO dao = new DestinationMockDAO();
	private VoyageDAO voyageDAO;
	
	/**
	 * Constructeur par défaut DestinationsFacade()
	 */
	public DestinationsFacade() {}

	/**
	 * Constructeur DestinationsFacade(DestinationDAO destinationDAO)
	 * @param dao
	 */
	
	public DestinationsFacade(DestinationDAO destinationDAO) {
		this.dao = destinationDAO;
	}

/**
 * Constructeur DestinationsFacade(DestinationDAO destinationDAO,VoyageDAO voyageDAO)
 * @param dao
 * @param voyageDAO
 */
	
	public DestinationsFacade (DestinationDAO destinationDAO,VoyageDAO voyageDAO) {
		this.dao = destinationDAO;
		this.voyageDAO = voyageDAO;
		
	}
	
	/**
	 *Methode "Facade" de la couche Presentation du livrable.
	 *Appelle la methode create de DestinationMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param Parametre de type Destination.
	 *@return Pas de retour (Void). 
	 */
	public void createDestination(Destination destination) {
		dao.create(destination);
	}

	/**
	 *Methode "Facade" de la couche Pr�sentation du livrable.
	 *Appelle la methode getAllDestinations de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 *@param Aucun argument/parametre demande.
	 *@return Renvois la liste de toutes les destinations existantes. 
	 */
	public List<Destination> getAllDestinations() {
		return dao.getAllDestinations();
	}

	/**
	 *Methode "Facade" de la couche Presentation du livrable.
	 *Appelle la methode getDatesVoyages de DestinationMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param id Destination de type long.
	 *@return Renvois la liste de toutes les dates de voyages de tous les voyages correspondant à l'identifiant saisi. 
	 */
	public List<DatesVoyages> getDatesVoyages(long idDestination) {
		Destination destinations = dao.getDestinationByID(idDestination);
		return dao.getDatesVoyages(destinations);

	}

	/**
	 *Methode "Facade" de la couche Presentation du livrable.
	 *Appelle la methode getDestinationByRegion de DestinationMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param region de type String.
	 *@return Renvois la liste des destinations correpondant à la region saisie. 
	 */
	public List<Destination> getDestinationByRegion(String region) {
		return dao.getDestinationsByRegion(region);
	}

	/**
	 *Methode "Facade" de la couche Presentation du livrable.
	 *Appelle la methode getDatesVoyages de DestinationMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param de type Destination.
	 *@return Renvois la liste de toutes les dates de voyages existantes pour la destination saisie.
	 */
	public List<DatesVoyages> getDatesVoyages(Destination destination) {
		return dao.getDatesVoyages(destination);
	}
}
