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
public class PracticaMenuComidas {

    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) {
        Menu menus = new ElementoMenu("MENUS DIARIOS");
        Menu desayunos = new ElementoMenu("\tDESAYUNO COMPLETO");
        Menu comidas = new ElementoMenu("\tCOMIDA COMPLETA");
        Menu cenas = new ElementoMenu("\tCENA DE ANOTIJITOS");
        
        Menu de1 = new Platillo("Echiladas", "Verdes, Rojas, Mole", 35, false);
        Menu de2 = new Platillo("Bebida", "Cafe, Atole, Agua", 15, true);
        Menu de3 = new Platillo("Postre dulce", "Flan, Pastel, Gelatina", 25, true);
        
        Menu co1 = new Platillo("Caldo de pollo", "Con o sin arroz", 40, false);
        Menu co2 = new ElementoMenu("\t\tBebidas Frias");
        co2.agregar(new Platillo("\tRefresco", "Tutifruti", 15, false));
        co2.agregar(new Platillo("\tAgua", "De frutas topicales", 15, false));
        co2.agregar(new Platillo("\tJugos", "Boing", 15, false));
        
        Menu co3 = new Platillo("Postre salado", "Crepa de jamón, Crepa de queso", 30, false);
        
        Menu ce1 = new ElementoMenu("\t\tAntojitos");
        
            Menu p1 = new Platillo("\tTacos Pastor", "Res", 50, false);
            Menu p2 = new Platillo("\tTacos Tripa", "Puerco", 60, false);
            Menu p3 = new Platillo("\tTacos suadero", "Res", 60, false);
            Menu p4 = new Platillo("\tTacos tasajo", "Res", 60, false);

            ce1.agregar(p1);
            ce1.agregar(p2);
            ce1.agregar(p3);
            ce1.agregar(p4);
        
        Menu ce2 = new Platillo("Bebida", "Refresco, Agua, Café, Chocolate", 15, false);
        Menu ce3 = new Platillo("Postre", "Crepas, Pastel, Manzanas de chile", 30, false);
        
        
        
        desayunos.agregar(de1);
        desayunos.agregar(de2);
        desayunos.agregar(de3);
        
        comidas.agregar(co1);
        comidas.agregar(co2);
        comidas.agregar(co2);
        comidas.agregar(co2);
        comidas.agregar(co3);
        comidas.agregar(de1);
        comidas.agregar(de1);
        comidas.agregar(de1);
        comidas.agregar(de1);
        
        cenas.agregar(ce1);
        cenas.agregar(ce2);
        cenas.agregar(ce3);
        
        menus.agregar(desayunos);
        menus.agregar(comidas);
        menus.agregar(cenas);
        /*System.out.println(menus.listarMenu());
        
        
        System.out.println("\n--->>>CAMBIANDO PRECIO<<<---");
        de1.setPrecio(500);
        System.out.println(menus.listarMenu());*/
        
        System.out.println(comidas.listarMenu());
        System.out.println("\n--->>>NUMERO<<<--- "+comidas.getSizeElements());
        comidas.reset();
        System.out.println("\n--->>>NUMERO<<<--- "+comidas.getSizeElements());
    }
    
}
