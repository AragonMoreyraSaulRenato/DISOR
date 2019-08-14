/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorstrem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author drone
 */
public abstract class Pantalla {
    protected BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public abstract void write( String [] s );
    public abstract void read( String [] s );
}
