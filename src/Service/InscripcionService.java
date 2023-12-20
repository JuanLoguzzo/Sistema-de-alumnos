package Service;

import DAO.DAOException;
import DAO.InscripcionesDAO;
import Entidades.Inscripciones;

import javax.swing.*;
import java.awt.*;

public class InscripcionService {
    private InscripcionesDAO inscripcionesDao = new InscripcionesDAO();

    public InscripcionService() {
    }

    public void GuardarInscripcion(Inscripciones inscripcion) throws ServiceException {
        try {
            this.inscripcionesDao.guardar(inscripcion);
        } catch (DAOException var3) {
            throw new ServiceException(var3.getMessage());
        }
    }

    public void guardarInscripcion(Inscripciones inscripcion) throws ServiceException {
        InscripcionService inscripcionService = new InscripcionService();
        inscripcionService.GuardarInscripcion(inscripcion);
        JOptionPane.showMessageDialog((Component)null, "Inscripcion realizada con exito", "Informacion", 1);
    }
}
