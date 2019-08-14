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
public abstract class GUI {
    protected String [] etiqueta;
    protected String [] campoTxt;
    protected String [] botones;
    
    
    protected GUI(String [] etiqueta, String [] campoTxt, String [] botones){
        this.etiqueta = etiqueta;
        this.campoTxt = campoTxt;
        this.botones = botones;
    }
    
    
    protected void defineInterfaz(){
        System.out.println("\t| Definiendo...");
        
        for(String e : etiqueta) System.out.println("\t\t| "+e);
        for(String e : campoTxt) System.out.println("\t\t| "+e);
        for(String e : botones) System.out.println("\t\t| "+e);
    }
    protected void agregaElementos(){}
    protected void creaPresentacion(){}
}
