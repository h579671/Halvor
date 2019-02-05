package no.hvl.dat102.test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.tabell.TabellKoe;

public class KjedetKoeTest extends KoeTest{
	

	
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellKoe<Integer>();
	}

}
