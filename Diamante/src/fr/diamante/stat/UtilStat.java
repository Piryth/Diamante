package fr.diamante.stat;

public class UtilStat {
	/**
	 * La classe UtilStat est un utilitaire de gestion de statistique.
	 */
	
	//Constructeur
	public UtilStat() {}
	
	//Corps
	public static double moyenneArith(double[] liste) {
		double moyenne = 0.0;
		for(int i = 0; i < liste.length; i++) {
			moyenne += liste[i];
		}
		moyenne /= liste.length;
		return moyenne;
		
	}
	
}
