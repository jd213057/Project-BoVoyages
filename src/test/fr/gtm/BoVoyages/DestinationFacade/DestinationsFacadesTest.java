package fr.gtm.BoVoyages.DestinationFacade;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.Test;

import fr.gtm.BoVoyages.DestinationDAO.DestinationDAO;
import fr.gtm.BoVoyages.DestinationDAO.DestinationMockDAO;
import fr.gtm.BoVoyages.DestinationDAO.VoyageMockDAO;
import fr.gtm.BoVoyages.Entities.Destination;
import fr.gtm.BoVoyages.Entities.DatesVoyages;
import fr.gtm.BoVoyages.DestinationFacade.DestinationsFacade;

public class DestinationsFacadesTest {
//
//	
//	Test de la fonctionnalite de la methode getDestinationByRegion() de la façade
//	-> dans ce test, il n'y a qu'une destination
//	-> on cree une destination que l'on place dans la mock puis on demande à la façade
//	      de renvoyer la liste des destionations dont la region est celle demandee
	@Test
	public void testN1GetDestinationByRegion() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec.png");
		destinationCanada.addImages("Montreal.png");
		destinationMockDAO.create(destinationCanada);
		VoyageMockDAO voyageMockDAO = new VoyageMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationMockDAO,voyageMockDAO);
		List<Destination> destinationDemandee = new ArrayList<Destination>();
		destinationDemandee = destinationFacade.getDestinationByRegion("Quebec");
		assertEquals("m", "Quebec", destinationDemandee.get(0).getRegion());
	}
//	
//	Test de la fonctionnalite de la methode getDestinationByRegion() de la façade
//	-> dans ce test, il y a plusieurs destinations
//	-> on cree plusieurs destinations que l'on place dans la mock puis on demande à la façade
//	      de renvoyer la liste des destionations dont la region est celle demandee
//	-> cela permet de tester la capacite de la methode a fonctionner avec n'importe quel
//	      nombre de destinations qui on la même region
	@Test
	public void testN2GetDestinationByRegion2() {
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
		Destination destinationCanada3 = new Destination();
		destinationCanada3.setRegion("Quebec");
		destinationCanada3.setDescriptif("Pays de la Poutine");
		destinationCanada3.addImages("Montreal1.png");
		destinationCanada3.addImages("Montreal2.png");
		destinationMockDAO.create(destinationCanada3);
		VoyageMockDAO voyageMockDAO = new VoyageMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationMockDAO,voyageMockDAO);
		List<Destination> destinationDemandee = new ArrayList<Destination>();
		destinationDemandee = destinationFacade.getDestinationByRegion("Quebec");
		assertEquals("m", "Quebec", destinationDemandee.get(0).getRegion());
		assertEquals("m", "Quebec", destinationDemandee.get(1).getRegion());

	}
//	
//	Test de la fonctionnalite de la methode getDatesVoyages() de la façade
//	-> dans ce test, il y a une destinations mais avec plusieurs dates
//	-> on cree plusieurs destinations que l'on place dans la mock puis on demande à la façade
//	      de renvoyer la liste des dates de voyage d'une destination précise
//	-> cela permet de tester le bon fonctionnement de la methode sur un ensemble de date
	@Test
	public void testN3GetDatesVoyages() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
		DatesVoyages datesVoyage1 = new DatesVoyages();
		Date dateAller1 = new Date();
		dateAller1.setYear(2019);
		dateAller1.setMonth(10);
		dateAller1.setDate(3);
		Date dateRetour1 = new Date();
		dateRetour1.setYear(2019);
		dateRetour1.setMonth(10);
		dateRetour1.setDate(10);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		DatesVoyages datesVoyage2 = new DatesVoyages();
		Date dateAller2 = new Date();
		dateAller2.setYear(2019);
		dateAller2.setMonth(10);
		dateAller2.setDate(3);
		Date dateRetour2 = new Date();
		dateRetour2.setYear(2019);
		dateRetour2.setMonth(10);
		dateRetour2.setDate(10);
		datesVoyage2.setDateAller(dateAller2);
		datesVoyage2.setDateRetour(dateRetour2);
		Destination destinationCanada = new Destination();
		destinationCanada.setRegion("Quebec");
		destinationCanada.setDescriptif("Pays de la Poutine");
		destinationCanada.addImages("Quebec1.png");
		destinationCanada.addImages("Quebec2.png");
		List<DatesVoyages> datesVoyages = new ArrayList<DatesVoyages>();
		datesVoyages.add(datesVoyage1);
		datesVoyages.add(datesVoyage2);
		destinationCanada.setDatesVoyages(datesVoyages);
		destinationMockDAO.create(destinationCanada);
		VoyageMockDAO voyageMockDAO = new VoyageMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationMockDAO,voyageMockDAO);
		List<DatesVoyages> datesVoyagesDisponible = new ArrayList<DatesVoyages>();
		datesVoyagesDisponible = destinationFacade.getDatesVoyages(destinationCanada);
		assertEquals("m", 3, datesVoyagesDisponible.get(0).getDateAller().getDate());
	}
