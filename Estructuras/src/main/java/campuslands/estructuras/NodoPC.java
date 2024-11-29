package campuslands.estructuras;

public class NodoPC<T> {
    private T dato; 
    private NodoPC<T> siguiente;
    
    public NodoPC(T dato){
        this.dato = dato; 
        this.siguiente = null; 
    }
    
    public T getDato(){
        return dato;
    }
    
    public void setDato(T dato){
        this.dato = dato; 
    }
    
    public NodoPC<T> getSiguiente(){
        return siguiente; 
    }
    
    public void setSiguiente(NodoPC<T> siguiente){
        this.siguiente = siguiente; 
    }
}
