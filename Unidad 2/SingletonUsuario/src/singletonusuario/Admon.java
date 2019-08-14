/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonusuario;

/**
 *
 * @author drone
 */
public class Admon {
    private String usuario;
    private String password;
    private String tipo;
    protected static Admon admon;

    private Admon(String usuario, String password, String tipo) {
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public static Admon getInstance(String usuario, String password, String tipo){
        if(admon == null){
            admon = new Admon(usuario,password,tipo);
            return admon;
        } 
        else{
            return admon;
        }
    }
    
    public void cerrarSession(){
        admon = null;
    }
    
    @Override
    public String toString(){
        return usuario;
    }
}
