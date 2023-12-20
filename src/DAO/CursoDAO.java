package DAO;

import Entidades.Alumno;
import Entidades.Curso;

import java.sql.*;
import java.util.ArrayList;

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

            preparedStatement = connection.prepareStatement("INSERT into cursos Values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,curso.getCodCurso());
            preparedStatement.setString(2,curso.getNombreCurso());
            preparedStatement.setString(3,curso.getNombreProfesor());
            preparedStatement.setString(4, curso.getCorreoProfesor());
            preparedStatement.setInt(5,curso.getCupoCurso());
            preparedStatement.setInt(6,curso.getPrecioCurso());

            int res = preparedStatement.executeUpdate();


            System.out.println("Registros insertados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Curso elemento) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(this.DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE cursos SET cupoCurso = cupoCurso - 1 WHERE codCurso=?");
            preparedStatement.setLong(1, elemento.getCodCurso());
            int res = preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        } catch (SQLException | ClassNotFoundException var5) {
            throw new DAOException(var5.getMessage());
        }
    }

    public void modificar2(Curso elemento) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(this.DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE cursos SET cupoCurso = cupoCurso + 1 WHERE codCurso=?");
            preparedStatement.setLong(1, elemento.getCodCurso());
            int res = preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        } catch (SQLException | ClassNotFoundException var5) {
            throw new DAOException(var5.getMessage());
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
                curso.setCodCurso( res.getInt("CODCURSO") );
                curso.setNombreCurso( res.getString("NOMBRECURSO") );
                curso.setNombreProfesor(res.getString("NOMBREPROFESOR"));
                curso.setCorreoProfesor(res.getString("CORREOPROFESOR"));
                curso.setCupoCurso(res.getInt("CUPOCURSO"));
                curso.setPrecioCurso(res.getInt("PRECIOCURSO"));
            }

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

        return curso;
    }
    public ArrayList<Curso> buscarTodos() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Curso> cursos = new ArrayList();

        try {
            Class.forName(this.DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM CURSOS");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Curso curso = new Curso();
                curso.setCodCurso(resultSet.getInt("codCurso"));
                curso.setNombreCurso(resultSet.getString("nombreCurso"));
                curso.setNombreProfesor(resultSet.getString("nombreProfesor"));
                curso.setCupoCurso(resultSet.getInt("cupoCurso"));
                curso.setPrecioCurso(resultSet.getInt("precioCurso"));
                cursos.add(curso);
            }

            return cursos;
        } catch (SQLException | ClassNotFoundException var6) {
            throw new DAOException(var6.getMessage());
        }
    }
}
