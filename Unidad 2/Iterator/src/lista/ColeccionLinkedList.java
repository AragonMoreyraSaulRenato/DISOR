package lista;

import clases.Articulo;
import iterator.IteradorLinkedList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author drone
 */
public class ColeccionLinkedList extends Coleccion{
    LinkedList<Articulo> listaA;
    public ColeccionLinkedList(){
        listaA = new LinkedList<>();
    }
    @Override
    public Iterator <Articulo> creaIterador(){
        return new IteradorLinkedList(listaA);
    }
    @Override
    public void add(Articulo art){
            listaA.add(art);
    }
    @Override
    public void imprimir(Iterator il){
        while(il.hasNext())  System.out.println(((Articulo)il.next()).toString());
    }
    public LinkedList<Articulo> getColeccion(){
        return listaA;
    }
    
}
