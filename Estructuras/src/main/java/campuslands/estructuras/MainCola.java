package campuslands.estructuras;

public class MainCola {

    public static void main(String[] args) {
        // Crear una cola de tipo Persona
        Cola<Persona> cola = new Cola<>();

        // 1. Intentar usar los métodos en una cola vacía
        System.out.println("Pruebas con la cola vacía:");
        System.out.println("Buscar posición 0 en la cola vacía:");
        System.out.println(cola.buscarPosicion(0));  // Debería mostrar mensaje de error

        System.out.println("Buscar dato (persona) en la cola vacía:");
        System.out.println(cola.buscarDato(new Persona("Juan", 25)));  // Debería mostrar mensaje de error

        System.out.println("Eliminar de la cola vacía:");
        System.out.println(cola.eliminar());  // Debería mostrar mensaje de error

        // 2. Agregar objetos desordenados a la cola
        System.out.println("\nAgregando personas desordenadas a la cola...");
        cola.agregar(new Persona("Juan", 25));
        cola.agregar(new Persona("Ana", 22));
        cola.agregar(new Persona("Pedro", 30));
        cola.agregar(new Persona("Maria", 28));

        // Mostrar la cola antes de ordenar
        System.out.println("\nCola antes de ordenar:");
        cola.mostrarCola();  // Debería mostrar los elementos en el orden en que fueron agregados

        // 3. Ordenar la cola
        System.out.println("\nOrdenando la cola...");
        cola.ordenar();

        // Mostrar la cola después de ordenar
        System.out.println("\nCola después de ordenar:");
        cola.mostrarCola();  // Debería mostrar los elementos ordenados por edad

        // 4. Mostrar tamaño de la cola
        System.out.println("\nTamaño de la cola después de ordenar: " + cola.mostrarTamano());  // Debería mostrar: 4

        // 5. Buscar un elemento por su posición (por ejemplo, la posición 2)
        System.out.println("\nBuscando el elemento en la posición 2...");
        Persona personaPosicion = cola.buscarPosicion(2);  // Debería devolver el valor en la posición 2
        System.out.println("Persona en la posición 2: " + personaPosicion);

        // 6. Buscar un dato en la cola (por ejemplo, "Maria")
        System.out.println("\nBuscando la persona 'Maria' en la cola...");
        int posicion = cola.buscarDato(new Persona("Maria", 28));  // Debería devolver la posición de Maria
        if (posicion != -1) {
            System.out.println("La persona Maria se encuentra en la posición: " + posicion);
        }

        // 7. Intentar eliminar de la cola
        System.out.println("\nEliminando un elemento de la cola...");
        Persona eliminado = cola.eliminar();
        System.out.println("Elemento eliminado: " + eliminado);  // Debería eliminar el primero agregado (Juan)
        cola.mostrarCola();  // Debería mostrar el resto de los elementos

        // 8. Vaciar la cola
        System.out.println("\nVaciar la cola...");
        cola.vaciar();

        // 9. Verificar el comportamiento al buscar por posición en una cola vacía
        System.out.println("\nBuscando un elemento en la posición 0 en la cola vacía...");
        Persona personaVacia = cola.buscarPosicion(0);  // Debería devolver null
        if (personaVacia == null) {
            System.out.println("La cola está vacía, no hay elementos en la posición 0.");
        }
    }
    
}
