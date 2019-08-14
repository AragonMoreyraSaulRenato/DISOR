/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import logicanegocio.ActividadLN;
import logicanegocio.MedicionesLN;
import logicanegocio.PersonaLN;
import models.Actividad;
import models.Medicion;
import models.Persona;
import pojos.Validator;

/**
 *
 * @author drone
 */
@Named(value = "medicionBean")
@SessionScoped
public class MedicionBean implements Serializable {

    @EJB
    private ActividadLN actividadLN;
    @EJB
    private MedicionesLN medicionLN;
    @EJB
    private PersonaLN personaLN;
    
    private Medicion medicion;
    private Persona persona;
    
    private int idactividad;
    private int idpersona;
    private String mensaje = "";
    
    private boolean bandera = true;
    private String fecha_format ="";
    

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
        
    public void creaMedicion(ActionEvent e){
        medicion = new Medicion();
        generarFecha();
    }
    
    public Medicion getMedicion() {
        return medicion;
    }

    public void setMedicion(Medicion medicion) {
        this.medicion = medicion;
    }
    
    public void registraMedicion(ActionEvent e){
        if(isValidMedicion(medicion)){
            try{
                medicion.setIdAct(actividadLN.findActividad(idactividad));
                medicion.setIdPersona(persona);
                
                Medicion m = medicionLN.medicionByFechaID(medicion);
                if( m != null){
                    medicionLN.delete(m);
                }
                
                medicionLN.registro(medicion);
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.invalidateSession();
                ec.redirect(ec.getRequestContextPath()+"/faces/vista/listamediciones.xhtml");
            }catch(IOException ioe){
            
            }
        }
    } 
    
    public List<Medicion> mediciones(){
        return medicionLN.mediciones();
    }
    
    public List<Persona> personas(){
        return personaLN.personas();
    }
    
    public List<Actividad> actividades(){
        return actividadLN.actividades();
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    public void seleccionaPersona(ActionEvent e){
        persona = personaLN.findPersona(idpersona);
        bandera = persona == null;
                           
    }
    
    public void invalidateSession(ActionEvent e){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public boolean isValidMedicion(Medicion m){
        mensaje = "";
        Validator v = new Validator();
        
        if(persona == null )
            mensaje += "<strong>Persona</strong><br>";
        
        if(m.getFecha()== null || (m.getFecha()+"").equals("") )
            mensaje += "<strong>Fecha</strong><br>";
       
        if( !v.onlyNumbers(m.getPeso()+"") || m.getPeso()==null || (""+m.getPeso()).equals("") )
            mensaje += "<strong>Peso</strong><br>";
        
        if( !v.onlyNumbers(m.getCintura()+"") || m.getCintura()==null || (""+m.getCintura()).equals("") )
            mensaje += "<strong>Cintura</strong><br>";
        
        if( !v.onlyNumbers(m.getCadera()+"") || m.getCadera()==null || (""+m.getCadera()).equals("") )
            mensaje += "<strong>Cadera</strong><br>";
        
        if(mensaje.equals("")) return true;
        else{
            mensaje = "<p> Revisa los campos:<br>"+mensaje+"</p>";
            return false;
        }
    }
    
    public List<Medicion> medicionesByPersona(){
        if(persona == null){
            return mediciones();
        }
        else{
            return medicionLN.medicionesByPersona(persona);
        }
    }
    
    public String IMC(Medicion m){
        double estCM = m.getIdPersona().getEstatura() / 100;
        double imc = m.getPeso() / ( estCM * 2);
        return imc+"";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void generarFecha() {
        Date curDate = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate); 
        calendar.add(Calendar.DAY_OF_YEAR, (int)Math.random()*3+1);  
        Date newDate = calendar.getTime(); 
        
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        fecha_format = format.format(newDate);
        medicion.setFecha(newDate);
        
        //return DateToStr;
    }           

    public String getFecha_format() {
        return fecha_format;
    }

    public void setFecha_format(String fecha_format) {
        this.fecha_format = fecha_format;
    }
    
    
}
