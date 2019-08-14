package practica1.u2;
/**
 *
 * @author drone
 */
public class Practica1U2 {
    public static void main(String[] args) {
        
        
        
        Aplicacion fabrica;
        
        fabrica = Aplicacion.cargaFabrica("Android");        
        fabrica.generarGUI(new String[]{"etiqueta1"},new String[]{"campo1"},new String[]{"boton1"});
        
        System.out.println("\n\n");

        fabrica = Aplicacion.cargaFabrica("Awt");        
        fabrica.generarGUI(new String[]{"etiqueta2"},new String[]{"campo2"},new String[]{"boton2"});
        
        System.out.println("\n\n");

        fabrica = Aplicacion.cargaFabrica("Swing");        
        fabrica.generarGUI(new String[]{"etiqueta3"},new String[]{"campo3"},new String[]{"boton3"});
        
        System.out.println("\n\n");

        fabrica = Aplicacion.cargaFabrica("Html");        
        fabrica.generarGUI(new String[]{"etiqueta4"},new String[]{"campo4"},new String[]{"boton4"});
        
        System.out.println("\n\n");
    }
}
