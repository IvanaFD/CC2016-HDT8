import java.util.List;
import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 *
 * Clase Main
 * Controla la ejecucion del programa
 */

public class Main {
    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in);
        PriorityQueueInterface<Patient> queue = null;
        System.out.println("Bienvenidos al sistema de pacientes");
        System.out.println("Seleccione la implementacion de cola de prioridad que utilizara");
        System.out.println("1. Vector Heap");
        System.out.println("2. Priority Queue JCF");

        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            System.out.println("opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        //Se usa el factory para seleccionar la implementacion que quiere la persona
        if (opcion == 1) {
            queue = PriorityQueueFactory.getPriorityQueue(PriorityQueueFactory.ImplementationType.VECTOR_HEAP);
            System.out.println("\nSe eligio VectorHeap.");
        } else {
            queue = PriorityQueueFactory.getPriorityQueue(PriorityQueueFactory.ImplementationType.JCF);
            System.out.println("\nSe eligio PriorityQueue JCF.");
        }

        List<Patient> patients = DocumentController.loadPatients("paciente.txt");
        for (Patient p : patients) {
            queue.add(p);
        }

        System.out.println("\nPacientes cargados: " + queue.size() + "\n");

        while (!queue.isEmpty()) {
            System.out.println("Paciente con mayor prioridad:");
            System.out.println(queue.peek());

            System.out.println("\n1. Atender paciente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                Patient atendido = queue.remove();
                System.out.println("Paciente atendido: " + atendido + "\n");
            } else if (choice == 0) {
                System.out.println("Saliendo del sistema...");
                break;
            }
        }

        if (queue.isEmpty()) {
            System.out.println("Todos los pacientes han sido atendidos.");
        }

        scanner.close();
    }
}