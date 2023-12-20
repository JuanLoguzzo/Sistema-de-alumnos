package Service;


import DAO.CursoDAO;
import DAO.DAOException;
import Entidades.Curso;

public class CursoService {
    private CursoDAO cursoDao;

    public CursoService() {
        cursoDao = new CursoDAO();
    }
    public void guardarCurso(Curso curso) throws ServiceException {
        try {
           cursoDao.guardar(curso);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarCurso(Curso curso) throws ServiceException {
        try {
            cursoDao.modificar(curso);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }
    public void eliminarCurso(long codCurso) throws ServiceException{
        try {
            cursoDao.eliminar(codCurso);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Curso buscarCurso(long codCurso) throws ServiceException{
        Curso curso;
        try {
            curso = cursoDao.buscar(codCurso);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return curso;
    }

}
