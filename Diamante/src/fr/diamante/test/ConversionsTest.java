package fr.diamante.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversion;

import fr.diamante.numeration.Conversions;

class ConversionsTest {

	@Test
	void testUnsignedDecToBin() {
		int dec = 0;
		byte[] bin = {0};
		if(Conversions.unsignedDecToBin(dec) != bin) {
			fail("Erreur de conversion 0");
		}
		
	}

	@Test
	void testUnsignedDecToBin1() {
		fail("Not yet implemented");
	}

	@Test
	void testBinToDec() {
		fail("Not yet implemented");
	}

}
