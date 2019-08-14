/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Actividad;

/**
 *
 * @author drone
 */
@Stateless
public class ActividadFacade extends AbstractFacade<Actividad> {

    @PersistenceContext(unitName = "EnterpriseApplication3-BaseD-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }
    
}
