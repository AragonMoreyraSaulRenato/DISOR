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
public class SolucionCuadratica implements ModoSolucion{
    
    private double a, b, c;
    public SolucionCuadratica(double [] coef){
        a = coef[0];
        b = coef[1];
        c = coef[2];
    }
    
    @Override
    public double[] solucion(double[] coef) {
        double r = (b*b) - (4*a*c);
        System.out.println("r: "+r);
        if(r < 0) {
            r = -r;
            double x1 = (Math.sqrt(r)/ (2*a));
            double x0 = -b / (2*a);
            return new double[]{x0, x1, 0.0};
        }
        else{
            double x1 = (-b + Math.sqrt(r)) / (2*a);
            double x2 = (-b - Math.sqrt(r)) / (2*a);
            return new double[]{x1,x2};
        }
    }
    
}
