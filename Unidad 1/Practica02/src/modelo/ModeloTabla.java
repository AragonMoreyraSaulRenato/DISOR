/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ManejoDatosEst;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author drone
 */
public class ModeloTabla extends AbstractTableModel{
    
    private List <Object []> dato;
    private ManejoDatosEst baseDatos;
    private String encabezado[] = new String[]
            {"Nu.Cont","Nombre","Edad","Sexo","Semestre","Creditos","Carrera"};
    
    private Class tipos[] = new Class[]
            {Integer.class, String.class, Integer.class, String.class, 
             Integer.class, Integer.class, Integer.class};
    
    public void setDatos(List <Object []> d, ManejoDatosEst bd){
        dato = d;
        baseDatos = bd;
    }
    
    public ManejoDatosEst getBaseDatos(){
        return baseDatos;
    }
    

    @Override
    public int getRowCount() {
        return dato.size();
    }

    @Override
    public int getColumnCount() {
        return tipos.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return dato.get(r)[c];
    }

    @Override
    public void setValueAt(Object aValue, int r, int c) {
        if(c>0){
            try {
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE SAUL.ESTUDIANTE SET NOMBRE = '"+
                    (String)dato.get(r)[1]+"', EDAD = "+dato.get(r)[2] +
                    "WHERE NO_CONTROL = "+(Integer)dato.get(r)[0];
            baseDatos.actualizarDatos(datos);
                System.err.println(datos);
            } catch (SQLException ex) {
                Logger.getLogger(ModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public String getColumnName(int col) {
        return encabezado[col];
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        return c>0;
    }
}
