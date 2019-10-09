package fr.gtm.BoVoyages.DestinationDAO;

import java.util.List;

import fr.gtm.BoVoyages.Entities.DatesVoyages;
import fr.gtm.BoVoyages.Entities.Voyage;

/**
 * Date 04/10/2019
 * Interface gerant le MockDAO des Voyages de BoVoyages.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public interface VoyageDAO {
	
	/**
	 * Appelle la methode create de VoyageMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param Parametre de type Voyage.
	 *@return Pas de retour (Void). 
	 */
	void create(Voyage voyage);
	/**
	 * Appelle la methode delete de VoyageMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param Parametre de type Voyage.
	 *@return Pas de retour (Void).
	 */
	void delete(Voyage voyage);
	/**
	 * Appelle la methode update de VoyageMockDAO. Se reporter à cette classe pour plus de renseignements.
	 *@param Parametre de type Voyage.
	 *@return Pas de retour (Void).
	 */
	void update(Voyage voyage);
	/**
	 * Appelle la methode getVoyageById de VoyageMockDAO. Se reporter � cette classe pour plus de renseignements.
	 *@param Parametre de type Voyage.
	 *@return Renvois le Voyage correspondant à l'identifiant saisi.
	 */
	Voyage getVoyageById(long id);
	

}
