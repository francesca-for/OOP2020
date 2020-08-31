package poli.tuit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTuit {

	@Test
	public void testRegistrazioneUtente() {
		
		FacciataTuit tuit = new FacciataTuit();
		
		tuit.nuovoUtente("Bernie","bernie@dp.us");
		
	}
	
	@Test
	public void testControlloUtente() {
		
		FacciataTuit tuit = new FacciataTuit();
		
		tuit.nuovoUtente("Bernie","bernie@dp.us");
		
		assertTrue( tuit.esisteUtente("Bernie"));
		assertFalse( tuit.esisteUtente("Jake"));
		
		tuit.nuovoUtente("Jake","jake@email.com");
		
		assertEquals( "bernie@dp.us", tuit.emailOf("Bernie"));
		assertEquals( "jake@email.com", tuit.emailOf("Jake"));
		
	}
	
	@Test
	public void testScritturaTuit() throws TuitException {
		
		FacciataTuit tuit = new FacciataTuit();
		
		tuit.nuovoUtente("Bernie","bernie@dp.us");

		int n = tuit.numeroTuit("Bernie");
		assertEquals( 0 , n);
		
		tuit.nuovoTuit("Bernie","Questo è il primo tuit!");
		
		n = tuit.numeroTuit("Bernie");	
		assertEquals( 1 , n);
	}

	@Test(expected = TuitException.class)
	public void testScritturaTuitMax() throws TuitException {
		
		FacciataTuit tuit = new FacciataTuit();
		
		tuit.nuovoUtente("Bernie","bernie@dp.us");

		String testo="12345678901234";
		String testoTuit="";
		for(int i=0; i<10; ++i) {
			testoTuit += testo;
		}
		try {
			tuit.nuovoTuit("Bernie",testoTuit);
		}catch( TuitException e) {
			fail("Eccezione non attesa per 140 caratteri");
		}

		tuit.nuovoTuit("Bernie",testoTuit + "o");

	}

	public void testIdentificatoreTuit() throws TuitException {
		
		FacciataTuit tuit = new FacciataTuit();
		
		tuit.nuovoUtente("Bernie","bernie@dp.us");

		String codice1 = tuit.nuovoTuit("Bernie","Primo twui");
		String codice2 = tuit.nuovoTuit("Bernie","Primo twui");

		assertNotEquals(codice1,codice2);
		
	}

}
