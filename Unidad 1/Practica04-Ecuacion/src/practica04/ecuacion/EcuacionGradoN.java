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
public class EcuacionGradoN extends Ecuacion{
    public EcuacionGradoN(double [][] fx, double [][] fxp, double x0){
        if(fx[0] != fx[1] || fxp[0] != fxp[1] ) new UnsupportedOperationException();
        modSol = new SolucionGradoN(fx, fxp, x0);
    }    

    @Override
    protected void resultado() {
        double [] x = modSol.solucion(new double[]{0});
        System.out.println("X:"+x[0]+ " \t\t "+ "F(x): "+x[1]+"\n");
    }
    
    
}
