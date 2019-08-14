/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import clases.Articulo;
import iterator.IteradorArrayList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author drone
 */
public class ColeccionArrayList extends Coleccion{
    ArrayList<Articulo> listaA;
    public ColeccionArrayList(){
        listaA = new ArrayList<Articulo>();
    }
    @Override
    public Iterator <Articulo> creaIterador(){
        return new IteradorArrayList(listaA);
    }
    @Override
    public void add(Articulo art){
            listaA.add(art);
    }
    @Override
    public void imprimir(Iterator il){
        while(il.hasNext())  System.out.println(((Articulo)il.next()).toString());
    }
    public ArrayList<Articulo> getColeccion(){
        return listaA;
    }
}
