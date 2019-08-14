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
public abstract class Decorador extends Pantalla {
    public Pantalla inner;
    public Decorador( Pantalla i ) { 
        inner = i; 
    }

    @Override
    public void write( String[] s ) { inner.write( s ); }

    @Override
    public void read( String[] s ) { inner.read( s ); }
}