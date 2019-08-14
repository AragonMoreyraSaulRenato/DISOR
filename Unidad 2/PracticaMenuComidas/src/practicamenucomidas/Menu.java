/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamenucomidas;

/**
 *
 * @author drone
 */
public abstract class Menu {
    public abstract void agregar(Menu m);
    public abstract void remover(Menu m);
    public abstract String listarMenu();
    public abstract int getPrecio();
    public abstract void setPrecio(int precio);
    public abstract int getSizeElements();
    public abstract void reset();
}
