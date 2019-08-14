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
public class Nucleo extends Pantalla {
    
    @Override
    public void write( String[] s ) {
        System.out.print( "INPUT: " );
        try {
            s[0] = in.readLine();
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    @Override
    public void read( String[] s ) {
        System.out.println( "Output: " + s[0] );
    } 
}