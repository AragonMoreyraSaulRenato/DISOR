/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03.duck;

/**
 *
 * @author drone
 */
public class Main {
    public static void main(String []args){
        Pato p3 = new PatoSilvestre(2);
        p3.mostrar();
        p3.nadar();
        p3.compVolar();
        p3.compGraznar();
        
        System.out.println("\nAhora:");
        
        p3.setCompGraznar(new GraznaNo());
        p3.setCompVolar(new VuelaNo());
        
        p3.mostrar();
        p3.nadar();
        p3.compVolar();
        p3.compGraznar();
        
    }
    
}
