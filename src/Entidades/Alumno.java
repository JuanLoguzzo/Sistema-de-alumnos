package Entidades;

public class Alumno extends Usuario{
    private String nombre;
    private String apellido;


    public Alumno(long id,String nombreUsuario, String contraseña,  String nombre, String apellido) {
        super(id,nombreUsuario, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno() {
        super();
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

    @Override
    public String toString() {
        return super.toString() + "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
