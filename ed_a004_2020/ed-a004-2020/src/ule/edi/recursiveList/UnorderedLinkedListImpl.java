package ule.edi.recursiveList;

import java.util.NoSuchElementException;

public class UnorderedLinkedListImpl<T> extends AbstractLinkedListImpl<T> implements UnorderedListADT<T> {

	public UnorderedLinkedListImpl() {
		// Vacía
	}

	public UnorderedLinkedListImpl(T... v) {
		// Añadir en el mismo orden que en 'v'
		for (T Vi : v) {
			addLast(Vi);
		}
	}

	@Override
	public void addFirst(T element) throws NullPointerException {
		// TODO
		if (element == null) {
			throw new NullPointerException();
		}

		Node<T> current = new Node<T>(element);
		if (front != null) {
			current.next = front;
		}
		front = current;
	}

	@Override
	public void addLast(T element) throws NullPointerException {
		if(element == null) {
			throw new NullPointerException();
		}
		if(isEmpty()) {
			front = new Node <T>(element);
		}else {
			addLastRec(element, front);
		}
	
	}
	private Node<T> addLastRec(T element, Node<T> aux) {
		if(aux == null) {
			aux = new Node<T>(element);
		}else {
			aux.next = addLastRec(element, aux.next);
		}
		return aux;
	}
	
	@Override
	public void addBefore(T element, T target) throws NullPointerException, NoSuchElementException {
		// TODO RECURSIVO
		if ((element == null) || (target == null)) {
			throw new NullPointerException();
		}
		if(!contains(target)){
			throw new NoSuchElementException();
		}
		
		if(front.elem == target) {
			addFirst(element);
		}else {
			addBeforeRec(element,target,front);
		}
	}
		
	private void addBeforeRec(T element, T target, Node<T> aux) {
		if(aux.next.elem.equals(target)) {
			Node<T> nuevo = new Node<T>(element);
			nuevo.next = aux.next;
			aux.next = nuevo;
		}else {
			aux = aux.next;
			addBeforeRec(element,target,aux);
		}
	}
	
}
