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
public class PatoHule extends Pato {
    public PatoHule(int edad) {
        super(edad);
        modoVolar= new VuelaNo();
        modoGraznar= new GraznaImita();
    }

    @Override
    public void mostrar() {        
            System.out.println("Soy un patito de hule");
    }
    @Override
    public void compVolar(){
        modoVolar.volar();
    }
    @Override
    public void compGraznar(){
        modoGraznar.graznar();
    }

    @Override
    public void setCompGraznar(ModoGraznar mg) {
        modoGraznar = mg;
    }

    @Override
    public void setCompVolar(ModoVolar mv) {
        modoVolar = mv;
    }
    
}
