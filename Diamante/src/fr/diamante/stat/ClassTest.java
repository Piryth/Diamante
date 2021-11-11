package fr.diamante.stat;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> liste = new ArrayList<>(Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0));
		double moyAr, moyGe;
		moyAr = UtilStat.moyenneArith(liste);
		moyGe = UtilStat.moyenneGeom(liste);
		System.out.println("Moyenne arithmétique : " + moyAr);
		System.out.println("Moyenne géométrique : " + moyGe);
		
		}

}
