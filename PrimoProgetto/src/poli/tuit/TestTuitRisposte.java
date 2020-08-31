package poli.tuit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTuitRisposte {
	private static final String JAKE = "Jake";
	private static final String BERNIE = "Bernie";
	private static final String KYLE = "Kyle";
	private FacciataTuit tuit;
	private String id1;
	
	@Before
	public void setUp() throws TuitException {
		tuit = new FacciataTuit();
		
		tuit.nuovoUtente(BERNIE,"bernie@dp.us");
		tuit.nuovoUtente(KYLE,"kyle@me.com");
		tuit.nuovoUtente(JAKE,"jake@mail.com");

		id1 = tuit.nuovoTuit(KYLE,"Trump: \"It's frankly disgusting the "
								  + "way the press is able to write whatever thy want to "
								  + "write and people should look into it\" (via CBS)");
	}
	
	@Test
	public void testAutoreTuit() {
		String autore = tuit.getAutore(id1);
		
		assertEquals(KYLE,autore);
	}

	@Test
	public void testTestoTuit() {
		String testo = tuit.getTesto(id1);
		
		assertTrue(testo.contains("press"));
	}

	@Test
	public void testRispostaTuit() throws TuitException {
		
		String idr = tuit.nuovaRisposta(id1,JAKE,"Hitler said the same thing.");
		
		assertEquals(JAKE,tuit.getAutore(idr));
		assertTrue(tuit.getTesto(idr).contains("thing"));
	}

}
