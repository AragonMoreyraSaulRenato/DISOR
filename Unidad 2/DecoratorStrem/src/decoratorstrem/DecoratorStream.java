/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorstrem;
/**
 *
 * @author drone
 */
public class DecoratorStream {
    
    
    public static void main( String[] args ) {
        Pantalla stream = new Nucleo();
        stream = new Encriptar(stream);
        stream = new Contrasena(stream);
        
        String [] str = { new String() };
        stream.write( str );
        System.out.println( "main: " + str[0] );
        stream.read( str );
        
       
    }
}
