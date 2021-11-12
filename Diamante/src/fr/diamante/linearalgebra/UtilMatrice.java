package fr.diamante.linearalgebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class UtilMatrice {
	/**
	 * La classe UtilMatrice définit les opérations matricielles usuelles. Elle travaille avec la classe Matrice.
	 * 
	 * @author Mélian
	 * 
	 */
	
	
	//fonction arrondi type float au centième	
    public static float arrondi2(float unFloat) {
        //{} => {résultat = valeur de unFloat arrondie à deux décimales}
        return (float) Math.round(100 * unFloat) / 100.0f;
    }

    //fonction création matrice
    public static Matrice createMatrice(){
        //{} => {matrice de dimensions dimY, dimX ayant ses coefficients saisis par l'utilisateur}
        System.out.println("───────────────────────────────────────────");
        System.out.println("Création d'une nouvelle matrice :");

        //déclaration et initialisation lecteur
        Scanner lecteur = new Scanner(System.in);

        //déclaration et initialisation variables dimensions matrice
        System.out.print("Saisie dimension Y : ");
        int dimY = lecteur.nextInt(); lecteur.nextLine();
        System.out.print("Saisie dimension X : ");
        int dimX = lecteur.nextInt(); lecteur.nextLine();

        //déclaration tableau des coefficients
        ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(dimY);

        //déclaration ligne coefficients (sera utilisé pour chaque ligne du tableau des coefficients)
        ArrayList<Float> ligneCoeff;

        //saisie des coefficients par l'utilisateur
        for (int y = 0; y < dimY; y++){
            //saisie d'une ligne de coefficients, ajout de cette ligne au tableau des coefficients
            ligneCoeff = new ArrayList<Float>(dimX);
            System.out.println("Saisie des coefficients de la ligne " + (y+1) + ".");
            for (int x = 0; x < dimX; x++){
                System.out.print("(" + (y+1) + ", " + (x+1) + ") = ");
                ligneCoeff.add(lecteur.nextFloat());
                lecteur.nextLine();
            }
            tableauCoeff.add(ligneCoeff);
        }
        System.out.println();
        System.out.println("Saisie complète.");
        System.out.println("───────────────────────────────────────────");
        lecteur.close();
        return new Matrice(dimY, dimX, tableauCoeff);
    }

    //procédure affichage d'une matrice
    public static void showMatrice(Matrice maMatrice){
        //{} => {affichage de la matrice}
        System.out.println("───────────────────────────────────────");
        //parcours complet des lignes du tableau
        for (int y = 0; y < maMatrice.getDimY(); y++){
            //parcours complet des colonnes du tableau (dans une même ligne)
            for (int x = 0; x < maMatrice.getDimX(); x++) {
                //si c'est le premier coefficient de la première ligne, on rajoute ┌ au début,
                //sinon si c'est le premier coefficient de la dernière ligne, on rajoute └ au début,
                //sinon si c'est le premier coefficient d'une ligne on rajoute │ au début
                if (y == 0 & x == 0) {
                    System.out.print("┌ ");
                } else if (y == maMatrice.getDimY() - 1 & x == 0) {
                    System.out.print("└ ");
                } else if (x == 0){
                    System.out.print("│ ");
                }
                //affichage d'un coefficient
                System.out.print(arrondi2(maMatrice.getCoeff(y, x)));

                //rajouter un espace après le coefficient si ce n'est pas le dernier de la ligne
                if (x != maMatrice.getDimX()-1){
                    System.out.print("  ");
                }

                //si c'est le dernier coefficient de la première ligne, on rajoute ┐ à la fin,
                //sinon si c'est le dernier coefficient de la dernière ligne, on rajoute ┘ au à la fin,
                //sinon si c'est le dernier coefficient d'une ligne on rajoute │ à la fin
                if (y == 0 & x == maMatrice.getDimX()-1) {
                    System.out.print(" ┐");
                } else if (y == maMatrice.getDimY() - 1 & x == maMatrice.getDimX()-1) {
                    System.out.print(" ┘");
                } else if (x == maMatrice.getDimX()-1){
                    System.out.print(" │");
                }
            }
            System.out.println();
        }
    }

    //fonction ajout de deux matrices
    public static Matrice addMatrice(Matrice m1, Matrice m2){
        //{deux matrices de dimensions égales} => {matrice somme des deux matrices}

        //vérification compatibilité des dimensions
        if ( (m1.getDimX() != m2.getDimX()) | (m1.getDimY() != m2.getDimY()) ){
            //retour matrice vide
            System.out.println("Dimensions incompatibles pour l'addition.");
            ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(0);
            return new Matrice(0, 0 , tableauCoeff);
        }

        //déclaration tableau des coefficients de la matrice somme
        ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(m1.getDimY());
        //déclaration ligne coefficients (sera utilisé pour chaque ligne du tableau des coefficients)
        ArrayList<Float> ligneCoeff;

        //parcours complet de chaque ligne des matrices
        for (int y = 0; y < m1.getDimY(); y++) {
            ligneCoeff = new ArrayList<Float>(m1.getDimX());
            //parcours complet de chaque colonne des matrices (pour chaque ligne)
            for (int x = 0; x < m2.getDimX(); x++) {
                //ajout du coefficient somme à la ligne de coefficients du tableau
                ligneCoeff.add(m1.getCoeff(y, x) + m2.getCoeff(y, x));
            }
            tableauCoeff.add(ligneCoeff);
        }
        return new Matrice(m1.getDimY(), m1.getDimX(), tableauCoeff);
    }

    
    //fonction multiplication matrice par un réel
    public static Matrice actualMultipl(Matrice m, float real){
        //{} => {matrice m multipliée par le réel real}

        //déclaration tableau des coefficients de la matrice somme
        ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(m.getDimY());
        //déclaration ligne coefficients (sera utilisé pour chaque ligne du tableau des coefficients)
        ArrayList<Float> ligneCoeff;

        //parcours complet des lignes de la matrice
        for (int y = 0; y < m.getDimY(); y++) {
            ligneCoeff = new ArrayList<Float>(m.getDimX());
            //parcours complet des colonnes de la matrice (dans une même ligne)
            for (int x = 0; x < m.getDimX(); x++) {
                //ajout du coefficient multiple à la ligne de coefficients du tableau
                ligneCoeff.add(m.getCoeff(y, x) * real);
            }
            tableauCoeff.add(ligneCoeff);
        }
        return new Matrice(m.getDimY(), m.getDimX(), tableauCoeff);
    }

    
    //fonction multiplication de deux matrices
    public static Matrice matriceMultipl(Matrice m1, Matrice m2){
        //{deux matrices dont la dimension X de m1 équivaut à la dimension Y de m2} => {multiplication de ces matrices}

        //vérification compatibilité des matrices pour multiplication
        if (m1.getDimX() != m2.getDimY()){
            //retour matrice vide
            System.out.println("Dimensions incompatibles pour la multiplication.");
            ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(0);
            return new Matrice(0, 0 , tableauCoeff);
        }

        //déclaration tableau des coefficients de la matrice multiplication
        ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(m1.getDimY());
        //déclaration ligne coefficients (sera utilisé pour chaque ligne du tableau des coefficients)
        ArrayList<Float> ligneCoeff;

        float newCoeff;

        //parcours complet de chaque ligne des matrices
        for (int y = 0; y < m1.getDimY(); y++) {
            ligneCoeff = new ArrayList<Float>(m2.getDimX());
            //parcours complet de chaque colonne des matrices (pour chaque ligne)
            for (int x = 0; x < m2.getDimX(); x++) {
                newCoeff = 0;
                //détermination de chaque coefficient de la matrice résultat (formule C(i,j) = ΣA(i,k)*B(k,j))
                for (int k = 0; k < m1.getDimX(); k++){
                    newCoeff += m1.getCoeff(y, k) * m2.getCoeff(k, x);
                }
                ligneCoeff.add(newCoeff);
            }
            tableauCoeff.add(ligneCoeff);
        }
        return new Matrice(m1.getDimY(), m2.getDimX(), tableauCoeff);
    }

    
    //fonction puissance d'une matrice
    public static Matrice powMatrice(Matrice m, int pow){
        //{matrice carrée, entier strictement positif} => {matrice de la matrice donnée à la puissance pow}

        //vérification compatibilité matrice avec la mise à la puissance
        if (m.getDimX() != m.getDimY()){
            //retour matrice vide
            System.out.println("Dimensions incompatibles pour la mise à la puissance");
            ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(0);
            return new Matrice(0, 0 , tableauCoeff);
        }
        //vérification pow = entier strictement positif
        if (pow <= 0){
            //retour matrice vide
            System.out.println("Puissance invalide.");
            ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(0);
            return new Matrice(0, 0 , tableauCoeff);
        }

        Matrice matriceUtile = m;

        //multiplication pow-1 fois de la matrice de départ par elle-même
        for (int i = 1; i < pow; i++) {
            matriceUtile = matriceMultipl(matriceUtile, m);
        }

        return new Matrice(matriceUtile.getDimY(), matriceUtile.getDimX(), matriceUtile.getTableauCoeff());
    }

    
    
    //A COMPLETER
    
    //fonction inversion d'une matrice
    public static Matrice inversionMatrice(Matrice m){
        //{matrice carrée} => {inverse de la matrice}

        //vérification compatibilité matrice avec la mise à la puissance
        if (m.getDimX() != m.getDimY()){
            //retour matrice vide
            System.out.println("Dimensions incompatibles pour l'inversion.");
            ArrayList<ArrayList<Float>> tableauCoeff = new ArrayList<ArrayList<Float>>(0);
            return new Matrice(0, 0 , tableauCoeff);
        }
        
        else {
        	return new Matrice();
        }


    }
}
