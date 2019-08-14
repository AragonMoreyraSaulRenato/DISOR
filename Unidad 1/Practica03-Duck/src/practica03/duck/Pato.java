/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03.duck;

/**
 *
 * @author drone
 */
public abstract class Pato {

    protected ModoVolar modoVolar;
    protected ModoGraznar modoGraznar;
    protected int edad;
    public Pato(int edad){
        this.edad=edad;
    }
    public void compVolar(){
        modoVolar.volar();
    }
    public void compGraznar(){
        modoGraznar.graznar();
    }
    public void nadar(){
        System.out.println("Todos los patos nadan");
    }
    public abstract void setCompGraznar(ModoGraznar mg);
    public abstract void setCompVolar(ModoVolar mv);
    public abstract void mostrar();
}
