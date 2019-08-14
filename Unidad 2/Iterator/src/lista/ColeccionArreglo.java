/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import clases.Articulo;
import iterator.IteradorArreglo;
import java.util.Iterator;

/**
 *
 * @author drone
 */
public class ColeccionArreglo extends Coleccion{
    private Articulo [] listaA;
    private int maxElementos, indice;
    public ColeccionArreglo(int maxEl){
        maxElementos = maxEl;
        indice = 0;
        listaA = new Articulo[maxElementos];
    }
    @Override
    public Iterator <Articulo> creaIterador(){
        return new IteradorArreglo(listaA);
    }
    @Override
    public void add(Articulo art){
        if(indice != maxElementos){
            listaA[indice] = art;
            indice++;
        }
    }
    @Override
    public void imprimir(Iterator il){
        while(il.hasNext())  System.out.println(((Articulo)il.next()).toString());
    }
    public Articulo[] getColeccion(){
        return listaA;
    }
}