//	
//	Test de la fonctionnalite de la methode getDatesVoyages() de la façade
//	-> dans ce test, il y a plusieurs destinations mais avec plusieurs dates
//	-> on cree plusieurs destinations que l'on place dans la mock puis on demande à la façade
//	      de renvoyer la liste des dates de voyage d'une destination précise
//	-> cela permet de tester le bon fonctionnement de la methode sur un ensemble de destination
	@Test
	public void testN4GetDatesVoyage2() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
//		datesVoyage
		DatesVoyages datesVoyage1 = new DatesVoyages();
		Date dateAller1 = new Date();
		dateAller1.setYear(2019);
		dateAller1.setMonth(10);
		dateAller1.setDate(1);
		Date dateRetour1 = new Date();
		dateRetour1.setYear(2019);
		dateRetour1.setMonth(10);
		dateRetour1.setDate(8);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		DatesVoyages datesVoyage2 = new DatesVoyages();
		Date dateAller2 = new Date();
		dateAller2.setYear(2019);
		dateAller2.setMonth(10);
		dateAller2.setDate(2);
		Date dateRetour2 = new Date();
		dateRetour2.setYear(2019);
		dateRetour2.setMonth(10);
		dateRetour2.setDate(9);
		datesVoyage2.setDateAller(dateAller2);
		datesVoyage2.setDateRetour(dateRetour2);
		DatesVoyages datesVoyage3 = new DatesVoyages();
		Date dateAller3 = new Date();
		dateAller3.setYear(2019);
		dateAller3.setMonth(10);
		dateAller3.setDate(3);
		Date dateRetour3 = new Date();
		dateRetour3.setYear(2019);
		dateRetour3.setMonth(10);
		dateRetour3.setDate(10);
		datesVoyage3.setDateAller(dateAller3);
		datesVoyage3.setDateRetour(dateRetour3);
		DatesVoyages datesVoyage4 = new DatesVoyages();
		Date dateAller4 = new Date();
		dateAller4.setYear(2019);
		dateAller4.setMonth(10);
		dateAller4.setDate(4);
		Date dateRetour4 = new Date();
		dateRetour4.setYear(2019);
		dateRetour4.setMonth(10);
		dateRetour4.setDate(11);
		datesVoyage4.setDateAller(dateAller4);
		datesVoyage4.setDateRetour(dateRetour4);
//		Destination
		List<DatesVoyages> datesVoyages1 = new ArrayList<DatesVoyages>();
		datesVoyages1.add(datesVoyage1);
		datesVoyages1.add(datesVoyage2);
		List<DatesVoyages> datesVoyages2 = new ArrayList<DatesVoyages>();
		datesVoyages2.add(datesVoyage3);
		datesVoyages2.add(datesVoyage4);
		Destination destinationCanada1 = new Destination();
		destinationCanada1.setRegion("Quebec");
		destinationCanada1.setDescriptif("Pays de la Poutine");
		destinationCanada1.addImages("Quebec1.png");
		destinationCanada1.addImages("Quebec2.png");
		destinationCanada1.setDatesVoyages(datesVoyages1);
		destinationMockDAO.create(destinationCanada1);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontario");
		destinationCanada2.setDescriptif("sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationCanada2.setDatesVoyages(datesVoyages2);
		destinationMockDAO.create(destinationCanada2);
		VoyageMockDAO voyageMockDAO = new VoyageMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationMockDAO,voyageMockDAO);
		List<DatesVoyages> datesVoyagesDisponible = new ArrayList<DatesVoyages>();
		datesVoyagesDisponible = destinationFacade.getDatesVoyages(destinationCanada1);
		List<DatesVoyages> datesVoyagesDisponible2 = new ArrayList<DatesVoyages>();
		datesVoyagesDisponible2 = destinationFacade.getDatesVoyages(destinationCanada2);
		assertEquals("m", 1, datesVoyagesDisponible.get(0).getDateAller().getDate());
		assertEquals("m", 2, datesVoyagesDisponible.get(1).getDateAller().getDate());
		assertEquals("m", 3, datesVoyagesDisponible2.get(0).getDateAller().getDate());
		assertEquals("m", 4, datesVoyagesDisponible2.get(1).getDateAller().getDate());
		
	}
