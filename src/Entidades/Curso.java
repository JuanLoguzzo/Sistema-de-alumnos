package Entidades;

public class Curso {
    private long codCurso;
    private String nombreCurso;
    private String nombreProfesor;
    private int cupoCurso;
    private int precioCurso;


    public Curso( String nombreCurso, String nombreProfesor, int cupoCurso, int precioCurso) {
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.cupoCurso = cupoCurso;
        this.precioCurso = precioCurso;

    }

    public Curso() {

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


}
