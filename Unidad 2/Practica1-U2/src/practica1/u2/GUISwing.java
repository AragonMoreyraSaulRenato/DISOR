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
public class GUISwing extends GUI{

    public GUISwing(String[] etiqueta, String[] campoTxt, String[] botones) {
        super(etiqueta, campoTxt, botones);
    }
    
    @Override
    protected void creaPresentacion() {
        System.out.println("Creó presentacion GUI Swing");
    }
    
    @Override
    protected void defineInterfaz() {
        System.out.println("Definió interfaz GUI Swing");
        super.defineInterfaz();
    }

    @Override
    protected void agregaElementos() {
        System.out.println("Agregó elementos en GUI Swing");
    }
}
