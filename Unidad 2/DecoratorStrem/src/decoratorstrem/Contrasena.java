/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorstrem;

import java.io.IOException;

/**
 *
 * @author drone
 */
public class Contrasena extends Decorador {
    private String contra;
    
    public Contrasena( Pantalla inner ) { 
        super( inner ); 
    }

    @Override
    public void write( String[] s ) {
        System.out.print( "PASSWORD: " );
        try {
            contra = in.readLine();
        } catch (IOException ex) { ex.printStackTrace(); }
        super.write( s );
    }

    @Override
    public void read( String[] s ) {
        String c="";
        System.out.print( "PASSWORD: ");
        try {
            c=in.readLine();
        } catch (IOException ex) { 
            ex.printStackTrace(); 
        }
        
        if(compContra(c))
            super.read( s );
        else
            System.out.println("Contraseña Incorrecta");
    } 
    
    public boolean compContra(String c){
        return contra.equals(c);
    }
    
}
