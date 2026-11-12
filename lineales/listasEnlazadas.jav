import java.util.LinkedList;

/*
 * CASO DE USO:
 * Un reproductor de música maneja la lista de reproducción (playlist).
 * - Se pueden AGREGAR canciones al final (addLast) o al inicio (addFirst).
 * - Se puede INSERTAR una canción en una posición intermedia (add con índice).
 * - Al reproducir, se SACA la primera canción de la lista (removeFirst).
 * - Se puede ELIMINAR una canción específica (remove).
 *
 * ¿Por qué una lista enlazada (LinkedList)?
 * Cada elemento guarda una referencia al siguiente (y al anterior),
 * por lo que insertar o eliminar al inicio o al final es muy rápido
 * y no hay que desplazar todos los demás elementos como en un ArrayList.
 */
public class listasEnlazadas {

    public static void main(String[] args) {

        // Creamos la playlist (vacía al inicio)
        LinkedList<String> playlist = new LinkedList<>();

        // addLast() / add(): agregar canciones al final
        playlist.addLast("Canción A");
        playlist.addLast("Canción B");
        playlist.addLast("Canción C");
        System.out.println("Playlist inicial: " + playlist);

        // addFirst(): agregar una canción al inicio (para que suene primero)
        playlist.addFirst("Canción Intro");
        System.out.println("Con intro al inicio: " + playlist);

        // add(índice, elemento): insertar en una posición intermedia
        playlist.add(2, "Canción Sorpresa");
        System.out.println("Con sorpresa en la posición 2: " + playlist);

        // getFirst() / getLast(): ver el primero y el último sin quitarlos
        System.out.println("Suena ahora: " + playlist.getFirst());
        System.out.println("Última de la lista: " + playlist.getLast());

        // removeFirst(): al terminar una canción, se saca de la lista
        String reproducida = playlist.removeFirst();
        System.out.println("Terminó de sonar: " + reproducida);
        System.out.println("Playlist ahora: " + playlist);

        // remove(objeto): eliminar una canción específica
        playlist.remove("Canción B");
        System.out.println("Sin la Canción B: " + playlist);

        // Recorrer la lista con for-each
        System.out.println("Próximas canciones:");
        for (String cancion : playlist) {
            System.out.println(" - " + cancion);
        }

        // size(): cantidad de canciones restantes
        System.out.println("Canciones restantes: " + playlist.size());
    }
}