/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorpattern;

/**
 *
 * @author drone
 */
public class PruebaBebida {
    public static void main(String[] args) {
        Bebida bebidaSimple = new BebidaSimple("Agua pura", "Mediana", 10);
        System.out.println(bebidaSimple.getNombre()+ " " +bebidaSimple.getCosto());
        
        Bebida bebidaSabor = new Sabor(bebidaSimple,"mango");
        System.out.println("Nombre: "+ bebidaSabor.getNombre()+ "\nTamaño: " + bebidaSabor.getTamano()+"\nCosto: "+bebidaSabor.getCosto());
     
        Bebida bebidaFruta = new Fruta(bebidaSimple,"sandía");
        System.out.println("Nombre: "+ bebidaFruta.getNombre()+ "\nTamaño: " + bebidaFruta.getTamano()+"\nCosto: "+bebidaFruta.getCosto());
        
        Bebida bebidaNieve = new Nieve(bebidaSimple, "limón");
        System.out.println("Nombre: "+ bebidaNieve.getNombre()+ "\nTamaño: " + bebidaNieve.getTamano()+"\nCosto: "+bebidaNieve.getCosto());
        
        //combinada
        Bebida bebidaCombinada = new BebidaSimple("Agua natural","Grande",20);
        bebidaCombinada = new Sabor(bebidaCombinada,"naranja");
        bebidaCombinada = new Fruta(bebidaSimple,"plátano");
        bebidaCombinada = new Nieve(bebidaCombinada,"leche quemada");
        System.out.println("Nombre: "+ bebidaCombinada.getNombre()+ "\nTamaño: " + bebidaCombinada.getTamano()+"\nCosto: "+bebidaCombinada.getCosto());
     
    }
    
    
}
