/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.colecciones;

import practica.clases.Estudiante;
import practica.iterador.Iterator;

/**
 *
 * @author drone
 */
public interface Estudiantes {
    public abstract Iterator getIterator();
    public abstract void addEstudiante(Estudiante e);
}
