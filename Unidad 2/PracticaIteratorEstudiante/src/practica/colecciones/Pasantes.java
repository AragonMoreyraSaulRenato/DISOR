/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.colecciones;

import practica.clases.Estudiante;
import practica.iterador.IteraPasantes;
import practica.iterador.Iterator;

/**
 *
 * @author drone
 */
public class Pasantes implements Estudiantes{
    int index;
    int tamMax;
    Estudiante [] estudiantes;
    public Pasantes(int t){
        index = 0;
        tamMax = t;
        estudiantes = new Estudiante[tamMax];
    }
    
    @Override
    public Iterator getIterator(){
        return new IteraPasantes(estudiantes,tamMax);
    }
    
    @Override
    public void addEstudiante(Estudiante e){
        estudiantes[index] = e;
        index++;
    }
}
