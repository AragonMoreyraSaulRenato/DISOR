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
public class Practica04Ecuacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //a, b
        double x[] = {3.0, 3.9};
        Ecuacion eq1 = new EcuacionLineal(x);
        eq1.mostrar();
        eq1.resultado();
        
        //a, b
        double x2[] = {-2.0, 10.0};
        Ecuacion eq2 = new EcuacionLineal(x2);
        eq2.mostrar();
        eq2.resultado();
        
        
        //a, b, c
        double x3[] = {2.0, -2.0, 5.0};
        Ecuacion eq3 = new EcuacionCuadratica(x3);
        eq3.mostrar();
        eq3.resultado();
        
        //a, b, c
        double x4[] = {2.0, 10.0, 4.0};
        Ecuacion eq4 = new EcuacionCuadratica(x4);
        eq4.mostrar();
        eq4.resultado();
        */
        
        double [][] fx = {{5,4,2,3},{3,2,1,0}};
        double [][] fxp = {{15,8,2},{2,1,0}};
        Ecuacion eq5 = new EcuacionGradoN(fx, fxp, 1);
        eq5.mostrar(fx);
        eq5.resultado();
        
    }
    
}
