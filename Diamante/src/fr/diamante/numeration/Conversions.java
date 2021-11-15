package fr.diamante.numeration;

/**
 * 
 * @author Pax
 *
 */

public class Conversions {
	
	/**
	 * 
	 * @param dec
	 * 				 le nombre binaire � convertir
	 * @return
	 * 				 un tableau de bytes contenant le code binaire
	 */
	public static byte[] unsignedDecToBin(int dec) {
		
		int nb = 1;
		int nbBit = 1;
		while(dec - nb >0){
			nbBit++;
			nb*=2;
		}
		
		//On cr�e un tableau statique de la taille du nombre de bits
		byte[] bin = new byte[nbBit];
		
		
		for(int i = 0; i < nbBit; i++) {   
			bin[i] = 0;						//On initialise les coefficients � 0
			if(dec - nb >= 0) {				//On r�utilise la variable nb qui est �gale � 2^nbBit.		
				dec-=nb;						//On retranche si l>nb
				bin[i] = 1;					//On met le coefficient � 1
				
			}
			nb/=2;							//On divise nb par 2
		}
		return bin;
	}
	
	/**
	 * 
	 * @param dec 
	 * 				le nombre binaire � convertir
	 * @return
	 * 				un tableau de bytes contenant le code binaire
	 */
	public static byte[] UnsignedDecToBin(long dec) {
		
		//V�rification du nombre d'octets du nombre test�
				long nb = 1L;
				int nbBit = 1;
				while(dec - nb >0){
					nbBit++;
					nb*=2;
				}
				
				//On cr�e un tableau statique de la taille du nombre de bits
				byte[] bin = new byte[nbBit];
				
				
				for(int i = 0; i < nbBit; i++) {   
					bin[i] = 0;						//On initialise les coefficients � 0
					if(dec - nb >= 0) {				//On r�utilise la variable nb qui est �gale � 2^nbBit.		
						dec-=nb;						//On retranche si l>nb
						bin[i] = 1;					//On met le coefficient � 1
						
					}
					nb/=2;							//On divise nb par 2
				}
				return bin;
			}
	
	
	/**
	 * Convertit un binaire en d�cimal. Conversion sign�e
	 * 
	 * @param bin
	 * 				Le nombre binaire, sous forme de tableau de byte, � convertir
	 * @return
	 * 				La valeur d�cimale convertie
	 */
	public static int binToDec(byte[] bin) {
		
		int dec = 0;
		
		//On va dans le sens inverse, pour finir sur le bit de signe
		for(int i = bin.length-1; i>=0; i--) {
			
			if(bin[i] == 1) {
				dec += Math.pow(2, i-bin.length);
			}
			
			//bin[0] identifie le signe
			if(i == 0) {
				dec *= -1;
			}
			
		}
		return dec;
	}
}
