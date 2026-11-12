import java.util.HashMap;
import java.util.Map;

/*
 * CASO DE USO:
 * Una tienda guarda el inventario de sus productos.
 * - Cada producto tiene un CÓDIGO único (la clave) y una CANTIDAD en stock (el valor).
 * - Se puede AGREGAR un producto nuevo al inventario (put).
 * - Se puede CONSULTAR la cantidad de un producto por su código (get),
 *   sin tener que recorrer toda la lista.
 * - Se puede ACTUALIZAR la cantidad cuando se vende o llega mercancía (put sobre una clave existente).
 * - Se puede verificar si un producto existe (containsKey) y ELIMINARLO (remove).
 * - Se puede RECORRER todo el inventario (entrySet).
 *
 * ¿Por qué un mapa (HashMap)?
 * Guarda pares clave -> valor. Gracias a una función hash, encuentra
 * un valor a partir de su clave casi al instante, sin importar si hay
 * 10 o 10 millones de elementos. En una lista tendrías que revisar
 * elemento por elemento hasta encontrarlo.
 * Las claves no se pueden repetir: si usas put con una clave que ya
 * existe, simplemente se reemplaza su valor.
 */
public class hashMap {

    public static void main(String[] args) {

        // Clave: código del producto (String). Valor: cantidad en stock (Integer).
        Map<String, Integer> inventario = new HashMap<>();

        // put(): agregar productos (clave, valor)
        inventario.put("A001", 50);   // Arroz
        inventario.put("B002", 30);   // Leche
        inventario.put("C003", 100);  // Pan
        inventario.put("D004", 20);   // Huevos
        System.out.println("Inventario inicial: " + inventario);

        // size(): cantidad de productos distintos
        System.out.println("Productos registrados: " + inventario.size());

        // get(): buscar por clave (búsqueda directa y muy rápida)
        System.out.println("Stock del producto B002: " + inventario.get("B002"));

        // put() con una clave que ya existe: actualiza el valor
        // Se vendieron 10 unidades de Pan
        inventario.put("C003", inventario.get("C003") - 10);
        System.out.println("Stock de C003 después de vender 10: " + inventario.get("C003"));

        // getOrDefault(): evita null si la clave no existe
        System.out.println("Stock de Z999 (no existe): " + inventario.getOrDefault("Z999", 0));

        // containsKey(): verificar si un producto está registrado
        if (inventario.containsKey("D004")) {
            System.out.println("El producto D004 sí está en el inventario.");
        }

        // remove(): eliminar un producto por su clave
        inventario.remove("D004");
        System.out.println("Después de eliminar D004: " + inventario);

        // Recorrer el mapa con for-each sobre entrySet()
        System.out.println("Detalle del inventario:");
        for (Map.Entry<String, Integer> producto : inventario.entrySet()) {
            System.out.println(" - Código " + producto.getKey()
                    + ": " + producto.getValue() + " unidades");
        }

        // isEmpty(): saber si el mapa está vacío
        System.out.println("¿Inventario vacío? " + inventario.isEmpty());
    }
}