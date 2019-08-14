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
public class Invitado {
     private String usuario;
    private String password;
    private String tipo;
    protected static int numinvitados = 0;
    protected static int NUMERO_INVITADOS = 0;
    protected static Invitado invitado;

    private Invitado(String usuario, String password, String tipo) {
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
    
    public static Invitado getInstance(String usuario, String password, String tipo){
        if(invitado == null || numinvitados < NUMERO_INVITADOS){
            numinvitados++;
            invitado = new Invitado(usuario,password,tipo);
            return invitado;
        } 
        else{
            return null;
        }
    }
    
    public static void setNumeroInv(int i){
        NUMERO_INVITADOS = i;
    }
    
    public void cerrarSession(){
        invitado = null;
    }
    
    @Override
    public String toString(){
        return usuario;
    }
}
