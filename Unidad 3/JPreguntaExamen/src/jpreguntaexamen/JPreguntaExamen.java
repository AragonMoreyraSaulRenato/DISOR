/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpreguntaexamen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author drone
 */
public class JPreguntaExamen extends JPanel{
    public static final int VERTICAL = 1;
    public static final int HORIZONTAL = 2;
    
    public static final int RADIO = 1;
    public static final int CHECK = 2;
    public static final int COMBO = 3;
    
    private int tipoPregunta = RADIO;
    
    private int orientation = VERTICAL;
    private String encabezado;
    private JPanel panelOpciones;
    private JLabel labeltitulo;
    private JLabel labelcorrectas;
    private String [] opciones;
    private String [] respuestas;
    private int [] correctas;
    
    
    private JButton check;
    private JRadioButton [] radioButtons;
    private JCheckBox [] checkButtons;
    private JLabel [] comboLabels;
    private JComboBox [] comboOptions;
    
    private boolean orientacionVertical, orientacionHorizontal;
    private boolean tipoRadio, tipoCheck, tipoComboBox;
    private boolean showCheck;
    
    public JPreguntaExamen(){
        this.setLayout(new BorderLayout());
        labeltitulo = new JLabel("Pregunta 1");
        
        this.add(labeltitulo,BorderLayout.NORTH);
        
        opciones = new String[]{"Opcion 1","Opcion 2","Opcion 3"};
        radioButtons = new JRadioButton[opciones.length];
        panelOpciones = new JPanel();
        showCheck = false;
        makeRadios();
    }

    private void makeChecks(){
        checkButtons = new JCheckBox[opciones.length];
        panelOpciones.removeAll();
        switch(orientation){
            case VERTICAL:
                panelOpciones.setLayout(new BoxLayout(panelOpciones,BoxLayout.Y_AXIS));
                break;
            case HORIZONTAL:
                panelOpciones.setLayout(new BoxLayout(panelOpciones,BoxLayout.X_AXIS));
                break;
        }
        for(int i=0; i<opciones.length; i++){
            checkButtons[i] = new JCheckBox(opciones[i]);
            panelOpciones.add(checkButtons[i]);
        }
        this.add(panelOpciones,BorderLayout.CENTER);
    }
    
    private void makeRadios() {
        radioButtons = new JRadioButton[opciones.length];
        ButtonGroup group = new ButtonGroup();
        panelOpciones.removeAll();
        switch(orientation){
            case VERTICAL:
                panelOpciones.setLayout(new BoxLayout(panelOpciones,BoxLayout.Y_AXIS));
                break;
            case HORIZONTAL:
                panelOpciones.setLayout(new BoxLayout(panelOpciones,BoxLayout.X_AXIS));
                break;
        }
        for(int i=0; i<opciones.length; i++){
            radioButtons[i] = new JRadioButton(opciones[i]);
            group.add(radioButtons[i]);
            panelOpciones.add(radioButtons[i]);
        }
        this.add(panelOpciones,BorderLayout.CENTER);
    }

    private void makeCombos(){
        comboOptions = new JComboBox[opciones.length];
        comboLabels = new JLabel[opciones.length];
        panelOpciones.removeAll();
        switch(orientation){
            case VERTICAL:
                panelOpciones.setLayout(new GridLayout(opciones.length,2));
                break;
            case HORIZONTAL:
                panelOpciones.setLayout(new BoxLayout(panelOpciones,BoxLayout.X_AXIS));
                break;
        }
        evalua();
        for(int i=0; i<opciones.length; i++){
            comboLabels[i] = new JLabel(opciones[i]);
            comboOptions[i] = new JComboBox();
            for (String respuesta : respuestas) {
                comboOptions[i].addItem(respuesta);
            }
            
            panelOpciones.add(comboLabels[i]);
            panelOpciones.add(comboOptions[i]);
                    
        }
        this.add(panelOpciones,BorderLayout.CENTER);
    }
    
