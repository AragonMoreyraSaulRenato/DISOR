/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.iterador;

import java.util.ArrayList;
import practica.clases.Estudiante;

/**
 *
 * @author drone
 */
public class IteraInscritos implements Iterator{
    private ArrayList<Estudiante> estudiantes;
    private int posicion;

    
    public IteraInscritos(ArrayList<Estudiante> es){
        estudiantes = es;
        posicion = 0;
    }
    
    @Override
    public Estudiante previus() {
        if(posicion > 0) 
            return estudiantes.get(posicion--);
        return null;
    }

    @Override
    public void restart() {
        posicion = 0;
    }

    @Override
    public boolean isFirst() {
        return posicion == 0 && estudiantes.get(0) != null;
    }

    @Override
    public boolean hasNext() {
        return posicion< estudiantes.size();
    }

    @Override
    public Estudiante next() {
        return estudiantes.get(posicion++);
    }
}
