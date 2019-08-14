

import lista.ColeccionLinkedList;
import clases.Articulo;
import iterator.IteradorArrayList;
import iterator.IteradorArreglo;
import iterator.IteradorLinkedList;
import lista.ColeccionArrayList;
import lista.ColeccionArreglo;

/**
 *
 * @author drone
 */
public class PruebaListaArt{
    public static void main(String args[]){
        int tamMax = 10;
        System.out.println("ColeccionLinkedList");
        ColeccionLinkedList lista = new ColeccionLinkedList();
        lista.add(new Articulo("Articulo1",100,5));
        lista.add(new Articulo("Articulo1",100,5));
        lista.add(new Articulo("Articulo1",100,5));
        lista.add(new Articulo("Articulo1",100,5));
        lista.add(new Articulo("Articulo1",100,5));
        lista.add(new Articulo("Articulo1",100,5));
        lista.imprimir(new IteradorLinkedList(lista.getColeccion()));
        
        System.out.println("\n\nColeccionArrayList");
        ColeccionArrayList lista1 = new ColeccionArrayList();
        lista1.add(new Articulo("Articulo2",100,5));
        lista1.add(new Articulo("Articulo2",100,5));
        lista1.add(new Articulo("Articulo2",100,5));
        lista1.add(new Articulo("Articulo2",100,5));
        lista1.add(new Articulo("Articulo2",100,5));
        lista1.add(new Articulo("Articulo2",100,5));
        lista1.imprimir(new IteradorArrayList(lista1.getColeccion()));
        
        System.out.println("\n\nColeccionArreglo");
        ColeccionArreglo lista2 = new ColeccionArreglo(tamMax);
        lista2.add(new Articulo("Articulo3",100,5));
        lista2.add(new Articulo("Articulo3",100,5));
        lista2.add(new Articulo("Articulo3",100,5));
        lista2.add(new Articulo("Articulo3",100,5));
        lista2.add(new Articulo("Articulo3",100,5));
        lista2.add(new Articulo("Articulo3",100,5));
        lista2.imprimir(new IteradorArreglo(lista2.getColeccion()));
    }
    
}
