/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.directiva;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import jwapahorcado.controller.JugadasJpaController;
import jwapahorcado.controller.TipoJpaController;
import jwapahorcado.model.Jugadas;
import jwapahorcado.model.Tipo;

/**
 *
 * @author drone
 */
public class Directiva {
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    
        
    public List<Tipo> getTipos(){
        emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
        TipoJpaController tiposcontroller = new TipoJpaController(utx, emf);
        return tiposcontroller.findTipoEntities();
    }
    
    public String [] getDificultad(){
        return new String[]{"Novato","Medio","Dificil","Estas loco?"};
    }
    
    public List<Jugadas> getUsuariosDesc(){
        emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
        JugadasJpaController usuarioscontroller = new JugadasJpaController(utx,emf);
        List<Jugadas> user = usuarioscontroller.getUsuarioDesc();
        for(int i=0; i<user.size(); i++){
            System.out.println(user.get(i).getJugador());
        }
        return usuarioscontroller.getUsuarioDesc();
    }
    
    /**public boolean existUsuario(String nombre) throws Exception{
            System.out.println(nombre);
            emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
            JugadasJpaController usuarioscontroller = new JugadasJpaController(utx,emf);
            Jugadas u = usuarioscontroller.getUsuarioPorNombre(nombre);
            if(u != null){
                return nombre.equals(u.getJugador());
            }else{
                Jugadas x = new Jugadas();
                x.setJugador(nombre);
                x.setGanados(0);
                x.setPerdidos(0);
                x.setRacha(0);
                System.out.println(x.getNombre() +" "+ x.getGanados() +" "+ x.getPerdidos() +" "+ x.getRacha());
                usuarioscontroller.create(u);
                return false;
            }
    }**/
}
