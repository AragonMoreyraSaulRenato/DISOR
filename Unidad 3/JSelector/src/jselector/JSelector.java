/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jselector;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Selector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author drone
 */
public class JSelector extends JPanel{
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    
    private int orientacion = HORIZONTAL;
    
    private JLabel etiqueta1, etiqueta2;
    private JLabel espacio;
    private JComboBox combo1, combo2;
    
    private Object [] conjunto1 = {"Combo1","Combo2","Combo3"};
    private String [] conjunto;
    private String [] etiquetas = {"Etiqueta1","Etiqueta2"};
    
    private boolean orientacionVertical,orientacionHorizontal;
    
    public JSelector(){
        make();        
        this.setVisible(true);
    }   
    
    public void make(){
        this.removeAll();
        switch (orientacion) {
            case HORIZONTAL:
                this.setLayout(new GridLayout(1,5));
                etiqueta1 = new JLabel(etiquetas[0]);
                etiqueta2 = new JLabel(etiquetas[1]);
                espacio = new JLabel("   ");
                combo1 = new JComboBox(conjunto1);
                combo2 = new JComboBox(getNoSelecionados(conjunto1[0]));
                
                
                
                this.add(etiqueta1);
                this.add(combo1);
                this.add(espacio);
                this.add(etiqueta2);
                this.add(combo2);
                
                break;
            case VERTICAL:
                
                this.setLayout(new GridLayout(2,2));
                etiqueta1 = new JLabel(etiquetas[0]);
                etiqueta2 = new JLabel(etiquetas[1]);
                espacio = new JLabel("   ");
                combo1 = new JComboBox(conjunto1);
                combo2 = new JComboBox(getNoSelecionados(conjunto1[0]));
                
                this.add(etiqueta1);
                this.add(combo1);
                this.add(etiqueta2);
                this.add(combo2);
                
                break;
            default:
                throw new AssertionError();
        }
        
        combo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = (String)combo1.getSelectedItem();
                if(x!=null){//System.out.println(x.toString());
                    combo2.removeAllItems();
                    Object [] y = getNoSelecionados(x);
                    for(int i=0; i<y.length; i++){
                        combo2.addItem(y[i]);
                    }
                }
            }
        });
        
        
        combo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = (String)combo2.getSelectedItem();
                if(x!=null){//System.out.println(x.toString());
                    combo1.removeAllItems();
                    Object [] y = getNoSelecionados(x);
                    for(int i=0; i<y.length; i++){
                        combo1.addItem(y[i]);
                    }
                }
            }
        });
    }
    
    private Object [] getNoSelecionados(Object selec){
        Object s = selec.toString();
        Object [] y = new String[conjunto1.length-1];
        int e = 0;
        for(int i=0; i<conjunto1.length; i++){
            if(!s.equals((String)conjunto1[i])){
                y[e] = conjunto1[i];
                System.out.print(y[e]+"   ");
                e++;
            }
        }
        return y;
    }

    public String[] getConjunto() {
        return conjunto;
    }

    public void setConjunto(String [] conjunto) {
        this.conjunto = conjunto;
        if(conjunto.length >0 ){
            conjunto1 = new Object[conjunto.length];
            for(int i=0; i<conjunto1.length; i++){
                conjunto1[i] =  (Object)conjunto[i];
            }
            make();
        }
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
        make();
    }

    public boolean isOrientacionVertical() {
        return orientacionVertical;
    }

    public void setOrientacionVertical(boolean orientacionVertical) {
        this.orientacionVertical = orientacionVertical;
        this.orientacionHorizontal = false;
        if(this.orientacionVertical){
            orientacion = VERTICAL;
            make();
        }
    }

    public boolean isOrientacionHorizontal() {
        return orientacionHorizontal;
    }

    public void setOrientacionHorizontal(boolean orientacionHorizontal) {
        this.orientacionHorizontal = orientacionHorizontal;
        this.orientacionVertical = false;
        if(orientacionHorizontal) {
            orientacion = HORIZONTAL;
            make();
        }
    }
    
    public Object [] getSeleccionados(){
        return new Object[]{combo1.getSelectedItem(),combo2.getSelectedItem()};
    }
    
    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new BorderLayout());
        
        JSelector selector = new JSelector();
        selector.setEtiquetas(new String[]{"Origen","Destino"});
        selector.setConjunto(new String[]{"Oaxaca","Puebla","CDMX"});
        selector.setOrientacionVertical(true);
        frame.add(selector,BorderLayout.CENTER);
        
        frame.setVisible(true);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
*/}
