package ule.edi.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Árbol binario de búsqueda (binary search tree, BST).
 * 
 * El código fuente está en UTF-8, y la constante EMPTY_TREE_MARK definida en
 * AbstractTreeADT del proyecto API debería ser el símbolo de conjunto vacío: ∅
 * 
 * Si aparecen caracteres "raros", es porque el proyecto no está bien
 * configurado en Eclipse para usar esa codificación de caracteres.
 *
 * En el toString() que está ya implementado en AbstractTreeADT se usa el
 * formato:
 * 
 * Un árbol vacío se representa como "∅". Un árbol no vacío como "{(información
 * raíz), sub-árbol 1, sub-árbol 2, ...}".
 * 
 * Por ejemplo, {A, {B, ∅, ∅}, ∅} es un árbol binario con raíz "A" y un único
 * sub-árbol, a su izquierda, con raíz "B".
 * 
 * El método render() también representa un árbol, pero con otro formato; por
 * ejemplo, un árbol {M, {E, ∅, ∅}, {S, ∅, ∅}} se muestra como:
 * 
 * M | E | | ∅ | | ∅ | S | | ∅ | | ∅
 * 
 * Cualquier nodo puede llevar asociados pares (clave,valor) para adjuntar
 * información extra. Si es el caso, tanto toString() como render() mostrarán
 * los pares asociados a cada nodo.
 * 
 * Con {@link #setTag(String, Object)} se inserta un par (clave,valor) y con
 * {@link #getTag(String)} se consulta.
 * 
 * 
 * Con <T extends Comparable<? super T>> se pide que exista un orden en los
 * elementos. Se necesita para poder comparar elementos al insertar.
 * 
 * Si se usara <T extends Comparable<T>> sería muy restrictivo; en su lugar se
 * permiten tipos que sean comparables no sólo con exactamente T sino también
 * con tipos por encima de T en la herencia.
 * 
 * @param <T> tipo de la información en cada nodo, comparable.
 */
public class BinarySearchTreeImpl<T extends Comparable<? super T>> extends AbstractBinaryTreeADT<T> {

	BinarySearchTreeImpl<T> father; // referencia a su nodo padre)

	/**
	 * Devuelve el árbol binario de búsqueda izquierdo.
	 */
	protected BinarySearchTreeImpl<T> getLeftBST() {
		// El atributo leftSubtree es de tipo AbstractBinaryTreeADT<T> pero
		// aquí se sabe que es además de búsqueda binario
		//
		return (BinarySearchTreeImpl<T>) leftSubtree;
	}

	private void setLeftBST(BinarySearchTreeImpl<T> left) {
		this.leftSubtree = left;
	}

	/**
	 * Devuelve el árbol binario de búsqueda derecho.
	 */
	protected BinarySearchTreeImpl<T> getRightBST() {
		return (BinarySearchTreeImpl<T>) rightSubtree;
	}

	private void setRightBST(BinarySearchTreeImpl<T> right) {
		this.rightSubtree = right;
	}

	/**
	 * Árbol BST vacío
	 */
	public BinarySearchTreeImpl() {
		// TODO HACER QUE THIS SEA EL NODO VACÍO
		this.father = null;
		this.content = null;
		setLeftBST(null);
		setRightBST(null);

	}

	public BinarySearchTreeImpl(BinarySearchTreeImpl<T> father) {
		// TODO HACER QUE THIS SEA EL NODO VACÍO, asignando como padre el parámetro
		// recibido
		setContent(null);
		setLeftBST(null);
		setRightBST(null);
		this.father = father;
	}
	

	/**
	 * Inserta los elementos de una colección en el árbol. si alguno es 'null', NO
	 * INSERTA NINGUNO
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param elements valores a insertar.
	 * @return numero de elementos insertados en el arbol (los que ya están no los
	 *         inserta)
	 */
	public void insert(Collection<T> elements) {
		// si alguno es 'null', ni siquiera se comienza a insertar (no inserta ninguno)
		// TODO Implementar el método

		for (T elem : elements) {
			if (elem == null) {
				throw new IllegalArgumentException();
			}
		}

		for (T elem : elements) {
			insert(elem);
		}

	}

	/**
	 * Inserta los elementos de un array en el árbol. si alguno es 'null', NO
	 * INSERTA NINGUNO
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param elements elementos a insertar.
	 * @return numero de elementos insertados en el arbol (los que ya están no los
	 *         inserta)
	 */
	public void insert(T... elements) {
		// si alguno es 'null', ni siquiera se comienza a insertar (no inserta ninguno)
		// TODO Implementar el método

		for (T elem : elements) {
			if (elem == null) {
				throw new IllegalArgumentException();
			}
		}

		for (T elem : elements) {
			insert(elem);
		}
	}

	/**
	 * Inserta (como hoja) un nuevo elemento en el árbol de búsqueda.
	 * 
	 * Debe asignarse valor a su atributo father (referencia a su nodo padre o null
	 * si es la raíz)
	 * 
	 * No se permiten elementos null. Si element es null dispara excepción:
	 * IllegalArgumentException Si el elemento ya existe en el árbol NO lo inserta.
	 * 
	 * @param element valor a insertar.
	 * @return true si se pudo insertar (no existia ese elemento en el arbol, false
	 *         en caso contrario
	 * @throws IllegalArgumentException si element es null
	 */
	public boolean insert(T element) {
		// TODO Implementar el método

		if (element == null) {
			throw new IllegalArgumentException();
		}

		if (this.getContent() == null) {
			this.setContent(element);
			this.setLeftBST(new BinarySearchTreeImpl<T>(this));
			this.setRightBST(new BinarySearchTreeImpl<T>(this));
			return true;
		} else {
			if (element.compareTo(this.content) < 0) {
				return getLeftBST().insert(element);
			} else if (element.compareTo(this.content) > 0) {
				return getRightBST().insert(element);
			} else {
				return false;
			}
		}
	}

	/**
	 * Busca el elemento en el árbol.
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param element valor a buscar.
	 * @return true si el elemento está en el árbol, false en caso contrario
	 */
	public boolean contains(T element) {
		// TODO Implementar el método

		if (!this.isEmpty()) {
			if (element == this.getContent()) {
				return true;
			} else if (element.compareTo(this.getContent()) < 0 && this.getLeftBST() != null) {
				return this.getLeftBST().contains(element);
			} else if (element.compareTo(this.getContent()) > 0 && this.getRightBST() != null) {
				return this.getRightBST().contains(element);
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Elimina los valores en un array del árbol. O todos o ninguno; si alguno es
	 * 'null'o no lo contiene el árbol, no se eliminará ningún elemeno
	 * 
	 * @throws NoSuchElementException si alguno de los elementos a eliminar no está
	 *                                en el árbol
	 */
	public void remove(T... elements) {
		// TODO Implementar el método

		for (T elem : elements) {
			if (elem == null) {
				throw new IllegalArgumentException();
			}
			if (!contains(elem)) {
				throw new NoSuchElementException();
			}
		}

		for (T elem : elements) {
			remove(elem);
		}
	}

	/**
	 * Elimina un elemento del árbol.
	 * 
	 * Si el elemento tiene dos hijos, se tomará el criterio de sustituir el
	 * elemento por el menor de sus mayores y eliminar el menor de los mayores.
	 * 
	 * @throws NoSuchElementException si el elemento a eliminar no está en el árbol
	 */
	public void remove(T element) throws NoSuchElementException {
		// TODO Implementar el método
		if(element == null) {
			throw new IllegalArgumentException();
		}
		
		if (!contains(element)) {
			throw new NoSuchElementException();
		}

		if (!isEmpty()) {
			if (element.compareTo(this.getContent()) == 0) {

				if (this.getLeftBST().getContent() == null && this.getRightBST().getContent() == null) {
					this.setContent(null);
					this.setLeftBST(null);
					this.setRightBST(null);
				} else if (this.getLeftBST().getContent() != null && this.getRightBST().getContent() != null) {
					BinarySearchTreeImpl<T> minimo = this.getRightBST().getMinimum();
					this.setContent(minimo.getContent());
					this.getRightBST().remove(minimo.getContent());
				} else {
					if (this.getLeftBST().content != null) {
						BinarySearchTreeImpl<T> sustituto = this.getLeftBST();
						this.content = sustituto.content;
						this.setLeftBST(sustituto.getLeftBST());
						this.setRightBST(sustituto.getRightBST());
					} else {
						BinarySearchTreeImpl<T> sustituto = this.getRightBST();
						this.content = sustituto.content;
						this.setLeftBST(sustituto.getLeftBST());
						this.setRightBST(sustituto.getRightBST());
					}
				}
			} else if (element.compareTo(this.content) < 0) {
				this.getLeftBST().remove(element);
			} else if (element.compareTo(this.content) > 0) {
				this.getRightBST().remove(element);
			}
		}

	}

	private BinarySearchTreeImpl<T> getMinimum() {
		if (this.getLeftBST().getContent() != null) {
			return this.getLeftBST().getMinimum();
		} else {
			return this;
		}
	}

	/**
	 * Importante: Solamente se puede recorrer el árbol una vez
	 * 
	 * Etiqueta cada nodo con la etiqueta "height" y el valor correspondiente a la
	 * altura del nodo.
	 * 
	 * Por ejemplo, sea un árbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * 10 | 5 | | 2 | | | ∅ | | | ∅ | | ∅ | 20 | | 15 | | | ∅ | | | ∅ | | 30 | | | ∅
	 * | | | ∅
	 * 
	 * 
	 * el árbol quedaría etiquetado:
	 * 
	 * {10 [(height, 1)], {5 [(height, 2)], {2 [(height, 3)], ∅, ∅}, ∅}, {20
	 * [(height, 2)], {15 [(height, 3)], {12 [(height, 4)], ∅, ∅}, ∅}, ∅}}
	 * 
	 */
	public void tagHeight() {
		// TODO implementar el método
		int count;

		if (!this.isEmpty()) {
			count = 1;
			this.setTag("height", count);
			count++;
			tagHeighRec( this.getRightBST(), count);
			tagHeighRec(this.getLeftBST(), count);
		}
	}

	private void tagHeighRec( BinarySearchTreeImpl<T> nodo, int count) {
		// TODO Auto-generated method stub
		if (!nodo.isEmpty()) {
			nodo.setTag("height", count);
			count++;
			tagHeighRec(nodo.getRightBST(), count);
			tagHeighRec(nodo.getLeftBST(), count);
		}
	}

	/**
	 * Importante: Solamente se puede recorrer el árbol una vez
	 * 
	 * Etiqueta cada nodo con el valor correspondiente al número de descendientes
	 * que tiene en este árbol.
	 * 
	 * Por ejemplo, sea un árbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * 10 | 5 | | 2 | | | ∅ | | | ∅ | | ∅ | 20 | | 15 | | | ∅ | | | ∅ | | 30 | | | ∅
	 * | | | ∅
	 * 
	 * 
	 * el árbol quedaría etiquetado:
	 * 
	 * {10 [(decendents, 5)], {5 [(decendents, 1)], {2 [(decendents, 0)], ∅, ∅}, ∅},
	 * {20 [(decendents, 2)], {15 [(decendents, 0)], ∅, ∅}, {30 [(decendents, 0)],
	 * ∅, ∅}}}
	 * 
	 * 
	 */
	public void tagDecendents() {
		// TODO Implementar el método

		if (!isEmpty()) {

			if (!getLeftBST().isEmpty())
				getLeftBST().tagDecendents();

			if (!getRightBST().isEmpty())
				getRightBST().tagDecendents();

			if (!this.isLeaf()) {
				int count = 0;

				if (getLeftBST().getTag("decendents") != null)
					count = (int) getLeftBST().getTag("decendents") + 1;

				if (getRightBST().getTag("decendents") != null)
					count = (int) getRightBST().getTag("decendents") + count + 1;

				this.setTag("decendents", count);
			} else {
				this.setTag("decendents", 0);
			}
		}
	}

	/**
	 * Devuelve un iterador que recorre los elementos del arbol por niveles según el
	 * recorrido en anchura
	 * 
	 * Por ejemplo, con el árbol
	 * 
	 * {50, {30, {10, ∅, ∅}, {40, ∅, ∅}}, {80, {60, ∅, ∅}, ∅}}
	 * 
	 * y devolvería el iterador que recorrería los nodos en el orden: 50, 30, 80,
	 * 10, 40, 60
	 * 
	 * 
	 * 
	 * @return iterador para el recorrido en anchura
	 */

	public Iterator<T> iteratorWidth() {
		// TODO Implementar método
		// puede implementarse creando una lista con el recorrido en anchura de los
		// elementos del árbol y devolver el iterador de dicha lista

		ArrayList<BinarySearchTreeImpl<T>> cadena = new ArrayList<BinarySearchTreeImpl<T>>();
		ArrayList<T> result = new ArrayList<T>();

		cadena.add(this);

		while (!cadena.isEmpty()) {

			BinarySearchTreeImpl<T> aux = cadena.remove(0);

			if (!aux.isEmpty()) {
				result.add(aux.getContent());
				cadena.add(aux.getLeftBST());
				cadena.add(aux.getRightBST());
			}
		}

		return result.iterator();
	}

	/**
	 * Importante: Solamente se puede recorrer el árbol una vez
	 * 
	 * Calcula y devuelve el número de nodos que son hijos únicos y etiqueta cada
	 * nodo que sea hijo único (no tenga hermano hijo del mismo padre) con la
	 * etiqueta "onlySon" y el valor correspondiente a su posición según el
	 * recorrido inorden en este árbol.
	 * 
	 * La raíz no se considera hijo único.
	 * 
	 * Por ejemplo, sea un árbol "A", que tiene 3 hijos únicos, los va etiquetando
	 * según su recorrido en inorden.
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 *
	 * el árbol quedaría etiquetado:
	 * 
	 * {10, {5, {2 [(onlySon, 1)], ∅, ∅}, ∅}, {20, {15 [(onlySon, 3)], {12
	 * [(onlySon, 2)], ∅, ∅}, ∅}, ∅}}
	 * 
	 */
	
	public int tagOnlySonInorder() {
		// TODO Implementar el método
		int[] onlySonArray = new int[1];

		tagOnlySonInorderRec(onlySonArray);

		return onlySonArray[0];
	}

	private void tagOnlySonInorderRec(int[] i) {

		if (!getLeftBST().isEmpty()) {
			getLeftBST().tagOnlySonInorderRec(i);
		}

		if (this.father != null) {
			if ((this.father.getLeftBST().isEmpty()) || (this.father.getRightBST().isEmpty())) {
				i[0]++;
				this.setTag("onlySon", i[0]);
			}
		}
		if (!getRightBST().isEmpty()) {
			getRightBST().tagOnlySonInorderRec(i);
		}
	}

}
