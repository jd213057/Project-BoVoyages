package fr.gtm.hello;

public class Exercice {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 0;
		
		calcule(a, b, c);
//		System.out.println("Le résultat de l\'équation est ")
	}
	public static void calcule(int a, int b, int c) {
		double eq = b*b - 4 * a * c;
		
		if (eq < 0) {
			System.out.println("Cette équation n'a pas de solution réelle.");
			return;
		}
		else if (eq == 0) {
			double r = -b/(2*a);
			System.out.println("Cette équation possède une solution double x = -(b/2*a) : "+r);
			return;
		}
		else
			System.out.println("Il y a deux solutions réelles et distinctes");
			System.out.println("\t"+((-b-Math.sqrt(eq))/2*a));
			System.out.println("\t"+((-b+Math.sqrt(eq))/2*a));

//		System.out.println(eq);
	}

}
