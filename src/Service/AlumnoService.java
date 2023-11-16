package Service;

import DAO.AlumnoDAO;
import DAO.DAOException;
import Entidades.Alumno;

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
}
