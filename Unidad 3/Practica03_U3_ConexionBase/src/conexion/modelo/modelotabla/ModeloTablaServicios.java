package conexion.modelo.modelotabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drone
 */
public class ModeloTablaServicios extends ModeloTablaAbstract{

    public ModeloTablaServicios() {
        super();
        encabezado = new String[]{"Nu.Cont","Nombre","Edad","Sexo",
                                  "Semestre","Creditos","Carrera"};
        
        tipos = new Class[]{Integer.class, String.class, Integer.class, 
                            String.class, Integer.class, Integer.class, 
                            Integer.class};
    }
    
    @Override
    public void updateTable(Object aValue, int r, int c) {
        if(c>0){
            try {
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE SAUL.ESTUDIANTE SET"
                            + " NOMBRE = '"+ (String)dato.get(r)[1] + "', "
                            + " EDAD = "+dato.get(r)[2] + ","
                            + " SEXO = '"+dato.get(r)[3] + "',"
                            + " SEMESTRE = "+dato.get(r)[4] + ","
                            + " CREDITOS = "+dato.get(r)[5]
                            + " WHERE NO_CONTROL = "+(Integer)dato.get(r)[0];
            baseDatos.actualizarDatos(datos);
                System.err.println(datos);
            } catch (SQLException ex) {
                Logger.getLogger(ModeloTablaServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
