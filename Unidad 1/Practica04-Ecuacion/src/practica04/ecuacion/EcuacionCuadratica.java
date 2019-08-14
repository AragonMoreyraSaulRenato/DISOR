package practica04.ecuacion;
import practica04.ecuacion.SolucionCuadratica;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author drone
 */
public class EcuacionCuadratica extends Ecuacion{
    public EcuacionCuadratica(double [] coef){
        if(coef.length != 3) new UnsupportedOperationException();
        coeficientes = coef;
        grado = coef.length;
        modSol = new SolucionCuadratica(coef);
    }

    @Override
    protected void resultado() {
        double [] r = modSol.solucion(coeficientes);
        if(r.length == 3){
            System.out.println("x1 = " + r[0] + " + " + r[1] +"i");
            System.out.println("x2 = " + r[0] + " - " + r[1] +"i");
        }
        else{
            System.out.println("x1 = " + r[0] );
            System.out.println("x2 = " + r[1] );
        }
    }
}
