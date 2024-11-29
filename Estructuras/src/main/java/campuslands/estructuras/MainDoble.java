package campuslands.estructuras;

public class MainDoble {

    public static void main(String[] args) {
         // Crear una lista doblemente enlazada de tipo Integer
        ListaDoble<Integer> lista = new ListaDoble<>();
        
        // Agregar elementos al inicio, al final y en una posición específica
        System.out.println("Agregando elementos al inicio:");
        lista.agregarInicio(10);
        lista.agregarInicio(5);
        lista.agregarInicio(3);
        lista.agregarInicio(1);
        lista.agregarInicio(7);
        lista.mostrarOrden(); 
        
        System.out.println("\nAgregando elementos al final:");
        lista.agregarFinal(15);
        lista.agregarFinal(20);
        lista.agregarFinal(25);
        lista.mostrarOrden(); 
        
        // Insertar repetidos para demostrar la modificación múltiple
        System.out.println("\nInsertando valores repetidos (10, 10, 25):");
        lista.agregarFinal(10);
        lista.agregarFinal(10);
        lista.agregarFinal(25);
        lista.mostrarOrden(); 
        
        // **Prueba de modificación de múltiples elementos con el mismo valor**
        System.out.println("\nModificando todos los 10 por 30 (sustitución de todos):");
        lista.modificarDato(10, 30, true); 
        lista.mostrarOrden(); 
        
        System.out.println("\nModificando todos los 25 por 50 (sustitución de todos):");
        lista.modificarDato(25, 50, true); 
        lista.mostrarOrden(); 
        
        // Mostrar tamaño de la lista
        System.out.println("\nTamaño de la lista:");
        lista.mostrarTamano(); 
        
        // Eliminar un elemento por su posición
        System.out.println("\nEliminando el elemento en la posición 1:");
        lista.eliminarPosicion(1);
        lista.mostrarOrden(); 
        
        // Eliminar un elemento por su valor
        System.out.println("\nEliminando el valor 30:");
        lista.eliminarDato(30);
        lista.mostrarOrden(); 
        
        // **Manejo de errores:**
        System.out.println("\nEliminando un valor que no existe (valor 100):");
        lista.eliminarDato(100); 
        
        // Modificar un elemento por su posición
        System.out.println("\nModificando el elemento en la posición 2 (nuevo valor 40):");
        lista.modificarPosicion(2, 40);
        lista.mostrarOrden(); 
        
        // Modificar un elemento por su valor
        System.out.println("\nModificando el valor 15 por 60 (solo el primer dato):");
        lista.modificarDato(15, 60, false);
        lista.mostrarOrden(); 
        
        // Modificar un elemento por su valor con sustitución de todos los valores
        System.out.println("\nModificando todos los 50 por 70:");
        lista.modificarDato(50, 70, true);
        lista.mostrarOrden(); 
        
        // **Manejo de errores:**
        System.out.println("\nModificando un valor que no existe (valor 100):");
        lista.modificarDato(100, 50, false); // Esperado: "Dato no encontrado"
        
        // Ordenar la lista
        System.out.println("\nOrdenando la lista:");
        lista.ordenar(); 
        
        // Mostrar la lista en orden inverso
        System.out.println("\nMostrando la lista en orden inverso:");
        lista.mostrarTamano();
        lista.mostrarInverso(); 
    }
    
}
