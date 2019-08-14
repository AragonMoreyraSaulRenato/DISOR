/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.u2;

/**
 *
 * @author drone
 */
public class AplicacionAWT extends Aplicacion{

    //GUIAwt awt;
    
    @Override
    public GUI creaGUI(String [] etiqueta, String [] campoTxt, String [] botones) {
        System.out.println("Se está fabricando un GUI AWT");
        GUI gui = new GUIAwt(etiqueta,campoTxt,botones);
        return gui;
    }
}
