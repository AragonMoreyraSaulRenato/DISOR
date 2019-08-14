package clases;

/**
 *
 * @author drone
 */
public class Articulo {
    private String nombre;
    private int cantidad;
    private int precio;
    public Articulo(String n, int c, int p){
        this.nombre = n;
        this.cantidad = c;
        this.precio = p;
    }
    public String toString(){
        return nombre + "\t" + cantidad + "\t" + precio;
    }
}
