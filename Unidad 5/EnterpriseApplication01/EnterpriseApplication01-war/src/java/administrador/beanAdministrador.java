/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author drone
 */
@Named(value = "beanAdministrador")
@SessionScoped
public class beanAdministrador implements Serializable {

    private final Integer MAX_VALUE = 500;
    private Integer numeroAdivinar = 0;
    private Integer numeroAleatorio;
    private String pista = "";
    private String mensaje = "";
    /**
     * Creates a new instance of BeanAdministrador
     */
    public beanAdministrador() {
        Random valorAleatorio = new Random();
        numeroAleatorio = new Integer(valorAleatorio.nextInt(MAX_VALUE));
    }

    public Integer getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(Integer numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public Integer getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(Integer numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }    

    public String getMensaje() {
        if(numeroAdivinar.equals(numeroAleatorio)){
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "Adivinaste!";
        }
        else{
            return numeroAdivinar>numeroAleatorio? "El numero debe ser menor a: "+numeroAdivinar:"El numero debe ser mayor a: "+numeroAdivinar;
        }
    }
}
