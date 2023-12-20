package Service;

import DAO.AdminDAO;
import DAO.CursoDAO;
import DAO.DAOException;
import Entidades.Admin;
import Entidades.Alumno;
import Entidades.Curso;
import GUI.HomeAdminGUI;
import GUI.HomeAlumnoGUI;

import javax.swing.*;
import java.awt.*;


public class AdminService {
    private AdminDAO adminDao = new AdminDAO();
    private CursoService cursoService = new CursoService();

    public AdminService() {
    }

    public void guardarAdmin(Admin admin) throws ServiceException {
        try {
            this.adminDao.guardar(admin);
        } catch (DAOException var3) {
            throw new ServiceException(var3.getMessage());
        }
    }
    public void GuardarCurso(Curso curso) throws ServiceException{
        try {

            cursoService.guardarCurso(curso);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

    }
    public boolean buscar2Admin(String correo, String contraseña, JFrame frame) {
        try {
            Admin admin = adminDao.buscar2(correo);

            if (admin != null) {
                if (admin.getContraseña().equals(contraseña)) {
                    if (admin.getCorreo().equals(correo)) {
                        new HomeAdminGUI(admin, frame);
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
}
