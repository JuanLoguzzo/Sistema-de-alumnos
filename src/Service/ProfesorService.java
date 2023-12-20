package Service;


import DAO.DAOException;
import DAO.ProfesorDAO;
import Entidades.Profesor;

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
    public Profesor buscar2Profesor(String correo) throws ServiceException{
        Profesor profesor;
        try {
            profesor = profesorDao.buscar2(correo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return profesor;
    }
}
