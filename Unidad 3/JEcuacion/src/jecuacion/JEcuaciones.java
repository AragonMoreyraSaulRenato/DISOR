/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jecuacion;

import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author drone
 */
public class JEcuaciones extends JPanel {
    private JInputDouble a , b, c;
    public JEcuaciones(){
         this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
         
         a = new JInputDouble("A: ");
         b = new JInputDouble("B: ");
         c = new JInputDouble("C: ");
         
         this.add(a);
         this.add(b);
         this.add(c);
    }   
    
    
    public String [] getInputs(){
        //AQUI REGRESA EL VALOR DE A, B, C EN STRING
        String [] x = {a.getInputText(),b.getInputText(),c.getInputText()};
        return x;
    }
    
    public void setInputs(String [] inputs){
        a.setInputText(inputs[0]);
        b.setInputText(inputs[1]);
        c.setInputText(inputs[2]);
    } 
    
}
