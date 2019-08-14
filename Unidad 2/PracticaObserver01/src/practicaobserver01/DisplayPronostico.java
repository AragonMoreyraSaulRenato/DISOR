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
public class DisplayPronostico implements Observador, DisplayValores{
    private float presionActual = 29.92f;
    private float presionAnterior;
    private ArrayList<Integer> topics;
    //private DatosClima datosClima;
    
    public DisplayPronostico(DatosClima datosClima, int [] topico){
        //this.datosClima = datosClima;
        
        datosClima.registartObservador(this);
        topics = new ArrayList<Integer>();
        for(int i: topico) topics.add(i);
    }
    
    @Override
    public void actualizar(float temperatura, float humedad, float presion) {
        presionAnterior = presionActual;
        presionActual = presion;
        display();
    }

    @Override
    public void display() {
        if(presionActual > presionAnterior){
            System.out.printf("%-30s %-30s %-150s \n","DisplayPronostico",toString(),"Pronostico: Mejoramiento de condiciones!");
        }else if(presionActual == presionAnterior){
            System.out.printf("%-30s %-30s %-150s \n","DisplayPronostico",toString(),"Pronostico: No cambian las condiciones");
        }else{
            System.out.printf("%-30s %-30s %-150s \n","DisplayPronostico",toString(),"Pronostico: Clima lluvioso (Paraguas!!!)");
        }    
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
