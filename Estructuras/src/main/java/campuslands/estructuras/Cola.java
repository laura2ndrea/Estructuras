package campuslands.estructuras;
import java.util.Arrays;

public class Cola<T extends Comparable<T>> {
    private NodoPC<T> frente;
    private NodoPC<T> finalCola;
    private int tamano;

    public Cola(){
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    // Método para agregar un elemento al final de la cola
    public void agregar(T dato){
        NodoPC<T> nuevoNodo = new NodoPC<>(dato);
        if (finalCola == null) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        tamano++;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia(){
        return frente == null;
    }

    // Método para eliminar un elemento desde el frente de la cola
    public T eliminar(){
        if (estaVacia()){
            System.out.println("La cola no tiene elementos");
            return null;
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            finalCola = null;
        }
        tamano--;
        return dato;
    }

    // Método para vaciar la cola
    public void vaciar(){
        if (estaVacia()){
            System.out.println("La cola ya está vacía");
            return;
        }
        while (!estaVacia()){
            eliminar();
        }
    }

    // Método para mostrar el elemento al frente de la cola
    public T mostrar(){
        if (estaVacia()){
            System.out.println("La cola no tiene elementos");
            return null;
        }
        return frente.getDato();
    }

    // Método para obtener el tamaño de la cola
    public int mostrarTamano(){
        return tamano;
    }

    // Método para mostrar todos los elementos de la cola
    public void mostrarCola(){
        if (estaVacia()){
            System.out.println("La cola está vacía");
            return;
        }
        NodoPC<T> temp = frente;
        while (temp != null){
            System.out.print(temp.getDato() + " ");
            temp = temp.getSiguiente();
        }
        System.out.println();
    }

    // Método para buscar un elemento por su posición en la cola
    public T buscarPosicion(int posicion){
        if (frente == null){
            return null;
        }
        if (posicion < 0 || posicion >= tamano){
            System.out.println("Posición fuera del rango");
            return null;
        }
        NodoPC<T> temp = frente;
        for (int i = 0; i < posicion; i++){
            temp = temp.getSiguiente();
        }
        return temp.getDato();
    }

    // Método para buscar un dato en la cola
    public int buscarDato(T dato){
        NodoPC<T> temp = frente;
        int indice = 0;
        while (temp != null){
            if (temp.getDato().equals(dato)){
                return indice;
            }
            temp = temp.getSiguiente();
            indice++;
        }
        System.out.println("Dato no encontrado");
        return -1;
    }

    // Método para ordenar la cola
    public void ordenar(){
        if (estaVacia()){
            System.out.println("La cola está vacía");
            return;
        }

        Object[] arr = new Object[tamano];
        NodoPC<T> temp = frente;
        int i = 0;
        while (temp != null){
            arr[i++] = temp.getDato();
            temp = temp.getSiguiente();
        }

        Arrays.sort(arr);

        frente = null;
        finalCola = null;
        for (int j = 0; j < arr.length; j++){
            agregar((T) arr[j]);
        }
        tamano = arr.length; 
    }
}

