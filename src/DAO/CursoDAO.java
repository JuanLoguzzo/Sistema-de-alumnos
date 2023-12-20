package DAO;

import Entidades.Alumno;
import Entidades.Curso;

import java.sql.*;

public class CursoDAO implements DAO<Curso>{

    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:\\Users\\juanl\\IdeaProjects\\Turnera media";
    private String DB_USER ="sa";
    private String DB_PASSWORD = "";

    @Override
    public void guardar(Curso curso) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT into cursos Values(?,?,?,?,?)");
            preparedStatement.setLong(1,curso.getCodCurso());
            preparedStatement.setString(2,curso.getNombreCurso());
            preparedStatement.setString(3,curso.getNombreProfesor());
            preparedStatement.setInt(4,curso.getCupoCurso());
            preparedStatement.setInt(5,curso.getPrecioCurso());

            int res = preparedStatement.executeUpdate();


            System.out.println("Registros insertados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Curso curso) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE cursos NOMBRECURSO=?, NOMBREPROFESOR=?, CUPOCURSO=?, PRECIOCURSO=? WHERE CODCURSO=?");

            preparedStatement.setString(1, curso.getNombreCurso());
            preparedStatement.setString(2,curso.getNombreProfesor());
            preparedStatement.setInt(3,curso.getCupoCurso());
            preparedStatement.setInt(4,curso.getPrecioCurso());
            preparedStatement.setLong(5,curso.getCodCurso());



            int res = preparedStatement.executeUpdate();


            System.out.println("Registros modificados: " + res);


        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void eliminar(long codCurso) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM cursos WHERE CODCURSO=?");
            preparedStatement.setLong(1,codCurso);


            int res = preparedStatement.executeUpdate();

            System.out.println("Registros eliminados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

    }

    @Override
    public Curso buscar(long codCurso) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Curso curso = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Cursos WHERE codCurso=?");
            preparedStatement.setLong(1,codCurso);

            ResultSet res = preparedStatement.executeQuery();

            while(res.next())
            {
                curso = new Curso();
                curso.setCodCurso( res.getLong("CODCURSO") );
                curso.setNombreCurso( res.getString("NOMBRECURSO") );
                curso.setNombreProfesor(res.getString("NOMBREPROFESOR"));
                curso.setCupoCurso(res.getInt("CUPOCURSO"));
                curso.setPrecioCurso(res.getInt("PRECIOCURSO"));
            }

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

        return curso;
    }
}
