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
public class DisplayEstadisticas implements Observador, DisplayValores {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
        private ArrayList<Integer> topics;
	private DatosClima datosClima;

	public DisplayEstadisticas(DatosClima datosClima, int [] topicos) {
		this.datosClima = datosClima;
		datosClima.registartObservador(this);
                topics = new ArrayList<Integer>();
                for(int i: topicos) topics.add(i);
	}

        @Override
	public void actualizar(float temperatura, float humedad, float presion) {
		tempSum += temperatura;
		numReadings++;

		if (temperatura > maxTemp) {
			maxTemp = temperatura;
		}
 
		if (temperatura < minTemp) {
			minTemp = temperatura;
		}

		display();
	}

	public void display() {
		System.out.printf("%-30s %-30s %-150s \n","DisplayEstadisticas",toString(),"Promedio/Max/Min temperatura = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
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
    
    /**
     public static final int TEMPERATURA = 0;
    public static final int HUMEDAD = 1;
    public static final int PRESION = 2;
     */
    
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