package DAO;

import Entidades.Alumno;
import Entidades.Inscripciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscripcionesDAO implements DAO<Inscripciones>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:\\Users\\juanl\\IdeaProjects\\Turnera media";
    private String DB_USER ="sa";
    private String DB_PASSWORD = "";

    @Override
    public void guardar(Inscripciones inscripcion) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT into Inscripciones Values(?,?,?,?,?,?,?,?)");
            preparedStatement.setLong(1,inscripcion.getCodCurso());
            preparedStatement.setString(2,inscripcion.getNombreCurso());
            preparedStatement.setInt(3,inscripcion.getPrecioCurso());
            preparedStatement.setInt(4,inscripcion.getCupoCurso());
            preparedStatement.setString(5,inscripcion.getNombreProfesor());
            preparedStatement.setString(6,inscripcion.getNombreAlumno());
            preparedStatement.setString(7,inscripcion.getApellidoAlumno());
            preparedStatement.setInt(4,inscripcion.getNotaFinalAlumno());

            int res = preparedStatement.executeUpdate();

            System.out.println("Registros insertados: " + res);

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }
    public void modificar(Inscripciones inscripcion) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE inscripciones SET NOTAALUMNO=? WHERE CODCURSO=?");

            preparedStatement.setInt(1, inscripcion.getNotaFinalAlumno());
            preparedStatement.setLong(2, inscripcion.getCodCurso());

            int res = preparedStatement.executeUpdate();
            System.out.println("Registros modificados: " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    public void eliminar(long id) throws DAOException {
    }

    public Inscripciones buscar(long id) throws DAOException {
        return null;
    }
}
