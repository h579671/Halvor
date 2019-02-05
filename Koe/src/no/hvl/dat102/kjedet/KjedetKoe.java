package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T>{
	private LinearNode<T> head, tail;
	private int antall;

	public KjedetKoe() {
		head = tail = null;
		antall = 0;
	}

	public void innKoe(T element) {
		LinearNode<T> forste = new LinearNode<T>(element);
		
		
		if(erTom()) {
			throw new EmptyCollectionException("Køen");
		}else {
			tail.setNeste(forste);
		}
		
		tail = forste;
		antall++;
	}

	public T utKoe() throws EmptyCollectionException {
		if(erTom()) 
			throw new EmptyCollectionException("Køen");
		
		T result = head.getElement();
		head = head.getNeste();
		antall--;
		
		if(erTom())
			tail = null;
		
		return result;
	}

	public T foerste() {
		T forste = tail.getElement();
		return forste;
	}

	public boolean erTom() {
		if(antall == 0) 
			return true;
		return false;
	}

	public int antall() {
		return antall;
	}
	
	
	

	public LinearNode<T> getHead() {
		return head;
	}

	public void setHead(LinearNode<T> head) {
		this.head = head;
	}

	public LinearNode<T> getTail() {
		return tail;
	}

	public void setTail(LinearNode<T> tail) {
		this.tail = tail;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}
	
	
	
}
