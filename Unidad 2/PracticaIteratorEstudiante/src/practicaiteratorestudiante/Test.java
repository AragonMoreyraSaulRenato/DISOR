/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaiteratorestudiante;

import practica.clases.ControlEscolar;
import practica.clases.Estudiante;

/**
 *
 * @author drone
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlEscolar ce = new ControlEscolar();
        ce.inscribir(new Estudiante(15161,"Aragón Moreyra Saúl Renato","Ing. En Sistemas",1,0,0));
        ce.inscribir(new Estudiante(15162,"Ignacio Luis Luz Deisy","Ing. En Sistemas",1,0,0));
        ce.inscribir(new Estudiante(15163,"Lopez Altamirano Héctor","Ing. En Sistemas",1,0,0));
        ce.inscribir(new Estudiante(15164,"José Rios José","Ing. En Sistemas",1,0,0));
        ce.inscribir(new Estudiante(15165,"Niño Ruiz Candy","Ing. En Sistemas",1,0,0));
        ce.inscribir(new Estudiante(15166,"Jimenez Vivar Jesus","Ing. En Sistemas",1,0,0));
        
        System.out.println("Relacion de estudiantes INSCRITOS");
        ce.imprimir("ESTUDIANTES");
        
        for(int i=1; i<9; i++)  ce.reinscribir();
        
        System.out.println("\nAl cursar el 9 semestre concluyeron sus creditos de las materias");
        System.out.println("Relacion de estudiantes INSCRITOS");
        ce.imprimir("ESTUDIANTES");
        
        System.out.println("\nRelacion de estudiantes PASANTES");
        ce.concluirResidencia();
        ce.imprimir("PASANTES");
    }
    
}
