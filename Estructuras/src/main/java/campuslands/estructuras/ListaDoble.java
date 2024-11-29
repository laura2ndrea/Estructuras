package campuslands.estructuras;

public class ListaDoble<T extends Comparable<T>> {
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
        Nodo<T> actual = cabeza; 
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente(); 
        }
        System.out.println();
    }
    
    // Método para mostrar la lista en orden inverso 
    public void mostrarInverso(){
        Nodo<T> actual = cabeza; 
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
        if (cabeza == null) {
            cabeza = nuevoNodo; 
        } else {
            Nodo<T> actual = cabeza;
            while (actual != null && actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
            tamano +=1;  
        }
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
        tamano++;
    }

    
    // Método para buscar un elemento por la posición
    public void buscarPosicion (int posicion){
        if (cabeza == null){
            return; 
        }
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
        if (cabeza == null){
            return;
        }
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
    public void eliminarPosicion(int posicion){
        if (cabeza == null){
            return; 
        }
        // Verificar que la posición sea valida
        if (posicion < 0 || posicion >= tamano){
            System.out.println("Posición fuera del rango");
            return;
        }
        // Para buscar el nodo en la posición especificada
        Nodo<T> actual = cabeza; 
        for (int i = 0; i < posicion; i++){
            actual = actual.getSiguiente();
        }
        
        if (actual.getAnterior() != null){
            actual.getAnterior().setSiguiente(actual.getSiguiente());
        } else {
            cabeza = actual.getSiguiente();
        }
        
        if (actual.getSiguiente() != null){
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }
        
        tamano--; 
    }
    
    // Método para eliminar un elemento por su valor
    public void eliminarDato(T dato) {
        if (cabeza == null){
            return; 
        }
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                // Si nos encontramos en la cabeza
                if (actual.getAnterior() == null) {
                    // Si el nodo a eliminar es la cabeza
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null); // Aseguramos que cabeza no apunte al nodo eliminado
                    }
                } else {
                    // Si el nodo no es la cabeza
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() != null) {
                        actual.getSiguiente().setAnterior(actual.getAnterior());
                    }
                }
                // Si el nodo a eliminar es el último
                if (actual.getSiguiente() == null) {
                    // Si eliminamos el último nodo, aseguramos que el siguiente de su anterior sea null
                    actual.getAnterior().setSiguiente(null);
                }
                tamano--; // Decrementamos el tamaño
                return;
            }
            actual = actual.getSiguiente(); // Continuamos con el siguiente nodo
        }
        System.out.println("Dato no encontrado");
    }
    
    // Método para modificar un elemento por su posición 
    public void modificarPosicion (int posicion, T nuevoDato){
        // Validación que la posición sea correcta
        if (posicion < 0 || posicion >= tamano){
            System.out.println("Posición fuera del rango");
            return;
        }
        
        Nodo<T> actual = cabeza; 
        int indice = 0; 
        
        while (indice < posicion) {
            actual = actual.getSiguiente();
            indice++;
        }
        
        actual.setDato(nuevoDato);
    }
    
    // Método para modificar un elemento por su valor 
    public void modificarDato (T dato, T nuevoDato, boolean sustitucion){
        Nodo<T> actual = cabeza;
        boolean modificado = false;
        
        while (actual != null){
            if (actual.getDato().equals(dato)){
                actual.setDato(nuevoDato);
                modificado = true;
                
                if (!sustitucion){
                    return;
                }
            }
            actual = actual.getSiguiente();
        }
        if (!modificado){
            System.out.println("Dato no encontrado");
        } 
    }
    
    // Método para orden la lista (se usa el método Bubble Sort)
    public void ordenar(){
        if (tamano <=1) {
            mostrarOrden();
            return;
        } 
        Nodo<T> actual = cabeza; 
        while (actual != null){
            Nodo<T> siguiente = actual.getSiguiente();
            while (siguiente != null) {
                if (actual.getDato().compareTo(siguiente.getDato()) > 0){
                    T temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                }
                siguiente = siguiente.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
        mostrarOrden();
    }
}