    private void evalua(){
        if(respuestas == null){
            respuestas = new String[opciones.length];
            for(int i=0; i<opciones.length; i++){
                respuestas[i] = "Error";
            }
        }
    }
    
    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int optionOrientation) {
        this.orientation = optionOrientation;
        make();
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String titulo) {
        this.encabezado = titulo;
        this.labeltitulo.setText(encabezado);
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
        make();
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
        tipoPregunta = COMBO;
        make();
    }

    public int getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(int tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
        evalua();
        make();
    }
        
    private void make(){
        
        switch(tipoPregunta){
            case RADIO:
                makeRadios();
                break;
            case CHECK:
                makeChecks();
                break;
            case COMBO:
                if(respuestas != null)
                    makeCombos();
                break;
        }
        if(showCheck){
            check = new JButton("Check!");
            labelcorrectas = new JLabel("Correctas: ");
            check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    labelcorrectas.setText("Correctas: "+getCalificacion());
                }
            });
            this.add(check,BorderLayout.EAST);
            this.add(labelcorrectas,BorderLayout.SOUTH);
        }
    }
    
    public boolean isOrientacionVertical() {
        return orientacionVertical;
    }

    public void setOrientacionVertical(boolean orientacionVertical) {
        this.orientacionVertical = orientacionVertical;
        this.orientacionHorizontal = false;
        if(!orientacionVertical)
            this.orientacionVertical = true;
        setOrientation(VERTICAL);         
    }

    public boolean isOrientacionHorizontal() {
        return orientacionHorizontal;
    }

    public void setOrientacionHorizontal(boolean orientacionHorizontal) {
        this.orientacionHorizontal = orientacionHorizontal;
        this.orientacionVertical = false;
        if(!orientacionHorizontal)
            this.orientacionHorizontal = true;
        setOrientation(HORIZONTAL); 
    }
    
    public  HashMap getContestadas(){
        HashMap diccionario  = new HashMap<>();
        switch(tipoPregunta){
            case RADIO:{
                for(int i=0; i<opciones.length; i++){
                    diccionario.put(radioButtons[i].getText(),radioButtons[i].isSelected());
                }
            }
            
            case CHECK:{
                for(int i=0; i<opciones.length; i++){
                    diccionario.put(checkButtons[i].getText(),checkButtons[i].isSelected());
                }
            }
            case COMBO:{
                for(int i=0; i<opciones.length; i++){
                    diccionario.put(comboLabels[i].getText(),comboOptions[i].getSelectedItem());
                }
            }
        }
        return diccionario;
    }
    
    public boolean isTipoRadio() {
        return tipoRadio;
    }

    public void setTipoRadio(boolean tipoRadio) {
        this.tipoRadio = tipoRadio;
        this.tipoCheck = false;
        this.tipoComboBox = false;
        if(!tipoRadio)
            this.tipoRadio = true;
        setTipoPregunta(RADIO); 
    }

    public boolean isTipoCheck() {
        return tipoCheck;
    }

    public void setTipoCheck(boolean tipoCheck) {
        this.tipoCheck = tipoCheck;
        this.tipoRadio = false;
        this.tipoComboBox = false;
        if(!tipoCheck)
            this.tipoCheck = true;
        setTipoPregunta(CHECK); 
        
    }

    public boolean isTipoComboBox() {
        return tipoComboBox;
    }

    public void setTipoComboBox(boolean tipoComboBox) {
        this.tipoComboBox = tipoComboBox;
        this.tipoRadio = false;
        this.tipoCheck = false;
        if(!tipoComboBox)
            this.tipoComboBox = true;
        setTipoPregunta(COMBO); 
    }

    public int[] getCorrectas() {
        return correctas;
    }

    public void setCorrectas(int[] correctas) {
        this.correctas = correctas;
    }

    public int getCalificacion(){
        if(correctas != null){
            switch(tipoPregunta){
                case RADIO:{
                    int acum =0;
                    for (int i = 0; i < radioButtons.length; i++) {
                        boolean cor = correctas[i] == 1;
                        System.out.println("RADIO:"+radioButtons[i].isSelected() + " RESP: " +cor + " CORRE: "+correctas[i]);
                        if(radioButtons[i].isSelected() == cor && radioButtons[i].isSelected() == true){
                            acum ++;
                        }
                    }
                    return acum;
                }
                case CHECK:{
                    int acum = 0;
                    if(checkButtons.length == correctas.length){
                        for(int i=0; i < checkButtons.length; i++){
                            boolean cor = correctas[i] == 1;
                            if(checkButtons[i].isSelected() == cor && checkButtons[i].isSelected() == true){
                                acum ++;
                            }
                        }
                    }
                    return acum;
                }
                case COMBO:{
                    int acum = 0;
                    if(comboOptions.length == correctas.length){
                        for(int i=0; i<comboOptions.length; i++){
                            if(comboOptions[i].getSelectedIndex() == correctas[i]){
                                acum ++;
                            }
                        }
                    }
                    return acum;
                }
            }
        }
        return 0;
    }

    public boolean isShowCheck() {
        return showCheck;
    }

    public void setShowCheck(boolean showCheck) {
        this.showCheck = showCheck;
        make();
    }
        
    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame("PRUEBA");
        frame.setLayout(new BorderLayout());
        
        JPreguntaExamen pregunta = new JPreguntaExamen();
        pregunta.setOpciones(new String []{"1+1","2+2","3+3"});
        pregunta.setRespuestas(new String[]{"2","4","6"});
        pregunta.setOrientation(JPreguntaExamen.VERTICAL);
        pregunta.setEncabezado("Sexo: ");
        pregunta.setTipoPregunta(JPreguntaExamen.COMBO);
        pregunta.setShowCheck(true);
                
        pregunta.setCorrectas(new int[]{0,1,2});
        frame.add(pregunta);
        frame.setVisible(true);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    */
}
