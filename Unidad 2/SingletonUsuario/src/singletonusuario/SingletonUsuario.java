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
public class SingletonUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Admon admon1 = Admon.getInstance("Saul","12345","Admon");
        System.out.println(admon1.toString());
        Admon admon2 = Admon.getInstance("Deisy","qwerty","Admon");
        System.out.println(admon2.toString());
        admon1.cerrarSession();
        Admon admon3 = Admon.getInstance("Jose","asdfg","Admon");
        System.out.println(admon3.toString());
        */
        
        Invitado i1 = Invitado.getInstance("Saul","12345","Invitado");
        //
        Invitado i2 = Invitado.getInstance("Jose","12345","Invitado");
        //
        Invitado i3 = Invitado.getInstance("Deisy","12345","Invitado");
        //
        Invitado i4 = Invitado.getInstance("Joselyn","12345","Invitado");
        //
        
        System.out.println(i1!=null? i1.toString() : "Instancia no creada");
        System.out.println(i2!=null? i2.toString() : "Instancia no creada");
        System.out.println(i3!=null? i3.toString() : "Instancia no creada");
        System.out.println(i4!=null? i4.toString() : "Instancia no creada");
    }
    
}
