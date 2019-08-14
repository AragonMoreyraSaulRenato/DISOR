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
public interface Sujeto {
    public void registartObservador(Observador o);
    public void removerObservador(Observador o);
    public void notificarObservador(ArrayList<Integer> topics);
}
