package ule.edi.recursiveList;

public class OrderedLinkedListImpl<T extends Comparable<? super T>> extends
		AbstractLinkedListImpl<T> implements OrderedListADT<T> {

	public OrderedLinkedListImpl() {
		// Vacía
	}

	public OrderedLinkedListImpl(T... v) {
		// Añade todos los elementos del array 'v'
		for (T Vi : v) {
			add(Vi);
		}
	}

	

	
	@Override
    public void add(T element) {
        // TODO RECURSIVO

        if(element == null)
            throw new NullPointerException();

        if (isEmpty()) {
        	Node<T> result = new Node<T>(element);
            front = result;
        } else if (element.compareTo(front.elem) < 0){
            Node<T> result = new Node<T>(element);
            result.next = front;
            front = result;
        } else {
            add(element, front);
        }

    }

    private void add(T element, Node<T> node) {
        Node<T> aux = new Node<T>(element);
        if (node.next != null)  {
            if ((element).compareTo((T) node.next.elem) < 0) {
                aux.next = node.next;
                node.next = aux;
            } else {
                add(element, node.next);
            }
        } else {
            node.next = aux;
        }
    }
	

    @Override
    public int removeDuplicates() {
        // TODO RECURSIVE
        // Redefinir para listas ordenadas (los duplicados estarán consecutivos)

        return removeDuplicates(front);
    }

    private int removeDuplicates(Node<T> aux) {
        if (aux.next != null) {
            if (aux.elem.equals(aux.next.elem)) {
                aux.next = aux.next.next;
                return 1 + removeDuplicates(aux);
            } else {
                return removeDuplicates(aux.next);
            }
        } else {
            return 0;
        }
    }

	
	



	

		

}
