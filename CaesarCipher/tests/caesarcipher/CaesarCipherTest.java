package caesarcipher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void calculateEncryptMessage() {

		Assert.assertEquals("GRGSGQUZG", CaesarCipher.encryptMessage("ALAMAKOTA", 6));
	}

	@Test
	public void calculatemostLetterEncryptMessageTest() {

		Assert.assertEquals('K', CaesarCipher.calculatemostLetterEncryptMessage("KVKWKUYDK", 9));
		// sprawdza, czy wynik metody dla konkretnych argumentów jest równy
		// oczekiwanemu(w tym wypadku K);
	}

	@Test
	public void calculateShiftKeyTest() {

		Assert.assertEquals(10, CaesarCipher.calculateShiftKey('A', 'K'));
	}

	@Test
	public void decryptTest() {

		Assert.assertEquals("ALAMAKOTA", CaesarCipher.decrypt("KVKWKUYDK", 10));
	}

}
