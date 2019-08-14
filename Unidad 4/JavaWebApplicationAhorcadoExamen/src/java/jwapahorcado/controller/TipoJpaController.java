/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jwapahorcado.model.Palabra;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import jwapahorcado.controller.exceptions.NonexistentEntityException;
import jwapahorcado.controller.exceptions.RollbackFailureException;
import jwapahorcado.model.Tipo;

/**
 *
 * @author drone
 */
public class TipoJpaController implements Serializable {

    public TipoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipo tipo) throws RollbackFailureException, Exception {
        if (tipo.getPalabraCollection() == null) {
            tipo.setPalabraCollection(new ArrayList<Palabra>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Palabra> attachedPalabraCollection = new ArrayList<Palabra>();
            for (Palabra palabraCollectionPalabraToAttach : tipo.getPalabraCollection()) {
                palabraCollectionPalabraToAttach = em.getReference(palabraCollectionPalabraToAttach.getClass(), palabraCollectionPalabraToAttach.getIdPalabra());
                attachedPalabraCollection.add(palabraCollectionPalabraToAttach);
            }
            tipo.setPalabraCollection(attachedPalabraCollection);
            em.persist(tipo);
            for (Palabra palabraCollectionPalabra : tipo.getPalabraCollection()) {
                Tipo oldTipoOfPalabraCollectionPalabra = palabraCollectionPalabra.getTipo();
                palabraCollectionPalabra.setTipo(tipo);
                palabraCollectionPalabra = em.merge(palabraCollectionPalabra);
                if (oldTipoOfPalabraCollectionPalabra != null) {
                    oldTipoOfPalabraCollectionPalabra.getPalabraCollection().remove(palabraCollectionPalabra);
                    oldTipoOfPalabraCollectionPalabra = em.merge(oldTipoOfPalabraCollectionPalabra);
                }
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

    public void edit(Tipo tipo) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipo persistentTipo = em.find(Tipo.class, tipo.getIdTipo());
            Collection<Palabra> palabraCollectionOld = persistentTipo.getPalabraCollection();
            Collection<Palabra> palabraCollectionNew = tipo.getPalabraCollection();
            Collection<Palabra> attachedPalabraCollectionNew = new ArrayList<Palabra>();
            for (Palabra palabraCollectionNewPalabraToAttach : palabraCollectionNew) {
                palabraCollectionNewPalabraToAttach = em.getReference(palabraCollectionNewPalabraToAttach.getClass(), palabraCollectionNewPalabraToAttach.getIdPalabra());
                attachedPalabraCollectionNew.add(palabraCollectionNewPalabraToAttach);
            }
            palabraCollectionNew = attachedPalabraCollectionNew;
            tipo.setPalabraCollection(palabraCollectionNew);
            tipo = em.merge(tipo);
            for (Palabra palabraCollectionOldPalabra : palabraCollectionOld) {
                if (!palabraCollectionNew.contains(palabraCollectionOldPalabra)) {
                    palabraCollectionOldPalabra.setTipo(null);
                    palabraCollectionOldPalabra = em.merge(palabraCollectionOldPalabra);
                }
            }
            for (Palabra palabraCollectionNewPalabra : palabraCollectionNew) {
                if (!palabraCollectionOld.contains(palabraCollectionNewPalabra)) {
                    Tipo oldTipoOfPalabraCollectionNewPalabra = palabraCollectionNewPalabra.getTipo();
                    palabraCollectionNewPalabra.setTipo(tipo);
                    palabraCollectionNewPalabra = em.merge(palabraCollectionNewPalabra);
                    if (oldTipoOfPalabraCollectionNewPalabra != null && !oldTipoOfPalabraCollectionNewPalabra.equals(tipo)) {
                        oldTipoOfPalabraCollectionNewPalabra.getPalabraCollection().remove(palabraCollectionNewPalabra);
                        oldTipoOfPalabraCollectionNewPalabra = em.merge(oldTipoOfPalabraCollectionNewPalabra);
                    }
                }
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
                Integer id = tipo.getIdTipo();
                if (findTipo(id) == null) {
                    throw new NonexistentEntityException("The tipo with id " + id + " no longer exists.");
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
            Tipo tipo;
            try {
                tipo = em.getReference(Tipo.class, id);
                tipo.getIdTipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipo with id " + id + " no longer exists.", enfe);
            }
            Collection<Palabra> palabraCollection = tipo.getPalabraCollection();
            for (Palabra palabraCollectionPalabra : palabraCollection) {
                palabraCollectionPalabra.setTipo(null);
                palabraCollectionPalabra = em.merge(palabraCollectionPalabra);
            }
            em.remove(tipo);
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

    public List<Tipo> findTipoEntities() {
        return findTipoEntities(true, -1, -1);
    }

    public List<Tipo> findTipoEntities(int maxResults, int firstResult) {
        return findTipoEntities(false, maxResults, firstResult);
    }

    private List<Tipo> findTipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipo.class));
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

    public Tipo findTipo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipo> rt = cq.from(Tipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
