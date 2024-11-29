package campuslands.estructuras;

public class MainPila {

    public static void main(String[] args) {
        // Crear una pila de tipo Double
        Pila<Double> pila = new Pila<>();

        // 1. Intentar usar los métodos en una pila vacía
        System.out.println("Pruebas con la pila vacía:");
        System.out.println("Buscar posición 0 en la pila vacía:");
        System.out.println(pila.buscarPosicion(0));  // Debería mostrar mensaje de error

        System.out.println("Buscar dato 5.5 en la pila vacía:");
        System.out.println(pila.buscarDato(5.5));  // Debería mostrar mensaje de error

        System.out.println("Eliminar de la pila vacía:");
        System.out.println(pila.eliminar());  // Debería mostrar mensaje de error

        // 2. Agregar elementos desordenados a la pila
        System.out.println("\nAgregando elementos desordenados a la pila...");
        pila.agregar(7.8);
        pila.agregar(2.3);
        pila.agregar(5.5);
        pila.agregar(1.2);
        pila.agregar(9.6);
        pila.agregar(3.1);
        pila.agregar(4.4);
        pila.agregar(8.9);
        pila.agregar(6.7);

        // Mostrar la pila antes de ordenar
        System.out.println("\nPila antes de ordenar:");
        pila.mostrarPila();  // Debería mostrar los elementos en el orden en que fueron agregados

        // 3. Ordenar la pila
        System.out.println("\nOrdenando la pila...");
        pila.ordenar();

        // Mostrar la pila después de ordenar
        System.out.println("\nPila después de ordenar:");
        pila.mostrarPila();  // Debería mostrar los elementos ordenados

        // 4. Mostrar tamaño de la pila
        System.out.println("\nTamaño de la pila después de ordenar: " + pila.mostrarTamano());  // Debería mostrar: 9

        // 5. Buscar un elemento por su posición (por ejemplo, la posición 4)
        System.out.println("\nBuscando el elemento en la posición 4...");
        Double elementoPosicion = pila.buscarPosicion(4);  // Debería devolver el valor en la posición 4
        System.out.println("Elemento en la posición 4: " + elementoPosicion);

        // 6. Buscar un dato en la pila (por ejemplo, 5.5)
        System.out.println("\nBuscando el dato 5.5 en la pila...");
        int posicion = pila.buscarDato(5.5);  // Debería devolver la posición del 5.5
        if (posicion != -1) {
            System.out.println("El dato 5.5 se encuentra en la posición: " + posicion);
        }

        // 7. Intentar eliminar de la pila
        System.out.println("\nEliminando un elemento de la pila...");
        Double eliminado = pila.eliminar();
        System.out.println("Elemento eliminado: " + eliminado);  // Debería eliminar el último agregado (6.7)
        pila.mostrarPila();  // Debería mostrar el resto de los elementos

        // 8. Vaciar la lista
        System.out.println("\nVaciando la lista...");
        pila.vaciar();

        // 9. Verificar el comportamiento al buscar por posición en una pila vacía
        System.out.println("\nBuscando un elemento en la posición 0 en la pila vacía...");
        Double elementoVacio = pila.buscarPosicion(0);  // Debería devolver null
        System.out.println(elementoVacio);
        
    } 
}
