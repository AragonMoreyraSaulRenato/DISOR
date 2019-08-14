package iterator;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author drone
 */
public class IteradorLinkedList implements  Iterator{
    private LinkedList listA;
    private int indice = 0;
    public IteradorLinkedList(LinkedList la){
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
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
}
