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
public class BebidaSimple implements Bebida{
    private String nombre, tamano; 
    private int costo;

    public BebidaSimple(String nombre, String tamano, int costo) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.costo = costo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTamano() {
        return tamano;
    }

    @Override
    public int getCosto() {
        return costo;
    }
    
}