//	
//	Test de la fonctionnalite de la methode getAllDestination() de la façade
//	-> dans ce test, il y a plusieurs destinations 
//	-> on cree plusieurs destinations que l'on place dans la mock puis on demande à la façade
//	      de renvoyer la liste des destinations existantes
//	-> cela permet de tester le bon fonctionnement de la methode
	@Test
	public void testN5GetAllDestination() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
//		datesVoyage
		DatesVoyages datesVoyage1 = new DatesVoyages();
		Date dateAller1 = new Date();
		dateAller1.setYear(2019);
		dateAller1.setMonth(10);
		dateAller1.setDate(1);
		Date dateRetour1 = new Date();
		dateRetour1.setYear(2019);
		dateRetour1.setMonth(10);
		dateRetour1.setDate(8);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		DatesVoyages datesVoyage2 = new DatesVoyages();
		Date dateAller2 = new Date();
		dateAller2.setYear(2019);
		dateAller2.setMonth(10);
		dateAller2.setDate(2);
		Date dateRetour2 = new Date();
		dateRetour2.setYear(2019);
		dateRetour2.setMonth(10);
		dateRetour2.setDate(9);
		datesVoyage2.setDateAller(dateAller2);
		datesVoyage2.setDateRetour(dateRetour2);
		DatesVoyages datesVoyage3 = new DatesVoyages();
		Date dateAller3 = new Date();
		dateAller3.setYear(2019);
		dateAller3.setMonth(10);
		dateAller3.setDate(3);
		Date dateRetour3 = new Date();
		dateRetour3.setYear(2019);
		dateRetour3.setMonth(10);
		dateRetour3.setDate(10);
		datesVoyage3.setDateAller(dateAller3);
		datesVoyage3.setDateRetour(dateRetour3);
		DatesVoyages datesVoyage4 = new DatesVoyages();
		Date dateAller4 = new Date();
		dateAller4.setYear(2019);
		dateAller4.setMonth(10);
		dateAller4.setDate(4);
		Date dateRetour4 = new Date();
		dateRetour4.setYear(2019);
		dateRetour4.setMonth(10);
		dateRetour4.setDate(11);
		datesVoyage4.setDateAller(dateAller4);
		datesVoyage4.setDateRetour(dateRetour4);
//		Destination
		List<DatesVoyages> datesVoyages1 = new ArrayList<DatesVoyages>();
		datesVoyages1.add(datesVoyage1);
		datesVoyages1.add(datesVoyage2);
		List<DatesVoyages> datesVoyages2 = new ArrayList<DatesVoyages>();
		datesVoyages2.add(datesVoyage3);
		datesVoyages2.add(datesVoyage4);
		Destination destinationCanada1 = new Destination();
		destinationCanada1.setRegion("Quebec");
		destinationCanada1.setDescriptif("Pays de la Poutine");
		destinationCanada1.addImages("Quebec1.png");
		destinationCanada1.addImages("Quebec2.png");
		destinationCanada1.setDatesVoyages(datesVoyages1);
		destinationMockDAO.create(destinationCanada1);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontarion");
		destinationCanada2.setDescriptif("sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationCanada2.setDatesVoyages(datesVoyages2);
		destinationMockDAO.create(destinationCanada2);
		VoyageMockDAO voyageMockDAO = new VoyageMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationMockDAO,voyageMockDAO);
		List<Destination> destinations = new ArrayList<Destination>();
		destinations = destinationFacade.getAllDestinations();
		destinations.get(0);
		assertEquals("m", "Quebec", destinations.get(0).getRegion());
		assertEquals("m", "Ontarion", destinations.get(1).getRegion());

	}
