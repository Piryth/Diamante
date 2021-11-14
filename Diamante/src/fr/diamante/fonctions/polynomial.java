package fr.diamante.fonctions;

import java.lang.Math;
import java.util.Scanner;

public class polynomial {

    public static void main(String[] args) {
        polynome();
    }

    public static void saisieRoots() {
        /*
        Author : Sébastien RUET
        Méthode de saisie pour la méthode Polynomial.roots()
        */

        // Déclaration des variables
        float a, b, c;
        Scanner lecteur = new Scanner(System.in);
        
        // Saisie
        System.out.println("Polynôme du second degré du type 'aX² + bX + c' :");
        
        System.out.print("  Valeur de a : ");
        a = lecteur.nextFloat();
        lecteur.nextLine();

        System.out.print("  Valeur de b : ");
        b = lecteur.nextFloat();
        lecteur.nextLine();

        System.out.print("  Valeur de c : ");
        c = lecteur.nextFloat();
        lecteur.nextLine();

        System.out.println("");
        
        // Calcul des racines
        Polynomial.roots(a, b, c);

        // Fermeture du Scanner lecteur
        lecteur.close();
    }

    public static void roots(float a, float b, float c) {
        /*
        Author : Sébastien RUET
        Méthode de calcul des racines d'un polynôme du second degré
        */
        
        // Déclaration des variables
        float delta = (b*b)-(4*a*c);

        // Détermination du nb de racines
        if (delta > 0) {
            System.out.println("Nombre de racines : 2");
            System.out.println("Racine 1 : " + (-b-Math.sqrt(delta))/(2*a));
            System.out.println("Racine 2 : " + (-b+Math.sqrt(delta))/(2*a));
        } else {
            if (delta == 0) {
                System.out.println("Nombre de racines : 1");
                System.out.println("Racine : " + (-b)/(2*a));
            } else {
                System.out.println("Nombre de racines : 0");
            }
        }
    }
}
