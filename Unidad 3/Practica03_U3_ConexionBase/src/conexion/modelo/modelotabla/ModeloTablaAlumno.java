package conexion.modelo.modelotabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drone
 */
public class ModeloTablaAlumno extends ModeloTablaAbstract{

    public ModeloTablaAlumno() {
        super();
        encabezado = new String[]{"No.Cont","Nombre","Edad"};
        tipos = new Class[]{Integer.class, String.class, Integer.class};
    }
    
    @Override
    public void updateTable(Object aValue, int r, int c){
        if(c>0){
            try {
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE SAUL.ESTUDIANTE SET EDAD = "+dato.get(r)[2] +
                    "WHERE NO_CONTROL = "+(Integer)dato.get(r)[0];
            baseDatos.actualizarDatos(datos);
                System.err.println(datos);
            } catch (SQLException ex) {
                Logger.getLogger(ModeloTablaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    @Override
    public boolean isCellEditable(int r, int c) {
        switch(c){
            case 0: return false;
            case 1: return false;
            case 2: return true;
        }
        return false;
    }
}
