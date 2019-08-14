/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaobserver01;

/**
 *
 * @author drone
 */
public class PracticaObserver01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosClima datosClima = new DatosClima();
        
        DisplayCondicionActual mostrarCondicionActual = 
                new DisplayCondicionActual(datosClima,
                        new int[]{DatosClima.TEMPERATURA,DatosClima.HUMEDAD});
        
        DisplayPronostico muestaPronostico = 
                new DisplayPronostico(datosClima, 
                        new int[]{DatosClima.PRESION});
        
        DisplayPercepcionTermica percepcionTermica = 
                new DisplayPercepcionTermica(datosClima,
                        new int[]{DatosClima.TEMPERATURA,DatosClima.HUMEDAD});
        
        DisplayEstadisticas estadisticas = 
                new DisplayEstadisticas(datosClima, 
                        new int[]{DatosClima.TEMPERATURA});
                
        datosClima.asignarMediciones(80, 65, 30.4f);
        System.out.println("");
        datosClima.asignarMediciones(80, 65, 31.4f);
        System.out.println("");
        datosClima.asignarMediciones(80, 61, 29.2f);
        System.out.println("");
        
        
    }
    
}
