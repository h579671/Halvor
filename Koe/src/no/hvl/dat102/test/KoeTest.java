package no.hvl.dat102.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeTest {

	private KoeADT<Integer> stabel;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();
	/**
	 * Hent en ny stabel for hver test.
	 * @return 
	 */
	@Before
	public final void setup() {
		stabel = reset();
	}
	
	@Test
	public final void testInnKoe() {
		stabel.innKoe(e0);
		stabel.innKoe(e1);
		stabel.innKoe(e2);
		stabel.innKoe(e3);
	}

	@Test
	public final void testUtKoe() {
		stabel.innKoe(e0);
		stabel.innKoe(e1);
		stabel.innKoe(e2);
		stabel.innKoe(e3);

		try {
			assertEquals(e0, stabel.utKoe());
			assertEquals(e1, stabel.utKoe());
			assertEquals(e2, stabel.utKoe());
			assertEquals(e3, stabel.utKoe());
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}

	@Test
	public final void testFoerste() {
		stabel.innKoe(e0);
		stabel.innKoe(e1);
		assertTrue(e0 == stabel.foerste());
	}

	@Test
	public final void testErTom() {
		assertTrue(stabel.erTom());
	}

	@Test
	public final void testAntall() {
		stabel.innKoe(e0);
		stabel.innKoe(e1);
		stabel.innKoe(e2);
		assertEquals(3, stabel.antall());
	}
}
