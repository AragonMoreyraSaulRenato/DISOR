/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtitleunique;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jtextunique.JTextUnique;

/**
 *
 * @author drone
 */
public class JTitleUnique extends JPanel{
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;
    
    public static final int TEXT = 1;
    public static final int NUMBER = 2;
    public static final int DECIMAL_NUMBER = 3;
    
    public final int MIN_COLUMS = 5;
    private boolean typetext,typenumber,typedecimal;
    private boolean positionUp,positionDown,positionLeft,positionRight;
    
    private JTextUnique text;
    private JLabel title;
    private int position;
    
    public JTitleUnique(){
        text = new JTextUnique();
        text.setColumnas(MIN_COLUMS);
        
        
        title = new JLabel("JTitleUnique");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        
        this.setLayout(new BorderLayout());
        position = LEFT;
        makeComponent(position);
    }
    
    private void makeComponent(int postition) {
        this.removeAll();
        switch(postition){
            case UP:{
                this.add(title,BorderLayout.NORTH);
                this.add(text,BorderLayout.CENTER);
                break;
            }
            case LEFT:{
                this.add(title,BorderLayout.WEST);
                this.add(text,BorderLayout.CENTER);
                break;
            }
            case DOWN:{
                this.add(text,BorderLayout.CENTER);
                this.add(title,BorderLayout.SOUTH);
                break;
            }
            case RIGHT:{
                this.add(title,BorderLayout.EAST);
                this.add(text,BorderLayout.CENTER);
                break;
            }
        }
    }
    
    public void setTitle(String title){
        this.title.setText(title);
    }
    
    public String getTitle(){
        return this.title.getText();
    }
    
    public void setText(String text){
        this.text.setText(text);
    }
    
    public String getText(){
        return this.text.getText();
    }
    
    public void setPosicion(int pos){
        this.position = pos;
        makeComponent(pos);
    }
    
    public int getPosicion(){
        return position;
    }
    
    public void setColumnas(int col){
        text.setColumnas(col);
    }
    
    public int getColumnas(){
        return text.getColumnas();
    }
    
    public int getType() {
        return text.getType();
    }

    public void setType(int type) {
        text.setType(type);
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
        else{
            setType(TEXT);
            typetext = true;
        }
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
        else{
            setType(TEXT);
            typetext = true;
        }
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
        else{
            setType(TEXT);
            typetext = true;
        }
    }

    public boolean isPositionUp() {
        return positionUp;
    }

    public void setPositionUp(boolean positionUp) {
        this.positionUp = positionUp;
        this.positionDown = false;
        this.positionLeft = false;
        this.positionRight = false;
        if(positionUp)
            setPosicion(UP);
        else{
            setPosicion(LEFT);
            positionLeft = true;
        }
    }

    public boolean isPositionDown() {
        return positionDown;
    }

    public void setPositionDown(boolean positionDown) {
        this.positionUp = false;
        this.positionDown = positionDown;
        this.positionLeft = false;
        this.positionRight = false;
        if(positionDown)
            setPosicion(DOWN);
        else{
            setPosicion(LEFT);
            positionLeft = true;
        }
    }

    public boolean isPositionLeft() {
        return positionLeft;
    }

    public void setPositionLeft(boolean positionLeft) {
        this.positionUp = false;
        this.positionDown = false;
        this.positionLeft = positionLeft;
        this.positionRight = false;
        if(positionLeft)
            setPosicion(LEFT);
        else{
            setPosicion(LEFT);
            positionLeft = true;
        }
    }

    public boolean isPositionRight() {
        return positionRight;
    }

    public void setPositionRight(boolean positionRight) {
        this.positionUp = false;
        this.positionDown = false;
        this.positionLeft = false;
        this.positionRight = positionRight;
        if(positionRight)
            setPosicion(RIGHT);
        else{
            setPosicion(LEFT);
            positionLeft = true;
        }
    }
        
    @Override
    public void setSize(int i, int i1) {
        super.setSize(i, i1); 
        text.setSize(i-2, i1-2);
    }
    
    
    
 /*   public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new GridLayout(3, 1));
        
        JTitleUnique text = new JTitleUnique();
        text.setTitle("Texto");
        text.setColumnas(15);
        text.setPosicion(JTextTitle.LEFT);
        text.setType(JTitleUnique.TEXT);
        
        JTitleUnique ente = new JTitleUnique();
        ente.setTitle("Entero");
        ente.setType(JTitleUnique.NUMBER);
        ente.setColumnas(15);
        ente.setPosicion(JTextTitle.LEFT);
        
        JTitleUnique deci = new JTitleUnique();
        deci.setTitle("Decimal");
        deci.setColumnas(15);
        deci.setPosicion(JTextTitle.LEFT);
        deci.setType(JTitleUnique.DECIMAL_NUMBER);
        
        frame.add(text);
        frame.add(ente);
        frame.add(deci);
        
        frame.setVisible(true);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
*/
}
