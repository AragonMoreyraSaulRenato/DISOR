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
public class Platillo extends Menu{
    private String nombre;
    private String descripcion;
    private boolean vegetariano;
    private int precio;
    private boolean contado;


    public Platillo(String nombre, String descripcion, int precio, boolean vegetariano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vegetariano = vegetariano;
        this.precio = precio;
        contado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }
    
    public boolean isContado() {
        return contado;
    }

    public void setContado(boolean contado) {
        this.contado = contado;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public void agregar(Menu m) {
        throw new UnsupportedOperationException("No suportado.");
    }

    @Override
    public void remover(Menu m) {
        throw new UnsupportedOperationException("No suportado.");
    }

    @Override
    public String listarMenu() {
        String format = "\t\t%-20s%-40s%-20s%-10s\n";
        return String.format(format,getNombre(),getDescripcion(),isVegetariano(),"$"+getPrecio());
    }

    @Override
    public int getSizeElements() {
        if(contado)
            return 0;
        else{
            contado = true;
            return 1;
        }
    }

    @Override
    public void reset() {
        contado = false;
    }
}
