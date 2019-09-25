// package circularlinkedlist;
import java.util.*;

public class CircularLinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	@SuppressWarnings("unchecked")
	public static void main(String[] args){

		Scanner inScan = new Scanner(System.in);
		System.out.println("input num soldiers, hit enter, input num skips");
		int numSoldiers = inScan.nextInt();
		int numSkips = inScan.nextInt();
		int[] soldiers = new int[numSoldiers];
		for (int i = 0; i < numSoldiers; i++) { soldiers[i] = i + 1; }

		// Shift soldiers[] into a single linked list
		CircularLinkedList linkedList = new CircularLinkedList();
		for (int i = 0; i < numSoldiers; i++) { linkedList.add(soldiers[i]); }

		System.out.println("done");
	}

	// Implement a constructor
	public CircularLinkedList() {
		this.head = null;
		this.size = 0;	
	}
	// in This method: Add a node to the end of the list
	  // remember: Use the overloaded add method (below this one) as a helper method
		// Cases to handle (here):
		//      Adding an element to an empty list
	public void add(E item) { 
		//CASE: Add element to an empty list
		if (this.size == 0) {
			this.head = new Node<E>(item);
			this.size++;
		}
		// else this.next();	that's half-baked...
	}
		// Cases to handle (here):
		//      Adding an element to the front
		//      Adding an element to the end
		//      Adding an element in the middle
	public void add(int index, E item) {
		// CASE: handle OOB exception
		if (index < 0 || index >= this.size) {throw new IndexOutOfBoundsException(Integer.toString(index));}
		// CASE: Add element to an empty list
		if (this.size == 0 && index == 0) {
			head = new Node<E>(item);
			size++;
		}
		// Case: Add el to Front
		if (index == 0) {
		// create a new node, shift ALL nodes down 1, then insert new node at head
		}
		// Case: Add el to Middle
		if (index != 0 && index != this.size - 1) {

		}
		// Case: Add el to End
		if (index == this.size - 1) {

		}
	}

	// Return Node<E> found at the specified index
	private Node<E> getNode(int index) {
		//CASE: handle OOB exception
		if (index < 0 || index >= size) {throw new IndexOutOfBoundsException(Integer.toString(index));}

		else for (int i = 0; i < index; i++) {
			// start at head, call next until reached the correct position
			// return node at index
		}
		return null;
	}

	public E remove(int index) {
		return null;
	}

	// Stringify your list
	// Cases to handle:
	//      Empty list
	//      Single element list
	//      Multi-element list
	// Use "==>" to delimit each node
	public String toString() {
		StringBuilder result = new StringBuilder();

		return result.toString();
	}

	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}
	
	// This class is not static because it needs to reference its parent class
	private class ListIterator<E> implements Iterator<E> {
		Node<E> nextItem;
		Node<E> prev;
		int index;

		@SuppressWarnings("unchecked")
		// Creates a new iterator that starts at the head of the list
		public ListIterator() {
			nextItem = (Node<E>) head;
			index = -1;
		}

		// Returns true if there is a next node
		//public boolean hasNext() {
		//	if (nextItem == head) return false;
		//	else return true;
		}
		
		// Advances the iterator to the next item
		// Should wrap back around to the head
		public E next() {
			return null;
		}

		// Remove the last node visited by the .next() call
		// For example, if we had just created an iterator,
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		// Use CircularLinkedList.this to reference the CircularLinkedList parent class
		public void remove() {
		
		}
	}
	
	// The Node class
	private static class Node<E>{
		E item;
		Node<E> next;
		
		public Node(E item) {
			this.item = item;
		}
		
	}	
}
