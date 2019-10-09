package fr.gtm.BoVoyages.DestinationDAO;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.BoVoyages.Entities.Destination;
import fr.gtm.BoVoyages.Entities.Voyage;

/**
 * Date 04/10/2019
 * Classe modelisant un MockDAO qui gère les Voyages de BoVoyages.
 * @author Amédée COSTES & Jonathan DIMUR
 * @version 1.0
 *
 */
public class VoyageMockDAO implements VoyageDAO {
	
	List<Voyage> voyages = new ArrayList<Voyage>();

	/**
	 * Identifiant de type long, unique et non nul servant de Primary Key pour chaque Voyage.
	 */
	private long id = 0;

	/**
	 *Methode simulant la mise en memoire dans la BDD d'une nouveau Voyage.
	 *La methode attribue un identifiant de type long, unique et non nul. Puis cr�ation d'un espace memoire dans la BDD pour le voyage.
	 *@param Parametre de type Voyage.
	 *@return Pas de retour (Void).
	 */
	@Override
	public void create(Voyage voyage) {

		voyage.setId(++id);
		voyages.add(voyage);
		
	}

	/**
	 *Methode simulant la suppression de la memoire de la BDD du Voyage saisi.
	 *La methode efface dans la BDD l'espace memoire associe au voyage.
	 *@param Parametre de type Voyage.
	 *@return Pas de retour (Void).
	 */
	@Override
	public void delete(Voyage voyage) {
		voyages.remove(voyage);
		
	}

	/**
	 *Methode simulant la mise � jour dans la BDD d'un Voyage.
	 *La m�thode parcours le MockDAO � la recherche de l'element voulu puis le remplace par le Voyage saisi.
	 *@param Parametre de type Voyage.
	 *@return Pas de retour (Void). 
	 */
	@Override
	public void update(Voyage voyage) {
		for (Voyage v : voyages) {
			if (v.getId()==v.getId()) {
				voyage.setId(id);
				voyage.setDescriptif(voyage.getDescriptif());
				voyage.setRegion(voyage.getRegion());
			}
		}
		
		
	}

	/**
	 *Methode permettant de parcourir le MockDAO Voyage et de renvoyer le voyage correspondant à l'identifiant saisie.
	 *@param Parametre de type long(identifiant de la destination).
	 *@return Retourne le voyage correspondant � l'identifiant. 
	 */
	@Override
	public Voyage getVoyageById(long id) {
		for (Voyage v : voyages) {
			if (v.getId()==id) {
				return v;
			}
		}
		 return null;
	}
	
}