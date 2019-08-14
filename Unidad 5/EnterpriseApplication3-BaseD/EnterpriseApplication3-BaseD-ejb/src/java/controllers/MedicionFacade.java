/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Medicion;
import models.Persona;

/**
 *
 * @author drone
 */
@Stateless
public class MedicionFacade extends AbstractFacade<Medicion> {

    @PersistenceContext(unitName = "EnterpriseApplication3-BaseD-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicionFacade() {
        super(Medicion.class);
    }
    
    public List<Medicion> medicionesByPersona(Persona p){
        Query consulta = em.createNamedQuery("Medicion.findByIdPersona");
        consulta.setParameter("idPersona", p);
        try{
            return (List<Medicion>) consulta.getResultList();
        }catch(Exception ex){ return null; }
    }
    
    public Medicion medicionesByFechaID(Medicion m){
        Query consulta = em.createNamedQuery("Medicion.findByFechaAndId");
        consulta.setParameter("idPersona", m.getIdPersona());
        consulta.setParameter("fecha", m.getFecha());
        try{
            return (Medicion) consulta.getSingleResult();
        }catch(Exception ex){ return null; }
    }
}
