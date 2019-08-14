import conexion.vista.interfaz.InterfazAlumno;
import conexion.vista.interfaz.InterfazProfesor;
import conexion.vista.interfaz.InterfazServicios;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author drone
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int opc =  Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa numero\n(1) Servicios\n(2) Alumno\n(3) Profesor\n(4) Salir"));
        switch(opc){
            case 1: new InterfazServicios("Servicios").setVisible(true);    break;  
            case 2: new InterfazAlumno("Alumno").setVisible(true);          break;  
            case 3: new InterfazProfesor("Profesor").setVisible(true);      break;  
        }
    }
}
