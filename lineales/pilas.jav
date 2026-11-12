import java.util.Stack;

/*
 * CASO DE USO:
 * Un editor de texto tiene la función "Deshacer" (Ctrl + Z).
 * - Cada vez que el usuario escribe algo, la acción se GUARDA en la pila (push).
 * - Al presionar "Deshacer", se SACA la última acción realizada (pop).
 * - Se puede VER cuál fue la última acción sin quitarla (peek).
 * - Si la pila está vacía, no hay nada más que deshacer (isEmpty).
 *
 * ¿Por qué una pila (Stack)?
 * Funciona con la regla LIFO (Last In, First Out): lo último que entra
 * es lo primero que sale. Justo lo que necesitamos para deshacer:
 * siempre se deshace primero la acción más reciente.
 */
public class pilas {

    public static void main(String[] args) {

        // Creamos la pila donde guardaremos el historial de acciones
        Stack<String> historial = new Stack<>();

        // push(): el usuario realiza acciones, cada una entra en la cima de la pila
        historial.push("Escribió: Hola");
        historial.push("Escribió: Mundo");
        historial.push("Aplicó negrita");
        historial.push("Escribió: !!!");
        System.out.println("Historial de acciones: " + historial);

        // size(): cuántas acciones se pueden deshacer
        System.out.println("Acciones guardadas: " + historial.size());

        // peek(): ver la última acción SIN quitarla de la pila
        System.out.println("Última acción realizada: " + historial.peek());

        // pop(): el usuario presiona "Deshacer", se quita la acción de la cima
        String deshecha = historial.pop();
        System.out.println("Deshaciendo -> " + deshecha);

        deshecha = historial.pop();
        System.out.println("Deshaciendo -> " + deshecha);

        System.out.println("Historial ahora: " + historial);

        // isEmpty() + pop(): deshacer todo lo que quede, hasta vaciar la pila
        while (!historial.isEmpty()) {
            System.out.println("Deshaciendo -> " + historial.pop());
        }

        // Siempre se verifica que la pila no esté vacía antes de hacer pop(),
        // porque si está vacía lanza un error (EmptyStackException)
        if (historial.isEmpty()) {
            System.out.println("No hay más acciones para deshacer.");
        }
    }
}