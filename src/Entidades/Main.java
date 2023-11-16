package Entidades;


import GUI.UsuarioGUI;
import Service.AlumnoService;
import Service.ServiceException;

public class Main {
    public static void main(String[] args) throws ServiceException {

        AlumnoService alumnoService = new AlumnoService();

        Alumno alumno1 = new Alumno();
        //alumno1.setId();
        alumno1.setNombreUsuario("jloguz");
        alumno1.setContraseña("100");
        alumno1.setNombre("juan");
        alumno1.setApellido("loguzzo");

        Alumno alumno2 = new Alumno();
        //alumno2.setId();
        alumno2.setNombreUsuario("oriego");
        alumno2.setContraseña("101");
        alumno2.setNombre("octavio");
        alumno2.setApellido("riego");

        new UsuarioGUI();
/*
       try {
            alumnoService.guardarAlumno(alumno1);
            alumnoService.guardarAlumno(alumno2);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

*/

        /*
        try {
            alumnoService.modificarAlumno(alumno1);
            alumnoService.modificarAlumno(alumno2);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }*/

        /*
        try {
            alumnoService.buscarAlumno(1);
            System.out.println("ID: " + alumno1.getId() + " NOMBREUSUARIO: " + alumno1.getNombreUsuario() + "  CONTRASEÑA: " +alumno1.getContraseña() + " NOMBRE: " + alumno1.getNombre() + " APELLIDO: " + alumno1.getApellido() );
            alumnoService.buscarAlumno(2);
            System.out.println("ID: " + alumno2.getId() + " NOMBREUSUARIO: " + alumno2.getNombreUsuario() + "  CONTRASEÑA: " +alumno2.getContraseña() + " NOMBRE: " + alumno2.getNombre() + " APELLIDO: " + alumno2.getApellido() );
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
*/
/*
        try {
            alumnoService.eliminarAlumno(1);

        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
*/
        /*
        try {

            alumno1.setId(3);
            alumno1.setNombreUsuario("jorgito");
            alumno1.setContraseña("dsadadas");
            alumno1.setNombre("jorgesito");
            alumno1.setApellido("alfajorsito");
            alumnoService.modificarAlumno(alumno1);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }*/


    }
}