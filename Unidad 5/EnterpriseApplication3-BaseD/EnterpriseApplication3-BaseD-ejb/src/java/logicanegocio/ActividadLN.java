/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicanegocio;

import controllers.ActividadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import models.Actividad;

/**
 *
 * @author drone
 */
@Stateless
@LocalBean
public class ActividadLN {

    @EJB
    private ActividadFacade actividadFacade;

    public void registro(Actividad p){
        actividadFacade.create(p);
    }
    
    public List<Actividad> actividades(){
        return actividadFacade.findAll();
    }
    
    public Actividad findActividad(int idAct){
        return actividadFacade.find(idAct);
    }
      
}
