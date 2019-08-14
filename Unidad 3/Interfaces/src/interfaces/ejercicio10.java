package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ejercicio10 extends JFrame{
    
    JComboBox cboProgresion;
    
    JTextField txtInicio;
    JTextField txtFin;
    JTextField txtIntervalo;
    
    JButton btnRellenar;
    JButton btnVaciar;
    
    JLabel etiResultado;
    
    JLabel etPro, etIni, etFin, etInt;
    
    public ejercicio10(){
        etPro = new JLabel("Progresión");
        etIni = new JLabel("Inicio");
        etFin = new JLabel("Fin");
        etInt = new JLabel("Intervalo");
        
        cboProgresion = new JComboBox();
        txtInicio = new JTextField();
        txtFin = new JTextField();
        txtIntervalo = new JTextField();
        btnRellenar = new JButton("Rellenar");
        btnVaciar = new JButton("Vaciar");
        etiResultado = new JLabel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400, 400);
        
        this.add(etPro);
        this.add(cboProgresion);
        this.add(etIni);
        this.add(etFin);
        this.add(etInt);
        this.add(txtInicio);
        this.add(txtFin);
        this.add(txtIntervalo);
        this.add(btnRellenar);
        this.add(btnVaciar);
        this.add(etiResultado);
        
        etPro.setBounds(10, 0, 200, 25);
        cboProgresion.setBounds(10, 30, 200, 25);
        etIni.setBounds(10, 80, 100, 25);
        etFin.setBounds(10, 110, 100, 25);
        etInt.setBounds(10, 140, 100, 25);
        txtInicio.setBounds(110, 80, 100, 25);
        txtFin.setBounds(110, 110, 100, 25);
        txtIntervalo.setBounds(110, 140, 100, 25);
        btnRellenar.setBounds(10, 180, 100, 25);
        btnVaciar.setBounds(10, 210, 100, 25);
        etiResultado.setBounds(10, 240, 300, 25);
        
        btnRellenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnRellenarAction(ae);
            }
        });
        
        btnVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnVaciarAction(ae);
            }
        });
        
        cboProgresion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cboProgresionAction(ae);
            }
        });
        
        this.setVisible(true);
    }
    
    public void btnRellenarAction(ActionEvent ae){
        try{
            int ini = Integer.parseInt(txtInicio.getText());
            int fin = Integer.parseInt(txtFin.getText());
            int inter = Integer.parseInt(txtIntervalo.getText());
            if(ini < (fin-inter)){
                cboProgresion.removeAllItems();
                for(int i=ini; i<fin; i=i+inter){
                    cboProgresion.addItem(i);
                }            
            }
            else if(ini >= (fin-inter)){
                etiResultado.setText("Inicio debe ser menor que fin");
            }
        }catch(NumberFormatException e){
            etiResultado.setText("Introduce solo numeros plis!");
        }
    }
    
    public void btnVaciarAction(ActionEvent ae){
        cboProgresion.removeAllItems();
        txtInicio.setText("");
        txtFin.setText("");
        txtIntervalo.setText("");
        etiResultado.setText("");
    }  
    
    public void cboProgresionAction(ActionEvent ae) {
        etiResultado.setText("Seleccionado: "+cboProgresion.getSelectedItem().toString());
    }
    
    public static void main(String[] args) {
        ejercicio10 e = new ejercicio10();
    }
}
