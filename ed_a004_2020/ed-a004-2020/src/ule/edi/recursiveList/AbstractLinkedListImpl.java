package ule.edi.recursiveList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;
import ule.edi.exceptions.TypeIsNotComparableException;

public class AbstractLinkedListImpl<T> implements ListADT<T> {

	// Estructura de datos, lista simplemente enlazada
	//
	// Este es el primer nodo de la lista
	protected Node<T> front = null;

	// Clase para cada nodo en la lista
	protected class Node<T> {

		T elem;

		Node<T> next;

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		@Override
		public String toString() {
			return "(" + elem + ")";
		}

	}

	private class IteratorImpl implements Iterator<T> {
		// TODO Implementar el iterador normal

		private Node<T> node;

		public IteratorImpl(Node<T> node) {
			this.node = node;
		}

		@Override
		public boolean hasNext() {

			return (node != null);
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T next = node.elem;
			node = node.next;

			return next;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// Ejemplos de ejercicios de recursividad
	//

	@Override
	public String toString() {
		// TODO RECURSIVO
		// Construye y devuelve con el formato adecuado "(A B C )"
		StringBuffer cadena = new StringBuffer();

		cadena.append("(");
		if (!isEmpty()) {
			toStringRec(cadena, front);
		}
		cadena.append(")");

		return cadena.toString();
	}

	private void toStringRec(StringBuffer cadena, Node<T> aux) {
		if (aux.next == null) {
			cadena.append(aux.elem.toString() + " ");
		} else {
			cadena.append(aux.elem.toString() + " ");
			aux = aux.next;
			toStringRec(cadena, aux);
		}

	}

	@Override
	public boolean contains(T target) {
		// TODO RECURSIVO

		if (target == null) {
			throw new NullPointerException();
		}
		return containsRec(front, target);
	}

	private boolean containsRec(Node<T> aux, T target) {
		if (aux.elem.equals(target)) {
			return true;
		} else if (aux.next != null) {
			aux = aux.next;
			return containsRec(aux, target);
		} else {
			return false;
		}

	}

	@Override
	public int count(T element) {
		// TODO RECURSIVO
		int count = 0;
		if (isEmpty()) {
			return count;
		} else {
			return countRec(element, front, count);
		}
	}

	private int countRec(T element, Node<T> aux, int count) {

		if (aux.elem.equals(element)) {
			count++;
			aux = aux.next;
			return countRec(element, aux, count);
		} else if (aux.next != null) {
			aux = aux.next;
			return countRec(element, aux, count);
		} else {
			return count;
		}
	}

	@Override
	public T getLast() throws EmptyCollectionException {
		// TODO RECURSIVO
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista");
		}

		return getLastRec(front);
	}

	private T getLastRec(Node<T> aux) {
		if (aux.next == null) {
			return aux.elem;
		} else {
			aux = aux.next;
			return getLastRec(aux);
		}
	}

	@Override
	public boolean isOrdered() {
		// TODO RECURSIVO
		if (isEmpty()) {
			return true;
		} else {
			return isOrderedRec(front, front.next);
		}
	}

