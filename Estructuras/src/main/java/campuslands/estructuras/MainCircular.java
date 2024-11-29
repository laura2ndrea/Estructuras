/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campuslands.estructuras;

/**
 *
 * @author ACER
 */
public class MainCircular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Crear una lista circular de Personas
        ListaCircular<Persona> lista = new ListaCircular<>();

        // Agregar elementos
        System.out.println("Agregando elementos a la lista...");
        lista.agregarPosicion(new Persona("Laura", 25), 0);
        lista.agregarPosicion(new Persona("Carlos", 30), 1);
        lista.agregarPosicion(new Persona("Ana", 20), 2);
        lista.agregarPosicion(new Persona("Miguel", 35), 1); // Entre Laura y Carlos
        lista.mostrarOrden();

        // Buscar elementos por posición
        System.out.println("\nBuscando elementos por posición:");
        lista.buscarPosicion(0); // Laura
        lista.buscarPosicion(2); // Miguel
        lista.buscarPosicion(5); // Error (fuera de rango)

        // Buscar elementos por valor
        System.out.println("\nBuscando elementos por valor:");
        lista.buscarDato(new Persona("Ana", 20)); // Debe encontrar el índice
        lista.buscarDato(new Persona("Luis", 40)); // No encontrado

        // Eliminar elementos por posición
        System.out.println("\nEliminando elementos por posición:");
        lista.eliminarPosicion(1); // Elimina Miguel
        lista.mostrarOrden();
        lista.eliminarPosicion(5); // Error (fuera de rango)

        // Eliminar elementos por valor
        System.out.println("\nEliminando elementos por valor:");
        lista.eliminarDato(new Persona("Carlos", 30));
        lista.mostrarOrden();
        lista.eliminarDato(new Persona("Luis", 40)); // No encontrado

        // Modificar elementos por posición
        System.out.println("\nModificando elementos por posición:");
        lista.modificarPosicion(1, new Persona("Juan", 28));
        lista.mostrarOrden();

        // Modificar elementos por valor
        System.out.println("\nModificando elementos por valor:");
        lista.modificarDato(new Persona("Laura", 25), new Persona("Sofia", 27), false); // Solo modifica el primero
        lista.mostrarOrden();
        lista.modificarDato(new Persona("Sofia", 27), new Persona("Maria", 26), true); // Modifica todos
        lista.mostrarOrden();

        // Ordenar la lista
        System.out.println("\nOrdenando la lista:");
        lista.ordenar();
        lista.mostrarOrden();
        lista.mostrarInverso();

        // Prueba con lista vacía
        System.out.println("\nPruebas con lista vacía:");
        ListaCircular<Persona> listaVacia = new ListaCircular<>();
        listaVacia.mostrarOrden();
        listaVacia.buscarPosicion(0);
        listaVacia.eliminarPosicion(0);
        listaVacia.eliminarDato(new Persona("Luis", 40));
    }
    
}
