/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicanegocio;

import controllers.PersonaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import models.Persona;

/**
 *
 * @author drone
 */
@Stateless
@LocalBean
public class PersonaLN {

    
    
    @EJB
    private PersonaFacade personaFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void registro(Persona p){
        personaFacade.create(p);
    }
    
    public List<Persona> personas(){
        return personaFacade.findAll();
    }
    
    public Persona findPersona(int idPersona){
        return personaFacade.find(idPersona);
    }
}