/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jecuacion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author drone
 */
public class JInputDouble extends JPanel{

    private String texto;
    
    private JLabel titulo;
    private JTextField input;
    
    public JInputDouble(String texto) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.texto = texto;
        titulo = new JLabel(texto);
        input = new JTextField();
        
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char key = ke.getKeyChar();
                if(!Character.isDigit(key) && key!='.') ke.consume();
                else if(input.getText().contains(".") && !Character.isDigit(key)) ke.consume();
                  
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
        
        this.add(titulo);
        this.add(input);
    }

    public String getTexto() {
        return titulo.getText();
    }

    public void setTexto(String texto) {
        titulo.setText(texto);
    }
    
    public String getInputText(){
        return input.getText();
    }
    
    public void setInputText(String texto){
        input.setText(texto);
    }
    
    
    
    
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new FlowLayout());
        
        JInputDouble text = new JInputDouble();
        text.setTexto("Hola");
        frame.add(text);
        
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
    
}
