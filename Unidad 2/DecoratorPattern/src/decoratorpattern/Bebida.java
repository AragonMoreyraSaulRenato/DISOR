/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorpattern;

/**
 *
 * @author drone
 */
public interface Bebida {
    public String nombre = "Sin nombre", tamano = "Estándar"; 
    public int costo = 0;

    public abstract String getNombre();
    public abstract String getTamano();
    public abstract int getCosto();    
}
