
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 * Clase PriorityQueueJCF
 * Implementacion de una cola de prioridad usando JCF
 * 
 * @param <E> Tipo de elementos que deben implementar Comparable.
 * 
 */
import java.util.PriorityQueue;

public class PriorityQueueJCF<E> implements PriorityQueueInterface<E> {
    private PriorityQueue<E> queue;

    /**
     * Constructor que inicializa la cola.
     */
    public PriorityQueueJCF() {
        queue = new PriorityQueue<>();
    }

    /**
     * Agrega un valor a la cola de prioridad.
     * @param value Elemento a agregar.
     */
    @Override
    public void add(E value) {
        queue.add(value);
    }


    /**
     * Elimina y retorna un valor a la cola de prioridad.
     * @return Elemento removido, o null di esta vacia.
     */
    @Override
    public E remove() {
        return queue.poll(); 
    }

    /**
     * Verifica si la cola esta vacia
     * @return true si esta vacia, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    /**
     * Muestra el elemento con mayor prioridad sin removerlo 
     * @return Elemento al frente, o null si esta vacia
     */
    @Override
    public E peek() {
        return queue.peek();
    }

    /**
     * Retorna el numero de elementos 
     * @return tamanio de la cola.
     */
    @Override
    public int size() {
        return queue.size();
    }
}