//	Test de la fonctionnalite de la methode getDatesVoyages(long id) de la façade
//	-> dans ce test, il y a plusieurs destinations 
//	-> on cree plusieurs destinations que l'on place dans la mock puis on demande à la façade
//	      de renvoyer la liste des dates pour l'identifiant de la destination
//	-> cela permet de tester le bon fonctionnement de la methode
	@Test
	public void testN6GetDatesVoyages() {
		DestinationDAO destinationMockDAO = new DestinationMockDAO();
//		datesVoyage
		DatesVoyages datesVoyage1 = new DatesVoyages();
		Date dateAller1 = new Date();
		dateAller1.setYear(2019);
		dateAller1.setMonth(10);
		dateAller1.setDate(1);
		Date dateRetour1 = new Date();
		dateRetour1.setYear(2019);
		dateRetour1.setMonth(10);
		dateRetour1.setDate(8);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		DatesVoyages datesVoyage2 = new DatesVoyages();
		Date dateAller2 = new Date();
		dateAller2.setYear(2019);
		dateAller2.setMonth(10);
		dateAller2.setDate(2);
		Date dateRetour2 = new Date();
		dateRetour2.setYear(2019);
		dateRetour2.setMonth(10);
		dateRetour2.setDate(9);
		datesVoyage2.setDateAller(dateAller2);
		datesVoyage2.setDateRetour(dateRetour2);
		DatesVoyages datesVoyage3 = new DatesVoyages();
		Date dateAller3 = new Date();
		dateAller3.setYear(2019);
		dateAller3.setMonth(10);
		dateAller3.setDate(3);
		Date dateRetour3 = new Date();
		dateRetour3.setYear(2019);
		dateRetour3.setMonth(10);
		dateRetour3.setDate(10);
		datesVoyage3.setDateAller(dateAller3);
		datesVoyage3.setDateRetour(dateRetour3);
		DatesVoyages datesVoyage4 = new DatesVoyages();
		Date dateAller4 = new Date();
		dateAller4.setYear(2019);
		dateAller4.setMonth(10);
		dateAller4.setDate(4);
		Date dateRetour4 = new Date();
		dateRetour4.setYear(2019);
		dateRetour4.setMonth(10);
		dateRetour4.setDate(11);
		datesVoyage4.setDateAller(dateAller4);
		datesVoyage4.setDateRetour(dateRetour4);
//		Destination
		List<DatesVoyages> datesVoyages1 = new ArrayList<DatesVoyages>();
		datesVoyages1.add(datesVoyage1);
		datesVoyages1.add(datesVoyage2);
		List<DatesVoyages> datesVoyages2 = new ArrayList<DatesVoyages>();
		datesVoyages2.add(datesVoyage3);
		datesVoyages2.add(datesVoyage4);
		Destination destinationCanada1 = new Destination();
		destinationCanada1.setRegion("Quebec");
		destinationCanada1.setDescriptif("Pays de la Poutine");
		destinationCanada1.addImages("Quebec1.png");
		destinationCanada1.addImages("Quebec2.png");
		destinationCanada1.setDatesVoyages(datesVoyages1);
		destinationMockDAO.create(destinationCanada1);
		Destination destinationCanada2 = new Destination();
		destinationCanada2.setRegion("Ontarion");
		destinationCanada2.setDescriptif("sous-anglais");
		destinationCanada2.addImages("Toronto1.png");
		destinationCanada2.addImages("Toronto2.png");
		destinationCanada2.setDatesVoyages(datesVoyages2);
		destinationMockDAO.create(destinationCanada2);
		VoyageMockDAO voyageMockDAO = new VoyageMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationMockDAO,voyageMockDAO);
		List<DatesVoyages> datesVoyage = new ArrayList<DatesVoyages>();
		datesVoyage = destinationFacade.getDatesVoyages(1);
		assertEquals("m", 1, datesVoyage.get(0).getDateAller().getDate());
		List<DatesVoyages> datesVoyag2 = new ArrayList<DatesVoyages>();
		datesVoyag2 = destinationFacade.getDatesVoyages(2);
		assertEquals("m", 3, datesVoyag2.get(0).getDateAller().getDate());
	}
}

