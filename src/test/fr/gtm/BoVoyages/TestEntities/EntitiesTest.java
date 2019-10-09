package fr.gtm.BoVoyages.TestEntities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import fr.gtm.BoVoyages.Entities.Client;
import fr.gtm.BoVoyages.Entities.Voyageur;
import fr.gtm.BoVoyages.Entities.Voyage;
import fr.gtm.BoVoyages.Entities.DatesVoyages;
import fr.gtm.BoVoyages.Entities.Destination;

public class EntitiesTest {
	
	@Test
	public void testN1ObjetVoyageur() {
		Voyageur voyageur = new Voyageur();
		Date dateNaissance = new Date();
		dateNaissance.setDate(1);
		dateNaissance.setMonth(1);
		dateNaissance.setYear(1991);
		voyageur.setDateDeNaissance(dateNaissance);
		voyageur.setCivilite("Mme");
		voyageur.setNom("Tac");
		voyageur.setPrenom("Tuc");
		voyageur.setId(1);
		Date dateNaissance2 = new Date();
		dateNaissance2.setDate(2);
		dateNaissance2.setMonth(2);
		dateNaissance2.setYear(1992);
		Voyageur voyageur1 = new Voyageur(dateNaissance2,"M","Tic","Toc");
		Voyageur voyageur2 = new Voyageur(dateNaissance2,"M","Tic","Toc",2);
		assertEquals("m", 1, voyageur.getDateDeNaissance().getDate());
		assertEquals("m", 1, voyageur.getDateDeNaissance().getMonth());
		assertEquals("m", 1991, voyageur.getDateDeNaissance().getYear());
		assertEquals("m", "Mme", voyageur.getCivilite());
		assertEquals("m", "Tac", voyageur.getNom());
		assertEquals("m", "Tuc", voyageur.getPrenom());
		assertEquals("m", 1, voyageur.getId());
		assertEquals("m", 2, voyageur1.getDateDeNaissance().getDate());
		assertEquals("m", 2, voyageur1.getDateDeNaissance().getMonth());
		assertEquals("m", 1992, voyageur1.getDateDeNaissance().getYear());
		assertEquals("m", "M", voyageur1.getCivilite());
		assertEquals("m", "Tic", voyageur1.getNom());
		assertEquals("m", "Toc", voyageur1.getPrenom());
		assertEquals("m", 2, voyageur2.getId());

	}
	
	@Test
	public void testN2ObjetDatesVoyage() {
		DatesVoyages datesVoyage1 = new DatesVoyages();
		Date dateAller1 = new Date();
		dateAller1.setDate(1);
		dateAller1.setMonth(1);
		dateAller1.setYear(1991);
		Date dateRetour1 = new Date();
		dateRetour1.setDate(2);
		dateRetour1.setMonth(2);
		dateRetour1.setYear(1992);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		datesVoyage1.setTarifUnitaireHT(50.5);
		datesVoyage1.setId(1);
		assertEquals("m", 1, datesVoyage1.getDateAller().getDate());
		assertEquals("m", 1, datesVoyage1.getDateAller().getMonth());
		assertEquals("m", 1991, datesVoyage1.getDateAller().getYear());
		assertEquals("m", 2, datesVoyage1.getDateRetour().getDate());
		assertEquals("m", 2, datesVoyage1.getDateRetour().getMonth());
		assertEquals("m", 1992, datesVoyage1.getDateRetour().getYear());
		assertEquals(50.5, datesVoyage1.getTarifUnitaireHT(), 0);
		assertEquals("m", 1, datesVoyage1.getId());
		Date dateAller2 = new Date();
		dateAller2.setDate(3);
		dateAller2.setMonth(3);
		dateAller2.setYear(1993);
		Date dateRetour2 = new Date();
		dateRetour2.setDate(4);
		dateRetour2.setMonth(4);
		dateRetour2.setYear(1994);
		DatesVoyages datesVoyage2 = new DatesVoyages(dateAller2,dateRetour2);
		assertEquals("m", 3, datesVoyage2.getDateAller().getDate());
		assertEquals("m", 3, datesVoyage2.getDateAller().getMonth());
		assertEquals("m", 1993, datesVoyage2.getDateAller().getYear());
		assertEquals("m", 4, datesVoyage2.getDateRetour().getDate());
		assertEquals("m", 4, datesVoyage2.getDateRetour().getMonth());
		assertEquals("m", 1994, datesVoyage2.getDateRetour().getYear());
		DatesVoyages datesVoyage3 = new DatesVoyages(dateAller2,dateRetour2,37.2);
		assertEquals(37.2, datesVoyage3.getTarifUnitaireHT(), 0);
		DatesVoyages datesVoyage4 = new DatesVoyages(dateAller2,dateRetour2,37.2,2);
		assertEquals("m", 2, datesVoyage4.getId());
		
		
	}
	