	private boolean isOrderedRec(Node<T> actual, Node<T> next) {
		try {
			if (next != null) {
				if (((Comparable<T>) actual.elem).compareTo(next.elem) <= 0) {
					return isOrderedRec(next, next.next);
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (ClassCastException e) {
			throw new TypeIsNotComparableException();
		}
	}

	@Override
	public T remove(T element) throws EmptyCollectionException {
		// TODO RECURSIVO
		T result = null;

		if (element == null) {
			throw new NullPointerException();
		}
		if (!contains(element)) {
			throw new NoSuchElementException();
		}

		if (isEmpty()) {
			throw new EmptyCollectionException("Lista");
		}

		if (front.elem == element) {
			result = front.elem;
			front = front.next;
			return result;
		} else {
			return removeRec(element, front, result);
		}
	}

	private T removeRec(T element, Node<T> aux, T result) {
		if (aux.next.elem.equals(element)) {
			result = aux.next.elem;
			aux.next = aux.next.next;
			return result;
		} else {
			return removeRec(element, aux.next, result);
		}
	}

	@Override
	public T removeLast(T element) throws EmptyCollectionException {
		// TODO RECURSIVO
		Node<T> aux = null;

		if (element == null) {
			throw new NullPointerException();
		}
		if (!contains(element)) {
			throw new NoSuchElementException();
		}
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista");
		}
		if (front.elem == element) {
			aux = front;
		}
		return removeLastRec(element, aux, front);
	}

	private T removeLastRec(T element, Node<T> aux, Node<T> current) {
		if (current.next != null) {
			if (current.next.elem.equals(element)) {
				aux = current;
			}
			current = current.next;
			return removeLastRec(element, aux, current);
		} else {
			aux.next = aux.next.next;
			return element;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO
		return front == null;
	}

	@Override
	public int size() {
		// TODO RECURSIVO
		int size = 0;
		if (isEmpty()) {
			return 0;
		} else {
			return sizeRec(front, size);
		}
	}

	private int sizeRec(Node<T> aux, int size) {
		// TODO RECURSIVO
		if (aux.next == null) {
			size++;
			return size;
		} else {
			size++;
			aux = aux.next;
			return sizeRec(aux, size);
		}

	}

	@Override
	public T getFirst() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista");
		}
		return front.elem;
	}

	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO RECURSIVO
		StringBuffer cadena = new StringBuffer();
		Node<T> auxiliar = front;

		if ((from < 1) || (until < from)) {
			throw new IllegalArgumentException();
		}

		cadena.append("(");
		if (isEmpty()) {
			cadena.append("");
		} else {
			toStringFromUntilRec(from, until, auxiliar, front, cadena);
		}
		cadena.append(")");

		return cadena.toString();

	}

	private void toStringFromUntilRec(int from, int until, Node<T> auxiliar, Node<T> aux, StringBuffer cadena) {
		if (from > size()) {
			cadena.append("");
		} else if (until > size()) {
			if (from > 1) {
				aux = aux.next;
				from--;
				toStringFromUntilRec(from, until, auxiliar, aux, cadena);
			} else {
				cadena.append(aux.elem.toString() + " ");
				if (aux.next != null) {
					aux = aux.next;
					toStringFromUntilRec(from, until, auxiliar, aux, cadena);
				}
			}
		} else {
			if (from > 1) {
				aux = aux.next;
				from--;
				toStringFromUntilRec(from, until, auxiliar, aux, cadena);
			} else if (until > 1) {
				auxiliar = auxiliar.next;
				until--;
				toStringFromUntilRec(from, until, auxiliar, aux, cadena);
			} else {
				if (aux.equals(auxiliar)) {
					cadena.append(aux.elem.toString() + " ");
				} else {
					cadena.append(aux.elem.toString() + " ");
					aux = aux.next;
					toStringFromUntilRec(from, until, auxiliar, aux, cadena);
				}
			}
		}
	}

	@Override
	public String toStringReverse() {
		// TODO RECURSIVE
		StringBuffer cadenaReverse = new StringBuffer();

		cadenaReverse.append("(");
		toStringReverseRec(cadenaReverse, front);
		cadenaReverse.append(")");

		return cadenaReverse.toString();
	}

	private void toStringReverseRec(StringBuffer cadena, Node<T> aux) {
		if (aux != null) {
			toStringReverseRec(cadena, aux.next);
			cadena.append(aux.elem.toString() + " ");
		}
	}

	@Override
	public int removeDuplicates() throws EmptyCollectionException {
		// TODO RECURSIVE
		// Implementar teniendo en cuenta que la lista está desordenada
		int veces = 0;
		Node<T> node = null;
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista");
		}

		return removeDuplicatesRec(front, node, veces);

	}

	private int removeDuplicatesRec(Node<T> aux, Node<T> node, int veces) {
		if (aux != null) {
			node = aux;
			veces = removeDuplicatesRecRec(aux, node);
			return veces + removeDuplicatesRec(aux.next, node, veces);
		} else {
			return 0;
		}
	}

	private int removeDuplicatesRecRec(Node<T> aux, Node<T> node) {
		if (node.next != null) {
			if (node.next.elem.equals(aux.elem)) {
				node.next = node.next.next;
				return 1 + removeDuplicatesRecRec(aux, node);
			} else {
				node = node.next;
				return removeDuplicatesRecRec(aux, node);
			}
		} else {
			return 0;
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO
		Iterator<T> iterador = new IteratorImpl(front);
		return iterador;
	}

}
