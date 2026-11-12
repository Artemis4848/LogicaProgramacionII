import java.util.HashSet;
import java.util.Set;

/*
 * CASO DE USO:
 * Un evento registra a los asistentes que entran por la puerta.
 * Una misma persona puede pasar el lector de entradas varias veces,
 * pero en la lista de asistentes debe aparecer UNA sola vez.
 * - Se puede AGREGAR un asistente (add). Si ya estaba, no se duplica.
 * - add() devuelve true si se agregó y false si ya existía,
 *   lo que permite detectar repetidos.
 * - Se puede verificar si alguien ya está registrado (contains).
 * - Se puede ELIMINAR a un asistente (remove).
 * - Se pueden comparar dos conjuntos: unión, intersección y diferencia.
 *
 * ¿Por qué un conjunto (Set)?
 * Un Set guarda elementos SIN REPETIR. Si intentas agregar uno que ya
 * existe, simplemente se ignora. Además, HashSet verifica si un elemento
 * está (contains) casi al instante, igual que un HashMap.
 * A diferencia de una lista, no tiene posiciones: no existe get(0).
 * Tampoco garantiza el orden de los elementos.
 */
public class conjuntos {

    public static void main(String[] args) {

        // Creamos el conjunto de asistentes (vacío al inicio)
        Set<String> asistentes = new HashSet<>();

        // add(): registrar asistentes
        asistentes.add("Ana");
        asistentes.add("Luis");
        asistentes.add("Marta");
        System.out.println("Asistentes: " + asistentes);

        // add() con un elemento repetido: no se agrega y devuelve false
        boolean agregado = asistentes.add("Ana");
        System.out.println("¿Se agregó Ana otra vez? " + agregado);
        System.out.println("Asistentes (sin duplicados): " + asistentes);

        // size(): cantidad de asistentes distintos
        System.out.println("Total de asistentes: " + asistentes.size());

        // contains(): verificar si alguien ya está registrado
        if (asistentes.contains("Luis")) {
            System.out.println("Luis ya está registrado.");
        }

        // remove(): eliminar a un asistente
        asistentes.remove("Marta");
        System.out.println("Después de eliminar a Marta: " + asistentes);

        // OPERACIONES ENTRE CONJUNTOS
        // Imaginemos que el evento tiene dos días y queremos comparar asistentes
        Set<String> dia1 = new HashSet<>();
        dia1.add("Ana");
        dia1.add("Luis");
        dia1.add("Carlos");

        Set<String> dia2 = new HashSet<>();
        dia2.add("Luis");
        dia2.add("Carlos");
        dia2.add("Sofía");

        // Unión: todas las personas que fueron algún día (sin repetir)
        Set<String> union = new HashSet<>(dia1);
        union.addAll(dia2);
        System.out.println("\nFueron al menos un día: " + union);

        // Intersección: personas que fueron los dos días
        Set<String> ambosDias = new HashSet<>(dia1);
        ambosDias.retainAll(dia2);
        System.out.println("Fueron los dos días: " + ambosDias);

        // Diferencia: personas que fueron solo el día 1
        Set<String> soloDia1 = new HashSet<>(dia1);
        soloDia1.removeAll(dia2);
        System.out.println("Fueron solo el día 1: " + soloDia1);

        // Recorrer el conjunto con for-each
        System.out.println("\nLista final de asistentes del día 1:");
        for (String persona : dia1) {
            System.out.println(" - " + persona);
        }

        // isEmpty(): saber si el conjunto está vacío
        System.out.println("¿Conjunto vacío? " + asistentes.isEmpty());
    }
}