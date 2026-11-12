import java.util.ArrayList;

/*
 * CASO DE USO:
 * Un explorador de archivos organiza las carpetas de forma jerárquica.
 * - Existe una carpeta RAÍZ de la que cuelgan otras carpetas (sus hijos).
 * - Cada carpeta puede tener subcarpetas, y estas a su vez más subcarpetas.
 * - Se puede AGREGAR una carpeta dentro de otra (agregarHijo).
 * - Se puede MOSTRAR toda la estructura con sangría (recorrido recursivo).
 * - Se puede BUSCAR una carpeta por nombre y contar cuántas hay en total.
 *
 * ¿Por qué un árbol?
 * Un árbol representa datos con relación padre-hijo. Cada elemento (nodo)
 * tiene un solo padre y puede tener varios hijos. Java no trae una clase
 * "Arbol" lista para usar, así que lo construimos con una clase Nodo.
 * Lo mismo aplica para menús desplegables, organigramas, categorías, etc.
 */
public class arboles {

    // Cada nodo del árbol es una carpeta con un nombre y una lista de hijos
    static class Carpeta {
        String nombre;
        ArrayList<Carpeta> hijos = new ArrayList<>();

        Carpeta(String nombre) {
            this.nombre = nombre;
        }

        // Agrega una subcarpeta dentro de esta carpeta
        void agregarHijo(Carpeta hijo) {
            hijos.add(hijo);
        }

        // Recorrido recursivo: muestra esta carpeta y luego todos sus hijos.
        // "nivel" controla cuánta sangría se imprime (qué tan profundo está).
        void mostrar(int nivel) {
            System.out.println("  ".repeat(nivel) + "📁 " + nombre);
            for (Carpeta hijo : hijos) {
                hijo.mostrar(nivel + 1);
            }
        }

        // Cuenta cuántas carpetas hay en total desde este nodo hacia abajo
        int contar() {
            int total = 1; // esta carpeta
            for (Carpeta hijo : hijos) {
                total += hijo.contar();
            }
            return total;
        }

        // Busca una carpeta por nombre en todo el árbol (devuelve null si no existe)
        Carpeta buscar(String buscado) {
            if (nombre.equals(buscado)) {
                return this;
            }
            for (Carpeta hijo : hijos) {
                Carpeta encontrada = hijo.buscar(buscado);
                if (encontrada != null) {
                    return encontrada;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {

        // Creamos las carpetas (nodos)
        Carpeta raiz = new Carpeta("Mis Documentos");
        Carpeta trabajo = new Carpeta("Trabajo");
        Carpeta estudio = new Carpeta("Estudio");
        Carpeta fotos = new Carpeta("Fotos");

        // Armamos la jerarquía: raíz -> hijos
        raiz.agregarHijo(trabajo);
        raiz.agregarHijo(estudio);
        raiz.agregarHijo(fotos);

        // Segundo nivel: subcarpetas dentro de Trabajo y Estudio
        trabajo.agregarHijo(new Carpeta("Informes"));
        trabajo.agregarHijo(new Carpeta("Facturas"));
        estudio.agregarHijo(new Carpeta("Java"));
        estudio.agregarHijo(new Carpeta("Bases de Datos"));

        // Tercer nivel: una subcarpeta dentro de Java
        Carpeta java = estudio.buscar("Java");
        java.agregarHijo(new Carpeta("Ejercicios"));

        // Mostramos toda la estructura
        System.out.println("Estructura de carpetas:");
        raiz.mostrar(0);

        // Contamos todas las carpetas
        System.out.println("\nTotal de carpetas: " + raiz.contar());

        // Buscamos una carpeta por nombre
        Carpeta resultado = raiz.buscar("Facturas");
        if (resultado != null) {
            System.out.println("Se encontró la carpeta: " + resultado.nombre);
        }

        if (raiz.buscar("Música") == null) {
            System.out.println("La carpeta 'Música' no existe.");
        }
    }
}