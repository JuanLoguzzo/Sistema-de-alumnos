package Entidades;

public class Curso {
    private long codCurso;
    private String nombreCurso;
    private String nombreProfesor;
    private int cupoCurso;
    private int precioCurso;

    private String fechaInicio;
    private String fechaFin;

    public Curso(long codCurso, String nombreCurso, String nombreProfesor, int cupoCurso, int precioCurso, String fechaInicio, String fechaFin) {
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.cupoCurso = cupoCurso;
        this.precioCurso = precioCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
