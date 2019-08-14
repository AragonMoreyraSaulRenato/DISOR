/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.clases;
import practica.colecciones.Estudiantes;
import practica.colecciones.Inscritos;
import practica.colecciones.Pasantes;
import practica.iterador.Iterator;

/**
 *
 * @author drone
 */
public class ControlEscolar {
    Estudiantes estudiantes;
    Estudiantes pasantes;
    public ControlEscolar(){
        estudiantes = new Inscritos();
    }
    
    public void inscribir(Estudiante e){
        estudiantes.addEstudiante(e);
    }
    
    public void reinscribir(){
        Iterator it= estudiantes.getIterator();
        Estudiante obj=null;
        while(it.hasNext()){
            obj=(Estudiante)it.next();
            obj.setSemestre(obj.getSemestre()+1);
            obj.setCreditosCursos(obj.getCreditosCursos()+30);
        }
    }
    
    
    public void concluirResidencia(){
        Iterator it=estudiantes.getIterator();
        Estudiante obj = null;
        int cont = 0;
        while(it.hasNext()){
          obj= (Estudiante)it.next();
          obj.setCreditosResidencia(20);
          obj.setSemestre(obj.getSemestre()+1);
          cont ++;
        }
        it.restart();
        pasantes = new Pasantes(cont);
        while(it.hasNext()){
            pasantes.addEstudiante(it.next());
        }
    }
    
    public void imprimir(String TYPE){
        String format = "%-15s%-30s%-20s%-15s%-15s%-15s\n";
        System.out.printf(format,"NUM.CONTROL",
                "NOMBRE","CARRERA","SEMESTRE",
                "CRED.CURSOS","CRED.RESIDENCIA");
        Iterator it = null;
        
        switch(TYPE){   
            case "ESTUDIANTES":
                it=estudiantes.getIterator();
                break;
            case "PASANTES":
                it=pasantes.getIterator();
                break;
            default: break;
        }
        
        while(it.hasNext()){
            Estudiante obj= it.next();
            System.out.printf(format,
                   obj.getNumControl(),
                   obj.getNombre(),
                   obj.getCarrera(),
                   obj.getSemestre(),
                   obj.getCreditosCursos(),
                   obj.getCreditosResidencia());
        }
    }
}
