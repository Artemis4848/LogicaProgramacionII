import java.util.LinkedList;
import java.util.Queue;

/*
 * CASO DE USO:
 * Una clínica atiende a sus pacientes por orden de llegada.
 * - Cuando llega un paciente, se pone al FINAL de la fila (offer / add).
 * - Cuando el doctor queda libre, atiende al que está al FRENTE de la fila (poll / remove).
 * - Se puede VER quién es el siguiente sin sacarlo de la fila (peek).
 * - Se puede saber cuántas personas están esperando (size) y si la fila está vacía (isEmpty).
 *
 * ¿Por qué una cola (Queue)?
 * Funciona con la regla FIFO (First In, First Out): el primero que entra
 * es el primero que sale. Es lo justo para una fila de espera:
 * nadie se salta a los que llegaron antes.
 */
public class colas {

    public static void main(String[] args) {

        // Creamos la cola (fila de espera). Queue es una interfaz,
        // y LinkedList es una de las clases que la implementan.
        Queue<String> filaPacientes = new LinkedList<>();

        // offer(): los pacientes llegan y se ponen al final de la fila
        filaPacientes.offer("Ana");
        filaPacientes.offer("Carlos");
        filaPacientes.offer("Marta");
        filaPacientes.offer("Luis");
        System.out.println("Fila de espera: " + filaPacientes);

        // size(): cuántas personas están esperando
        System.out.println("Pacientes esperando: " + filaPacientes.size());

        // peek(): ver quién sigue SIN sacarlo de la fila
        System.out.println("Siguiente en ser atendido: " + filaPacientes.peek());

        // poll(): el doctor atiende al primero y este sale de la fila
        String atendido = filaPacientes.poll();
        System.out.println("Atendiendo a: " + atendido);
        System.out.println("Fila ahora: " + filaPacientes);

        // Llega un nuevo paciente, se va al final de la fila
        filaPacientes.offer("Sofía");
        System.out.println("Llegó Sofía. Fila: " + filaPacientes);

        // isEmpty() + poll(): atender a todos hasta vaciar la fila
        while (!filaPacientes.isEmpty()) {
            System.out.println("Atendiendo a: " + filaPacientes.poll());
        }

        // Si la cola está vacía, poll() y peek() devuelven null (no lanzan error)
        if (filaPacientes.isEmpty()) {
            System.out.println("No hay más pacientes en espera.");
        }
    }
}