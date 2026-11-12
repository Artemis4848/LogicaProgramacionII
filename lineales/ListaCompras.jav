import java.util.ArrayList;

/*
 * CASO DE USO:
 * Una persona quiere armar su lista de compras del supermercado.
 * - Puede AGREGAR productos a la lista (add).
 * - Puede ELIMINAR un producto si ya no lo necesita (remove).
 * - Puede ver cuántos productos tiene (size).
 * - Puede verificar si un producto ya está en la lista (contains).
 * La lista cambia de tamaño dinámicamente, que es la gran ventaja
 * de un ArrayList frente a un array normal.
 */
public class listaCompras {

    public static void main(String[] args) {

        // Creamos la lista de compras (vacía al inicio)
        ArrayList<String> compras = new ArrayList<>();

        // add(): agregar productos al final de la lista
        compras.add("Leche");
        compras.add("Pan");
        compras.add("Huevos");
        compras.add("Arroz");
        System.out.println("Lista inicial: " + compras);

        // size(): cantidad de elementos
        System.out.println("Total de productos: " + compras.size());

        // contains(): verificar si un producto ya está
        if (compras.contains("Pan")) {
            System.out.println("El pan ya está en la lista, no lo agregamos de nuevo.");
        } else {
            compras.add("Pan");
        }

        // get(i): obtener un elemento por su posición (empieza en 0)
        System.out.println("Primer producto: " + compras.get(0));

        // remove(): eliminar un producto (por valor o por posición)
        compras.remove("Huevos");  // por valor
        compras.remove(0);         // por posición (quita "Leche")
        System.out.println("Después de eliminar: " + compras);

        // Recorrer la lista con for-each
        System.out.println("Productos pendientes:");
        for (String producto : compras) {
            System.out.println(" - " + producto);
        }

        // isEmpty(): saber si la lista quedó vacía
        System.out.println("¿Lista vacía? " + compras.isEmpty());
    }
}