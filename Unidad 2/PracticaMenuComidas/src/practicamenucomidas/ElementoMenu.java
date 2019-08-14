/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicamenucomidas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author drone
 */
public class ElementoMenu extends Menu{
    protected String nombre;
    protected ArrayList<Menu> submenu;
    int precio;

    public ElementoMenu(String nombre) {
        this.nombre = nombre;
        submenu = new ArrayList<>();
    }

    @Override
    public void agregar(Menu m) {
        submenu.add(m);
    }

    @Override
    public void remover(Menu m) {
        submenu.remove(m);
    }

    @Override
    public String listarMenu() {
        String acum = nombre+ "   $"+getPrecio()+"\n";
        Iterator<Menu> it = submenu.iterator();
        while(it.hasNext()){
            acum += it.next().listarMenu();
        }   
        return acum;
        
    }

    @Override
    public int getPrecio() {
        Iterator<Menu> it = submenu.iterator();
        int cont = 0;
        while (it.hasNext()) {
            Menu next = it.next();
            cont += next.getPrecio();
        }
        return cont;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = getPrecio();
    }

    @Override
    public int getSizeElements() {
        Iterator<Menu> it = submenu.iterator();
        int cont = 0;
        while (it.hasNext()) {
            cont += it.next().getSizeElements();
        }
        return cont;
    }

    @Override
    public void reset() {
        Iterator<Menu> it = submenu.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }
    
    
}
