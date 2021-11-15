package fr.diamante.numeration;

public class Conversions {
	public static byte[] unsignedDecToBin(int l) {
		/*
		 * {int l, l>=0} -> {byte[] = l en binaire}
		 */
		//V�rification du nombre d'octets du nombre test�
		int nb = 1;
		int nbBit = 1;
		while(l - nb >0){
			nbBit++;
			nb*=2;
		}
		
		//On cr�e un tableau statique de la taille du nombre de bits
		byte[] bin = new byte[nbBit];
		
		
		for(int i = 0; i < nbBit; i++) {   
			bin[i] = 0;						//On initialise les coefficients � 0
			if(l - nb >= 0) {				//On r�utilise la variable nb qui est �gale � 2^nbBit.		
				l-=nb;						//On retranche si l>nb
				bin[i] = 1;					//On met le coefficient � 1
				
			}
			nb/=2;							//On divise nb par 2
		}
		return bin;
	}
	
	public static byte[] UnsignedDecToBin(long l) {
		/*
		 * {long l, l>=0} -> {byte[] = l en binaire}
		 */
		//V�rification du nombre d'octets du nombre test�
				long nb = 1L;
				int nbBit = 1;
				while(l - nb >0){
					nbBit++;
					nb*=2;
				}
				
				//On cr�e un tableau statique de la taille du nombre de bits
				byte[] bin = new byte[nbBit];
				
				
				for(int i = 0; i < nbBit; i++) {   
					bin[i] = 0;						//On initialise les coefficients � 0
					if(l - nb >= 0) {				//On r�utilise la variable nb qui est �gale � 2^nbBit.		
						l-=nb;						//On retranche si l>nb
						bin[i] = 1;					//On met le coefficient � 1
						
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
