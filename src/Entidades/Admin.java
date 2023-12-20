package Entidades;

import java.util.ArrayList;

public class Admin extends Usuario {
    private ArrayList <Curso> cursos = new ArrayList();



    public Admin(String correo, String contraseña, ArrayList<Curso> cursos) {
        super(correo, contraseña);
        this.cursos = cursos;
    }

    public Admin(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public Admin(){
    }

    public Admin(String correo, String contraseña ) {
        super(correo, contraseña);

    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }



}
