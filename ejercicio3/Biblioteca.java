package ejercicio3;

import java.lang.String;

public class Biblioteca {
    public Libro[] libros;
    public int nroLibros;
    private final int DEFAULT_MAX = 50;

    public Biblioteca() {
        libros = new Libro[DEFAULT_MAX];
        nroLibros = 0;
    }

    public Biblioteca(int max) {
        libros = new Libro[max];
        nroLibros = 0;
    }

    // Si el catalogo no esta lleno inserta el libro al final del arreglo
    public boolean agregarLibro(Libro l) {
    	// Insertar siempre en la ultima posicion del arreglo

        if (this.nroLibros < 50) {
            int i = this.nroLibros;
            this.libros[i] = l ;
            this.nroLibros = (this.nroLibros + 1);
            return true;
        }

            return false;
    }

    // Si hay un libro con titulo t en el catalogo lo retorna, sino devuelve null.
    public Libro buscarPorTitulo(String t) {
    	// recorrer libros hasta encontrar un libro con titulo t
        for (int i = 0; i < this.nroLibros; i++ ) {
            if (this.libros[i].titulo == t) {
                return libros[i];
            }
        }
        return null;
    }

    public void mostrar() {
        for (int i = 0; i<nroLibros; i++)
            System.out.println("Libro " + i + ": " + libros[i].toString());
    }

    public static void mergeSort1(Libro[] librito, int nroLibros) {
        mergeSort(librito, nroLibros);

    }

    public static void mergeSort(Libro[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Libro[] l = new Libro[mid];
        Libro[] r = new Libro[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
//work

    public static void merge(Libro[] a, Libro[] l, Libro[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i].compareTo(r[j]) < 0 || l[i].compareTo(r[j]) == 0) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
