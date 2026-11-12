import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * CASO DE USO:
 * Una red social conecta personas que son amigas entre sí.
 * - Cada persona es un NODO (o vértice) del grafo.
 * - Cada amistad es una CONEXIÓN (o arista) entre dos nodos.
 * - Se puede AGREGAR una persona y CONECTARLA con otra (amistad mutua).
 * - Se puede MOSTRAR los amigos directos de cada persona.
 * - Se pueden encontrar los AMIGOS EN COMÚN entre dos personas.
 * - Se puede calcular a cuántos "saltos" está una persona de otra
 *   (grados de separación), usando un recorrido en anchura (BFS).
 *
 * ¿Por qué un grafo?
 * A diferencia del árbol, en un grafo no hay jerarquía de padre e hijos:
 * cualquier nodo puede conectarse con cualquier otro, y puede haber ciclos
 * (Ana es amiga de Luis, Luis de Marta y Marta de Ana).
 * Sirve para redes sociales, mapas de rutas, redes de computadores, etc.
 *
 * Java no trae una clase "Grafo", así que lo representamos con una
 * LISTA DE ADYACENCIA: un mapa donde cada persona tiene la lista de sus amigos.
 */
public class grafo {

    // Clave: nombre de la persona. Valor: lista de sus amigos directos.
    static class RedSocial {
        Map<String, ArrayList<String>> amigos = new HashMap<>();

        // Agrega una persona a la red (sin amigos al inicio)
        void agregarPersona(String nombre) {
            amigos.putIfAbsent(nombre, new ArrayList<>());
        }

        // Conecta a dos personas. La amistad es mutua, por eso se agrega en ambos sentidos.
        void conectar(String a, String b) {
            agregarPersona(a);
            agregarPersona(b);
            amigos.get(a).add(b);
            amigos.get(b).add(a);
        }

        // Muestra cada persona con sus amigos directos
        void mostrar() {
            for (String persona : amigos.keySet()) {
                System.out.println(persona + " -> " + amigos.get(persona));
            }
        }

        // Amigos en común: personas que están en la lista de ambos
        ArrayList<String> amigosEnComun(String a, String b) {
            ArrayList<String> comunes = new ArrayList<>(amigos.get(a));
            comunes.retainAll(amigos.get(b)); // se queda solo con los que están en ambas listas
            return comunes;
        }

        // Recorrido en anchura (BFS): calcula cuántos saltos hay entre dos personas.
        // Primero visita a los amigos directos, luego a los amigos de los amigos, etc.
        // Devuelve -1 si no hay ninguna conexión entre ellas.
        int gradosDeSeparacion(String origen, String destino) {
            if (origen.equals(destino)) {
                return 0;
            }

            Queue<String> porVisitar = new LinkedList<>();
            Map<String, Integer> distancia = new HashMap<>(); // también sirve como "ya visitados"

            porVisitar.offer(origen);
            distancia.put(origen, 0);

            while (!porVisitar.isEmpty()) {
                String actual = porVisitar.poll();

                for (String vecino : amigos.get(actual)) {
                    if (!distancia.containsKey(vecino)) { // si aún no lo visitamos
                        distancia.put(vecino, distancia.get(actual) + 1);

                        if (vecino.equals(destino)) {
                            return distancia.get(vecino);
                        }
                        porVisitar.offer(vecino);
                    }
                }
            }
            return -1; // no hay camino
        }
    }

    public static void main(String[] args) {

        RedSocial red = new RedSocial();

        // Creamos las amistades (conexiones entre nodos)
        red.conectar("Ana", "Luis");
        red.conectar("Ana", "Marta");
        red.conectar("Luis", "Marta");   // forma un ciclo: Ana - Luis - Marta - Ana
        red.conectar("Luis", "Carlos");
        red.conectar("Carlos", "Sofía");

        // Una persona nueva sin ninguna conexión todavía
        red.agregarPersona("Pedro");

        // Mostramos toda la red
        System.out.println("Red de amistades:");
        red.mostrar();

        // Amigos en común entre dos personas
        System.out.println("\nAmigos en común entre Ana y Carlos: "
                + red.amigosEnComun("Ana", "Carlos"));

        // Grados de separación (cuántos saltos hay entre dos personas)
        System.out.println("Ana -> Marta: " + red.gradosDeSeparacion("Ana", "Marta") + " salto(s)");
        System.out.println("Ana -> Sofía: " + red.gradosDeSeparacion("Ana", "Sofía") + " salto(s)");

        // Pedro no está conectado con nadie
        int resultado = red.gradosDeSeparacion("Ana", "Pedro");
        if (resultado == -1) {
            System.out.println("Ana y Pedro no tienen ninguna conexión.");
        }
    }
}