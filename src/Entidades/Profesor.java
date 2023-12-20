package Entidades;

public class Profesor extends Usuario {
    private String nombre;
    private String apellido;

    public Profesor(String correo, String contraseña, String nombre, String apellido) {
        super(correo, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Profesor(String correo, String contraseña) {
        super(correo, contraseña);
    }

    public Profesor() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
