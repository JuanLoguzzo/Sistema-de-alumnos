package Entidades;

import java.util.ArrayList;

public class Curso {
    private int codCurso;
    private String nombreCurso;
    private String nombreProfesor;
    private String correoProfesor;
    private Profesor profesor;
    private int cupoCurso;
    private int precioCurso;
    private  ArrayList<Alumno> alumnos = new ArrayList();


    public Curso(int codCurso, String nombreCurso, String nombreProfesor, Profesor profesor,String correoProfesor, int cupoCurso, int precioCurso, ArrayList<Alumno> alumnos) {
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.correoProfesor = correoProfesor;
        this.profesor = profesor;
        this.cupoCurso = cupoCurso;
        this.precioCurso = precioCurso;
        this.alumnos = alumnos;
    }
    public Curso(int codCurso, String nombreCurso, String nombreProfesor,String correoProfesor, int cupoCurso, int precioCurso) {
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.correoProfesor = correoProfesor;
        this.cupoCurso = cupoCurso;
        this.precioCurso = precioCurso;
    }


    public Curso() {

    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getCupoCurso() {
        return cupoCurso;
    }

    public void setCupoCurso(int cupoCurso) {
        this.cupoCurso = cupoCurso;
    }

    public int getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(int precioCurso) {
        this.precioCurso = precioCurso;
    }


}
