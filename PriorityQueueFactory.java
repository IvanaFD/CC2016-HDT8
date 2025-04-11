
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 * Clase PriorityQueue
 * permite seleccionar entre los dos tipos de implementación que hay
 */


public class PriorityQueueFactory {
    public enum ImplementationType {
        VECTOR_HEAP,
        JCF
    }

    /**
     * Devuelve una implementacion de PriorityQueueInterface segun el tipo.
     * @param type Tipo de implementación a usar
     * @return Implementacion concreta de la cola de prioridad
     */
    public static PriorityQueueInterface<Patient> getPriorityQueue(ImplementationType type) {
        switch (type) {
            case VECTOR_HEAP:
                return new VectorHeap<>();
            case JCF:
                return new PriorityQueueJCF<>();
            default:
                throw new IllegalArgumentException("Tipo de implementación no válido.");
        }
    }
}
