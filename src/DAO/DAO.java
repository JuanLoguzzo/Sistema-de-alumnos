package DAO;

import Entidades.Alumno;

import java.util.ArrayList;

public interface DAO<X> {
    public void guardar(X elemento) throws DAOException;
    public void modificar(X elemento) throws DAOException;
    public void eliminar(long id) throws DAOException;
    public X buscar(long id) throws DAOException;


}