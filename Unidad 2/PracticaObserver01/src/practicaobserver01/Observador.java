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
public interface Observador {
    public void setTopico(int [] topico);
    public ArrayList<Integer> getTopico();
    public void actualizar(float temperatura, float humedad, float presion);
}
