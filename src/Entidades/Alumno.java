package Entidades;

public class Alumno extends Usuario{
    private String nombre;
    private String apellido;



    public Alumno(String correo, String contraseña,  String nombre, String apellido) {
        super(correo, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno(String correo, String contraseña) {
        super(correo, contraseña);
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
