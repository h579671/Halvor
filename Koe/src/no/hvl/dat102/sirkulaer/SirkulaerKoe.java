package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {
	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;

	public SirkulaerKoe(int initialCapacity) {
		front = rear = count = 0;
		queue = (T[]) (new Object[initialCapacity]);
	}
	
	public SirkulaerKoe() {
		this(DEFAULT_CAPACITY);
	}
	
	
	public void innKoe(T element) {
		if(size() == queue.length) 
			expandCapacity();
		
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count ++;
			
	}
	
	public void expandCapacity() {
		T[] larger = (T[]) (new Object[queue.length *2]);
		
		for(int scan = 0; scan < count; scan++) {
			larger[scan] = queue[front];
			front = (front+1) % queue.length;
		}
		
		front = 0;
		rear = count;
		queue = larger;
	}

	public T utKoe() throws EmptyCollectionException {
		if(erTom()) 
			throw new EmptyCollectionException("Køen");
		
		T result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		
		count--;
		
		return result;
	}

	public T foerste() {
		T forste = queue[front];
		return forste;
	}

	public boolean erTom() {
		if(queue[front] == null)
			return true;
		return false;
	}

	public int antall() {
		return count;
	}
	
	public int size() {
		return DEFAULT_CAPACITY;
	}

}
