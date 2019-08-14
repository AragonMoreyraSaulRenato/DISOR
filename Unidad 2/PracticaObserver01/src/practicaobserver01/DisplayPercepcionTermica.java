/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaobserver01;

import java.util.ArrayList;

/**
 *
 * @author drone
 */



public class DisplayPercepcionTermica implements Observador, DisplayValores {
    float persepcion = 0.0f;
    private DatosClima datosClima;
    private ArrayList<Integer> topics;
    
    public DisplayPercepcionTermica(DatosClima datosClima, int [] topicos) {
            this.datosClima = datosClima;
            datosClima.registartObservador(this);
            topics = new ArrayList<Integer>();
            for(int i: topicos) topics.add(i);
    }

    @Override
    public void actualizar(float temperatura, float humedad, float presion) {
            persepcion = computeHeatIndex(temperatura, humedad);
            display();
    }

    private float computeHeatIndex(float t, float rh) {
            float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) 
                    + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) 
                    + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                    (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 * 
                    (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) + 
                    (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                    0.000000000843296 * (t * t * rh * rh * rh)) -
                    (0.0000000000481975 * (t * t * t * rh * rh * rh)));
            return index;
    }

    @Override
    public void display() {
            System.out.printf("%-30s %-30s %-150s \n","DisplayPercepcionTermica",toString(),"Persepcion termica es de: " + persepcion);
    }

    @Override
    public void setTopico(int [] topico) {
        topics = new ArrayList<Integer>();
        for(int i: topico) topics.add(i);
    }

    @Override
    public ArrayList<Integer> getTopico() {
        return topics;
    }
    
    @Override
    public String toString(){
        String acum = "";
        for(int i=0; i<topics.size(); i++){
            switch(topics.get(i)){
                case 0: acum += "TEMPERATURA "; break;
                case 1: acum += "HUMEDAD ";     break;
                case 2: acum += "PRESION ";     break;
            }
        }
        return acum;
    }
}
