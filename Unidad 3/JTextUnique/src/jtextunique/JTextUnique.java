/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtextunique;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author drone
 */
public class JTextUnique extends JTextField implements KeyListener{
    public static final int TEXT = 1;
    public static final int NUMBER = 2;
    public static final int DECIMAL_NUMBER = 3;
    public static final int MIN_LONG = 1;
    
    private int columns;
    private int type;
    private boolean typetext,typenumber,typedecimal;

    public JTextUnique(){
        super();
        this.addKeyListener(this);
        columns = MIN_LONG;
        type = TEXT;
        typetext = true;
        typenumber = false;
        typedecimal = false;
    }
    
    public int getColumnas() {
        return columns;
    }

    public void setColumnas(int columns) {
        this.columns = columns;
        this.setColumns(columns);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public boolean isTypetext() {
        return typetext;
    }

    public void setTypetext(boolean typetext) {
        this.typetext = typetext;
        this.typenumber = false;
        this.typedecimal = false;
        if(typetext)
            setType(TEXT);
    }

    public boolean isTypenumber() {
        return typenumber;
    }

    public void setTypenumber(boolean typenumber) {
        this.typenumber = typenumber;
        typetext = false;
        typedecimal = false;
        if(typenumber)
            setType(NUMBER);
    }

    public boolean isTypedecimal() {
        return typedecimal;
    }

    public void setTypedecimal(boolean typedecimal) {
        this.typedecimal = typedecimal;
        typetext = false;
        typenumber = false;
        if(typedecimal)
            setType(DECIMAL_NUMBER);
    }
    
    
    @Override 
    public void keyTyped(KeyEvent ke) {
        char key = ke.getKeyChar();
        if(columns <= this.getText().length())
            ke.consume();
            
        switch (type){
            case JTextUnique.TEXT:{
                if(!Character.isLetter(key) && !Character.isWhitespace(key))
                    ke.consume();
                break;
            }
            case JTextUnique.NUMBER:{
                if(!Character.isDigit(key)) ke.consume();
                break;
            }
            case JTextUnique.DECIMAL_NUMBER:{
                if(!Character.isDigit(key) && key!='.') ke.consume();
                else if(this.getText().contains(".") && !Character.isDigit(key)) ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
    
    
    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new FlowLayout());
        
        JTextUnique text = new JTextUnique();
        text.setColumnas(10);
        text.setType(JTextUnique.TEXT);
        //text.setSize(100, 25);
 
        
        JTextUnique number = new JTextUnique();
        number.setColumnas(10);
        number.setType(JTextUnique.NUMBER);
        //number.setSize(100, 25);
        
        JTextUnique decimal = new JTextUnique();
        decimal.setColumnas(10);
        decimal.setType(JTextUnique.DECIMAL_NUMBER);
        //decimal.setSize(100, 25);
        
        frame.add(text);
        frame.add(number);
        frame.add(decimal);
        
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
    
}
