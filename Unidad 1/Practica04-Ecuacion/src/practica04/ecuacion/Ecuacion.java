package practica04.ecuacion;
import practica04.ecuacion.ModoSolucion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author drone
 */
public class Ecuacion {
    protected double [] coeficientes;
    protected ModoSolucion modSol;
    protected int grado;
    
    public void mostrar(){
        System.out.println("\nEcuacion de grado: "+grado);
        /**System.out.print(coeficientes[0] +  "(x^2) ");
        System.out.print((coeficientes[1]<0? coeficientes[1]: "+" + coeficientes[1]) + "x ");
        System.out.print(coeficientes[2]<0? coeficientes[2]: "+" + coeficientes[2]);
        System.out.println();***/
        
        
        int a = grado - 1; 
        String acum = "";
        for(int c = 0; c<coeficientes.length; c++){
            if(c == coeficientes.length-1) 
                System.out.print(coeficientes[c]<0? coeficientes[c]: "+" + coeficientes[c]);
            else if(c == coeficientes.length-2)  
                System.out.print((coeficientes[c]<0? coeficientes[c]: "+" + coeficientes[c]) + "x ");
            else
                System.out.print((coeficientes[c]<0? coeficientes[c]: "+" + coeficientes[c]) + "(x^"+a+") ");
        }
        System.out.println();
    }
    
    public void mostrar(double [][] coef){
        System.out.println("Ecuacion de grado N");
        for(int i = 0; i<coef[0].length; i++){
            System.out.print((coef[0][i] <0? coef[0][i]: "+" + coef[0][i]));
            //+ "(x^"+coef[1][i]+") "
            if(coef[1][i] > 1.0) System.out.print("(x^"+coef[1][i]+") ");
            else if(coef[1][i] == 1.0) System.out.print("x ");
            else System.out.print("");
        }
        System.out.println();
    }
    
    protected void resultado(){}
}
