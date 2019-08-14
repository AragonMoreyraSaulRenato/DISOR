/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import clases.Articulo;
import java.util.Iterator;

/**
 *
 * @author drone
 */
public class IteradorArreglo implements  Iterator{
    private Articulo [] listA;
    private int indice = 0;
    public IteradorArreglo(Articulo [] la){
        this.listA = la;
    }

    @Override
    public boolean hasNext() {
        return indice< listA.length && listA[indice] != null;
    }

    @Override
    public Object next() {
        return listA[indice++];
    }

    @Override
    public void remove() {
        Iterator.super.remove(); 
    }
}
