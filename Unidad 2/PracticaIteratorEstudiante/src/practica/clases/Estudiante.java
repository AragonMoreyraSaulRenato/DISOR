/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.clases;

/**
 *
 * @author drone
 */
public class Estudiante {

    private int numControl;
    private String nombre;
    private String carrera;
    private int semestre;
    private int creditosCursos;
    private int creditosResidencia;
    
    public Estudiante(int numControl, String nombre, String carrera, int semestre, int creditosCursos, int creditosResidencia) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.creditosCursos = creditosCursos;
        this.creditosResidencia = creditosResidencia;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditosCursos() {
        return creditosCursos;
    }

    public void setCreditosCursos(int creditosCursos) {
        this.creditosCursos = creditosCursos;
    }

    public int getCreditosResidencia() {
        return creditosResidencia;
    }

    public void setCreditosResidencia(int creditosResidencia) {
        this.creditosResidencia = creditosResidencia;
    }
}
