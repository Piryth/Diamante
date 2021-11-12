package fr.diamante.linearalgebra;

import java.util.ArrayList;

public class Matrice {
	/**
	 * @author Mélian
	 */
	
	//attributs
    private int dimY;
    private int dimX;
    private ArrayList<ArrayList<Float>> tableauCoeff;

    //constructeur
    public Matrice(int dimY, int dimX, ArrayList<ArrayList<Float>> tableauCoeff){
        this.dimY = dimY;
        this.dimX = dimX;
        this.tableauCoeff = tableauCoeff;
    }
    
    public Matrice() {}
    

    //méthodes

    
    //getters
    public int getDimY() {
        return dimY;
    }
    public int getDimX() {
        return dimX;
    }
    public float getCoeff(int y, int x){
        return tableauCoeff.get(y).get(x);
    }
    public ArrayList<ArrayList<Float>> getTableauCoeff() {
        return tableauCoeff;
    }
    //setters
    public void setCoeff(int y, int x, float newCoeff){
        //{coorodonnées entières x et y, nouveau coefficient} => {remplace l'ancien coefficicent de ces coordonnées par le nouveau coefficicent}

        tableauCoeff.get(y).remove(x);
        tableauCoeff.get(y).add(x, newCoeff);
    }
}
