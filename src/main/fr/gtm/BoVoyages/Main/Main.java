package fr.gtm.BoVoyages.Main;

import fr.gtm.BoVoyages.DestinationFacade.DestinationsFacade;
//
import fr.gtm.BoVoyages.Entities.Destination;
import fr.gtm.BoVoyages.Entities.DatesVoyages;
//
import fr.gtm.BoVoyages.DestinationDAO.DestinationDAO;
import fr.gtm.BoVoyages.DestinationDAO.DestinationMockDAO;
//
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args)  throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		DestinationDAO destinationDAO = new DestinationMockDAO();
		DestinationsFacade destinationFacade = new DestinationsFacade(destinationDAO); 


		   String fileName = "BoVoyageDate.txt";
		   Destination destinationUtilisateur;
		   int id;
		   String region;
		   String descriptif;
		   List<String> images = new ArrayList<String>();
		   List<DatesVoyages> datesVoyages;
		   DatesVoyages datesVoyage = new DatesVoyages();
		   Date dateAller = new Date();
		   Date dateRetour = new Date();
		   try {
		      BufferedReader  br = new BufferedReader(new FileReader(fileName));
			   
			   String line  = br.readLine();
			   String[] fields;
			   while(line != null) {
				   fields = line.split(";");
				   id = Integer.parseInt(fields[0]);
				   region = fields[1];
				   descriptif = fields[2];
				   for(int i = 3 ; i<fields.length; i++) {
					   images.add(fields[i]);
				   }
				   line = br.readLine();
				   fields = line.split(";");
				   datesVoyages = new ArrayList<DatesVoyages>();
				   for(int i = 0 ; i<fields.length; i += 6) {
					   dateAller.setDate(Integer.parseInt(fields[i]));
					   dateAller.setMonth(Integer.parseInt(fields[i+1]));
					   dateAller.setYear(Integer.parseInt(fields[i+2]));
					   dateRetour.setDate(Integer.parseInt(fields[i+3]));
					   dateRetour.setMonth(Integer.parseInt(fields[i+4]));
					   dateRetour.setYear(Integer.parseInt(fields[i+5]));
					   datesVoyage.setDateAller(dateAller);
					   datesVoyage.setDateRetour(dateRetour);
					   datesVoyages.add(datesVoyage);
				   }
				   destinationDAO.create(new Destination(id, region, descriptif, images, datesVoyages));
				   line = br.readLine();
		   }
			   br.close();
		   }
		   catch (IOException e) {
			   e.printStackTrace();
			   System.out.println("Pas de fichier " + fileName);
		   }
		
	    BufferedReader  saisieUtilisateur = new BufferedReader(new InputStreamReader(System.in));
		boolean onContinue = true;
		
		List<Destination> destinations = new ArrayList<Destination>();
		
		while(onContinue) {
		System.out.println("Bonjour");
		System.out.println("Entrer le numero correspondant à l'action que vous souhaitez réaliser");
		System.out.println("1 : Afficher les destinations");
		System.out.println("2 : Choisir une destination suivant la région");
		System.out.println("3 : Ajouter une destination");
		System.out.println("q : quitter");
		String choix = saisieUtilisateur.readLine();
		switch(choix){
		case "1" : 
			System.out.println("");
			System.out.println("Voici les destinations disponibles");
			destinations = new ArrayList<Destination>();
			destinations = destinationFacade.getAllDestinations();
			for(Destination destination : destinations){
				System.out.println("" + destination.getRegion() + " " + destination.getDatesVoyages().size() + " dates" );
			}
			System.out.println("");
			System.out.println("Entrer n'importe quel caractère pour revenir au menu principal");
			choix = saisieUtilisateur.readLine();
			for(int i = 0 ; i<20 ; i++) {
				System.out.println("");
			}
			break;

		case "2" : 
			System.out.println("");
			System.out.println("Entrer la région que vous souhaitez visiter");
			region = saisieUtilisateur.readLine();
			System.out.println(" ");
			System.out.println("Voici les dates disponibles pour la destination " + region);
			destinations = new ArrayList<Destination>();
			destinations = destinationFacade.getDestinationByRegion(region);
			System.out.println(destinations);
			datesVoyages = new ArrayList<DatesVoyages>();
			for(int i = 0 ; i<destinations.size(); i++) {
				datesVoyages = destinations.get(i).getDatesVoyages();
				for(int j = 0 ; j<datesVoyages.size(); j++) {
					System.out.println("" + datesVoyages.get(j).getDateAller().toString());
				}
			}
			System.out.println("");
			System.out.println("Entrer n'importe quel caractère pour revenir au menu principal");
			choix = saisieUtilisateur.readLine();
			for(int i = 0 ; i<20 ; i++) {
				System.out.println("");
			}
			break;

		case "3" : 
			System.out.println("");
			destinationUtilisateur = new Destination();
			System.out.println("Entrer une region");
			destinationUtilisateur.setRegion(saisieUtilisateur.readLine());
			System.out.println("");
			System.out.println("Entrer un descriptif");
			destinationUtilisateur.setDescriptif(saisieUtilisateur.readLine());
			System.out.println("");
			destinationDAO.create(destinationUtilisateur);
			System.out.println("Votre destination a bien été ajoutée");
			System.out.println("Entrer n'importe quel caractère pour revenir au menu principal");
			System.out.println("");
			choix = saisieUtilisateur.readLine();
			
			break;

		case "q" : 
			onContinue = false;
			break;
		
		}
		}
		System.out.println("");
		System.out.println("A bientôt");
		saisieUtilisateur.close();
	}

}
