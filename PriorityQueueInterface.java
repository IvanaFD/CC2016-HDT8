
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 * Clase PriorityQueueInterface
 * Interfaz para una cola de prioridad génerica
 * 
 * se utilizo en las dos implementaciones usadas en el programa
 * @param <E> Tipo de elementos en la cola.
 */


public interface PriorityQueueInterface<E> {

    void add(E value);
    E remove();
    E peek();
    boolean isEmpty();
    int size();
}