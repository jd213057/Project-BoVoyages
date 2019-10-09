package fr.gtm.BoVoyages.DestinationDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.gtm.BoVoyages.DestinationDAO.DestinationDAO;
import fr.gtm.BoVoyages.DestinationDAO.DestinationMockDAO;
import fr.gtm.BoVoyages.DestinationDAO.VoyageMockDAO;
import fr.gtm.BoVoyages.Entities.Destination;
import fr.gtm.BoVoyages.DestinationFacade.DestinationsFacade;

public class DestinationMockDAOTest {

	@Test
	public void testN1VerifFonctionnaliteCreate() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec.png");
		destinationCanada.addImages("Montreal.png");
//		On utilise la fonction create
		destinationMockDAO.create(destinationCanada);
		List<Destination> destinations = new ArrayList<Destination>();
		destinations = destinationMockDAO.getAllDestinations();
		assertEquals("m", "Quebec", destinations.get(0).getRegion());
	}
	
	@Test
	public void testN2VerifFonctionnaliteDelete1() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec1.png");
		destinationCanada.addImages("Quebec2.png");
		destinationMockDAO.create(destinationCanada);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontario");
		destinationCanada2.setDescriptif("Des sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationMockDAO.create(destinationCanada2);
//		On supprime la destination 1
		destinationMockDAO.delete(destinationCanada);
		List<Destination> destinations = new ArrayList<Destination>();
		destinations = destinationMockDAO.getAllDestinations();
		assertEquals("m", "Ontario", destinations.get(0).getRegion());
	}
	
	@Test
	public void testN3VerifFonctionnaliteDelete2() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec1.png");
		destinationCanada.addImages("Quebec2.png");
		destinationMockDAO.create(destinationCanada);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontario");
		destinationCanada2.setDescriptif("Des sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationMockDAO.create(destinationCanada2);
//		On supprime la destination 1
		destinationMockDAO.delete(destinationCanada2);
		List<Destination> destinations = new ArrayList<Destination>();
		destinations = destinationMockDAO.getAllDestinations();
		assertEquals("m", "Quebec", destinations.get(0).getRegion());
	}
	
	@Test
	public void testN4VerifFonctionnaliteUpdate() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec1.png");
		destinationCanada.addImages("Quebec2.png");
		destinationMockDAO.create(destinationCanada);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontario");
		destinationCanada2.setDescriptif("Des sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationMockDAO.create(destinationCanada2);
//      On met a jour l'objet destinationCanada
		Destination destinationCanada3 = new Destination();
		destinationCanada3.setRegion("Quebec");
		destinationCanada3.setDescriptif("Pays de la Poutine");
		List<String> images = new ArrayList<String>();
		images.add("Montreal1.png");
		images.add("Montreal2.png");
		destinationCanada3.setImages(images);
		destinationCanada3.setId(1);
//		On met a jour la destination 1
		destinationMockDAO.update(destinationCanada3);
		List<Destination> destinations = new ArrayList<Destination>();
		destinations = destinationMockDAO.getAllDestinations();
		assertEquals("m", 2, destinations.size());
		assertEquals("m", "Montreal1.png", destinations.get(0).getImages().get(0));
		
	}
	
	@Test
	public void testN5GetDestinationsByRegion() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec1.png");
		destinationCanada.addImages("Quebec2.png");
		destinationMockDAO.create(destinationCanada);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontario");
		destinationCanada2.setDescriptif("Des sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationMockDAO.create(destinationCanada2);
		destinationMockDAO.update(destinationCanada);
		destinationMockDAO.update(destinationCanada2);
		List<Destination> destinations = new ArrayList<Destination>();
		destinations = destinationMockDAO.getDestinationsByRegion("Quebec");
		assertEquals("m", "Quebec", destinations.get(0).getRegion());
		List<Destination> destinations1 = new ArrayList<Destination>();
		destinations1 = destinationMockDAO.getDestinationsByRegion("Ontario");
		assertEquals("m", "Ontario", destinations1.get(0).getRegion());
		
	}
	
}
