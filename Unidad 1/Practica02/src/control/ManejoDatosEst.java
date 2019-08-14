/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drone
 */
public class ManejoDatosEst {
    private Connection con;
    private Conexion conec;
    private final int NUM_CAMPOS_ESTUDIANTE = 7;
    
    public ManejoDatosEst() throws ClassNotFoundException, SQLException{
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
    
    public List <Object []> consultarDatos(String sql){
        List <Object []> datos = new ArrayList<Object []>();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Object dat [] = new Object[NUM_CAMPOS_ESTUDIANTE];
                dat[0] = rs.getInt(1);
                dat[1] = rs.getString(2);
                dat[2] = rs.getInt(3);
                dat[3] = rs.getString(4);
                dat[4] = rs.getInt(5);
                dat[5] = rs.getInt(6);
                dat[6] = rs.getInt(7);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al listar: "+e);
        }
        return datos;
    }
}
