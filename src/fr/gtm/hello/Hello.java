package fr.gtm.hello;

public class Hello {

	public static void main(String[] args) {
		int[] tab = {5,8,56,1,0,9,78,20,-5};
		
		for(int i=0; i<tab.length; i++) {
			System.out.println(i + " : " + tab[i]);
		}
		
		//on peut également écrire un raccourci type foreach:	
		for(int elt : tab) {
			System.out.println(elt);
		}
		
		int nb = 10;
		int sum = sommeNPremierNombres(nb);
		System.out.println("Somme des "+ nb +" premiers nombres :"+sum);
		
		
		int min = min(tab);
		System.out.println("minimum : " +min);
		
		int max = max(tab);
		System.out.println("minimum : " +max);
		
		double moy = moyenne(tab);
		System.out.println("moyenne : " +moy);

	}
	

	private static int sommeNPremierNombres(int nb) {
//		int somme = 0;
//		for(int i=0; i<= nb; i++) {
//			somme = somme + i;
//		}
		return nb*(++nb)/2; //++nb même chose que nb+1 : ici on incrémente avant !
//		return somme;
	}


	private static int min(int[] tab) {
		int maxVal = Integer.MAX_VALUE; //ou int min = tab[0];
	    int i = 0;
	    
		do {
			if(tab[i] < maxVal) {
				maxVal = tab[i];				
			}
			i++;
		}
		while(i<tab.length);

		return maxVal;
	}
	
	private static int max(int[] tab) {
	    int minVal = Integer.MIN_VALUE; 
	    int i = 0;
		while(i<tab.length) {
			if(tab[i] > minVal) {
				minVal = tab[i];
			}
			i++;
		}
		return minVal;
	}

	private static double moyenne(int[] tab) {
		double somme= 0;
		
		for(int i=0; i<tab.length; i++) {
			somme = somme + tab[i];
		}
		
		//mais également avec la boucle foreach :
//		for(int elt : tab) {
//			somme = somme + elt;
//		}
		
		return somme / tab.length;
	}
	
}
