package Entidades;

public abstract class Usuario {
    private String correo;
    private String contraseña;

    private long id;


    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario() {

    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String nombreUsuario) {
        this.correo = nombreUsuario;
    }




    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
