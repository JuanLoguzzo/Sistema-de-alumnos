package DAO;

import Entidades.Alumno;
import Entidades.Profesor;
import java.sql.*;

public class ProfesorDAO implements DAO<Profesor>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:\\Users\\juanl\\IdeaProjects\\Turnera media";
    private String DB_USER ="sa";
    private String DB_PASSWORD = "";

    @Override
    public void guardar(Profesor profesor) throws DAOException{

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO Profesores VALUES(?,?,?,?,?)");
            preparedStatement.setLong(1,profesor.getId());
            preparedStatement.setString(2,profesor.getNombreUsuario());
            preparedStatement.setString(3,profesor.getContraseña());
            preparedStatement.setString(4,profesor.getNombre());
            preparedStatement.setString(5,profesor.getApellido());


            int res = preparedStatement.executeUpdate();


            System.out.println("Registros insertados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Profesor profesor) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE Profesores NOMBREUSUARIO=?, CONTRASEÑA=?, NOMBRE=?, APELLIDO=? WHERE ID=?");

            preparedStatement.setString(1, profesor.getNombreUsuario());
            preparedStatement.setString(2,profesor.getContraseña());
            preparedStatement.setString(3,profesor.getNombre());
            preparedStatement.setString(4,profesor.getApellido());
            preparedStatement.setLong(5,profesor.getId());


            int res = preparedStatement.executeUpdate();


            System.out.println("Registros modificados: " + res);


        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void eliminar(long id) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM Profesores WHERE ID=?");
            preparedStatement.setLong(1,id);


            int res = preparedStatement.executeUpdate();

            System.out.println("Registros eliminados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

    }

    @Override
    public Profesor buscar(long id) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Profesor profesor = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Profesores WHERE id=?");
            preparedStatement.setLong(1,id);


            ResultSet res = preparedStatement.executeQuery();


            while(res.next())
            {
                profesor = new Profesor();
                profesor.setId( res.getLong("ID") );
                profesor.setContraseña( res.getString("CONTRASEÑA") );
                profesor.setNombreUsuario(res.getString("NOMBREUSUARIO"));
                profesor.setNombre(res.getString("NOMBRE"));
                profesor.setApellido(res.getString("APELLIDO"));

            }

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

        return profesor;
    }
}
