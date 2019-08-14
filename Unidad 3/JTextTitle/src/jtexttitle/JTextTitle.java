/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtexttitle;

import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author drone
 */
public class JTextTitle extends JPanel{
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;
    
    public static final int TEXT = 1;
    public static final int NUMBER = 2;
    public static final int DECIMAL_NUMBER = 3;
    
    private JFormattedTextField text;
    private JLabel title;
    private int position;
    
    public JTextTitle(){
        text = new JFormattedTextField();
        title = new JLabel();
        makeComponent(LEFT);
    }
    
    private void makeComponent(int postition) {
        this.removeAll();
        switch(postition){
            case UP:{
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                this.add(title);
                this.add(text);
                break;
            }
            case LEFT:{
                this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
                this.add(title);
                this.add(text);
                break;
            }
            case DOWN:{
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                this.add(text);
                this.add(title);
                break;
            }
            case RIGHT:{
                this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
                this.add(text);
                this.add(title);
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
    
    public void setColumns(int col){
        text.setColumns(col);
    }
    
    private MaskFormatter formatText() throws ParseException {
        String acum = "";
        for(int i=0; i<text.getColumns(); i++){
            acum += "*";
        }
        return new MaskFormatter(acum);
    }
    
    private MaskFormatter formatInteger() throws ParseException {
        String acum = "";
        for(int i=0; i<text.getColumns(); i++){
            acum += "#";
        }
        return new MaskFormatter(acum);
    }
    
    private MaskFormatter formatDecimal(int ent) throws ParseException {
        String acum = "";
        for(int i=0; i<ent; i++){
            acum += "#";
        }
        acum += ".";
        for(int i=ent; i<text.getColumns(); i++){
            acum += "#";
        }
        return new MaskFormatter(acum);
    }
    
    public void beInteger() throws ParseException{
        text = new JFormattedTextField(formatInteger());
        makeComponent(position);
    }
    
    public void beDecimal(int ent) throws ParseException{
        text = new JFormattedTextField(formatDecimal(ent));
        makeComponent(position);
    }
    
    public void beText() throws ParseException{
        text = new JFormattedTextField(formatText());
        makeComponent(position);
    }

    @Override
    public void setSize(int i, int i1) {
        super.setSize(i, i1); 
        text.setSize(i-2, i1-2);
    }
    
    
   /* 
    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new GridLayout(3, 1));
        
        JTextTitle text = new JTextTitle();
        text.setTitle("Texto");
        text.setColumns(15);
        text.setPosicion(JTextTitle.LEFT);
        text.beText();
        
        JTextTitle ente = new JTextTitle();
        ente.setTitle("Entero");
        ente.setColumns(15);
        ente.setPosicion(JTextTitle.LEFT);
        ente.beInteger();
        
        JTextTitle deci = new JTextTitle();
        deci.setTitle("Decimal");
        deci.setColumns(15);
        deci.setPosicion(JTextTitle.LEFT);
        deci.beDecimal(6);
        
        frame.add(text);
        frame.add(ente);
        frame.add(deci);
        
        frame.setVisible(true);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    */
}
