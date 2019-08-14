/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerexamen;

import java.util.ArrayList;

/**
 *
 * @author drone
 */
public class DisplayEstadisticas implements Observador, Displayelemento{

    private ArrayList<Float> estadisticas;
    
    public DisplayEstadisticas(Automovil auto){
        auto.registartObservador(this);
        estadisticas = new ArrayList<>();
    }
            
    
    @Override
    public void actualizar(float litrosg, float rendimiento, float cuentakm) {
        estadisticas.add(cuentakm);
        display();
    }

    @Override
    public void display() {
        //for(int i=0; i<estadisticas.size(); i++)
         //   System.out.print("\t Intervalo "+ (i+1) + " " +estadisticas.get(i) +"\n");
        
        System.out.print(" Menor: "+menor() + " Mayor: "+mayor() + " Total:"+total() + "\n");
    }

    private float menor() {
        float menor = 1000;
        for (int i = 0; i < estadisticas.size(); i++) {
            //System.out.println("Esta: "+estadisticas.get(i) );
            if(estadisticas.get(i) < menor && estadisticas.get(i)!=0.0)
                menor = estadisticas.get(i);
        }
        return menor;
    }

    private float mayor() {
        float mayor = 0;
        for (int i = 0; i < estadisticas.size(); i++) {
            if(estadisticas.get(i) > mayor)
                mayor = estadisticas.get(i);
        }
        return mayor;
    }

    private float total() {
        float mayor = 0;
        for (int i = 0; i < estadisticas.size(); i++) {
            mayor+= estadisticas.get(i);
        }
        return mayor;
    }
    
}
