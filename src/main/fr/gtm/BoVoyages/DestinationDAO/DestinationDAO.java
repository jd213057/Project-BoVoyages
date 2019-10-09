package fr.gtm.BoVoyages.DestinationDAO;

import java.util.List;

import fr.gtm.BoVoyages.Entities.DatesVoyages;
import fr.gtm.BoVoyages.Entities.Destination;

/**
 *Date 04/10/2019
 * Interface g�rant le MockDAO des Destinations de BoVoyages.
 * @author Am�d�e COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public interface DestinationDAO {
	
	/**
	 *Appelle la m�thode create de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 *@param Param�tre de type Destination.
	 *@return Pas de retour (Void). 
	 */
	void create(Destination destination);
	/**
	 *Appelle la m�thode delete de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 *@param Param�tre de type Destination.
	 *@return Pas de retour (Void). 
	 */
	void delete(Destination destination);
	/**
	 *Appelle la m�thode update de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 *@param Param�tre de type Destination.
	 *@return Pas de retour (Void).
	 */
	void update(Destination destination);
	/**
	 * Appelle la m�thode getDestinationsByRegion de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 * @param region de type String.
	 * @return Retourne une liste Destination correspondant � la recherche.
	 */
	List<Destination> getDestinationsByRegion(String region);
	/**
	 * Appelle la m�thode getDestinationsByRegion de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 * @param id de type long.
	 * @return Retourne la destination correspondant � la recherche.
	 */
	Destination getDestinationByID(long id);
	/**
	 * Appelle la m�thode getDatesVoyages de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 * @param destination de type Destination..
	 * @return Retourne la liste de voyages correspondant � la recherche.
	 */
	List<DatesVoyages> getDatesVoyages(Destination destination);
	/**
	 * Appelle la m�thode getAllDestinations de DestinationMockDAO. Se reporter � cette classe pour plus de renseignements.
	 * @param destination de type Destination..
	 * @return Retourne la liste de toutes les destinations en m�moire.
	 */
	List<Destination> getAllDestinations();

}
