package fr.diamante.stat;

import java.util.ArrayList;

public class UtilStat {
	/**
	 * La classe UtilStat est un utilitaire de gestion de statistique.
	 */
	
	//Constructeur
	public UtilStat() {}
	
	//Corps
	public static double moyenneArith(ArrayList<Double> liste) {
		//{ArrayList<Double>} -> {Retourne la moyenne arithmétique des valeurs l'argument}
		double moyenne = 0.0;
		for(int i = 0; i < liste.size(); i++) {
			moyenne += liste.get(i);
		}
		moyenne /= liste.size();
		return moyenne;
		
	}
	
	public static double moyenneGeom(ArrayList<Double> liste){
		//{ArrayList<Double>} -> {Retourne la moyenne géométrique des valeurs l'argument}
		double moyenne = 1.0;
		for(int i = 0; i < liste.size(); i++) {
			moyenne *= liste.get(i);
		}
		return Math.pow(moyenne, 1.0/liste.size());
	}
	
}
