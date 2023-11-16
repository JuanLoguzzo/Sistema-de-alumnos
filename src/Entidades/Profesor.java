package Entidades;

public class Profesor extends Usuario {
    private String nombre;
    private String apellido;

    public Profesor(long id, String nombreUsuario, String contraseña, String nombre, String apellido) {
        super(id, nombreUsuario, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
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