	@Test
	public void testN3ObjetClient() {
		Client client1 = new Client();
		client1.setNom("Tic");
		client1.setId(1);
		assertEquals("m", "Tic", client1.getNom());
		assertEquals("m", 1, client1.getId());
		Client client2 = new Client("Tac");
		assertEquals("m", "Tac", client2.getNom());
		Client client3 = new Client(2);
		assertEquals("m", 2, client3.getId());
		Client client4 = new Client("Toc",3);
		assertEquals("m", "Toc", client4.getNom());
		assertEquals("m", 3, client4.getId());
		
	}
	
	@Test
	public void testN4ObjetVoyage() {
		Voyage voyage = new Voyage();
		DatesVoyages datesVoyage = new DatesVoyages();
		Date dateAller = new Date();
		dateAller.setDate(1);
		dateAller.setMonth(1);
		dateAller.setYear(1991);
		Date dateRetour = new Date();
		dateRetour.setDate(2);
		dateRetour.setMonth(2);
		dateRetour.setYear(1992);
		datesVoyage.setDateAller(dateAller);
		datesVoyage.setDateRetour(dateRetour);
		voyage.setDatesVoyages(datesVoyage);
		voyage.setRegion("Quebec");
		voyage.setDescriptif("Pays de la poutine");
		voyage.setId(1);
		assertEquals("m", 1, voyage.getDatesVoyages().getDateAller().getDate());
		assertEquals("m", 1, voyage.getDatesVoyages().getDateAller().getMonth());
		assertEquals("m", 1991, voyage.getDatesVoyages().getDateAller().getYear());
		assertEquals("m", 2, voyage.getDatesVoyages().getDateRetour().getDate());
		assertEquals("m", 2, voyage.getDatesVoyages().getDateRetour().getMonth());
		assertEquals("m", 1992, voyage.getDatesVoyages().getDateRetour().getYear());
		DatesVoyages datesVoyage2 = new DatesVoyages();
		Date dateAller2 = new Date();
		dateAller2.setDate(3);
		dateAller2.setMonth(3);
		dateAller2.setYear(1993);
		Date dateRetour2 = new Date();
		dateRetour2.setDate(4);
		dateRetour2.setMonth(4);
		dateRetour2.setYear(1994);
		datesVoyage2.setDateAller(dateAller2);
		datesVoyage2.setDateRetour(dateRetour2);
		Voyage voyage2 = new Voyage(datesVoyage2, "Ontario", "sous-anglais");
		assertEquals("m", 3, voyage2.getDatesVoyages().getDateAller().getDate());
		assertEquals("m", 3, voyage2.getDatesVoyages().getDateAller().getMonth());
		assertEquals("m", 1993, voyage2.getDatesVoyages().getDateAller().getYear());
		assertEquals("m", 4, voyage2.getDatesVoyages().getDateRetour().getDate());
		assertEquals("m", 4, voyage2.getDatesVoyages().getDateRetour().getMonth());
		assertEquals("m", 1994, voyage2.getDatesVoyages().getDateRetour().getYear());
		Date dateNaissance1 = new Date();
		dateNaissance1.setDate(1);
		dateNaissance1.setMonth(1);
		dateNaissance1.setYear(1991);
		Date dateNaissance2 = new Date();
		dateNaissance2.setDate(2);
		dateNaissance2.setMonth(2);
		dateNaissance2.setYear(1992);
		Voyageur voyageur1 = new Voyageur(dateNaissance1,"M","Tic","Toc");
		Voyageur voyageur2 = new Voyageur(dateNaissance2,"Mme","Tac","Tuc");
		List<Voyageur> voyageurs = new ArrayList<Voyageur>();
		voyageurs.add(voyageur1);
		voyageurs.add(voyageur2);
		Voyage voyage3 = new Voyage(voyageurs, datesVoyage2, "Ontario", "sous-anglais");
		assertEquals("m", "M", voyage3.getVoyageurs().get(0).getCivilite());
		assertEquals("m", "Mme", voyage3.getVoyageurs().get(1).getCivilite());
		Client client = new Client("Tac");
		Voyage voyage4 = new Voyage(client, datesVoyage2, "Ontario", "sous-anglais");
		assertEquals("m", "Tac", client.getNom());
		assertEquals("m", "M", voyage3.getVoyageurs().get(0).getCivilite());
		assertEquals("m", "Mme", voyage3.getVoyageurs().get(1).getCivilite());
		
	}
	
