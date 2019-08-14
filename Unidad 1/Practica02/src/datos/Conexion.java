/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author drone
 */
public class Conexion {
    private String URLDerby = "jdbc:derby://localhost:1527/DISOR";
    private String usuario = "saul";
    private String contrasena = "2121";
    private Connection connection;
    private int nC = 0;    
    
    protected static Conexion con;
    
    protected Conexion() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = (Connection)DriverManager.getConnection(URLDerby,usuario,contrasena);
            nC++;
            System.out.println("Se crea la conexión #"+nC);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.err.println("Fatality Error " + e);
        }
    }
    
    public static Conexion getInstance() throws ClassNotFoundException, SQLException{
        if(con == null){
            con = new Conexion();
        } else if (con.getConnection().isClosed()) {
            con = new Conexion();
        }
        System.out.println("Soy una conexion unica");
        return con;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public boolean closeConnection() throws SQLException{
        if(connection != null){
            if(nC == 1){
                connection.close();
                return true;
            }else{
                nC--;
            }
            return false;
        }
        return false;
    }
    
    public int getNumberOfConnections(){
        return nC;
    }
}