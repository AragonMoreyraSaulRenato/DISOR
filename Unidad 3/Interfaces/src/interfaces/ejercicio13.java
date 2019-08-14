package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ejercicio13 extends JFrame{
    
    JRadioButton norte, sur, este, oeste; 
    JTextField txtAncho, txtAlto;
    JButton btnAsignar, btnArea, btnPerimetro;
    
    Rectangulo recNorte, recSur, recEste, recOeste;
    
    public ejercicio13(){        
        //PANEL PAREDES
        JPanel pared = new JPanel();
        
        TitledBorder border = new TitledBorder("Paredes");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        
        ButtonGroup bg = new ButtonGroup();
        norte = new JRadioButton("Pared Norte", true);
        sur = new JRadioButton("Pared Sur");
        este = new JRadioButton("Pared Este");
        oeste = new JRadioButton("Pared Oeste");
        
        bg.add(norte);
        bg.add(sur);
        bg.add(este);
        bg.add(oeste);
        
        pared.setBorder(border);
        pared.setLayout(null);
        pared.add(norte);
        pared.add(sur);
        pared.add(este);
        pared.add(oeste);
        
        norte.setBounds(20, 20, 100, 25);
        sur.setBounds(20, 50, 100, 25);
        este.setBounds(20, 80, 100, 25);
        oeste.setBounds(20, 110, 100, 25);
        
        //PANEL TAMAÑO
        JPanel tama = new JPanel();
        
        TitledBorder border2 = new TitledBorder("Tamaño");
        border2.setTitleJustification(TitledBorder.LEFT);
        border2.setTitlePosition(TitledBorder.TOP);
        tama.setBorder(border2);
        tama.setLayout(null);
        
        JLabel etAncho = new JLabel("Ancho:");
        JLabel etAlto = new JLabel("Alto:");
        txtAncho = new JTextField();
        txtAlto = new JTextField();
        btnAsignar = new JButton("Asignar");
        
        tama.add(etAncho);
        tama.add(etAlto);
        tama.add(txtAncho);
        tama.add(txtAlto);        
        tama.add(btnAsignar);
        
        etAncho.setBounds(20, 30, 50, 25);
        etAlto.setBounds(20, 70, 50, 25);
        txtAncho.setBounds(120, 30, 160, 25);
        txtAlto.setBounds(120, 70, 160, 25);
        btnAsignar.setBounds(20, 130, 260, 25);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(580, 400);
        this.setVisible(true);
        
        
        
        btnArea = new JButton("Area");
        btnPerimetro = new JButton("Perimetro");
        
       
        this.add(pared);
        this.add(tama);
        this.add(btnArea);
        this.add(btnPerimetro);
        
        pared.setBounds(10, 10, 200, 220);
        tama.setBounds(250, 10, 300, 220);
        btnArea.setBounds(10, 250, 540, 25);
        btnPerimetro.setBounds(10, 280, 540, 25);
        
        recNorte = new Rectangulo();
        recSur = new Rectangulo();
        recEste = new Rectangulo();
        recOeste = new Rectangulo();
        
        btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnAsignarAction(ae);
            }            
        });
        
        btnArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnAreaAction(ae);
            }
        });
        
        btnPerimetro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnPerimetroAction(ae);
            }
        });
    }    
    
    private void btnAsignarAction(ActionEvent ae) {
        try {
            double alto = Double.parseDouble(txtAlto.getText());
            double ancho = Double.parseDouble(txtAncho.getText());
            
            System.err.println(alto);
            System.err.println(ancho);
            if(norte.isSelected()){
                recNorte.setAltura(alto);
                recNorte.setBase(ancho);
            }
            else if(sur.isSelected()){
                recSur.setAltura(alto);
                recSur.setBase(ancho);
            }
            else if(este.isSelected()){
                recEste.setAltura(alto);
                recEste.setBase(ancho);
            }
            else{
                recOeste.setAltura(alto);
                recOeste.setBase(ancho);
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo números!");
        }
    }
    
    private void btnAreaAction(ActionEvent ae) {
        if(norte.isSelected()){
            JOptionPane.showMessageDialog(null, "AREA de Pared Norte: "+recNorte.getArea());
        }
        else if(sur.isSelected()){
            JOptionPane.showMessageDialog(null, "AREA de Pared Sur: "+recSur.getArea());
        }
        else if(este.isSelected()){
            JOptionPane.showMessageDialog(null, "AREA de Pared Este: "+recEste.getArea());
        }
        else{
            JOptionPane.showMessageDialog(null, "AREA de Pared Oeste: "+recOeste.getArea());
        }
    }    

    private void btnPerimetroAction(ActionEvent ae) {
        if(norte.isSelected()){
            JOptionPane.showMessageDialog(null, "PERIMETRO de Pared Norte: "+recNorte.getPerimetro());
        }
        else if(sur.isSelected()){
            JOptionPane.showMessageDialog(null, "PERIMETRO de Pared Sur: "+recSur.getPerimetro());
        }
        else if(este.isSelected()){
            JOptionPane.showMessageDialog(null, "PERIMETRO de Pared Este: "+recEste.getPerimetro());
        }
        else{
            JOptionPane.showMessageDialog(null, "PERIMETRO de Pared Oeste: "+recOeste.getPerimetro());
        }
    }
    
    
    public static void main(String[] args) {
        ejercicio13 e = new ejercicio13();
    }
}
