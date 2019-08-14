/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonusuario;

import java.util.ArrayList;

/**
 *
 * @author drone
 */
public class Credenciales {
    protected static ArrayList<String> usuario;
    protected static ArrayList<String> password;
    protected static ArrayList<String> tipo;

    public static ArrayList<String> getUsuario() {
        return usuario;
    }

    public static void setUsuario(ArrayList<String> usuario) {
        Credenciales.usuario = usuario;
    }

    public static ArrayList<String> getPassword() {
        return password;
    }

    public static void setPassword(ArrayList<String> password) {
        Credenciales.password = password;
    }

    public static ArrayList<String> getTipo() {
        return tipo;
    }

    public static void setTipo(ArrayList<String> tipo) {
        Credenciales.tipo = tipo;
    }
    
    public static void inicializa(){
        usuario = new ArrayList<>();
        password = new ArrayList<>();
        tipo = new ArrayList<>();
        
        usuario.add("Mario");
        usuario.add("Carlos");
        usuario.add("Josefina");
        usuario.add("Karla");
        
        password.add("ma05x");
        password.add("kar06y");
        password.add("jose07z");
        password.add("kar08x");     
        
        tipo.add("admo");
        tipo.add("admo");
        tipo.add("invitado");
        tipo.add("invitado");   
    }
}
