/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jformulario;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jtitleunique.JTitleUnique;
/**
 *
 * @author drone
 */
public class JFormulario extends JPanel{
    
    private int colums = 15;
    private int position = JTitleUnique.LEFT;
    private int type = JTitleUnique.TEXT;
    
    private int [] columnas;
    private int [] positions;
    private int [] types;
    private String [] titulos;
    private JTitleUnique [] preguntas;
    
    public JFormulario(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        titulos = new String[]{"titulo1"};
        types = new int[]{type};
        positions = new int[]{position};
        columnas = new int[]{colums};
        preguntas = new JTitleUnique[titulos.length];
        makeComponents();
    }

    private void makeComponents() {
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        preguntas = new JTitleUnique[titulos.length];
        for(int i=0; i<titulos.length; i++){
            preguntas[i] = new JTitleUnique();
            preguntas[i].setTitle(titulos[i]);
            preguntas[i].setType(types[i]);
            preguntas[i].setPosicion(positions[i]);
            preguntas[i].setColumnas(columnas[i]);
            this.add(preguntas[i]);
        }
        this.setVisible(true);
    }

    public int[] getPositions() {
        return positions;
    }

    public void setPositions(int[] positions) {
        if(titulos.length == positions.length){
            this.positions = positions;
            makeComponents();
        }
        else
            evalua();
    }

    public int[] getTypes() {
        return types;
    }

    public void setTypes(int[] types) {
        if(titulos.length == types.length){
            this.types = types;
            makeComponents();
        }
        else    
            evalua();
    }

    public int[] getColumnas() {
        return columnas;
    }

    public void setColumnas(int[] columnas) {
        if(titulos.length == columnas.length){
            this.columnas = columnas;
            makeComponents();
        }
        else
            evalua();
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String [] titulos) {
        this.titulos = titulos;
        evalua();
        makeComponents();
    }

    public int getColums() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
        evalua();
        makeComponents();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        evalua();
        makeComponents();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        evalua();
        makeComponents();
    }
    
    
    
    private void evalua(){
        positions = new int[titulos.length];
        for(int i=0; i<titulos.length; i++){
            positions[i] = position;
        }

        types = new int[titulos.length];
        for(int i=0; i<titulos.length; i++){
            types[i] = type;
        }

        columnas = new int[titulos.length];
        for(int i=0; i<titulos.length; i++){
            columnas[i] = colums;
        }
    }
    
    /*
    public static void main(String[] args){
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new BorderLayout());
        
        JFormulario formulario = new JFormulario();
        formulario.setTitulos(new String[]{"Pregunta 1","Pregunta 2","Pregunta 3"});
        //formulario.setSize(400, 400);
        
      
        //JPanel p = new JPanel(new BorderLayout());
        //p.add(new JTitleUnique(),BorderLayout.NORTH);
        
        //frame.add(p);
        frame.add(formulario,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }*/
    
}
