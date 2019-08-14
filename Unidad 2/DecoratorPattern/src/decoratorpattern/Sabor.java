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
public class Sabor extends Ingrediente{
    Bebida bebida;
    private String nombre, tamano;
    private int costo;
    public Sabor(Bebida bebida, String nombre){
        this.bebida = bebida;
        this.nombre =  nombre;
        
        
    }

    @Override
    public String getNombre() {
        return bebida.getNombre() + " más sabor " + nombre;
    }

    @Override
    public String getTamano() {
        return bebida.getTamano()+ " aún más lleno ";
    }

    @Override
    public int getCosto() {
        return bebida.getCosto() + 10;
    }    
}
