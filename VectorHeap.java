
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
     */
    public VectorHeap() {
        data = new Vector<>();
    }


     /** Almacena los elementos del heap */
    public VectorHeap(Vector<E> v) {
        data = new Vector<>(v.size());
        for (E item : v) {
            add(item);
        }
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

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

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

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

    @Override
    public E peek() {
        if (data.isEmpty()) return null;
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}
