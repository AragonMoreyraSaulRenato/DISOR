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
public interface Iterator{
    public abstract Estudiante next();
    public abstract boolean hasNext ();
    public abstract Estudiante previus();
    public abstract void restart();
    public abstract boolean isFirst();
}
