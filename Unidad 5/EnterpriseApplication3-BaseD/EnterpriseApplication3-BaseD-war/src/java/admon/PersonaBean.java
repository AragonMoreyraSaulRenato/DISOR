/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import logicanegocio.PersonaLN;
import models.Persona;
import pojos.Validator;

/**
 *
 * @author drone
 */
@Named(value = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable{

    @EJB
    private PersonaLN personaLN;
    
    private Persona persona;
    private int personaBuscada;
    private String mensaje ="";
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registroPersona(ActionEvent e){
        System.out.println(mensaje);
        if(isValidPersona(persona))  {
            try{
                personaLN.registro(persona);
                invalidateSession(e);
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.invalidateSession();
                ec.redirect(ec.getRequestContextPath()+"/faces/vista/listapersonas.xhtml");
            }catch(IOException  ioex){
            
            }
        }
    }
        
    public void creaPersona(ActionEvent e){
        persona = new Persona();
    }
    
    public List<Persona> personas(){
        return personaLN.personas();
    }

    public int getPersonaBuscada() {
        return personaBuscada;
    }

    public void setPersonaBuscada(int personaBuscada) {
        this.personaBuscada = personaBuscada;
    }
        
    public void findPersona(){
        persona =  personaLN.findPersona(personaBuscada);
    }
    
    public void invalidateSession(ActionEvent e){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    private boolean isValidPersona(Persona p){
        Validator v = new Validator();
        mensaje = "";
        
        
        if(!v.onlyLetters(p.getNombre()) || p.getNombre()==null || p.getNombre().equals(""))
            mensaje += "<strong>Nombre</strong><br>";
        
        if(p.getFechaNac() == null || (p.getFechaNac()+"").equals("") )
            mensaje += "<strong>Fecha</strong><br>";
        
        if(p.getSexo() == null || (!p.getSexo().equals('H') || !p.getSexo().equals('H')))
            mensaje += "<strong>Sexo</strong><br>";
        
        
        if(!v.onlyNumbers(p.getEstatura()+"") || p.getEstatura()==null || (""+p.getEstatura()).equals("") || (p.getEstatura() < 100 || p.getEstatura() > 230))
            mensaje += "<strong>(99 < Estatura < 230 )</strong><br>";
        
        if(!evaluaFecha(p.getFechaNac())){ 
            mensaje += "<strong>Eres menor de edad!</strong><br>";
            System.out.println("FECHAAAAAA VALIDA" + evaluaFecha(p.getFechaNac()));
        }
        
        if(mensaje.equals("")) return true;
        else{
            mensaje = "Revisa los campos: <br/>"+mensaje;
            return false;
        }
    }
    
    private boolean evaluaFecha(Date d){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String [] fecha_format = format.format(d).split("-");
        int yer = Integer.parseInt(fecha_format[2]);
        System.out.println("aÑOPO" + (yer < 2000));
        return yer < 2000;
    }
}
