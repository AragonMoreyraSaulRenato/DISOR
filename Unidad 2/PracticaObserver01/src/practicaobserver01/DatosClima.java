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
public class DatosClima implements Sujeto{
    public static final int TEMPERATURA = 0;
    public static final int HUMEDAD = 1;
    public static final int PRESION = 2;
    
    private ArrayList observadores;
    private float temperatura;
    private float humedad;
    private float presion;
    
    public DatosClima(){
        observadores = new ArrayList();
    }

    @Override
    public void registartObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        int i = observadores.indexOf(o);
        if( i>= 0)
            observadores.remove(o);
    }

    @Override
    public void notificarObservador(ArrayList<Integer> topics) {
        for (int i = 0; i < observadores.size(); i++) {
            Observador observador = (Observador) observadores.get(i);
            for(int k=0; k<observador.getTopico().size(); k++){
                for(int j = 0; j<topics.size(); j++){
                    if(topics.get(j) == observador.getTopico().get(k)){
                        //System.out.println("OBSERVADOR: "+i +" TOPICOS: "+topics.get(j) + " TOPICOS OBSERVADOR: "+observador.getTopico().get(k));
                        observador.actualizar(temperatura, humedad, presion);
                        //System.out.println("");
                        k = observador.getTopico().size();
                        break;
                    }
                }
            }
        }
    }
    
    public void cambioMediciones(ArrayList<Integer> topics){
        notificarObservador(topics);
    }
    
    public void asignarMediciones(float temperatura, float humedad, float presion){
        ArrayList<Integer> topics = new ArrayList();
        
        if(this.temperatura != temperatura)
            topics.add(DatosClima.TEMPERATURA);
        
        if(this.humedad != humedad) 
            topics.add(DatosClima.HUMEDAD);
        
        if(this.presion != presion) 
            topics.add(DatosClima.PRESION);
        
        
        
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
        cambioMediciones(topics);
    }

    public float temperatura() {
        return temperatura;
    }

    public float humedad() {
        return humedad;
    }

    public float presion() {
        return presion;
    }
}
