/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import jwapahorcado.controller.exceptions.NonexistentEntityException;
import jwapahorcado.controller.exceptions.RollbackFailureException;
import jwapahorcado.model.Palabra;
import jwapahorcado.model.Tipo;

/**
 *
 * @author drone
 */
public class PalabraJpaController implements Serializable {

    public PalabraJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Palabra palabra) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipo tipo = palabra.getTipo();
            if (tipo != null) {
                tipo = em.getReference(tipo.getClass(), tipo.getIdTipo());
                palabra.setTipo(tipo);
            }
            em.persist(palabra);
            if (tipo != null) {
                tipo.getPalabraCollection().add(palabra);
                tipo = em.merge(tipo);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Palabra palabra) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Palabra persistentPalabra = em.find(Palabra.class, palabra.getIdPalabra());
            Tipo tipoOld = persistentPalabra.getTipo();
            Tipo tipoNew = palabra.getTipo();
            if (tipoNew != null) {
                tipoNew = em.getReference(tipoNew.getClass(), tipoNew.getIdTipo());
                palabra.setTipo(tipoNew);
            }
            palabra = em.merge(palabra);
            if (tipoOld != null && !tipoOld.equals(tipoNew)) {
                tipoOld.getPalabraCollection().remove(palabra);
                tipoOld = em.merge(tipoOld);
            }
            if (tipoNew != null && !tipoNew.equals(tipoOld)) {
                tipoNew.getPalabraCollection().add(palabra);
                tipoNew = em.merge(tipoNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = palabra.getIdPalabra();
                if (findPalabra(id) == null) {
                    throw new NonexistentEntityException("The palabra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Palabra palabra;
            try {
                palabra = em.getReference(Palabra.class, id);
                palabra.getIdPalabra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The palabra with id " + id + " no longer exists.", enfe);
            }
            Tipo tipo = palabra.getTipo();
            if (tipo != null) {
                tipo.getPalabraCollection().remove(palabra);
                tipo = em.merge(tipo);
            }
            em.remove(palabra);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Palabra> findPalabraEntities() {
        return findPalabraEntities(true, -1, -1);
    }

    public List<Palabra> findPalabraEntities(int maxResults, int firstResult) {
        return findPalabraEntities(false, maxResults, firstResult);
    }

    private List<Palabra> findPalabraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Palabra.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Palabra findPalabra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Palabra.class, id);
        } finally {
            em.close();
        }
    }

    public int getPalabraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Palabra> rt = cq.from(Palabra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
