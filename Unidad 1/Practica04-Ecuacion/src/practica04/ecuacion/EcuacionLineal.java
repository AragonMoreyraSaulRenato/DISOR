package practica04.ecuacion;
import practica04.ecuacion.SolucionLineal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author drone
 */
public class EcuacionLineal extends Ecuacion{
    public EcuacionLineal(double [] coef){
        if(coef.length != 2) new UnsupportedOperationException();
        coeficientes = coef;
        grado = coef.length;
        modSol = new SolucionLineal(coef);
    }

    @Override
    protected void resultado() {
        System.out.println("x = " + modSol.solucion(coeficientes)[0]);
    }
    
    
}
