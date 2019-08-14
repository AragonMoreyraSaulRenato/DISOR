/*
 * 
 * 
 * 
 */
package conexion.vista.interfaz;

import conexion.control.manejodatos.ManejoDatosAbstracto;
import conexion.control.manejodatos.ManejoDeDatosAlumno;
import conexion.modelo.modelotabla.ModeloTablaAbstract;
import conexion.modelo.modelotabla.ModeloTablaAlumno;
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
public class InterfazAlumno extends Interfaz{
    
    private JButton btnBuscar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField noControl;
    private String consulta;
    public InterfazAlumno(String ident) {
        super(ident);
        initComponents();
        baseDatos = creaManejoDatos();
        modeloTabla = creaModeloTabla();
    }

    @Override
    public ModeloTablaAbstract creaModeloTabla() {
        return new ModeloTablaAlumno();
    }

    @Override
    public ManejoDatosAbstracto creaManejoDatos() {
        try {
            return new ManejoDeDatosAlumno();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfazAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {  
        String p = noControl.getText();
        if(!p.equals("")){
            consulta = "SELECT NO_CONTROL,NOMBRE,EDAD FROM SAUL.ESTUDIANTE "
                + "WHERE NO_CONTROL = "+noControl.getText();
            modeloTabla.setDatos(baseDatos.consultarDatos(consulta),baseDatos);
            jTable1.setModel(modeloTabla);
            modeloTabla.fireTableDataChanged();
        }
    }                                           
   
    // <editor-fold defaultstate="collapsed" desc="">   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        noControl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Interfaz de Alumno");

        jLabel2.setText("No. de Control: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "No.Cont","Nombre","Edad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(noControl, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(noControl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold> 
    
}
