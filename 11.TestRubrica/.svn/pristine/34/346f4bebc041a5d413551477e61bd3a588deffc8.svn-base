package it.polito.oop.rubrica.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import it.polito.oop.rubrica.classi.Rubrica;

//annotation needed to include test class in suite, if used only standalone can be omitted
@RunWith(JUnitPlatform.class)
public class TestRubricaJunit4 {
	
	private Rubrica r;
	private String nomeRubrica;
	private String nome;
	private String cognome;
	private String tel;
	
	@Before
	public void setUp()
	{
		nomeRubrica = "RubricaTest";
		r = new Rubrica(nomeRubrica);
		
		nome = "Mario";
		cognome = "Rossi";
		tel = "12345";
		r.aggiungi(nome, cognome, tel);
	}
	
	@Test
	public void testNome()
	{
		assertEquals("Rubrica: restituito nome non corretto",
				r.getNome(),nomeRubrica);
	}
	
	@Test
	public void testPrimo1()
	{
		String primo = r.primo();
		int posNome = primo.indexOf(nome);
		int posCognome = primo.indexOf(cognome);
		int posTel = primo.indexOf(tel);
		
		//assertTrue("Nome non presente", posNome >= 0);
		
		assertFalse("Nome non presente", posNome <0);
		
		assertTrue(posCognome >= 0);
		assertTrue(primo.contains(cognome));
		
		assertTrue(posTel >= 0);
	}
	
	@Test
	public void testPrimo2()
	{
		String primo = r.primo();
		int posNome = primo.indexOf(nome);
		int posCognome = primo.indexOf(cognome);
		int posTel = primo.indexOf(tel);
		
		assertTrue(posNome < posCognome);
		assertTrue(posCognome < posTel);
		//assertTrue(posNome < posTel, "Il nome dovrebbe precedere il num tel");
	}
	
	@Test
	public void testVoce1()
	{
//		String primo = r.primo();
//		String voce1 = r.voce(1);
//		assertEquals("primo() e voce(1) dovrebbero restituire la stessa stringa",
//				primo,voce1);
		assertEquals("primo() e voce(1) dovrebbero restituire la stessa stringa",
				r.primo(),r.voce(1));
	}
	
	@Test
	public void testVoce2()
	{
		r.aggiungi("Giuseppe", "Verdi", "56789");
		r.aggiungi("Gianni", "Bianchi", "12389");
		r.aggiungi("Gianna", "Bianca", "123891");
		
		assertEquals("Ultima voce in rubrica non letta correttamente",r.voce(4),"Gianna Bianca 123891");
		assertEquals("Voce intermedia in rubrica non letta correttamente",r.voce(2),"Giuseppe Verdi 56789");
	}
	
	@Test
	public void testElenco()
	{
		String nome1 = "Ugo";
		String cognome1 = "Verdi";
		String tel1 = "120203";
		r.aggiungi(nome1, cognome1, tel1);
		
		String elenco = r.elenco().trim();
		int sep = elenco.indexOf(",");
		
		assertTrue(elenco.startsWith("("));
		assertTrue(elenco.endsWith(")"));
		
		assertTrue(sep>=0);
		
		assertEquals(r.voce(1), elenco.substring(1,sep).trim());
		assertEquals(r.voce(2), elenco.substring(sep+1,elenco.length()-1).trim());
		
	}
	
	@Test
	public void testRicerca()
	{
		String nome1 = "Ugo";
		String cognome1 = "Verdi";
		String tel1 = "120203";
		r.aggiungi(nome1, cognome1, tel1);
		
		r.aggiungi("Giuseppe", "Verdi", "56789");
		r.aggiungi("Gianni", "Bianchi", "12389");
		r.aggiungi("Gianna", "Bianca", "123891");
		
		String verdi1 = r.ricerca("Verdi");
		String verdi2 = r.ricerca("Ugo");
		String verdi3 = r.ricerca("120203");
		
		assertEquals(verdi1,verdi2);
		assertEquals(verdi1,verdi3);
	}
}
