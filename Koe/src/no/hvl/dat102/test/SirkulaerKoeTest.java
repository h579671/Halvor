package no.hvl.dat102.test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;

public class SirkulaerKoeTest extends KoeTest{
	
	@Override
	protected KoeADT<Integer> reset() {
		return new SirkulaerKoe<Integer>();
	}


}
