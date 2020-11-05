package ejercicio3;

public class Main {

    public static void main(String args[]){
        Libro l1 = new Libro("eLibroGonza1", "marcelo tinelli");
        Libro l2 = new Libro("aLibroGonza2", "marcelo tinelli");
        Libro l3 = new Libro("bLibroGonza3", "marcelo tinelli");
        Libro l4 = new Libro("cLibroGonza4", "marcelo tinelli");

        Biblioteca c1 = new Biblioteca();

        c1.agregarLibro(l1);
        c1.agregarLibro(l2);
        c1.agregarLibro(l3);
        c1.agregarLibro(l4);
    }

}
