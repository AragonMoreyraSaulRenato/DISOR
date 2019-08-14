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
import jwapahorcado.model.Jugadas;
import jwapahorcado.model.Palabra;

/**
 *
 * @author drone
 */
public class JugadasJpaController implements Serializable {

    public JugadasJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jugadas jugadas) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Palabra palabra = jugadas.getPalabra();
            if (palabra != null) {
                palabra = em.getReference(palabra.getClass(), palabra.getIdPalabra());
                jugadas.setPalabra(palabra);
            }
            em.persist(jugadas);
            if (palabra != null) {
                palabra.getJugadasCollection().add(jugadas);
                palabra = em.merge(palabra);
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

    public void edit(Jugadas jugadas) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Jugadas persistentJugadas = em.find(Jugadas.class, jugadas.getIdJugada());
            Palabra palabraOld = persistentJugadas.getPalabra();
            Palabra palabraNew = jugadas.getPalabra();
            if (palabraNew != null) {
                palabraNew = em.getReference(palabraNew.getClass(), palabraNew.getIdPalabra());
                jugadas.setPalabra(palabraNew);
            }
            jugadas = em.merge(jugadas);
            if (palabraOld != null && !palabraOld.equals(palabraNew)) {
                palabraOld.getJugadasCollection().remove(jugadas);
                palabraOld = em.merge(palabraOld);
            }
            if (palabraNew != null && !palabraNew.equals(palabraOld)) {
                palabraNew.getJugadasCollection().add(jugadas);
                palabraNew = em.merge(palabraNew);
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
                Integer id = jugadas.getIdJugada();
                if (findJugadas(id) == null) {
                    throw new NonexistentEntityException("The jugadas with id " + id + " no longer exists.");
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
            Jugadas jugadas;
            try {
                jugadas = em.getReference(Jugadas.class, id);
                jugadas.getIdJugada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugadas with id " + id + " no longer exists.", enfe);
            }
            Palabra palabra = jugadas.getPalabra();
            if (palabra != null) {
                palabra.getJugadasCollection().remove(jugadas);
                palabra = em.merge(palabra);
            }
            em.remove(jugadas);
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

    public List<Jugadas> findJugadasEntities() {
        return findJugadasEntities(true, -1, -1);
    }

    public List<Jugadas> findJugadasEntities(int maxResults, int firstResult) {
        return findJugadasEntities(false, maxResults, firstResult);
    }

    private List<Jugadas> findJugadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugadas.class));
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

    public Jugadas findJugadas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getJugadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugadas> rt = cq.from(Jugadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Jugadas> getUsuarioDesc(){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createNativeQuery("SELECT * FROM JUGADAS",Jugadas.class);
            return q.getResultList();
        }finally{
            em.close();
        }
    } 
    
     public Jugadas getUsuarioPorNombre(String nombre){
        EntityManager em=getEntityManager();
        try{
            List<Jugadas> user = findJugadasEntities();
            for(int i=0; i<user.size(); i++){
                if(user.get(i).getJugador().equals(nombre))
                    return user.get(i);
            }
        }finally{
            em.close();
        }
        return null;
    } 
    
}
