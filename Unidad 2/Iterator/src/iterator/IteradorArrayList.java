/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author drone
 */
public class IteradorArrayList implements Iterator{
    private ArrayList listA;
    private int indice = 0;
    public IteradorArrayList(ArrayList la){
        this.listA = la;
    }

    @Override
    public boolean hasNext() {
        return indice< listA.size();
    }

    @Override
    public Object next() {
        return listA.get(indice++);
    }

    @Override
    public void remove() {
        Iterator.super.remove(); 
    }
}
