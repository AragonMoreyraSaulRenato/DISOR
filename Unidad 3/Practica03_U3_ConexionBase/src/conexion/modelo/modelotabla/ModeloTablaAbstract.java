package conexion.modelo.modelotabla;

import conexion.control.manejodatos.ManejoDatosAbstracto;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author drone
 */
public abstract class ModeloTablaAbstract extends AbstractTableModel{
    
    protected List <Object []> dato;
    protected ManejoDatosAbstracto baseDatos;
    protected String encabezado[];
    protected Class tipos[];
    
    public void setDatos(List <Object []> d, ManejoDatosAbstracto bd){
        dato = d;
        baseDatos = bd;
    }
    
    public ManejoDatosAbstracto getBaseDatos(){
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
    public void setValueAt(Object aValue, int r, int c){
        updateTable(aValue, r, c);
    }

    @Override
    public String getColumnName(int col) {
        return encabezado[col];
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        return c>0;
    }
    
    public abstract void updateTable(Object aValue, int r, int c);
}
