/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.iterador;

import practica.clases.Estudiante;

/**
 *
 * @author drone
 */
public class IteraPasantes implements Iterator{
    
    private Estudiante[] estudiantes;
    private int numEstudiantes;
    private int posicion;
        
    public IteraPasantes(Estudiante[] est, int total) {
        posicion = 0;
        numEstudiantes = total;
        estudiantes = est;
    }

    
    
    @Override
    public Estudiante previus() {
        if(posicion>0) return estudiantes[posicion];
        return null;
    }

    @Override
    public void restart() {
        posicion = 0;
    }

    @Override
    public boolean isFirst() {
        return posicion == 0 && estudiantes[0] != null;
    }

    @Override
    public boolean hasNext() {
        return posicion< estudiantes.length && estudiantes[posicion] != null;
    }

    @Override
    public Estudiante next() {
        return estudiantes[posicion++];
    }
    
}
