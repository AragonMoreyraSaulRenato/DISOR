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
public class Automovil implements Sujeto{
    private float litrosg, rendimiento, cuentakm = 0;
    private ArrayList observadores;
    
    public Automovil(float litros, float rendimiento){
        this.litrosg = litros;
        this.rendimiento = rendimiento;
        observadores = new ArrayList();
    }
    
    public float getLitros(){
        return litrosg;
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
    public void notificarObservador() {
        for(int i=0; i<observadores.size(); i++){
            Observador observador = (Observador) observadores.get(i);
            observador.actualizar(litrosg, rendimiento, cuentakm);
        }
    }
    
    public void cambioDeMediciones(){
        notificarObservador();
    }
    
    public void deplazamiento(float tiempoHoras, float velocidad){
        cuentakm = velocidad * tiempoHoras;
        cambioDeMediciones();
    }
    
}
