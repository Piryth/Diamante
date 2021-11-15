package fr.diamante.numeration;

public class Conversions {
	public static byte[] unsignedDecToBin(int l) {
		/*
		 * {int l, l>=0} -> {byte[] = l en binaire}
		 */
		//Vérification du nombre d'octets du nombre testé
		int nb = 1;
		int nbBit = 1;
		while(l - nb >0){
			nbBit++;
			nb*=2;
		}
		
		//On crée un tableau statique de la taille du nombre de bits
		byte[] bin = new byte[nbBit];
		
		
		for(int i = 0; i < nbBit; i++) {   
			bin[i] = 0;						//On initialise les coefficients à 0
			if(l - nb >= 0) {				//On réutilise la variable nb qui est égale à 2^nbBit.		
				l-=nb;						//On retranche si l>nb
				bin[i] = 1;					//On met le coefficient à 1
				
			}
			nb/=2;							//On divise nb par 2
		}
		return bin;
	}
	
	public static byte[] UnsignedDecToBin(long l) {
		/*
		 * {long l, l>=0} -> {byte[] = l en binaire}
		 */
		//Vérification du nombre d'octets du nombre testé
				long nb = 1L;
				int nbBit = 1;
				while(l - nb >0){
					nbBit++;
					nb*=2;
				}
				
				//On crée un tableau statique de la taille du nombre de bits
				byte[] bin = new byte[nbBit];
				
				
				for(int i = 0; i < nbBit; i++) {   
					bin[i] = 0;						//On initialise les coefficients à 0
					if(l - nb >= 0) {				//On réutilise la variable nb qui est égale à 2^nbBit.		
						l-=nb;						//On retranche si l>nb
						bin[i] = 1;					//On met le coefficient à 1
						
					}
					nb/=2;							//On divise nb par 2
				}
				return bin;
			}
	
	public static int binToDec(byte[] bin) {
		int dec = 0;
		for(int i = bin.length-1; i>0; i--) {
			if(bin[i] == 1) {
				dec += Math.pow(2, bin.length-i);
			}
		}
		return 0;
	}
}
