package DAO;

import Entidades.Alumno;

import java.sql.*;

public class AlumnoDAO implements DAO<Alumno>{

    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:C:\\Users\\juanl\\IdeaProjects\\Turnera media";
    private String DB_USER ="sa";
    private String DB_PASSWORD = "";

    @Override
    public void guardar(Alumno alumno) throws DAOException{

        Connection connection = null;
        // es un objeto que se utiliza para poder ejecutar un query multiples veces con distintos parametros
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT into alumnos Values(?,?,?,?,?)");
            preparedStatement.setLong(1,alumno.getId());
            preparedStatement.setString(2,alumno.getCorreo());
            preparedStatement.setString(3,alumno.getContraseña());
            preparedStatement.setString(4,alumno.getNombre());
            preparedStatement.setString(5,alumno.getApellido());


            int res = preparedStatement.executeUpdate();


            System.out.println("Registros insertados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Alumno alumno) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE alumnos SET NOMBREUSUARIO=?, CONTRASEÑA=?, NOMBRE=?, APELLIDO=? WHERE ID=?");

            preparedStatement.setString(1, alumno.getCorreo());
            preparedStatement.setString(2,alumno.getContraseña());
            preparedStatement.setString(3,alumno.getNombre());
            preparedStatement.setString(4,alumno.getApellido());
            preparedStatement.setLong(5,alumno.getId());
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
            preparedStatement = connection.prepareStatement("DELETE FROM alumnos WHERE ID=?");
            preparedStatement.setLong(1,id);


            int res = preparedStatement.executeUpdate();

            System.out.println("Registros eliminados: " + res);


        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

    }

    @Override
    public Alumno buscar(long id) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Alumno alumno = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM alumnos WHERE id=?");
            preparedStatement.setLong(1,id);

            ResultSet res = preparedStatement.executeQuery();

            while(res.next())
            {
                alumno = new Alumno();
                alumno.setId( res.getLong("ID") );
                alumno.setContraseña( res.getString("CONTRASEÑA") );
                alumno.setCorreo(res.getString("NOMBREUSUARIO"));
                alumno.setNombre(res.getString("NOMBRE"));
                alumno.setApellido(res.getString("APELLIDO"));
            }

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

        return alumno;
    }
    public  Alumno buscar2(String correo) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Alumno alumno = null;

        try {
            Class.forName(this.DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM ALUMNOS  WHERE NOMBREUSUARIO=?");
            preparedStatement.setString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                alumno = new Alumno();
                alumno.setCorreo(correo);
                alumno.setContraseña(resultSet.getString("CONTRASEÑA"));

            }

            return alumno;
        } catch (SQLException | ClassNotFoundException var6) {
            throw new DAOException(var6.getMessage());
        }
    }
    public Alumno buscar3(String correo) throws DAOException{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Alumno alumno = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM alumnos WHERE NOMBREUSUARIO=?");
            preparedStatement.setString(1,correo);

            ResultSet res = preparedStatement.executeQuery();

            while(res.next())
            {
                alumno = new Alumno();
                alumno.setId( res.getLong("ID") );
                alumno.setContraseña( res.getString("CONTRASEÑA") );
                alumno.setCorreo(res.getString("NOMBREUSUARIO"));
                alumno.setNombre(res.getString("NOMBRE"));
                alumno.setApellido(res.getString("APELLIDO"));
            }

        } catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }

        return alumno;
    }
}

