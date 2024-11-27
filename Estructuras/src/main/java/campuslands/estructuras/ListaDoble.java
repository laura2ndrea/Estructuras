package campuslands.estructuras;

public class ListaDoble<T> {
    private Nodo<T> cabeza; 
    private int tamano; 
    
    public ListaDoble() {
        this.cabeza = null; 
        this.tamano = 0; 
    }
    
    // Método para mostrar el tamaño de la lista 
    public void mostrarTamano(){
        System.out.println(tamano);
    }
    
    // Método para mostrar la lista en orden
    public void mostrarOrden(){
        Nodo <T> actual = cabeza; 
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente(); 
        }
        System.out.println();
    }
    
    // Método para mostrar la lista en orden inverso 
    public void mostrarInverso(){
        Nodo <T> actual = cabeza; 
        // Para recorrer hasta llegar al último nodo
        while (actual != null && actual.getSiguiente() != null){
            actual = actual.getSiguiente(); 
        }
        while (actual != null){
            System.out.print(actual.getDato() + " ");
            actual = actual.getAnterior();
        }
        System.out.println();
    }
    
    // Método para agregar elementos al inicio de la lista
    public void agregarInicio(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza != null){
            cabeza.setAnterior(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza);
        }
        cabeza = nuevoNodo; 
        tamano +=1; 
    }
    
    // Método para agregar elementos al final de la lista 
    public void agregarFinal (T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        Nodo<T> actual= cabeza;
        while (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(actual);
        tamano +=1;  
    }
    
    // Método para agregar elementos en un posición especifica 
    public void agregarPosicion (T dato, int posicion){
        // Validación que la posición es válida 
        if (posicion < 0){
            System.out.println("La posición no puede ser negativa");
            return;
        }
        // Para agregar en la primera posición
        if (posicion == 0){
            agregarInicio(dato);
            return;
        }
        // Para agregar en una posición diferente 
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        Nodo<T> actual = cabeza; 
        int contador = 0; 
        // Recorro la lista para llegar al nodo anterior a la posición
        while (actual != null && contador < posicion - 1){
            actual = actual.getSiguiente();
            contador++;
        }
        // En caso de no encontrar la posición
        if (actual == null){
            System.out.println("La posición es mayor al tamaño de la lista");
            return;
        }
        // Inserción del nuevo nodo 
        Nodo<T> siguiente = actual.getSiguiente();
        nuevoNodo.setSiguiente(siguiente);
        nuevoNodo.setAnterior(actual);
        
        // Si siguiente no es null se hace el enlace
        if (siguiente != null){
            siguiente.setAnterior(nuevoNodo);
        }
        
        // Enlace con el nodo en actual y el nuevo nodo
        actual.setSiguiente(nuevoNodo);
    }

    
    // Método para buscar un elemento por la posición
    public void buscarPosicion (int posicion){
        // Verificación de la posición
        if (posicion < 0){
            System.out.println("La posición no puede ser negativa");
            return; 
        }
        Nodo<T> actual = cabeza; 
        int contador = 0;
        while (actual != null && contador != posicion) {
            actual = actual.getSiguiente();
            contador++;
        }
        
        if (actual == null){
            System.out.println("La posición es mayor al tamaño de la lista");
            return;
        }
        System.out.println(actual.getDato());
    }
    
    // Método para buscar un elemento por el dato
    public void buscarDato (T dato){
        Nodo<T> actual = cabeza;
        int indice = 0;
        int contador = 0;
        while (actual != null){
            if (actual.getDato().equals(dato)){
                System.out.println(indice);
                contador++;
            }
            actual = actual.getSiguiente();
            indice++;
        }
        if (contador == 0){
            System.out.println("-1");
        }
    }
    
    // Método para eliminar un elemento por su posición
    
    // Método para eliminar un elemento por su valor
    
    // Método para modificar un elemento por su posición 
    
    // Método para modificar un elemento por su valor 

}