package Service;


import DAO.DAOException;
import DAO.ProfesorDAO;
import Entidades.Alumno;
import Entidades.Profesor;
import GUI.HomeAlumnoGUI;
import GUI.HomeProfesoresGUI;

import javax.swing.*;
import java.awt.*;

public class ProfesorService {

    private ProfesorDAO profesorDao;

    public ProfesorService() {

        profesorDao = new ProfesorDAO();
    }
    public void guardarProfesor(Profesor profesor) throws ServiceException {
        try {
            profesorDao.guardar(profesor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarProfesor(Profesor profesor) throws ServiceException {
        try {
            profesorDao.modificar(profesor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }
    public void eliminarProfesor(long id) throws ServiceException{
        try {
            profesorDao.eliminar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Profesor buscarProfesor(long id) throws ServiceException{
        Profesor profesor;
        try {
            profesor = profesorDao.buscar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return profesor;
    }
    public boolean buscar2Profesor(String correo, String contraseña, JFrame frame) {
        try {
            Profesor profesor = profesorDao.buscar2(correo);

            if (profesor != null) {
                if (profesor.getContraseña().equals(contraseña)) {
                    if (profesor.getCorreo().equals(correo)) {
                        new HomeProfesoresGUI(profesor, frame);
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
    public Profesor buscar3Profesor(String correo) throws ServiceException{
        Profesor profesor;
        try {
            profesor = profesorDao.buscar3(correo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return profesor;
    }
}
