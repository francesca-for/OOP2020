package it.polito.oop.rubrica.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import it.polito.oop.rubrica.classi.Voce;

//annotation needed to include test class in suite, if used only standalone can be omitted
@RunWith(JUnitPlatform.class)
public class TestVoce {

	Voce v;
	
	@BeforeEach
	void setUp()
	{
		v = new Voce("Albert", "Einstein", "0110901234");
	}
	
	@AfterEach
	void finalMethod()
	{
		System.out.println("Test eseguito!");
	}
	
	@Test
	void testGetter()
	{
		assertEquals(v.getNome(),"Albert","Nome errato: dovrebbe essere Albert");
		assertEquals(v.getCognome(),"Einstein","Cognome errato: dovrebbe essere Einstein");
		assertEquals(v.getNumTelefono(),"0110901234","Num. tel. errato: dovrebbe essere 0110901234");
	}
	
	@Test
	void testToString()
	{
		assertEquals(v.toString(),"Albert Einstein 0110901234");
	}
}
