package campuslands.estructuras;

public class Main {

    public static void main(String[] args) {
        ListaDoble <Double> listaDobles = new ListaDoble <>();
        listaDobles.agregarInicio(10.0); 
        ListaDoble <Integer> listaEntero = new ListaDoble<>();
        System.out.println("print");
        listaEntero.agregarInicio(80);
        listaEntero.agregarInicio(40);
        listaEntero.agregarInicio(12);
        listaEntero.agregarInicio(80);
        listaEntero.buscarDato(80);
        listaEntero.buscarDato(1);
//        listaEntero.mostrarOrden();
//        listaEntero.mostrarTamano();
//        listaEntero.mostrarInverso();
//        System.out.println("Prueba del nuevo metodo");
//        listaEntero.agregarFinal(14);
//        listaEntero.agregarFinal(25); 
//        listaEntero.agregarFinal(76);
//        listaEntero.mostrarOrden();
//        listaEntero.mostrarInverso();
//        listaEntero.mostrarTamano();
//        listaEntero.agregarPosicion(32, 7);
//        listaEntero.mostrarOrden();
//        listaEntero.buscarPosicion(3);
//        listaEntero.buscarDato(80);
    }
}
