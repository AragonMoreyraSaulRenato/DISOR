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
public abstract class Aplicacion {
    protected Aplicacion(){
    }
    
    public abstract GUI creaGUI(String [] etiqueta, String [] campoTxt, String [] botones);
    
     public void generarGUI(String [] etiqueta, String [] campoTxt, String [] botones){
        GUI producto = creaGUI(etiqueta,campoTxt,botones);
       
        System.out.println("----------------------------------------------------------------");
        producto.creaPresentacion();
        producto.defineInterfaz();
        producto.agregaElementos();
        System.out.println("----------------------------------------------------------------"); 
    }
     
    public static Aplicacion cargaFabrica(String type){
        if (type.equals("Android")) return new AplicacionAndroid();
        
        if (type.equals("Html")) return new AplicacionHtml();
        
        if (type.equals("Awt")) return new AplicacionAWT();
        
        if (type.equals("Swing")) return new AplicacionSwing();
        
        return null;
        
    }
}
