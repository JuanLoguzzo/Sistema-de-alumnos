package Entidades;

import DAO.AlumnoDAO;
import DAO.DAOException;
import DAO.ProfesorDAO;
import Service.AlumnoService;

import java.util.ArrayList;

public class Inscripciones {

    private long codCurso;
    private String nombreCurso;
    private int precioCurso;
    private int cupoCurso;
    private String nombreProfesor;
    private Profesor porfesor;
    private String nombreAlumno;
    private String apellidoAlumno;
    private Alumno alumno;
    private int notaFinalAlumno;


    public Inscripciones(long codCurso, String nombreCurso, int precioCurso, int cupoCurso, String nombreProfesor, Profesor porfesor, String nombreAlumno, String apellidoAlumno, Alumno alumno, int notaFinalAlumno) {
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.precioCurso = precioCurso;
        this.cupoCurso = cupoCurso;
        this.nombreProfesor = nombreProfesor;
        this.porfesor = porfesor;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.alumno = alumno;
        this.notaFinalAlumno = notaFinalAlumno;
    }

    public int getNotaFinalAlumno() {
        return notaFinalAlumno;
    }

    public void setNotaFinalAlumno(int notaFinalAlumno) {
        this.notaFinalAlumno = notaFinalAlumno;
    }

    public int getCupoCurso() {
        return cupoCurso;
    }

    public void setCupoCurso(int cupoCurso) {
        this.cupoCurso = cupoCurso;
    }



    public long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(long codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(int precioCurso) {
        this.precioCurso = precioCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public Profesor getPorfesor() {
        return porfesor;
    }

    public void setPorfesor(Profesor porfesor) {
        this.porfesor = porfesor;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
