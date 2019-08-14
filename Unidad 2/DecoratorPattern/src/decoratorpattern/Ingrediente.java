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
public abstract class Ingrediente implements Bebida{
    private Bebida bebida;
    public abstract String getNombre();
    public abstract String getTamano();
    public abstract int getCosto();
}
