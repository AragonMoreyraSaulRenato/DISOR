/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.colecciones;

import java.util.ArrayList;
import practica.clases.Estudiante;
import practica.iterador.IteraInscritos;
import practica.iterador.Iterator;


/**
 *
 * @author drone
 */
public class Inscritos implements Estudiantes{
    ArrayList<Estudiante> estudiantes;
    public Inscritos(){
        estudiantes = new ArrayList<Estudiante>();
    }
    
    @Override
    public Iterator getIterator(){
        return new IteraInscritos(estudiantes);
    }
    
    @Override
    public void addEstudiante(Estudiante e){
        estudiantes.add(e);
    }
}
