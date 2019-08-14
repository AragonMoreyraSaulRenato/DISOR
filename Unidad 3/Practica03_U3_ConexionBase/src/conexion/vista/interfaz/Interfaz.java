/*
 * 
 * 
 * 
 */
package conexion.vista.interfaz;

import conexion.control.manejodatos.ManejoDatosAbstracto;
import conexion.modelo.modelotabla.ModeloTablaAbstract;
import javax.swing.JFrame;

/**
 *
 * @author drone
 */
public abstract class Interfaz extends JFrame{
    protected ManejoDatosAbstracto baseDatos;
    protected ModeloTablaAbstract modeloTabla;
    public Interfaz(String ident){
        super(ident);
        
    }
    public abstract ModeloTablaAbstract creaModeloTabla();
    public abstract ManejoDatosAbstracto creaManejoDatos();
}
