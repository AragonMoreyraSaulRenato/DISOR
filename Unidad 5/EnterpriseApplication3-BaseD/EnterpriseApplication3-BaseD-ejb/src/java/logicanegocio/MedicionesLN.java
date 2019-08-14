/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicanegocio;

import controllers.MedicionFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import models.Medicion;
import models.Persona;

/**
 *
 * @author drone
 */
@Stateless
@LocalBean
public class MedicionesLN {

    @EJB
    private MedicionFacade medicionFacade;
    
    private Medicion medicion;
    
    public void registro(Medicion p){
        medicionFacade.create(p);
    }
    
    public List<Medicion> mediciones(){
        return medicionFacade.findAll();
    }
    
    public List<Medicion> medicionesByPersona(Persona p){
        return medicionFacade.medicionesByPersona(p);
    }
    
    public Medicion medicionByFechaID(Medicion m){
        return medicionFacade.medicionesByFechaID(m);
    }
    public void delete(Medicion m){
        medicionFacade.remove(m);
    }
}
