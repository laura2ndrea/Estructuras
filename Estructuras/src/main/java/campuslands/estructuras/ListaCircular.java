package campuslands.estructuras;

public class ListaCircular<T extends Comparable<T>> {
    private Nodo<T> cabeza;
    private int tamano; 
    
    public ListaCircular(){
        this.cabeza = null; 
        this.tamano = 0; 
    }
    
    // Método para mostrar el tamaño de la lista 
    public int getTamano(){
        return tamano; 
    }
    
    // Método para mostrar la lista en orden
    public void mostrarOrden(){
        if (cabeza != null){
            Nodo<T> actual = cabeza; 
            do {
                System.out.print(actual.dato + " ");
                actual = actual.getSiguiente();
            } while (actual != cabeza);
        }
        System.out.println();
    }
    
    // Método para mostrar la lista en orden inverso 
    public void mostrarInverso(){
        if (cabeza != null){
            Nodo<T> actual = cabeza.getAnterior();
            do {
                System.out.print(actual.getDato() + " ");
                actual = actual.getAnterior();
            } while (actual != cabeza.getAnterior());
        }   System.out.println();
    }
    
    // Método para agregar elementos al inicio de la lista
    public void agregarInicio(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null){
            cabeza = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(cabeza);
        } else {
            Nodo<T> ultimo = cabeza.getAnterior();
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            cabeza = nuevoNodo;
        }
        tamano++;
    }
    
    // Método para agregar elementos al final de la lista 
    public void agregarFinal(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null){
            cabeza = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(cabeza);
        } else {
            Nodo<T> ultimo = cabeza.getAnterior();
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            cabeza.setAnterior(nuevoNodo);
        }
        tamano++;
    }
    
    // Método para agregar elementos en un posición especifica 
    public void agregarPosicion(T dato, int posicion){
        if (posicion < 0 || posicion > tamano){
            System.out.println("Posición fuera del rango");
            return; 
        }
        // En el inicio de la lista
        if (posicion == 0) {
            agregarInicio(dato);
            return; 
        }
        
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++){
            actual = actual.getSiguiente();
        }
        Nodo<T> siguiente = actual.getSiguiente();
        nuevoNodo.setSiguiente(siguiente);
        nuevoNodo.setAnterior(actual);
        actual.setSiguiente(nuevoNodo);
        siguiente.setAnterior(nuevoNodo);
        tamano++;
    }
    
    // Método para buscar un elemento por la posición
   public void buscarPosicion (int posicion){
       if (posicion < 0 || posicion >= tamano){
           System.out.println("Posicion fuera del rango");
           return; 
       }
       
       Nodo<T> actual = cabeza; 
       int contador = 0; 
       
       // Recorrar la lista hasta llegar a la posicion
       while (contador < posicion){
           actual = actual.getSiguiente();
           contador++;
       }
       
       System.out.println(actual.getDato());
   }
    
    // Método para buscar un elemento por el dato
   public void buscarDato (T dato){
       if (cabeza == null){
           return;
       }
       Nodo<T> actual = cabeza; 
       int indice = 0; 
       boolean encontrado = false; 
       
       do {
           if (actual.getDato().equals(dato)){
               System.out.println(indice);
               encontrado = true; 
           }
           actual = actual.getSiguiente();
           indice++;
       } while (actual != cabeza);
       
       if (!encontrado){
           System.out.println("Dato no encontrado");
       }
   }
   
    // Método para eliminar un elemento por su posición
   public void eliminarPosicion (int posicion){
       if (cabeza == null){
           return; 
       }
       
       if (posicion < 0 || posicion >= tamano){
           System.out.println("Posición fuera del rango");
           return; 
       }
       
       Nodo<T> actual = cabeza;
       // En caso de que se deba eliminar la cabeza
       if (posicion == 0){
           if (tamano == 1){
               cabeza = null; 
           }else {
               Nodo<T> ultimo = cabeza.getAnterior();
               cabeza = cabeza.getSiguiente();
               cabeza.setAnterior(ultimo);
               ultimo.setSiguiente(cabeza);
           }
           tamano--;
           return; 
       }
       // Para eliminar en cualquier otra parte
       for (int i = 0; i < posicion; i++){
           actual = actual.getSiguiente();
       }
       
       Nodo<T> anterior = actual.getAnterior();
       Nodo<T> siguiente = actual.getSiguiente();
       
       anterior.setSiguiente(siguiente);
       siguiente.setAnterior(anterior);
       
       tamano--;
       return; 
   }
    
    // Método para eliminar un elemento por su valor
    public void eliminarDato (T dato){
        // Si la lista esta vacia 
        if (cabeza == null){
            return; 
        }
        
        Nodo<T> actual = cabeza; 
        
        do{
            if (actual.getDato().equals(dato)){
                // Si el dato a eliminar esta en la cabeza
                if (actual == cabeza){
                    // Si solo hay un nodo
                    if (tamano == 1){
                        cabeza = null; 
                    } else {
                        Nodo<T> ultimo = cabeza.getAnterior();
                        cabeza = cabeza.getSiguiente();
                        cabeza.setAnterior(ultimo);
                        ultimo.setSiguiente(cabeza);
                    } 
                } else {
                    // El nodo se encuentra en otro lugar 
                    Nodo<T> anterior = actual.getAnterior();
                    Nodo<T> siguiente = actual.getSiguiente();
                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);
                }
                tamano--;
                return; 
            } 
            actual = actual.getSiguiente();
        } while(actual != cabeza);
        System.out.println("Dato no encontrado");
    }
    
    // Método para modificar un elemento por su posición 
    public void modificarPosicion(int posicion, T nuevoDato){
        if (cabeza == null){
            return;
        }
        
        if (posicion < 0 || posicion >= tamano){
            System.out.println("Posición fuera del rango");
            return; 
        }
        
        Nodo<T> actual = cabeza; 
        
        for (int i = 0; i < posicion; i++){
            actual = actual.getSiguiente();
        }
        
        actual.setDato(nuevoDato);
        return; 
    }
    
    // Método para modificar un elemento por su valor 
    public void modificarDato (T dato, T nuevoDato, boolean sustituir){
        if (cabeza == null){
            return; 
        }
        Nodo <T> actual = cabeza;
        boolean encontrado = false; 
        
        do {
            if (actual.getDato().equals(dato)){
                actual.setDato(nuevoDato);
                encontrado = true; 
                
                if (!sustituir){
                    return; 
                }
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        if (!encontrado){
            System.out.println("Dato no encontrado");
        }     
    }
    
    // Método para orden la lista (se usa el método Bubble Sort)
    public void ordenar(){
        // Si la lista esta vacia o solo tiene un elemento
        if (cabeza == null || cabeza.getSiguiente() == cabeza){
            return; 
        }
        
        boolean intercambio; 
        do {
            Nodo<T> actual = cabeza; 
            Nodo<T> siguiente = cabeza.getSiguiente();
            intercambio = false; 
            
            do {
                if (actual.getDato().compareTo(siguiente.getDato()) > 0){
                    T temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    intercambio = true; 
                }
                actual = siguiente; 
                siguiente = siguiente.getSiguiente();
            } while (siguiente != cabeza);
        } while (intercambio);
    }
}
