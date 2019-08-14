/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    String [] oraciones = 
    {
        "Yo corro rapido","Yo corro despacio","Yo corro poco","Yo corro demasiado",
        "Yo corro amenudo","Yo como rapido","Yo como despacio","Yo como poco","Yo como demasiado",
        "Yo como saludable","Yo escribo rapido","Yo escribo despacio","Yo escribo poco","Yo escribo demasiado","Yo escribo poemas",
        "Yo escribo cartas","Yo escribo libros","Yo leo despacio","Yo leo poco","Yo leo demasiado","Yo leo poemas","Yo leo cartas",
        "Yo leo libros",
        "El corre rapido","El corre despacio","El corre poco","El corre demasiado",
        "El corre amenudo","El come rapido","El come despacio","El come poco","El come demasiado",
        "El come saludable","El escribe rapido","El escribe despacio","El escribe poco","El escribe demasiado","El escribe poemas",
        "El escribe cartas","El escribe libros","El lee despacio","El lee poco","El lee demasiado","El lee poemas","El lee cartas",
        "El lee libros",
        "Ella corre rapido","Ella corre despacio","Ella corre poco","Ella corre demasiado",
        "Ella corre amenudo","Ella come rapido","Ella come despacio","Ella come poco","Ella come demasiado",
        "Ella come saludable","Ella escribe rapido","Ella escribe despacio","Ella escribe poco","Ella escribe demasiado","Ella escribe poemas",
        "Ella escribe cartas","Ella escribe libros","Ella lee despacio","Ella lee poco","Ella lee demasiado","Ella lee poemas","Ella lee cartas",
        "Ella lee libros",
        "Tu corres rapido","Tu corres despacio","Tu corres poco","Tu corres demasiado",
        "Tu corres amenudo","Tu comes rapido","Tu comes despacio","Tu comes poco","Tu comes demasiado",
        "Tu comes saludable","Tu escribes rapido","Tu escribes despacio","Tu escribes poco","Tu escribes demasiado","Tu escribes poemas",
        "Tu escribes cartas","Tu escribes libros","Tu lees despacio","Tu lees poco","Tu lees demasiado","Tu lees poemas","Tu lees cartas",
        "Tu lees libros",
    };
    
    private String [] s = {"Yo","Tu","El","Ella"};
    private String [] v = {"corro","corre","corres","como","come","comes","esbribo","escribe","escribes","leo","lee","lees"};
    private String [] p = {"rapido","despacio","poco","demasiado","amenudo","saludable","poemas","cartas","libros","comics"};
    
    private String verbos = "";
    private String sujetos = "";
    private String predicados = "";
    
    private String sujeto ="";
    private String verbo = "";
    private String predicado = "";
    
    private String oracionRandom = "";
    private String mensaje = "";
    
    private String date = "";
    
    private int intentos= 0;
    
    public beanAdministrador(){
        Random r = new Random();
        oracionRandom = oraciones[new Integer(r.nextInt(oraciones.length))];
    }

    public String getSujeto() {
        return sujeto;
    }

    public void setSujeto(String sujeto) {
        this.sujeto = sujeto;
    }

    public String getVerbo() {
        return verbo;
    }

    public void setVerbo(String verbo) {
        this.verbo = verbo;
    }

    public String getPredicado() {
        return predicado;
    }

    public void setPredicado(String predicado) {
        this.predicado = predicado;
    }

    public String getMensaje() {
        if(oracionRandom.equals(sujeto+" "+verbo+" "+predicado)){
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "<h3>Haz adivinado la oracion! </h3><h3>" +oracionRandom+"</h3>";
        }else{
            intentos++;
            mensaje = "";
            System.out.println(oracionRandom);
            if(oracionRandom.contains(sujeto)) mensaje += "<p>Acertaste el sujeto</p>";
            if(oracionRandom.contains(verbo)) mensaje += "<p>Acertaste el verbo</p>";
            if(oracionRandom.contains(predicado)) mensaje += "<p>Acertaste el predicado</p>";
            if(!oracionRandom.contains(sujeto) && !oracionRandom.contains(verbo) && !oracionRandom.contains(predicado))
                mensaje += "<p>Revisa todo :C </p>";
            
            if(intentos > 3) mensaje += "<p>Pista 1: Sujeto: "+oracionRandom.split(" ")[0] + "</p>";
            if(intentos > 6) mensaje += "<p>Pista 2: Verbo: "+oracionRandom.split(" ")[1] + "</p>";
            if(intentos > 9) mensaje += "<p>Pista 3: Predicado: "+oracionRandom.split(" ")[2] + "</p>";
            
            mensaje += "<p>Oracion formada: "+sujeto+" "+verbo+" "+predicado+"</p>";
            
            return mensaje;
        }
    }    
    
    public String getDate(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        return f.format(new Date());
    }

    public String getVerbos() {
        verbos = "<select value = #{beanAdministrador.verbo}>";
        for (String v1 : v) {
            verbos += "<option  value=\"" + v1 + "\">" + v1 + "</option>\n";
        }
        verbos += "</select>";
        return verbos;
    }

    public String getSujetos() {
        sujetos = "<select value = #{beanAdministrador.sujeto}>";
        for (String v1 : s) {
            sujetos += "<option  value=\"" + v1 + "\">" + v1 + "</option>\n";
        }
        sujetos += "</select>";
        return sujetos;
    }

    public String getPredicados() {
        predicados = "<select value = #{beanAdministrador.predicado}>";
        for (String v1 : p) {
            predicados += "<option  value=\"" + v1 + "\">" + v1 + "</option>\n";
        }
        predicados += "</select>";
        return predicados;
    }
    
   
    
}
