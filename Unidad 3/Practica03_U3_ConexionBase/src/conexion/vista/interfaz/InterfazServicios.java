/*
 * 
 * 
 * 
 */
package conexion.vista.interfaz;

import conexion.control.manejodatos.ManejoDatosAbstracto;
import conexion.control.manejodatos.ManejoDeDatosServicios;
import conexion.modelo.modelotabla.ModeloTablaAbstract;
import conexion.modelo.modelotabla.ModeloTablaServicios;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author drone
 */
public class InterfazServicios extends Interfaz{
    
    private JButton btnRefresh;
    private JButton btnRegistrar;
    private JButton btnTerminar;
    private ButtonGroup buttonGroup1;
    private JSpinner creditos;
    private JSpinner edad;
    private JRadioButton hombre;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JRadioButton mujer;
    private JTextField nombre;
    private JSpinner semestre;   

    
    public InterfazServicios(String ident) throws ClassNotFoundException, SQLException {
        super(ident);
        initComponents();
        
        baseDatos = creaManejoDatos();
        modeloTabla = creaModeloTabla();
        
        
        buttonGroup1.add(hombre);
        buttonGroup1.add(mujer);
        
        String consulta = "SELECT NO_CONTROL,NOMBRE,EDAD,SEXO,SEMESTRE,"
                + "CREDITOS,CARRERA FROM SAUL.ESTUDIANTE";
    
        
        modeloTabla.setDatos(baseDatos.consultarDatos(consulta),baseDatos);
        jTable1.setModel(modeloTabla);
    }

    
    
    private void btnRegistrarActionPerformed(ActionEvent evt) {                                             
        String sexo = "";
        if(hombre.isSelected())
            sexo = hombre.getText();
        else
            sexo = mujer.getText();
        
        String datos = "INSERT INTO SAUL.ESTUDIANTE "+
                       "(NOMBRE,EDAD,SEXO,SEMESTRE,CREDITOS,CARRERA) VALUES"+
                       "('"+ nombre.getText() +"',"+ edad.getValue() +", '"+ sexo + "',"+
                       semestre.getValue() +","+ creditos.getValue() +","+ 1 +")"; 
        try {
            baseDatos.actualizarDatos(datos);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        modeloTabla.setDatos(baseDatos.consultarDatos("SELECT NO_CONTROL,NOMBRE,EDAD,SEXO,SEMESTRE,CREDITOS,CARRERA FROM SAUL.ESTUDIANTE"), baseDatos);
        modeloTabla.fireTableDataChanged();
        
        nombre.setText("");
        buttonGroup1.clearSelection();
        edad.setValue(0);
        semestre.setValue(0);
        creditos.setValue(0);
    }                                            

    private void btnTerminarActionPerformed(ActionEvent evt) {                                            
        try {
            if(baseDatos.closeConnection())
                System.exit(0);
            else
                this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InterfazServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }                                           

    private void btnRefreshActionPerformed(ActionEvent evt) {                                           
        modeloTabla.setDatos(baseDatos.consultarDatos("SELECT NO_CONTROL,NOMBRE,EDAD,SEXO,SEMESTRE,CREDITOS,CARRERA FROM SAUL.ESTUDIANTE"), baseDatos);
        modeloTabla.fireTableDataChanged();
    } 
    
    @Override
    public ModeloTablaAbstract creaModeloTabla() {
        return new ModeloTablaServicios();
    }

    @Override
    public ManejoDatosAbstracto creaManejoDatos(){
        try {
            return new ManejoDeDatosServicios();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfazServicios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // <editor-fold defaultstate="collapsed" desc=""> 
    @SuppressWarnings("unchecked")                     
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hombre = new javax.swing.JRadioButton();
        mujer = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        edad = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        semestre = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        creditos = new javax.swing.JSpinner();
        btnRegistrar = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agregar, visualizar y modificar los datos de los estudiantes");

        jLabel2.setText("Num. de Control: ");

        jLabel4.setText("Nombre: ");

        jLabel5.setText("Sexo:");

        hombre.setText("Hombre");

        mujer.setText("Mujer");

        jLabel6.setText("Edad:");

        jLabel7.setText("Semestre:");

        jLabel8.setText("Creditos:");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRefresh.setText("Refrescar");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mujer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(hombre)
                    .addComponent(mujer)
                    .addComponent(jLabel6)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnTerminar)
                    .addComponent(btnRefresh))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>        
}
