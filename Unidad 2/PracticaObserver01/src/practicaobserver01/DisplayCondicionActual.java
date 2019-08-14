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
public class DisplayCondicionActual implements Observador, DisplayValores{
    private float temperatura;
    private float humuedad;
    private ArrayList<Integer> topics;
    //private DatosClima datosClima;
    
    public DisplayCondicionActual(DatosClima datosClima, int [] topicos){
        //this.datosClima = datosClima;
        datosClima.registartObservador(this);
        topics = new ArrayList<Integer>();
            for(int i: topicos) topics.add(i);
    }

    @Override
    public void actualizar(float temperatura, float humedad, float presion) {
        this.temperatura = temperatura;
        this.humuedad = humedad;
        display();
    }

    @Override
    public void display() {
        System.out.printf("%-30s %-30s %-150s \n" ,"DisplayCondicionActual",toString(),"Condiciones actuales: "
                +"Humedad: "+humuedad+"%    Temperatura:"+temperatura+"°C");
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
