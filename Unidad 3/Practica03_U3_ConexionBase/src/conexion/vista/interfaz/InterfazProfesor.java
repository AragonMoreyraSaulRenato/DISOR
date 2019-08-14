/*
 * 
 * 
 * 
 */
package conexion.vista.interfaz;

import conexion.control.manejodatos.ManejoDatosAbstracto;
import conexion.control.manejodatos.ManejoDeDatosProfesor;
import conexion.modelo.modelotabla.ModeloTablaAbstract;
import conexion.modelo.modelotabla.ModeloTablaProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author drone
 */
public class InterfazProfesor extends Interfaz{
    
    private JButton btnBuscar;
    private JButton btnTodos;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;

    public InterfazProfesor(String ident) {
        super(ident);
        initComponents();
        baseDatos = creaManejoDatos();
        modeloTabla = creaModeloTabla();
        todos();
        
    }
    
    public void todos(){
        String consulta = "SELECT NO_CONTROL,NOMBRE,CALIFICACION FROM SAUL.ESTUDIANTE";
        modeloTabla.setDatos(baseDatos.consultarDatos(consulta),baseDatos);
        jTable1.setModel(modeloTabla);
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) { 
        String consulta = "SELECT NO_CONTROL,NOMBRE,CALIFICACION "
            + "FROM SAUL.ESTUDIANTE WHERE NO_CONTROL = "+jTextField1.getText();
        modeloTabla.setDatos(baseDatos.consultarDatos(consulta),baseDatos);
        jTable1.setModel(modeloTabla);
        modeloTabla.fireTableDataChanged();
    } 
    
    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {  
        todos();
        modeloTabla.fireTableDataChanged();
    }  

    @Override
    public ModeloTablaAbstract creaModeloTabla() {
        return new ModeloTablaProfesor();
    }

    @Override
    public ManejoDatosAbstracto creaManejoDatos() {
        try {
            return new ManejoDeDatosProfesor();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfazProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">      
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnTodos = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Interfaz Profesor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "No.Cont","Nombre","Calificacion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("No. Control: ");

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });  

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTodos)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTodos)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

}
