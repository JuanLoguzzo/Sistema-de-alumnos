package Service;

import DAO.AlumnoDAO;
import DAO.DAOException;
import Entidades.Alumno;
import GUI.HomeAlumnoGUI;

import javax.swing.*;
import java.awt.*;

public class AlumnoService {
    private AlumnoDAO alumnoDao;

    public AlumnoService() {
         alumnoDao = new AlumnoDAO();
    }
    public void guardarAlumno(Alumno alumno) throws ServiceException {
        try {
            alumnoDao.guardar(alumno);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarAlumno(Alumno alumno) throws ServiceException {
        try {
            alumnoDao.modificar(alumno);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }
    public void eliminarAlumno(long id) throws ServiceException{
        try {
            alumnoDao.eliminar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Alumno buscarAlumno(long id) throws ServiceException{
        Alumno alumno;
        try {
            alumno = alumnoDao.buscar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return alumno;
    }
    public boolean buscar2Alumno(String correo, String contraseña, JFrame frame) {
        try {
            Alumno alumno = alumnoDao.buscar2(correo);

            if (alumno != null) {
                if (alumno.getContraseña().equals(contraseña)) {
                    if (alumno.getCorreo().equals(correo)) {
                        new HomeAlumnoGUI(alumno, frame);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Nombre de usuario o contraseña incorrectos", "ADVERTENCIA", 2);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Nombre de usuario o contraseña incorrectos", "ADVERTENCIA", 2);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "Usuario inexistente", "ADVERTENCIA", 2);
                return false;
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    public Alumno buscar3Alumno(String correo) throws ServiceException{
        Alumno alumno;
        try {
            alumno = alumnoDao.buscar3(correo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return alumno;
    }
}
