package ejercicio3;


public class Libro implements Comparable<Libro>{

    public String autor;
    public String titulo;

    public Libro() {
        titulo = null;
        autor = null;
    }

    public Libro(String t, String a) {
        titulo = t;
        autor = a;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public void asignarTitulo(String t) {
        titulo = t;
    }

    public String obtenerAutor() {
        return autor;
    }

    public void asignarAutor(String a) {
        autor = a;
    }


    @Override
    public String toString() {
        return "Autor: " + autor + ", Titulo: " + titulo;
    }
    public int compareTo(Libro t){
        int autorLibro = this.autor.compareTo(t.autor);
        int tituloLibro = this.titulo.compareTo(t.titulo);
        if (autorLibro == 0) {
            return tituloLibro;
        }else{
            return autorLibro;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        return (this.titulo.equals(((Libro)other).titulo) && this.autor.equals(((Libro)other).autor));
    }
}
