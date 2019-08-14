/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerexamen;

/**
 *
 * @author drone
 */
public class ObserverExamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automovil a = new Automovil(50, 20);
        DisplayEstadisticas estadisticas = new DisplayEstadisticas(a);
        DisplayGasolina gasolina = new DisplayGasolina(a);
        
        for(int i=0; i<15; i++){
            float tiempo =  (float)Math.random();
            float distancia =  (float)Math.random() * 150 + 60;
            a.deplazamiento(tiempo, distancia);
            
        }
        
    }
    
}
