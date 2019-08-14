/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author drone
 */
public class SingletonConnection {
    private String URLDerby = "jdbc:derby://localhost:1527/DISOR";
    private String usuario = "saul";
    private String contrasena = "2121";
    private Connection connection;
    private String nombre;
    
    protected static int nC = 0;
    protected static int limite = 2;
    protected static SingletonConnection instance;
    
    protected SingletonConnection(String nombre) throws ClassNotFoundException, SQLException{
        this.nombre = nombre;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = (Connection)DriverManager.getConnection(URLDerby,usuario,contrasena);
            System.out.println("Is Connected");
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.err.println("Fatality Error " + e);
        }
    }
    
    public static SingletonConnection getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null || nC < limite){
            nC++;
            instance = new SingletonConnection("Soy la conexion: "+nC);
        } else if (instance.getConnection().isClosed()) {
            nC--;
            instance = new SingletonConnection("Soy la conexion: "+nC);
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public int getNumberOfConnections(){
        return nC;
    }
    
    public String toString(){
        return nombre;
    }
    
}
