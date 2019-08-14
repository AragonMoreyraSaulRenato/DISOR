/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04.ecuacion;

/**
 *
 * @author drone
 */
public class SolucionLineal implements ModoSolucion{

    private double a, b;
    
    public SolucionLineal(double [] coef){
        a = coef[0];
        b = coef[1];
    }
    
    @Override
    public double[] solucion(double[] coef) {
        double y [] = { new Double(-a/b) };
        return y;
    }
}
