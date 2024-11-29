package campuslands.estructuras;
import java.util.Arrays;

public class Pila<T extends Comparable<T>> {
    private NodoPC<T> cima;
    private int tamano; 
    
    public Pila(){
        cima = null; 
        tamano = 0; 
    }
    
    // Método para agregar un elemento a la pila (en la cima)
    public void agregar(T dato){
        NodoPC<T> nuevoNodo = new NodoPC<>(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo; 
        tamano++;
    }
    
    //Método para verificar si la pila esta vacio
    public boolean estaVacia(){
        return cima == null; 
    }
    
    // Método para eliminar un elemento 
    public T eliminar(){
        if(estaVacia()){
            System.out.println("La pila no tiene elementos");
            return null; 
        }
        T dato = cima.getDato(); 
        cima = cima.getSiguiente();
        tamano--;
        return dato; 
    }
    
    // Método para vaciar la lista
    public void vaciar(){
        if(estaVacia()){
            System.out.println("La pila ya esta vacia");
            return; 
        }
        while (!estaVacia()){
            eliminar();
        }
    }
    
    // Metodo para mostrar el elemento en la cima
    public T mostrar(){
        if (estaVacia()){
            System.out.println("La pila no tiene elementos");
            return null; 
        }
        return cima.getDato();
    }
    
    // Método para obtener el tamaño de la lista
    public int mostrarTamano(){
        return tamano; 
    }
    
    // Método para mostrar todos los elementos de la pila 
    public void mostrarPila(){
        if(estaVacia()){
            System.out.println("La pila esta vacia");
            return; 
        }
        NodoPC<T> temp = cima; 
        while (temp != null){
            System.out.print(temp.getDato() + " ");
            temp = temp.getSiguiente(); 
        }
        System.out.println();
    }
    
    // Método para buscar un elemento por su posición en la pila
    public T buscarPosicion(int posicion){
        if (cima == null){
            return null;
        }
        if (posicion < 0 || posicion >= tamano){
            System.out.println("Posición fuera del rango");
            return null; 
        }
        NodoPC<T> temp = cima; 
        for (int i = 0; i < posicion; i++){
            temp = temp.getSiguiente();
        }
        return temp.getDato();
    }
    
    // Método para buscar un elemento por el dato
    public int buscarDato (T dato){
        NodoPC<T> temp = cima; 
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
    
    // Método para ordenar la lista
    public void ordenar(){
        if (estaVacia()){
            System.out.println("La pila esta vacia");
            return; 
        }
        
        Object[] arr = new Object[tamano];
        NodoPC<T> temp = cima; 
        int i = 0; 
        
        while (temp != null){
            arr[i++] = temp.getDato();
            temp = temp.getSiguiente();
        }
        
        Arrays.sort(arr);
        
        cima = null; 
        for (int j = arr.length - 1; j >= 0; j--){
            agregar((T) arr[j]);
        }
        tamano = arr.length; 
       
    }
}
