package conexion.control.manejodatos;

import conexion.datos.conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author drone
 */
public abstract class ManejoDatosAbstracto {
    protected Connection con;
    protected Conexion conec;
    //protected final int NUM_CAMPOS_ESTUDIANTE = 7;
    
    public ManejoDatosAbstracto() throws ClassNotFoundException, SQLException{
        conec = conec.getInstance();
        con = conec.getConnection();
    }
    
    public boolean closeConnection() throws SQLException{
        return conec.closeConnection();
    }
    
    public boolean actualizarDatos(String sql) throws SQLException{
        boolean res = false;
        
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        return res;
    }   
    
    public abstract List <Object []> consultarDatos(String sql);
}
