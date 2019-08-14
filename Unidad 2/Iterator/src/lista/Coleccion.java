package lista;

import clases.Articulo;
import java.util.Iterator;

/**
 *
 * @author drone
 */
public abstract class Coleccion {
    public abstract void add(Articulo obj);   
    public abstract Iterator creaIterador();
    public abstract void imprimir(Iterator il);
}
