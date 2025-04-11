
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 * Clase VectorHeap
 * Implementacion de cola de prioridad usando heap respaldado por un vector
 * 
 * @param <E> Tipo de elementos que deben implementar Comparable.
 * 
 */
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueueInterface<E> {
     /** Almacena los elementos del heap */
    protected Vector<E> data; 

     /** 
      * Contructor, inicializa un heap vacio
     *  
     */
    public VectorHeap() {
        data = new Vector<>();
    }


     /** Almacena los elementos del heap 
      * @param v Vector con elementos iniciales
     */
    public VectorHeap(Vector<E> v) {
        data = new Vector<>(v.size());
        for (E item : v) {
            add(item);
        }
    }


    /**
     * Calcula el indice del padre de un nodo.
     * @param i indice del nodo hijo.
     * @return indice del nodo padre.
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el indice del hijo izquierdo de un nodo.
     * @param i indice del nodo padre.
     * @return indice del hijo izquierdo.
     */
    protected int left(int i) {
        return 2 * i + 1;
    }


    /**
     * Calcula el indice del hijo izquierdo de un nodo.
     * @param i indice del nodo padre.
     * @return indice del hijo derecho.
     */
    protected int right(int i) {
        return 2 * i + 2;
    }


    /**
     * Ajusta un nodo hacia arriba en el heap para mantener la propiedad del heap.
     * @param leaf indice del nodo hoja que se acaba de insertar.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }


    /**
     * Ajusta un nodo hacia abajo en el heap para restaurar la propiedad del heap.
     * @param root indice de la raiz del subárbol que necesita reordenarse.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childPos = left(root);
            if (childPos >= heapSize) break;

            int rightPos = right(root);
            if (rightPos < heapSize && data.get(rightPos).compareTo(data.get(childPos)) < 0) {
                childPos = rightPos;
            }

            if (data.get(childPos).compareTo(value) < 0) {
                data.set(root, data.get(childPos));
                root = childPos;
            } else {
                break;
            }
        }
        data.set(root, value);
    }


    /**
     * Agrega un elemento al heap y mantiene la propiedad de orden.
     * @param value elemento a insertar.
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Elimina y retorna el elemento con mayor prioridad.
     * @return elemento de mayot prioridad, null si esta vacio.
     */

    @Override
    public E remove() {
        if (data.isEmpty()) return null;
        E minVal = data.get(0);
        E last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            pushDownRoot(0);
        }
        return minVal;
    }


    /**
     * retorna el elemento con mayor prioridad.
     * @return elemento de mayor prioridad, null si esta vacio.
     */
    @Override
    public E peek() {
        if (data.isEmpty()) return null;
        return data.get(0);
    }


    /**
     * Verifica si el heap esta vacío.
     * @return true si está vacio, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    /**
     * Retorna el numero de elementos en el heap.
     * @return Tamaño del heap.
     */
    @Override
    public int size() {
        return data.size();
    }
}