	@Test
	public void testN5ObjetDestination() {
		Destination destination1 = new Destination();
		destination1.setRegion("Quebec");
		destination1.setDescriptif("Pays de la poutine");
		destination1.addImages("Quebec1.png");
		destination1.addImages("Quebec2.png");
		destination1.setId(1);
		DatesVoyages datesVoyage1 = new DatesVoyages();
		Date dateAller1 = new Date();
		dateAller1.setDate(1);
		dateAller1.setMonth(1);
		dateAller1.setYear(1991);
		Date dateRetour1 = new Date();
		dateRetour1.setDate(2);
		dateRetour1.setMonth(2);
		dateRetour1.setYear(1992);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		DatesVoyages datesVoyage2 = new DatesVoyages();
		Date dateAller2 = new Date();
		dateAller2.setDate(3);
		dateAller2.setMonth(3);
		dateAller2.setYear(1993);
		Date dateRetour2 = new Date();
		dateRetour2.setDate(4);
		dateRetour2.setMonth(4);
		dateRetour2.setYear(1994);
		datesVoyage1.setDateAller(dateAller1);
		datesVoyage1.setDateRetour(dateRetour1);
		datesVoyage2.setDateAller(dateAller2);
		datesVoyage2.setDateRetour(dateRetour2);
		List<DatesVoyages> datesVoyages = new ArrayList<DatesVoyages>();
		datesVoyages.add(datesVoyage1);
		datesVoyages.add(datesVoyage2);
		destination1.setDatesVoyages(datesVoyages);
		assertEquals("m", "Quebec", destination1.getRegion());
		assertEquals("m", "Pays de la poutine", destination1.getDescriptif());
		assertEquals("m", "Quebec1.png", destination1.getImages().get(0));
		assertEquals("m", "Quebec2.png", destination1.getImages().get(1));
		assertEquals("m", 1, destination1.getId());
		assertEquals("m", 1, destination1.getDatesVoyages().get(0).getDateAller().getDate());
		assertEquals("m", 1, destination1.getDatesVoyages().get(0).getDateAller().getMonth());
		assertEquals("m", 1991, destination1.getDatesVoyages().get(0).getDateAller().getYear());
		assertEquals("m", 2, destination1.getDatesVoyages().get(0).getDateRetour().getDate());
		assertEquals("m", 2, destination1.getDatesVoyages().get(0).getDateRetour().getMonth());
		assertEquals("m", 1992, destination1.getDatesVoyages().get(0).getDateRetour().getYear());
		assertEquals("m", 3, destination1.getDatesVoyages().get(1).getDateAller().getDate());
		assertEquals("m", 3, destination1.getDatesVoyages().get(1).getDateAller().getMonth());
		assertEquals("m", 1993, destination1.getDatesVoyages().get(1).getDateAller().getYear());
		assertEquals("m", 4, destination1.getDatesVoyages().get(1).getDateRetour().getDate());
		assertEquals("m", 4, destination1.getDatesVoyages().get(1).getDateRetour().getMonth());
		assertEquals("m", 1994, destination1.getDatesVoyages().get(1).getDateRetour().getYear());
//		
		List<String> images = new ArrayList<String>();
		images.add("Montreal1.png");
		images.add("Montreal2.png");
		Destination destination2 = new Destination("Montreal","Pays de la poutine",images);
		assertEquals("m", "Montreal", destination2.getRegion());
		assertEquals("m", "Pays de la poutine", destination2.getDescriptif());
		assertEquals("m", "Montreal1.png", destination2.getImages().get(0));
		assertEquals("m", "Montreal2.png", destination2.getImages().get(1));
//		
		Destination destination3 = new Destination("Montreal","Pays de la poutine",images,datesVoyages);
		assertEquals("m", 1, destination3.getDatesVoyages().get(0).getDateAller().getDate());
		assertEquals("m", 1, destination3.getDatesVoyages().get(0).getDateAller().getMonth());
		assertEquals("m", 1991, destination3.getDatesVoyages().get(0).getDateAller().getYear());
		assertEquals("m", 2, destination3.getDatesVoyages().get(0).getDateRetour().getDate());
		assertEquals("m", 2, destination3.getDatesVoyages().get(0).getDateRetour().getMonth());
		assertEquals("m", 1992, destination3.getDatesVoyages().get(0).getDateRetour().getYear());
		assertEquals("m", 3, destination3.getDatesVoyages().get(1).getDateAller().getDate());
		assertEquals("m", 3, destination3.getDatesVoyages().get(1).getDateAller().getMonth());
		assertEquals("m", 1993, destination3.getDatesVoyages().get(1).getDateAller().getYear());
		assertEquals("m", 4, destination3.getDatesVoyages().get(1).getDateRetour().getDate());
		assertEquals("m", 4, destination3.getDatesVoyages().get(1).getDateRetour().getMonth());
		assertEquals("m", 1994, destination3.getDatesVoyages().get(1).getDateRetour().getYear());
//		
		Destination destination4 = new Destination(2,"Montreal","Pays de la poutine",images);
		assertEquals("m", 2, destination4.getId());
//		
		Destination destination5 = new Destination(3,"Montreal","Pays de la poutine",images,datesVoyages);
		assertEquals("m", 3, destination5.getId());
		
	}

}
