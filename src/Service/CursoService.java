package Service;


import DAO.CursoDAO;
import DAO.DAOException;
import DAO.ProfesorDAO;
import Entidades.Alumno;
import Entidades.Curso;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

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
    public JComboBox<Curso> cargarCursos(JComboBox<Curso> cursosComboBox) {
        try {
            ArrayList<Curso> cursos = this.cursoDao.buscarTodos();
            ProfesorService profesorService = new ProfesorService();
            Iterator var4 = cursos.iterator();

            while(var4.hasNext()) {
                Curso curso = (Curso)var4.next();
                curso.setProfesor(profesorService.buscar3Profesor(curso.getCorreoProfesor()));
                cursosComboBox.addItem(curso);
            }

            return cursosComboBox;
        } catch (ServiceException var6) {
            throw new RuntimeException(var6);
        } catch (DAOException var7) {
            throw new RuntimeException(var7);
        }
    }

}
